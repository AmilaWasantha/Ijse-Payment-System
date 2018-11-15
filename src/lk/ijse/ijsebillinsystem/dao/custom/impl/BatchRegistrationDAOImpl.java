/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import lk.ijse.ijsebillinsystem.conncetion.DBFactory;
import lk.ijse.ijsebillinsystem.dao.custom.BatchRegistrationDAO;
import lk.ijse.ijsebillinsystem.dto.BatchRegistrationDTO;
import lk.ijse.ijsebillinsystem.querydto.CalculateIncomeQueryDTO;

/**
 *
 * @author user
 */
public class BatchRegistrationDAOImpl implements BatchRegistrationDAO{
    private Connection connection;

    public BatchRegistrationDAOImpl() {
        connection=DBFactory.getInstance().getConnection(DBFactory.connectionType.DBCONNECTION).getConnection();
    }
    
    

    @Override
    public boolean save(BatchRegistrationDTO dto) throws Exception {
        Statement stm=connection.createStatement();
        int res=stm.executeUpdate("insert into registration values('"+dto.getRid()+"','"+dto.getStudentDTO().getStudentId()+"','"+dto.getBatchDTO().getBatchId()+"','"+dto.getDate()+"','"+dto.getBatchStartDate()+"','"+dto.getFee()+"','"+dto.getStatus()+"')");
        if(res>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(BatchRegistrationDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(BatchRegistrationDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BatchRegistrationDTO find(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BatchRegistrationDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registrationToAnotherBatch(BatchRegistrationDTO dto) throws Exception {
        Statement stm=connection.createStatement();
        int res=stm.executeUpdate("insert into registration values('"+dto.getRid()+"','"+dto.getStudentDTO().getStudentId()+"','"+dto.getBatchDTO().getBatchId()+"','"+dto.getDate()+"','"+dto.getBatchStartDate()+"','"+dto.getFee()+"','"+dto.getStatus()+"')");
        if(res>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean afterBatchTransfer(BatchRegistrationDTO batchRegistrationDTO) throws Exception {
        Statement stm=connection.createStatement();
        int res=stm.executeUpdate("update registration set STATUS='"+batchRegistrationDTO.getStatus()+"' where REGISTRATION_ID='"+batchRegistrationDTO.getRid()+"'");
        if(res>0){
            return true;
        }else{
            return false;
        }
                
    }

    @Override
    public CalculateIncomeQueryDTO getIncomeForMonth(String month, String year) throws Exception {
         CalculateIncomeQueryDTO dto=null;
         Statement stm=connection.createStatement();
         ResultSet rst=stm.executeQuery("select sum(FEE) as income from registration where month(REGISTRATION_DATE)='"+month+"' AND year(REGISTRATION_DATE)='"+year+"'");
         while(rst.next()){
             dto=new CalculateIncomeQueryDTO(rst.getDouble(1));
         }
        return dto;
    }

    @Override
    public CalculateIncomeQueryDTO getDailyIncomeByRegistration(String day, String month, String year) throws Exception {
        CalculateIncomeQueryDTO dto=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select sum(FEE) as income from registration where day(REGISTRATION_DATE)='"+day+"' AND month(REGISTRATION_DATE)='"+month+"' AND year(REGISTRATION_DATE)='"+year+"'");
        while(rst.next()){
            dto=new CalculateIncomeQueryDTO(rst.getDouble(1));
        }
        return dto;
    }

    @Override
    public CalculateIncomeQueryDTO getYearlyIncome(String year) throws Exception {
        CalculateIncomeQueryDTO dto=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select sum(FEE) as income from registration where year(REGISTRATION_DATE)='"+year+"'");
        while(rst.next()){
            dto=new CalculateIncomeQueryDTO(rst.getDouble(1));
            
        }
        return dto;
    }
    
}
