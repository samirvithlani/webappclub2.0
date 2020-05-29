package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.AdminBean;
import com.dao.AdminDao;

@Controller
public class AdminController {

	@Autowired
	AdminDao adminDao;

	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("adminBean", new AdminBean());

		return "login";
	}

	@RequestMapping("/adminlogout")
	public String logout(HttpSession session) {

		session.invalidate();

		return "index";
	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public String adminLogin(AdminBean adminBean, Model model, HttpSession session) {

		AdminBean adminBean2 = adminDao.loginAdmin(adminBean);
		System.out.println("admin name =" + adminBean2.getaName());
		session.setAttribute("loginAdmin", adminBean2);
		return "redirect:/viewAdmins";
	}

	@RequestMapping("/adminHome")
	public String home(Model model) {

		model.addAttribute("adminBean", new AdminBean());
		return "addAdmin";
	}

	@RequestMapping("/insertAdmin")
	public String insertAdmin(@Valid @ModelAttribute("adminBean") AdminBean adminBean, BindingResult br) {

		if (br.hasErrors()) {

			return "addAdmin";
		}

		int res = adminDao.addAdmin(adminBean);

		return "redirect:/viewAdmins";

	}

	@RequestMapping("/viewAdmins")
	// model in continer
	// user create
	public String viewData(Model model) {

		List<AdminBean> listOfAdmins = new ArrayList<AdminBean>();
		listOfAdmins = adminDao.listOfAdmins();
		model.addAttribute("admins", listOfAdmins);

		return "viewAdmin";
	}

	/*
	 * @RequestMapping("/deleteadmin") public String
	 * deleteAdmin(@RequestParam("aid") int aId){
	 * 
	 * 
	 * int res = adminDao.deleteAdmin(aId); System.out.println(res);
	 * 
	 * return "redirect:/viewAdmins";
	 * 
	 * }
	 */

	@RequestMapping("/deleteadmin/{aId}")
	public String deleteAdmin(@PathVariable int aId) {

		int res = adminDao.deleteAdmin(aId);
		System.out.println(res);

		return "redirect:/viewAdmins";

	}

	@RequestMapping("/editadmin/{aId}")
	public String editAdmin(@PathVariable int aId, Model model) {

		AdminBean adminBean = adminDao.getDataById(aId);
		model.addAttribute("admin", adminBean);
		return "editAdmin";

	}

	@RequestMapping(value = "/updateadmin", method = RequestMethod.POST)
	public String updateAdmin(@ModelAttribute("admin") AdminBean adminBean) {

		System.out.println(adminBean);
		int res = adminDao.updateAdmin(adminBean);
		System.out.println(res);
		return "redirect:/viewAdmins";
	}

	@RequestMapping(value = "/getadmindetail/{aId}")
	public String adminDetail(@PathVariable int aId, Model model) {

		AdminBean adminBean = adminDao.getDataById(aId);
		model.addAttribute("adminDetail", adminBean);

		return "adminDetail";
	}

}
