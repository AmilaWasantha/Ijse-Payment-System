/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.querydto;

/**
 *
 * @author user
 */
public class BatchDetailsForNewRegistrationDTO {
    private String batchId;
    private String status;
    private String batchName;

    public BatchDetailsForNewRegistrationDTO() {
    }

    public BatchDetailsForNewRegistrationDTO(String batchId, String status, String batchName) {
        this.batchId = batchId;
        this.status = status;
        this.batchName = batchName;
    }

    /**
     * @return the batchId
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * @param batchId the batchId to set
     */
    public void setBatchId(String batchId) {
        this.batchId = batchId;
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

    /**
     * @return the batchName
     */
    public String getBatchName() {
        return batchName;
    }

    /**
     * @param batchName the batchName to set
     */
    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    @Override
    public String toString() {
        return "BatchDetailsForNewRegistrationDTO{" + "batchId=" + batchId + ", status=" + status + ", batchName=" + batchName + '}';
    }
    
    
    
}
