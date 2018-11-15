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
public class DailyIncomController implements Initializable {
    private BatchRegistrationController batchRegistrationController;
    private PaymentController paymentController;
    private BatchTransferController batchTransferController;
    
    private double dailyRegistration;
    private double dailyPayment;
    private double dailyBatchTransfer;
    private String description;
    
    private double TotalOfDailyIncome;
    @FXML
    private JFXDatePicker datePicker;
    @FXML
    private JFXTextField txtDailyIncomeRegistration;
    @FXML
    private JFXTextField txtDailyIncomeBatchTransfer;
    @FXML
    private JFXTextField txtDailyIncomePayment;
    @FXML
    private JFXButton txtDailyPrintIncome;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        batchRegistrationController=(BatchRegistrationController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.BATCHREGISTRATIONCONTROLLER);
        paymentController=(PaymentController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.PAYMENTCONTROLLER);
        batchTransferController=(BatchTransferController) ControllerFactory.getInstance().getConnection(ControllerFactory.getControllerType.BATCHTRANSFERCONTROLLER);
        this.description="Income For Per Day";
        //txtDailyIncomeBatchTransfer.setVisible(false);
       // txtDailyIncomePayment.setVisible(false);
        //txtDailyIncomeRegistration.setVisible(false);
        // TODO
    }    

    @FXML
    private void datePickerAction(ActionEvent event) {
        try {
            String date=datePicker.getValue().toString();
            String [] split=date.split("-");
            String year=split[0];
            String month=split[1];
            String day=split[2];
            
            CalculateIncomeQueryDTO dto=paymentController.getIncomeForDailyPayment(day, month, year);
            if(dto!=null){
                this.dailyPayment=dto.getIncome();
                txtDailyIncomePayment.setText(Double.toString(dto.getIncome()));
                System.out.println("onna payment daily income eka awa"+dto.getIncome());
            }
            CalculateIncomeQueryDTO dto1=batchRegistrationController.getDailyIncomeByRegistration(day, month, year);
            if(dto1!=null){
                this.dailyRegistration=dto1.getIncome();
                txtDailyIncomeRegistration.setText(Double.toString(dto1.getIncome()));
                System.out.println("onna daily registration income ekath awa"+dto1.getIncome());
            }
            CalculateIncomeQueryDTO dto2=batchTransferController.getDailyIncomeByBatchTransfer(day, month, year);
            if(dto2!=null){
                this.dailyBatchTransfer=dto2.getIncome();
                txtDailyIncomeBatchTransfer.setText(Double.toString(dto2.getIncome()));
                System.out.println("onna daily batchtransfer ekath awa "+dto2.getIncome());
            }
            
            this.TotalOfDailyIncome=this.dailyBatchTransfer+this.dailyPayment+this.dailyRegistration;
            System.out.println("onna dawasatha okkoma income eka"+this.TotalOfDailyIncome);
        } catch (Exception ex) {
            Logger.getLogger(DailyIncomController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void pringDailyIncomeAction(ActionEvent event) throws JRException {
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(DailyIncomController.class.getResourceAsStream("/lk/ijse/ijsebillinsystem/jasperReport/DailyIncome.jasper"));

            HashMap<String, Object> parHashMap = new HashMap<>();
            parHashMap.put("dailyIncomeForRegistration",Double.toString(this.dailyRegistration));
            parHashMap.put("dailyIncomeForBatchTransfer",Double.toString(this.dailyBatchTransfer));
            parHashMap.put("dailyIncomeForPayment",Double.toString(this.dailyPayment));
            parHashMap.put("description",this.description);
            parHashMap.put("registration",Double.toString(this.dailyRegistration));
            parHashMap.put("batchTransfer",Double.toString(this.dailyBatchTransfer));
            parHashMap.put("payment",Double.toString(this.dailyPayment));
            parHashMap.put("total",Double.toString(this.TotalOfDailyIncome));
            
            
            

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
