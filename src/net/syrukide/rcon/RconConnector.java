package net.syrukide.rcon;

import net.syrukide.rcon.ex.AuthenticationException;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Random;

/**
 * Created by Ethan on 9/21/2016.
 */
public class RconConnector implements Runnable {

    private InetAddress server;
    private int port;
    private String password;
    private int requestId;
    private Socket socket;
    private Charset charset;

    private final Object sync = new Object();
    private final Random rand = new Random();

    /**
     * Create a RconConnector
     * @param address Host server to connect to
     * @param port Port to use on the host server
     * @param pass RCON password of the host server
     * @throws UnknownHostException
     */
    public RconConnector(InetAddress address, int port, String pass) throws UnknownHostException, IllegalArgumentException {
        this.server = address;
        if(port < 1 || port > 65535)
            throw new IllegalArgumentException("Port out of range");
        this.port = port;
        this.password = pass;
        this.charset = Charset.forName("UTF-8");
    }

    /**
     * Connect to the server
     */
    public void connect() throws IOException, AuthenticationException{
        synchronized(sync) {
            this.requestId = rand.nextInt();
            System.out.println(this.server + " | " + this.port);
            this.socket = new Socket(this.server, this.port);
        }

        RconPacket auth = this.send(RconPacket.SERVERDATA_AUTH, this.password.getBytes(this.charset));
        System.out.println("Response ID: " + auth.getRequestId());
        if(auth.getRequestId() == -1) {
            throw new AuthenticationException("Password rejected by server");
        }
    }

    public RconPacket send(int type, byte[] payload) throws IOException {
        synchronized(sync) {
            return RconPacket.send(this, type, payload);
        }
    }

    @Override
    public void run() {
        try {
            this.connect();
        } catch(Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public int getRequestId() {
        return requestId;
    }

    public Socket getSocket() {
        return socket;
    }

    public Charset getCharset() {
        return charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

}
