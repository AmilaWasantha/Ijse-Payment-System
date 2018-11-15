/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import lk.ijse.ijsebillinsystem.conncetion.DBFactory;
import lk.ijse.ijsebillinsystem.dao.custom.GardianDAO;
import lk.ijse.ijsebillinsystem.dto.GardianDTO;

/**
 *
 * @author user
 */
public class GardianDAOImpl implements GardianDAO{
    private Connection connection;

    public GardianDAOImpl() {
        connection=DBFactory.getInstance().getConnection(DBFactory.connectionType.DBCONNECTION).getConnection();
    }
    
    

    @Override
    public boolean save(GardianDTO dto) throws Exception {
        Statement stm= connection.createStatement();
        int res=stm.executeUpdate("insert into gardian values('"+dto.getGardianId()+"','"+dto.getName()+"','"+dto.getMobile_1()+"','"+dto.getMobile_2()+"','"+dto.getEmail()+"','"+dto.getDesignation()+"','"+dto.getWorkingPlace()+"','"+dto.getAddress()+"')");
        if(res>0){
        return true;
    }else{
            return false;
        }
    }

    @Override
    public boolean delete(GardianDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(GardianDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GardianDTO find(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GardianDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
