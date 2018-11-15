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
public class BatchQueryDTO {
    
    private String batchId;
    private String coursId;
    private String batchName;
    private String date;
    private String status;
    private String coursName;

    public BatchQueryDTO() {
    }

    public BatchQueryDTO(String batchId, String coursId, String batchName, String date, String status, String coursName) {
        this.batchId = batchId;
        this.coursId = coursId;
        this.batchName = batchName;
        this.date = date;
        this.status = status;
        this.coursName = coursName;
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
     * @return the coursId
     */
    public String getCoursId() {
        return coursId;
    }

    /**
     * @param coursId the coursId to set
     */
    public void setCoursId(String coursId) {
        this.coursId = coursId;
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
     * @return the coursName
     */
    public String getCoursName() {
        return coursName;
    }

    /**
     * @param coursName the coursName to set
     */
    public void setCoursName(String coursName) {
        this.coursName = coursName;
    }

    @Override
    public String toString() {
        return "BatchQuery{" + "batchId=" + batchId + ", coursId=" + coursId + ", batchName=" + batchName + ", date=" + date + ", status=" + status + ", coursName=" + coursName + '}';
    }
    
    
    
}
