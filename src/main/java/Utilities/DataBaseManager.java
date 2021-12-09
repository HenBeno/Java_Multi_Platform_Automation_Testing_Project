package Utilities;

import java.sql.SQLException;
import java.util.ArrayList;

public class DataBaseManager extends CommonOps {

    public static void getLoginDetails() {
        listOfUsersFromDB = new ArrayList<>();
        listOfPasswordFromDB = new ArrayList<>();
        listOfNamesFromDB = new ArrayList<>();
        try {
            rs = stmt.executeQuery("SELECT UserName,Password,Name FROM MyLoginDetails");

            while (rs.next()) {
                listOfUsersFromDB.add(rs.getString(1));
                listOfPasswordFromDB.add(rs.getString(2));
                listOfNamesFromDB.add(rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println("Error Occurred While Printing Table Data, See Details: " + e);
        }
    }


}
