package net.syrukide.server;

import net.syrukide.Main;

import java.net.InetAddress;
import java.util.ArrayList;

/**
 * Created by Ethan on 9/23/2016.
 */
public class ServerManager {

    private ArrayList<Server> servers;

    private Main main;

    public ServerManager(Main m) {
        this.main = m;
        this.servers = new ArrayList<>();
    }

    /**
     * Create demo servers for testing before saved server list are implemented
     * (This method will be removed in a future version)
     */
    public void createDemoServers() {
        if(servers.size() > 0) {
            System.out.println("Demo servers already added!");
            return;
        }
        try {
            servers.add(new Server("uninspired-jail", InetAddress.getByName("98.192.43.173"), 27015, "password"));
            servers.add(new Server("uninspired-surf", InetAddress.getByName("98.192.43.173"), 27018, "password"));
        } catch(Exception e) {
            e.printStackTrace();
        }
        for(Server s : servers) {
            System.out.println(s.toString());
        }
    }

    public void connect() {
        for(Server s : servers) {
            s.checkIfReachable();
            s.connect();
        }
    }


}
