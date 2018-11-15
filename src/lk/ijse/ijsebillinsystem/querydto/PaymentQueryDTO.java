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
public class PaymentQueryDTO {
    private String studentId;
    private String studentName;
    private String registrationId;
    private String batchId;
    private String batchStartDate;
    private String batchName;
    private String courseName;
    private String courseId;
    private double courseFee;
    private String discount;
    private String latePayment;

    public PaymentQueryDTO() {
    }

    public PaymentQueryDTO(String studentId, String studentName, String registrationId, String batchId, String batchStartDate, String batchName, String courseName, String courseId, double courseFee, String discount, String latePayment) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.registrationId = registrationId;
        this.batchId = batchId;
        this.batchStartDate = batchStartDate;
        this.batchName = batchName;
        this.courseName = courseName;
        this.courseId = courseId;
        this.courseFee = courseFee;
        this.discount = discount;
        this.latePayment = latePayment;
    }

    /**
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return the registrationId
     */
    public String getRegistrationId() {
        return registrationId;
    }

    /**
     * @param registrationId the registrationId to set
     */
    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
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
     * @return the discount
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(String discount) {
        this.discount = discount;
    }

    /**
     * @return the latePayment
     */
    public String getLatePayment() {
        return latePayment;
    }

    /**
     * @param latePayment the latePayment to set
     */
    public void setLatePayment(String latePayment) {
        this.latePayment = latePayment;
    }

    @Override
    public String toString() {
        return "PaymentQueryDTO{" + "studentId=" + studentId + ", studentName=" + studentName + ", registrationId=" + registrationId + ", batchId=" + batchId + ", batchStartDate=" + batchStartDate + ", batchName=" + batchName + ", courseName=" + courseName + ", courseId=" + courseId + ", courseFee=" + courseFee + ", discount=" + discount + ", latePayment=" + latePayment + '}';
    }

    

   
    
    
}
