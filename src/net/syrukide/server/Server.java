package net.syrukide.server;

import net.syrukide.rcon.ServerConnector;

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
    private ServerConnector rcon;

    public Server(String name, InetAddress host, int port, String password) throws UnknownHostException {
        this.name = name;
        this.host = host;
        this.port = port;
        this.password = password;
        this.rcon = new ServerConnector(host, port, password);
    }

    @Override
    public String toString() {
        return this.name;
    }

}
