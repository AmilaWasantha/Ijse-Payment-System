/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.service.custom.impl;

import java.util.List;
import lk.ijse.ijsebillinsystem.dao.DAOFactory;
import lk.ijse.ijsebillinsystem.dao.custom.UserDAO;
import lk.ijse.ijsebillinsystem.dto.UserDTO;
import lk.ijse.ijsebillinsystem.service.custom.UserService;

/**
 *
 * @author user
 */
public class UserServiceImpl implements UserService{
    private UserDAO userDAO;

    public UserServiceImpl() {
        userDAO=(UserDAO) DAOFactory.getInstance().getConnection(DAOFactory.DAOType.USERDAO);
    }
    
    

    @Override
    public boolean save(UserDTO userDTO) throws Exception {
       return userDAO.save(userDTO);
    }

    @Override
    public boolean delete(UserDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(UserDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserDTO find(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean UserLogint(UserDTO userDTO) throws Exception {
        return userDAO.UserLogint(userDTO);
    }
    
}
