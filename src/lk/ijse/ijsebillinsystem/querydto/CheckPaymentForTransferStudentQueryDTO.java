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
public class CheckPaymentForTransferStudentQueryDTO {
    private String paymentId;
    private String studentId;
    private String coursName;
    private String paymentType;
    private String date;

    public CheckPaymentForTransferStudentQueryDTO() {
    }

    public CheckPaymentForTransferStudentQueryDTO(String paymentId, String studentId, String coursName, String paymentType, String date) {
        this.paymentId = paymentId;
        this.studentId = studentId;
        this.coursName = coursName;
        this.paymentType = paymentType;
        this.date = date;
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

    @Override
    public String toString() {
        return "CheckPaymentForTransferStudentQueryDTO{" + "paymentId=" + paymentId + ", studentId=" + studentId + ", coursName=" + coursName + ", paymentType=" + paymentType + ", date=" + date + '}';
    }

   

    
    
    
    
}
