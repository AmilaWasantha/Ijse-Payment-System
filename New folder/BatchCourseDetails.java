/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.billingsystem.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

/**
 *
 * @author kavii
 */
@Entity
public class BatchCourseDetails implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(
            @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false))
    private Batch batch;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(
            @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false))
    private Course course;
    
    @EmbeddedId
    private BatchCourse_pk batchCourse_pk;

    public BatchCourseDetails() {
    }

    public BatchCourseDetails(Batch batch, Course course, BatchCourse_pk batchCourse_pk) {
        this.batch = batch;
        this.course = course;
        this.batchCourse_pk = batchCourse_pk;
    }

    /**
     * @return the batch
     */
    public Batch getBatch() {
        return batch;
    }

    /**
     * @param batch the batch to set
     */
    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    /**
     * @return the course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * @return the batchCourse_pk
     */
    public BatchCourse_pk getBatchCourse_pk() {
        return batchCourse_pk;
    }

    /**
     * @param batchCourse_pk the batchCourse_pk to set
     */
    public void setBatchCourse_pk(BatchCourse_pk batchCourse_pk) {
        this.batchCourse_pk = batchCourse_pk;
    }

   
    

}
