package com.cts.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.model.Student;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/data")
	public ModelAndView sendData() {
		ModelAndView mav = new ModelAndView("data");
		//Sending the text data to a template
		mav.addObject("message", "There is no meaning of Living If you can't live the life the way that you want");
		return mav; 
	}
	
	@RequestMapping("/student")
	public ModelAndView getStudent() {
		ModelAndView mav=new ModelAndView("student");
		
		Student student = new Student();
		student.setName("Devika");
		student.setScore(97);
		
		//sending an object to a template
		mav.addObject("student", student);
		return mav;
	}
	
	@RequestMapping("/studentList")
	public ModelAndView getStudents() {
		ModelAndView mav=new ModelAndView("studentList");
		
		Student student = new Student();
		student.setName("Bunny");
		student.setScore(97);
		
		Student student2 = new Student();
		student2.setName("Chinni");
		student2.setScore(90);	
		
		List<Student> students = Arrays.asList(student,student2);
		
		//sending an list object to a template
		mav.addObject("students", students);
		return mav;
	}
	
	@RequestMapping("/studentForm")
	public ModelAndView sendingStudentToForm() {
		ModelAndView mav=new ModelAndView("studentForm");
		
		Student student = new Student();
		student.setName("Devika");
		student.setScore(97);
		
		//sending an object to a template
		mav.addObject("student", student);
		return mav;
	}

	@RequestMapping("/studentSave")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		ModelAndView mav=new ModelAndView("studentSave");
		return mav;
	}
	
}
