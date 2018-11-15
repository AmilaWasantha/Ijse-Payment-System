/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.service.custom;

import lk.ijse.ijsebillinsystem.dto.UserDTO;
import lk.ijse.ijsebillinsystem.service.SuperService;

/**
 *
 * @author user
 */
public interface UserService extends SuperService<UserDTO, String>{
    
    public boolean UserLogint(UserDTO userDTO)throws Exception;
}
