package com.cn.model;

public class Course {
	private String courseId;
	private String courseName;
	private String courseCredit;
	private String courseHours;
	private String courseTeacherId;
	private String courseTeacherName;
	
	public Course (String courseId, String courseName, String courseCredit, String courseHours, String courseTeacherId, String courseTeacherName){
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseCredit = courseCredit;
		this.courseHours = courseHours;
		this.courseTeacherId = courseTeacherId;
		this.courseTeacherName = courseTeacherName;
	}
	
	public Course() {
		super();
	}
	
	public String getcourseId(){
		return courseId;
	}
	
	public String getcourseName(){
		return courseName;
	}
	
	public String getcourseCredit(){
		return courseCredit;
	}
	
	public String getcourseHours(){
		return courseHours;
	}
	
	public String getcourseTeacherId(){
		return courseTeacherId;
	}
	
	public String getcourseTeacherName(){
		return courseTeacherName;
	}
	
	//////////////////////////////////////////////
	
	public void setcourseId(String courseId) {
		this.courseId=courseId;
	}
	
	public void setcourseName(String courseName) {
		this.courseName=courseName;
	}
	
	public void setcourseCreditd(String courseCredit) {
		this.courseCredit=courseCredit;
	}
	
	public void setcourseHours(String courseHours) {
		this.courseHours=courseHours;
	}
	
	public void setcourseTeacherId(String courseTeacherId) {
		this.courseTeacherId=courseTeacherId;
	}
	
	public void courseTeacherName(String courseTeacherName) {
		this.courseTeacherName=courseTeacherName;
	}
	
	public void info() {
		
	}
}
