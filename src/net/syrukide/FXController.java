package net.syrukide;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;

public class FXController {

    private Main main;

    @FXML protected void handleExportLog(ActionEvent event) {
        System.out.println("This feature is not implemented yet.");
    }

    @FXML protected void handleOpenServerManager(ActionEvent event) {
        System.out.println("This feature is not implemented yet.");
    }

    @FXML protected void handleOpenSettings(ActionEvent event) {
        System.out.println("This feature is not implemented yet.");
    }

    @FXML protected void handleExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML protected void handleAbout(ActionEvent event) {
        System.out.println("This feature is not implemented yet.");
    }

    @FXML protected void stopConsoleInput(KeyEvent event) {
        event.consume();
    }

    @FXML protected void handleConsoleInput(ActionEvent event) {
        System.out.println("This feature is not implemented yet.");
    }

    @FXML protected void handleServerStart(ActionEvent event) {
        main.getServerManager().connect();
        System.out.println("Attempted to connect.");
    }

    @FXML protected void handleServerStop(ActionEvent event) {
        System.out.println("This feature is not implemented yet.");
    }

    @FXML protected void handleServerEdit(ActionEvent event) {
        System.out.println("This feature is not implemented yet.");
    }

    @FXML protected void handleServerDelete(ActionEvent event) {
        System.out.println("This feature is not implemented yet.");
    }

    @FXML protected void handleServerAdd(ActionEvent event) {
        System.out.println("This feature is not implemented yet.");
    }

    @FXML protected void handleServerDemo(ActionEvent event) {
        main.getServerManager().createDemoServers();
        System.out.println("Demo servers added successfully!");
    }

    public void passMain(Main m) {
        this.main = m;
    }

}
