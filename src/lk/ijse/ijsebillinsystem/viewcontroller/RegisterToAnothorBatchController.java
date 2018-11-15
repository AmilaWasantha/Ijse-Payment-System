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
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import lk.ijse.ijsebillinsystem.AutoGenarateID.IDGenetator;
import lk.ijse.ijsebillinsystem.controller.ControllerFactory;
import lk.ijse.ijsebillinsystem.controller.custom.BatchController;
import lk.ijse.ijsebillinsystem.controller.custom.BatchRegistrationController;
import lk.ijse.ijsebillinsystem.controller.custom.CourseController;
import lk.ijse.ijsebillinsystem.controller.custom.StudentController;
import lk.ijse.ijsebillinsystem.dto.BatchDTO;
import lk.ijse.ijsebillinsystem.dto.BatchRegistrationDTO;
import lk.ijse.ijsebillinsystem.dto.CourseDTO;
import lk.ijse.ijsebillinsystem.dto.StudentDTO;
import lk.ijse.ijsebillinsystem.querydto.BatchDetailsForNewRegistrationDTO;
import lk.ijse.ijsebillinsystem.querydto.CheckOldBatchDetailsForRegisterToAnotherBatchQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.GetNewCourseDetailsQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.RegisterStudentToAnothoerBatchQueryDTO;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author user
 */
