/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.viewcontroller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JDialog;
import lk.ijse.ijsebillinsystem.controller.ControllerFactory;
import lk.ijse.ijsebillinsystem.controller.custom.UserController;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author user
 */
public class DashboardController implements Initializable {

    private UserController userController;
    private String paymentType;

    @FXML
    private Label lableStudent;
    @FXML
    private Label lableCourse;
    @FXML
    private Label lableBatch;
    @FXML
    private Label lableLecture;
    @FXML
    private JFXButton btnAdmin;

    @FXML
    private AnchorPane MainPanal;
    @FXML
    private JFXButton btnMonthlyIncome;
    @FXML
    private JFXButton btnDailyIncome;
    @FXML
    private JFXButton btnPendinPayment;
    @FXML
    private JFXButton btnYearlyIncome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userController = (UserController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.USER);
        this.paymentType = "Half Payment";
        // TODO
    }

    @FXML
    private void buttonAdminAction(ActionEvent event) {
        LoadStages("/lk/ijse/ijsebillinsystem/view/Admin.fxml");
    }

    private void LoadStages(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            //stage.show();

            BoxBlur boxBlur = new BoxBlur();
            boxBlur.setIterations(2);
            MainPanal.setEffect(boxBlur);
            stage.showAndWait();

            boxBlur.setIterations(0);
            MainPanal.setEffect(boxBlur);
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void MonthlyIncomOnAction(ActionEvent event) {
        LoadStages("/lk/ijse/ijsebillinsystem/view/MonthlyIncome.fxml");

    }

    @FXML
    private void buttonDailyIncomeAction(ActionEvent event) {
        LoadStages("/lk/ijse/ijsebillinsystem/view/DailyIncom.fxml");
    }

    @FXML
    private void buttonPendinPaymentOnAction(ActionEvent event) throws JRException {
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(DashboardController.class.getResourceAsStream("/lk/ijse/ijsebillinsystem/jasperReport/PendinPayment.jasper"));
         HashMap<String, Object> parHashMap = new HashMap<>();
         parHashMap.put("halfPayment",this.paymentType);
        
        // JasperReport compiledReport = (JasperReport) JRLoader.loadObject(SaveBatchController.class.getResourceAsStream("/lk/ijse/ijsebillinsystem/jasperReport/allBatch.jasper"));
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

            JasperPrint fillledReport = JasperFillManager.fillReport(jasperReport, parHashMap, connection);
            
            JasperViewer jasperReportViewer = new JasperViewer(fillledReport);
            JDialog dialog = new JDialog();
            // jasperReportViewer.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
            dialog.setContentPane(jasperReportViewer.getContentPane());
            dialog.setSize(jasperReportViewer.getContentPane().getSize());
            dialog.setVisible(true);
    }

    @FXML
    private void buttonYerlyIncomeAction(ActionEvent event) {
        LoadStages("/lk/ijse/ijsebillinsystem/view/YearlyIncome.fxml");
    }

}
