/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chinsu;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Windows 10
 */
public class ConnectionDB {
    public static Connection getConnection() {
        String DB_URL = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=chinsu;"
                + "integratedSecurity=true";
        String USER_NAME = "DESKTOP-2VL97NC\\Windows 10";
        String PASSWORD = "";
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
