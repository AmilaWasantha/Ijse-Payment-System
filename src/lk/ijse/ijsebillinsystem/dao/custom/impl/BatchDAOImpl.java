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
import lk.ijse.ijsebillinsystem.dao.custom.BatchDAO;
import lk.ijse.ijsebillinsystem.dto.BatchDTO;
import lk.ijse.ijsebillinsystem.querydto.BatchDetailsForNewRegistrationDTO;
import lk.ijse.ijsebillinsystem.querydto.BatchQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.CheckOldBatchDetailsForRegisterToAnotherBatchQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.GetNewCourseDetailsQueryDTO;

/**
 *
 * @author user
 */
public class BatchDAOImpl implements BatchDAO{
    private Connection connection;

    public BatchDAOImpl() {
        connection=DBFactory.getInstance().getConnection(DBFactory.connectionType.DBCONNECTION).getConnection();
    }
    
    

    @Override
    public boolean save(BatchDTO dto) throws Exception {
        Statement stm= connection.createStatement();
        int res=stm.executeUpdate("insert into batch values('"+dto.getBatchId()+"','"+dto.getBatchName()+"','"+dto.getDate()+"','"+dto.getType()+"','"+dto.getStatus()+"')");
        if(res>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(BatchDTO dto) throws Exception {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    }

    @Override
    public boolean update(BatchDTO t) throws Exception {
       List<BatchQueryDTO>list= getAllBatchDetailsForRegistration();
       return true;
    }

    @Override
    public BatchDTO find(String id)throws Exception{
        BatchDTO batchDTO=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("SELECT ijsepaymentsystem.batch.`BATCH_ID`,ijsepaymentsystem.batch.`BATCH_NAME`,ijsepaymentsystem.batch.`DATE`,ijsepaymentsystem.batch.`TYPE`,ijsepaymentsystem.batch.`STATUS` FROM ijsepaymentsystem.batch WHERE  ijsepaymentsystem.batch.`BATCH_NAME`='"+id+"'");
        while(rst.next()){
            if(batchDTO==null){
                batchDTO=new BatchDTO(rst.getString(1), rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(4));
            }
        }
        return batchDTO;
        
    }

    @Override
    public List<BatchDTO> getAll()throws Exception{
        List<BatchDTO>batchDTOs=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select *from batch");
        while(rst.next()){
            if(batchDTOs==null){
                batchDTOs=new ArrayList<>();
            }
            BatchDTO batchDTO=new BatchDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),rst.getString(5));
            batchDTOs.add(batchDTO);
        }
        return batchDTOs;
    }

