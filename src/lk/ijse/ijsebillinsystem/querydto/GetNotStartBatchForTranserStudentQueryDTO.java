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
public class GetNotStartBatchForTranserStudentQueryDTO {
    
    private String batchName;
    private String courseName;
    private String status;

    public GetNotStartBatchForTranserStudentQueryDTO() {
    }

    public GetNotStartBatchForTranserStudentQueryDTO(String batchName, String courseName, String status) {
        this.batchName = batchName;
        this.courseName = courseName;
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

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
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
        return "GetNotStartBatchForTranserStudentQueryDTO{" + "batchName=" + batchName + ", courseName=" + courseName + ", status=" + status + '}';
    }

    
    
    
    
}
