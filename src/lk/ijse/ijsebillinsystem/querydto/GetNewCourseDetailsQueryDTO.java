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
public class GetNewCourseDetailsQueryDTO {
    private String courseType;
    private String courseId;
    private String batchName;

    public GetNewCourseDetailsQueryDTO() {
    }

    public GetNewCourseDetailsQueryDTO(String courseType, String courseId, String batchName) {
        this.courseType = courseType;
        this.courseId = courseId;
        this.batchName = batchName;
    }

    /**
     * @return the courseType
     */
    public String getCourseType() {
        return courseType;
    }

    /**
     * @param courseType the courseType to set
     */
    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    /**
     * @return the courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
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
        return "GetNewCourseDetailsQueryDTO{" + "courseType=" + courseType + ", courseId=" + courseId + ", batchName=" + batchName + '}';
    }
    
     
}
