/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.ijsebillinsystem.conncetion.DBFactory;
import lk.ijse.ijsebillinsystem.dao.custom.PaymentDAO;
import lk.ijse.ijsebillinsystem.dto.PaymentDTO;
import lk.ijse.ijsebillinsystem.querydto.CalculateIncomeQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.FindPaymentOrNotQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.PaymentQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.PaymentQueryFindByCourseIdDTO;

/**
 *
 * @author user
 */
public class PaymentDAOImpl implements PaymentDAO{
    
    private Connection connection;

    public PaymentDAOImpl() {
        connection=DBFactory.getInstance().getConnection(DBFactory.connectionType.DBCONNECTION).getConnection();
    }
    
    

    @Override
    public boolean save(PaymentDTO dto) throws Exception {
        Statement stm=connection.createStatement();
        int res=stm.executeUpdate("insert into payment values('"+dto.getPaymentId()+"','"+dto.getRegistrationId()+"','"+dto.getStudentId()+"','"+dto.getStudentName()+"','"+dto.getCourseId()+"','"+dto.getCourseName()+"','"+dto.getBatchId()+"','"+dto.getBatchName()+"','"+dto.getFullPayment()+"','"+dto.getPayAmount()+"','"+dto.getBalance()+"','"+dto.getPaymentType()+"','"+dto.getPaymentDate()+"','"+dto.getPaymentPendinDAte()+"','"+dto.getDiscount()+"')");
        if(res>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(PaymentDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(PaymentDTO dto) throws Exception {
        Statement stm=connection.createStatement();
        int res=stm.executeUpdate("update payment set REGISTRATION_ID='"+dto.getRegistrationId()+"',STUDENT_ID='"+dto.getStudentId()+"', STUDENT_NAME='"+dto.getStudentName()+"',COURSE_ID='"+dto.getCourseId()+"',COURSE_NAME='"+dto.getCourseId()+"',COURSE_NAME='"+dto.getCourseName()+"',BATCH_ID='"+dto.getBatchId()+"',BATCH_NAME='"+dto.getBatchName()+"',FULL_AMOUNT='"+dto.getFullPayment()+"',PAY_AMOUNT='"+dto.getPayAmount()+"',BALANCE='"+dto.getBalance()+"',PAYMENT_TYPE='"+dto.getPaymentType()+"',PAYMENT_DATE='"+dto.getPaymentDate()+"',PAYMENT_PENDING_DATE='"+dto.getPaymentPendinDAte()+"',DISCOUNT='"+dto.getDiscount()+"' where PAYMENT_ID='"+dto.getPaymentId()+"'");
        if(res>0){
            return true;
        }else{
            return false;
        }
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
        List<PaymentQueryDTO>paymentQueryDTOs=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select s.STUDENT_ID, s.NAME_WITH_INITIAL, r.REGISTRATION_ID,cb.BATCH_ID,cb.DATE,cb.BATCH_NAME, c.COURSE_Name,c.COURSE_ID,c.COURSE_FEE,c.DISCOUNT,c.LATEPAYMENT from student s,batch b, course_batch cb,course c,registration r where r.STUDENT_ID=s.STUDENT_ID AND s.STUDENT_ID='"+ID+"' AND r.BATCH_ID=b.BATCH_ID AND cb.BATCH_ID=b.BATCH_ID AND cb.COURSE_ID=c.COURSE_ID AND r.STATUS='"+status+"'");
        while(rst.next()){
            if(paymentQueryDTOs==null){
               paymentQueryDTOs=new ArrayList<>();
            }
             PaymentQueryDTO paymentQueryDTO=new PaymentQueryDTO(rst.getString(1), rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8),rst.getDouble(9),rst.getString(10),rst.getString(11));
             paymentQueryDTOs.add(paymentQueryDTO);
        }
        return paymentQueryDTOs;
        
      
    }

    @Override
    public List<PaymentQueryFindByCourseIdDTO> getDetailsForPayment(String courseName, String studentID,String status) throws Exception {
        List<PaymentQueryFindByCourseIdDTO>details=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select s.STUDENT_ID, s.NAME_WITH_INITIAL, r.REGISTRATION_ID,cb.BATCH_ID,r.BATCH_START_DATE,cb.BATCH_NAME, c.COURSE_Name,c.COURSE_ID,c.COURSE_FEE,c.DISCOUNT,c.LATEPAYMENT from student s,batch b, course_batch cb,course c,registration r where cb.COURSE_ID=c.COURSE_ID AND c.COURSE_Name='"+courseName+"' AND r.BATCH_ID=b.BATCH_ID AND cb.BATCH_ID=b.BATCH_ID  AND r.STUDENT_ID=s.STUDENT_ID AND s.STUDENT_ID='"+studentID+"' AND r.STATUS='"+status+"'");
        while(rst.next()){
            if(details==null){
                details=new ArrayList<>();
            }
            PaymentQueryFindByCourseIdDTO dto=new PaymentQueryFindByCourseIdDTO(rst.getString(1), rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8),rst.getDouble(9),rst.getString(10),rst.getString(11));
            details.add(dto);
        }
        return details;
    }

    @Override
    public List<FindPaymentOrNotQueryDTO> getAllDetailsForEachStudents(String sid,String courseName) throws Exception {
        List<FindPaymentOrNotQueryDTO>paymentDTOs=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select p.PAYMENT_ID,p.REGISTRATION_ID, p.STUDENT_ID,p.STUDENT_NAME,p.COURSE_ID ,p.COURSE_NAME,p.BATCH_ID,p.BATCH_NAME,p.FULL_AMOUNT,p.PAY_AMOUNT,p.BALANCE,p.PAYMENT_TYPE,p.PAYMENT_PENDING_DATE,p.DISCOUNT from payment p where p.STUDENT_ID='"+sid+"' AND p.COURSE_NAME='"+courseName+"'");
        while(rst.next()){
            if(paymentDTOs==null){
                paymentDTOs=new ArrayList<>();
            }
            FindPaymentOrNotQueryDTO dto=new FindPaymentOrNotQueryDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8),rst.getDouble(9), rst.getString(10), rst.getString(11), rst.getString(12), rst.getString(13), rst.getString(14));
            paymentDTOs.add(dto);
        }
        return paymentDTOs;
    }

    @Override
    public boolean updateAfterBatchTransferStudent(PaymentDTO paymentDTO) throws Exception {
       Statement stm= connection.createStatement();
       int res=stm.executeUpdate("update payment set REGISTRATION_ID='"+paymentDTO.getRegistrationId()+"' , BATCH_ID='"+paymentDTO.getBatchId()+"', BATCH_NAME='"+paymentDTO.getBatchName()+"',PAYMENT_PENDING_DATE='"+paymentDTO.getPaymentPendinDAte()+"' where PAYMENT_ID='"+paymentDTO.getPaymentId()+"'");
       if(res>0){
           return true;
       }else{
           return false;
       }
    }

    @Override
    public CalculateIncomeQueryDTO getIncomeForMonthlyPayment(String month, String year) throws Exception {
        CalculateIncomeQueryDTO dto=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select sum(PAY_AMOUNT) as income from payment where month(PAYMENT_DATE)='"+month+"' AND year(PAYMENT_DATE)='"+year+"';");
        while(rst.next()){
            dto=new CalculateIncomeQueryDTO(rst.getDouble(1));
        }
        return dto;
    }

    @Override
    public CalculateIncomeQueryDTO getIncomeForDailyPayment(String day, String month, String year) throws Exception {
        CalculateIncomeQueryDTO dto=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select sum(PAY_AMOUNT) as income from payment where day(PAYMENT_DATE)='"+day+"' AND month(PAYMENT_DATE)='"+month+"' AND year(PAYMENT_DATE)='"+year+"'");
        while(rst.next()){
            dto=new CalculateIncomeQueryDTO(rst.getDouble(1));
        }
        return dto;
    }

    @Override
    public CalculateIncomeQueryDTO getIncomeForYearly(String year) throws Exception {
        CalculateIncomeQueryDTO dto=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select sum(PAY_AMOUNT) as income from payment where year(PAYMENT_DATE)='"+year+"'");
        while(rst.next()){
            dto=new CalculateIncomeQueryDTO(rst.getDouble(1));
            
        }
        return dto;
    }
    
}
