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
public class FindPaymentOrNotQueryDTO {
    private String paymentId;
    private String registrationId;
    private String studentId;
    private String studentName;
    private String courseId;
    private String courseName;
    private String batchId;
    private String batchName;
    private double fullPayment;
    private String payAmount;
    private String balance;
    private String paymentType;
    
    private String paymentPendinDAte;
    private String discount;

    public FindPaymentOrNotQueryDTO() {
    }

    public FindPaymentOrNotQueryDTO(String paymentId, String registrationId, String studentId, String studentName, String courseId, String courseName, String batchId, String batchName, double fullPayment, String payAmount, String balance, String paymentType, String paymentPendinDAte, String discount) {
        this.paymentId = paymentId;
        this.registrationId = registrationId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseId = courseId;
        this.courseName = courseName;
        this.batchId = batchId;
        this.batchName = batchName;
        this.fullPayment = fullPayment;
        this.payAmount = payAmount;
        this.balance = balance;
        this.paymentType = paymentType;
        this.paymentPendinDAte = paymentPendinDAte;
        this.discount = discount;
    }

    /**
     * @return the paymentId
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * @param paymentId the paymentId to set
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
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
     * @return the fullPayment
     */
    public double getFullPayment() {
        return fullPayment;
    }

    /**
     * @param fullPayment the fullPayment to set
     */
    public void setFullPayment(double fullPayment) {
        this.fullPayment = fullPayment;
    }

    /**
     * @return the payAmount
     */
    public String getPayAmount() {
        return payAmount;
    }

    /**
     * @param payAmount the payAmount to set
     */
    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * @return the balance
     */
    public String getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }

    /**
     * @return the paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * @param paymentType the paymentType to set
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * @return the paymentPendinDAte
     */
    public String getPaymentPendinDAte() {
        return paymentPendinDAte;
    }

    /**
     * @param paymentPendinDAte the paymentPendinDAte to set
     */
    public void setPaymentPendinDAte(String paymentPendinDAte) {
        this.paymentPendinDAte = paymentPendinDAte;
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

    @Override
    public String toString() {
        return "FindPaymentOrNotQueryDTO{" + "paymentId=" + paymentId + ", registrationId=" + registrationId + ", studentId=" + studentId + ", studentName=" + studentName + ", courseId=" + courseId + ", courseName=" + courseName + ", batchId=" + batchId + ", batchName=" + batchName + ", fullPayment=" + fullPayment + ", payAmount=" + payAmount + ", balance=" + balance + ", paymentType=" + paymentType + ", paymentPendinDAte=" + paymentPendinDAte + ", discount=" + discount + '}';
    }

    
}
