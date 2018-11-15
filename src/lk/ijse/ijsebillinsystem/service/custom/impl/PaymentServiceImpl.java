/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.service.custom.impl;

import java.util.List;
import lk.ijse.ijsebillinsystem.dao.DAOFactory;
import lk.ijse.ijsebillinsystem.dao.custom.PaymentDAO;
import lk.ijse.ijsebillinsystem.dto.PaymentDTO;
import lk.ijse.ijsebillinsystem.querydto.CalculateIncomeQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.FindPaymentOrNotQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.PaymentQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.PaymentQueryFindByCourseIdDTO;
import lk.ijse.ijsebillinsystem.service.custom.PaymentService;

/**
 *
 * @author user
 */
public class PaymentServiceImpl implements PaymentService{
    private PaymentDAO paymentDAO;

    public PaymentServiceImpl() {
        paymentDAO=(PaymentDAO) DAOFactory.getInstance().getConnection(DAOFactory.DAOType.PAYMENTDAO);
    }
    
    

    @Override
    public boolean save(PaymentDTO paymentDTO) throws Exception {
        return paymentDAO.save(paymentDTO);
    }

    @Override
    public boolean delete(PaymentDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(PaymentDTO paymentDTO) throws Exception {
        return paymentDAO.update(paymentDTO);
    }

    @Override
    public PaymentDTO find(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PaymentDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PaymentQueryDTO> getPaymentQueryDetails(String ID,String status) throws Exception {
        List<PaymentQueryDTO>paymentQueryDTOs=paymentDAO.getPaymentQueryDetails(ID,status);
        return paymentQueryDTOs;
    }

    @Override
    public List<PaymentQueryFindByCourseIdDTO> getDetailsForPayment(String courseName, String studentID,String status) throws Exception {
        List<PaymentQueryFindByCourseIdDTO>details=paymentDAO.getDetailsForPayment(courseName, studentID,status);
        if(details!=null){
            return details;
        }else{
            return null;
        }
    }

    @Override
    public List<FindPaymentOrNotQueryDTO> getAllDetailsForEachStudents(String sid,String courseName) throws Exception {
        List<FindPaymentOrNotQueryDTO>paymentDTOs=paymentDAO.getAllDetailsForEachStudents(sid,courseName);
        if(paymentDTOs!=null){
            return paymentDTOs;
        }else{
            return null;
        }
    }

    @Override
    public CalculateIncomeQueryDTO getIncomeForMonthlyPayment(String month, String year) throws Exception {
        CalculateIncomeQueryDTO dto=paymentDAO.getIncomeForMonthlyPayment(month, year);
        if(dto!=null){
            return dto;
        }else{
            return null;
        }
    }

    @Override
    public CalculateIncomeQueryDTO getIncomeForDailyPayment(String day, String month, String year) throws Exception {
        CalculateIncomeQueryDTO dto=paymentDAO.getIncomeForDailyPayment(day, month, year);
        if(dto!=null){
            return dto;
        }else{
            return null;
        }
    }

    @Override
    public CalculateIncomeQueryDTO getIncomeForYearly(String year) throws Exception {
        CalculateIncomeQueryDTO dto=paymentDAO.getIncomeForYearly(year);
        if(dto!=null){
            return dto;
        }else{
            return null;
        }
    }
    
}
