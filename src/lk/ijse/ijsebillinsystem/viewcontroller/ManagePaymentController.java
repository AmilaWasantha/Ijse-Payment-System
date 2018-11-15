    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.viewcontroller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JDialog;
import lk.ijse.ijsebillinsystem.AutoGenarateID.IDGenetator;
import lk.ijse.ijsebillinsystem.controller.ControllerFactory;
import lk.ijse.ijsebillinsystem.controller.custom.PaymentController;
import lk.ijse.ijsebillinsystem.controller.custom.StudentController;
import lk.ijse.ijsebillinsystem.dto.PaymentDTO;
import lk.ijse.ijsebillinsystem.dto.StudentDTO;
import lk.ijse.ijsebillinsystem.querydto.FindPaymentOrNotQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.PaymentQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.PaymentQueryFindByCourseIdDTO;
import net.sf.jasperreports.engine.JREmptyDataSource;
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
public class ManagePaymentController implements Initializable {

    private int dateCount;
    final ToggleGroup group = new ToggleGroup();
    private StudentController studentController;
    private PaymentController paymentController;
    double fullPayAmount;
    int discount;
    int tax;
    int lateDiscount;
    double discountWithFullPayment;
    int latedescount;
    String radioValues;
    String paymentId;
    String pendinDate;
    String description;
    private String status;
    @FXML
    private AnchorPane MainPanal;
    @FXML
    private JFXTextField txtDate;
    @FXML
    private JFXTextField txtStudentName;
    @FXML
    private JFXTextField txtStudentNIC;
    @FXML
    private JFXTextField txtStudentID;
    @FXML
    private JFXRadioButton radioBtnFullPayment;
    @FXML
    private JFXRadioButton radioBtnHalfPayment;
    @FXML
    private JFXTextField txtFullPaymentFee;
    @FXML
    private JFXTextField txtDiscount;
    @FXML
    private JFXTextField txtTax;
    @FXML
    private JFXTextField txtLate;
    @FXML
    private JFXTextField txtCurrentPayment;
    @FXML
    private JFXTextField txtBalance;
    @FXML
    private TableView<?> tablePayment;
    @FXML
    private JFXButton btnMakePayment;
    @FXML
    private JFXButton btnUpdatePyment;
    @FXML
    private JFXTextField txtLateDate;
    @FXML
    private JFXButton btnPrintBill;
    @FXML
    private JFXComboBox<?> comboCourseName;
    @FXML
    private JFXCheckBox settleBalanceCheckBoxID;
    @FXML
    private JFXTextField txtSettleBalance;
    @FXML
    private JFXTextField txtTotalOfPayAmount;
    @FXML
    private JFXDatePicker txtPendinDate;
    @FXML
    private Label lableFullPayment;
    @FXML
    private JFXTextField txtCoursID;
    @FXML
    private JFXTextField txtBatchName;
    @FXML
    private JFXTextField txtBatchID;
    @FXML
    private JFXTextField txtPaymentDate;
    @FXML
    private JFXTextField txtRegistrationID;
    @FXML
    private JFXTextField txtPaymentID;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        studentController = (StudentController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.STUDENTCONTROLLER);
        paymentController = (PaymentController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.PAYMENTCONTROLLER);
        setCurrentDate();
        setCurrentDateToDatePicker();
        setTax();
        radioButtonGroup();
        this.status="Active";
        DateCount();
        setPaymentID();
        settleBalanceCheckBoxID.setVisible(false);
        lableFullPayment.setVisible(false);
        this.latedescount = 1;
        txtPaymentID.setVisible(false);

