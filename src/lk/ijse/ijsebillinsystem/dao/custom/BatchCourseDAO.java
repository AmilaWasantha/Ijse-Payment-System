/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.dao.custom;

import lk.ijse.ijsebillinsystem.dao.SuperDAO;
import lk.ijse.ijsebillinsystem.dto.BatchCourseDTO;
import lk.ijse.ijsebillinsystem.dto.BatchDTO;

/**
 *
 * @author user
 */
public interface BatchCourseDAO extends SuperDAO<BatchCourseDTO, String>{
   public boolean UpdateBatchStatus(BatchDTO batchDTO) throws Exception; 
}
