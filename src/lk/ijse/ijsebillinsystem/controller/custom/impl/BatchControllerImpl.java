/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.controller.custom.impl;

import java.util.List;
import lk.ijse.ijsebillinsystem.controller.custom.BatchController;
import lk.ijse.ijsebillinsystem.dto.BatchCourseDTO;
import lk.ijse.ijsebillinsystem.dto.BatchDTO;
import lk.ijse.ijsebillinsystem.querydto.BatchDetailsForNewRegistrationDTO;
import lk.ijse.ijsebillinsystem.querydto.BatchQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.CheckOldBatchDetailsForRegisterToAnotherBatchQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.GetNewCourseDetailsQueryDTO;
import lk.ijse.ijsebillinsystem.service.ServiceFactory;
import lk.ijse.ijsebillinsystem.service.custom.BatchService;

/**
 *
 * @author user
 */
public class BatchControllerImpl implements BatchController{
    
    private BatchService batchService;

    public BatchControllerImpl() {
        batchService=(BatchService) ServiceFactory.getInstance().getConnection(ServiceFactory.getServiceType.BATCHSERVICE);
    }
    
    

    @Override
    public boolean save(BatchDTO batchDTO) throws Exception {
        return batchService.save(batchDTO);
    }

    @Override
    public boolean update(BatchDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(BatchDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BatchDTO find(String id) throws Exception {
        BatchDTO batchDTO=batchService.find(id);
        if(batchDTO!=null){
            return batchDTO;
        }else{
            return null;
        }
    }

    @Override
    public List<BatchDTO> getAll() throws Exception {
        List<BatchDTO>batchDTOs=batchService.getAll();
        if(batchDTOs!=null){
            return batchDTOs;
        }else{
            return null;
        }
    }

    @Override
    public List<BatchQueryDTO> getAllBatchDetailsForRegistration() throws Exception {
        List<BatchQueryDTO>batchQuerys=batchService.getAllBatchDetailsForRegistration();
        return batchQuerys;
    }

    @Override
    public boolean saveBatchCourse(BatchDTO batchDTO, BatchCourseDTO batchCourseDTO) throws Exception {
        return batchService.saveBatchCourse(batchDTO, batchCourseDTO);
    }

    @Override
    public List<BatchDTO> searchBatchForStart(String status) throws Exception {
        List<BatchDTO>batchDTOs=batchService.searchBatchForStart(status);
        if(batchDTOs!=null){
            return batchDTOs;
        }else{
            return null;
        }
    }

    @Override
    public BatchDTO findBatchForCheckEqualsBatchId(String batchName) throws Exception {
        BatchDTO batchDTO=batchService.findBatchForCheckEqualsBatchId(batchName);
        if(batchDTO!=null){
            return batchDTO;
        }else{
            return null;
        }
    }

    @Override
    public List<BatchDTO> getAllOfNOtStartedBatch(String status) throws Exception {
        List<BatchDTO>batchDTOs=batchService.getAllOfNOtStartedBatch(status);
        if(batchDTOs!=null){
            return batchDTOs;
        }else{
            return null;
        }
    }

    @Override
    public boolean UpdateBatchStatus(BatchDTO batchDTO) throws Exception {
        return batchService.UpdateBatchStatus(batchDTO);
    }

    @Override
    public List<BatchDTO> getAllStartedBatch(String status) throws Exception {
        List<BatchDTO>batchDTOs=batchService.getAllStartedBatch(status);
        if(batchDTOs!=null){
            return batchDTOs;
        }else{
            return null;
        }
    }

    @Override
    public List<BatchDetailsForNewRegistrationDTO> getBatchDetailsForNewRegistration(String coursId) throws Exception {
        List<BatchDetailsForNewRegistrationDTO>details=batchService.getBatchDetailsForNewRegistration(coursId);
        if(details!=null){
            return details;
        }else{
            return null;
        }
    }

    @Override
    public List<CheckOldBatchDetailsForRegisterToAnotherBatchQueryDTO> getBatchDetails(String sid, String courseName, String status) throws Exception {
        List<CheckOldBatchDetailsForRegisterToAnotherBatchQueryDTO>dTOs=batchService.getBatchDetails(sid, courseName, status);
        if(dTOs!=null){
            return dTOs;
        }else{
            return null;
        }
    }

    @Override
    public List<GetNewCourseDetailsQueryDTO> getNewCourseDetailsForRegisterToAnothorBatch(String courseName, String batchStatus) throws Exception {
        List<GetNewCourseDetailsQueryDTO>dTOs=batchService.getNewCourseDetailsForRegisterToAnothorBatch(courseName, batchStatus);
        if(dTOs!=null){
            return dTOs;
        }else{
            return null;
        }
    }
    
}
