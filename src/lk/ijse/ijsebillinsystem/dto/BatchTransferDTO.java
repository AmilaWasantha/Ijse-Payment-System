/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.dto;

/**
 *
 * @author user
 */
public class BatchTransferDTO extends SuperDTO{
    private String batch_transfer_id;
    private StudentDTO studentDTO;
    private String reason;
    private String date;
    private BatchDTO batchDTO;
    private String newBatch;
    private double transferfee;

    public BatchTransferDTO() {
    }

    public BatchTransferDTO(String batch_transfer_id, StudentDTO studentDTO, String reason, String date, BatchDTO batchDTO, String newBatch, double transferfee) {
        this.batch_transfer_id = batch_transfer_id;
        this.studentDTO = studentDTO;
        this.reason = reason;
        this.date = date;
        this.batchDTO = batchDTO;
        this.newBatch = newBatch;
        this.transferfee = transferfee;
    }

    /**
     * @return the batch_transfer_id
     */
    public String getBatch_transfer_id() {
        return batch_transfer_id;
    }

    /**
     * @param batch_transfer_id the batch_transfer_id to set
     */
    public void setBatch_transfer_id(String batch_transfer_id) {
        this.batch_transfer_id = batch_transfer_id;
    }

    /**
     * @return the studentDTO
     */
    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    /**
     * @param studentDTO the studentDTO to set
     */
    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the batchDTO
     */
    public BatchDTO getBatchDTO() {
        return batchDTO;
    }

    /**
     * @param batchDTO the batchDTO to set
     */
    public void setBatchDTO(BatchDTO batchDTO) {
        this.batchDTO = batchDTO;
    }

    /**
     * @return the newBatch
     */
    public String getNewBatch() {
        return newBatch;
    }

    /**
     * @param newBatch the newBatch to set
     */
    public void setNewBatch(String newBatch) {
        this.newBatch = newBatch;
    }

    /**
     * @return the transferfee
     */
    public double getTransferfee() {
        return transferfee;
    }

    /**
     * @param transferfee the transferfee to set
     */
    public void setTransferfee(double transferfee) {
        this.transferfee = transferfee;
    }

    @Override
    public String toString() {
        return "BatchTransferDTO{" + "batch_transfer_id=" + batch_transfer_id + ", studentDTO=" + studentDTO + ", reason=" + reason + ", date=" + date + ", batchDTO=" + batchDTO + ", newBatch=" + newBatch + ", transferfee=" + transferfee + '}';
    }

    
    
    
}
