package com.learnSphere.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entity.Course;
import com.learnSphere.entity.Lesson;
import com.learnSphere.repository.CourseRepository;
import com.learnSphere.repository.LessonRepository;

@Service
public class StudentServiceImplementation implements StudentService{

	@Autowired
	LessonRepository lessonRepo;
	@Autowired
	CourseRepository courseRepo;
	
	@Override
	public Lesson getLesson(int lessonId) {
		return lessonRepo.findById(lessonId).get();
	}

	@Override
	public List<Course> courseList() {
		return courseRepo.findAll();
	}

	@Override
	public boolean getLessonId(int lessonId) {
		return lessonRepo.existsById(lessonId);
	}

}
