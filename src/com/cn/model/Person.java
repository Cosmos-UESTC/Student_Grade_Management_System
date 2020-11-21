package com.cn.model;

public abstract class Person {
	private String ID;
	private String Name;
	private String Gender;
	private String Birthday;
	private String Faculty;
	
	public Person (String ID, String Name, String Gender, String Birthday, String Faculty){
		super();
		this.ID = ID;
		this.Name = Name;
		this.Gender = Gender;
		this.Birthday = Birthday;
		this.Faculty = Faculty;
	}
	
	public Person() {
		super();
	}
	
	public String getID() {
		return ID;
	}
	//获取ID
	public String getName() {
		return Name;
	}
	//获取姓名
	public String getGender() {
		return Gender;
	}
	//获取性别
	public String getBirthday() {
		return Birthday;
	}
	//获取出生年
	public String getFaculty() {
		return Faculty;
	}
	//获取所在专业
	
//*********************************************//
	public void setID(String ID) {
		this.ID=ID;
	}
	//设置ID
	public void setName(String Name) {
		this.Name=Name;
	}
	//设置姓名
	public void setGender(String Gender) {
		this.Gender=Gender;
	}
	//设置性别
	public void setBirthday(String Birthday) {
		this.Birthday = Birthday;
	}
	//设置出生年
	public void setFaculty(String Faculty) {
		this.Faculty=Faculty;
	}
	//设置所在专业
	public abstract void info();
		
}

