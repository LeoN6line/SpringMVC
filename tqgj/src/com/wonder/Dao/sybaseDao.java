package com.wonder.Dao;

	import java.io.IOException;
import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.naming.Context;
	import javax.naming.InitialContext;
	import javax.naming.NamingException;
	import com.alibaba.druid.pool.DruidDataSource;
import com.wonder.Entity.Data;

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
		public static Data search(String province,String city,String area,String tdate) throws IOException {
			time();	
			String sql =null;
			String home_add = null;
			Data data =null;
			try {
				conn=dds.getConnection();
			if(province=="上海"){
				home_add ="%"+area;
				sql = "select COUNT(DISTINCT B.TRANS_NUM) ,SUM(B.HAPPEN_AMOUNT)  from house_address_detail A,TRANS_MONTH B where A.trans_num=B.TRANS_NUM AND substring(B.TRANS_HAPPEN_TIME,1,6)= ? AND B.ERROR_TYPE ='00' AND SUBSTRING(B.TRANS_TYPE, 3,1)='3' and A.status='0' and A.province LIKE ? and  A.area LIKE ? ";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,tdate);
				pstmt.setString(2,province+"%");
				pstmt.setString(3,home_add+"%");
			}else{
			home_add = province+city+area;
			sql = "select COUNT(DISTINCT B.TRANS_NUM),SUM(B.HAPPEN_AMOUNT) from HOUSE_INFO A,TRANS_MONTH B where A.TRANS_NUM=B.TRANS_NUM AND substring(B.TRANS_HAPPEN_TIME,1,6)= ?  AND B.ERROR_TYPE='00' AND SUBSTRING(B.TRANS_TYPE,3,1) ='3' and A.HOUSE_ADD like ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,tdate);
			pstmt.setString(2,home_add+"%");
			}
			

				
//				pstmt=conn.prepareStatement(sql);
//				pstmt.setString(1,tdate);
//				pstmt.setString(2,home_add+"%");
				rs = pstmt.executeQuery();
				while(rs.next()){
					data =new Data();
					data.setCount(rs.getInt(1));
					data.setSum(rs.getInt(2));
					System.out.println(rs.getInt(1));
					System.out.println(rs.getInt(2));
			}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				release(conn,pstmt,rs);
				System.out.println("DONE!");
			}
			return data;
		}

		public static Data searchYDate(String province,String city,String area,String tdate) throws IOException {
			time();	
			String home_add = province+city+area;
			String sql = "select COUNT(DISTINCT B.TRANS_NUM),SUM(B.HAPPEN_AMOUNT) from HOUSE_INFO A,TRANS_HIS B where A.TRANS_NUM=B.TRANS_NUM AND substring(B.TRANS_HAPPEN_TIME,1,6)= ?  AND B.ERROR_TYPE='00' AND SUBSTRING(B.TRANS_TYPE,3,1) ='3' and A.HOUSE_ADD like ? ";
			Data data =null;
			try {
				conn=dds.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,tdate);
				pstmt.setString(2,home_add+"%");
				rs = pstmt.executeQuery();
				while(rs.next()){
					data =new Data();
					data.setCount(rs.getInt(1));
					data.setSum(rs.getInt(2));
					System.out.println(rs.getInt(1));
					System.out.println(rs.getInt(2));
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
