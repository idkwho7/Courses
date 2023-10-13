package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entites.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	@Autowired
	private CourseService cs;
	
	@GetMapping("/home")
	public String home() {
		return "GET API IS HERE";
	}
	
	//get the courses
	
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.cs.getCourses();
	}
	
	@GetMapping("/course/{courseId}")
	public Course getCourse(@PathVariable String courseId)
	{
		return this.cs.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		return this.cs.addCourse(course);
		
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.cs.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus>deleteCourse( @PathVariable String courseId){
		try {
			this.cs.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
