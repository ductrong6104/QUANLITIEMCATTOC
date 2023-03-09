package com.Controller;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.Entity.DichVu;
import com.Entity.LoaiDichVu;
import com.Entity.NhanVien;
import com.Entity.ThayDoiGiaSanPham;

@Controller
@Transactional
@RequestMapping("serviceClient/")
public class ServiceClient {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping(value="index/{usernameKH}", method=RequestMethod.GET)
	public String index(ModelMap model, @PathVariable("usernameKH") String usernameKH) {
//		Session session = factory.getCurrentSession();
		List<DichVu> services = getServices();
		int size = services.size();
		int numberPage = size/4;
		int lastPage = 0;
		if (size % 4 != 0) {
			numberPage += 1;
			lastPage = size % 4;
		}
		else {
			lastPage = 4;
		}
		List<Integer> collectionPage = new ArrayList<>();
		for (int i= 0; i < numberPage; i++) {
			collectionPage.add(i);
		}
		
		
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("collectionPage", collectionPage);
		model.addAttribute("services", services);
		model.addAttribute("usernameKH",usernameKH);
		return "viewClient/service/indexHieu";
	}
	
	
	// tra ve cac loai dich vu trong view insert 1 dich vu
	@ModelAttribute("typeServices")
	public List<LoaiDichVu>  getTypeServices(){
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from LoaiDichVu");
		List<LoaiDichVu> typeServices = query.list();
		return typeServices;
	}

	// tra ve danh sach cac dich vu
	@ModelAttribute("services")
	public List<DichVu> getServices(){
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from DichVu");
		List<DichVu> services = query.list();
		return services;
	}
	
}
