package com.cognizantEvaluation.courseEvaluation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerCourseEvaluation  {
	
	@Autowired
	private StudentDaoImpl studentDao;
	//Find the total number of students attending a particular course
	@RequestMapping(value="/students/{course}", method=RequestMethod.GET)
	public int getStudentsList(@PathVariable("course") String courseName) {
		
		int result = studentDao.getStudentCount(courseName); //fetch from database
		
		return result;
		
	}
	
	//Find the professor who teaches the maximum number of courses
	@RequestMapping(value="/students/maxNumberofCourses", method=RequestMethod.GET)
	public String getProfessor() {
		
		String professor = studentDao.getProfessor(); // fetch from database
		return professor;
	}
	
	//Which course has the minimum number of students?
	@RequestMapping(value="students/minnoofStudents", method=RequestMethod.GET)
	public String getCourse() {
		
		String course = studentDao.getCourse();//fetch from database
		return course;
	}
	
	//Which 2 students have the highest number of matching classes?
	@RequestMapping(value="students/matchingclasses", method=RequestMethod.GET)
	public List<Student> getmatchingStudents(){
		
		List<Student> list = studentDao.getmatchingStudents();
		//fetch the list of students from database
		return null;
	}
	

}
