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
import lk.ijse.ijsebillinsystem.dao.custom.BatchTransferDAO;
import lk.ijse.ijsebillinsystem.dto.BatchDTO;
import lk.ijse.ijsebillinsystem.dto.BatchTransferDTO;
import lk.ijse.ijsebillinsystem.querydto.BatchTransferQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.CalculateIncomeQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.CheckPaymentForTransferStudentQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.GetBatchDetailsForTransferQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.GetNotStartBatchForTranserStudentQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.GetStudentDetailsForTransferQueryDTO;

/**
 *
 * @author user
 */
public class BatchTransferDAOImpl implements BatchTransferDAO{
    
    private Connection connection;

    public BatchTransferDAOImpl() {
        connection=DBFactory.getInstance().getConnection(DBFactory.connectionType.DBCONNECTION).getConnection();
    }
    
     

    @Override
    public boolean save(BatchTransferDTO dto) throws Exception {
        Statement stm=connection.createStatement();
        int res=stm.executeUpdate("insert into  batch_transfer values('"+dto.getBatch_transfer_id()+"','"+dto.getStudentDTO().getStudentId()+"','"+dto.getBatchDTO().getBatchId()+"','"+dto.getReason()+"','"+dto.getDate()+"','"+dto.getNewBatch()+"','"+dto.getTransferfee()+"')");
        if(res>0){
            return true;
            
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(BatchTransferDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(BatchTransferDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BatchTransferDTO find(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BatchTransferDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BatchTransferQueryDTO> getStudentDetails(String nic) throws Exception {
        List<BatchTransferQueryDTO>batchTransferQueryDTOs=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("SELECT ijsepaymentsystem.student.`NIC`,ijsepaymentsystem.student.`STUDENT_ID`,ijsepaymentsystem.student.`NAME_WITH_INITIAL`,ijsepaymentsystem.batch.`BATCH_NAME`,ijsepaymentsystem.batch.`BATCH_ID`,ijsepaymentsystem.registration.`REGISTRATION_ID`FROM ijsepaymentsystem.registration INNER JOIN ijsepaymentsystem.student ON  ijsepaymentsystem.registration.`STUDENT_ID` = ijsepaymentsystem.student.`STUDENT_ID` INNER JOIN ijsepaymentsystem.batch ON ijsepaymentsystem.registration.`BATCH_ID` = ijsepaymentsystem.batch.`BATCH_ID` WHERE  ijsepaymentsystem.student.`NIC`='"+nic+"'");
        while(rst.next()){
            if(batchTransferQueryDTOs==null){
                batchTransferQueryDTOs=new ArrayList<>();
            }
            BatchTransferQueryDTO dto=new BatchTransferQueryDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
            batchTransferQueryDTOs.add(dto);
        }
        return batchTransferQueryDTOs;
    }

    @Override
    public List<GetStudentDetailsForTransferQueryDTO> getStudentDetailsForTransfer(String sid,String status) throws Exception {
        List<GetStudentDetailsForTransferQueryDTO>dTOs=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select s.NAME_WITH_INITIAL, c.COURSE_Name  from registration r, student s, course c, course_batch cb, batch b where r.STUDENT_ID=s.STUDENT_ID  AND cb.BATCH_ID=b.BATCH_ID AND cb.COURSE_ID=c.COURSE_ID AND s.STUDENT_ID='"+sid+"' AND r.BATCH_ID=b.BATCH_ID AND cb.BATCH_ID=b.BATCH_ID AND cb.COURSE_ID=c.COURSE_ID AND r.STATUS='"+status+"'");
        while(rst.next()){
            if(dTOs==null){
                dTOs=new ArrayList<>();
            }
            GetStudentDetailsForTransferQueryDTO dto=new GetStudentDetailsForTransferQueryDTO(rst.getString(1), rst.getString(2));
            dTOs.add(dto);
        }
        return dTOs;
    }

    @Override
    public List<GetBatchDetailsForTransferQueryDTO> getBatchDetailsForTransfer(String sid, String coursName) throws Exception {
        List<GetBatchDetailsForTransferQueryDTO>dTOs=null;
       Statement stm= connection.createStatement();
       ResultSet rst=stm.executeQuery("select  r.REGISTRATION_ID,s.STUDENT_ID, b.BATCH_ID,b.BATCH_NAME from batch b,registration r,course c,student s, course_batch cb where r.STUDENT_ID=s.STUDENT_ID AND S.STUDENT_ID='"+sid+"' AND r.BATCH_ID=b.BATCH_ID AND cb.BATCH_ID=b.BATCH_ID AND cb.COURSE_ID=c.COURSE_ID AND c.COURSE_Name='"+coursName+"'");
       while(rst.next()){
           if(dTOs==null){
               dTOs=new ArrayList<>();
           }
           GetBatchDetailsForTransferQueryDTO dto=new GetBatchDetailsForTransferQueryDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
           dTOs.add(dto);
       }
        return dTOs;
    }

    @Override
    public List<GetNotStartBatchForTranserStudentQueryDTO> getNotStartBatch(String coursName, String status) throws Exception {
        List<GetNotStartBatchForTranserStudentQueryDTO>dTOs=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("SELECT ijsepaymentsystem.batch.`BATCH_NAME`,ijsepaymentsystem.batch.`STATUS`,ijsepaymentsystem.course.`COURSE_Name` FROM ijsepaymentsystem.course_batch INNER JOIN ijsepaymentsystem.batch ON  ijsepaymentsystem.course_batch.`BATCH_ID` = ijsepaymentsystem.batch.`BATCH_ID` INNER JOIN ijsepaymentsystem.course ON ijsepaymentsystem.course_batch.`COURSE_ID` = ijsepaymentsystem.course.`COURSE_ID` WHERE ijsepaymentsystem.course.`COURSE_Name` ='"+coursName+"'  AND  ijsepaymentsystem.batch.`STATUS` = '"+status+"'");
        while(rst.next()){
            if(dTOs==null){
                dTOs=new ArrayList<>();
            }
            GetNotStartBatchForTranserStudentQueryDTO dto=new GetNotStartBatchForTranserStudentQueryDTO(rst.getString(1), rst.getString(2), rst.getString(3));
            dTOs.add(dto);
        }
        return dTOs;
    }

    @Override
    public List<CheckPaymentForTransferStudentQueryDTO> getPaymentDetails(String sid, String coursName) throws Exception {
        List<CheckPaymentForTransferStudentQueryDTO>dTOs=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select p.PAYMENT_ID,p.STUDENT_ID,p.COURSE_NAME,p.PAYMENT_TYPE,p.PAYMENT_PENDING_DATE from payment p where p.STUDENT_ID='"+sid+"' AND p.COURSE_NAME='"+coursName+"';");
        while(rst.next()){
            if(dTOs==null){
                dTOs=new ArrayList<>();
            }
            CheckPaymentForTransferStudentQueryDTO dto=new CheckPaymentForTransferStudentQueryDTO(rst.getString(1),rst.getString(2),rst.getString(3), rst.getString(4), rst.getString(5));
            dTOs.add(dto);
        }
        return dTOs;
    }

    @Override
    public BatchDTO findBatchIDByBatchName(String batchName) throws Exception {
        BatchDTO batchDTO=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("SELECT ijsepaymentsystem.batch.`BATCH_ID` FROM ijsepaymentsystem.batch WHERE ijsepaymentsystem.batch.`BATCH_NAME`='"+batchName+"'");
        while(rst.next()){
            batchDTO=new BatchDTO(rst.getString(1));
            
        }
        return batchDTO;
    }

    @Override
    public CalculateIncomeQueryDTO getIncomeForBatchTransferFee(String month, String year) throws Exception {
        CalculateIncomeQueryDTO dto=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select sum(TRANSER_FEE) as income from batch_transfer where month(DATE)='"+month+"' AND year(DATE)='"+year+"'");
        while(rst.next()){
            dto=new CalculateIncomeQueryDTO(rst.getDouble(1));
        }
        return dto;
    }

    @Override
    public CalculateIncomeQueryDTO getDailyIncomeByBatchTransfer(String day, String month, String year) throws Exception {
        CalculateIncomeQueryDTO dto=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select sum(TRANSER_FEE) as income from batch_transfer where day(DATE)='"+day+"' AND month(DATE)='"+month+"' AND year(DATE)='"+year+"'");
        while(rst.next()){
            dto=new CalculateIncomeQueryDTO(rst.getDouble(1));
        }
        return dto;
    }

    @Override
    public CalculateIncomeQueryDTO getYearlyIncome(String year) throws Exception {
        CalculateIncomeQueryDTO dto=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select sum(TRANSER_FEE) as income from batch_transfer where year(DATE)='"+year+"'");
        while(rst.next()){
            dto=new CalculateIncomeQueryDTO(rst.getDouble(1));
        }
        return dto;
        
    }
    
}
