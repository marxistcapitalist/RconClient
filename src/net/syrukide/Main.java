package net.syrukide;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.syrukide.server.ServerManager;

public class Main extends Application {

    protected FXController fxController;
    protected ServerManager serverManager;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        fxmlLoader.load();
        Parent root = fxmlLoader.getRoot();
        primaryStage.setTitle("Rcon Server Manager");
        primaryStage.setScene(new Scene(root, 800, 600));
        this.fxController = fxmlLoader.getController();
        fxController.passMain(this);
        primaryStage.show();
        this.serverManager = new ServerManager(this);
    }

    public ServerManager getServerManager() {
        return this.serverManager;
    }


    public static void main(String[] args) {
        launch(args);
    }


}
