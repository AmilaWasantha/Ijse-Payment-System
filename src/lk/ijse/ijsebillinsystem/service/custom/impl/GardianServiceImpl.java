/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.service.custom.impl;

import java.util.List;
import lk.ijse.ijsebillinsystem.dao.DAOFactory;
import lk.ijse.ijsebillinsystem.dao.custom.GardianDAO;
import lk.ijse.ijsebillinsystem.dto.GardianDTO;
import lk.ijse.ijsebillinsystem.service.custom.GardianService;

/**
 *
 * @author user
 */
public class GardianServiceImpl implements GardianService{
    private GardianDAO gardianDAO;

    public GardianServiceImpl() {
        gardianDAO=(GardianDAO) DAOFactory.getInstance().getConnection(DAOFactory.DAOType.GARDIANDAO);
    }
    
    

    @Override
    public boolean save(GardianDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public List<GardianDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
