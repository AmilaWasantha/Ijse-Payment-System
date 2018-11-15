/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.ijsebillinsystem.conncetion.DBFactory;
import lk.ijse.ijsebillinsystem.dao.custom.CourseDAO;
import lk.ijse.ijsebillinsystem.dto.CourseDTO;

/**
 *
 * @author user
 */
public class CourseDAOImpl implements CourseDAO{
    
    private Connection connection;

    public CourseDAOImpl() {
        connection=DBFactory.getInstance().getConnection(DBFactory.connectionType.DBCONNECTION).getConnection();
    }
    
    

    @Override
    public boolean save(CourseDTO courseDTO) throws Exception {
        Statement stm=connection.createStatement();
        int res=stm.executeUpdate("insert into course values('"+courseDTO.getCourseId()+"','"+courseDTO.getCourseName()+"','"+courseDTO.getCourseType()+"','"+courseDTO.getCourseFee()+"','"+courseDTO.getLatePayment()+"','"+courseDTO.getDuration()+"','"+courseDTO.getCourseDiscount()+"')");
        if(res>0){
            return true;
        }
        return false;
        
        
    }

    @Override
    public boolean delete(CourseDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(CourseDTO dto) throws Exception {
       Statement stm= connection.createStatement();
       int res=stm.executeUpdate("update course set DISCOUNT='"+dto.getCourseDiscount()+"' where COURSE_ID='"+dto.getCourseId()+"'");
       if(res>0){
           return true;
       }else{
           return false;
       }
    }

    @Override
    public CourseDTO find(String id) throws Exception {
        CourseDTO courseDTO=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select * from course where COURSE_Name='"+id+"'");
        while(rst.next()){
            courseDTO=new CourseDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4),rst.getInt(5),rst.getString(6),rst.getString(7));
            
        }
        return courseDTO;
    }

    @Override
    public List<CourseDTO> getAll() throws Exception {
        List<CourseDTO>courseDTOs=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select * from course");
        while(rst.next()){
            if(courseDTOs==null){
                courseDTOs=new ArrayList<>();
            }
            CourseDTO courseDTO=new CourseDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4),rst.getInt(5),rst.getString(6),rst.getString(7));
            courseDTOs.add(courseDTO);
        }
        return courseDTOs;
        
    }
    
}