public class RegisterToAnothorBatchController implements Initializable {
    public static String studentNic;
    public static String sid;
    private StudentController studentController;
    private CourseController courseController;
    private BatchController batchController;
    private String registrationStatus;
    private String autoGenaratedID;
    private String status;
    private BatchRegistrationController batchRegistrationController;
    private String batchStatus;
    @FXML
    private JFXTextField txtStudentNic;
    @FXML
    private JFXTextField txtStudentId;
    @FXML
    private JFXTextField txtStudentName;
    @FXML
    private JFXComboBox<?> comboCourseId;
    @FXML
    private JFXTextField txtCoursId;
    @FXML
    private JFXTextField txtNewCourseType;
    @FXML
    private JFXComboBox<?> comboNewBatch;
    @FXML
    private JFXTextField txtFee;
    @FXML
    private JFXButton txtNewRegistration;
    @FXML
    private JFXDatePicker txtDatePicker;
    @FXML
    private JFXTextField txtCurrentDate;
    @FXML
    private JFXComboBox<?> comboCourseName;
    @FXML
    private JFXTextField txtCourseType;
    @FXML
    private JFXTextField txtBatchName;
    @FXML
    private JFXTextField txtBatchState;
    @FXML
    private JFXTextField txtNewBatchID;
    @FXML
    private JFXTextField txtNewBatchStatus;
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        batchRegistrationController=(BatchRegistrationController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.BATCHREGISTRATIONCONTROLLER);
        batchController=(BatchController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.BATCHCONTROLLER);
        studentController=(StudentController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.STUDENTCONTROLLER);
        courseController=(CourseController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.COURSECONTROLLER);
        setNIC();
        this.status="Active";
        this.registrationStatus="Active";
        this.batchStatus="Not Yet Started";
        txtFee.setText("0.00");
        setDate();
        setRegistrationID();
        getAllCourseDetails();
// TODO
    }    

    @FXML
    private void studentNicAction(ActionEvent event) {
    }

    @FXML
    private void studentIdAction(ActionEvent event) {
           try {
            String sid=txtStudentId.getText();
            String status=this.status;
            List<RegisterStudentToAnothoerBatchQueryDTO>registerToAnothorBatchControllers=studentController.getStudentDetails(sid,status);
            if(registerToAnothorBatchControllers!=null){
                ObservableList list=FXCollections.observableArrayList();
                for (RegisterStudentToAnothoerBatchQueryDTO registerToAnothorBatchController : registerToAnothorBatchControllers) {
                    list.add(registerToAnothorBatchController.getCourseName());
                    comboCourseName.setItems(list);
                    txtStudentName.setText(registerToAnothorBatchController.getStudentName());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(RegisterToAnothorBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setNIC() {
        txtStudentNic.setText(studentNic);
        txtStudentId.setText(sid);
        System.out.println("onna nic eka awa"+studentNic);
    }


    @FXML
    private void comboCourseDatailsAction(ActionEvent event) {
        searchCourseId();
       
    }

    private void getAllCourseDetails() {
         try {
            List<CourseDTO>courseDTOs=courseController.getAll();
            if(courseDTOs!=null){
                ObservableList list=FXCollections.observableArrayList();
                for (CourseDTO courseDTO : courseDTOs) {
                    list.add(courseDTO.getCourseName());
                    comboCourseId.setItems(list);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(RegisterToAnothorBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void searchCourseId() {
        try {
            String coursName=comboCourseId.getSelectionModel().getSelectedItem().toString();
            String batchStatus=this.batchStatus;
            
            List<GetNewCourseDetailsQueryDTO>dTOs=batchController.getNewCourseDetailsForRegisterToAnothorBatch(coursName, batchStatus);
            if(dTOs!=null){
                ObservableList list=FXCollections.observableArrayList();
                for (GetNewCourseDetailsQueryDTO dTO : dTOs) {
                    list.add(dTO.getBatchName());
                    comboNewBatch.setItems(list);
                    
                    txtNewCourseType.setText(dTO.getCourseType());
                    txtCoursId.setText(dTO.getCourseId());
                }
            }else{
                
                 Notifications notifications = Notifications.create()
                 .title("Check Not Started Batch")
                 .text("All Batches Started")
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
            Logger.getLogger(RegisterToAnothorBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void comboNewBatchName(ActionEvent event) {
        findBatchDetails();
    }


    @FXML
    private void NewCourseIDAction(ActionEvent event) {
        getNewBatchDetails();
    }

    private void getNewBatchDetails() {
        try {
            String coursId=txtCoursId.getText();
            List<BatchDetailsForNewRegistrationDTO>details=batchController.getBatchDetailsForNewRegistration(coursId);
            if(details!=null){
                ObservableList list=FXCollections.observableArrayList();
                ObservableList list1=FXCollections.observableArrayList();
                ObservableList list2=FXCollections.observableArrayList();
                for (BatchDetailsForNewRegistrationDTO detail : details) {
                    list.add(detail.getBatchId());
                    list1.add(detail.getStatus());
                    list2.add(detail.getBatchName());
                  //  comboNewBatchID.setItems(list);
                    comboNewBatch.setItems(list2);
                    //comboNewBatchStatus.setItems(list1);
                    
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(RegisterToAnothorBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void findBatchDetails() {
        try {
            String batchName=(String) comboNewBatch.getSelectionModel().getSelectedItem();
            
            BatchDTO batchDetails=batchController.findBatchForCheckEqualsBatchId(batchName);
            if(batchDetails!=null){
                txtNewBatchID.setText(batchDetails.getBatchId());
                txtNewBatchStatus.setText(batchDetails.getStatus());
                System.out.println("11111111111111111111111111111111111111111111111"+batchDetails.getBatchName());
            }
        } catch (Exception ex) {
            Logger.getLogger(RegisterToAnothorBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void buttonNewRegistrationAction(ActionEvent event) {
        String oldCourseType=txtCourseType.getText();
        String newcourseType=txtNewCourseType.getText();
      
        if(txtBatchState.getText().equalsIgnoreCase("Completed") || !txtCourseType.getText().equalsIgnoreCase(txtNewCourseType.getText())){
            try {
                double fee=Double.parseDouble(txtFee.getText());
                BatchRegistrationDTO dto=new BatchRegistrationDTO();
                dto.setRid(this.autoGenaratedID);
                dto.setStatus(this.registrationStatus);
                dto.setFee(Double.parseDouble(txtFee.getText()));
                dto.setDate(txtCurrentDate.getText());
                dto.setBatchStartDate(txtDatePicker.getValue().toString());
                
                BatchDTO batchDTO=new BatchDTO();
                batchDTO.setBatchId(txtNewBatchID.getText());
                
                StudentDTO  studentDTO=new  StudentDTO();
                studentDTO.setStudentId(txtStudentId.getText());
                
                dto.setBatchDTO(batchDTO);
                dto.setStudentDTO(studentDTO);
                
                boolean isAdded=batchRegistrationController.registrationToAnotherBatch(dto);
                if(isAdded){
                    Notifications notifications= Notifications.create()
                            .title("Batch Registration")
                            .text("Registraton is successfully")
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
                Logger.getLogger(RegisterToAnothorBatchController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }else {
               Notifications notifications= Notifications.create()
                        .title("Trouble This Registration")
                        .text("Registration Fail ")
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
           
    }

    private void setDate() {
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        txtCurrentDate.setText(format.format(date));
    }

    private void setRegistrationID() {
        try {
            String newId = IDGenetator.getNewId("registration", "REGISTRATION_ID", "R", 2);
            autoGenaratedID=newId;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterToAnothorBatchController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterToAnothorBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void comboCouresNameAction(ActionEvent event) {
        checkOldBatchDetails();
    }

    private void checkOldBatchDetails() {
        try {
            String sid=txtStudentId.getText();
            String courseName=comboCourseName.getSelectionModel().getSelectedItem().toString();
            String status=this.status;
            
            List<CheckOldBatchDetailsForRegisterToAnotherBatchQueryDTO>dTOs=batchController.getBatchDetails(sid, courseName, status);
            if(dTOs!=null){
                for (CheckOldBatchDetailsForRegisterToAnotherBatchQueryDTO dTO : dTOs) {
                    txtCourseType.setText(dTO.getCoursType());
                    txtBatchName.setText(dTO.getBatchName());
                    txtBatchState.setText(dTO.getBatchStatus());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(RegisterToAnothorBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
