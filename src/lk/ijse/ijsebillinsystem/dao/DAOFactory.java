/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.dao;

import lk.ijse.ijsebillinsystem.dao.custom.impl.BatchCourseDAOImpl;
import lk.ijse.ijsebillinsystem.dao.custom.impl.BatchDAOImpl;
import lk.ijse.ijsebillinsystem.dao.custom.impl.BatchRegistrationDAOImpl;
import lk.ijse.ijsebillinsystem.dao.custom.impl.BatchTransferDAOImpl;
import lk.ijse.ijsebillinsystem.dao.custom.impl.CourseDAOImpl;
import lk.ijse.ijsebillinsystem.dao.custom.impl.GardianDAOImpl;
import lk.ijse.ijsebillinsystem.dao.custom.impl.IjseRegistrationDAOImpl;
import lk.ijse.ijsebillinsystem.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.ijsebillinsystem.dao.custom.impl.StudentDAOImpl;
import lk.ijse.ijsebillinsystem.dao.custom.impl.UserDAOImpl;

/**
 *
 * @author user
 */
public class DAOFactory {
    public enum DAOType{
        BATCHCOURSEDAO,BATCHDAO,BATCHREGISTRATIONDAO,BATCHTRANSFERDAO,COURSEDAO,GARDIANDAO,IJSEREGISTRATIONDAO,PAYMENTDAO,STUDENTDAO,USERDAO;
        
    }
    
    private static DAOFactory dAOFactory;

    private DAOFactory() {
    }
    
    public static DAOFactory getInstance(){
        if(dAOFactory==null){
            dAOFactory=new DAOFactory();
        }
        return dAOFactory;
    }
    
    public SuperDAO getConnection(DAOType type){
        switch(type){
            case BATCHCOURSEDAO:
                return new BatchCourseDAOImpl();
            case BATCHDAO:
                return new BatchDAOImpl();
            case BATCHREGISTRATIONDAO:
                return new BatchRegistrationDAOImpl();
            case BATCHTRANSFERDAO:
                return new BatchTransferDAOImpl();
            case COURSEDAO:
                return new CourseDAOImpl();
            case GARDIANDAO:
                return new GardianDAOImpl();
            case IJSEREGISTRATIONDAO:
                return new IjseRegistrationDAOImpl();
            case PAYMENTDAO:
                return new PaymentDAOImpl();
            case STUDENTDAO:
                return new StudentDAOImpl();
            case USERDAO:
                return new UserDAOImpl();
            default :
                return null;
        }
    }
    
    
}
