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
import lk.ijse.ijsebillinsystem.dao.custom.GardianDAO;
import lk.ijse.ijsebillinsystem.dao.custom.StudentDAO;
import lk.ijse.ijsebillinsystem.dto.BatchRegistrationDTO;
import lk.ijse.ijsebillinsystem.querydto.CalculateIncomeQueryDTO;
import lk.ijse.ijsebillinsystem.service.custom.BatchRegistrationService;

/**
 *
 * @author user
 */
public class BatchRegistrationServiceImpl implements BatchRegistrationService{
    private BatchRegistrationDAO batchRegistrationDAO;
    private StudentDAO studentDAO;
    private GardianDAO gardianDAO;
    private Connection connection;

    public BatchRegistrationServiceImpl() {
        batchRegistrationDAO=(BatchRegistrationDAO) DAOFactory.getInstance().getConnection(DAOFactory.DAOType.BATCHREGISTRATIONDAO);
        studentDAO=(StudentDAO) DAOFactory.getInstance().getConnection(DAOFactory.DAOType.STUDENTDAO);
        gardianDAO=(GardianDAO) DAOFactory.getInstance().getConnection(DAOFactory.DAOType.GARDIANDAO);
        connection=DBFactory.getInstance().getConnection(DBFactory.connectionType.DBCONNECTION).getConnection();
    }
    
    

    @Override
    public boolean save(BatchRegistrationDTO registrationDTO)throws Exception{
    
        try {
            connection.setAutoCommit(false);
            boolean result=gardianDAO.save(registrationDTO.getStudentDTO().getGardianDTO());
            if(result==true){
                boolean result1=studentDAO.save(registrationDTO.getStudentDTO());
                if(result1==true){
                    boolean result2=batchRegistrationDAO.save(registrationDTO);
                }else{
                    connection.rollback();
                    return false;
                }
            }else{
                connection.rollback();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BatchRegistrationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            connection.rollback();
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(BatchRegistrationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            connection.rollback();
            throw ex;
        }finally{
            connection.setAutoCommit(true);
        }
        return true;
        
       
        
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
    public List<BatchRegistrationDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registrationToAnotherBatch(BatchRegistrationDTO dto) throws Exception {
        return batchRegistrationDAO.registrationToAnotherBatch(dto);
    }

    @Override
    public boolean afterBatchTransfer(BatchRegistrationDTO batchRegistrationDTO) throws Exception {
        return batchRegistrationDAO.afterBatchTransfer(batchRegistrationDTO);
    }

    @Override
    public CalculateIncomeQueryDTO getIncomeForMonth(String month, String year) throws Exception {
        CalculateIncomeQueryDTO dto=batchRegistrationDAO.getIncomeForMonth(month, year);
        if(dto!=null){
            return dto;
        }else{
            return null;
        }
    }

    @Override
    public CalculateIncomeQueryDTO getDailyIncomeByRegistration(String day, String month, String year) throws Exception {
        CalculateIncomeQueryDTO dto=batchRegistrationDAO.getDailyIncomeByRegistration(day, month, year);
        if(dto!=null){
            return dto;
        }else{
            return null;
        }
    }

    @Override
    public CalculateIncomeQueryDTO getYearlyIncome(String year) throws Exception {
        CalculateIncomeQueryDTO dto=batchRegistrationDAO.getYearlyIncome(year);
        if(dto!=null){
            return dto;
        }else{
            return null;
        }
    }
    
}
