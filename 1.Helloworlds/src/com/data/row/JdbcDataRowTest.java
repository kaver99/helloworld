package com.data.row;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDataRowTest {
	
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:51521:xe";
        String dbId = "violet";
        String dbPw = "violet";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{       
            Class.forName(driver);
            conn = DriverManager.getConnection(url,dbId,dbPw);
            String sql = "SELECT username, name, socialtype FROM violet_user";   
            pstmt = conn.prepareStatement(sql);  
            rs = pstmt.executeQuery();
            String jeonmun = "";
            
            while(rs.next()){
                 System.out.print(rs.getString("username"));
                 System.out.print(" ");
                 System.out.print(rs.getString("name"));
                 System.out.print(" ");
                 System.out.println(rs.getString("socialtype"));
                 
                 jeonmun = "@s@|f|3|" + rs.getString("username") + "|" + rs.getString("name") + "|" + rs.getString("socialtype"); 
            }
            System.out.println(jeonmun);
        }catch(ClassNotFoundException e){
            // driver로딩 실패...
        	e.printStackTrace();
        }catch(SQLException e){
            // sql 예외...
        	e.printStackTrace();
        }finally{
            if(rs != null){ try{ rs.close(); }catch(SQLException e){} }
            if(pstmt != null){ try{ pstmt.close(); }catch(SQLException e){} }
            if(conn != null){ try{ conn.close(); }catch(SQLException e){} }
        }
    } 
} 
