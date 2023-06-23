package com.Controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.transaction.Transactional;

import org.apache.catalina.startup.FailedContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.result.PrintingResultHandler;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Bean.LogUp;
import com.Bean.Login;
import com.Entity.ChiTietPhieuDatHang;
import com.Entity.DichVu;
import com.Entity.KhachHang;
import com.Entity.LoaiDichVu;
import com.Entity.LoaiSanPham;
import com.Entity.PhieuDatHang;
import com.Entity.SanPham;
import com.Entity.TaiKhoanKhachHang;
import com.Entity.ThongBao;
import com.Entity.TrangThaiTaiKhoan;

@Controller
@Transactional
@RequestMapping("client/")
public class ClientController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping(value="loginKH", method=RequestMethod.GET)
	public String login(ModelMap model) {
//		return "formLogin/loginKH";
		model.addAttribute("account", new Login());
		return "viewClient/formLogin/loginHieu";
		
		
	}
	
	@RequestMapping(value="loginKH", method=RequestMethod.POST)
	public String login(ModelMap model,  @ModelAttribute("account") Login account, BindingResult errors) {
		if(account.getUsername().trim().length() == 0 || account.getUsername() == null){
			errors.rejectValue("username", "Vui lòng nhập username!");
		}
		if(account.getPassword().trim().length() == 0 || account.getPassword() == null){
			errors.rejectValue("password", "Vui lòng nhập password!");
		}
		if(errors.hasErrors()){
			model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
			return "formLogin/loginHieu";
		}
		else{
			model.addAttribute("message", "Chúc mừng, bạn đã nhập đúng !");
		}

		
		Session session = factory.getCurrentSession();

		Query query = session.createQuery("from TaiKhoanKhachHang kh where kh.soDienThoai= :user and kh.passWord=:pass");
		query.setParameter("user", account.getUsername());
		query.setParameter("pass", account.getPassword());
		List<TaiKhoanKhachHang> list = query.list();
		
		if (list.size() == 0 ) {	// khong ton tai tai khoan
//			return "formLogin/loginKH";
			return "formLogin/loginHieu";
		}
		if (list.get(0).getTrangThaiTaiKhoanKhachHang().getMaTrangThai().equals('0')) { // trang thai tai khoan tam ngung
//			return "formLogin/loginKH";
			return "formLogin/loginHieu";
		}
		
		// lua chon cac thong bao khach hang xem duoc
		Query query1 = session.createQuery("from ThongBao tb where tb.loaiThongBao.maLoaiThongBao = 'LTB02' or tb.loaiThongBao.maLoaiThongBao = 'LTB03' ");
		List<ThongBao> notifys = query1.list();
		model.addAttribute("notifys", notifys);
		model.addAttribute("usernameKH", list.get(0).getMaTaiKhoanKhachHang());
		
		return "viewClient/notification/notify";
	}
	


	
	@RequestMapping(value="home",method = RequestMethod.GET)
	public String home(Model model) {
		LogUp logUp = new LogUp();
		model.addAttribute("logUp", logUp);
		System.out.println("home get: "+logUp);
		return "viewClient/home";
		
	}
	
	@RequestMapping(value="home",method = RequestMethod.POST)
	public String logUp(Model model, @ModelAttribute("logUp") LogUp logUp, BindingResult errors) {
		System.out.println(logUp);
		boolean success = true;
		
		
		if(!logUp.getPassword().trim().equals(logUp.getPasswordRepeat().trim())){
			errors.rejectValue("passwordRepeat", "logUp", "Mật khẩu nhập lại không khớp");
			System.out.println("Mật khẩu nhập lại không khớp");
			success = false;
		}
		
		Session session = factory.openSession();
		Query query = session.createQuery("from TaiKhoanKhachHang kh where kh.soDienThoai= :sdt");
		query.setParameter("sdt", logUp.getSdt());
		List<TaiKhoanKhachHang> list = query.list();
		System.out.println(list.size());
		if (list.size() == 1) {
			errors.rejectValue("sdt", "logUp", "Số điện thoại này đã có người đăng ký");
			System.out.println("Số điện thoại này đã có người đăng ký");
			success = false;
			
		}
		
		if (success) {
			Transaction transaction = session.beginTransaction();
			TaiKhoanKhachHang taiKhoanKhachHang = new TaiKhoanKhachHang();
			taiKhoanKhachHang.setSoDienThoai(logUp.getSdt().trim());
			taiKhoanKhachHang.setPassWord(logUp.getPassword().trim());
			taiKhoanKhachHang.setMaTaiKhoanKhachHang("1");
			String hoTen = logUp.getHoTen().trim();
			int viTriTachHoTen = 0;
			for (int i = hoTen.length()-1; i >= 0; i--) {
				if (hoTen.charAt(i) == ' ') {
					viTriTachHoTen = i;
					break;
				}
			}
			String ho = hoTen.substring(0, viTriTachHoTen);
			String ten = hoTen.substring(viTriTachHoTen+1, hoTen.length());
			System.out.println(ho);
			System.out.println(ten);
			KhachHang khachHang = new KhachHang();
			khachHang.setHo(ho);
			khachHang.setTen(ten);
			khachHang.setMaKhachHang("1");
			System.out.println(taiKhoanKhachHang);
			System.out.println(khachHang);
			try {
				session.save(taiKhoanKhachHang);
				session.save(khachHang);
				transaction.commit();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				success = false;
				transaction.rollback();
			}
			finally {
				session.close();
			}
		}
		if (success) {
			return "redirect:/loginKH.htm";
		}
		
		model.addAttribute("success", success);
		model.addAttribute("logUp", logUp);
		return "viewClient/home";
	}
	
	@RequestMapping("profile")
	public String profile(Model model) {
		Session session = factory.getCurrentSession();
		Query query1 = session.createQuery("from ThongBao tb where tb.loaiThongBao.maLoaiThongBao = 'LTB02' or tb.loaiThongBao.maLoaiThongBao = 'LTB03' ");
		List<ThongBao> notifys = query1.list();
		model.addAttribute("notifys", notifys);
		
		return "viewClient/notification/notify";
	}
	
	@RequestMapping("notify")
	public String notify(Model model) {
		Session session = factory.getCurrentSession();
		Query query1 = session.createQuery("from ThongBao tb where tb.loaiThongBao.maLoaiThongBao = 'LTB02' or tb.loaiThongBao.maLoaiThongBao = 'LTB03' ");
		List<ThongBao> notifys = query1.list();
		model.addAttribute("notifys", notifys);
		
		return "viewClient/notification/notify";
	}
	
	@RequestMapping(value="productClient/index/{usernameKH}", method=RequestMethod.GET)
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
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from PhieuDatHang pdh where pdh.khachHangDat.maKhachHang =:user and pdh.tinhTrangDonHang.maTinhTrang =:matt");
		query.setParameter("user", usernameKH);
		query.setParameter("matt", "0");
		List<PhieuDatHang> phieuDatHangs = query.list();
		if (phieuDatHangs.size() == 0) {
			model.addAttribute("gioHang", 0);
		}
		else {
			PhieuDatHang phieuDatHang = (PhieuDatHang) query.list().get(0);
			Query query2 = session.createQuery("from ChiTietPhieuDatHang ct where ct.phieuDatHang.idPhieuDatHang = phieuDatHang.idPhieuDatHang");
			List<ChiTietPhieuDatHang> chiTietPdh = query2.list();
			model.addAttribute("gioHang", chiTietPdh.size());
		}
	
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("collectionPage", collectionPage);
//		model.addAttribute("products", products);
		model.addAttribute("usernameKH",usernameKH);
		return "viewClient/product/index";
	}
	
	@RequestMapping(value="productClient/order/{usernameKH}/{maSanPham}", method=RequestMethod.GET)
	public String order(ModelMap model, @PathVariable("usernameKH") String usernameKH, @PathVariable("maSanPham") String maSanPham) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		
		try {
			Query query = session.createQuery("from PhieuDatHang pdh where pdh.khachHangDat.maKhachHang =:user and pdh.tinhTrangDonHang.maTinhTrang =:matt");
			query.setParameter("user", usernameKH);
			query.setParameter("matt", "0");
			List<PhieuDatHang> phieuDatHangs = query.list();
			List<ChiTietPhieuDatHang> ctpdhs = new ArrayList<>();
			PhieuDatHang phieuDatHang = new PhieuDatHang();
			System.out.println(phieuDatHangs.size());
			if (phieuDatHangs.size() == 0) { // khach hang chua lap phieu dat hang nao
				// tao phieu dat hang khi khach hang click mua san pham
				phieuDatHang.setHoTenNguoiNhan("");
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
			    Date date = new Date();  
			    System.out.println(formatter.format(date)); 
				phieuDatHang.setNgayDat(date);
				KhachHang kh = (KhachHang)session.get(KhachHang.class, usernameKH);
				System.out.println(kh);
				phieuDatHang.setDiaChi(kh.getDiaChi());
				phieuDatHang.setSoDienThoaiNguoiNhan("");
				phieuDatHang.setNgayDuKienGiaoHang(null);
				phieuDatHang.setKhachHangDat(kh);
//				TinhTrangDonHang ttdh = (TinhTrangDonHang) session.get(TinhTrangDonHang.class, "1");
				phieuDatHang.setTinhTrangDonHang(null);
				phieuDatHang.setNhanVienDuyet(null);
				phieuDatHang.setNhanVienGiao(null);
				System.out.println(phieuDatHang);
				
				
			}
			else {
				phieuDatHang = (PhieuDatHang) query.list().get(0);
				Query query2 = session.createQuery("from ChiTietPhieuDatHang ct where ct.phieuDatHang.idPhieuDatHang = phieuDatHang.idPhieuDatHang and ct.sanPhamDuocDat.maSanPham =:ma ");
				query2.setParameter("ma", maSanPham);
				ctpdhs = query2.list();
			}
			session.save(phieuDatHang);
			
			// them san pham vao chi tiet phieu dat hang
//			Query query1 = session.createQuery("from PhieuDatHang");
//			List<PhieuDatHang> phieuDatHangs = query1.list();
			
			
			ChiTietPhieuDatHang ctpdh = new ChiTietPhieuDatHang();
			if (phieuDatHangs.size() == 0 || ctpdhs.size() == 0) {
				ctpdh = new ChiTietPhieuDatHang();
				SanPham sp = (SanPham)session.get(SanPham.class, maSanPham);
				ctpdh.setPhieuDatHang(phieuDatHang);
				ctpdh.setSanPhamDuocDat(sp);
				ctpdh.setSoLuong(1);	
			}
			else {
				ctpdh = ctpdhs.get(0);
				ctpdh.setSoLuong(ctpdh.getSoLuong()+1);
			}
			
			System.out.println(ctpdh);
			session.save(ctpdh);
			t.commit();
			model.addAttribute("message","order success");
		}
		catch(Exception e) {
			t.rollback();
			model.addAttribute("message","order fail");
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		
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
		Session session1 = factory.getCurrentSession();
		Query query = session1.createQuery("from PhieuDatHang pdh where pdh.khachHangDat.maKhachHang =:user and pdh.tinhTrangDonHang.maTinhTrang =:matt");
		query.setParameter("user", usernameKH);
		query.setParameter("matt", "0");
		List<PhieuDatHang> phieuDatHangs = query.list();
		if (phieuDatHangs.size() == 0) {
			model.addAttribute("gioHang", 0);
		}
		else {
			PhieuDatHang phieuDatHang = (PhieuDatHang) query.list().get(0);
			Query query2 = session1.createQuery("from ChiTietPhieuDatHang ct where ct.phieuDatHang.idPhieuDatHang = phieuDatHang.idPhieuDatHang");
			List<ChiTietPhieuDatHang> chiTietPdh = query2.list();
			model.addAttribute("gioHang", chiTietPdh.size());
		}
	
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("collectionPage", collectionPage);
		model.addAttribute("products", products);
		model.addAttribute("usernameKH",usernameKH);
		return "viewClient/product/index";
	}
	
	@RequestMapping(value="productClient/cart/{usernameKH}", method=RequestMethod.GET)
	public String cart(ModelMap model, @PathVariable("usernameKH") String usernameKH) {
		Session session1 = factory.getCurrentSession();
		Query query = session1.createQuery("from PhieuDatHang pdh where pdh.khachHangDat.maKhachHang =:user and pdh.tinhTrangDonHang.maTinhTrang =:matt");
		query.setParameter("user", usernameKH);
		query.setParameter("matt", "0");
		List<PhieuDatHang> phieuDatHangs = query.list();
		if (phieuDatHangs.size() == 0) {
			model.addAttribute("chiTietPhieuDatHangs", null);
		}
		else {
			PhieuDatHang phieuDatHang = (PhieuDatHang) query.list().get(0);
			Query query2 = session1.createQuery("from ChiTietPhieuDatHang ct where ct.phieuDatHang.idPhieuDatHang = phieuDatHang.idPhieuDatHang");
			List<ChiTietPhieuDatHang> chiTietPdh = query2.list();
			model.addAttribute("chiTietPhieuDatHangs", chiTietPdh);
		}
		model.addAttribute("usernameKH",usernameKH);
		return "viewClient/product/order";
	}
	
	@RequestMapping(value="productClient/cart/{usernameKH}", method=RequestMethod.POST)
	public String cart1(ModelMap model, @PathVariable("usernameKH") String usernameKH) {
		Session session1 = factory.getCurrentSession();
		Query query = session1.createQuery("from PhieuDatHang pdh where pdh.khachHangDat.maKhachHang =:user and pdh.tinhTrangDonHang.maTinhTrang =:matt");
		query.setParameter("user", usernameKH);
		query.setParameter("matt", "0");
		List<PhieuDatHang> phieuDatHangs = query.list();
		if (phieuDatHangs.size() == 0) {
			model.addAttribute("chiTietPhieuDatHangs", null);
		}
		else {
			PhieuDatHang phieuDatHang = (PhieuDatHang) query.list().get(0);
			Query query2 = session1.createQuery("from ChiTietPhieuDatHang ct where ct.phieuDatHang.idPhieuDatHang = phieuDatHang.idPhieuDatHang");
			List<ChiTietPhieuDatHang> chiTietPdh = query2.list();
			model.addAttribute("chiTietPhieuDatHangs", chiTietPdh);
		}
		model.addAttribute("usernameKH",usernameKH);
		return "viewClient/product/order";
	}
		
	@RequestMapping(value="productClient/detail/{usernameKH}/{maSanPham}", method=RequestMethod.GET)
	public String detail(ModelMap model, @PathVariable("usernameKH") String usernameKH, @PathVariable("maSanPham") String maSanPham) {
		Session session = factory.getCurrentSession();
		SanPham sanPham = (SanPham)session.get(SanPham.class, maSanPham);
		model.addAttribute("sanPham", sanPham);
		model.addAttribute("usernameKH",usernameKH);
		return "viewClient/product/detail";
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
	
	@RequestMapping(value="serviceClient/index/{usernameKH}", method=RequestMethod.GET)
	public String service(ModelMap model, @PathVariable("usernameKH") String usernameKH) {
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
	
	@RequestMapping("serviceClient/booking")
	public String booking(Model model) {
		return "viewClient/service/booking";
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
