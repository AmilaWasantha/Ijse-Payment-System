/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.billingsystem.dto;

/**
 *
 * @author kavii
 */
public class BatchCoursedetailsDto {
    private BatchDto batchDto;
    private CourseDto courseDto;

    public BatchCoursedetailsDto() {
    }

    public BatchCoursedetailsDto(BatchDto batchDto, CourseDto courseDto) {
        this.batchDto = batchDto;
        this.courseDto = courseDto;
    }

    /**
     * @return the batchDto
     */
    public BatchDto getBatchDto() {
        return batchDto;
    }

    /**
     * @param batchDto the batchDto to set
     */
    public void setBatchDto(BatchDto batchDto) {
        this.batchDto = batchDto;
    }

    /**
     * @return the courseDto
     */
    public CourseDto getCourseDto() {
        return courseDto;
    }

    /**
     * @param courseDto the courseDto to set
     */
    public void setCourseDto(CourseDto courseDto) {
        this.courseDto = courseDto;
    }
    
}
