/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.controller.custom;

import lk.ijse.ijsebillinsystem.controller.SuperController;
import lk.ijse.ijsebillinsystem.dto.BatchRegistrationDTO;
import lk.ijse.ijsebillinsystem.querydto.CalculateIncomeQueryDTO;

/**
 *
 * @author user
 */
public interface BatchRegistrationController extends SuperController<BatchRegistrationDTO, String>{
    
    public boolean registrationToAnotherBatch(BatchRegistrationDTO dto)throws Exception;
    public boolean afterBatchTransfer(BatchRegistrationDTO batchRegistrationDTO)throws Exception;
    public CalculateIncomeQueryDTO getIncomeForMonth(String month,String year)throws Exception;
    public CalculateIncomeQueryDTO getDailyIncomeByRegistration(String day,String month,String year)throws Exception;
    public CalculateIncomeQueryDTO getYearlyIncome(String year)throws Exception;
}
