package com.Controller;

import java.util.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;
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

import com.Entity.ThongBao;

@Controller
@Transactional
@RequestMapping("notification/")
public class Notification {
	@Autowired
	SessionFactory factory;
	@RequestMapping(value="index/{usernameKH}", method = RequestMethod.GET)
	public String index(ModelMap model, @PathVariable("usernameKH") String usernameKH) {	// khach hang xem thong bao
		model.addAttribute("notifys", getNotifys());
		model.addAttribute("usernameKH",usernameKH);
//		return "notification/index";
		return "viewClient/notification/notify";
	}
	
	@ModelAttribute("notifys")
	public List<ThongBao> getNotifys(){
		Session session = factory.getCurrentSession();
		Query query1 = session.createQuery("from ThongBao tb where tb.loaiThongBao.maLoaiThongBao = 'LTB02' or tb.loaiThongBao.maLoaiThongBao = 'LTB03' ");
		List<ThongBao> notifys = query1.list();
		return notifys;
	}
}
