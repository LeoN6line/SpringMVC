package com.wonder.Control;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wonder.Dao.sybaseDao;
import com.wonder.Entity.Data;
import com.wonder.Entity.Excel;
import com.wonder.Service.ExcelService;
import com.wonder.Service.MySQLDaoService;
import com.wonder.Service.SybaseDaoService;



/**
 * 用户管理
 * 
 * @author zjn
 */
@Controller
public class gftjController {

	@RequestMapping("")
	public String Create(Model model) {
		return "index";
	}
	@RequestMapping("/gftj")
	public String re() {
		return "gftj";
	}

	@RequestMapping("/search")
	public String Save(@RequestParam(value="date")String date, Model model) throws Exception { 
		ArrayList<Excel> elist = new ArrayList<Excel>();
		String tdate = date.replaceAll("-", "");
		System.out.println(tdate);
		
		
		elist  = MySQLDaoService.search(tdate);
		System.out.println(elist.isEmpty());
		if(elist.isEmpty()){
			String fileDir = "E:/项目工作空间/workspace_javaweb/tqgj/web/excel/"+tdate+"月份的购房统计月报表.xls";
			String excelName = tdate + "月份的购房统计月报表.xls";
			String status ="1";
			boolean isStatus = ExcelService.writeExcel(fileDir,excelName,tdate);
				if(isStatus)
					status = "2";
			MySQLDaoService.insert(fileDir,excelName,tdate,status);
			elist  = MySQLDaoService.search(tdate);
		}
 		model.addAttribute("elist", elist);

	
		return "gftj";
	}
}
