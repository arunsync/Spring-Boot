package com.sss.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sss.model.Teacher;
import com.sss.repository.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository repository;
	
	public List<Teacher> getTeachers() {
		List<Teacher> teachers = new ArrayList<>();
		repository.findAll().forEach(teachers::add);
		return teachers;
	}

	public String addTeacher(Teacher t) {
		return repository.save(t) != null?"Success":"Failure"; 
	}

	public String updateTeacher(Teacher t, int id) {
		return repository.save(t) != null?"Success":"Failure"; 
	}

	public void deleteTeacher(int id) {
		repository.deleteById(id);
	}

	public Optional<Teacher> getTeacher(int id) {
		return repository.findById(id); 
	}
}