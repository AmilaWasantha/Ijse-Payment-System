/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.billingsystem.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author kavii
 */
@Entity
public class Registration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private Student student;
    
    @OneToOne(cascade = CascadeType.ALL)
    private BatchCourseDetails batchCourseDetails;

    private String date;
    private double fee;

    public Registration() {
    }

    public Registration(int id, Student student, BatchCourseDetails batchCourseDetails, String date, double fee) {
        this.id = id;
        this.student = student;
        this.batchCourseDetails = batchCourseDetails;
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
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * @return the batchCourseDetails
     */
    public BatchCourseDetails getBatchCourseDetails() {
        return batchCourseDetails;
    }

    /**
     * @param batchCourseDetails the batchCourseDetails to set
     */
    public void setBatchCourseDetails(BatchCourseDetails batchCourseDetails) {
        this.batchCourseDetails = batchCourseDetails;
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
