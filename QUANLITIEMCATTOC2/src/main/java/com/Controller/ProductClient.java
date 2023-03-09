package com.Controller;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.Entity.LoaiSanPham;
import com.Entity.SanPham;


@Controller
@Transactional
@RequestMapping("productClient/")
public class ProductClient {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping(value="index/{usernameKH}", method=RequestMethod.GET)
	public String index(ModelMap model, @PathVariable("usernameKH") String usernameKH) {

		List<SanPham> products = getProducts();
		int size = products.size();
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
		model.addAttribute("products", products);
		model.addAttribute("usernameKH",usernameKH);
		return "viewClient/product/index";
	}
	
	
	// tra ve cac loai san pham trong view insert 1 san pham
	@ModelAttribute("typeProducts")
	public List<LoaiSanPham>  getTypeProducts(){;
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from LoaiSanPham");
		List<LoaiSanPham> typeProducts = query.list();
		return typeProducts;
	}

	// tra ve danh sach cac san pham
	@ModelAttribute("products")
	public List<SanPham> getProducts(){
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from SanPham");
		List<SanPham> products = query.list();
		return products;
	}
	
}
