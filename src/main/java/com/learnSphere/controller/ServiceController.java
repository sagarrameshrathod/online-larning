package com.learnSphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.entity.Comments;
import com.learnSphere.entity.Users;
import com.learnSphere.services.CommentService;
import com.learnSphere.services.UserServices;

@Controller
public class ServiceController {
	@Autowired
	UserServices userService;
	
	@Autowired
	CommentService commentService;
	
	@PostMapping("/addUser")
	public String addUser(@RequestParam("name")String name,
			@RequestParam("email")String email,
			@RequestParam("password")String password,
			@RequestParam("role")String role)
	{

		boolean emailExist=userService.checkEmail(email);
		if(emailExist==false) {
			Users user = new Users();
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setRole(role);
			userService.addUsers(user);

			System.out.println("User registered successfully!");
			return "redirect:/login";
		}
		else {
			System.out.println("User already exist!");
			return "redirect:/register";
		}
	}

	@PostMapping("/login")
	public String validate(@RequestParam("email")String email,
				@RequestParam("password")String password) {
		boolean val=userService.validate(email, password);
		if(val==true) {
			if(userService.getUserRole(email).equalsIgnoreCase("trainer")) {
				return "trainerHome";
			}
			else {				
				return "studentHome";
			}
		}
		else {
			System.out.println("incorrect credentials, try again!");
			return "login";
		}
	}
	
	@PostMapping("/addComment")
	public String comments(@RequestParam("comment")String comment
						,Model model) {
		Comments c=new Comments();
		c.setComment(comment);
		commentService.addComment(c);
		
		List<Comments> commentsList=commentService.commentList();
		model.addAttribute("comments",commentsList);
		
		return "redirect:/";
	}
	
}
