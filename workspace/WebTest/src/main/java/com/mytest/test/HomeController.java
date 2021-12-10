package com.mytest.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/getScore.do")
	public String Score(String name, String score, Model model) {
		
		if(name.equals("") || score.equals("")) {
			return "error";
		}
		
		int i = Integer.parseInt(score);
		String grade = "";
		i /= 10;
		switch(i) {
		case 10 :
		case 9 :
			grade = "A";
			break;
		case 8 :
			grade = "B";
			break;
		case 7 :
			grade = "C";
			break;
		case 6 :
			grade = "D";
			break;
		default :
			grade = "F";
			break;
		}
		
		model.addAttribute("grade", grade);
		model.addAttribute("name", name);
		model.addAttribute("score", score);
		return "result";
	}
	
}
