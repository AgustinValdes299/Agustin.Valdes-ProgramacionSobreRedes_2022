package ChatFinal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Agustin Valdes, Abdia
 */
public class MainServidor {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_MAGENTA = "\u0033[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    static String clave = "FooBar1234567890"; // 128 bit
    static ArrayList<Cliente> ClientesConectados = new ArrayList<Cliente>();

    public static void main(String[] args) {

        try {

            LogFile log = new LogFile("", "logFile.log");

            System.setErr(
                    new PrintStream(
                            new FileOutputStream(
                                    new File("logFile.log"), true), true)
            );

            System.out.println("INICIANDO SERVIDOR");
            log.setMsg("El servidor se ha iniciado servidor Iniciado correctamente");
            log.run();

            Servidor inicio = new Servidor();
            inicio.setName("SERVIDOR");

            inicio.start();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PrintStream ps = new PrintStream(System.out);
    }
} // fin class principal


//==============================================================================
/**
 * Hilo de manejo de cliente en el servidor 
 * @author agusv
 */
class Cliente implements Runnable {
    String nickName = "";
    Socket sock;
    Thread hilo;
    EstadoConec disconectUser = null;
    Registro registro = null;
    
    final DataInputStream disCliente;
    final DataOutputStream dosCliente;
    boolean isConected;

    /**
     * 
     * @param sock
     * @param nick
     * @param in
     * @param out 
     */
    public Cliente(Socket sock, String nick, DataInputStream in, DataOutputStream out) {
        this.nickName = nick;
        this.sock = sock;
        this.disCliente = in;
        this.dosCliente = out;
        this.isConected = true;
        this.disconectUser = new EstadoConec(nickName);
        this.hilo = new Thread(this, nickName);
    }

