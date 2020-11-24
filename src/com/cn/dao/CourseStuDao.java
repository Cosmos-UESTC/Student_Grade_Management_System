package com.cn.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.cn.model.CourseStu;


public class CourseStuDao {
	//从选课记录读取信息
			static String finalFileName = "-1";	
			public static ArrayList<CourseStu> readCourseStu(String finalCourseName){
				ArrayList<CourseStu> list = new ArrayList<>(); 
				finalFileName = "D:\\Eclipse-Workplace\\MNO_Grade_Management_System/src/data/" + finalCourseName + "_student.txt";
				try (BufferedReader br = new BufferedReader(new FileReader(finalFileName))) {
					String line = br.readLine();
					String[] textData = null;
					while (line != null) {
						textData = line.split(" ");
						String courseId = textData[0];
						String courseName = textData[1];
						String studentId = textData[2];
						String studentName = textData[3];
						CourseStu courseStu = new CourseStu(courseId, courseName, studentId, studentName);
						list.add(courseStu);
						line = br.readLine();
					}	
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}	
				return list;
			}
	//写信息到花名册
			public static int writeCourseStu(CourseStu coursestu, String finalCourseName) {
				ArrayList<CourseStu> list = readCourseStu(finalCourseName);
				list.add(coursestu);
				int num = 0;
				try {
					FileWriter fileWriter = new FileWriter(finalFileName);
					for (int i = 0; i < list.size(); i++) {
						CourseStu coustu = list.get(i);
						fileWriter.write(
								coustu.getCourseId() + " " + coustu.getCourseName() + " " + coustu.getCourseStuId() + " " + coustu.getCourseStuName() + "\r\n");
					}
					fileWriter.flush();
					fileWriter.close();
					num = 1;
				} catch (IOException e) {
					e.printStackTrace();
				}
				return num;
			}
	//删除花名册信息
			public static int delCourseStu(String CourseStuId, String finalCourseName) {
				ArrayList<CourseStu> list = readCourseStu(finalCourseName);
				int num = 0;
				for (int i = 0; i < list.size(); i++) {
					if (CourseStuId.equals(list.get(i).getCourseStuId())) {
						list.remove(i);
					}
				}
				try {
					FileWriter fileWriter = new FileWriter(finalFileName);
					for (int i = 0; i < list.size(); i++) {
						CourseStu coustu = list.get(i);
						fileWriter.write(
								coustu.getCourseId() + " " + coustu.getCourseName() + " " + coustu.getCourseStuId() + " " + coustu.getCourseStuName() + "\r\n");
					}
					fileWriter.flush();
					fileWriter.close();
					num = 1;
				} catch (IOException e) {
					e.printStackTrace();
				}
				return num;
			}
	//查询花名册信息
			public static ArrayList<CourseStu> findCourseStu(String CourseStuId, String finalCourseName) {
				ArrayList<CourseStu> list = readCourseStu(finalCourseName);
				ArrayList<CourseStu> newlist = new ArrayList<>();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getCourseStuId().equals(CourseStuId)){
						newlist.add(list.get(i));				
					}
				}	
				return newlist;		
			}
	}
