/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author muhammad ali raza
 */
public class SQLConnection {
    private String serverName;
    private String dbName;
    private String dbUserName;
    private String dbUserPassword;
    
    public SQLConnection(String sName, String dbName, String userId, String userPass) {
        this.serverName = sName;
        this.dbName = dbName;
        this.dbUserName = userId;
        this.dbUserPassword = userPass;
    }

    
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/registration_database?zeroDateTimeBehavior=CONVERT_TO_NULL"+this.dbName+"TrustServerCertificate", this.dbUserName+"root",this.dbUserPassword+"Ali6635.");
        }
        catch (Exception e) {
            System.out.println("Error Trace in getConnection() : " + e.getMessage());
        }
        return null;
    }
}
