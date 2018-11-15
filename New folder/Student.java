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
import javax.persistence.OneToOne;

/**
 *
 * @author kavii
 */
@Entity
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nameWith;
    private String name;
    private String address;
    private String email;
    private String gender;
    private String nic;
    private String bDay;
    private String homeTel;
    private String mobileTel;
    private String school;
    private String uni;
    private String faculty;
    private String edu;
    
    @OneToOne
    private Parent parent;

    public Student() {
    }

    public Student(int id, String nameWith, String name, String address, String email, String gender, String nic, String bDay, String homeTel, String mobileTel, String school, String uni, String faculty, String edu, Parent parent) {
        this.id = id;
        this.nameWith = nameWith;
        this.name = name;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.nic = nic;
        this.bDay = bDay;
        this.homeTel = homeTel;
        this.mobileTel = mobileTel;
        this.school = school;
        this.uni = uni;
        this.faculty = faculty;
        this.edu = edu;
        this.parent = parent;
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
     * @return the nameWith
     */
    public String getNameWith() {
        return nameWith;
    }

    /**
     * @param nameWith the nameWith to set
     */
    public void setNameWith(String nameWith) {
        this.nameWith = nameWith;
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

    /**
     * @return the bDay
     */
    public String getbDay() {
        return bDay;
    }

    /**
     * @param bDay the bDay to set
     */
    public void setbDay(String bDay) {
        this.bDay = bDay;
    }

    /**
     * @return the homeTel
     */
    public String getHomeTel() {
        return homeTel;
    }

    /**
     * @param homeTel the homeTel to set
     */
    public void setHomeTel(String homeTel) {
        this.homeTel = homeTel;
    }

    /**
     * @return the mobileTel
     */
    public String getMobileTel() {
        return mobileTel;
    }

    /**
     * @param mobileTel the mobileTel to set
     */
    public void setMobileTel(String mobileTel) {
        this.mobileTel = mobileTel;
    }

    /**
     * @return the school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school the school to set
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * @return the uni
     */
    public String getUni() {
        return uni;
    }

    /**
     * @param uni the uni to set
     */
    public void setUni(String uni) {
        this.uni = uni;
    }

    /**
     * @return the faculty
     */
    public String getFaculty() {
        return faculty;
    }

    /**
     * @param faculty the faculty to set
     */
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    /**
     * @return the edu
     */
    public String getEdu() {
        return edu;
    }

    /**
     * @param edu the edu to set
     */
    public void setEdu(String edu) {
        this.edu = edu;
    }

    /**
     * @return the parent
     */
    public Parent getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Parent parent) {
        this.parent = parent;
    }
    
    
}
