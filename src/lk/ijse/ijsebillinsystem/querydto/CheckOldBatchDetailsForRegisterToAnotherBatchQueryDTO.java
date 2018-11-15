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
public class CheckOldBatchDetailsForRegisterToAnotherBatchQueryDTO {
    private String coursType;
    private String batchName;
    private String batchStatus;

    public CheckOldBatchDetailsForRegisterToAnotherBatchQueryDTO() {
    }

    public CheckOldBatchDetailsForRegisterToAnotherBatchQueryDTO(String coursType, String batchName, String batchStatus) {
        this.coursType = coursType;
        this.batchName = batchName;
        this.batchStatus = batchStatus;
    }

    /**
     * @return the coursType
     */
    public String getCoursType() {
        return coursType;
    }

    /**
     * @param coursType the coursType to set
     */
    public void setCoursType(String coursType) {
        this.coursType = coursType;
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

    /**
     * @return the batchStatus
     */
    public String getBatchStatus() {
        return batchStatus;
    }

    /**
     * @param batchStatus the batchStatus to set
     */
    public void setBatchStatus(String batchStatus) {
        this.batchStatus = batchStatus;
    }

    @Override
    public String toString() {
        return "CheckOldBatchDetailsForRegisterToAnotherBatchQueryDTO{" + "coursType=" + coursType + ", batchName=" + batchName + ", batchStatus=" + batchStatus + '}';
    }
    
    
}
