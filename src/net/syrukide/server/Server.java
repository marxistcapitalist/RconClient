package net.syrukide.server;

import net.syrukide.rcon.RconConnector;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Ethan on 9/23/2016.
 */
public class Server {

    private String name;
    private InetAddress host;
    private int port;
    private String password;
    private RconConnector rcon;

    public Server(String name, InetAddress host, int port, String password) throws UnknownHostException {
        this.name = name;
        this.host = host;
        this.port = port;
        this.password = password;
        this.rcon = new RconConnector(host, port, password);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void connect() {
        try {
            this.rcon.connect();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void checkIfReachable() {
        try {
            boolean d = this.host.isReachable(20);
            System.out.println("Reachable: " + d);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
