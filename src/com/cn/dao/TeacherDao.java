package com.cn.dao;

import java.io.*;
import java.util.*;
import com.cn.model.Teacher;

public class TeacherDao {
	//从文件读取教师信息
	public static ArrayList<Teacher> readTeacher(){
		ArrayList<Teacher> list = new ArrayList<>();  //新建链表
		try (BufferedReader br = new BufferedReader(new FileReader("D:\\Eclipse-Workplace\\MNO_Grade_Management_System/src/data/teacher.txt"))) {
			String line = br.readLine();
			String[] textData = null;
			while (line != null) {
				textData = line.split(" ");
				String ID = textData[0];
				String Name = textData[1];
				String Gender = textData[2];
				String Birthday = textData[3];
				String Faculty = textData[4];
				String Title = textData[5];
				Teacher teacher = new Teacher(ID, Name, Gender, Birthday, Faculty, Title);
				list.add(teacher);
				line = br.readLine();
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return list;
	}
//******************************************************//
	//写教师信息到文件
	public static int writeTeacher(Teacher teacher) {
		ArrayList<Teacher> list = readTeacher();
		list.add(teacher);
		int num = 0;
		try {
			FileWriter fileWriter = new FileWriter("D:\\Eclipse-Workplace\\MNO_Grade_Management_System/src/data/teacher.txt");
			for (int i = 0; i < list.size(); i++) {
				Teacher stu = list.get(i);
				fileWriter.write(
						stu.getID() + " " + stu.getName() + " " + stu.getGender() + " " + 
						stu.getBirthday() + " " + stu.getFaculty() + " " + stu.getTitle() + "\r\n");
			}
			fileWriter.flush();
			fileWriter.close();
			num = 1;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num;
	}
//******************************************************//
	//删除对应教师信息
	public int delTeacher(String name) {
		ArrayList<Teacher> list = readTeacher();
		int num = 0;
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getName())) {
				list.remove(i);
			}
		}
		try {
			FileWriter fileWriter = new FileWriter("D:\\Eclipse-Workplace\\MNO_Grade_Management_System/src/data/teacher.txt");
			for (int i = 0; i < list.size(); i++) {
				Teacher stu = list.get(i);
				fileWriter.write(
						stu.getID() + " " + stu.getName() + " " + stu.getGender() + " " + 
						stu.getBirthday() + " " + stu.getFaculty() + " " + stu.getTitle() + "\r\n");
			}
			fileWriter.flush();
			fileWriter.close();
			num = 1;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num;
	}
//******************************************************//
	//查询教师信息
	public static ArrayList<Teacher> findTeacher(String name) {
		ArrayList<Teacher> list = readTeacher();
		ArrayList<Teacher> newlist = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().contains(name)){
				newlist.add(list.get(i));
			}
		}	
		return newlist;
	}
}