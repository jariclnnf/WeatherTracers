package generalPage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GeneralApp extends Application{

    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("generalPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Weather Tracers");
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
