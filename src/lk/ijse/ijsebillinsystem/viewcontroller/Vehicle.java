/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.viewcontroller;

/**
 *
 * @author user
 */
public class Vehicle {
    
 void park(){
     System.out.println("super");

}
    
}

class car extends Vehicle{
    void park(){
        System.out.println("sub");
    }
}
