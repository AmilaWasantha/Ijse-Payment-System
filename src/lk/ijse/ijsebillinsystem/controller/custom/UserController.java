/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.controller.custom;

import lk.ijse.ijsebillinsystem.controller.SuperController;
import lk.ijse.ijsebillinsystem.dto.UserDTO;

/**
 *
 * @author user
 */
public interface UserController extends SuperController<UserDTO, String>{
  
    public boolean UserLogint(UserDTO userDTO)throws Exception;  
}
