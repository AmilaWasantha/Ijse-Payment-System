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
public class BatchTransferQueryDTO {
    private String studentnic;
    private String studentId;   
    private String studentName;
    private String batchName;
    private String batchId;

    public BatchTransferQueryDTO() {
    }

    public BatchTransferQueryDTO(String studentnic, String studentId, String studentName, String batchName, String batchId) {
        this.studentnic = studentnic;
        this.studentId = studentId;
        this.studentName = studentName;
        this.batchName = batchName;
        this.batchId = batchId;
    }

    /**
     * @return the studentnic
     */
    public String getStudentnic() {
        return studentnic;
    }

    /**
     * @param studentnic the studentnic to set
     */
    public void setStudentnic(String studentnic) {
        this.studentnic = studentnic;
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

    @Override
    public String toString() {
        return "TransferStudentsQueryDTO{" + "studentnic=" + studentnic + ", studentId=" + studentId + ", studentName=" + studentName + ", batchName=" + batchName + ", batchId=" + batchId + '}';
    }
    
    
   
}
