package com.cn.dao;

import java.io.*;
import java.util.*;
import com.cn.model.Student;

public class StudentDao {
	
		//从文件读取学生信息
		public static ArrayList<Student> readStudent(){
			ArrayList<Student> list = new ArrayList<>();
			try (BufferedReader br = new BufferedReader(new FileReader("src/data/student.txt"))) {
				String line = br.readLine();
				String[] textData = null;
				while (line != null) {
					textData = line.split(" ");
					String ID = textData[0];
					String Name = textData[1];
					String Gender = textData[2];
					String Birthday = textData[3];
					String Faculty = textData[4];
					String Major = textData[5];
					Student student = new Student(ID, Name, Gender, Birthday, Faculty, Major);
					list.add(student);
					line = br.readLine();
				}	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			return list;
		}

		//写学生信息到文件
		public static int writeStudent(Student student) {
			ArrayList<Student> list = readStudent();
			list.add(student);
			if(Student.ifStudentExist(student.getID())) {
				System.out.println("学生已经存在！\n");
				return 0;
			}
			int num = 0;
			try {
				FileWriter fileWriter = new FileWriter("src/data/student.txt");
				for (int i = 0; i < list.size(); i++) {
					Student stu = list.get(i);
					fileWriter.write(
							stu.getID() + " " + stu.getName() + " " + stu.getGender() + " " + 
							stu.getBirthday() + " " + stu.getFaculty() + " " + stu.getMajor() + "\r\n");
				}
				fileWriter.flush();
				fileWriter.close();
				num = 1;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return num;
		}

		//删除对应学生信息
		public static int delStudent(String ID) {
			ArrayList<Student> list = readStudent();
			int num = 0;
			for (int i = 0; i < list.size(); i++) {
				if (ID.equals(list.get(i).getID())) {
					list.remove(i);
				}
			}
			try {
				FileWriter fileWriter = new FileWriter("src/data/student.txt");
				for (int i = 0; i < list.size(); i++) {
					Student stu = list.get(i);
					fileWriter.write(
							stu.getID() + " " + stu.getName() + " " + stu.getGender() + " " + 
							stu.getBirthday() + " " + stu.getFaculty() + " " + stu.getMajor() + "\r\n");
				}
				fileWriter.flush();
				fileWriter.close();
				num = 1;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return num;
		}

		//查询学生信息
		public static ArrayList<Student> findStudent(String ID) {
			ArrayList<Student> list = readStudent();
			ArrayList<Student> newlist = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getID().equals(ID)){
					newlist.add(list.get(i));				
				}
			}	
			return newlist;		
		}
}
