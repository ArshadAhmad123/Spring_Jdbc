package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 */

//basically mujhe jdbcTemplate class ka obj chahiye jo ki mujhe needed method dega
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        //javaconfig and xml file dono use kiya hai mene
       ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
//        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/jdbc_config.xml");
        StudentDao std1 = context.getBean("studentDao",StudentDao.class);
         // Student student = new Student();
        
          //insert
//          student.setId(15);
//          student.setName("arsah");
//          student.setCity("meerut");
//          int r = std1.insert(student);
//          System.out.println("inserted "+r);
          
         //update
//          student.setId(15);
//          student.setName("vandana");
//          student.setCity("delhi");
//          int r=std1.change(student);
//          System.out.println("updated "+r);
          
          //delete
//          int r=std1.delete(102);
//          System.out.println("deleted "+r);
          //without any interface insert query
//        String query ="insert into `tbl_user` values (102,'Arfat','Arfat@gmail.com')";
//        int result = template.update(query);
//        System.out.println("number of record inserted"+result);
          
          
          
          //select queries .. iske liye hum RawMapplerImpl class banayenge joki result set ko obj main convert karega
//          Student std=std1.getStudent(2);
//          System.out.println(std);
//          Student std2=std1.getStudent(15);
//          System.out.println(std2);
        
        
        //select all table data
        List<Student> allStudents = std1.getAllStudents();
        System.out.println(allStudents);
    }
}
