package com.wonder.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelService {
	public static HSSFWorkbook workbook =null;
	/*
	 * 判断文件是否存在
	 * @param fileDir 文件路径
	 * @return
	 */
	
	public static boolean fileExist(String fileDir){
		boolean flag =false;
		File file =new File(fileDir); 
		flag =file.exists();
		return flag;
	}
	
	/*
	 * 判断文件的sheet是否存在
	 * @param fileDir 文件路径
	 * @param sheetName 表格索引名
	 * @return
	 */
	
	public static boolean sheetExist(String fileDir,String sheetName) throws Exception{
		boolean flag = false;
		File file =new File(fileDir);
		if(file.exists()){
			try {
				workbook =new HSSFWorkbook(new FileInputStream(file));
				HSSFSheet sheet =workbook.getSheet(sheetName);
				if(sheet!=null)
					flag=true;
				} catch (Exception e) {
					throw e;
				}
		
		}else{
		flag=false;
		}
		return flag;
	}
	/*创建新excel
	 * @param fileDir excel的路径
	 * @param sheetName 要创建的表格索引
	 * @param titleRow excel的第一行即表格头
	 */
	public static void createExcel(String fileDir,String sheetName,String titleRow[]) throws Exception{
		workbook =new HSSFWorkbook();		
		HSSFSheet sheet1=workbook.createSheet(sheetName);
		FileOutputStream out =null;
		try {
		HSSFRow row =workbook.getSheet(sheetName).createRow(0);
		for(short i = 0;i<titleRow.length;i++){
			HSSFCell cell =row.createCell(i);
			cell.setCellValue(titleRow[i]);
			}
		
			out = new FileOutputStream(fileDir);
			workbook.write(out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		} finally{
			try{
				out.close();
			}catch(IOException  e){
				e.printStackTrace();
			}
		}
	}
	/*
	 * 删除文件
	 * @param fileDir 文件路径
	 */
	public static boolean deleteExcel(String fileDir){
		boolean flag =false;
		File file =new File(fileDir);
		if(!file.exists()){
			return flag;
		}else{
			if(file.isFile()){
				file.delete();
				flag=true;
			}
		}
		return flag;
	}
	/*
	 * 往excel中写入（已经存在数据无法写入）
	 * @param fileDir 文件路径
	 * @param sheetName 表格索引
	 * @param object
	 * @throws Exception 
	 */
	public static void writeToExcel(String fileDir,String sheetName,List<Map> maplist){
		//创建workbook
		File file = new File(fileDir);
		try {
			workbook =new HSSFWorkbook(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
