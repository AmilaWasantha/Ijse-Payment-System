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
public class BatchCourseDTO extends SuperDTO{
    private String batchCourseId;
    private BatchDTO batchDTO;
    private CourseDTO courseDTO;
    private String batchName;
    private String date;
    private String type;
    private String status;

    public BatchCourseDTO() {
    }

    public BatchCourseDTO(String batchCourseId, BatchDTO batchDTO, CourseDTO courseDTO, String batchName, String date, String type, String status) {
        this.batchCourseId = batchCourseId;
        this.batchDTO = batchDTO;
        this.courseDTO = courseDTO;
        this.batchName = batchName;
        this.date = date;
        this.type = type;
        this.status = status;
    }

    /**
     * @return the batchCourseId
     */
    public String getBatchCourseId() {
        return batchCourseId;
    }

    /**
     * @param batchCourseId the batchCourseId to set
     */
    public void setBatchCourseId(String batchCourseId) {
        this.batchCourseId = batchCourseId;
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
     * @return the courseDTO
     */
    public CourseDTO getCourseDTO() {
        return courseDTO;
    }

    /**
     * @param courseDTO the courseDTO to set
     */
    public void setCourseDTO(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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
        return "BatchCourseDTO{" + "batchCourseId=" + batchCourseId + ", batchDTO=" + batchDTO + ", courseDTO=" + courseDTO + ", batchName=" + batchName + ", date=" + date + ", type=" + type + ", status=" + status + '}';
    }

    

   
    
    
}
