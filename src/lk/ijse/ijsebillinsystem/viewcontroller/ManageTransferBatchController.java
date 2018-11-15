/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.viewcontroller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import lk.ijse.ijsebillinsystem.AutoGenarateID.IDGenetator;
import lk.ijse.ijsebillinsystem.controller.ControllerFactory;
import lk.ijse.ijsebillinsystem.controller.custom.BatchController;
import lk.ijse.ijsebillinsystem.controller.custom.BatchRegistrationController;
import lk.ijse.ijsebillinsystem.controller.custom.BatchTransferController;
import lk.ijse.ijsebillinsystem.controller.custom.StudentController;
import lk.ijse.ijsebillinsystem.dto.BatchDTO;
import lk.ijse.ijsebillinsystem.dto.BatchRegistrationDTO;
import lk.ijse.ijsebillinsystem.dto.BatchTransferDTO;
import lk.ijse.ijsebillinsystem.dto.PaymentDTO;
import lk.ijse.ijsebillinsystem.dto.StudentDTO;
import lk.ijse.ijsebillinsystem.querydto.CheckPaymentForTransferStudentQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.GetBatchDetailsForTransferQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.GetNotStartBatchForTranserStudentQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.GetStudentDetailsForTransferQueryDTO;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ManageTransferBatchController implements Initializable {
    private BatchTransferController batchTransferController;
    private BatchController batchController;
    private StudentController studentController;
    private BatchRegistrationController batchRegistrationController;
    private String paymentType;
    private String oldRegistrationID;
    private String paymentID;
    
    private String newRegistrationID;
    private String batchTransferID;
    private double registrationFee;
    private String activeStatus;
    private String inactiveStatus;
    @FXML
    private JFXTextField txtStudentId;
    @FXML
    private JFXTextField txtStudentName;
    @FXML
    private JFXTextField txtStudentNic;
    @FXML
    private JFXTextField txtReson;
    @FXML
    private JFXComboBox<?> comboNewBatch;
    @FXML
    private JFXTextField txtTransferFee;
    @FXML
    private TableView<?> tableTransferBatch;
    @FXML
    private JFXButton btnSaveTransfer;
    private JFXComboBox<?> comboBatchID;
    private JFXComboBox<?> comboBatchName;
    @FXML
    private JFXTextField currentDateID;
    @FXML
    private JFXButton btnCheckPayment;
    @FXML
    private JFXComboBox<?> comboCourseName;
    @FXML
    private JFXTextField txtOldBatchName;
    @FXML
    private JFXTextField txtBatchID;
    @FXML
    private JFXDatePicker paymentDatePicker;
    @FXML
    private JFXTextField newBatchID;
    
    
    void buttonSaveTransfer(ActionEvent event) {

    }

    void buttonUpdate(ActionEvent event) {

    }

    void tableTransferBatch(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        batchTransferController=(BatchTransferController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.BATCHTRANSFERCONTROLLER);
        batchController=(BatchController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.BATCHCONTROLLER);
        studentController=(StudentController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.STUDENTCONTROLLER);
        batchRegistrationController=(BatchRegistrationController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.BATCHREGISTRATIONCONTROLLER);
        this.activeStatus="Active";
        this.inactiveStatus="InActive";
        this.registrationFee=0.00;
        setDate();
        setBatchTransferID();
        setNewRegistrationID();
        btnCheckPayment.setVisible(false);
    // TODO
    }    

    @FXML
    private void studentNicOnAction(ActionEvent event) {
        findStudentForTransfer();
    }

    

    private void oldBatchNameOnAction(ActionEvent event) {
        getBatchID();
    }

    private void setDate() {
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        currentDateID.setText(format.format(date));
    }

    @FXML
    private void tableTransferBatch(SortEvent<?> event) {
    }

    private void findStudentForTransfer() {
        
        try {
            String nic=txtStudentNic.getText();
            StudentDTO studentDTO=studentController.find(nic);
            if(studentDTO!=null){
                txtStudentId.setText(studentDTO.getStudentId());
            }
            
//            String nic=txtStudentNic.getText();
//            List<BatchTransferQueryDTO>dTOs=batchTransferController.getAllStudentdetails(nic);
//            if(dTOs!=null){
//                ObservableList list=FXCollections.observableArrayList();
//                ObservableList list1=FXCollections.observableArrayList();
//                for (BatchTransferQueryDTO dTO : dTOs) {
//                    list.add(dTO.getBatchId());
//                    list1.add(dTO.getBatchName());
//                    comboBatchID.setItems(list);
//                    comboBatchName.setItems(list1);
//                    txtStudentId.setText(dTO.getStudentId());
//                    txtStudentName.setText(dTO.getStudentName());
//                    
//                }
//            }
//        
        } catch (Exception ex) {
            Logger.getLogger(ManageTransferBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getBatchID() {
        try {
            String batchName=comboBatchName.getSelectionModel().getSelectedItem().toString();
            BatchDTO batchDTO=batchController.find(batchName);
            if(batchDTO!=null){
                ObservableList list=FXCollections.observableArrayList();
                list.add(batchDTO.getBatchId());
                comboBatchID.setItems(list);
                
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageTransferBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void buttonCehckPaymentOrNotAction(ActionEvent event) {
        //checkPaymentOfNot();
    }

    @FXML
    private void comboCourseNameOnAction(ActionEvent event) {
        getAllBatchDetails();
        getNotStartedBatch();
        checkPaymentOfNot();
    }
    

    @FXML
    private void searchStudentAndHisCoursesOnAction(ActionEvent event) {
        searchStudentNameAndHisCourse();
    }

    private void searchStudentNameAndHisCourse() {
        try {
            String active=this.activeStatus;
            String sid=txtStudentId.getText();
            List<GetStudentDetailsForTransferQueryDTO>dTOs=batchTransferController.getStudentDetailsForTransfer(sid,active);
            if(dTOs!=null){
                ObservableList list=FXCollections.observableArrayList();
                for (GetStudentDetailsForTransferQueryDTO dTO : dTOs) {
                    txtStudentName.setText(dTO.getStudentName());
                    list.add(dTO.getCourseName());
                    comboCourseName.setItems(list);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageTransferBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getAllBatchDetails() {
        try {
            String sid=txtStudentId.getText();
            String coursName=comboCourseName.getSelectionModel().getSelectedItem().toString();
            
            List<GetBatchDetailsForTransferQueryDTO>dTOs=batchTransferController.getBatchDetailsForTransfer(sid, coursName);
            if(dTOs!=null){
                for (GetBatchDetailsForTransferQueryDTO dTO : dTOs) {
                    txtOldBatchName.setText(dTO.getBatchName());
                    txtBatchID.setText(dTO.getBatchid());
                    this.oldRegistrationID=dTO.getRegistrationId();
                    System.out.println("onna registration id eka hari"+this.oldRegistrationID);
                    
                    
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageTransferBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getNotStartedBatch() {
        try {
            String courseName=comboCourseName.getSelectionModel().getSelectedItem().toString();
            String status="Not Yet Started";
            
            List<GetNotStartBatchForTranserStudentQueryDTO>dTOs=batchTransferController.getNotStartBatch(courseName, status);
            if(dTOs!=null){
                ObservableList list=FXCollections.observableArrayList();
                for (GetNotStartBatchForTranserStudentQueryDTO dTO : dTOs) {
                    list.add(dTO.getBatchName());
                    comboNewBatch.setItems(list);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageTransferBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void checkPaymentOfNot() {
        try {
            String sid=txtStudentId.getText();
            String coursName=comboCourseName.getSelectionModel().getSelectedItem().toString();
            
            List<CheckPaymentForTransferStudentQueryDTO>dTOs=batchTransferController.getPaymentDetails(sid, coursName);
            if(dTOs!=null){
                for (CheckPaymentForTransferStudentQueryDTO dTO : dTOs) {
                    
                    if(dTO.getDate().equalsIgnoreCase("Not Pendin date")){
                        paymentDatePicker.setVisible(false);
                         Notifications notifications = Notifications.create()
                         .title("Chek Payment Of Not ")
                         .text("Settle Full Payment This Course")
                                .graphic(new ImageView())
                                .hideAfter(Duration.seconds(3))
                                .position(Pos.CENTER)
                                .onAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        System.out.println("notification clicked");

                                    }
                                });

                            notifications.darkStyle();
                            notifications.show();
                    }else{
                        paymentDatePicker.setVisible(true);
                        paymentDatePicker.setValue(LocalDate.parse(dTO.getDate()));
                    }
                    this.paymentID=dTO.getPaymentId();
                    
                    
                    if(dTO.getPaymentType().equalsIgnoreCase("half payment")){
                            Notifications notifications = Notifications.create()
                                .title("Chek Payment Of Not ")
                                .text("Settle Half Payment For This Course")
                                .graphic(new ImageView())
                                .hideAfter(Duration.seconds(3))
                                .position(Pos.CENTER)
                                .onAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        System.out.println("notification clicked");

                                    }
                                });

                            notifications.darkStyle();
                            notifications.show();
                    }else if(dTO.getPaymentType().equalsIgnoreCase("full payment")){
//                            Notifications notifications = Notifications.create()
//                                .title("Chek Payment Of Not ")
//                                .text("Settle Full Payment This Course")
//                                .graphic(new ImageView())
//                                .hideAfter(Duration.seconds(3))
//                                .position(Pos.CENTER)
//                                .onAction(new EventHandler<ActionEvent>() {
//                                    @Override
//                                    public void handle(ActionEvent event) {
//                                        System.out.println("notification clicked");
//
//                                    }
//                                });
//
//                            notifications.darkStyle();
//                            notifications.show();
                    }else{
                        Notifications notifications = Notifications.create()
                                .title("Chek Payment Of Not ")
                                .text("Not Payment Yet For This Course")
                                .graphic(new ImageView())
                                .hideAfter(Duration.seconds(3))
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
                    
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageTransferBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void newBatchOnAction(ActionEvent event) {
        getNewBatchID();
    }

    private void getNewBatchID() {
        try {
            String batchName=comboNewBatch.getSelectionModel().getSelectedItem().toString();
            BatchDTO batchDTO=batchTransferController.getBatchIDByBatchName(batchName);
            if(batchDTO!=null){
                newBatchID.setText(batchDTO.getBatchId());
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageTransferBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setNewRegistrationID() {
        try {
            String newId = IDGenetator.getNewId("registration", "REGISTRATION_ID", "R", 2);
            newRegistrationID = newId;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageTransferBatchController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageTransferBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setBatchTransferID() {
        try {
            String newId = IDGenetator.getNewId("batch_transfer", "BATCH_TRANSFER_ID", "BT", 2);
            batchTransferID = newId;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageTransferBatchController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageTransferBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void saveTransferOnAction(ActionEvent event) {
        try {
            StudentDTO studentDTO=new StudentDTO();
            studentDTO.setStudentId(txtStudentId.getText());
            
            BatchDTO batchDTO=new BatchDTO();
            batchDTO.setBatchId(newBatchID.getText());
            
            BatchTransferDTO batchTransferDTO=new  BatchTransferDTO();
            batchTransferDTO.setBatch_transfer_id(batchTransferID);
            batchTransferDTO.setStudentDTO(studentDTO);
            batchTransferDTO.setBatchDTO(batchDTO);
            batchTransferDTO.setReason(txtReson.getText());
            batchTransferDTO.setDate(currentDateID.getText());
            batchTransferDTO.setNewBatch(comboNewBatch.getValue().toString());
            batchTransferDTO.setTransferfee(Double.parseDouble(txtTransferFee.getText()));
            
            BatchRegistrationDTO batchRegistrationDTO=new BatchRegistrationDTO();
            batchRegistrationDTO.setRid(this.newRegistrationID);
            batchRegistrationDTO.setStudentDTO(studentDTO);
            batchRegistrationDTO.setBatchDTO(batchDTO);
            batchRegistrationDTO.setDate(currentDateID.getText());
            batchRegistrationDTO.setBatchStartDate(paymentDatePicker.getValue().toString());
            batchRegistrationDTO.setFee(this.registrationFee);
            batchRegistrationDTO.setStatus(this.activeStatus);
            
            PaymentDTO paymentDTO=new PaymentDTO();
            paymentDTO.setPaymentId(paymentID);
            paymentDTO.setPaymentPendinDAte(paymentDatePicker.getValue().toString());
            paymentDTO.setRegistrationId(newRegistrationID);
            paymentDTO.setBatchId(newBatchID.getText());
            paymentDTO.setBatchName(comboNewBatch.getValue().toString());
            
            BatchRegistrationDTO batchRegistrationDTO1=new BatchRegistrationDTO();
            batchRegistrationDTO1.setRid(this.oldRegistrationID);
            batchRegistrationDTO1.setStatus(this.inactiveStatus);
            
            
            boolean isAdded=batchTransferController.manageBatchTransfer(batchRegistrationDTO, batchTransferDTO, paymentDTO);
            if(isAdded){
                boolean isSave=batchRegistrationController.afterBatchTransfer(batchRegistrationDTO1);
                if(isSave){
                    Notifications notifications = Notifications.create()
                            .title("Batch Transfer ")
                            .text("Batch Transfer Successfully")
                            .graphic(new ImageView())
                            .hideAfter(Duration.seconds(3))
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
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageTransferBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
    }
    

   
   
    
}
