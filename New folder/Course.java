/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.billingsystem.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author kavii
 */
@Entity
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String name;
    private String type;
    private double fee;
    private int discount;
    private int late;
    private String duration;
    private int limt;
    private String start;
    private String end;
    private int tax;

    public Course() {
    }

    public Course(int id, String name, String type, double fee, int discount, int late, String duration, int limt, String start, String end, int tax) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.fee = fee;
        this.discount = discount;
        this.late = late;
        this.duration = duration;
        this.limt = limt;
        this.start = start;
        this.end = end;
        this.tax = tax;
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

    /**
     * @return the discount
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    /**
     * @return the late
     */
    public int getLate() {
        return late;
    }

    /**
     * @param late the late to set
     */
    public void setLate(int late) {
        this.late = late;
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
     * @return the limt
     */
    public int getLimt() {
        return limt;
    }

    /**
     * @param limt the limt to set
     */
    public void setLimt(int limt) {
        this.limt = limt;
    }

    /**
     * @return the start
     */
    public String getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public String getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * @return the tax
     */
    public int getTax() {
        return tax;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(int tax) {
        this.tax = tax;
    }


    /**
     * @return the id
     */
    
    
}
