package com.project.Blogify.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.Blogify.domain.PostRepository;
@Controller
public class MainController {	
@Autowired
private PostRepository postrepo;
@RequestMapping(value="/", method = RequestMethod.GET)
public String Indexhome(Model model){
	model.addAttribute("posts", postrepo.RetrieveByDate());
	return "index";
}
@RequestMapping(value="/home")
public String logged_home(Model model){
	model.addAttribute("posts", postrepo.RetrieveByDate());
	return "index";
}
@RequestMapping(value = "/login", method = RequestMethod.GET)
public String login() {
	return "login";
}
}
