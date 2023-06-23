package com.Controller;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Bean.UploadFile;
import com.Entity.DichVu;
import com.Entity.KhachHang;
import com.Entity.LoaiDichVu;
import com.Entity.LoaiSanPham;
import com.Entity.NhanVien;
import com.Entity.SanPham;
import com.Entity.TaiKhoanKhachHang;
import com.Entity.TaiKhoanNhanVien;

@Controller
@Transactional
public class EmployeeController {
	@Autowired
	SessionFactory factory;
	@Autowired
	ServletContext context;
	@Qualifier("uploadfileSanPham")
	UploadFile baseUploadfile;
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
			model.addAttribute("usernameManager",taiKhoan.getMaTaiKhoanNhanVien());
//			return "viewManager/index";
			return "viewManager/dashboard";
		}
		else if (taiKhoan.getQuyen().getMaQuyen().equals("Q02")){	// nhan vien
//			return "viewEmployee/index";
			List<SanPham> products = getProducts();
			model.addAttribute("products", products);
			model.addAttribute("usernameEmployee",taiKhoan.getMaTaiKhoanNhanVien());
			return "viewEmployee/dashboard";
		}
		
		return "formLogin/loginNV";
	
	}
	
	
	
	
	
	@RequestMapping(value="productEmployee/index/{usernameEmployee}", method=RequestMethod.GET)
	public String indexProduct(ModelMap model, @PathVariable("usernameEmployee") String usernameEmployee) {
//		Session session = factory.getCurrentSession();
		List<SanPham> sanPhams = getProducts();
//		for (SanPham i: sanPhams) {
//			System.out.println(i.getGiaSanPhams().get(0).getGia());
//		}
		model.addAttribute("products", getProducts());
		model.addAttribute("usernameEmployee", usernameEmployee);
		return "viewEmployee/product/index";
	}
	@RequestMapping(value="serviceEmployee/index/{usernameEmployee}", method=RequestMethod.GET)
	public String indexService(ModelMap model, @PathVariable("usernameEmployee") String usernameEmployee) {
//		Session session = factory.getCurrentSession();
		model.addAttribute("services", getServices());
		model.addAttribute("usernameEmployee", usernameEmployee);
		return "viewEmployee/service/index";
	}
	
	
	
	
	@RequestMapping(value = "product/index/{usernameManager}", method = RequestMethod.GET)
	public String index(ModelMap model, @PathVariable("usernameManager") String usernameManager) {
		List<SanPham> sanPhams = getProducts();

		model.addAttribute("products", getProducts());
		model.addAttribute("usernameManager", usernameManager);
		return "viewManager/product/index";

	}

	@RequestMapping(value = "product/insert/{usernameManager}", method = RequestMethod.GET)
	public String insert(ModelMap model, @PathVariable("usernameManager") String usernameManager) {
		Session session = factory.getCurrentSession();
//		Query query = session.createQuery("from NhanVien nv where nv.maNhanVien = :user");
//		query.setParameter("user", usernameManager);
		NhanVien nv = (NhanVien) session.get(NhanVien.class, usernameManager);

		model.addAttribute("typeProducts", getTypeProducts());
		model.addAttribute("usernameManager", usernameManager);
		model.addAttribute("manager", nv);
		return "viewManager/product/insert";
	}

	@RequestMapping(value = "product/insert/{usernameManager}", method = RequestMethod.POST)
	public String insert(ModelMap model, @PathVariable("usernameManager") String usernameManager,
			@RequestParam("maSanPham") String maSanPham, @RequestParam("tenSanPham") String tenSanPham,
			@RequestParam("moTa") String moTa, @RequestParam("hinhAnh") MultipartFile hinhAnh,
			@RequestParam("loaiSanPham") String maLoaiSanPham, @RequestParam("gia") BigDecimal gia) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		SanPham product = new SanPham();
		try {
			// xu li file anh
			
			String hinhAnhPath = context.getRealPath("/image/product/" + hinhAnh.getOriginalFilename());
			hinhAnh.transferTo(new File(hinhAnhPath));
			NhanVien quanLi = (NhanVien) session.get(NhanVien.class, usernameManager);
			LoaiSanPham loaiSP = (LoaiSanPham) session.get(LoaiSanPham.class, maLoaiSanPham);

//			chua them chuc nang upload file anh
			product.setTenSanPham(tenSanPham);
			product.setMaSanPham(maSanPham);
			product.setHinhAnh(hinhAnh.getOriginalFilename());
			product.setMoTa(moTa);
			product.setLoaiSanPham(loaiSP);
//			System.out.println((NhanVien)session.get(NhanVien.class, usernameManager));

//			System.out.println((LoaiSanPham)session.get(LoaiSanPham.class, maLoaiSanPham));

			session.save(product);

			// chua them chuc nang them gia san pham
			// get current day
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			System.out.println(formatter.format(date));

			t.commit();
			model.addAttribute("message", "Thêm thành công");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm thất bại");

		} finally {
			session.close();
		}
		System.out.println(product);
		model.addAttribute("usernameManager", usernameManager);
		model.addAttribute("products", getProducts());
		return "viewManager/product/index";
	}


	

	// tra ve cac loai san pham trong view insert 1 san pham
	@ModelAttribute("typeProducts")
	public List<LoaiSanPham> getTypeProducts() {

		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from LoaiSanPham");
		List<LoaiSanPham> typeProducts = query.list();
		return typeProducts;
	}

	@ModelAttribute("typeProducts")
	public List<SanPham> getProducts() {

		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from SanPham");
		List<SanPham> sanPhams = query.list();
		return sanPhams;
	}
	// tra ve danh sach cac san pham
	
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

	@RequestMapping(value = "product/delete/{usernameManager}/{maSanPham}", method = RequestMethod.GET)
	public String delete(ModelMap model, @PathVariable("usernameManager") String usernameManager,
			@PathVariable("maSanPham") String maSanPham) {
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
		model.addAttribute("usernameManager", usernameManager);
		model.addAttribute("products", getProducts());
		return "viewManager/product/index";
	}

	@RequestMapping(value="service/index/{usernameManager}", method=RequestMethod.GET)
	public String service(ModelMap model, @PathVariable("usernameManager") String usernameManager) {
//		Session session = factory.getCurrentSession();
		model.addAttribute("services", getServices());
		model.addAttribute("usernameManager", usernameManager);
		return "viewManager/service/index";
	}
	
	@RequestMapping(value="service/insert/{usernameManager}", method=RequestMethod.GET)
	public String insertService(ModelMap model, @PathVariable("usernameManager") String usernameManager) {
		Session session = factory.getCurrentSession();
		NhanVien nv = (NhanVien)session.get(NhanVien.class, usernameManager);
		
		model.addAttribute("typeProducts", getTypeServices());
		model.addAttribute("usernameManager", usernameManager);
		model.addAttribute("manager", nv);
		return "viewManager/service/insert";
	}
	
	@RequestMapping(value="service/insert/{usernameManager}", method=RequestMethod.POST)
	public String insert(ModelMap model, @PathVariable("usernameManager") String usernameManager
			,@RequestParam("maDichVu") String maDichVu, 
			@RequestParam("tenDichVu") String tenDichVu,
			@RequestParam("thoiGianThucHien") Time thoiGianThucHien,
			@RequestParam("moTa") String moTa,
			@RequestParam("hinhAnh") MultipartFile hinhAnh,
			@RequestParam("loaiDichVu") String maLoaiDichVu,
			@RequestParam("gia") String gia
			) {
		System.out.print(thoiGianThucHien);
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		DichVu service = new DichVu();
		
		try {
			String hinhAnhPath = context.getRealPath("/image/service/" + hinhAnh.getOriginalFilename());
			hinhAnh.transferTo(new File(hinhAnhPath));
			NhanVien quanLi = (NhanVien)session.get(NhanVien.class, usernameManager);
			LoaiDichVu loaiDV = (LoaiDichVu)session.get(LoaiDichVu.class, maLoaiDichVu);
			
//			chua them chuc nang upload file anh
			service.setTenDichVu(tenDichVu);
			service.setMaDichVu(maDichVu);
			service.setThoiGianThucHien(thoiGianThucHien);
			service.setHinhAnh(hinhAnh.getOriginalFilename());
			service.setMoTa(moTa);
			
			service.setLoaiDichVu(loaiDV);
			
			session.save(service);
			
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
		System.out.println(service);
		
		model.addAttribute("services", getServices());
		return "viewManager/service/index";
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
	
	
	@RequestMapping(value = "service/delete/{maDichVu}", method = RequestMethod.GET)
	public String delete(ModelMap model, @PathVariable("maDichVu") String maDichVu) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			DichVu deleteService = (DichVu) session.get(DichVu.class, maDichVu);
			session.delete(deleteService);
			t.commit();
			model.addAttribute("message", "Xóa thành công!");
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			model.addAttribute("message", "Xóa thất bại!");
		} finally {
			session.close();
		}
		model.addAttribute("services", getServices());
		return "viewManager/service/index";
	}
}
