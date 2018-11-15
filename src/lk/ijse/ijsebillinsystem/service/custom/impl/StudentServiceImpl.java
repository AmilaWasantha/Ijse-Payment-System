/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.service.custom.impl;

import java.util.List;
import lk.ijse.ijsebillinsystem.dao.DAOFactory;
import lk.ijse.ijsebillinsystem.dao.custom.StudentDAO;
import lk.ijse.ijsebillinsystem.dto.StudentDTO;
import lk.ijse.ijsebillinsystem.querydto.RegisterStudentToAnothoerBatchQueryDTO;
import lk.ijse.ijsebillinsystem.service.custom.StudentService;

/**
 *
 * @author user
 */
public class StudentServiceImpl implements StudentService{
    
    private StudentDAO studentDAO;

    public StudentServiceImpl() {
        studentDAO=(StudentDAO) DAOFactory.getInstance().getConnection(DAOFactory.DAOType.STUDENTDAO);
    }
    
    

    @Override
    public boolean save(StudentDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(StudentDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(StudentDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StudentDTO find(String id) throws Exception {
        StudentDTO studentDTO=studentDAO.find(id);
        if(studentDTO!=null){
            return studentDTO;
        }else{
            return null;
        }
    }

    @Override
    public List<StudentDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RegisterStudentToAnothoerBatchQueryDTO> getStudentDetails(String sid,String status) throws Exception {
        List<RegisterStudentToAnothoerBatchQueryDTO>registerStudentToAnothoerBatchQueryDTOs=studentDAO.getStudentDetails(sid,status);
        if(registerStudentToAnothoerBatchQueryDTOs!=null){
            return registerStudentToAnothoerBatchQueryDTOs;
        }else{
            return null;
        }
    }
    
}
