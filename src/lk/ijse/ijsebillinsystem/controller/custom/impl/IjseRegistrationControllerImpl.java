/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.controller.custom.impl;

import java.util.List;
import lk.ijse.ijsebillinsystem.controller.custom.IjseRegistrationController;
import lk.ijse.ijsebillinsystem.dto.IjseRegistrationDTO;
import lk.ijse.ijsebillinsystem.service.ServiceFactory;
import lk.ijse.ijsebillinsystem.service.custom.IjseRegistrationService;

/**
 *
 * @author user
 */
public class IjseRegistrationControllerImpl implements IjseRegistrationController{
    
    private IjseRegistrationService ijseRegistrationService;

    public IjseRegistrationControllerImpl() {
        ijseRegistrationService=(IjseRegistrationService) ServiceFactory.getInstance().getConnection(ServiceFactory.getServiceType.IJSEREGISTRATIONSERVICE);
    }
    
    

    @Override
    public boolean save(IjseRegistrationDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(IjseRegistrationDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(IjseRegistrationDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IjseRegistrationDTO find(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IjseRegistrationDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
