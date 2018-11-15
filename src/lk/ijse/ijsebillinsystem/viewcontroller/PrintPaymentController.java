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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import lk.ijse.ijsebillinsystem.AutoGenarateID.IDGenetator;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PrintPaymentController implements Initializable {
    public static String date;
    public static String studentName;
    public static String studentNIC;
    public static String courseName;
    public static String fullAmount;
    public static String payAmount;
    public static String balance;
     private String autoGenerateId;
    
    

    
    @FXML
    private Label lable;
    @FXML
    private Label lableDate;
    @FXML
    private Label lableStudentName;
    @FXML
    private Label lable1;
    @FXML
    private Label lable11;
    @FXML
    private Label lableStudentNIC;
    @FXML
    private Label lable12;
    @FXML
    private Label lableCourseName;
    @FXML
    private Label lable111;
    @FXML
    private Label lableFullAmount;
    @FXML
    private Label lable1111;
    @FXML
    private Label lablePayAmount;
    @FXML
    private Label lable1112;
    @FXML
    private Label lableBalance;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setDate();
        setId();
        //testId.setVisible(false);
        // TODO
    }    

    private void setDate() {
        lableDate.setText(date);
        lableStudentName.setText(studentName);
        lableStudentNIC.setText(studentNIC);
        lableCourseName.setText(courseName);
        lableFullAmount.setText(fullAmount);
        lablePayAmount.setText(payAmount);
        lableBalance.setText(balance);
    }

    private void setId() {
        try {
             String newId = IDGenetator.getNewId("batch", "BATCH_ID", "B", 2);
            autoGenerateId=newId;
            System.out.println("jfdasfjsdajfksdajflkdsafjldsajflsdjflsajdf"+autoGenerateId);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrintPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PrintPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
