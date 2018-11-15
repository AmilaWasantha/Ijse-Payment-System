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
import lk.ijse.ijsebillinsystem.dao.custom.StudentDAO;
import lk.ijse.ijsebillinsystem.dto.GardianDTO;
import lk.ijse.ijsebillinsystem.dto.StudentDTO;
import lk.ijse.ijsebillinsystem.querydto.RegisterStudentToAnothoerBatchQueryDTO;

/**
 *
 * @author user
 */
public class StudentDAOImpl implements StudentDAO{
    
    private Connection connection;

    public StudentDAOImpl() {
        connection=DBFactory.getInstance().getConnection(DBFactory.connectionType.DBCONNECTION).getConnection();
    }
    
    

    @Override
    public boolean save(StudentDTO dto) throws Exception {
        Statement stm= connection.createStatement();
        int res=stm.executeUpdate("insert into student values ('"+dto.getStudentId()+"','"+dto.getGardianDTO().getGardianId()+"','"+dto.getNameWithInitials()+"','"+dto.getAddress()+"','"+dto.getCity()+"','"+dto.getHome_tel()+"','"+dto.getMobile_tel()+"','"+dto.getEmail()+"','"+dto.getNic()+"','"+dto.getBday()+"','"+dto.getGender()+"','"+dto.getUniversity()+"','"+dto.getEducation()+"')");
        if(res>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(StudentDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(StudentDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StudentDTO find(String id) throws Exception {
        StudentDTO studentDTO=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select * from student where NIC='"+id+"'");
        while(rst.next()){
            GardianDTO gardianDTO=new GardianDTO(rst.getString(13));
            studentDTO=new StudentDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8),rst.getString(9),rst.getString(10),rst.getString(11),rst.getString(12), gardianDTO);
            return studentDTO;
        }
        return null;
        
    }

    @Override
    public List<StudentDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RegisterStudentToAnothoerBatchQueryDTO> getStudentDetails(String sid,String status) throws Exception {
        List<RegisterStudentToAnothoerBatchQueryDTO>registerStudentToAnothoerBatchQueryDTOs=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select s.NAME_WITH_INITIAL, c.COURSE_Name  from registration r, student s, course c, course_batch cb, batch b where r.STUDENT_ID=s.STUDENT_ID  AND cb.BATCH_ID=b.BATCH_ID AND cb.COURSE_ID=c.COURSE_ID AND s.STUDENT_ID='"+sid+"' AND r.BATCH_ID=b.BATCH_ID AND cb.BATCH_ID=b.BATCH_ID AND cb.COURSE_ID=c.COURSE_ID AND r.STATUS='"+status+"'");
        while(rst.next()){
            if(registerStudentToAnothoerBatchQueryDTOs==null){
                registerStudentToAnothoerBatchQueryDTOs=new ArrayList<>();
            }
            RegisterStudentToAnothoerBatchQueryDTO dto=new RegisterStudentToAnothoerBatchQueryDTO(rst.getString(1), rst.getString(2));
            registerStudentToAnothoerBatchQueryDTOs.add(dto);
        }
        return registerStudentToAnothoerBatchQueryDTOs;
    }
    
}
