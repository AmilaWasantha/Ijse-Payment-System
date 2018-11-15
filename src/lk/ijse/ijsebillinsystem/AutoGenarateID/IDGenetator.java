/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.ijsebillinsystem.AutoGenarateID;

import java.sql.SQLException;
import java.text.NumberFormat;

/**
 *
 * @author user
 */
public class IDGenetator {
     public static String getNewId(String tableName, String columnName, String prefix, int digitCount) throws ClassNotFoundException, SQLException {
        String lastId = IDController.getLastId(tableName, columnName);
        if (null != lastId) {
            String[] idArray = lastId.split(prefix);

            int id = Integer.parseInt(idArray[1]);
            id++;
            NumberFormat numberFormat = NumberFormat.getIntegerInstance();
            numberFormat.setMinimumIntegerDigits(digitCount);
            numberFormat.setGroupingUsed(false);
            String newId = numberFormat.format(id);
            newId = prefix + "0" + newId ;
            return newId;
        } else {
            String newId = prefix;
            for (int i = 0; i < digitCount - 1; i++) {
                newId += "00";
            }
            newId += "1";
            return newId;
        }
    }
}