    @Override
    public void run() {
        String msgRecibido = "";
        String msg = "";
        String cli = "";

        while (sock.isConnected() && this.isConected) {
            
            try {
                msgRecibido = disCliente.readUTF();
                //    mensaje#cliente
                if (msgRecibido.contains("#")) {
                    StringTokenizer token = new StringTokenizer(msgRecibido, "#");
                    msg = token.nextToken().trim();
                    cli = token.nextToken().trim().toLowerCase();
                } else {
                    msg = msgRecibido.trim();
                    cli = "";
                }   
                
                registro = new Registro(nickName, (cli.equals("") ? "TODOS" : cli.toUpperCase()), msg);
                registro.run();                
                System.out.println("\n"
                        + MainServidor.ANSI_PURPLE
                        + "El cliente " + this.nickName
                        + " envia:"
                        + msg + "\n\t"
                        + " al cliente =>"
                        + MainServidor.ANSI_CYAN
                        + (cli.equals("") ? " TODOS" : cli.toUpperCase())
                        + "\n"
                        + MainServidor.ANSI_RESET
                );
                
                Servidor.log.setMsg("El cliente " + this.nickName
                        + " envia: "
                        + msg
                        + " al cliente =>"
                        + (cli.equals("") ? " TODOS" : cli.toUpperCase()));
                Servidor.log.run();
                

                //comandos
                if (msg.startsWith("/")) {
                    switch (msg.substring(1, msg.length()).toLowerCase().trim()) {
                        case "salir":
                            this.disCliente.close();
                            this.dosCliente.close();
                            this.isConected = false;
                            this.sock.close();
                            this.disconectUser.run();

                            MainServidor.ClientesConectados.remove(this);
                            System.err.println(MainServidor.ANSI_RED
                                    + "\tCliente "
                                    + this.nickName
                                    + " se ah desconectado.\n"
                                    + MainServidor.ANSI_RESET
                            );
                            this.ingresoCliente(false);
                            break;
                    }
                }

                for (Cliente c : MainServidor.ClientesConectados) {
                    // si exite el cliente en la lista  Y  si esta online
                    //mesnaje#""
                    if (msg.equals("")) {
                        break;
                    }

                    if (c.nickName.toLowerCase().equals(cli.toLowerCase()) && this.isConected) {
                        c.dosCliente.writeUTF(
                                this.nickName
                                + ":"
                                + msg
                        );
                        break;
                    } else if (cli.equals("") && this.isConected && !c.nickName.toLowerCase().equals(this.nickName.toLowerCase())) {
                        c.dosCliente.writeUTF(this.nickName
                                + ":"
                                + msg
                        );
                    }
                }//fin for
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//fin while
    }// fin run

    void ingresoCliente(boolean b) {
        for (Cliente cliente : MainServidor.ClientesConectados) {
            if (!cliente.nickName.equals(this.nickName) && cliente.isConected) {
                try {
                    if (b) {
                        cliente.dosCliente.writeUTF(MainServidor.ANSI_GREEN
                                + "\t---"
                                + this.nickName
                                + " se ha unido al chat---"
                                + MainServidor.ANSI_RESET
                        );
                        Servidor.log.setMsg("\t---"
                                + this.nickName
                                + " se ha unido al chat---");
                        Servidor.log.run();
                    } else {
                        cliente.dosCliente.writeUTF(MainServidor.ANSI_RED
                                + "\t---"
                                + this.nickName
                                + " se ha desconectado---"
                                + MainServidor.ANSI_RESET
                        );
                        Servidor.log.setMsg("\t---"
                                + this.nickName
                                + " se ha desconectado---");
                        Servidor.log.run();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                }
            }
        }
    }
}


//==============================================================================

/**
 * aca esta el servidor donde se conectan los clientes
 * espera una conexion y luego de que se hace correctamtnte 
 * conecta con otro cliente que este en el mismo servidor 
 * de esta forma pueden establecer comunicacion entre si 
 * 
 * informa la cantidad de clientes conectados 
 * 
 * se ejecuta en forma de hilo
 * 
 * @author abdia
 */
class Servidor extends Thread {
    ServerSocket server;
    int PUERTO = 7777;
    Socket sockAux;
    PrintStream ps;

    DataInputStream disCliente;
    DataOutputStream dosCliente;
    static LogFile log = new LogFile("", "LogFile.log");

    public Servidor() {
        try {
            ps = new PrintStream(System.out);
            disCliente = null;
            dosCliente = null;
            
            server = new ServerSocket(PUERTO);

            Thread verificarLista = new Thread(
                    new Runnable() {
                @Override
                public void run() {

                    for (Cliente cli : MainServidor.ClientesConectados) {
                        if (!cli.sock.isConnected() || !cli.isConected) {
                            MainServidor.ClientesConectados.remove(cli);
                            cli.ingresoCliente(false);
                        }
                    }
                }
            }
            );

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                ps.println("Esperando conexion de un cliente...\n");
                sockAux = server.accept();

                ps.println(MainServidor.ANSI_BLUE
                        + "Cliente conectado: "
                        + sockAux.getInetAddress().getHostAddress()
                        + MainServidor.ANSI_RESET
                );
                
                log.setMsg("Se ha conectado el cliente " + sockAux.getInetAddress().getHostAddress());
                log.run();
                
                DataInputStream disCliente = new DataInputStream(sockAux.getInputStream());
                DataOutputStream dosCliente = new DataOutputStream(sockAux.getOutputStream());

                System.out.println(MainServidor.ANSI_BLUE
                        + "Creando un cliente... Esperando NickName"
                        + MainServidor.ANSI_RESET
                );
                String nickname = disCliente.readUTF();

                Cliente cli = new Cliente(sockAux, nickname, disCliente, dosCliente);
                UsuarioConecBD user = new UsuarioConecBD(nickname.toUpperCase());

                System.out.println(MainServidor.ANSI_RED
                        + "El cliente "
                        + cli.nickName
                        + " se a conectado al servidor.\n"
                        + MainServidor.ANSI_RESET
                );
                log.setMsg(sockAux.getInetAddress().getHostAddress() + " se ha unido al chat con el nickname '" + cli.nickName + "'");
                log.run();
                MainServidor.ClientesConectados.add(cli);

                cli.hilo.start();
                user.run();
                cli.ingresoCliente(true);

            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}


//==============================================================================
/**
 * se crea la conexion al usuario a la bdd donde se va a almacenar el nombre de usuario 
 * y donde se va a poder hacer la actualizacion del perfil de usuario
 * 
 * corre en forma de hilo
 * 
 * @author abdia
 */
class UsuarioConecBD implements Runnable {

    private String nickname;

    /**
     * 
     * @param nickname 
     */
    public UsuarioConecBD(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public void run() {
        Connection con = null;

        try {
            con = ConexionesFactory.getInstance().getConection();
            PreparedStatement UsuarioConecBD = null;
            ResultSet userRow = null;
            UsuarioConecBD = con.prepareStatement("SELECT * FROM `users` WHERE `nickname` = ?");
            UsuarioConecBD.setString(1, nickname);
            userRow = UsuarioConecBD.executeQuery();
            
            if (!userRow.next()) {
                PreparedStatement insertUser = null;
                insertUser = con.prepareStatement("INSERT INTO `users` (`nickname`) VALUES (?)");
                insertUser.setString(1, nickname);
                if (insertUser.executeUpdate() == 1) {
                    System.out.println(
                            MainServidor.ANSI_GREEN
                            + "Usuario '" + nickname + "' Agregado correctamente!"
                    );
                } else {
                    System.out.println(
                            MainServidor.ANSI_RED
                            + "Usuario '" + nickname + "' No ha sido agregado"
                    );
                }
            } else {
                PreparedStatement updateState = null;
                updateState = con.prepareStatement("UPDATE `users` SET `conectado` =  1 WHERE `nickname` = ?");
                updateState.setString(1, nickname);

                if (updateState.executeUpdate() == 1) {
                    System.out.println(
                            MainServidor.ANSI_GREEN
                            + "Usuario '" + nickname + "' Actualizado exitosamente!"
                    );
                } else {
                    System.out.println(
                            MainServidor.ANSI_RED
                            + "Usuario '" + nickname + "' No ha pudido actualizarse"
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioConecBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


//==============================================================================
/**
 * se muestran los usuarios conectados
 * 
 * es un hilo 
 * 
 * @author abdia
 */
class EstadoConec implements Runnable {
    private String nickname;
    public EstadoConec(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public void run() {
        Connection con = null;
        try {
            con = ConexionesFactory.getInstance().getConection();
            PreparedStatement updateState = null;
            updateState = con.prepareStatement("UPDATE `users` SET `conectado` =  0 WHERE `nickname` = ?");
            updateState.setString(1, nickname);

            if (updateState.executeUpdate() == 1) {
                System.out.println(
                        MainServidor.ANSI_GREEN
                        + "Usuario '" + nickname + "' se desconcecto exitosamente!"
                );
            } else {
                System.out.println(
                        MainServidor.ANSI_RED
                        + "Ha ocurrido un error y el Usuario '" + nickname + "no pudo desconectarse correctamente"
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstadoConec.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


//==============================================================================
/**
 * se realiza el registro de mensajes del usuario en una bdd
 * 
 * @author abdia
 */
class Registro implements Runnable {
    private String nickname;
    private String receptor;
    private String msg;
    public Registro(String nickname, String receptor, String msg) {
        this.nickname = nickname;
        this.receptor = receptor;
        this.msg = msg;
    }

    public void run() {
        Connection con = null;

        try {
            con = ConexionesFactory.getInstance().getConection();
            PreparedStatement registro = null;
            registro = con.prepareStatement(
                    "INSERT INTO `historial`(`usuario`,`receptor`,`mensaje`)"
                        + "VALUES ("
                            + "(SELECT `id` FROM `users` WHERE `nickname` = ?),"
                            + "(SELECT `id` FROM `users` WHERE `nickname` = ?),"
                        + "?"
                    + ")"
            );

            registro.setString(1, nickname);
            registro.setString(2, receptor);
            registro.setString(3, msg);
            registro.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioConecBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


//==============================================================================
/**
 * genera el archivo .log donde se muestra el registro de lo que ocurre dentro del servidor 
 * mostrando la fecha y la hora exacta de cada accion ejecutada 
 * @author abdia
 */
class LogFile implements Runnable {
    private String msg;
    private String fileName;
    public LogFile(String msg, String fileName) {
        this.msg = msg;
        this.fileName = fileName;
    }

   
    @Override
    public void run() {
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter(new File(this.fileName), true);
            pw = new PrintWriter(fw);

            String fecha = "[" + DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()) + "]: ";

            pw.println(fecha + msg);

        } catch (IOException ex) {
            Logger.getLogger(LogFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(LogFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}


