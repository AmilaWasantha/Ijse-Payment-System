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
public class BatchRegistrationDTO extends SuperDTO{
    private String rid;
    private StudentDTO studentDTO;
    private BatchDTO batchDTO;
    private String date;
    private String batchStartDate;
    private double fee;
    private String status;

    public BatchRegistrationDTO() {
    }

    public BatchRegistrationDTO(String rid, StudentDTO studentDTO, BatchDTO batchDTO, String date, String batchStartDate, double fee, String status) {
        this.rid = rid;
        this.studentDTO = studentDTO;
        this.batchDTO = batchDTO;
        this.date = date;
        this.batchStartDate = batchStartDate;
        this.fee = fee;
        this.status = status;
    }

    /**
     * @return the rid
     */
    public String getRid() {
        return rid;
    }

    /**
     * @param rid the rid to set
     */
    public void setRid(String rid) {
        this.rid = rid;
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
     * @return the batchStartDate
     */
    public String getBatchStartDate() {
        return batchStartDate;
    }

    /**
     * @param batchStartDate the batchStartDate to set
     */
    public void setBatchStartDate(String batchStartDate) {
        this.batchStartDate = batchStartDate;
    }

    /**
     * @return the fee
     */
    public double getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(double fee) {
        this.fee = fee;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BatchRegistrationDTO{" + "rid=" + rid + ", studentDTO=" + studentDTO + ", batchDTO=" + batchDTO + ", date=" + date + ", batchStartDate=" + batchStartDate + ", fee=" + fee + ", status=" + status + '}';
    }

    

    
    
    
}
