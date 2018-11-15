/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.service.custom.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.ijsebillinsystem.conncetion.DBFactory;
import lk.ijse.ijsebillinsystem.dao.DAOFactory;
import lk.ijse.ijsebillinsystem.dao.custom.BatchRegistrationDAO;
import lk.ijse.ijsebillinsystem.dao.custom.BatchTransferDAO;
import lk.ijse.ijsebillinsystem.dao.custom.PaymentDAO;
import lk.ijse.ijsebillinsystem.dto.BatchDTO;
import lk.ijse.ijsebillinsystem.dto.BatchRegistrationDTO;
import lk.ijse.ijsebillinsystem.dto.BatchTransferDTO;
import lk.ijse.ijsebillinsystem.dto.PaymentDTO;
import lk.ijse.ijsebillinsystem.querydto.BatchTransferQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.CalculateIncomeQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.CheckPaymentForTransferStudentQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.GetBatchDetailsForTransferQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.GetNotStartBatchForTranserStudentQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.GetStudentDetailsForTransferQueryDTO;
import lk.ijse.ijsebillinsystem.service.custom.BatchTransferService;

/**
 *
 * @author user
 */
public class BatchTransferServiceImpl implements BatchTransferService{
    private BatchTransferDAO batchTransferDAO;
    private Connection connection;
    private BatchRegistrationDAO batchRegistrationDAO;
    private PaymentDAO paymentDAO;

    public BatchTransferServiceImpl() {
        batchTransferDAO=(BatchTransferDAO) DAOFactory.getInstance().getConnection(DAOFactory.DAOType.BATCHTRANSFERDAO);
        connection=DBFactory.getInstance().getConnection(DBFactory.connectionType.DBCONNECTION).getConnection();
        batchRegistrationDAO=(BatchRegistrationDAO) DAOFactory.getInstance().getConnection(DAOFactory.DAOType.BATCHREGISTRATIONDAO);
        paymentDAO=(PaymentDAO) DAOFactory.getInstance().getConnection(DAOFactory.DAOType.PAYMENTDAO);
    }
    
    

    @Override
    public boolean save(BatchTransferDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public List<BatchTransferDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BatchTransferQueryDTO> getStudentDetails(String nic) throws Exception {
        List<BatchTransferQueryDTO>batchTransferQueryDTOs=batchTransferDAO.getStudentDetails(nic);
        if(batchTransferQueryDTOs!=null){
            return batchTransferQueryDTOs;
        }else{
            return null;
        }
    }

    @Override
    public List<GetStudentDetailsForTransferQueryDTO> getStudentDetailsForTransfer(String sid,String status) throws Exception {
        List<GetStudentDetailsForTransferQueryDTO>dtos=batchTransferDAO.getStudentDetailsForTransfer(sid,status);
        if(dtos!=null){
            return dtos;
        }else{
            return null;
        }
    }

    @Override
    public List<GetBatchDetailsForTransferQueryDTO> getBatchDetailsForTransfer(String sid, String coursName) throws Exception {
        List<GetBatchDetailsForTransferQueryDTO>dTOs=batchTransferDAO.getBatchDetailsForTransfer(sid, coursName);
        if(dTOs!=null){
            return dTOs;
        }else{
            return null;
        }
    }

    @Override
    public List<GetNotStartBatchForTranserStudentQueryDTO> getNotStartBatch(String coursName, String status) throws Exception {
        List<GetNotStartBatchForTranserStudentQueryDTO>dTOs=batchTransferDAO.getNotStartBatch(coursName, status);
        if(dTOs!=null){
            return dTOs;
        }else{
            return null;
        }
    }

    @Override
    public List<CheckPaymentForTransferStudentQueryDTO> getPaymentDetails(String sid, String coursName) throws Exception {
        List<CheckPaymentForTransferStudentQueryDTO>dTOs=batchTransferDAO.getPaymentDetails(sid, coursName);
        if(dTOs!=null){
            return dTOs;
        }else{
            return null;
        }
    }

    @Override
    public BatchDTO getBatchIDByBatchName(String batchName) throws Exception {
        BatchDTO batchDTO=batchTransferDAO.findBatchIDByBatchName(batchName);
        if(batchDTO!=null){
            return batchDTO;
        }else{
            return null;
        }
    }

    @Override
    public boolean manageBatchTransfer(BatchRegistrationDTO batchRegistrationDTO, BatchTransferDTO batchTransferDTO, PaymentDTO paymentDTO) throws SQLException, Exception {
        try {
            connection.setAutoCommit(false);
            boolean result=batchTransferDAO.save(batchTransferDTO);
            if(result==true){
                boolean result1=batchRegistrationDAO.save(batchRegistrationDTO);
                if(result1==true){
                    boolean result2=paymentDAO.updateAfterBatchTransferStudent(paymentDTO);
                    
                }else{
                    connection.rollback();
                    return false;
                }
            }else{
                connection.rollback();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BatchTransferServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            connection.rollback();
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(BatchTransferServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            connection.rollback();
            throw ex;
        }finally{
            connection.setAutoCommit(true);
        }
        return true;
    }

    @Override
    public CalculateIncomeQueryDTO getIncomeForBatchTransferFee(String month, String year) throws Exception {
        CalculateIncomeQueryDTO dto=batchTransferDAO.getIncomeForBatchTransferFee(month, year);
        if(dto!=null){
            return dto;
        }else{
            return null;
        }
    }

    @Override
    public CalculateIncomeQueryDTO getDailyIncomeByBatchTransfer(String day, String month, String year) throws Exception {
        CalculateIncomeQueryDTO dto=batchTransferDAO.getDailyIncomeByBatchTransfer(day, month, year);
        if(dto!=null){
            return dto;
        }else{
            return null;
        }
    }

    @Override
    public CalculateIncomeQueryDTO getYearlyIncome(String year) throws Exception {
        CalculateIncomeQueryDTO dto=batchTransferDAO.getYearlyIncome(year);
        if(dto!=null){
            return dto;
        }else{
            return null;
        }
    }
    
}
