package com.cn.dao;

import java.io.*;
import java.util.*;
import com.cn.model.Course;

public class CourseDao {
	//从文件读取课程信息
			public static ArrayList<Course> readCourse(){
			ArrayList<Course> list = new ArrayList<>();  //新建链表
			try (BufferedReader br = new BufferedReader(new FileReader("D:\\Eclipse-Workplace\\MNO_Grade_Management_System/src/data/course.txt"))) {
				String line = br.readLine();
				String[] textData = null;
				while (line != null) {
					textData = line.split(" ");
					String courseId = textData[0];
					String courseName = textData[1];
					String courseCredit = textData[2];
					String courseHours = textData[3];
					String courseTeacherId = textData[4];
					String courseTeacherName = textData[5];
					Course course = new Course(courseId, courseName, courseCredit, courseHours, courseTeacherId, courseTeacherName);
					list.add(course);
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
		//写课程信息到文件
		public static int writeCourse(Course course) {
			ArrayList<Course> list = readCourse();
			list.add(course);
			int num = 0;
			try {
				FileWriter fileWriter = new FileWriter("D:\\Eclipse-Workplace\\MNO_Grade_Management_System/src/data/course.txt");
				for (int i = 0; i < list.size(); i++) {
					Course cou = list.get(i);
					fileWriter.write(
							cou.getcourseId() + " " + cou.getcourseName() + " " + cou.getcourseCredit() + " " + 
							cou.getcourseHours() + " " + cou.getcourseTeacherId() + " " + cou.getcourseTeacherName() + "\r\n");
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
		//删除对应学生信息
		public static int delCourse(String courseId) {
			ArrayList<Course> list = readCourse();
			int num = 0;
			for (int i = 0; i < list.size(); i++) {
				if (courseId.equals(list.get(i).getcourseId())) {
					list.remove(i);
				}
			}
			try {
				FileWriter fileWriter = new FileWriter("D:\\Eclipse-Workplace\\MNO_Grade_Management_System/src/data/course.txt");
				for (int i = 0; i < list.size(); i++) {
					Course cou = list.get(i);
					fileWriter.write(
							cou.getcourseId() + " " + cou.getcourseName() + " " + cou.getcourseCredit() + " " + 
							cou.getcourseHours() + " " + cou.getcourseTeacherId() + " " + cou.getcourseTeacherName() + "\r\n");
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
		//查询课程信息
		public static ArrayList<Course> findCourse(String courseId) {
			ArrayList<Course> list = readCourse();
			ArrayList<Course> newlist = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getcourseId().equals(courseId)){
					newlist.add(list.get(i));				
				}
			}	
			return newlist;		
		}
}
