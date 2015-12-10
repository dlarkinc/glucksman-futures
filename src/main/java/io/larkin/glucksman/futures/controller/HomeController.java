package io.larkin.glucksman.futures.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.larkin.glucksman.futures.domain.Question;
import io.larkin.glucksman.futures.domain.mapper.QuestionMapper;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	JdbcTemplate template;

	@RequestMapping(value = "/{page}", method = RequestMethod.GET)
	public String questionPage(@PathVariable int page, Model model) {
		
		Question q = (Question)template.queryForObject("SELECT * FROM questions WHERE page = ?", new QuestionMapper(), page);
		int count = template.queryForObject("SELECT COUNT(*) FROM questions", Integer.class);
		
		model.addAttribute("question", q);
		model.addAttribute("count", count);
		
		return "question";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/thankyou", method = RequestMethod.GET)
	public String thankyou() {
		return "thankyou";
	}
	
}
