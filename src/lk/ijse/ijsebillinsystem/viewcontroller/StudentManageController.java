/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.viewcontroller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import lk.ijse.ijsebillinsystem.AutoGenarateID.IDGenetator;
import lk.ijse.ijsebillinsystem.controller.ControllerFactory;
import lk.ijse.ijsebillinsystem.controller.custom.BatchController;
import lk.ijse.ijsebillinsystem.controller.custom.BatchRegistrationController;
import lk.ijse.ijsebillinsystem.controller.custom.StudentController;
import lk.ijse.ijsebillinsystem.dao.DAOFactory;
import lk.ijse.ijsebillinsystem.dao.custom.BatchDAO;
import lk.ijse.ijsebillinsystem.dto.BatchDTO;
import lk.ijse.ijsebillinsystem.dto.BatchRegistrationDTO;
import lk.ijse.ijsebillinsystem.dto.GardianDTO;
import lk.ijse.ijsebillinsystem.dto.StudentDTO;
import lk.ijse.ijsebillinsystem.querydto.BatchQueryDTO;
import lk.ijse.ijsebillinsystem.tableModel.RagistrationToBatchTableModel;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author user
 */
public class StudentManageController implements Initializable {
    private BatchRegistrationController batchRegistrationController;
    private StudentController studentController;
    final ToggleGroup group=new ToggleGroup();
    private String status;
    static GardianDTO gardianDTO;
    String date;
    String studentId;
    String registrationId;
    
    String gardianName;
    String gardianId;
    String mobile_1;
    String mobile_2;
    String email;
    String designation;
    String workingPlace;
    String address;
    
    String radiovalue;
    String checkBoxValues;
    private BatchController  batchController;
    private BatchDAO batchDAO;
    
    
    @FXML
    private JFXTextField txtFullName;
    @FXML
    private JFXTextField txtNameWithIntials;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXTextField txtHomeTelephone;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtMobileTelephone;
    @FXML
    private JFXTextField txtYear;
    @FXML
    private JFXTextField txtMonth;
    @FXML
    private JFXTextField txtDay;
    @FXML
    private JFXTextField txtCity;
    @FXML
    private JFXTextField txtNic;
    @FXML
    private JFXTextField txtSchool;
    @FXML
    private JFXTextField txtUniversityofother;

    @FXML
    private JFXTextField txtRegistration;

    @FXML
    private Button btnGardianDetails;

   

    @FXML
    private AnchorPane MainPanal;

    @FXML
    private JFXCheckBox checkBoxMaster;

    @FXML
    private JFXCheckBox checkBoxDegree;

    @FXML
    private JFXCheckBox checkBoxDipoloma;

    @FXML
    private JFXCheckBox checkBoxAL;
    @FXML
    private JFXButton btnRegisterStudent;
    @FXML
    private JFXRadioButton radioMale;
    @FXML
    private JFXRadioButton radioFemale;
    @FXML
    private JFXTextField txtBatchId;
    @FXML
    private TableView<RagistrationToBatchTableModel> tableBatch;
    @FXML
    private JFXTextField txtCurrentDate;
    
    @FXML
    private JFXTextField txtFindStudent;
    @FXML
    private JFXTextField txtStudentID;
    @FXML
    private JFXButton btnRegisterAnotherBatch;
    @FXML
    private JFXDatePicker paymentDateDatePicker;

