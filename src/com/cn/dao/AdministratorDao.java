package com.cn.dao;

import java.io.*;
import java.util.*;
import com.cn.model.Admin;

public class AdministratorDao {
		
	//从文件读取管理员信息
		public static ArrayList<Admin> readAdmin(){
			ArrayList<Admin> list = new ArrayList<>();  //新建链表
			try (BufferedReader br = new BufferedReader(new FileReader("src/data/administrator.txt"))) {
				String line = br.readLine();
				String[] textData = null;
				while (line != null) {
					textData = line.split(" ");
					String ID = textData[0];
					String Name = textData[1];
					String Gender = textData[2];
					String Birthday = textData[3];
					String Faculty = textData[4];
					String Type = textData[5];
					Admin admin = new Admin(ID, Name, Gender, Birthday, Faculty, Type);
					list.add(admin);
					line = br.readLine();
				}	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			return list;
		}

		//写管理员信息到文件
		public static int writeAdmin(Admin admin) {
			ArrayList<Admin> list = readAdmin();
			list.add(admin);
			int num = 0;
			try {
				FileWriter fileWriter = new FileWriter("src/data/administrator.txt");
				for (int i = 0; i < list.size(); i++) {
					Admin Admin = list.get(i);
					fileWriter.write(
							Admin.getID() + " " + Admin.getName() + " " + Admin.getGender() + " " + 
							Admin.getBirthday() + " " + Admin.getFaculty() + " " + Admin.getType() + "\r\n");
				}
				fileWriter.flush();
				fileWriter.close();
				num = 1;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return num;
		}

		//删除对应管理员信息
		public int delAdmin(String adminId) {
			ArrayList<Admin> list = readAdmin();
			int num = 0;
			for (int i = 0; i < list.size(); i++) {
				if (adminId.equals(list.get(i).getID())) {
					list.remove(i);
				}
			}
			try {
				FileWriter fileWriter = new FileWriter("src/data/administrator.txt");
				for (int i = 0; i < list.size(); i++) {
					Admin Admin = list.get(i);
					fileWriter.write(
							Admin.getID() + " " + Admin.getName() + " " + Admin.getGender() + " " + 
							Admin.getBirthday() + " " + Admin.getFaculty() + " " + Admin.getType() + "\r\n");
				}
				fileWriter.flush();
				fileWriter.close();
				num = 1;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return num;
		}

		//查询管理员信息
		public static ArrayList<Admin> findAdmin(String adminId) {
			ArrayList<Admin> list = readAdmin();
			ArrayList<Admin> newlist = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getID().equals(adminId)){
					newlist.add(list.get(i));
				}
			}	
			return newlist;
		}
	}
