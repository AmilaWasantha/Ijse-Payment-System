/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.tableModel;

/**
 *
 * @author user
 */
public class GetAllBatchTableModel {
    private String batchId;
    private String batchName;
    private String date;
    private String type;
    private String status;

    public GetAllBatchTableModel() {
    }

    public GetAllBatchTableModel(String batchId, String batchName, String date, String type, String status) {
        this.batchId = batchId;
        this.batchName = batchName;
        this.date = date;
        this.type = type;
        this.status = status;
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
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GetAllBatchTableModel{" + "batchId=" + batchId + ", batchName=" + batchName + ", date=" + date + ", type=" + type + ", status=" + status + '}';
    }

   
    
    
}
