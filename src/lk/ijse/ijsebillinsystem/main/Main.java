/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.main;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author user
 */
public class Main extends Application{
    
    private double x0ffset=0;
    private double y0ffset=0;

    @Override
    public void start(Stage primaryStage) throws Exception {
    
      Parent root=FXMLLoader.load(this.getClass().getResource("/lk/ijse/ijsebillinsystem/view/Login.fxml"));
      primaryStage.initStyle(StageStyle.TRANSPARENT );
        
       root.setOnMousePressed(new EventHandler<javafx.scene.input.MouseEvent>(){
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                x0ffset=event.getSceneX();
                y0ffset=event.getSceneY();
            }
           
           
       });
       
       root.setOnMouseDragged(new EventHandler<javafx.scene.input.MouseEvent>(){
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
               primaryStage.setX(event.getScreenX()-x0ffset);
               primaryStage.setY(event.getScreenY()-y0ffset);
            }
           
           
       });
        
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
        Platform.runLater(new Runnable() {
        @Override public void run() {
            
//put your code here
}});
    }
    
    
    
}
