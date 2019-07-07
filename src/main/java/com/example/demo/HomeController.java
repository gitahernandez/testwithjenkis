package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	
	@RequestMapping("home")
	@ResponseBody
	public String home() {
		return "test Text";
	}
	
	@RequestMapping("jsp")
	public String jsp() {
		return "sample.jsp";
	}
	
	@RequestMapping("homeWithServlet")
	public String homeWithServlet(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		System.out.println("hi "+name);
		session.setAttribute("name", name);
		return "sampleServlet.jsp";
		
	}
	
	
	@RequestMapping("ModelAndView")
	public ModelAndView ModelAndView(@RequestParam("name") String name) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.setViewName("sampleServlet.jsp");
		return mv;	
	}
	
	                 
}
