/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.billingsystem.dto;

/**
 *
 * @author kavii
 */
public class RegistrationDto {
    private int id;
    private StudentDto studentDto;
    private BatchCoursedetailsDto batchCoursedetailsDto;
    private String date;
    private double fee;

    public RegistrationDto() {
    }

    public RegistrationDto(int id, StudentDto studentDto, BatchCoursedetailsDto batchCoursedetailsDto, String date, double fee) {
        this.id = id;
        this.studentDto = studentDto;
        this.batchCoursedetailsDto = batchCoursedetailsDto;
        this.date = date;
        this.fee = fee;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the studentDto
     */
    public StudentDto getStudentDto() {
        return studentDto;
    }

    /**
     * @param studentDto the studentDto to set
     */
    public void setStudentDto(StudentDto studentDto) {
        this.studentDto = studentDto;
    }

    /**
     * @return the batchCoursedetailsDto
     */
    public BatchCoursedetailsDto getBatchCoursedetailsDto() {
        return batchCoursedetailsDto;
    }

    /**
     * @param batchCoursedetailsDto the batchCoursedetailsDto to set
     */
    public void setBatchCoursedetailsDto(BatchCoursedetailsDto batchCoursedetailsDto) {
        this.batchCoursedetailsDto = batchCoursedetailsDto;
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
     * @return the fee
     */
    public double getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(double fee) {
        this.fee = fee;
    }
        
}
