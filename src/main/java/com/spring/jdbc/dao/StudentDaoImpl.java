package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(Student student) {
		String query ="insert into `tbl_user`(id,name,email) values(?,?,?)";
       int result=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
       return result;
	}
    
	
	public JdbcTemplate getJdbcTemplate() {
		
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public int change(Student student) {
		String query="update tbl_user set name=?,email=? where id=?";
		
		int r=this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return r;
	}


	@Override
	public int delete(int stdId) {
	     String query = "delete from tbl_user where id=?";
	     int r = this.jdbcTemplate.update(query,stdId);
		 return r;
	}


	@Override
	public Student getStudent(int stdId) {
        String query  = "select * from tbl_user where id=?";
      //  iske liye hum RawMapplerImpl class ka obj banayenge joki queryForObject method ko pass karenge
        RowMapper<Student> rawMapper =new RawMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query,rawMapper,stdId);
		return student;
	}


	@Override
	public Student getStudentWithAnnomous(int stdId) {
		 String query  = "select * from tbl_user where id=?";
	     //annonymous class banayege joki direct implmentation deti hai
	        Student student = this.jdbcTemplate.queryForObject(query,new RowMapper<Student>() {

				@Override
				public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
					 Student student = new Student();
					 student.setId(rs.getInt(1));
					 student.setName(rs.getString(2));
					 student.setCity(rs.getString(3));
					return student;
				}
			},stdId);
			return student;
	}
	
}
