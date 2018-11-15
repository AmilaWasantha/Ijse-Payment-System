/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.billingsystem.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author kavii
 */
@Embeddable
public class BatchCourse_pk implements Serializable {
    private int bid;
    private int cid;

    public BatchCourse_pk() {
    }

    public BatchCourse_pk(int bid, int cid) {
        this.bid = bid;
        this.cid = cid;
    }

    /**
     * @return the bid
     */
    public int getBid() {
        return bid;
    }

    /**
     * @param bid the bid to set
     */
    public void setBid(int bid) {
        this.bid = bid;
    }

    /**
     * @return the cid
     */
    public int getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(int cid) {
        this.cid = cid;
    }
    
}
