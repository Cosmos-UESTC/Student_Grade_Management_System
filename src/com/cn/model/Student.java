package com.cn.model;

public class Student extends Person{
	private String Major; //职位
	
	public Student(String ID, String Name, String Gender, String Birthday, String Faculty, String Major) {
		super(ID, Name, Gender, Birthday, Faculty);
		this.Major=Major;
	}
	
	public Student() {
		super();
	}
	
	public String getMajor() {
		return Major;
	}
	//获取专业
	protected void setMajor(String Major) {
		this.Major=Major;
	}
	//设置专业
	
	public void info()
    {
        String str = "ID:" + super.getID() + "\nName:" + super.getName() + "\nGender:" + super.getGender() + "\nBirthday:" + super.getBirthday()
                + "\nAcademy:" + super.getFaculty() + "\nProfession:" + this.getMajor();
        System.out.println(str);
    }

}
