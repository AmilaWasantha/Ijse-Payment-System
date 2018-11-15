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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
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
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lk.ijse.ijsebillinsystem.AutoGenarateID.IDGenetator;
import lk.ijse.ijsebillinsystem.controller.ControllerFactory;
import lk.ijse.ijsebillinsystem.controller.custom.BatchController;
import lk.ijse.ijsebillinsystem.controller.custom.BatchCourseController;
import lk.ijse.ijsebillinsystem.controller.custom.CourseController;
import lk.ijse.ijsebillinsystem.dto.BatchCourseDTO;
import lk.ijse.ijsebillinsystem.dto.BatchDTO;
import lk.ijse.ijsebillinsystem.dto.CourseDTO;
import lk.ijse.ijsebillinsystem.tableModel.GetAllBatchTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author user
 */
public class SaveBatchController implements Initializable {

    private CourseController courseController;
    private BatchController batchController;
    private BatchCourseController batchCourseController;
    String autoGenaratId;
    String batchCourseId;
    String equalsBatchId;
    String StartedBatch;
    String CompletedBatch;

    ObservableList<String> durationList = FXCollections.observableArrayList("Not Yet Started", "Start", "Complete");

    @FXML
    private JFXComboBox<?> comboCourses;

    @FXML
    private JFXButton btnSaveBatch;

    @FXML
    private JFXButton btnUpdateBatch;

    @FXML
    private JFXTextField txtStatus;
    @FXML
    private JFXTextField txtBatchName;
    @FXML
    private JFXTextField txtStartDate;
    @FXML
    private JFXTextField txtCoursName;
    @FXML
    private JFXButton btnStartBatch;
    @FXML
    private JFXComboBox<String> comboSelectFormStartBatch;
    @FXML
    private JFXComboBox<?> comboForEndBatch;
    @FXML
    private JFXButton btnEndBatch;
    @FXML
    private AnchorPane mainPanal;
    @FXML
    private TableView<GetAllBatchTableModel> tableBatch;
    @FXML
    private JFXTextField txtBatchType;
    @FXML
    private JFXButton btnPrint;

    public SaveBatchController() {
        //this.observableList = FXCollections.observableMap("fdjsa");
    }

    @FXML
    void buttonSaveBatch(ActionEvent event) {

        test();

        if (equalsBatchId.equalsIgnoreCase("nothing")) {

            try {
                System.out.println("null ekak thama enne");
                BatchDTO batchDTO = new BatchDTO();
                batchDTO.setBatchId(autoGenaratId);
                batchDTO.setBatchName(txtBatchName.getText());
                batchDTO.setDate(txtStartDate.getText());
                batchDTO.setType(txtBatchType.getText());
                batchDTO.setStatus(txtStatus.getText());

                CourseDTO courseDTO = new CourseDTO();
                courseDTO.setCourseId(txtCoursName.getText());

                BatchCourseDTO batchCourseDTO = new BatchCourseDTO();
                batchCourseDTO.setBatchCourseId(batchCourseId);

                batchCourseDTO.setBatchDTO(batchDTO);
                batchCourseDTO.setCourseDTO(courseDTO);
                batchCourseDTO.setBatchName(txtBatchName.getText());
                batchCourseDTO.setDate(txtStartDate.getText());
                batchCourseDTO.setType(txtBatchType.getText());
                batchCourseDTO.setStatus(txtStatus.getText());

                boolean isAdded = batchController.saveBatchCourse(batchDTO, batchCourseDTO);
                if (isAdded) {
                    test();
                    Notifications notifications = Notifications.create()
                            .title("Save successfully")
                            .text("Batch has save successfully")
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
                    setId();
                    setBatchCourseId();
                    getAllBatchDetails();
                    getAllNotStartedBatch();
                }
            } catch (Exception ex) {
                Logger.getLogger(SaveBatchController.class.getName()).log(Level.SEVERE, null, ex);
            }

            //else if(txtCoursName.getText().equalsIgnoreCase(equalsBatchId)){
        } else {
            try {
                BatchDTO batchDTO = new BatchDTO();
                batchDTO.setBatchId(equalsBatchId);
//              batchDTO.setBatchName(txtBatchName.getText());
//              batchDTO.setDate(txtStartDate.getText());
//              batchDTO.setStatus(txtStatus.getText());

                CourseDTO courseDTO = new CourseDTO();
                courseDTO.setCourseId(txtCoursName.getText());

                BatchCourseDTO batchCourseDTO = new BatchCourseDTO();
                batchCourseDTO.setBatchCourseId(batchCourseId);
                batchCourseDTO.setBatchDTO(batchDTO);
                batchCourseDTO.setCourseDTO(courseDTO);
                batchCourseDTO.setBatchName(txtBatchName.getText());
                batchCourseDTO.setDate(txtStartDate.getText());
                batchCourseDTO.setType(txtBatchType.getText());
                batchCourseDTO.setStatus(txtStatus.getText());

                boolean isAdded = batchCourseController.save(batchCourseDTO);
                if (isAdded) {
                    test();
                    Notifications notifications = Notifications.create()
                            .title("Save successfully")
                            .text("Batch has save successfully")
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
                    setId();
                    setBatchCourseId();
                    getAllBatchDetails();
                    getAllNotStartedBatch();
                }

            } catch (Exception ex) {
                Logger.getLogger(SaveBatchController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//      }else{
//          try {
//              BatchDTO batchDTO=new BatchDTO();
//              batchDTO.setBatchId(autoGenaratId);
//              batchDTO.setBatchName(txtBatchName.getText());
//              batchDTO.setDate(txtStartDate.getText());
//              batchDTO.setStatus(txtStatus.getText());
//              
//              
//              
//              CourseDTO courseDTO=new CourseDTO();
//              courseDTO.setCourseId(txtCoursName.getText());
//              
//              
//              
//              
//              
//              BatchCourseDTO batchCourseDTO=new BatchCourseDTO();
//              batchCourseDTO.setBatchCourseId(batchCourseId);
//              batchCourseDTO.setBatchDTO(batchDTO);
//              batchCourseDTO.setCourseDTO(courseDTO);
//              
//              boolean isAdded=batchController.saveBatchCourse(batchDTO, batchCourseDTO);
//              if(isAdded){
//                  Notifications notifications= Notifications.create()
//                          .title("Save successfully ")
//                          .text("Batch has save successfully thun weni eka")
//                          .graphic(new ImageView())
//                          .hideAfter(Duration.seconds(5))
//                          .position(Pos.CENTER)
//                          .onAction(new EventHandler<ActionEvent>() {
//                              @Override
//                              public void handle(ActionEvent event) {
//                                  System.out.println("notification clicked");
//                                  
//                              }
//                          });
//                  
//                  notifications.darkStyle();
//                  notifications.show();
//                  setId();
//                  setBatchCourseId();
//              }
//          } catch (Exception ex) {
//              Logger.getLogger(SaveBatchController.class.getName()).log(Level.SEVERE, null, ex);
//          }
//      }

    }

    void buttonSearchBatch(ActionEvent event) {

    }

    @FXML
    void buttonUpdateBatch(ActionEvent event) {

    }

    @FXML
    void comboAction(ActionEvent event) {
        SearchCourseName();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        courseController = (CourseController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.COURSECONTROLLER);
        batchController = (BatchController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.BATCHCONTROLLER);
        batchCourseController = (BatchCourseController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.BATCHCOURSECONTROLLER);
        tableBatch.getColumns().get(0).setStyle("-fx-alignment:center");
        tableBatch.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("batchId"));
        tableBatch.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("batchName"));
        tableBatch.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("date"));
        tableBatch.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("status"));

