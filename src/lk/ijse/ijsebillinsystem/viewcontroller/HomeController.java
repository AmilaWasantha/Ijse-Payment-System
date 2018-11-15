/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.viewcontroller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class HomeController implements Initializable {
    
   

    @FXML
    private JFXButton btn_Dashboard;
    @FXML
    private JFXButton btn_ManagePayment;
    @FXML
    private JFXButton btn_ManageCourse;
    @FXML
    private JFXButton btn_ManageStudent;
    @FXML
    private JFXButton btn_ManageTransferStudent;
    @FXML
    private JFXButton btnManageBatch;
    
    @FXML
    private AnchorPane MainPanal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void button_DashboarAction(ActionEvent event) {
         LoadStages("/lk/ijse/ijsebillinsystem/view/Dashboard.fxml");
        
    }
    
    

    @FXML
    private void button_ManagePaymentAction(ActionEvent event) {
        LoadStages("/lk/ijse/ijsebillinsystem/view/ManagePayment.fxml");
    }

    @FXML
    private void button_ManageCourseAction(ActionEvent event) {
        LoadStages("/lk/ijse/ijsebillinsystem/view/ManageCourse.fxml");
    }

    @FXML
    private void button_ManageStrudentAction(ActionEvent event) {
        LoadStages("/lk/ijse/ijsebillinsystem/view/StudentManage.fxml");
    }

    @FXML
    private void buttton_ManageTransferAction(ActionEvent event) {
        LoadStages("/lk/ijse/ijsebillinsystem/view/ManageTransferBatch.fxml");
    }

    @FXML
    private void buttonManageBatchAction(ActionEvent event) {
        LoadStages("/lk/ijse/ijsebillinsystem/view/ManageBatch.fxml");
    }
    
    private void LoadStages(String fxml){
        try {
            Parent root=FXMLLoader.load(getClass().getResource(fxml));
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            //stage.show();
            
            BoxBlur boxBlur=new BoxBlur();
            boxBlur.setIterations(2);
            MainPanal.setEffect(boxBlur);
            stage.showAndWait();
            
            boxBlur.setIterations(0);
            MainPanal.setEffect(boxBlur);
            
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
