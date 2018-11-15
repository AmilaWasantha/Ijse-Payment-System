/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.service.custom;

import lk.ijse.ijsebillinsystem.dto.BatchRegistrationDTO;
import lk.ijse.ijsebillinsystem.querydto.CalculateIncomeQueryDTO;
import lk.ijse.ijsebillinsystem.service.SuperService;

/**
 *
 * @author user
 */
public interface BatchRegistrationService extends SuperService<BatchRegistrationDTO, String>{
    
    public boolean registrationToAnotherBatch(BatchRegistrationDTO dto)throws Exception;
    public boolean afterBatchTransfer(BatchRegistrationDTO batchRegistrationDTO)throws Exception;
    
    public CalculateIncomeQueryDTO getIncomeForMonth(String month,String year)throws Exception;
    public CalculateIncomeQueryDTO getDailyIncomeByRegistration(String day,String month,String year)throws Exception;
    public CalculateIncomeQueryDTO getYearlyIncome(String year)throws Exception;
}
