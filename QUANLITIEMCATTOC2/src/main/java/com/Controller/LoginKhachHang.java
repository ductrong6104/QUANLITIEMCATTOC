package com.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Entity.TaiKhoanKhachHang;
import com.Entity.ThongBao;

@Controller
@Transactional
public class LoginKhachHang {
	@Autowired
	SessionFactory factory;
	@RequestMapping(value="loginKH", method=RequestMethod.GET)
	public String login() {
//		return "formLogin/loginKH";
		return "viewClient/formLogin/loginHieu";
	}
	
	@RequestMapping(value="loginKH", method=RequestMethod.POST)
	public String login(ModelMap model, HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Session session = factory.getCurrentSession();
		
		Query query = session.createQuery("from TaiKhoanKhachHang kh where kh.userNameKhachHang= :user and kh.passWord=:pass");
		query.setParameter("user", username);
		query.setParameter("pass", password);
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
		model.addAttribute("usernameKH", username);
		return "viewClient/notification/notify";
	}
}
