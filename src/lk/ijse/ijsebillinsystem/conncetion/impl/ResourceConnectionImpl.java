/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.conncetion.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.ijsebillinsystem.conncetion.ResourceConnection;

/**
 *
 * @author user
 */
public class ResourceConnectionImpl implements ResourceConnection{
    private Connection connection;
    @Override
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ijsepaymentsystem","root","amila1568");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ResourceConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ResourceConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
}
