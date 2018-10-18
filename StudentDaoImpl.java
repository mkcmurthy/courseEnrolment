package com.cognizantEvaluation.courseEvaluation;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("studentdao")
public class StudentDaoImpl implements StudentDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public int getStudentCount(String courseName) {
		
		String str = "select count(*) from (select distinct student_name from course-enrolment where course_name=?";
		int res = jdbcTemplate.queryForObject(str,Integer.class);
		return res;
	}

	@Override
	public String getProfessor() {
		
		String str = "select professor from course-enrolment group by professor order by count(professor) desc limit 1";
		String s = jdbcTemplate.queryForObject(str, String.class);
		return s;
	}

	@Override
	public String getCourse() {
		String str = "select course_name from course-enrolment group by student_name order by count(student_name) asc limit 1";
		String s = jdbcTemplate.queryForObject(str, String.class);
		return s;
	}

	@Override
	public List<Student> getmatchingStudents() {
		return null;
	}

}