    @Override
    public List<BatchQueryDTO> getAllBatchDetailsForRegistration() throws Exception {
        List<BatchQueryDTO>batchDTOs=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select b.BATCH_ID,c.COURSE_ID,b.BATCH_NAME,b.DATE,b.STATUS ,c.COURSE_Name from batch b,course_batch bc ,course c where bc.BATCH_ID=b.BATCH_ID AND bc.COURSE_ID=c.COURSE_ID");
        while(rst.next()){

            if(batchDTOs==null){
                batchDTOs=new ArrayList<>();
            }
            BatchQueryDTO batchQuery=new BatchQueryDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6));
            batchDTOs.add(batchQuery);
          
        }
    
        return batchDTOs;
        
        
              
    }

    @Override
    public List<BatchDTO> searchBatchForStart(String status) throws Exception {
        List<BatchDTO>batchDTOs=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select*from batch where STATUS='"+status+"'");
        while(rst.next()){
            if(batchDTOs==null){
                batchDTOs=new ArrayList<>();
            }
            
            BatchDTO batchDTO=new BatchDTO(rst.getString(1),rst.getString(2), rst.getString(3),rst.getString(4),rst.getString(5));
            batchDTOs.add(batchDTO);
            //return batchDTOs;
        }
        return batchDTOs;
    }

    @Override
    public BatchDTO findBatchForCheckEqualsBatchId(String batchName) throws Exception {
        BatchDTO batchDTO=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select * from batch where BATCH_NAME='"+batchName+"'");
        while(rst.next()){
            
            batchDTO =new BatchDTO(rst.getString(1),rst.getString(2), rst.getString(3), rst.getString(4),rst.getString(5));
            
        }
        return batchDTO;
        
    }

    @Override
    public List<BatchDTO> getAllOfNOtStartedBatch(String status) throws Exception {
        List<BatchDTO>batchDTOs=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select *from batch where STATUS='"+status+"'");
        while(rst.next()){
            if(batchDTOs==null){
                batchDTOs=new ArrayList<>();
            }
            BatchDTO batchDTO=new BatchDTO(rst.getString(1), rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5));
            batchDTOs.add(batchDTO);
        }
        return batchDTOs;
    }

    @Override
    public boolean UpdateBatchStatus(BatchDTO batchDTO) throws Exception {
        Statement stm=connection.createStatement();
        int res=stm.executeUpdate("update batch set STATUS='"+batchDTO.getStatus()+"' where BATCH_ID='"+batchDTO.getBatchId()+"' ");
        if(res>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<BatchDTO> getAllStartedBatch(String staus) throws Exception {
        List<BatchDTO>batchDTOs=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select*from batch where STATUS='"+staus+"'");
        while(rst.next()){
            if(batchDTOs==null){
                batchDTOs=new ArrayList<>();
            }
            BatchDTO batchDTO=new BatchDTO(rst.getString(1), rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5));
            batchDTOs.add(batchDTO);
        }
        return batchDTOs;
    }

    @Override
    public List<BatchDetailsForNewRegistrationDTO> getBatchDetailsForNewRegistration(String coursId)throws Exception{
        List<BatchDetailsForNewRegistrationDTO>details=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select  b.BATCH_ID,b.STATUS,b.BATCH_NAME from batch b,course c,course_batch cb where cb.COURSE_ID=c.COURSE_ID AND c.COURSE_ID='"+coursId+"' AND  cb.BATCH_ID=b.BATCH_ID;");
        while(rst.next()){
            if(details==null){
                details=new ArrayList<>();
            }
            BatchDetailsForNewRegistrationDTO dto=new BatchDetailsForNewRegistrationDTO(rst.getString(1), rst.getString(2), rst.getString(3));
            details.add(dto);
        }
        return details;
    }

    @Override
    public List<CheckOldBatchDetailsForRegisterToAnotherBatchQueryDTO> getBatchDetails(String sid, String courseName, String status) throws Exception {
        List<CheckOldBatchDetailsForRegisterToAnotherBatchQueryDTO> dTOs=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select c.COURSE_TYPE,b.BATCH_NAME,b.STATUS from course c,batch b,registration r,student s,course_batch cb where r.STUDENT_ID=s. STUDENT_ID AND s.STUDENT_ID='"+sid+"' AND r.BATCH_ID=b.BATCH_ID AND cb.BATCH_ID=b.BATCH_ID AND cb.COURSE_ID=c.COURSE_ID AND c.COURSE_Name='"+courseName+"' AND r.STATUS='"+status+"'");
        while(rst.next()){
            if(dTOs==null){
                dTOs=new ArrayList<>();
            }
            CheckOldBatchDetailsForRegisterToAnotherBatchQueryDTO dto=new CheckOldBatchDetailsForRegisterToAnotherBatchQueryDTO(rst.getString(1), rst.getString(2), rst.getString(3));
            dTOs.add(dto);
        }
        return dTOs;
    }

    @Override
    public List<GetNewCourseDetailsQueryDTO> getNewCourseDetailsForRegisterToAnothorBatch(String courseName, String batchStatus) throws Exception {
        List<GetNewCourseDetailsQueryDTO>dTOs=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select c.COURSE_TYPE,c.COURSE_ID,b.BATCH_NAME from course c,batch b,course_batch cb where cb.COURSE_ID=c.COURSE_ID AND c.COURSE_Name='"+courseName+"'  AND cb.BATCH_ID=b.BATCH_ID AND b.STATUS='"+batchStatus+"';");
        while(rst.next()){
            if(dTOs==null){
                dTOs=new ArrayList<>();
            }
            GetNewCourseDetailsQueryDTO dto=new GetNewCourseDetailsQueryDTO(rst.getString(1), rst.getString(2), rst.getString(3));
            dTOs.add(dto);
        }
        return dTOs;
    }

   

    

    
    
}
