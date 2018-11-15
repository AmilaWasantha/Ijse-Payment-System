/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.conncetion;

import lk.ijse.ijsebillinsystem.conncetion.impl.ResourceConnectionImpl;

/**
 *
 * @author user
 */
public class DBFactory {
    
    public enum connectionType{
        DBCONNECTION;
    }
    
    private static DBFactory dBFactory;

    private DBFactory() {
    }
    
    public static DBFactory getInstance(){
        if(dBFactory==null){
            dBFactory=new DBFactory();
        }
        return dBFactory;
    }
    
    public ResourceConnection getConnection(connectionType type){
        switch(type){
            case DBCONNECTION:
                return new ResourceConnectionImpl();
            default :
                return null;
        }
    }
    
    
}
