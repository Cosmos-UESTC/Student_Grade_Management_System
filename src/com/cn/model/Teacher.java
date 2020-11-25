package com.cn.model;

import com.cn.dao.TeacherDao;

public class Teacher extends Person{
	private String Title; //职称
	
	public Teacher(String ID, String Name, String Gender, String Birthday, String Faculty, String Title) {
		super(ID, Name, Gender, Birthday, Faculty);
		this.Title=Title;
	}
	
	public String getTitle() {
		return Title;
	}
	//获取职称
	protected void setTitle(String Title) {
		this.Title=Title;
	}
	//设置职称
	
	public static boolean ifTeacherExist(String ID) {
		return !TeacherDao.findTeacher(ID).isEmpty();
	}
	
	public void info()
    {
        String str = "ID:" + super.getID() + "\nName:" + super.getName() + "\nGender:" + super.getGender() + "\nBirthday:" + super.getBirthday()
                + "\nAcademy:" + super.getFaculty() + "\nRank:" + this.getTitle();
        System.out.println(str);
    }
}
