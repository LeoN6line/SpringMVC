package com.wonder.Dao;

	import java.io.IOException;
import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
	import javax.naming.InitialContext;
	import javax.naming.NamingException;
	import javax.sql.DataSource;

	import com.alibaba.druid.pool.DruidDataSource;
import com.wonder.Entity.Data;
import com.wonder.Entity.Excel;

	public class sybaseDao {
		private static final String SYBASE_DB_JNDINAME="java:comp/env/jdbc/mysybaseds";
		private static DruidDataSource dds = null;
		private static Connection conn = null;
		private static PreparedStatement pstmt=null;
		private static ResultSet rs  = null;
		static {
			 try{
				 Context ctx = new InitialContext();
				 dds = (DruidDataSource) ctx.lookup(SYBASE_DB_JNDINAME);
				 
			 }catch(NamingException e){
				 e.printStackTrace();
			 }
		 }	
		public static Data search(String province,String city,String area,String date) throws IOException {
//			String sql = "select ?,?,?,?,?, COUNT(DISTINCT B.TRANS_NUM) ,SUM(B.HAPPEN_AMOUNT) from HOUSE_INFO  A, TRANS_MONTH B    where  A.TRANS_NUM=B.TRANS_NUM  AND  substring(B.TRANS_HAPPEN_TIME,1,6)=?   AND B.ERROR_TYPE ='00'AND SUBSTRING(B.TRANS_TYPE, 3,1) ='3'  and  A.HOUSE_ADD  like  ?   and  A.HOUSE_ADD like ?";
//			String sql = "select * from HOUSE_INFO where ZM_CODE =' 0124507'";
			time();	
			String home_add = province+city+area;
			String sql = "select COUNT(DISTINCT B.TRANS_NUM),SUM(B.HAPPEN_AMOUNT) from HOUSE_INFO A,TRANS_MONTH B where A.TRANS_NUM=B.TRANS_NUM AND substring(B.TRANS_HAPPEN_TIME,1,6)=?  AND B.ERROR_TYPE='00' AND SUBSTRING(B.TRANS_TYPE,3,1) ='3' and A.HOUSE_ADD like ? ";
			Data data =new Data();
			try {
				conn=dds.getConnection();
				pstmt=conn.prepareStatement(sql);
//				pstmt.setInt(1, i);
//				pstmt.setString(2, date);
//				pstmt.setString(3, province);
//				pstmt.setString(4, city);
//				pstmt.setString(5, area);
//				pstmt.setString(6, date);
				pstmt.setString(1, date);
				pstmt.setString(2, home_add+"%");
//				pstmt.setString(3, "%"+area+"%");
				rs = pstmt.executeQuery();
				while(rs.next()){
					data.setCount(rs.getInt(1));
					data.setSum(rs.getInt(2));
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				release(conn,pstmt,rs);
			}
			return data;
		}

	
		
		/*
		 * 释放连接
		 */
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
public static void time(){
	Calendar now = Calendar.getInstance();
	//使用Date
	Date d = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	System.out.println("当前时间：" + sdf.format(d));
}
	}
