/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.service;

import lk.ijse.ijsebillinsystem.service.custom.impl.BatchCourseServiceImpl;
import lk.ijse.ijsebillinsystem.service.custom.impl.BatchRegistrationServiceImpl;
import lk.ijse.ijsebillinsystem.service.custom.impl.BatchServiceImpl;
import lk.ijse.ijsebillinsystem.service.custom.impl.BatchTransferServiceImpl;
import lk.ijse.ijsebillinsystem.service.custom.impl.CourseServiceImpl;
import lk.ijse.ijsebillinsystem.service.custom.impl.GardianServiceImpl;
import lk.ijse.ijsebillinsystem.service.custom.impl.IjseRegistrationServiceImpl;
import lk.ijse.ijsebillinsystem.service.custom.impl.PaymentServiceImpl;
import lk.ijse.ijsebillinsystem.service.custom.impl.StudentServiceImpl;
import lk.ijse.ijsebillinsystem.service.custom.impl.UserServiceImpl;

/**
 *
 * @author user
 */
public class ServiceFactory {
    public enum getServiceType{
        BATCHCOURSERVICE,BATCHREGISTRATIONSERVICE,BATCHSERVICE,BATCHTRANSFERSERVICE,COURSERSERVICE,GARDIANSERVICE,IJSEREGISTRATIONSERVICE,PAYMENTSERVICE,STUDENTSERVICE,USER;
    }
    
    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
        
    }
    
    public static ServiceFactory getInstance(){
        if(serviceFactory==null){
            serviceFactory=new ServiceFactory();
        }
        return serviceFactory;
    }
    
    public SuperService getConnection(getServiceType type){
        switch(type){
            case BATCHCOURSERVICE:
                return new BatchCourseServiceImpl();
            case BATCHREGISTRATIONSERVICE:
                return new BatchRegistrationServiceImpl();
            case BATCHSERVICE:
                return new BatchServiceImpl();
            case BATCHTRANSFERSERVICE:
                return new BatchTransferServiceImpl();
            case COURSERSERVICE:
                return new CourseServiceImpl();
            case GARDIANSERVICE:
                return new GardianServiceImpl();
            case IJSEREGISTRATIONSERVICE:
                return new IjseRegistrationServiceImpl();
            case PAYMENTSERVICE:
                return new PaymentServiceImpl();
            case STUDENTSERVICE:
                return new StudentServiceImpl();
            case USER:
                return new UserServiceImpl();
            default :
                return null;
        }
    }
    
    
    
}

