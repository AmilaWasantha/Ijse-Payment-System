/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.controller.custom.impl;

import java.util.List;
import lk.ijse.ijsebillinsystem.controller.custom.BatchCourseController;
import lk.ijse.ijsebillinsystem.dto.BatchCourseDTO;
import lk.ijse.ijsebillinsystem.service.ServiceFactory;
import lk.ijse.ijsebillinsystem.service.custom.BatchCourseService;
import lk.ijse.ijsebillinsystem.service.custom.BatchService;

/**
 *
 * @author user
 */
public class BatchCourseControllerImpl implements BatchCourseController{
    
    private BatchCourseService batchCourseService;

    public BatchCourseControllerImpl() {
        batchCourseService=(BatchCourseService) ServiceFactory.getInstance().getConnection(ServiceFactory.getServiceType.BATCHCOURSERVICE);
    }
    
    

    @Override
    public boolean save(BatchCourseDTO batchCourseDTO) throws Exception {
        return batchCourseService.save(batchCourseDTO);
    }

    @Override
    public boolean update(BatchCourseDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(BatchCourseDTO t) throws Exception {
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
    
}
