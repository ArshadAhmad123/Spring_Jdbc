package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.entities.Student;

public interface StudentDao {
	
       public int insert(Student student);
       public int change(Student student);
       public int delete(int stdId);
       public Student getStudent(int stdId);
       public Student getStudentWithAnnomous(int stdId);
       
}
