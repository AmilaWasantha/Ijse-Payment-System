/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.controller.custom.impl;

import java.util.List;
import lk.ijse.ijsebillinsystem.controller.custom.BatchRegistrationController;
import lk.ijse.ijsebillinsystem.dto.BatchRegistrationDTO;
import lk.ijse.ijsebillinsystem.querydto.CalculateIncomeQueryDTO;
import lk.ijse.ijsebillinsystem.service.ServiceFactory;
import lk.ijse.ijsebillinsystem.service.custom.BatchRegistrationService;

/**
 *
 * @author user
 */
public class BatchRegistrationControllerImpl implements BatchRegistrationController{
    
    private BatchRegistrationService batchRegistrationService;

    public BatchRegistrationControllerImpl() {
        batchRegistrationService=(BatchRegistrationService) ServiceFactory.getInstance().getConnection(ServiceFactory.getServiceType.BATCHREGISTRATIONSERVICE);
    }
    
    

    @Override
    public boolean save(BatchRegistrationDTO registrationDTO) throws Exception {
        return batchRegistrationService.save(registrationDTO);
    }

    @Override
    public boolean update(BatchRegistrationDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(BatchRegistrationDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BatchRegistrationDTO find(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BatchRegistrationDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registrationToAnotherBatch(BatchRegistrationDTO dto) throws Exception {
        return batchRegistrationService.registrationToAnotherBatch(dto);
    }

    @Override
    public boolean afterBatchTransfer(BatchRegistrationDTO batchRegistrationDTO) throws Exception {
        return batchRegistrationService.afterBatchTransfer(batchRegistrationDTO);
    }

    @Override
    public CalculateIncomeQueryDTO getIncomeForMonth(String month, String year) throws Exception {
        CalculateIncomeQueryDTO dto=batchRegistrationService.getIncomeForMonth(month, year);
        if(dto!=null){
            return dto;
        }else{
            return null;
        }
    }

    @Override
    public CalculateIncomeQueryDTO getDailyIncomeByRegistration(String day, String month, String year) throws Exception {
        CalculateIncomeQueryDTO dto=batchRegistrationService.getDailyIncomeByRegistration(day, month, year);
        if(dto!=null){
            return dto;
        }else{
            return null;
        }
    }

    @Override
    public CalculateIncomeQueryDTO getYearlyIncome(String year) throws Exception {
        CalculateIncomeQueryDTO dto=batchRegistrationService.getYearlyIncome(year);
        if(dto!=null){
            return dto;
        }else{
            return null;
        }
    }
    
}
