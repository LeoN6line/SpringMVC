package com.wonder.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.wonder.Entity.Excel;

public class excelDao {
	private static final String MYSQL_DB_JNDINAME="java:comp/env/jdbc/mysqlds";
	private static DruidDataSource dds = null;
	private static Connection conn = null;
	private static PreparedStatement pstmt=null;
	private static ResultSet rs  = null;
	static {
		 try{
			 Context ctx = new InitialContext();
			 dds = (DruidDataSource) ctx.lookup(MYSQL_DB_JNDINAME);
			 
		 }catch(NamingException e){
			 e.printStackTrace();
		 }
	 }	
	public static ArrayList<Excel> search(String tdate) {
		String sql="select * from t_excel where date = ?";
		ArrayList<Excel> elist= new ArrayList<Excel>();		
		try {
			conn=dds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, tdate);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Excel excel = new Excel();
				excel.setId(rs.getInt("id"));
				excel.setExcelname(rs.getString("name"));
				excel.setDate(rs.getString("date"));
				excel.setLocation(rs.getString("location"));
				excel.setStatus(rs.getString("status"));
				elist.add(excel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			release(conn,pstmt,rs);
		}
		return elist;

	}
public static void release(Connection conn,PreparedStatement st,ResultSet rs){
		 if(rs!=null){
			 try{
				 rs.close();
			 }catch(Exception e){
				 e.printStackTrace();
			 }
			 rs=null;
		 }
		 if(st!=null){
			 try{
				 st.close();
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		 }
		 if(conn!=null){
			 try{
				 conn.close();
			 }catch(Exception e ){
				 e.printStackTrace();
			 }
		 }
	 }
}
