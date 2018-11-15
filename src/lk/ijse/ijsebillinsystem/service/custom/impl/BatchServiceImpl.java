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
import lk.ijse.ijsebillinsystem.dao.custom.BatchCourseDAO;
import lk.ijse.ijsebillinsystem.dao.custom.BatchDAO;
import lk.ijse.ijsebillinsystem.dto.BatchCourseDTO;
import lk.ijse.ijsebillinsystem.dto.BatchDTO;
import lk.ijse.ijsebillinsystem.querydto.BatchDetailsForNewRegistrationDTO;
import lk.ijse.ijsebillinsystem.querydto.BatchQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.CheckOldBatchDetailsForRegisterToAnotherBatchQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.GetNewCourseDetailsQueryDTO;
import lk.ijse.ijsebillinsystem.service.custom.BatchService;

/**
 *
 * @author user
 */
public class BatchServiceImpl implements BatchService{
    
    private BatchDAO batchDAO;
    private Connection connection;
    private BatchCourseDAO batchCourseDAO;

    public BatchServiceImpl() {
        batchDAO=(BatchDAO) DAOFactory.getInstance().getConnection(DAOFactory.DAOType.BATCHDAO);
        connection=DBFactory.getInstance().getConnection(DBFactory.connectionType.DBCONNECTION).getConnection();
        batchCourseDAO=(BatchCourseDAO) DAOFactory.getInstance().getConnection(DAOFactory.DAOType.BATCHCOURSEDAO);
    }
    
    

    @Override
    public boolean save(BatchDTO batchDTO) throws Exception {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
//        return batchDAO.save(batchDTO);
    }

    @Override
    public boolean delete(BatchDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(BatchDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BatchDTO find(String id) throws Exception {
        BatchDTO batchDTO=batchDAO.find(id);
        if(batchDTO!=null){
            return batchDTO;
        }else{
            return null;
        }
    }

    @Override
    public List<BatchDTO> getAll() throws Exception{
        List<BatchDTO>batchDTOs=batchDAO.getAll();
        if(batchDTOs!=null){
            return batchDTOs;
        }else{
              return null;
        }
      
    }

    @Override
    public List<BatchQueryDTO> getAllBatchDetailsForRegistration() throws Exception {
        List<BatchQueryDTO>batchQuerys=batchDAO.getAllBatchDetailsForRegistration();
        return batchQuerys;
    }

    @Override
    public boolean saveBatchCourse(BatchDTO batchDTO, BatchCourseDTO batchCourseDTO)throws Exception{
        try {
            connection.setAutoCommit(false);
            boolean result=batchDAO.save(batchDTO);
            if(result==true){
                result=batchCourseDAO.save(batchCourseDTO);
                
                
                
            }else{
                connection.rollback();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BatchServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(BatchServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            connection.setAutoCommit(true);
            
        }
        return true;
    }

    @Override
    public List<BatchDTO> searchBatchForStart(String status) throws Exception {
        List<BatchDTO>batchDTOs=batchDAO.searchBatchForStart(status);
        if(batchDTOs!=null){
            return batchDTOs;
        }else{
            return null;
        }
    }

    @Override
    public BatchDTO findBatchForCheckEqualsBatchId(String batchName) throws Exception {
        BatchDTO batchDTO=batchDAO.findBatchForCheckEqualsBatchId(batchName);
        if(batchDTO!=null){
            return batchDTO;
        }else{
            return null;
        }
    }

    @Override
    public List<BatchDTO> getAllOfNOtStartedBatch(String status) throws Exception {
        List<BatchDTO>batchDTOs=batchDAO.getAllOfNOtStartedBatch(status);
        if(batchDTOs!=null){
            return batchDTOs;
        }else{
            return null;
        }
    }

    @Override
    public boolean UpdateBatchStatus(BatchDTO batchDTO)throws Exception{
        try {
            BatchCourseDTO batchCourseDTO=new BatchCourseDTO();
            
            BatchDTO batchDTO1=new BatchDTO();
            batchDTO1.setBatchId(batchDTO.getBatchId());
            connection.setAutoCommit(false);
            boolean result1= batchDAO.UpdateBatchStatus(batchDTO);
            if(result1==true){
                boolean result2=batchCourseDAO.UpdateBatchStatus(batchDTO);
            }else{
                connection.rollback();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BatchServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            connection.rollback();
            return false;
            
        }finally{
            connection.setAutoCommit(true);
            return true;
        }
    }

    @Override
    public List<BatchDTO> getAllStartedBatch(String status) throws Exception {
        List<BatchDTO>batchDTOs=batchDAO.getAllOfNOtStartedBatch(status);
        if(batchDTOs!=null){
            return batchDTOs;
        }else{
            return null;
        }
    }

    @Override
    public List<BatchDetailsForNewRegistrationDTO> getBatchDetailsForNewRegistration(String coursId) throws Exception {
        List<BatchDetailsForNewRegistrationDTO>details=batchDAO.getBatchDetailsForNewRegistration(coursId);
        if(details!=null){
            return details;
        }else{
            return null;
        }
    }

    @Override
    public List<CheckOldBatchDetailsForRegisterToAnotherBatchQueryDTO> getBatchDetails(String sid, String courseName, String status) throws Exception {
        List<CheckOldBatchDetailsForRegisterToAnotherBatchQueryDTO>dTOs=batchDAO.getBatchDetails(sid, courseName, status);
        if(dTOs!=null){
            return dTOs;
        }else{
            return null;
        }
    }

    @Override
    public List<GetNewCourseDetailsQueryDTO> getNewCourseDetailsForRegisterToAnothorBatch(String courseName, String batchStatus) throws Exception {
        List<GetNewCourseDetailsQueryDTO>dTOs=batchDAO.getNewCourseDetailsForRegisterToAnothorBatch(courseName, batchStatus);
        if(dTOs!=null){
            return dTOs;
        }else{
            return null;
        }
    }
    
}
