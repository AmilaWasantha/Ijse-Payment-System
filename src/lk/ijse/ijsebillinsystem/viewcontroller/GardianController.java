/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.viewcontroller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import lk.ijse.ijsebillinsystem.AutoGenarateID.IDGenetator;

/**
 * FXML Controller class
 *
 * @author user
 */
public class GardianController implements Initializable {
    String genaratedId;
    StudentManageController studentManageController;

    @FXML
    private JFXTextField txtDesignation;
    @FXML
    private Button btnSaveGardian;
    @FXML
    private JFXTextField txtNameOfGardian;
    @FXML
    private JFXTextField txtMobile1;
    @FXML
    private JFXTextField txtMobile2;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtWorkingPlace;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private AnchorPane anchorPaneGardian;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setId();
        // TODO
    }    

    @FXML
    private void SaveGardianAction(ActionEvent event) {
        
            studentManageController.gardianDTO.setGardianId(genaratedId);
            studentManageController.gardianDTO.setName(txtNameOfGardian.getText());
            studentManageController.gardianDTO.setMobile_1(txtMobile1.getText());
            studentManageController.gardianDTO.setMobile_2(txtMobile2.getText());
            studentManageController.gardianDTO.setEmail(txtEmail.getText());
            studentManageController.gardianDTO.setDesignation(txtDesignation.getText());
            studentManageController.gardianDTO.setWorkingPlace(txtWorkingPlace.getText());
            studentManageController.gardianDTO.setAddress(txtAddress.getText());
            studentManageController.testGadianDetals();
            
       
        
    }

    private void setId() {
        try {
            String newId = IDGenetator.getNewId("gardian", "GARDIAN_ID", "G", 2);
            genaratedId=newId;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GardianController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GardianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
