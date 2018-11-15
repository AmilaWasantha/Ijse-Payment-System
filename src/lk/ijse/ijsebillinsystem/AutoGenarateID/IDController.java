/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.AutoGenarateID;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import lk.ijse.ijsebillinsystem.conncetion.DBFactory;

/**
 *
 * @author user
 */
public class IDController {
    public static String getLastId(String tableName, String columnName) throws ClassNotFoundException, SQLException {
		String query = "SELECT " + columnName + " FROM " + tableName + " ORDER BY 1 DESC LIMIT 1";
		Connection connection = DBFactory.getInstance().getConnection(DBFactory.connectionType.DBCONNECTION).getConnection();
		Statement stm = connection.createStatement();
		ResultSet rst = stm.executeQuery(query);
		if(rst.next()) {
                    String string = rst.getString(1);
                    String substring = string.substring(0);
                    System.out.println(substring);
                    return string;
		}
		return null;
	}
}
