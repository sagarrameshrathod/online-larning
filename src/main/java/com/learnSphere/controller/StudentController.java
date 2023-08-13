package com.learnSphere.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.entity.Course;
import com.learnSphere.entity.Lesson;
import com.learnSphere.services.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@PostMapping("/showLesson")
	public String myLesson(@RequestParam("lessonId")int lessonId, Model model) {
		boolean lessonExists = studentService.getLessonId(lessonId);
		if(lessonExists) {
			Lesson lessonList = studentService.getLesson(lessonId);
		    model.addAttribute("lesson", lessonList);
		    return "myLessons";
		}
		else {
			return "viewLesson";
		}
	}
	
	@GetMapping("/buyCourses")
	public String viewCourse(Model model) {
	    List<Course> courseList = studentService.courseList();
	    model.addAttribute("courseList", courseList);
	    return "buyCourses";
	}
}
