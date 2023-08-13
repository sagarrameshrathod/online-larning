package com.learnSphere.controller;

import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

	@GetMapping("/home")
	public String index() {
		return "index";
	}
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/createCourse")
	public String course() {
		return "createCourse";
	}
	@GetMapping("/addLesson")
	public String lesson() {
		return "addLesson";
	}
	@GetMapping("/trainerHome")
	public String trainer() {
		return "trainerHome";
	}
	@GetMapping("/studentHome")
	public String student() {
		return "studentHome";
	}
	@GetMapping("/view")
	public String viewCourses() {
		return "viewCourses";
	}
	@GetMapping("/buy")
	public String buy() {
		return "buyCourses";
	}
	@GetMapping("/myCourses")
	public String myCourses() {
		return "myCourses";
	}
	@GetMapping("/viewLesson")
	public String viewLessons() {
		return "viewLesson";
	}
	@GetMapping("/myLessons")
	public String myLessons() {
		return "myLessons";
	}
}
