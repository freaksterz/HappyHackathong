package com.happy.hack.common.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;

public class JDBCConnection {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Happyhack";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "admin123";

    public static List<Map<String, String>> getLuxury(float value, float rooms, float locations, float cleanliness, float checkIn, float service, float businessService, String type) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");

            if ( type.equalsIgnoreCase("luxury") ) {

                stmt =  conn.prepareStatement("select Bigram,count from BiGramUILuxury where Value <= ? AND Rooms <= ? AND Locations <= ? AND Cleanliness <= ? AND ChekIn <= ? AND Service <= ? AND BusinessService <= ? order by count DESC Limit 150");

            } else if ( type.equalsIgnoreCase("budget") ) {

                stmt =  conn.prepareStatement("select Bigram,count from BiGramUIBudget where Value <= ? AND Rooms <= ? AND Locations <= ? AND Cleanliness <= ? AND ChekIn <= ? AND Service <= ? AND BusinessService <= ? order by count DESC Limit 150");

            } else {
                stmt =  conn.prepareStatement("select Bigram,count from BiGramUIAverage where Value <= ? AND Rooms <= ? AND Locations <= ? AND Cleanliness <= ? AND ChekIn <= ? AND Service <= ? AND BusinessService <= ? order by count DESC Limit 150");
            }

            stmt.setFloat(1, value);
            stmt.setFloat(2, rooms);
            stmt.setFloat(3, locations);
            stmt.setFloat(4, cleanliness);
            stmt.setFloat(5, checkIn);
            stmt.setFloat(6, service);
            stmt.setFloat(7, businessService);

            //System.out.println("HEREE");
            List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
            ResultSet rs = stmt.executeQuery();

            //STEP 5: Extract data from result set

            while(rs.next()){
                //Display values
                Map<String, String> map = new HashMap<String,String>();
                map.put("text", rs.getString(1));
                map.put("weight", Float.toString(rs.getFloat(2)));
                mapList.add(map);


                //System.out.print("Bigram: " + rs.getString(1));
                //System.out.print("count: " + rs.getInt(2));

            }

            rs.close();
            stmt.close();
            conn.close();

            return mapList;
            //STEP 6: Clean-up environment
            //System.out.println("closing");

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources


            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

        return null;
    }
}