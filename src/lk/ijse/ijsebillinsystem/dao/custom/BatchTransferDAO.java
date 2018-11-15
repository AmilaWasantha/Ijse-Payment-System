/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.dao.custom;

import java.util.List;
import lk.ijse.ijsebillinsystem.dao.SuperDAO;
import lk.ijse.ijsebillinsystem.dto.BatchDTO;
import lk.ijse.ijsebillinsystem.dto.BatchTransferDTO;
import lk.ijse.ijsebillinsystem.querydto.BatchTransferQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.CalculateIncomeQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.CheckPaymentForTransferStudentQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.GetBatchDetailsForTransferQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.GetNotStartBatchForTranserStudentQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.GetStudentDetailsForTransferQueryDTO;

/**
 *
 * @author user
 */
public interface BatchTransferDAO extends SuperDAO<BatchTransferDTO, String>{
    public List<BatchTransferQueryDTO>getStudentDetails(String nic)throws Exception;
    public List<GetStudentDetailsForTransferQueryDTO>getStudentDetailsForTransfer(String sid,String Status)throws Exception;
    public List<GetBatchDetailsForTransferQueryDTO>getBatchDetailsForTransfer(String sid,String coursName)throws Exception;
    public List<GetNotStartBatchForTranserStudentQueryDTO>getNotStartBatch(String coursName,String status)throws Exception;
    public List<CheckPaymentForTransferStudentQueryDTO>getPaymentDetails(String sid,String coursName)throws Exception;
    public BatchDTO findBatchIDByBatchName(String batchName)throws Exception;
    public CalculateIncomeQueryDTO getIncomeForBatchTransferFee(String month,String year)throws Exception;
    public CalculateIncomeQueryDTO getDailyIncomeByBatchTransfer(String day,String month,String year)throws Exception;
    public CalculateIncomeQueryDTO getYearlyIncome(String year)throws Exception;
}
