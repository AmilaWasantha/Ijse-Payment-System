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
public class MonthlyIncomeController implements Initializable {
    
    private BatchRegistrationController registrationController;
    private PaymentController paymentController;
    private BatchTransferController batchTransferController;
    private double monthlyRegistrationIncom;
    private double monthlyPaymentIncome;
    private double monthlyTransferIncome;
    private double TotalIncomePerMonth;
    private String description;

    @FXML
    private JFXDatePicker datePicker;
    @FXML
    private JFXTextField txtMonthlyIncomeRegistration;
    @FXML
    private JFXTextField txtMonthlyIncomeBatchTransfer;
    @FXML
    private JFXTextField txtMonthlyIncomePayment;
    @FXML
    private JFXButton btnPringMonthlyIncom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        registrationController=(BatchRegistrationController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.BATCHREGISTRATIONCONTROLLER);
        paymentController=(PaymentController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.PAYMENTCONTROLLER);
        batchTransferController=(BatchTransferController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.BATCHTRANSFERCONTROLLER);
        this.description="Income For Per Month";
        //txtMonthlyIncomeBatchTransfer.setVisible(false);
        //txtMonthlyIncomePayment.setVisible(false);
        //txtMonthlyIncomeRegistration.setVisible(false);
// TODO
    }    

    @FXML
    private void datePickerAction(ActionEvent event) {
        try {
            String date=datePicker.getValue().toString();
            String[] split = date.split("-");
            String year=split[0];
            String month=split[1];
            String day=split[2];
            
            CalculateIncomeQueryDTO dto=registrationController.getIncomeForMonth(month, year);
            if(dto!=null){
                this.monthlyRegistrationIncom=dto.getIncome();
                txtMonthlyIncomeRegistration.setText(Double.toString(dto.getIncome()));
                
                System.out.println("onna registration income eka"+dto.getIncome());
           }
            
            CalculateIncomeQueryDTO  dto1=paymentController.getIncomeForMonthlyPayment(month, year);
            if(dto1!=null){
                this.monthlyPaymentIncome=dto1.getIncome();
                txtMonthlyIncomePayment.setText(Double.toString(dto1.getIncome()));
                System.out.println("onna payment income eka"+dto1.getIncome());
            }
            CalculateIncomeQueryDTO dto2=batchTransferController.getIncomeForBatchTransferFee(month, year);
            if(dto2!=null){
                this.monthlyTransferIncome=dto2.getIncome();
                txtMonthlyIncomeBatchTransfer.setText(Double.toString(dto2.getIncome()));
                System.out.println("onna transfer income eka awa "+dto2.getIncome());
            }
            
            this.TotalIncomePerMonth=this.monthlyPaymentIncome+this.monthlyRegistrationIncom+this.monthlyTransferIncome;
            System.out.println("onna okkoma incom eka per month"+this.TotalIncomePerMonth);
            
        } catch (Exception ex) {
            Logger.getLogger(MonthlyIncomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    @FXML
    private void pringMonthlyIncomeAction(ActionEvent event) {
        
        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(MonthlyIncomeController.class.getResourceAsStream("/lk/ijse/ijsebillinsystem/jasperReport/monthlyIncome.jasper"));

            HashMap<String, Object> parHashMap = new HashMap<>();
            parHashMap.put("IncomeOfRegistration",Double.toString(this.monthlyRegistrationIncom));
            parHashMap.put("IncomeOfBatchTransfer",Double.toString(this.monthlyTransferIncome));
            parHashMap.put("IncomeOfPayment",Double.toString(this.monthlyPaymentIncome));
            parHashMap.put("description",this.description);
            parHashMap.put("registration",Double.toString( this.monthlyRegistrationIncom));
            parHashMap.put("batchtransfer",Double.toString(this.monthlyTransferIncome));
            parHashMap.put("payment",Double.toString( this.monthlyPaymentIncome));
            parHashMap.put("TotalOfIncome",Double.toString( this.TotalIncomePerMonth));
            
            
            

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parHashMap, new JREmptyDataSource());
            JasperViewer jasperViewer = new JasperViewer(jasperPrint);
            java.awt.Container container = jasperViewer.getContentPane();

            JDialog jDialog = new JDialog();
            jDialog.setContentPane(container);
            jDialog.setSize(jasperViewer.getSize());
            jDialog.setLocationRelativeTo(null);
            jDialog.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(MonthlyIncomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
