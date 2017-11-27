package com.project.Blogify.web;

import java.security.Principal;
import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.Blogify.domain.ModifiableUserObject;
import com.project.Blogify.domain.Post;
import com.project.Blogify.domain.PostRepository;
import com.project.Blogify.domain.SelectableObject;
import com.project.Blogify.domain.User;
import com.project.Blogify.domain.UserRepository;



@Controller
public class UserController {
	
	@Autowired
	private UserRepository userepo;
	
	@Autowired
	private PostRepository postrepo;
	
	
	private ArrayList<Post> selectedPosts = new ArrayList<Post>();
	
	  @RequestMapping(value = "/username", method = RequestMethod.GET)
	  @ResponseBody
	    public String currentUserName(Principal principal) {
	        return principal.getName();
	    }
	  @RequestMapping(value = "/profile", method = RequestMethod.GET)
	    public String currentUserName(Principal principal,Model model) {
		  	model.addAttribute("user", userepo.findByUsername(principal.getName()));
		  	model.addAttribute("posts", postrepo.RetrieveByDate());
		  	model.addAttribute("post", new Post());
		  	model.addAttribute("newuser",new ModifiableUserObject());
		  	model.addAttribute("selectable", new SelectableObject());
		  	//DeletePostForm wrapper = new DeletePostForm();
		  	//wrapper.setSelectedPostList(postrepo.findAll());
		  //  model.addAttribute("wrapper", wrapper);
	        return "profile";
	    }
	  
	  @RequestMapping(value = "/profile/update", method = RequestMethod.POST)
		public String delete(@ModelAttribute("newuser") ModifiableUserObject user, Model model) {
		    System.out.println("UPDATE ACTION:  "+user.getUsername()+" "+user.getId()+" "+user.getFirstname());
		    User tobeModded = userepo.findById(user.getId());
			tobeModded.setFirstname(user.getFirstname());
			tobeModded.setLastname(user.getLastname());
			tobeModded.setUsername(user.getUsername());
		    userepo.save(tobeModded);
		    Authentication authentication = new UsernamePasswordAuthenticationToken(tobeModded.getUsername(),tobeModded.getPasswordHash());
		    SecurityContextHolder.getContext().setAuthentication(authentication);
			return "redirect:../profile";
		}
	  
	  @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	    public String viewDash(Principal principal,Model model) {
	        return "dashboard";
	    }
	  
	  @RequestMapping(value = "/dashboard/new blog", method = RequestMethod.GET)
	    public String newBlog(Principal principal,Model model) {
	        return "dashboard_newblog";
	    }
}
