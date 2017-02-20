package com.bit2017.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2017.emaillist.repository.EmailListDao;
import com.bit2017.emaillist.vo.EmailListVo;

@Controller
public class EmailListController {
	
	@Autowired
	private EmailListDao emailListDao;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<EmailListVo> list = emailListDao.getList();
		
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/list.jsp";
	}
	
	@RequestMapping("/form")
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping("/add")
	public String add(@ModelAttribute EmailListVo vo ) {
		
		emailListDao.insert(vo);
		
		return "redirect:/list";
	}
}
