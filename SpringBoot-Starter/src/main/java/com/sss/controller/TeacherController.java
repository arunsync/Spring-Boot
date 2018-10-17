package com.sss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sss.model.Teacher;
import com.sss.service.TeacherService;

@RestController
public class TeacherController {
	
	@Autowired
	private TeacherService teacherServie;
	
	@RequestMapping("/teachers")
	public List<Teacher> getTeachers() {
		return teacherServie.getTeachers();
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/teachers")
	public String addTeacher(@RequestBody Teacher t) {
		return teacherServie.addTeacher(t);
	}
	
	@RequestMapping("/teachers/{id}")
	public Optional<Teacher> addTeacher(@PathVariable int id) {
		return teacherServie.getTeacher(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/teachers/{id}")
	public String addTeacher(@RequestBody Teacher t, @PathVariable("id") int id) {
		return teacherServie.updateTeacher(t, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/teachers/{id}")
	public void deleteTeacher(@PathVariable("id") int id) {
		teacherServie.deleteTeacher(id);
	}
}