package com.wonder.Service;

import java.sql.SQLException;
import java.util.ArrayList;


import com.wonder.Dao.excelDao;
import com.wonder.Entity.Excel;

public class MySQLDaoService {

public static ArrayList<Excel> search(String tdate) throws SQLException {
	// TODO Auto-generated method stub
	return excelDao.search(tdate);
}



public static void insert(String fileDir, String excelName, String tdate,String status) {
	// TODO Auto-generated method stub
	excelDao.insert(fileDir,excelName,tdate,status);
}
}
