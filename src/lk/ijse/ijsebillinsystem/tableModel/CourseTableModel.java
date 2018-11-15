/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.tableModel;

/**
 *
 * @author user
 */
public class CourseTableModel {
    private String courseId;
    private String courseName;
    private String courseType;
    private double courseFee;
    private int latePayment;
    private String duration;
    private String courseDiscount;

    public CourseTableModel() {
    }

    public CourseTableModel(String courseId, String courseName, String courseType, double courseFee, int latePayment, String duration, String courseDiscount) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseType = courseType;
        this.courseFee = courseFee;
        this.latePayment = latePayment;
        this.duration = duration;
        this.courseDiscount = courseDiscount;
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
     * @return the courseFee
     */
    public double getCourseFee() {
        return courseFee;
    }

    /**
     * @param courseFee the courseFee to set
     */
    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

    /**
     * @return the latePayment
     */
    public int getLatePayment() {
        return latePayment;
    }

    /**
     * @param latePayment the latePayment to set
     */
    public void setLatePayment(int latePayment) {
        this.latePayment = latePayment;
    }

    /**
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * @return the courseDiscount
     */
    public String getCourseDiscount() {
        return courseDiscount;
    }

    /**
     * @param courseDiscount the courseDiscount to set
     */
    public void setCourseDiscount(String courseDiscount) {
        this.courseDiscount = courseDiscount;
    }
    
    
}