        StartedBatch = "Started";
        CompletedBatch = "Completed";
        getAllBatchDetails();
        getAllCourses();
        getAllNotStartedBatch();
        getAllStartedBatch();
        setId();
        setBatchCourseId();
        searchBatchForStart();

        txtStatus.setText("Not Yet Started");
        txtStatus.setEditable(false);
        // TODO
    }

    private void getAllCourses() {
        try {
            List<CourseDTO> courseDTOs = courseController.getAll();
            if (courseDTOs != null) {

                ObservableList list = FXCollections.observableArrayList();
                for (CourseDTO courseDTO : courseDTOs) {
                    System.out.println("hhh" + courseDTO.getCourseName());

                    list.add(courseDTO.getCourseName());
                    comboCourses.setItems(list);
                }

            }

        } catch (Exception ex) {
            Logger.getLogger(SaveBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void SearchCourseName() {
        try {
            String courseId = (String) comboCourses.getSelectionModel().getSelectedItem();
            CourseDTO courseDTO = courseController.find(courseId);
            if (courseDTO != null) {
                txtCoursName.setText(courseDTO.getCourseId());
                txtBatchType.setText(courseDTO.getCourseType());
                System.out.println("course id " + courseDTO.getCourseId());
            }
        } catch (Exception ex) {
            Logger.getLogger(SaveBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setId() {
        try {
            String newId = IDGenetator.getNewId("batch", "BATCH_ID", "B", 2);
            autoGenaratId = newId;
            System.out.println("onna id genarator eka " + autoGenaratId);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveBatchController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SaveBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void buttonStartBatchAction(ActionEvent event) {
        try {
            String batchName = comboSelectFormStartBatch.getValue();
            BatchDTO batchDTO = batchController.findBatchForCheckEqualsBatchId(batchName);
            if (batchDTO != null) {
                String status = "Started";
                BatchDTO batchDTO1 = new BatchDTO();
                batchDTO1.setBatchId(batchDTO.getBatchId());
                batchDTO1.setStatus(status);
                boolean isUpdate = batchController.UpdateBatchStatus(batchDTO1);
                if (isUpdate) {
                    getAllStartedBatch();
                    getAllNotStartedBatch();
                    Notifications notifications = Notifications.create()
                            .title("Batch Start successfully ")
                            .text("Batch has Started successfully")
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
                } else {
                    JOptionPane.showMessageDialog(null, "Somthing wrong");
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(SaveBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void buttonEndBatchAction(ActionEvent event) {
        try {
            String batchName = comboForEndBatch.getValue().toString();
            BatchDTO batchDTO = batchController.findBatchForCheckEqualsBatchId(batchName);
            if (batchName != null) {
                String completedBatch = this.CompletedBatch;
                BatchDTO batchDTO1 = new BatchDTO();
                batchDTO1.setBatchId(batchDTO.getBatchId());
                batchDTO1.setStatus(completedBatch);

                boolean isUpdate = batchController.UpdateBatchStatus(batchDTO1);
                if (isUpdate) {
                    getAllNotStartedBatch();
                    getAllStartedBatch();
                    Notifications notifications = Notifications.create()
                            .title("Batch Stoped successfully ")
                            .text(" Batch has Stoped successfully")
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
        } catch (Exception ex) {
            Logger.getLogger(SaveBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setBatchCourseId() {
        try {
            String newId = IDGenetator.getNewId("course_batch", "COURSE_BATCH", "BC", 2);
            batchCourseId = newId;
            System.out.println("uuuuuuuuuuuuuuuuuuuuuuuu" + batchCourseId);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveBatchController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SaveBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void searchBatchForStart() {
        try {
            String status = "Not Yet Started";
            List<BatchDTO> batchDTOs = batchController.searchBatchForStart(status);
            if (batchDTOs != null) {
                ObservableList list = FXCollections.observableArrayList();
                for (BatchDTO batchDTO : batchDTOs) {
                    list.add(batchDTO.getBatchName());
                    comboSelectFormStartBatch.setItems(list);
                    System.out.println("fldsafdasfl" + batchDTO.getBatchName());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(SaveBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void test() {
        String bathName = txtBatchName.getText();
        if (bathName.equalsIgnoreCase("CMJD Full")) {
            try {
                BatchDTO batchDTO = batchController.findBatchForCheckEqualsBatchId(bathName);
                System.out.println("batch dto " + batchDTO);
                if (batchDTO != null) {
                    equalsBatchId = batchDTO.getBatchId();
                } else {
                    equalsBatchId = "nothing";
                }
                System.out.println("oya hari");
            } catch (Exception ex) {
                Logger.getLogger(SaveBatchController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            equalsBatchId = "nothing";
        }
    }

    private void getAllNotStartedBatch() {
        try {
            String status = txtStatus.getText();
            List<BatchDTO> getAllNotStartedBatchs = batchController.getAllOfNOtStartedBatch(status);
            if (getAllNotStartedBatchs != null) {
                ObservableList list = FXCollections.observableArrayList();
                for (BatchDTO allNotStartedBatch : getAllNotStartedBatchs) {
                    list.add(allNotStartedBatch.getBatchName());
                    comboSelectFormStartBatch.setItems(list);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(SaveBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getAllStartedBatch() {
        try {
            String startedBatch = this.StartedBatch;
            List<BatchDTO> batchDTOs = batchController.getAllStartedBatch(startedBatch);
            if (batchDTOs != null) {
                ObservableList list = FXCollections.observableArrayList();
                for (BatchDTO batchDTO : batchDTOs) {

                    list.add(batchDTO.getBatchName());
                    comboForEndBatch.setItems(list);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(SaveBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getAllBatchDetails() {
        try {
            List<BatchDTO> batchDTOs = batchController.getAll();
            if (batchDTOs != null) {
                ObservableList<GetAllBatchTableModel> list = tableBatch.getItems();
                list.removeAll(list);
                for (BatchDTO batchDTO : batchDTOs) {
                    GetAllBatchTableModel getAllBatchTableModel = new GetAllBatchTableModel();
                    getAllBatchTableModel.setBatchId(batchDTO.getBatchId());
                    getAllBatchTableModel.setBatchName(batchDTO.getBatchName());
                    getAllBatchTableModel.setDate(batchDTO.getDate());
                    getAllBatchTableModel.setStatus(batchDTO.getStatus());
                    list.add(getAllBatchTableModel);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(SaveBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnPrint_OnAction(ActionEvent event) {

        try {

            JasperReport compiledReport = (JasperReport) JRLoader.loadObject(SaveBatchController.class.getResourceAsStream("/lk/ijse/ijsebillinsystem/jasperReport/allBatch.jasper"));
            Connection connection = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SaveBatchController.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/ijsepaymentsystem", "root", "amila1568");
            } catch (SQLException ex) {
                Logger.getLogger(SaveBatchController.class.getName()).log(Level.SEVERE, null, ex);
            }

            JasperPrint fillledReport = JasperFillManager.fillReport(compiledReport, new HashMap<>(), connection);
            JasperViewer jasperReportViewer = new JasperViewer(fillledReport);
            JDialog dialog = new JDialog();
            // jasperReportViewer.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
            dialog.setContentPane(jasperReportViewer.getContentPane());
            dialog.setSize(jasperReportViewer.getContentPane().getSize());
            dialog.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(SaveBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