    @FXML
    void btnRegisterStudentAction(ActionEvent event) {
        try {
            getRadioValues();
            testCheckBox();
            
            
            
            String testGender=radiovalue;
            System.out.println("testGender : "+testGender);
            String statu=this.status;
//            gardianName=gardianDTO.getName();
//            
            StudentDTO studentDTO=new StudentDTO();
            studentDTO.setStudentId(studentId);
            studentDTO.setGardianDTO(gardianDTO);
            studentDTO.setNameWithInitials(txtNameWithIntials.getText());
            studentDTO.setAddress(txtAddress.getText());
            studentDTO.setCity(txtCity.getText());
            studentDTO.setHome_tel(txtHomeTelephone.getText());
            studentDTO.setMobile_tel(txtMobileTelephone.getText());
            studentDTO.setEmail(txtEmail.getText());
            studentDTO.setNic(txtNic.getText());
            studentDTO.setBday(txtYear.getText()+"-"+txtMonth.getText()+"-"+txtDay.getText());
            studentDTO.setGender(testGender);
            studentDTO.setUniversity(txtUniversityofother.getText());
            studentDTO.setEducation(checkBoxValues);
            
            BatchDTO batchDTO=new BatchDTO();
            batchDTO.setBatchId(txtBatchId.getText());
            
            BatchRegistrationDTO batchRegistrationDTO=new BatchRegistrationDTO();
            batchRegistrationDTO.setRid(registrationId);
            batchRegistrationDTO.setStudentDTO(studentDTO);
            batchRegistrationDTO.setBatchDTO(batchDTO);
            batchRegistrationDTO.setDate(txtCurrentDate.getText());
            batchRegistrationDTO.setBatchStartDate(paymentDateDatePicker.getValue().toString());
            batchRegistrationDTO.setFee(Double.parseDouble(txtRegistration.getText()));
            batchRegistrationDTO.setStatus(statu);
            
            boolean isAdded=batchRegistrationController.save(batchRegistrationDTO);
            if(isAdded){
                
                  Notifications notifications= Notifications.create()
                          .title("Save successfully")
                          .text("Student has save successfully ")
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
                setRegistratinId();
                setStudentId();
                
            }else{
                JOptionPane.showMessageDialog(null, "somthing wrong");
            }
            //date=txtYear.getText()+"-"+txtMonth.getText()+"-"+txtDay.getText();
        } catch (Exception ex) {
            Logger.getLogger(StudentManageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setbuttongrouprediobuttons();
        setStudentId();
       
        setCurrentDate();
        setRegistratinId();
        this.status="Active";
        gardianDTO=new GardianDTO();
        //checkBoxValues=txtAddress.getText()+"/"+txtCity.getText();
        batchDAO=(BatchDAO) DAOFactory.getInstance().getConnection(DAOFactory.DAOType.BATCHDAO);
        studentController=(StudentController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.STUDENTCONTROLLER);
        batchController=(BatchController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.BATCHCONTROLLER);
        batchRegistrationController=(BatchRegistrationController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.BATCHREGISTRATIONCONTROLLER);
        
        tableBatch.getColumns().get(0).setStyle("-fx-alignment:center");
        tableBatch.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("batchId"));
        tableBatch.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("batchName"));
        tableBatch.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("coursName"));
        getAllBatchDetails();
        btnRegisterAnotherBatch.setVisible(false);
        
        
    }

    private void LoadStages(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            BoxBlur boxBlur = new BoxBlur();
            boxBlur.setIterations(2);
            MainPanal.setEffect(boxBlur);
            stage.showAndWait();
            
            boxBlur.setIterations(0);
            MainPanal.setEffect(boxBlur);

        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void buttonGardianDetailsAction(ActionEvent event) {
        LoadStages("/lk/ijse/ijsebillinsystem/view/Gardian.fxml");

    }

    private void setbuttongrouprediobuttons() {
        radioMale.setToggleGroup(group);
        radioMale.setSelected(true);
        
        radioFemale.setToggleGroup(group);
        radioFemale.setSelected(true);
        
       
        
        
    }

    private void getRadioValues() {
        RadioButton selectedRadioButton=(RadioButton) group.getSelectedToggle();
        radiovalue=selectedRadioButton.getText();
        
        System.out.println("radioValue : "+radiovalue);
    }

    private void testCheckBox() {
        
       
        
            if(checkBoxMaster.isSelected()){
                checkBoxValues+=checkBoxMaster.getText()+ " /";
            }
            if(checkBoxDegree.isSelected()){
                checkBoxValues+=checkBoxDegree.getText()+" / ";
            }
            if(checkBoxDipoloma.isSelected()){
                checkBoxValues+=checkBoxDipoloma.getText()+" /";
            }
            if(checkBoxAL.isSelected()){
                checkBoxValues+=checkBoxAL.getText();
            }
        
    }

    private void getAllBatchDetails() {
        try {
            List<BatchQueryDTO>batchQuerys=batchController.getAllBatchDetailsForRegistration();
            ObservableList<RagistrationToBatchTableModel> allCourseTableModels=tableBatch.getItems();
            allCourseTableModels.removeAll(allCourseTableModels);
            
            
                for (BatchQueryDTO batchQuery : batchQuerys) {
                 
                    allCourseTableModels.add(new RagistrationToBatchTableModel(batchQuery.getBatchId(),batchQuery.getCoursId(),batchQuery.getBatchName(),batchQuery.getDate(),batchQuery.getStatus(),batchQuery.getCoursName()));
                    
                }
            
        } catch (Exception ex) {
            Logger.getLogger(StudentManageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void buttonTestAction(ActionEvent event) {
        try {
            batchDAO.getAllBatchDetailsForRegistration();
        } catch (Exception ex) {
            Logger.getLogger(StudentManageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void testGadianDetals(){
        
    }

    private void setStudentId() {
        try {
            String newId = IDGenetator.getNewId("student", " STUDENT_ID", "S", 2);
            studentId=newId;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentManageController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentManageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setRegistratinId() {
        try {
            String newId = IDGenetator.getNewId("registration", " REGISTRATION_ID", "R", 2);
            registrationId=newId;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentManageController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentManageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setCurrentDate() {
        Date date=new Date();
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        this.txtCurrentDate.setText(sf.format(date));
                
    }

    @FXML
    private void tableBatchMouseClicked(MouseEvent event) {
        txtBatchId.setText(tableBatch.getSelectionModel().getSelectedItem().getBatchId());
    }

    @FXML
    private void findStudentAction(ActionEvent event) {
        try {
            String nic=txtFindStudent.getText();
            StudentDTO studentDTO=studentController.find(nic);
            if(studentDTO!=null){
                
               // Image image=new Image("/lk/ijse/ijsebillinsystem/assests/sucessfully.png");
                Notifications notifications= Notifications.create()
                        .title("This Student Is Active")
                        .text("You can register this student another batch")
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
                txtStudentID.setText(studentDTO.getStudentId());
                btnRegisterAnotherBatch.setVisible(true);
                
            }else{
                btnRegisterAnotherBatch.setVisible(false);
                //JOptionPane.showMessageDialog(null, "No such student found");
                txtStudentID.setText("NO Found Student");
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentManageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnRegisterAnotherBatchAction(ActionEvent event) {
        setId();
         LoadStages("/lk/ijse/ijsebillinsystem/view/RegisterToAnothorBatch.fxml");
         
    }

    private void setId() {
        RegisterToAnothorBatchController.studentNic=txtFindStudent.getText();
        RegisterToAnothorBatchController.sid=txtStudentID.getText();
        
    }

    

    

   
    

}
