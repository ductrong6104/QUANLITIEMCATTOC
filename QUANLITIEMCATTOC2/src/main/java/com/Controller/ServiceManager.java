package com.Controller;

import java.sql.Time;
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
import com.Entity.LoaiSanPham;
import com.Entity.NhanVien;
import com.Entity.SanPham;
import com.Entity.ThayDoiGiaSanPham;

@Controller
@Transactional
@RequestMapping("service/")
public class ServiceManager {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping(value="index/{usernameManager}", method=RequestMethod.GET)
	public String index(ModelMap model, @PathVariable("usernameManager") String usernameManager) {
//		Session session = factory.getCurrentSession();
		model.addAttribute("services", getServices());
		model.addAttribute("usernameManager", usernameManager);
		return "service/index";
	}
	
	@RequestMapping(value="insert/{usernameManager}", method=RequestMethod.GET)
	public String insert(ModelMap model, @PathVariable("usernameManager") String usernameManager) {
		Session session = factory.getCurrentSession();
		NhanVien nv = (NhanVien)session.get(NhanVien.class, usernameManager);
		
		model.addAttribute("typeProducts", getTypeServices());
		model.addAttribute("usernameManager", usernameManager);
		model.addAttribute("manager", nv);
		return "service/insert";
	}
	
	@RequestMapping(value="insert/{usernameManager}", method=RequestMethod.POST)
	public String insert(ModelMap model, @PathVariable("usernameManager") String usernameManager
			,@RequestParam("maDichVu") String maDichVu, 
			@RequestParam("tenDichVu") String tenDichVu,
			@RequestParam("thoiGianThucHien") Time thoiGianThucHien,
			@RequestParam("moTa") String moTa,
			@RequestParam("hinhAnh") String hinhAnh,
			@RequestParam("loaiDichVu") String maLoaiDichVu
//			@RequestParam("gia") String gia
			) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		DichVu service = new DichVu();
		ThayDoiGiaSanPham giaSanPham = new ThayDoiGiaSanPham();
		try {
			NhanVien quanLi = (NhanVien)session.get(NhanVien.class, usernameManager);
			LoaiDichVu loaiDV = (LoaiDichVu)session.get(LoaiDichVu.class, maLoaiDichVu);
			
//			chua them chuc nang upload file anh
			service.setTenDichVu(tenDichVu);
			service.setMaDichVu(maDichVu);
			service.setThoiGianThucHien(thoiGianThucHien);
			service.setHinhAnh(hinhAnh);
			service.setMoTa(moTa);
			
			service.setQuanLiTaoDichVu(quanLi);
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
		return "service/index";
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
	
	
	@RequestMapping(value = "delete/{maDichVu}", method = RequestMethod.GET)
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
		return "service/index";
	}
}
