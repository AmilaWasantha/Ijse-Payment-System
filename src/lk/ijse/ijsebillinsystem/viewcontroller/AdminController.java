/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.viewcontroller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
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
public class AdminController implements Initializable {
    private UserController userController;

    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private JFXButton btnSaveUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userController=(UserController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.USER);
        // TODO
    }    

    @FXML
    private void buttonSaveAction(ActionEvent event) {
        saveUser();
    }

    private void saveUser() {
        try {
            String userName=txtUserName.getText();
            String password=txtPassword.getText();
            
            UserDTO userDTO=new UserDTO();
            userDTO.setUserName(userName);
            userDTO.setPassword(password);
            
            boolean isSave=userController.save(userDTO);
            if(isSave){
                Notifications notifications= Notifications.create()
                        .title("Save Successfully")
                        .text("User Save successfully ")
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
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
