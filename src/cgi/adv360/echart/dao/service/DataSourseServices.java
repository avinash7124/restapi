package cgi.adv360.echart.dao.service;

import java.util.ArrayList;

import cgi.adv360.echart.EchartComman;
import cgi.adv360.echart.pojo.Student;

public class DataSourseServices {
	ArrayList<Student> studentList = EchartComman.sList;

	public DataSourseServices() {

		Student s1 = new Student(1, "avinash", "kumar");
		studentList.add(s1);
		Student s2 = new Student(2, "awesh", "mandal");
		studentList.add(s2);

	}

	public ArrayList<Student> getStudentList() {

		return studentList;
	}

}
