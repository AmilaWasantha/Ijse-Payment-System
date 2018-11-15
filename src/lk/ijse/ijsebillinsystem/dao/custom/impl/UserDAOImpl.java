/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import lk.ijse.ijsebillinsystem.conncetion.DBFactory;
import lk.ijse.ijsebillinsystem.dao.custom.UserDAO;
import lk.ijse.ijsebillinsystem.dto.UserDTO;

/**
 *
 * @author user
 */
public class UserDAOImpl implements UserDAO{
    
    private Connection connection;

    public UserDAOImpl() {
        connection=DBFactory.getInstance().getConnection(DBFactory.connectionType.DBCONNECTION).getConnection();
        
    }
    
    

    @Override
    public boolean save(UserDTO userDTO) throws Exception {
            int res=-1;
            String sql="insert into user values(?, password(?))";
            PreparedStatement pstm=connection.prepareStatement(sql);
            pstm.setObject(1,userDTO.getUserName());
            pstm.setObject(2,userDTO.getPassword());
            res=pstm.executeUpdate();
            if(res>0){
                return true;
            }else{
                return false;
            }
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
    public List<UserDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean UserLogint(UserDTO userDTO) throws Exception {
            boolean res=false;
            String sql="select * from user where USER_NAME=? AND PASSWORD = password(?)";
            PreparedStatement pstm=connection.prepareStatement(sql);
            pstm.setObject(1,userDTO.getUserName());
            pstm.setObject(2,userDTO.getPassword());
            ResultSet rst=pstm.executeQuery();
            res=rst.next();
            return res;
    }
    
}
