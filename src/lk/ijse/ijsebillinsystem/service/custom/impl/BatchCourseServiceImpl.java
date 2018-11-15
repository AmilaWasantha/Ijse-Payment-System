/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.service.custom.impl;

import java.util.List;
import lk.ijse.ijsebillinsystem.dao.DAOFactory;
import lk.ijse.ijsebillinsystem.dao.custom.BatchCourseDAO;
import lk.ijse.ijsebillinsystem.dto.BatchCourseDTO;
import lk.ijse.ijsebillinsystem.service.custom.BatchCourseService;

/**
 *
 * @author user
 */
public class BatchCourseServiceImpl implements BatchCourseService{
    
    private BatchCourseDAO batchCourseDAO;
    

    public BatchCourseServiceImpl() {
        batchCourseDAO=(BatchCourseDAO) DAOFactory.getInstance().getConnection(DAOFactory.DAOType.BATCHCOURSEDAO);
    }
    
    

    @Override
    public boolean save(BatchCourseDTO batchCourseDTO) throws Exception {
        return batchCourseDAO.save(batchCourseDTO);
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
    public List<BatchCourseDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
