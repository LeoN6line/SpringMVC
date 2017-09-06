package com.wonder.Service;

import java.sql.SQLException;
import java.util.ArrayList;


import com.wonder.Dao.excelDao;
import com.wonder.Entity.Excel;

public class DaoService {

public static ArrayList<Excel> search(String tdate) throws SQLException {
	// TODO Auto-generated method stub
	return excelDao.search(tdate);
}
}
