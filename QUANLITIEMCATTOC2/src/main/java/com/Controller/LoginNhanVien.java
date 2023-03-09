package com.Controller;

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
import com.Entity.NhanVien;
import com.Entity.SanPham;
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
		
		Query query = session.createQuery("from TaiKhoanNhanVien tk where tk.userNameNhanVien= :user and tk.passWord= :pass");
		query.setParameter("user", username);
		query.setParameter("pass", password);
		
		List<TaiKhoanNhanVien> taiKhoans = query.list();
		if (taiKhoans.size() == 0) {
			return "formLogin/loginNV";
		}
		TaiKhoanNhanVien taiKhoan = (TaiKhoanNhanVien) query.list().get(0); 
		
		if (taiKhoan.getQuyen().getMaQuyen().equals("Q01")) { // quan li
			List<SanPham> products = getProducts();
			model.addAttribute("products", products);
			model.addAttribute("usernameManager",username);
//			return "viewManager/index";
			return "viewManager/dashboard";
		}
		else if (taiKhoan.getQuyen().getMaQuyen().equals("Q02")){	// nhan vien
			return "viewEmployee/index";
	
		}
		
		return "formLogin/loginNV";
	
	}
	
	
	@ModelAttribute("products")
	public List<SanPham> getProducts(){
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from SanPham");
		List<SanPham> products = query.list();
		return products;
	}
}
