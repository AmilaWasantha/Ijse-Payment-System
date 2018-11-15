/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.viewcontroller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import lk.ijse.ijsebillinsystem.AutoGenarateID.IDGenetator;
import lk.ijse.ijsebillinsystem.controller.ControllerFactory;
import lk.ijse.ijsebillinsystem.controller.custom.CourseController;
import lk.ijse.ijsebillinsystem.dto.CourseDTO;
import lk.ijse.ijsebillinsystem.tableModel.CourseTableModel;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ManageCourseController implements Initializable {
    
    private String autoGenerateId;
    ObservableList<String>durationList=FXCollections.observableArrayList("06 months","24 months","04 months","20 days");
    ObservableList<String>courseTypeList=FXCollections.observableArrayList("Full Time","Part Time");
    private CourseController courseController;
    
   

    @FXML
    private JFXTextField txtCourseName;
    private JFXTextField txtCourseType;
    @FXML
    private JFXTextField txtCourseFee;
    @FXML
    private JFXTextField txtCourseDiscount;
    @FXML
    private JFXTextField txtLatePayment;
    @FXML
    private JFXComboBox<String> comboDuration;
    @FXML
    private TableView<CourseTableModel> tableCourse;
    @FXML
    private JFXButton btnSaveCourse;
    @FXML
    private JFXComboBox<String> comboCourseType;
    
    
    
    @FXML
    void buttonSaveCourse(ActionEvent event) {
        try {
            CourseDTO courseDTO=new CourseDTO();
            
            courseDTO.setCourseId(autoGenerateId);
            courseDTO.setCourseName(txtCourseName.getText());
            courseDTO.setCourseType(comboCourseType.getValue());
            courseDTO.setCourseFee(Double.parseDouble(txtCourseFee.getText()));
            courseDTO.setLatePayment(Integer.parseInt(txtLatePayment.getText()));
            courseDTO.setDuration(comboDuration.getValue());
            courseDTO.setCourseDiscount(txtCourseDiscount.getText());
            
            boolean isAdded= courseController.save(courseDTO);
            if(isAdded){
               
             
                Image image=new Image("/lk/ijse/ijsebillinsystem/assests/sucessfully.png");
                Notifications notifications= Notifications.create()
                        .title("Save successfully")
                        .text("Course has save successfully")
                        .graphic(new ImageView(image))
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
                 setId();
                loadAllCoursesDetails();
                
                        
                        
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void buttonSearchCourse(ActionEvent event) {
        
    }

    @FXML
    void buttonUpdateCourse(ActionEvent event) {
//        try {
//            String courseId="C002";
//            String discount="0";
//            CourseDTO courseDTO=new CourseDTO();
//            courseDTO.setCourseId(courseId);
//            courseDTO.setCourseDiscount(discount);
//            
//            boolean isUdate=courseController.update(courseDTO);
//            if(isUdate){
//                JOptionPane.showMessageDialog(null, "update successfully");
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(ManageCourseController.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableCourse.getColumns().get(0).setStyle("-fx-alignment:center");
        tableCourse.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("courseId"));
        tableCourse.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("courseName"));
        tableCourse.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("courseType"));
        tableCourse.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("courseFee"));
        tableCourse.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("latePayment"));
        tableCourse.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("duration"));
        tableCourse.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("courseDiscount"));
        courseController=(CourseController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.COURSECONTROLLER);
        comboDuration.setItems(durationList);
        comboCourseType.setItems(courseTypeList);
        comboDurationAction(null);
        setId();
        //loadAllCoursesDetails();
        
        
        
        // TODO
    }    

    private void test() {
        String output=comboDuration.getValue();
       
        
    }

    @FXML
    private void comboDurationAction(ActionEvent event) {
        test();
    }

    private void setId() {
        try {
            
            String newId = IDGenetator.getNewId("course", "COURSE_ID", "C", 2);
            autoGenerateId=newId;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageCourseController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadAllCoursesDetails() {
        try {
            List<CourseDTO>courseDTOs=courseController.getAll();
            
            ObservableList<CourseTableModel> allCourseTableModels=tableCourse.getItems();
            allCourseTableModels.removeAll(allCourseTableModels);
            
            for (CourseDTO courseDTO:courseDTOs) {
                System.out.println(courseDTO.getCourseName());
                allCourseTableModels.add(new CourseTableModel(courseDTO.getCourseId(),courseDTO.getCourseName(),courseDTO.getCourseType(), courseDTO.getCourseFee(),courseDTO.getLatePayment(), courseDTO.getDuration(),courseDTO.getCourseDiscount()));
            }
            
            //tableCourse.setItems(allCourseTableModels);
            
        } catch (Exception ex) {
            Logger.getLogger(ManageCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   }

    @FXML
    private void comboCourseTypeAction(ActionEvent event) {
    }

   
    
}
