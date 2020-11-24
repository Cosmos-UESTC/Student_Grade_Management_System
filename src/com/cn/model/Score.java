package com.cn.model;

import com.cn.dao.ScoreDao;

public class Score {
		private String courseId;
		private String courseName;
		private String courseTeacherId;
		private String courseTeacherName;
		private String studentId;
		private String studentName;
		private String studentScore;
		public Score (String courseId, String courseName, String courseTeacherId, String courseTeacherName, String studentId, String studentName, String studentScore){
			super();
			this.courseId = courseId;
			this.courseName = courseName;
			this.courseTeacherId = courseTeacherId;
			this.courseTeacherName = courseTeacherName;
			this.studentId = studentId;
			this.studentName = studentName;
			this.studentScore = studentScore;
		}
		
		public Score() {
			super();
		}
		
		public String getcourseId(){
			return courseId;
		}
		
		public String getcourseName(){
			return courseName;
		}
		
		public String getcourseTeacherId(){
			return courseTeacherId;
		}
		
		public String getcourseTeacherName(){
			return courseTeacherName;
		}
		
		public String getstudentId() {
			return studentId;
		}
		
		public String getstudentName() {
			return studentName;
		}
		
		public String getstudentScore() {
			return studentScore;
		}
		
		public static boolean ifScoreExist(String studentId, String courseName) {
			return !ScoreDao.findScore(studentId, courseName).isEmpty();
		}
		
	///////////////////////
		public void setcourseId(String courseId) {
			this.courseId=courseId;
		}
		
		public void setcourseName(String courseName) {
			this.courseName=courseName;
		}
		
		public void setcourseTeacherId(String courseTeacherId) {
			this.courseTeacherId=courseTeacherId;
		}
		
		public void setcourseTeacherName(String courseTeacherName) {
			this.courseTeacherName=courseTeacherName;
		}
		
		protected void setstudentId(String studentId) {
			this.studentId=studentId;
		}
		
		protected void setstudentName(String studentName) {
			this.studentName=studentName;
		}
		
		protected void setstudentScore(String studentScore) {
			this.studentScore=studentScore;
		}
		
		
		public void info()
	    {
	        String str = "courseId:" + getcourseId() + "\ncourseName:" + getcourseName() + "\nTeacherId:" + getcourseTeacherId() + "\nTeacherName:" 
	        		+ getcourseTeacherName() + "\nstudentId:" + getstudentId() + "\nstudentName:" + getstudentName()  + "\nstudentScore:" + getstudentScore();
	        System.out.println(str);
	    }
}
