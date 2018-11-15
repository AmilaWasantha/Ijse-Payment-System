/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.controller.custom.impl;

import java.util.List;
import lk.ijse.ijsebillinsystem.controller.custom.BatchTransferController;
import lk.ijse.ijsebillinsystem.dto.BatchDTO;
import lk.ijse.ijsebillinsystem.dto.BatchRegistrationDTO;
import lk.ijse.ijsebillinsystem.dto.BatchTransferDTO;
import lk.ijse.ijsebillinsystem.dto.PaymentDTO;
import lk.ijse.ijsebillinsystem.querydto.BatchTransferQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.CalculateIncomeQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.CheckPaymentForTransferStudentQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.GetBatchDetailsForTransferQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.GetNotStartBatchForTranserStudentQueryDTO;
import lk.ijse.ijsebillinsystem.querydto.GetStudentDetailsForTransferQueryDTO;
import lk.ijse.ijsebillinsystem.service.ServiceFactory;
import lk.ijse.ijsebillinsystem.service.custom.BatchTransferService;

/**
 *
 * @author user
 */
public class BatchTransferControllerImpl implements BatchTransferController{
    private BatchTransferService batchTransferService;

    public BatchTransferControllerImpl() {
        batchTransferService=(BatchTransferService) ServiceFactory.getInstance().getConnection(ServiceFactory.getServiceType.BATCHTRANSFERSERVICE);
    }
    
    

    @Override
    public boolean save(BatchTransferDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(BatchTransferDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(BatchTransferDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BatchTransferDTO find(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BatchTransferDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BatchTransferQueryDTO> getAllStudentdetails(String nic) throws Exception {
        List<BatchTransferQueryDTO>dTOs=batchTransferService.getStudentDetails(nic);
        if(dTOs!=null){
            return dTOs;
        }else{
            return null;
        }
    }

    @Override
    public List<GetStudentDetailsForTransferQueryDTO> getStudentDetailsForTransfer(String sid,String status) throws Exception {
        List<GetStudentDetailsForTransferQueryDTO>dtos=batchTransferService.getStudentDetailsForTransfer(sid,status);
        if(dtos!=null){
            return dtos;
        }else{
            return null;
        }
    }

    @Override
    public List<GetBatchDetailsForTransferQueryDTO> getBatchDetailsForTransfer(String sid, String coursName) throws Exception {
        List<GetBatchDetailsForTransferQueryDTO>dTOs=batchTransferService.getBatchDetailsForTransfer(sid, coursName);
        if(dTOs!=null){
            return dTOs;
        }else{
            return null;
        }
    }

    @Override
    public List<GetNotStartBatchForTranserStudentQueryDTO> getNotStartBatch(String coursName, String status) throws Exception {
        List<GetNotStartBatchForTranserStudentQueryDTO>dTOs=batchTransferService.getNotStartBatch(coursName, status);
        if(dTOs!=null){
            return dTOs;
        }else{
            return null;
        }
    }

    @Override
    public List<CheckPaymentForTransferStudentQueryDTO> getPaymentDetails(String sid, String coursName) throws Exception {
        List<CheckPaymentForTransferStudentQueryDTO>dTOs=batchTransferService.getPaymentDetails(sid, coursName);
        if(dTOs!=null){
            return dTOs;
        }else{
            return null;
        }
    }

    @Override
    public BatchDTO getBatchIDByBatchName(String batchName) throws Exception {
        BatchDTO batchDTO=batchTransferService.getBatchIDByBatchName(batchName);
        if(batchDTO!=null){
            return batchDTO;
        }else{
            return null;
        }
    }

    @Override
    public boolean manageBatchTransfer(BatchRegistrationDTO batchRegistrationDTO, BatchTransferDTO batchTransferDTO, PaymentDTO paymentDTO) throws Exception {
        return batchTransferService.manageBatchTransfer(batchRegistrationDTO, batchTransferDTO, paymentDTO);
    }

    @Override
    public CalculateIncomeQueryDTO getIncomeForBatchTransferFee(String month, String year) throws Exception {
        CalculateIncomeQueryDTO dto=batchTransferService.getIncomeForBatchTransferFee(month, year);
        if(dto!=null){
            return dto;
        }else{
            return null;
        }
    }

    @Override
    public CalculateIncomeQueryDTO getDailyIncomeByBatchTransfer(String day, String month, String year) throws Exception {
        CalculateIncomeQueryDTO dto=batchTransferService.getDailyIncomeByBatchTransfer(day, month, year);
        if(dto!=null){
            return dto;
        }else{
            return null;
        }
    }

    @Override
    public CalculateIncomeQueryDTO getYearlyIncome(String year) throws Exception {
        CalculateIncomeQueryDTO dto=batchTransferService.getYearlyIncome(year);
        if(dto!=null){
            return dto;
        }else{
            return null;
        }
    }
    
}
