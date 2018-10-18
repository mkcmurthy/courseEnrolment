package com.cognizantEvaluation.courseEvaluation;

import java.util.List;

public interface StudentDao {
	
	public int getStudentCount(String courseName);
	public String getProfessor();
	public String getCourse();
	public List<Student> getmatchingStudents();

}
