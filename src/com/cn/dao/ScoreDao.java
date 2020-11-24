package com.cn.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.cn.model.Score;

public class ScoreDao {
	//从文件读取分数信息
		static String finalFileName = "-1";	
		public static ArrayList<Score> readScore(String finalCourseName){
				ArrayList<Score> list = new ArrayList<>();  //新建链表
//				Scanner s = new Scanner(System.in);
				finalFileName = "D:\\Eclipse-Workplace\\MNO_Grade_Management_System/src/data/" + finalCourseName + ".txt";
				try (BufferedReader br = new BufferedReader(new FileReader(finalFileName))) {
					String line = br.readLine();
					String[] textData = null;
					while (line != null) {
						textData = line.split(" ");
						String courseId = textData[0];
						String courseName = textData[1];
						String courseTeacherId = textData[2];
						String courseTeacherName = textData[3];
						String studentId = textData[4];
						String studentName = textData[5];
						String studentScore = textData[6];
						Score score = new Score(courseId, courseName, courseTeacherId, courseTeacherName, studentId, studentName, studentScore);
						list.add(score);
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
			//写成绩信息到文件
			public static int writeScore(Score score, String finalCourseName) {
				ArrayList<Score> list = readScore(finalCourseName);
				finalFileName = "D:\\Eclipse-Workplace\\MNO_Grade_Management_System/src/data/" + finalCourseName + ".txt";
				list.add(score);
				int num = 0;
				try {
					FileWriter fileWriter = new FileWriter(finalFileName);
					for (int i = 0; i < list.size(); i++) {
						Score sco = list.get(i);
						fileWriter.write(
								sco.getcourseId() + " " + sco.getcourseName() + " " + sco.getcourseTeacherId() + " " + sco.getcourseTeacherName() + " " + 
								sco.getstudentId() + " " + sco.getstudentName() + " " + sco.getstudentScore() + "\r\n");
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
			//删除对应学生成绩
			public static int delScore(String studentId, String finalCourseName) {
				ArrayList<Score> list = readScore(finalCourseName);
				int num = 0;
				for (int i = 0; i < list.size(); i++) {
					if (studentId.equals(list.get(i).getstudentId())) {
						list.remove(i);
					}
				}
				try {
					FileWriter fileWriter = new FileWriter(finalFileName);
					for (int i = 0; i < list.size(); i++) {
						Score sco = list.get(i);
						fileWriter.write(
								sco.getcourseId() + " " + sco.getcourseName() + " " + sco.getcourseTeacherId() + " " + sco.getcourseTeacherName() + " " + 
								sco.getstudentId() + " " + sco.getstudentName() + " " + sco.getstudentScore() + "\r\n");
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
			//查询成绩信息
			public static ArrayList<Score> findScore(String courseName, String stuId) {
				ArrayList<Score> list = readScore(courseName);
				ArrayList<Score> newlist = new ArrayList<>();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getstudentId().equals(stuId)){
						newlist.add(list.get(i));				
					}
				}	
				return newlist;		
			}
}
