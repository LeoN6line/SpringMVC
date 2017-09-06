package com.wonder.Control;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wonder.Entity.Excel;
import com.wonder.Service.DaoService;



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
	public String Save(@RequestParam(value="date")String date, Model model) throws SQLException { 
		ArrayList<Excel> elist = new ArrayList<Excel>();
		String tdate = date.replaceAll("-", "");
		elist  = DaoService.search(tdate);
		model.addAttribute("elist", elist);
		return "gftj";
	}
}
