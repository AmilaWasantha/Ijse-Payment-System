/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.dao.custom;

import java.util.List;
import lk.ijse.ijsebillinsystem.dao.SuperDAO;
import lk.ijse.ijsebillinsystem.dto.BatchCourseDTO;
import lk.ijse.ijsebillinsystem.dto.BatchDTO;
import lk.ijse.ijsebillinsystem.entity.Batch;
import lk.ijse.ijsebillinsystem.entity.BatchCourse;
import lk.ijse.ijsebillinsystem.querydto.BatchDetailsForNewRegistrationDTO;
import lk.ijse.ijsebillinsystem.querydto.BatchQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.CheckOldBatchDetailsForRegisterToAnotherBatchQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.GetNewCourseDetailsQueryDTO;

/**
 *
 * @author user
 */
public interface BatchDAO extends SuperDAO<BatchDTO, String>{
    public List<BatchQueryDTO>getAllBatchDetailsForRegistration()throws Exception;
    public List<BatchDTO>searchBatchForStart(String status)throws Exception;
    public BatchDTO findBatchForCheckEqualsBatchId(String batchName)throws Exception;
    public List<BatchDTO>getAllOfNOtStartedBatch(String status)throws Exception;
    public boolean UpdateBatchStatus(BatchDTO batchDTO)throws Exception;
    public List<BatchDTO>getAllStartedBatch(String staus)throws Exception;
    public List<BatchDetailsForNewRegistrationDTO>getBatchDetailsForNewRegistration(String coursId)throws Exception;
    public List<CheckOldBatchDetailsForRegisterToAnotherBatchQueryDTO>getBatchDetails(String sid,String courseName,String status)throws Exception;
    public List<GetNewCourseDetailsQueryDTO>getNewCourseDetailsForRegisterToAnothorBatch(String courseName,String batchStatus)throws Exception;
    
}
