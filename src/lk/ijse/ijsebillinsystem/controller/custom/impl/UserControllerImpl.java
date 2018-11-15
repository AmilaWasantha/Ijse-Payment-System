/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.controller.custom.impl;

import java.util.List;
import lk.ijse.ijsebillinsystem.controller.custom.UserController;
import lk.ijse.ijsebillinsystem.dto.UserDTO;
import lk.ijse.ijsebillinsystem.service.ServiceFactory;
import lk.ijse.ijsebillinsystem.service.custom.UserService;

/**
 *
 * @author user
 */
public class UserControllerImpl implements UserController{
    
    private UserService userService;

    public UserControllerImpl() {
        userService=(UserService) ServiceFactory.getInstance().getConnection(ServiceFactory.getServiceType.USER);
    }
    
    

    @Override
    public boolean save(UserDTO userDTO) throws Exception {
        return userService.save(userDTO);
    }

    @Override
    public boolean update(UserDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(UserDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserDTO find(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean UserLogint(UserDTO userDTO) throws Exception {
        return userService.UserLogint(userDTO);
    }
    
}
