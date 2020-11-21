package com.cn.model;

public class Admin extends Person{
	private String Type; //职位
	public Admin(String ID, String Name, String Gender, String Birthday, String Faculty, String Type) {
		super(ID, Name, Gender, Birthday, Faculty);
		this.Type=Type;
	}
	
	public String getType() {
		return Type;
	}
	//获取职位
	protected void setType(String Type) {
		this.Type=Type;
	}
	//设置职位
	
	public void info()
    {
        String str = "ID:" + super.getID() + "\nName:" + super.getName() + "\nGender:" + super.getGender() + "\nBirthday:" + 
        			 super.getBirthday()+ "\nFaculty:" + super.getFaculty() + "\nType:" + this.getType();
        System.out.println(str);
    }
}
