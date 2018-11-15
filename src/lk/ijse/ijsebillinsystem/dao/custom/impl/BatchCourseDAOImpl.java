/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import lk.ijse.ijsebillinsystem.conncetion.DBFactory;
import lk.ijse.ijsebillinsystem.dao.custom.BatchCourseDAO;
import lk.ijse.ijsebillinsystem.dto.BatchCourseDTO;
import lk.ijse.ijsebillinsystem.dto.BatchDTO;
import lk.ijse.ijsebillinsystem.entity.BatchCourse;

/**
 *
 * @author user
 */
public class BatchCourseDAOImpl implements BatchCourseDAO{
    
    private Connection connection;

    public BatchCourseDAOImpl() {
        connection=DBFactory.getInstance().getConnection(DBFactory.connectionType.DBCONNECTION).getConnection();
    }
    
    

    @Override
    public boolean save(BatchCourseDTO dto) throws Exception {
        Statement stm=connection.createStatement();
        int res=stm.executeUpdate("insert into course_batch values('"+dto.getBatchCourseId()+"','"+dto.getBatchDTO().getBatchId()+"','"+dto.getCourseDTO().getCourseId()+"','"+dto.getBatchName()+"','"+dto.getDate()+"','"+dto.getType()+"','"+dto.getStatus()+"')");
        if(res>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(BatchCourseDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(BatchCourseDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BatchCourseDTO find(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BatchCourseDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean UpdateBatchStatus(BatchDTO batchDTO) throws Exception {
        Statement stm=connection.createStatement();
        int res=stm.executeUpdate("update course_batch set STATUS='"+batchDTO.getStatus()+"' where BATCH_ID='"+batchDTO.getBatchId()+"'");
        if(res>0){
            return true;
        }else{
            return false;
        }
    }

    
    
}
