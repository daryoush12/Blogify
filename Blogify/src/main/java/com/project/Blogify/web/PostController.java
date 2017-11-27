package com.project.Blogify.web;

import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.Blogify.domain.*;
import com.project.Blogify.storage.StorageService;
@Controller
public class PostController {
	
	@Autowired
	private PostRepository postrepo;
	@Autowired
	private UserRepository userepo;
	
	private final StorageService storageService;
	//
    @Autowired
    public PostController(StorageService storageService) {
        this.storageService = storageService;
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBook(Model model) {
		model.addAttribute("post", new Post());
		return "add";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(Post post,Principal principal,@RequestParam("file") MultipartFile file) {
		storageService.store(file);
		System.out.println("You successfully uploaded " + file.getOriginalFilename() + "!");
		post.setAuthor(userepo.findByUsername(principal.getName()));
		//New input value into form that show categories possible to be used:
		//categories to be added manually:
		post.setImageUrl(file.getOriginalFilename());
		post.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
	    postrepo.save(post);
		return "redirect:/";
	}

	@RequestMapping(value = "/post/{id}")
	public String showPost(@PathVariable("id") Long id, Model model) {
		System.out.println("User wanted to view post" + id);
		model.addAttribute("postImage",storageService.load(postrepo.findById(id).getImageUrl()));
		model.addAttribute("author",postrepo.findById(id).getAuthor());
		model.addAttribute("post",postrepo.findById(id));
		return "post";
	}
	
	 @RequestMapping(value = "/post/delete", method = RequestMethod.POST)
	   public String processQuery(SelectableObject sb, Model model) {
	     if(postrepo.findOne(sb.getId()) != null){
	    	 System.out.println("Found a match from database.");
	     }
	     	System.out.println(sb.getId());
	      return "redirect:../profile";
	   }
	 
//	 @RequestMapping(value = "/post/delete", method = RequestMethod.POST)
//	 public String foo(@RequestParam("selected") List<SelectableObject> values){
//		 for(int i = 0; i < values.size(); i++){
//	     if(postrepo.findOne(values.get(i).getId()) != null){
//	    	 System.out.println("Found a match from database.");
//	     }
//	   }
//		 return "redirect:../profile";
//	 }
	 
}
