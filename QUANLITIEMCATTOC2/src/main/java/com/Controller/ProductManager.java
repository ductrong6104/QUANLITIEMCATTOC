package com.Controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Entity.LoaiSanPham;
import com.Entity.NhanVien;
import com.Entity.SanPham;
import com.Entity.TaiKhoanNhanVien;
import com.Entity.ThayDoiGiaSanPham;



@Controller
@Transactional
@RequestMapping("product/")
public class ProductManager {
	@Autowired
	SessionFactory factory;
	@Autowired
	ServletContext context;
//	@RequestMapping("type")	// xem san pham thuoc loai san pham
//	public String typeProduct(ModelMap model) {
//		Session session = factory.getCurrentSession();
//		Query query1 = session.createQuery("from SanPham");
//		Query query2 = session.createQuery("from LoaiSanPham");
//		List<SanPham> products = query1.list();
//		List<LoaiSanPham> typeProducts = query2.list();
//		model.addAttribute("products", products);
//		model.addAttribute("typeProducts", typeProducts);
//		return "product/typeProduct";
//	}
	
	@RequestMapping(value="index/{usernameManager}", method=RequestMethod.GET)
	public String index(ModelMap model, @PathVariable("usernameManager") String usernameManager) {
//		Session session = factory.getCurrentSession();
		List<SanPham> sanPhams = getProducts();
//		for (SanPham i: sanPhams) {
//			System.out.println(i.getGiaSanPhams().get(0).getGia());
//		}
		model.addAttribute("products", getProducts());
		model.addAttribute("usernameManager", usernameManager);
		return "viewManager/product/index";
	}
	
	@RequestMapping(value="insert/{usernameManager}", method=RequestMethod.GET)
	public String insert(ModelMap model, @PathVariable("usernameManager") String usernameManager) {
		Session session = factory.getCurrentSession();
//		Query query = session.createQuery("from NhanVien nv where nv.maNhanVien = :user");
//		query.setParameter("user", usernameManager);
		NhanVien nv = (NhanVien)session.get(NhanVien.class, usernameManager);
		
		model.addAttribute("typeProducts", getTypeProducts());
		model.addAttribute("usernameManager", usernameManager);
		model.addAttribute("manager", nv);
		return "viewManager/product/insert";
	}
	
	@RequestMapping(value="insert/{usernameManager}", method=RequestMethod.POST)
	public String insert(ModelMap model, @PathVariable("usernameManager") String usernameManager
			,@RequestParam("maSanPham") String maSanPham, 
			@RequestParam("tenSanPham") String tenSanPham,
			@RequestParam("moTa") String moTa,
			@RequestParam("hinhAnh") MultipartFile hinhAnh,
			@RequestParam("loaiSanPham") String maLoaiSanPham
//			@RequestParam("gia") String gia
			) {
		
		
		
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		SanPham product = new SanPham();
		ThayDoiGiaSanPham giaSanPham = new ThayDoiGiaSanPham();
		try {
			// xu li file anh
			String hinhAnhPath = context.getRealPath("/image/product/" + hinhAnh.getOriginalFilename());
			hinhAnh.transferTo(new File(hinhAnhPath));
			NhanVien quanLi = (NhanVien)session.get(NhanVien.class, usernameManager);
			LoaiSanPham loaiSP = (LoaiSanPham)session.get(LoaiSanPham.class, maLoaiSanPham);
			
//			chua them chuc nang upload file anh
			product.setTenSanPham(tenSanPham);
			product.setMaSanPham(maSanPham);
			product.setHinhAnh(hinhAnh.getOriginalFilename());
			product.setMoTa(moTa);
			product.setQuanLiTaoSanPham(quanLi);
			product.setLoaiSanPham(loaiSP);
//			System.out.println((NhanVien)session.get(NhanVien.class, usernameManager));
		
			
//			System.out.println((LoaiSanPham)session.get(LoaiSanPham.class, maLoaiSanPham));
			
			
			session.save(product);
			
			
			// chua them chuc nang them gia san pham
			// get current day
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");  
//		    Date date = new Date();  
//		    System.out.println(formatter.format(date)); 
//			giaSanPham.setGia(gia);
//			giaSanPham.setquanLiThayDoiGiaSanPham(quanLi);
//			giaSanPham.setSanPham(product);
//			giaSanPham.setNgayApDung(formatter.format(date));
			
//			session.save(giaSanPham);
			t.commit();
			model.addAttribute("message", "Thêm thành công");
		}
		catch(Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm thất bại");
			
		}
		finally {
			session.close();
		}
		System.out.println(product);
		model.addAttribute("products", getProducts());
		return "viewManager/product/index";
	}
	
	// tra ve cac loai san pham trong view insert 1 san pham
	@ModelAttribute("typeProducts")
	public List<LoaiSanPham>  getTypeProducts(){

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
	// // tra ve danh sach quan li de lua chon quan li nao insert 1 san pham
//	@ModelAttribute("managers")
//	public List<NhanVien> getManagers(){
//		Session session = factory.getCurrentSession();
//		Query query = session.createQuery("from TaiKhoanNhanVien tk where tk.quyen.maQuyen = 'Q01'");
//		List<TaiKhoanNhanVien> tk = query.list();
//		List<NhanVien> managers = new ArrayList<>();
//		for (TaiKhoanNhanVien i: tk){
//			Query query2 = session.createQuery("from NhanVien nv where nv.maNhanVien = :user");
//			query2.setParameter("user", i.getUserNameNhanVien());
//			NhanVien nv = (NhanVien) query2.list().get(0);
//			managers.add(nv);
//		}
//		return managers;
//	}
	
//	@RequestMapping(value="update", method=RequestMethod.GET)
//	public String update(ModelMap model) {
//		model.addAttribute("product", new SanPham());
//		return "product/insert";
//	}
	
	@RequestMapping(value = "delete/{maSanPham}", method = RequestMethod.GET)
	public String delete(ModelMap model, @PathVariable("maSanPham") String maSanPham) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			SanPham deleteProduct = (SanPham) session.get(SanPham.class, maSanPham);
			session.delete(deleteProduct);
			t.commit();
			model.addAttribute("message", "Xóa thành công!");
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			model.addAttribute("message", "Xóa thất bại!");
		} finally {
			session.close();
		}
		model.addAttribute("products", getProducts());
		return "viewManager/product/index";
	}
	
}
