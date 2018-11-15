/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.viewcontroller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.JDialog;
import lk.ijse.ijsebillinsystem.controller.ControllerFactory;
import lk.ijse.ijsebillinsystem.controller.custom.BatchRegistrationController;
import lk.ijse.ijsebillinsystem.controller.custom.BatchTransferController;
import lk.ijse.ijsebillinsystem.controller.custom.PaymentController;
import lk.ijse.ijsebillinsystem.querydto.CalculateIncomeQueryDTO;
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
public class YearlyIncomeController implements Initializable {
    private PaymentController paymentController;
    private BatchRegistrationController batchRegistrationController;
    private BatchTransferController batchTransferController;
    private double yearlyPaymentIncome;
    private double YearlyRegistrationIncome;
    private double YearlyBatchTransferIncome;
    private double TotalOfYearlyIncome;
    private String description;

    @FXML
    private JFXDatePicker datePicker;
    @FXML
    private JFXTextField txtYearlyIncomeRegistration;
    @FXML
    private JFXTextField txtYearlyIncomeBatchTransfer;
    @FXML
    private JFXTextField txtYearlyIncomeBatchPayment;
    @FXML
    private JFXButton btnPrintYearlyIncom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        batchRegistrationController=(BatchRegistrationController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.BATCHREGISTRATIONCONTROLLER);
        batchTransferController=(BatchTransferController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.BATCHTRANSFERCONTROLLER);
        paymentController=(PaymentController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.PAYMENTCONTROLLER);
        this.description="Yearly Income";
        // TODO
    }    

    @FXML
    private void datePickerAction(ActionEvent event) {
        try {
            String date=datePicker.getValue().toString();
            String [] split=date.split("-");
            String year=split[0];
            
            CalculateIncomeQueryDTO dto=paymentController.getIncomeForYearly(year);
            if(dto!=null){
                this.yearlyPaymentIncome=dto.getIncome();
                txtYearlyIncomeBatchPayment.setText(Double.toString(dto.getIncome()));
            }
            CalculateIncomeQueryDTO dt01=batchRegistrationController.getYearlyIncome(year);
            if(dt01!=null){
                this.YearlyRegistrationIncome=dt01.getIncome();
                txtYearlyIncomeRegistration.setText(Double.toString(dt01.getIncome()));
            }
            CalculateIncomeQueryDTO dto3=batchTransferController.getYearlyIncome(year);
            if(dto3!=null){
                this.YearlyBatchTransferIncome=dto3.getIncome();
                txtYearlyIncomeBatchTransfer.setText(Double.toString(dto3.getIncome()));
            }
            
            this.TotalOfYearlyIncome=this.YearlyBatchTransferIncome+this.YearlyRegistrationIncome+this.yearlyPaymentIncome;
        } catch (Exception ex) {
            Logger.getLogger(YearlyIncomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void buttonPringYearlyIncomeBillAction(ActionEvent event) throws JRException {
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(YearlyIncomeController.class.getResourceAsStream("/lk/ijse/ijsebillinsystem/jasperReport/YearlyIncome.jasper"));

            HashMap<String, Object> parHashMap = new HashMap<>();
            parHashMap.put("YearlyIncomeForRegistration",Double.toString(this.YearlyRegistrationIncome));
            parHashMap.put("YearlyIncomeForBatchTransfer",Double.toString(this.YearlyBatchTransferIncome));
            parHashMap.put("YearlyIncomeForPayment",Double.toString(this.yearlyPaymentIncome));
            parHashMap.put("Description",this.description);
            parHashMap.put("Registration",Double.toString(this.YearlyRegistrationIncome));
            parHashMap.put("BatchTransfer",Double.toString(this.YearlyBatchTransferIncome));
            parHashMap.put("Payment",Double.toString(this.yearlyPaymentIncome));
            parHashMap.put("TotalOfIncome",Double.toString(this.TotalOfYearlyIncome));
            
            
            
            
            

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parHashMap, new JREmptyDataSource());
            JasperViewer jasperViewer = new JasperViewer(jasperPrint);
            java.awt.Container container = jasperViewer.getContentPane();

            JDialog jDialog = new JDialog();
            jDialog.setContentPane(container);
            jDialog.setSize(jasperViewer.getSize());
            jDialog.setLocationRelativeTo(null);
            jDialog.setVisible(true);
    }
    
}
