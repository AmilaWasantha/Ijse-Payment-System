/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.viewcontroller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.ijsebillinsystem.controller.ControllerFactory;
import lk.ijse.ijsebillinsystem.controller.custom.UserController;
import lk.ijse.ijsebillinsystem.dto.UserDTO;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author user
 */
public class LoginController implements Initializable {
    private UserController userController;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXPasswordField txtPasswordField;
    @FXML
    private JFXButton btnSignIn;
    @FXML
    private JFXButton btnLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userController=(UserController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.USER);
        // TODO
    }

    @FXML
    void btn_LoginAction(ActionEvent event) {
        loginNow();
        
            ((Stage) (((JFXButton) event.getSource()).getScene().getWindow())).hide();
    }

    
    
    
     private void LoadStages(String fxml){
        
        try {
            Parent root=FXMLLoader.load(getClass().getResource(fxml));
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void loginNow() {
        try {
            String name=txtUserName.getText();
            String password=txtPasswordField.getText();
            
            UserDTO userDTO=new UserDTO();
            userDTO.setUserName(name);
            userDTO.setPassword(password);
            
            boolean isLogin=userController.UserLogint(userDTO);
            if(isLogin){
                
            LoadStages("/lk/ijse/ijsebillinsystem/view/Home.fxml");
        
            }else{
                Notifications notifications= Notifications.create()
                          .title("Somthing wrong")
                          .text("UserName Or Password Incorrect")
                          .graphic(new ImageView())
                          .hideAfter(Duration.seconds(5))
                          .position(Pos.CENTER)
                          .onAction(new EventHandler<ActionEvent>() {
                              @Override
                              public void handle(ActionEvent event) {
                                  System.out.println("notification clicked");
                                  
                              }
                          });
                  
                  notifications.darkStyle();
                  notifications.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


   
    
}
