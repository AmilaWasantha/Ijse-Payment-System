/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.controller;

import lk.ijse.ijsebillinsystem.controller.custom.impl.BatchControllerImpl;
import lk.ijse.ijsebillinsystem.controller.custom.impl.BatchCourseControllerImpl;
import lk.ijse.ijsebillinsystem.controller.custom.impl.BatchRegistrationControllerImpl;
import lk.ijse.ijsebillinsystem.controller.custom.impl.BatchTransferControllerImpl;
import lk.ijse.ijsebillinsystem.controller.custom.impl.CourseControllerImpl;
import lk.ijse.ijsebillinsystem.controller.custom.impl.GardianControllerImpl;
import lk.ijse.ijsebillinsystem.controller.custom.impl.IjseRegistrationControllerImpl;
import lk.ijse.ijsebillinsystem.controller.custom.impl.PaymentControllerImpl;
import lk.ijse.ijsebillinsystem.controller.custom.impl.StudentControllerImpl;
import lk.ijse.ijsebillinsystem.controller.custom.impl.UserControllerImpl;

/**
 *
 * @author user
 */
public class ControllerFactory {
    
    public enum getControllerType{
        BATCHCONTROLLER,BATCHCOURSECONTROLLER,BATCHREGISTRATIONCONTROLLER,BATCHTRANSFERCONTROLLER,COURSECONTROLLER,GARDIANCONTROLLER,IJSEREGISTRATIONCONTROLLER,PAYMENTCONTROLLER,STUDENTCONTROLLER,USER;
        
    }
    
    private static ControllerFactory controllerFactory;

    private ControllerFactory() {
        
    }
    
    public static ControllerFactory getInstance(){
        if(controllerFactory==null){
            controllerFactory=new ControllerFactory();
        }
        return controllerFactory;
    }
    
    public SuperController getConnection(getControllerType type){
        switch(type){
            case BATCHCONTROLLER:
                return new BatchControllerImpl();
            case BATCHCOURSECONTROLLER:
                return new BatchCourseControllerImpl();
            case BATCHREGISTRATIONCONTROLLER:
                return new BatchRegistrationControllerImpl();
            case BATCHTRANSFERCONTROLLER:
                return new BatchTransferControllerImpl();
            case COURSECONTROLLER:
                return new CourseControllerImpl();
            case GARDIANCONTROLLER:
                return new GardianControllerImpl();
            case IJSEREGISTRATIONCONTROLLER:
                return new IjseRegistrationControllerImpl();
            case PAYMENTCONTROLLER:
                return new PaymentControllerImpl();
            case STUDENTCONTROLLER:
                return new StudentControllerImpl();
            case USER:
                return new UserControllerImpl();
                
            default :
                return null;
                
        }
    }
    
    
    
}
