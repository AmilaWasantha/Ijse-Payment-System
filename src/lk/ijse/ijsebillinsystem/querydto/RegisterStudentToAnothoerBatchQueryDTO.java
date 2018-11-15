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
public class RegisterStudentToAnothoerBatchQueryDTO {
    private String studentName;
    private String courseName;

    public RegisterStudentToAnothoerBatchQueryDTO() {
    }

    public RegisterStudentToAnothoerBatchQueryDTO(String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
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

    
    
    
}
