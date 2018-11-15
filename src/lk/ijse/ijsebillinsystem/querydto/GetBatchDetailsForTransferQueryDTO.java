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
public class GetBatchDetailsForTransferQueryDTO {
    private String registrationId;
    private String studentId;
    private String batchid;
    private String batchName;

    public GetBatchDetailsForTransferQueryDTO() {
    }

    public GetBatchDetailsForTransferQueryDTO(String registrationId, String studentId, String batchid, String batchName) {
        this.registrationId = registrationId;
        this.studentId = studentId;
        this.batchid = batchid;
        this.batchName = batchName;
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
     * @return the batchid
     */
    public String getBatchid() {
        return batchid;
    }

    /**
     * @param batchid the batchid to set
     */
    public void setBatchid(String batchid) {
        this.batchid = batchid;
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

    @Override
    public String toString() {
        return "GetBatchDetailsForTransferQueryDTO{" + "registrationId=" + registrationId + ", studentId=" + studentId + ", batchid=" + batchid + ", batchName=" + batchName + '}';
    }

    
    
    
    
}