        txtPaymentDate.setEditable(true);
        //txtPendinDate.setShowWeekNumbers(true);
        txtPendinDate.setVisible(false);
        //txtPendinDate.setEditable(false);
        // TODO
    }

    @FXML
    private void ButtonMakaPaymentAction(ActionEvent event) {
        try {
            gatRadioValues();

            PaymentDTO paymentDTO = new PaymentDTO();
            paymentDTO.setPaymentId(paymentId);
            paymentDTO.setRegistrationId(txtRegistrationID.getText());
            paymentDTO.setBalance(txtBalance.getText());
            paymentDTO.setBatchId(txtBatchID.getText());
            paymentDTO.setBatchName(txtBatchName.getText());
            paymentDTO.setCourseId(txtCoursID.getText());
            paymentDTO.setCourseName(comboCourseName.getValue().toString());
            paymentDTO.setDiscount(txtDiscount.getText());
            paymentDTO.setFullPayment(Double.parseDouble(txtFullPaymentFee.getText()));
            paymentDTO.setPayAmount(txtCurrentPayment.getText());
            paymentDTO.setPaymentDate(txtDate.getText());
            paymentDTO.setPaymentPendinDAte(this.pendinDate);
            paymentDTO.setPaymentType(radioValues);
            paymentDTO.setStudentId(txtStudentID.getText());
            paymentDTO.setStudentName(txtStudentName.getText());

            System.out.println("Pendin payment : " + txtPendinDate.getValue().toString());

            boolean isAdded = paymentController.save(paymentDTO);
            if (isAdded) {
                Notifications notifications = Notifications.create()
                        .title("Payment Save successfully")
                        .text("payment Save successfully")
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
                setPaymentID();

            }
        } catch (Exception ex) {
            Logger.getLogger(ManagePaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ButtonUpdatePaymentAction(ActionEvent event) {
        try {
            String paymentType = "Full Payment";
            String paymentPendinDate = "Not Pendin Date";
            PaymentDTO paymentDTO = new PaymentDTO();
            paymentDTO.setPaymentId(txtPaymentID.getText());
            paymentDTO.setRegistrationId(txtRegistrationID.getText());
            paymentDTO.setStudentId(txtStudentID.getText());
            paymentDTO.setStudentName(txtStudentName.getText());
            paymentDTO.setCourseId(txtCoursID.getText());
            paymentDTO.setCourseName(comboCourseName.getValue().toString());
            paymentDTO.setBatchId(txtBatchID.getText());
            paymentDTO.setBatchName(txtBatchName.getText());
            paymentDTO.setFullPayment(Double.parseDouble(txtFullPaymentFee.getText()));
            paymentDTO.setPayAmount(txtTotalOfPayAmount.getText());
            paymentDTO.setBalance(txtBalance.getText());
            paymentDTO.setPaymentType(paymentType);
            paymentDTO.setPaymentDate(txtDate.getText());
            paymentDTO.setPaymentPendinDAte(paymentPendinDate);
            paymentDTO.setDiscount(txtDiscount.getText());

            boolean isUpdate = paymentController.update(paymentDTO);
            if (isUpdate) {
                Notifications notifications = Notifications.create()
                        .title("Payment Update")
                        .text("Payment Update successfully")
                        .graphic(new ImageView())
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.CENTER)
                        .onAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                            }
                        });

                notifications.darkStyle();
                notifications.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManagePaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void EnterMouseStudentNIC(MouseEvent event) {
        txtStudentID.setEditable(true);
        //JOptionPane.showMessageDialog(null, "Search Student");
    }

    @FXML
    private void studentNicPresedAction(KeyEvent event) {

    }

    private void setCurrentDate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        txtDate.setText(format.format(date));

        txtDate.setEditable(false);
        //LocalDate localDate=LocalDate.parse(format.format(date));
        //txtPendinDate.setValue(localDate);
        //txtPendinDate.setValue(LocalDate.of(format.format(date));
    }

    private void setTax() {
        txtTax.setText("2%");
        tax = 2;
    }

    private void radioButtonGroup() {
        radioBtnFullPayment.setToggleGroup(group);
        radioBtnFullPayment.setSelected(true);

        radioBtnHalfPayment.setToggleGroup(group);
        radioBtnHalfPayment.setSelected(true);
    }

    @FXML
    private void PressStudentIdAction(KeyEvent event) {
        try {
            String studentId = txtStudentID.getText();
            String status=this.status;
            System.out.println("statussssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"+status);
            List<PaymentQueryDTO> paymentQueryDTOs = paymentController.getPaymentQueryDetails(studentId,status);
            if (paymentQueryDTOs != null) {
                ObservableList list = FXCollections.observableArrayList();
                

                for (PaymentQueryDTO paymentQueryDTO : paymentQueryDTOs) {
                    System.out.println("onns course name tika balaganna : "+paymentQueryDTO.getCourseName());
                   
                    list.add(paymentQueryDTO.getCourseName());
                    comboCourseName.setItems(list);
                    txtStudentName.setText(paymentQueryDTO.getStudentName());
                    
             
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ManagePaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void rediohalfPaymentAction(ActionEvent event) {
        boolean isEmpty = txtPaymentDate.getText().isEmpty();
        if (isEmpty) {
            if (isEmpty) {
                Notifications notifications = Notifications.create()
                        .title("Check Payment Date")
                        .text("Please fill payment date and try again")
                        .graphic(new ImageView())
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.CENTER)
                        .onAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                            }
                        });

                notifications.darkStyle();
                notifications.show();
            }
        } else {
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
            if (radioBtnHalfPayment.isSelected()) {
                txtDiscount.setText("No discount");
                txtPendinDate.setVisible(true);

                this.pendinDate = txtPendinDate.getValue().toString();
                txtBalance.setText("Balance");
                dateCount();
                double fullFee = Double.parseDouble(txtFullPaymentFee.getText());
                double halfPayment = fullFee / 2;
                double taxWith = halfPayment * tax / 100;
                double halfPaymentTaxWith = halfPayment + taxWith;
                txtCurrentPayment.setText(Double.toString(halfPaymentTaxWith));
                txtCurrentPayment.requestFocus();
                txtBalance.setText(Double.toString(halfPayment));

                if (dateCount > 0) {
                    double halfpayment = Double.parseDouble(txtCurrentPayment.getText());

                    int sumOfLatePaymentAndTaxt = dateCount + tax;
                    double ExtraSumPayment = halfpayment * sumOfLatePaymentAndTaxt / 100;
                    double withLatePaymentAndTaxFullPayment = halfpayment + ExtraSumPayment;
                    System.out.println("late Payment : " + withLatePaymentAndTaxFullPayment);
                    txtCurrentPayment.setText(Double.toString(withLatePaymentAndTaxFullPayment));
                    txtBalance.setText(Double.toString(halfPayment));
                    txtDiscount.setText("No Discount");
                    txtLateDate.setText(Integer.toString(dateCount));
                }

            }
        }
    }

    @FXML
    private void radioFullPaymentAction(ActionEvent event) {
        try {
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
            if (radioBtnFullPayment.isSelected()) {

                boolean isEmpty = txtPaymentDate.getText().isEmpty();
                if (isEmpty) {
                    if (isEmpty) {
                        Notifications notifications = Notifications.create()
                                .title("Check Payment Date")
                                .text("Please fill payment date and try again")
                                .graphic(new ImageView())
                                .hideAfter(Duration.seconds(3))
                                .position(Pos.CENTER)
                                .onAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                    }
                                });

                        notifications.darkStyle();
                        notifications.show();
                    }
                } else {
                    txtPendinDate.setVisible(false);
                    String status=this.status;
                    this.pendinDate = "Not Pendin date";
                    String studentId = txtStudentID.getText();
                    List<PaymentQueryDTO> paymentQueryDTOs = paymentController.getPaymentQueryDetails(studentId,status);
                    if (paymentQueryDTOs != null) {
                        for (PaymentQueryDTO paymentQueryDTO : paymentQueryDTOs) {
                            //System.out.println("ddddddddddddddddddddddddddddddddddddd"+paymentQueryDTO.getDiscount());
                            txtDiscount.setText(paymentQueryDTO.getDiscount() + "%");
//                            if(paymentQueryDTO.getDiscount().equalsIgnoreCase("no discount")){
//                                System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj"+paymentQueryDTO.getDiscount());
//                            }
                            //if(paymentQueryDTO.getDiscount()==(String)(paymentQueryDTO.getDiscount())){
                               this.discount=0;
                            //}else{
                                this.discount=Integer.parseInt(paymentQueryDTO.getDiscount());
                           // }
                           // this.discount=Integer.parseInt(paymentQueryDTO.getDiscount());
                            dateCount();
                            calculateDiscount();

                        }
                    }
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(ManagePaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void calculateDiscount() {
        fullPayAmount = Double.parseDouble(txtFullPaymentFee.getText());
        // discount=Integer.parseInt(txtDiscount.getText());
        //tax=Integer.parseInt(txtTax.getText());
        //lateDiscount=Integer.parseInt(txtLate.getText());
        if (dateCount > 0) {
            double fullPayment = Double.parseDouble(txtFullPaymentFee.getText());
            int sumOfLatePaymentAndTaxt = dateCount + tax;
            double ExtraSumPayment = fullPayment * sumOfLatePaymentAndTaxt / 100;
            double withLatePaymentAndTaxFullPayment = fullPayment + ExtraSumPayment;
            System.out.println("late Payment : " + withLatePaymentAndTaxFullPayment);
            txtCurrentPayment.setText(Double.toString(withLatePaymentAndTaxFullPayment));
            txtBalance.setText("0.0");
            txtDiscount.setText("No Discount");
            txtLateDate.setText(Integer.toString(dateCount));

        } else {
            int sumOfDiscountAndTax = this.discount-this.tax;
            System.out.println("onna dan disocunt ekaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+sumOfDiscountAndTax);
            double payAmount = fullPayAmount * sumOfDiscountAndTax / 100;
            discountWithFullPayment = fullPayAmount - payAmount;
            txtCurrentPayment.setText(Double.toString(discountWithFullPayment));
            double lastBalance = fullPayAmount-fullPayAmount;
            txtBalance.setText(Double.toString(lastBalance));
            System.out.println("Last Payment : " + discountWithFullPayment);
        }
    }

    @FXML
    private void currentPaymentAction(KeyEvent event) {
        double fullFee = Double.parseDouble(txtFullPaymentFee.getText());
        double balance = fullFee / 2;
        //double halfPayment=Double.parseDouble(txtCurrentPayment.getText());
        //double calculateBalance=fullFee-halfPayment;
        txtBalance.setText(Double.toString(balance));
    }

    private void DateCount() {

    }

    private void dateCount() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        String inputString1 = txtPaymentDate.getText();
        String inputString2 = txtDate.getText();

        try {
            Date date1 = myFormat.parse(inputString1);
            Date date2 = myFormat.parse(inputString2);
            long diff = date2.getTime() - date1.getTime();
            System.out.println("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));

            dateCount = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            System.out.println("result of date Count : " + dateCount);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void setPaymentID() {
        try {
            String newId = IDGenetator.getNewId("payment", " PAYMENT_ID", "P", 2);
            paymentId = newId;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagePaymentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagePaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void gatRadioValues() {
        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        radioValues = selectedRadioButton.getText();
    }

    @FXML
    private void buttonPrintPaymentBill(ActionEvent event) {
//        setDateToPrintBill();
//        
//        LoadStages("/lk/ijse/ijsebillinsystem/view/PrintPayment.fxml");

        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(ManagePaymentController.class.getResourceAsStream("/lk/ijse/ijsebillinsystem/jasperReport/payment.jasper"));

            HashMap<String, Object> parHashMap = new HashMap<>();
            parHashMap.put("Date",txtDate.getText() );
            parHashMap.put("Nic", txtStudentNIC.getText());
            parHashMap.put("StudentName", txtStudentName.getText());
            parHashMap.put("Batch", txtBatchName.getText());
            parHashMap.put("CommercingDate",txtPaymentDate.getText());
            parHashMap.put("Course Name", comboCourseName.getValue().toString());
            parHashMap.put("Description", this.description);
            parHashMap.put("TOTAL RECEIPT AMOUNT", txtFullPaymentFee.getText());
            parHashMap.put("discount", txtDiscount.getText());
            parHashMap.put("Amount", txtCurrentPayment.getText());
            parHashMap.put("Total ",txtCurrentPayment.getText());
            parHashMap.put("TOTAL RECEIPT AMOUNT", txtCurrentPayment.getText());
            parHashMap.put("AMOUNT RECEIVED", txtCurrentPayment.getText());
            parHashMap.put("BALANCE AMOUNT", txtBalance.getText());
            parHashMap.put("DUE DATE OF BALANCE", txtPendinDate.getValue().toString());
            

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parHashMap, new JREmptyDataSource());
            JasperViewer jasperViewer = new JasperViewer(jasperPrint);
            java.awt.Container container = jasperViewer.getContentPane();

            JDialog jDialog = new JDialog();
            jDialog.setContentPane(container);
            jDialog.setSize(jasperViewer.getSize());
            jDialog.setLocationRelativeTo(null);
            jDialog.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ManagePaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(ManagePaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void StudentNicAction(ActionEvent event) {
        try {
            String nic = txtStudentNIC.getText();
            StudentDTO studentDTO = studentController.find(nic);
            if (studentDTO != null) {
                txtStudentID.setText(studentDTO.getStudentId());

                //txtStudentID.requestFocus();
                txtStudentID.setEditable(false);
            }
        } catch (Exception ex) {
            Logger.getLogger(ManagePaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void comboCourseNameAction(ActionEvent event) {
        getDetailsForPayment();
    }


    private void getDetailsForPayment() {
        try {
            String studentID = txtStudentID.getText();
            String courseId = txtCoursID.getText();
            String courseName = (String) comboCourseName.getValue();
            String status=this.status;
//            
            List<FindPaymentOrNotQueryDTO> paymentDTOs = paymentController.getAllDetailsForEachStudents(studentID, courseName);
            if (paymentDTOs != null) {
                btnMakePayment.setVisible(false);
                btnUpdatePyment.setVisible(true);
                radioBtnFullPayment.setVisible(false);
                radioBtnHalfPayment.setVisible(false);
                settleBalanceCheckBoxID.setVisible(true);
                //txtPendinDate.setVisible(false);

                txtPaymentID.setVisible(true);
                
                for (FindPaymentOrNotQueryDTO paymentDTO : paymentDTOs) {
                    txtStudentName.setText(paymentDTO.getStudentName());
                    
                    
                    txtCoursID.setText(paymentDTO.getCourseId());
                    txtBatchID.setText(paymentDTO.getBatchId());
                    txtBatchName.setText(paymentDTO.getBatchName());
                    txtPaymentDate.setText(paymentDTO.getPaymentPendinDAte());
                    txtRegistrationID.setText(paymentDTO.getRegistrationId());
                    txtPaymentID.setText(paymentDTO.getPaymentId());

                    
                    
                    txtFullPaymentFee.setText(Double.toString(paymentDTO.getFullPayment()));
                    txtDiscount.setText(paymentDTO.getDiscount());
                    txtCurrentPayment.setText(paymentDTO.getPayAmount());
                    txtBalance.setText(paymentDTO.getBalance());
                    txtLate.setText(Integer.toString(this.latedescount) + "%");

                    if (paymentDTO.getPaymentType().equalsIgnoreCase("Half Payment")) {
                        
                        description="Half Payment";
                        radioBtnFullPayment.setVisible(false);
                        //txtPendinDate.setVisible(true);
                        radioBtnFullPayment.setVisible(false);
                        txtSettleBalance.setVisible(true);
                        txtTotalOfPayAmount.setVisible(true);
                        lableFullPayment.setVisible(false);

                        Notifications notifications = Notifications.create()
                                .title("About payment")
                                .text("You settle the Half Payment")
                                .graphic(new ImageView())
                                .hideAfter(Duration.seconds(3))
                                .position(Pos.TOP_CENTER)
                                .onAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                    }
                                });

                        notifications.darkStyle();
                        notifications.show();

                        settleBalanceCheckBoxID.setVisible(true);

                    } else if (paymentDTO.getPaymentType().equalsIgnoreCase("Full Payment")) {
                        description="Full Payment";
                        radioBtnFullPayment.setVisible(false);
                        txtPendinDate.setVisible(false);
                        radioBtnHalfPayment.setVisible(false);
                        txtSettleBalance.setVisible(false);
                        txtTotalOfPayAmount.setVisible(false);
                        lableFullPayment.setVisible(true);
                        settleBalanceCheckBoxID.setVisible(false);

                        Notifications notifications = Notifications.create()
                                .title("About payment")
                                .text("You settle The full Payment")
                                .graphic(new ImageView())
                                .hideAfter(Duration.seconds(3))
                                .position(Pos.TOP_CENTER)
                                .onAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                    }
                                });

                        notifications.darkStyle();
                        notifications.show();
                    }


                }
            } else {
                lableFullPayment.setVisible(false);

                Notifications notifications = Notifications.create()
                        .title("About payment")
                        .text("Not Payment Yet")
                        .graphic(new ImageView())
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.TOP_CENTER)
                        .onAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                            }
                        });

                notifications.darkStyle();
                notifications.show();

                System.out.println("onnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnna wada kara");
                List<PaymentQueryFindByCourseIdDTO> details = paymentController.getDetailsForPayment(courseName, studentID,status);
                if (details != null) {
                    btnMakePayment.setVisible(true);
                    btnUpdatePyment.setVisible(false);
                    settleBalanceCheckBoxID.setVisible(false);
                    txtSettleBalance.setVisible(false);
                    txtTotalOfPayAmount.setVisible(false);
                    radioBtnFullPayment.setVisible(true);
                    radioBtnHalfPayment.setVisible(true);
                    
                    for (PaymentQueryFindByCourseIdDTO detail : details) {
                        
                        //comboCourseName.setItems(list);
                        txtCoursID.setText(detail.getCourseId());
                        txtBatchID.setText(detail.getBathcID());
                        txtBatchName.setText(detail.getBatchName());
                        txtPaymentDate.setText(detail.getBatchStartDate());
                        txtRegistrationID.setText(detail.getRegisterID());
                       
                        txtFullPaymentFee.setText(Double.toString(detail.getCourseFee()));
                        txtDiscount.setText(detail.getDiscount());
                        System.out.println("111111111111111111111111111111111111111111111111111111111"+detail.getDiscount());
                        txtLate.setText(detail.getLatePayment() + "%");
                        txtCurrentPayment.setText("Pay Amount");
                        txtBalance.setText("Balance");
                        txtLateDate.setText("Late Dates");
                        this.lateDiscount = Integer.parseInt(detail.getLatePayment());

                        if (radioBtnFullPayment.isSelected()) {
                            txtPendinDate.setVisible(true);
                        }

//                  
                      
                    }

                }
            }
            System.out.println("course Id kdlfkdlsfakla" + courseId);
        } catch (Exception ex) {
            Logger.getLogger(ManagePaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setCurrentDateToDatePicker() {

        String date = new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        txtPendinDate.setValue(localDate);

    }


    @FXML
    private void settleBalanceCheckBoxAction(ActionEvent event) {
        if (settleBalanceCheckBoxID.isSelected()) {
            txtPendinDate.setVisible(false);
            if (txtPaymentDate.getText().isEmpty()) {
                Notifications notifications = Notifications.create()
                        .title("Check Payment Date")
                        .text("Please fill payment date")
                        .graphic(new ImageView())
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.CENTER)
                        .onAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                            }
                        });

                notifications.darkStyle();
                notifications.show();
            } else {
                dateCount();
                calculateSettleBalance();
            }
        }
    }

    private void calculateSettleBalance() {
        this.fullPayAmount = Double.parseDouble(txtBalance.getText());
        if (this.dateCount > 0) {
            double balannce = Double.parseDouble(txtBalance.getText());
            int sumOfLateAndTax = tax + dateCount;
            double extraPayment = balannce * sumOfLateAndTax / 100;
            double fullPayment = balannce + extraPayment;
            txtSettleBalance.setText(Double.toString(fullPayment));
            txtBalance.setText("0.00");

            double BeforePayAmount = Double.parseDouble(txtCurrentPayment.getText());
            double afterPayment = Double.parseDouble(txtSettleBalance.getText());
            double TotalOfAllPayment = BeforePayAmount + afterPayment;
            txtTotalOfPayAmount.setText(Double.toString(TotalOfAllPayment));

        } else {
            double balannce = Double.parseDouble(txtBalance.getText());
            int sumOfLateAndTax = tax;
            double extraPayment = balannce * sumOfLateAndTax / 100;
            double fullPayment = balannce + extraPayment;
            txtSettleBalance.setText(Double.toString(fullPayment));
            txtBalance.setText("0.00");

            double BeforePayAmount = Double.parseDouble(txtCurrentPayment.getText());
            double afterPayment = Double.parseDouble(txtSettleBalance.getText());
            double TotalOfAllPayment = BeforePayAmount + afterPayment;
            txtTotalOfPayAmount.setText(Double.toString(TotalOfAllPayment));
        }
    }

}
