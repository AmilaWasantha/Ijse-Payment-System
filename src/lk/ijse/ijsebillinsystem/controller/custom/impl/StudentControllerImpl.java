/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.controller.custom.impl;

import java.util.List;
import lk.ijse.ijsebillinsystem.controller.custom.StudentController;
import lk.ijse.ijsebillinsystem.dto.StudentDTO;
import lk.ijse.ijsebillinsystem.querydto.RegisterStudentToAnothoerBatchQueryDTO;
import lk.ijse.ijsebillinsystem.service.ServiceFactory;
import lk.ijse.ijsebillinsystem.service.custom.StudentService;

/**
 *
 * @author user
 */
public class StudentControllerImpl implements StudentController{
    private StudentService studentService;

    public StudentControllerImpl() {
        studentService=(StudentService) ServiceFactory.getInstance().getConnection(ServiceFactory.getServiceType.STUDENTSERVICE);
    }
    
    

    @Override
    public boolean save(StudentDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(StudentDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(StudentDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StudentDTO find(String id) throws Exception {
        StudentDTO studentDTO=studentService.find(id);
        if(studentDTO!=null){
            return studentDTO;
        }else{
            return null;
        }
    }

    @Override
    public List<StudentDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RegisterStudentToAnothoerBatchQueryDTO> getStudentDetails(String sid,String staus) throws Exception {
        List<RegisterStudentToAnothoerBatchQueryDTO>registerStudentToAnothoerBatchQueryDTOs=studentService.getStudentDetails(sid,staus);
        if(registerStudentToAnothoerBatchQueryDTOs!=null){
            return registerStudentToAnothoerBatchQueryDTOs;
        }else{
            return null;
        }
    }
    
}
