package com.cn.model;

import com.cn.dao.CourseStuDao;

public class CourseStu {
		private String courseId;
		private String courseName;
		private String studentId;
		private String studentName;
		
		public CourseStu (String courseId, String courseName, String studentId, String studentName){
			super();
			this.courseId = courseId;
			this.courseName = courseName;
			this.studentId = studentId;
			this.studentName = studentName;
		}
		
		public CourseStu() {
			super();
		}
		
		public String getCourseId(){
			return courseId;
		}
		
		public String getCourseName(){
			return courseName;
		}
		
		public String getCourseStuId() {
			return studentId;
		}
		
		public String getCourseStuName() {
			return studentName;
		}
		
		///////
		
		public static boolean ifCourseStuExist(String courseId, String CourseStuId) {
			return !CourseStuDao.findCourseStu(courseId, CourseStuId).isEmpty();
		}
		
		public void setCourseId(String courseId) {
			this.courseId=courseId;
		}
		
		public void setCourseName(String courseName) {
			this.courseName=courseName;
		}
		
		public void setStuId(String studentId) {
			this.studentId=studentId;
		}
		
		public void setStuName(String studentName) {
			this.studentName=studentName;
		}
		
		public void info()
	    {
	        String str = "courseId:" + getCourseId() + "\ncourseName:" + getCourseName() +  "\nstudentId:" + getCourseStuId() + "\nstudentName:" + getCourseStuName();
	        System.out.println(str);
	    }
}
