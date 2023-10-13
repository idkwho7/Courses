package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entites.Course;


@Service
public class CourseServiceImpl implements CourseService {
	
	
	List<Course> list;
	
	public CourseServiceImpl() {
		list=new ArrayList<>();
		list.add(new Course(01,"Java Course","All about java"));
		list.add(new Course(02,"Python Course","All about Python"));
		
	}
	

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}


	@Override
	public Course getCourse(long courseId) {
		Course c = null;
		for (Course course : list) {
			if (course.getId()==courseId) {
				c= course;
				break;
			}
		}
		return c;
	}


	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}


	@Override
	public Course updateCourse(Course course) {
		list.forEach(e ->{
			if(e.getId()==course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		return course;
	}


	@Override
	public void deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
	}

}
