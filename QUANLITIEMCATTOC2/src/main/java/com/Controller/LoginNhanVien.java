package com.Controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Entity.KhachHang;
import com.Entity.TaiKhoanKhachHang;
import com.Entity.TaiKhoanNhanVien;

@Controller
@Transactional
public class LoginNhanVien {
	@Autowired
	SessionFactory factory;
	@RequestMapping(value="loginNV", method=RequestMethod.GET)
	public String login() {
		return "formLogin/loginNV";
	}
	
	@RequestMapping(value="loginNV", method=RequestMethod.POST)
	public String login(ModelMap model, HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Session session = factory.getCurrentSession();
		
		Query query = session.createQuery("from TaiKhoanNhanVien");

		List<TaiKhoanNhanVien> list = query.list();
		for (TaiKhoanNhanVien i :list) {
			
			if (i.getUserNameNhanVien().equals(username) && i.getPassWord().equals(password)) {
				if (i.getQuyen().getMaQuyen().equals("Q01")) { // quan li
					model.addAttribute("taiKhoanNhanVien", i);
					return "viewManager/index";
				}
				else if (i.getQuyen().getMaQuyen().equals("Q02")){	// nhan vien
					System.out.println(3);
					return "viewEmployee/index";
				}
			}
			
		}
		
		return "formLogin/loginNV";
	}
	
}
