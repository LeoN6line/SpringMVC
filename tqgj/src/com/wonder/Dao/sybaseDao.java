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

	public class sybaseDao {
		private static final String MYSQL_DB_JNDINAME="java:comp/env/jdbc/mysybaseds";
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
		public  void test(){
			String sql = "select  1,'201706','上海','上海','浦东', COUNT(DISTINCT B.TRANS_NUM) ,SUM(B.HAPPEN_AMOUNT) from house_address_detail A,TRANS_MONTH B where A.trans_num=B.TRANS_NUM AND substring(B.TRANS_HAPPEN_TIME,1,6)='201706' AND B.ERROR_TYPE ='00' AND SUBSTRING(B.TRANS_TYPE, 3,1) ='3' and A.status='0' and A.province LIKE  '%上海%' and A.area LIKE '%浦东%' ";
			try {
				conn=dds.getConnection();
				pstmt=conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()){
					System.out.println(rs.getString(7));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				release(conn,pstmt,rs);
			}
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
