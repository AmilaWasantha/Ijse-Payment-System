/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.controller.custom;

import java.util.List;
import lk.ijse.ijsebillinsystem.controller.SuperController;
import lk.ijse.ijsebillinsystem.dto.PaymentDTO;
import lk.ijse.ijsebillinsystem.querydto.CalculateIncomeQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.FindPaymentOrNotQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.PaymentQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.PaymentQueryFindByCourseIdDTO;

/**
 *
 * @author user
 */
public interface PaymentController  extends SuperController<PaymentDTO, String>{
    List<PaymentQueryDTO>getPaymentQueryDetails(String ID, String status)throws Exception;
    
    public List<PaymentQueryFindByCourseIdDTO>getDetailsForPayment(String courseName,String studentID,String status)throws Exception;
    public List<FindPaymentOrNotQueryDTO>getAllDetailsForEachStudents(String sid,String courseName)throws Exception;
    public CalculateIncomeQueryDTO getIncomeForMonthlyPayment(String month,String year)throws Exception;
    public CalculateIncomeQueryDTO getIncomeForDailyPayment(String day,String month,String year)throws Exception;
    public CalculateIncomeQueryDTO getIncomeForYearly(String year)throws Exception;
}
