/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.service.custom.impl;

import java.util.List;
import lk.ijse.ijsebillinsystem.dao.DAOFactory;
import lk.ijse.ijsebillinsystem.dao.custom.CourseDAO;
import lk.ijse.ijsebillinsystem.dto.CourseDTO;
import lk.ijse.ijsebillinsystem.service.custom.CourseService;

/**
 *
 * @author user
 */
public class CourseServiceImpl implements CourseService{
    
    private CourseDAO courseDAO;

    public CourseServiceImpl() {
        courseDAO=(CourseDAO) DAOFactory.getInstance().getConnection(DAOFactory.DAOType.COURSEDAO);
    }
    
    

    @Override
    public boolean save(CourseDTO courseDTO) throws Exception {
        return courseDAO.save(courseDTO);
    }

    @Override
    public boolean delete(CourseDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(CourseDTO t) throws Exception {
        return courseDAO.update(t);
    }

    @Override
    public CourseDTO find(String id) throws Exception {
        CourseDTO courseDTO=courseDAO.find(id);
        return courseDTO;
    }

    @Override
    public List<CourseDTO> getAll()throws Exception{
       List<CourseDTO>courseDTOs=courseDAO.getAll();
       return courseDTOs;
    }
    
}
