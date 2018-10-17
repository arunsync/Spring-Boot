package com.sss.repository;

import org.springframework.data.repository.CrudRepository;

import com.sss.model.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer>{
	
}