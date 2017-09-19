package com.wonder.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.sybase.jdbc3.jdbc.Convert;
import com.wonder.Dao.sybaseDao;
import com.wonder.Entity.Data;
import com.wonder.Entity.Excel;

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
	@SuppressWarnings("deprecation")
	public static void createExcel(String fileDir,String[] province,String titleRow[]) throws Exception{
		workbook =new HSSFWorkbook();	
		FileOutputStream out =null;
		for(int sheetIx = 0;sheetIx<province.length;sheetIx++){
		HSSFSheet sheet=workbook.createSheet();
		workbook.setSheetName(sheetIx,province[sheetIx]+"各区县购房提取情况");
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中		
		HSSFRow row =workbook.getSheet(province[sheetIx]+"各区县购房提取情况").createRow(0);
		for(short i = 0;i<titleRow.length;i++){
			HSSFCell cell =row.createCell(i);
			cell.setCellValue(titleRow[i]);
			cell.setCellStyle(cellStyle);
			}
		}
		try {
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
			}catch(NullPointerException  e){
				e.printStackTrace();
			}
		}
		}
		

	private static boolean sheetExist() {
		// TODO Auto-generated method stub
		return false;
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
	 * 往excel中写入sheet（已经存在数据无法写入）
	 * @param fileDir 文件路径
	 * @param sheetName 表格索引
	 * @param object
	 * @throws Exception 
	 */
	
	@SuppressWarnings("unchecked")
	public static void writeSheet(String fileDir,String sheetName,List<Map> maplist) throws Exception{

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
		//流
		FileOutputStream out =null;
		HSSFSheet sheet =workbook.getSheet(sheetName);
		//获取表的总行数
		//int rowCount = sheet.getRow(0).getLastCellNum()+1;
		//获取表头的列数
		int columnCount = sheet.getRow(0).getLastCellNum()+1; 
//		System.out.println(columnCount);
		try {
			HSSFRow titleRow = sheet.getRow(0);
			String mapKey = null;
		if(titleRow!=null){
			for(int rowId =0;rowId<maplist.size();rowId++){
				Map<String, String> map = maplist.get(rowId);
				HSSFRow newRow =sheet.createRow(rowId+1);
				for(int columnIndex = 0; columnIndex<(columnCount-1);columnIndex++){
					mapKey = titleRow.getCell(columnIndex).toString().trim().toString().trim();
//					System.out.println(mapKey);
					HSSFCell cell =newRow.createCell(columnIndex);
					cell.setCellValue(map.get(mapKey).equals("")? null:map.get(mapKey).toString());
				}
			}
		}
			out = new FileOutputStream(fileDir);
			workbook.write(out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}finally{
			try{
				out.close();
				}catch(IOException e){
					e.printStackTrace();
				}catch(NullPointerException e){
					e.printStackTrace();
				}
			
			}
		}


	/*
	 * 创建Excel
	 * 
	 */

	public static boolean writeExcel(String fileDir, String excelName, String tdate) throws Exception {
		// TODO Auto-generated method stub
		boolean isExist = fileExist(fileDir);
		if(!isExist){
		String provinces[] ={"上海市","江苏省","浙江省","安徽省","山东省","福建省","江西省"};
		String titleRow[] ={"市","区县","笔数","金额","去年同月","上个月","上上个月","同比","环比"}; 
		createExcel(fileDir, provinces, titleRow);
			for(int i = 0 ; i < 7;i++){
			String province =provinces[i];
			String sheetName = province+"各区县购房提取情况";
			List<Map> maplist = SybaseDaoService.getData(province,tdate);
			writeSheet(fileDir, sheetName, maplist);		
			}
			return true;
		}
		return false;
	}

}
