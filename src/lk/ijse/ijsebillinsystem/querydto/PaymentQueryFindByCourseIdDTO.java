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
public class PaymentQueryFindByCourseIdDTO {
    private String studentID;
    private String name;
    private String registerID;
    private String bathcID;
    private String batchStartDate;
    private String batchName;
    private String courseName;
    private String courseId;
    private double courseFee;
    private String discount;
    private String latePayment;

    public PaymentQueryFindByCourseIdDTO() {
    }

    public PaymentQueryFindByCourseIdDTO(String studentID, String name, String registerID, String bathcID, String batchStartDate, String batchName, String courseName, String courseId, double courseFee, String discount, String latePayment) {
        this.studentID = studentID;
        this.name = name;
        this.registerID = registerID;
        this.bathcID = bathcID;
        this.batchStartDate = batchStartDate;
        this.batchName = batchName;
        this.courseName = courseName;
        this.courseId = courseId;
        this.courseFee = courseFee;
        this.discount = discount;
        this.latePayment = latePayment;
    }

    /**
     * @return the studentID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the registerID
     */
    public String getRegisterID() {
        return registerID;
    }

    /**
     * @param registerID the registerID to set
     */
    public void setRegisterID(String registerID) {
        this.registerID = registerID;
    }

    /**
     * @return the bathcID
     */
    public String getBathcID() {
        return bathcID;
    }

    /**
     * @param bathcID the bathcID to set
     */
    public void setBathcID(String bathcID) {
        this.bathcID = bathcID;
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
        return "PaymentQueryFindByCourseIdDTO{" + "studentID=" + studentID + ", name=" + name + ", registerID=" + registerID + ", bathcID=" + bathcID + ", batchStartDate=" + batchStartDate + ", batchName=" + batchName + ", courseName=" + courseName + ", courseId=" + courseId + ", courseFee=" + courseFee + ", discount=" + discount + ", latePayment=" + latePayment + '}';
    }
    
    
}
