/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.controller.custom.impl;

import java.util.List;
import lk.ijse.ijsebillinsystem.controller.custom.CourseController;
import lk.ijse.ijsebillinsystem.dto.CourseDTO;
import lk.ijse.ijsebillinsystem.service.ServiceFactory;
import lk.ijse.ijsebillinsystem.service.custom.CourseService;

/**
 *
 * @author user
 */
public class CourseControllerImpl implements CourseController{
    private CourseService courseService;

    public CourseControllerImpl() {
        courseService=(CourseService) ServiceFactory.getInstance().getConnection(ServiceFactory.getServiceType.COURSERSERVICE);
    }
    
    

    @Override
    public boolean save(CourseDTO courseDTO) throws Exception {
        return courseService.save(courseDTO);
    }

    @Override
    public boolean update(CourseDTO cuCourseDTO) throws Exception {
        return courseService.update(cuCourseDTO);
    }

    @Override
    public boolean delete(CourseDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CourseDTO find(String id) throws Exception {
        CourseDTO courseDTO=courseService.find(id);
        return courseDTO;
    }

    @Override
    public List<CourseDTO> getAll() throws Exception {
        List<CourseDTO>courseDTOs=courseService.getAll();
        return courseDTOs;
    }
    
}
