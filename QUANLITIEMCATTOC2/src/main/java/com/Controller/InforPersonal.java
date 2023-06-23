//package com.Controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.transaction.Transactional;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.Entity.KhachHang;
//
//
//// chua fix xong
//@Controller
//@Transactional
//@RequestMapping("inforPersonal/")
//public class InforPersonal {
//	@Autowired
//	SessionFactory factory;
//	
//	@RequestMapping(value="client/{usernameKH}", method=RequestMethod.GET)
//	public String inforClient(ModelMap model, @PathVariable("usernameKH") String usernameKH) {
//		System.out.print(usernameKH);
//		Session session = factory.getCurrentSession();
//		Query query = session.createQuery("from KhachHang kh where kh.soDienThoai = :sdt");
//		query.setParameter("sdt", usernameKH);
//		KhachHang kh = (KhachHang) query.list().get(0);
//		System.out.print(kh);
//		model.addAttribute("khachHang", kh);
//		return "viewClient/inforClient";
//	}
//	
//	@RequestMapping(value="client/{usernameKH}", method=RequestMethod.POST)
//	public String inforClient(ModelMap model, @ModelAttribute("khachHang") KhachHang khachHang, @PathVariable("usernameKH") String usernameKH) {
//		Session session = factory.openSession();
//		Transaction t = session.beginTransaction();
//		System.out.print(khachHang.getSoDienThoai());
//		try {
//			Query query = session.createQuery("from KhachHang kh where kh.soDienThoai = :sdt");
//			query.setParameter("sdt", usernameKH);
//			KhachHang khachHangCapNhat= (KhachHang) query.list().get(0);
//			System.out.print(khachHangCapNhat);
//			khachHangCapNhat.setHo(khachHang.getHo());		// them rang buoc ho, ten sau lan them dau, lan update tiep theo khong de trong
//			khachHangCapNhat.setTen(khachHang.getTen());
//			khachHangCapNhat.setNgaySinh(khachHang.getNgaySinh());
//			khachHangCapNhat.setDiaChi(khachHang.getDiaChi());
//			khachHangCapNhat.setEmail(khachHang.getEmail());
//			System.out.print(khachHangCapNhat);
//			session.update(khachHangCapNhat);
//			t.commit();
//			model.addAttribute("message", "Chỉnh sửa thành công!");
//			model.addAttribute("khachHang", khachHangCapNhat);
//		} catch (Exception e) {
//			// TODO: handle exception
//			t.rollback();
//			model.addAttribute("message", "Chỉnh sửa thất bại!");
//			model.addAttribute("khachHang", khachHang);
//		} 
//		finally {
//			session.close();
//		}
//		return "viewClient/inforClient";
//	}
//}
