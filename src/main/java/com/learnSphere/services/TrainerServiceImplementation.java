package com.learnSphere.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entity.Course;
import com.learnSphere.entity.Lesson;
import com.learnSphere.repository.CourseRepository;
import com.learnSphere.repository.LessonRepository;

@Service
public class TrainerServiceImplementation implements TrainerService {
	@Autowired
	CourseRepository courseRepo;
	@Autowired
	LessonRepository lessonRepo;

	@Override
	public String addCourse(Course c) {
		courseRepo.save(c);
		return "course added successfully!";
	}

	@Override
	public String addLesson(Lesson l) {
		lessonRepo.save(l);
		return "Lesson added successfully!";
	}

	@Override
	public Course getCourse(int courseId) {
		return courseRepo.findById(courseId).get();
	}

	@Override
	public List<Course> courseList() {
		return courseRepo.findAll();
	}

	@Override
	public boolean getCoureId(int courseId) {
		return courseRepo.existsById(courseId);
	}

}
