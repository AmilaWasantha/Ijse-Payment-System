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
public class StudentDTO extends SuperDTO{
    private String studentId;
    private String nameWithInitials;
    private String address;
    private String city;
    private String home_tel;
    private String mobile_tel;
    private String email;
    private String nic;
    private String bday;
    private String gender;
    private String university;
    private String education;
    private GardianDTO gardianDTO;

    public StudentDTO() {
    }

    public StudentDTO(String studentId, String nameWithInitials, String address, String city, String home_tel, String mobile_tel, String email, String nic, String bday, String gender, String university, String education, GardianDTO gardianDTO) {
        this.studentId = studentId;
        this.nameWithInitials = nameWithInitials;
        this.address = address;
        this.city = city;
        this.home_tel = home_tel;
        this.mobile_tel = mobile_tel;
        this.email = email;
        this.nic = nic;
        this.bday = bday;
        this.gender = gender;
        this.university = university;
        this.education = education;
        this.gardianDTO = gardianDTO;
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
     * @return the nameWithInitials
     */
    public String getNameWithInitials() {
        return nameWithInitials;
    }

    /**
     * @param nameWithInitials the nameWithInitials to set
     */
    public void setNameWithInitials(String nameWithInitials) {
        this.nameWithInitials = nameWithInitials;
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
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the home_tel
     */
    public String getHome_tel() {
        return home_tel;
    }

    /**
     * @param home_tel the home_tel to set
     */
    public void setHome_tel(String home_tel) {
        this.home_tel = home_tel;
    }

    /**
     * @return the mobile_tel
     */
    public String getMobile_tel() {
        return mobile_tel;
    }

    /**
     * @param mobile_tel the mobile_tel to set
     */
    public void setMobile_tel(String mobile_tel) {
        this.mobile_tel = mobile_tel;
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
     * @return the bday
     */
    public String getBday() {
        return bday;
    }

    /**
     * @param bday the bday to set
     */
    public void setBday(String bday) {
        this.bday = bday;
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
     * @return the university
     */
    public String getUniversity() {
        return university;
    }

    /**
     * @param university the university to set
     */
    public void setUniversity(String university) {
        this.university = university;
    }

    /**
     * @return the education
     */
    public String getEducation() {
        return education;
    }

    /**
     * @param education the education to set
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * @return the gardianDTO
     */
    public GardianDTO getGardianDTO() {
        return gardianDTO;
    }

    /**
     * @param gardianDTO the gardianDTO to set
     */
    public void setGardianDTO(GardianDTO gardianDTO) {
        this.gardianDTO = gardianDTO;
    }

    @Override
    public String toString() {
        return "StudentDTO{" + "studentId=" + studentId + ", nameWithInitials=" + nameWithInitials + ", address=" + address + ", city=" + city + ", home_tel=" + home_tel + ", mobile_tel=" + mobile_tel + ", email=" + email + ", nic=" + nic + ", bday=" + bday + ", gender=" + gender + ", university=" + university + ", education=" + education + ", gardianDTO=" + gardianDTO + '}';
    }

    

    
    
    
}
