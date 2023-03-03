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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Entity.ThongBao;

@Controller
@Transactional
@RequestMapping("notification/")
public class Notification {
	@Autowired
	SessionFactory factory;
	@RequestMapping(value="index", method = RequestMethod.GET)
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from ThongBao");
		List<ThongBao> list = query.list();
		model.addAttribute("list", list);
		return "notification/index";
	}
}
