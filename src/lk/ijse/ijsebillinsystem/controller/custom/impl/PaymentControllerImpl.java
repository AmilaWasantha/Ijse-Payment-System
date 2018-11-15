/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.controller.custom.impl;

import java.util.List;
import lk.ijse.ijsebillinsystem.controller.custom.PaymentController;
import lk.ijse.ijsebillinsystem.dto.PaymentDTO;
import lk.ijse.ijsebillinsystem.querydto.CalculateIncomeQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.FindPaymentOrNotQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.PaymentQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.PaymentQueryFindByCourseIdDTO;
import lk.ijse.ijsebillinsystem.service.ServiceFactory;
import lk.ijse.ijsebillinsystem.service.custom.PaymentService;

/**
 *
 * @author user
 */
public class PaymentControllerImpl implements PaymentController{
    
    private PaymentService paymentService;

    public PaymentControllerImpl() {
        paymentService=(PaymentService) ServiceFactory.getInstance().getConnection(ServiceFactory.getServiceType.PAYMENTSERVICE);
    }
    
    

    @Override
    public boolean save(PaymentDTO paymentDTO) throws Exception {
        return paymentService.save(paymentDTO);
    }

    @Override
    public boolean update(PaymentDTO paymentDTO) throws Exception {
        return paymentService.update(paymentDTO);
    }

    @Override
    public boolean delete(PaymentDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PaymentDTO find(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PaymentDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PaymentQueryDTO> getPaymentQueryDetails(String ID,String status) throws Exception {
        List<PaymentQueryDTO>paymentQueryDTOs=paymentService.getPaymentQueryDetails(ID,status);
        return paymentQueryDTOs;
        }

    @Override
    public List<PaymentQueryFindByCourseIdDTO> getDetailsForPayment(String courseName, String studentID,String status) throws Exception {
        List<PaymentQueryFindByCourseIdDTO>details=paymentService.getDetailsForPayment(courseName, studentID,status);
        if(details!=null){
            return details;
        }else{
            return null;
        }
    }

    @Override
    public List<FindPaymentOrNotQueryDTO> getAllDetailsForEachStudents(String sid,String courseName) throws Exception {
        List<FindPaymentOrNotQueryDTO>paymentDTOs=paymentService.getAllDetailsForEachStudents(sid,courseName);
        if(paymentDTOs!=null){
            return paymentDTOs;
        }else{
            return null;
        }
    }

    @Override
    public CalculateIncomeQueryDTO getIncomeForMonthlyPayment(String month, String year) throws Exception {
        CalculateIncomeQueryDTO dto=paymentService.getIncomeForMonthlyPayment(month, year);
        if(dto!=null){
            return dto;
        }else{
            return null;
        }
    }

    @Override
    public CalculateIncomeQueryDTO getIncomeForDailyPayment(String day, String month, String year) throws Exception {
        CalculateIncomeQueryDTO dto=paymentService.getIncomeForDailyPayment(day, month, year);
        if(dto!=null){
            return dto;
        }else{
            return null;
        }
    }

    @Override
    public CalculateIncomeQueryDTO getIncomeForYearly(String year) throws Exception {
        CalculateIncomeQueryDTO dto=paymentService.getIncomeForYearly(year);
        if(dto!=null){
            return dto;
        }else{
            return null;
        }
    }
    
}
