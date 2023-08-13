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
import com.learnSphere.services.TrainerService;


@Controller
public class TrainerController {
	@Autowired
	TrainerService ts;
	
	@PostMapping("/addCourse")
	public String addCourse(@RequestParam("courseId")int courseId, 
			@RequestParam("courseName")String courseName, 
			@RequestParam("coursePrice")float coursePrice) {
		boolean courseExists = ts.getCoureId(courseId);
		if(courseExists) {
		Course c = new Course();
		c.setCourseId(courseId);
		c.setCourseName(courseName);
		c.setCoursePrice(coursePrice);
		ts.addCourse(c);
		
		return "redirect:/trainerHome";
		}
		else {
			return "trainerHome";
		}
	}
	
	@PostMapping("/addLesson")
	public String addLesson(@RequestParam("courseId")int courseId, 
			@RequestParam("lessonId")int lessonId, 
			@RequestParam("lessonName")String lessonName, 
			@RequestParam("topics")String topics, 
			@RequestParam("links")String links) {
		Course course = ts.getCourse(courseId);
		Lesson l = new Lesson(courseId,lessonName,topics,links,course);
		course.getLesson().add(l);
		ts.addLesson(l);
		return "redirect:/trainerHome";
	}
	
	@GetMapping("/viewCourses")
	public String viewCourse(Model model) {
	    List<Course> courseList = ts.courseList();
	    model.addAttribute("courseList", courseList);
	    return "viewCourses";
	}

}
