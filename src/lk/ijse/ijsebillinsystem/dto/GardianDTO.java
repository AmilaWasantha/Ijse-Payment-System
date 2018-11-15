/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.dto;

/**
 *
 * @author user
 */
public class GardianDTO extends SuperDTO{
    private String gardianId;
    private String name;
    private String mobile_1;
    private String mobile_2;
    private String email;
    private String designation;
    private String workingPlace;
    private String address;

    public GardianDTO() {
        
    }

    public GardianDTO(String gardianId, String name, String mobile_1, String mobile_2, String email, String designation, String workingPlace, String address) {
        this.gardianId = gardianId;
        this.name = name;
        this.mobile_1 = mobile_1;
        this.mobile_2 = mobile_2;
        this.email = email;
        this.designation = designation;
        this.workingPlace = workingPlace;
        this.address = address;
    }

    public GardianDTO(String gardianId) {
        this.gardianId=gardianId;
    }

    /**
     * @return the gardianId
     */
    public String getGardianId() {
        return gardianId;
    }

    /**
     * @param gardianId the gardianId to set
     */
    public void setGardianId(String gardianId) {
        this.gardianId = gardianId;
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
     * @return the mobile_1
     */
    public String getMobile_1() {
        return mobile_1;
    }

    /**
     * @param mobile_1 the mobile_1 to set
     */
    public void setMobile_1(String mobile_1) {
        this.mobile_1 = mobile_1;
    }

    /**
     * @return the mobile_2
     */
    public String getMobile_2() {
        return mobile_2;
    }

    /**
     * @param mobile_2 the mobile_2 to set
     */
    public void setMobile_2(String mobile_2) {
        this.mobile_2 = mobile_2;
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
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @return the workingPlace
     */
    public String getWorkingPlace() {
        return workingPlace;
    }

    /**
     * @param workingPlace the workingPlace to set
     */
    public void setWorkingPlace(String workingPlace) {
        this.workingPlace = workingPlace;
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

    @Override
    public String toString() {
        return "GardianDTO{" + "gardianId=" + gardianId + ", name=" + name + ", mobile_1=" + mobile_1 + ", mobile_2=" + mobile_2 + ", email=" + email + ", designation=" + designation + ", workingPlace=" + workingPlace + ", address=" + address + '}';
    }
    
    
}
