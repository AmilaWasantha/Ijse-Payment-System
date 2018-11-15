/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.controller.custom;

import java.util.List;
import lk.ijse.ijsebillinsystem.controller.SuperController;
import lk.ijse.ijsebillinsystem.dto.StudentDTO;
import lk.ijse.ijsebillinsystem.querydto.RegisterStudentToAnothoerBatchQueryDTO;

/**
 *
 * @author user
 */
public interface StudentController extends SuperController<StudentDTO, String>{
    
    public List<RegisterStudentToAnothoerBatchQueryDTO>getStudentDetails(String sid,String status)throws Exception;
}
