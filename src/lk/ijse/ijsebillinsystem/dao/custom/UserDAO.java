/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.dao.custom;

import lk.ijse.ijsebillinsystem.dao.SuperDAO;
import lk.ijse.ijsebillinsystem.dto.UserDTO;

/**
 *
 * @author user
 */
public interface UserDAO extends SuperDAO<UserDTO, String>{
    public boolean UserLogint(UserDTO userDTO)throws Exception;
}
