package com.onlineTicketBooking.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.onlineTicketBooking.Constants.DB_Constants.Driver;
import static com.onlineTicketBooking.Constants.DB_Constants.*;

public class ConnectionUtil {
    private Connection connection;

    public Connection getConnection()throws Exception{
        Class.forName(Driver);
        connection= DriverManager.getConnection(URL,User_Name,Password);
        return connection;
    }
}
