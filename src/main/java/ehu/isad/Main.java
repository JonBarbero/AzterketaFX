package ehu.isad;

import ehu.isad.controller.ui.MainUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

        private Scene sceneMain;
        private Stage stage;
        private Parent MainUI;
        private ehu.isad.controller.ui.MainUI mainkud;

        @Override
        public void start (Stage primaryStage) throws Exception {
            stage = primaryStage;
            pantailakKargatu();

            stage.setTitle("AzterketaFX");
            stage.setScene(sceneMain);
            stage.show();
        }

        //ESZENA GUZTIAK
        public void hasieraErakutsi(){
        stage.setScene(sceneMain);
        stage.show();

    }

        //PANTAILA KARGATZEKO
        private void pantailakKargatu () throws IOException {

            FXMLLoader loaderHasiera = new FXMLLoader(getClass().getResource("/Scene.fxml"));
            MainUI = (Parent) loaderHasiera.load();
            mainkud = loaderHasiera.getController();
            mainkud.setMainApp(this);
            sceneMain = new Scene(MainUI);

        }
    public MainUI getMainUI(){
        return this.mainkud;
    }
    public static void main(String[] args) {
        launch(args);
    }

    }
