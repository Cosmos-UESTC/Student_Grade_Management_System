package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import com.cn.dao.StudentDao;
import com.cn.dao.AdministratorDao;
import com.cn.dao.TeacherDao;
import com.cn.model.Admin;
import com.cn.model.Student;
import com.cn.model.Teacher;

@SuppressWarnings("unused")

public class Main{
		static String finalId = "-1";
		@SuppressWarnings("serial")
		public static class Login extends JFrame {
			public Login() {
				super();
				this.setTitle("账号管理");
		        //创建容器
		        Container cont = getContentPane();
		        //关闭绝对布局 
		        this.setLayout(null);
		        //创建控件
		        JLabel jl1 = new JLabel("ID号");
//		        JLabel jl2 = new JLabel("密码");
		        JTextField jt = new JTextField("",20);
//		        JPasswordField jpf = new JPasswordField();
//		        jpf.setEchoChar('*');
		        JButton jb1 = new JButton("登陆");
		        JButton jb2 = new JButton("重置");
		        //设置登陆按钮功能
		        jb1.addActionListener(new ActionListener() {
					@Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println(jt.getText());
//		            	System.out.println(jpf.getText());
		            	
		            	finalId = jt.getText();
		            	int flag = 999;
		            	System.out.println(!StudentDao.findStudent(finalId).isEmpty());
		            	if(!StudentDao.findStudent(finalId).isEmpty()) {
//		            		ArrayList<Student> newlist = new ArrayList<>();
//			    			newlist = StudentDao.findStudent(finalId);
//			    			Student foundStudent = newlist.get(0);
//			    			System.out.println("Name="+foundStudent.getName()+" "+"ID="+foundStudent.getID());
			    			flag = 0;
			    			
		            	}
		            	
		            	else if(!TeacherDao.findTeacher(finalId).isEmpty()) {
//		            		ArrayList<Teacher> newlist1 = new ArrayList<>();
//			    			newlist1 = TeacherDao.findTeacher(finalId);
//			    			Teacher foundTeacher = newlist1.get(0);
//			    			System.out.println("Name="+foundTeacher.getName()+" "+"ID="+foundTeacher.getID());
			    			flag = 1;
			    			
		            	}
		            	else {flag = -1;}
		    			
//		    			ArrayList<Admin> newlist2 = new ArrayList<>();
//		    			newlist2 = AdministratorDao.findAdmin(finalId);
//		    			Admin foundAdmin = newlist2.get(0);
//		    			System.out.println("Name="+foundAdmin.getName()+" "+"ID="+foundAdmin.getID());
		    			
		            	jt.setText("");//此处原则上应改写为加密后的ID号
//		                jpf.setText("");	//次数可以为“*******”	 
		            	     
		                    
		                    switch(flag) {
		                    	case 0:
		                    		System.out.println("xs登陆成功！");
				                    JOptionPane.showMessageDialog(null, "登录成功！");
		                    		new StuOperation();dispose();
		                    		break;
		                    	case 1:
		                    		System.out.println("js登陆成功！");
				                    JOptionPane.showMessageDialog(null, "登录成功！");
		                    		new TeaOperation();dispose();
		                    		break;
		                    	case 2:
		                    		System.out.println("gly登陆成功！");
				                    JOptionPane.showMessageDialog(null, "登录成功！");
//		                    		new AdmOperation();dispose();
		                    		break;
		                    	default :
		                    		System.out.println("登录失败！");
				                    JOptionPane.showMessageDialog(null, "登录失败！");
				                    JOptionPane.showMessageDialog(null, "请输入正确的ID！");
				                    jt.requestFocus();
		                    }
        
		            }
		        });
		        
		        //设置重置按钮功能
		        jb2.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                jt.setText("");
//		                jpf.setText("");
		                //重新设置焦点
		                jt.requestFocus();
		            }
		        });    
		        //将控件加入容器中
		        cont.add(jl1);
//		        cont.add(jl2);
		        cont.add(jt);
//		        cont.add(jpf);
		        cont.add(jb1);
		        cont.add(jb2);
		       
		        //控件在容器中的位置及大小
		        jl1.setBounds(40, 20, 50, 20);
//		        jl2.setBounds(40, 50, 50, 20);
		        jt.setBounds(90,20,200,20);
//		        jpf.setBounds(90,50,200,20);
		        jb1.setBounds(110,90,60,20);
		        jb2.setBounds(180,90,60,20);
		        //窗体在电脑中的位置及大小
		        this.setBounds(780, 350, 360, 160);
		        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		        //设置窗体不可以拉伸
		        this.setResizable(false);
		        this.setVisible(true);
		    }
		} 
		
		
		//学生登录界面
		@SuppressWarnings("serial")
		public static class StuOperation extends JFrame {
			public StuOperation() {
				super();
				this.setTitle("学生");
		        //创建容器
		        Container cont = getContentPane();
		        //关闭绝对布局 
		        this.setLayout(null);
		        //创建控件		        
		        JButton jb1 = new JButton("信息查询");JButton jb2 = new JButton("成绩查询");
		        JButton jb3 = new JButton("课程查询");JButton jb4 = new JButton("修改信息");
		        JButton jb5 = new JButton("返回");
		        //设置信息查询按钮功能
		        jb1.addActionListener(new ActionListener() {
		            
					@Override
		            public void actionPerformed(ActionEvent e) {
						System.out.println("信息查询结果如下");
						ArrayList<Student> newlist = new ArrayList<>();
		    			newlist = StudentDao.findStudent(finalId);
		    			Student foundStudent = newlist.get(0);
		    			
		    			System.out.println("ID="+foundStudent.getID()+" "+"Name="+foundStudent.getName()+" "+"Gender="+foundStudent.getGender()+" "+
		    			"Birthday="+foundStudent.getBirthday()+" "+"Faculty="+foundStudent.getFaculty()+" "+"Major="+foundStudent.getMajor());
		    			
		    			JOptionPane.showMessageDialog(null, "ID="+foundStudent.getID()+" "+"Name="+foundStudent.getName()+"\n"+"Gender="+foundStudent.getGender()+" "+
				    			"Birthday="+foundStudent.getBirthday()+"\n"+"Faculty="+foundStudent.getFaculty()+" "+"Major="+foundStudent.getMajor());
		            }
		        });
		        //设置成绩查询按钮功能
		        jb2.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println("成绩查询");
		            }
		        });
		        //设置课程查询功能
		        jb3.addActionListener(new ActionListener() {
		        	@Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println("课程查询");
		            }
		        });		        
		        //设置修改信息功能
				jb4.addActionListener(new ActionListener() {
					@Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println("修改信息");
		            	new StuEdit();
		            	dispose();
		            }
		        });
				//设置返回按钮功能
				jb5.addActionListener(new ActionListener() {
					@Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println("返回");
		            	new Login();
		            	dispose();
		            }
		        });
				
				
		        //将控件加入容器中		       
		        cont.add(jb1);cont.add(jb2);
		        cont.add(jb3);cont.add(jb4);
		        cont.add(jb5);	       
		        //控件在容器中的位置及大小		        
		        jb1.setBounds(100,50,300,100);jb2.setBounds(100,200,300,100);
		        jb3.setBounds(100,350,300,100);jb4.setBounds(100,500,300,100);
		        jb5.setBounds(100,650,300,100);
		        //窗体在电脑中的位置及大小
		        this.setBounds(720, 200, 500, 850);
		        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		        //设置窗体不可以拉伸
		        this.setResizable(false);
		        this.setVisible(true);
		    }
		}
		
		//学生信息修改页面
		@SuppressWarnings("serial")
		public static class StuEdit extends JFrame {
			public StuEdit() {
				super();
				this.setTitle("信息修改");
		        //创建容器
		        Container cont = getContentPane();
		        //关闭绝对布局 
		        this.setLayout(null);
		        //创建控件
		        JLabel jl1 = new JLabel("姓名");JLabel jl2 = new JLabel("生日");
		        JLabel jl3 = new JLabel("学院");JLabel jl4 = new JLabel("专业");
		        JLabel jl5 = new JLabel("新密码");JLabel jl6 = new JLabel("确认密码");
		        JButton jb1 = new JButton("提交");JButton jb2 = new JButton("返回");
		        JTextField jt1 = new JTextField("",20);JTextField jt2 = new JTextField("",20);
		        JTextField jt3 = new JTextField("",20);JTextField jt4 = new JTextField("",20);
		        JTextField jt5 = new JTextField("",20);JTextField jt6 = new JTextField("",20);
		        JRadioButton jr1 = new JRadioButton("男",true);JRadioButton jr2 = new JRadioButton("女");
		        ButtonGroup G=new ButtonGroup();
		        //设置提交按钮功能
		        jb1.addActionListener(new ActionListener() {
   
					@Override
		            public void actionPerformed(ActionEvent e) {
						System.out.println("提交成功");
						
						
						System.out.println(jt1.getText());System.out.println(jt2.getText());
						System.out.println(jt3.getText());System.out.println(jt4.getText());
						System.out.println(jt5.getText());System.out.println(jt6.getText());
						System.out.println("Male="+jr1.isSelected());System.out.println("Female="+jr2.isSelected());
						JOptionPane.showMessageDialog(null, "提交成功！");
						new StuOperation();
		            	dispose();
		            }
		        });
				//设置返回按钮功能
				jb2.addActionListener(new ActionListener() {
					@Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println("返回");
		            	new StuOperation();
		            	dispose();
		            }
		        });
		        //将控件加入容器中		       
				cont.add(jl1);cont.add(jl2);cont.add(jl3);cont.add(jl4);
				cont.add(jl5);cont.add(jl6);cont.add(jb1);cont.add(jb2);
		        cont.add(jt1);cont.add(jt2);cont.add(jt3);cont.add(jt4);
		        cont.add(jt5);cont.add(jt6);cont.add(jr1);cont.add(jr2);		        
		        G.add(jr1);G.add(jr2);
		        //控件在容器中的位置及大小
		        jl1.setBounds(50,50,75,40);jr1.setBounds(150,125,75,40);
		        jr2.setBounds(250,125,75,40);jl2.setBounds(50,200,75,40);
		        jl3.setBounds(50,275,75,40);jl4.setBounds(50,350,75,40);
		        jl5.setBounds(50,425,75,40);jl6.setBounds(50,500,75,40);
		        jt1.setBounds(150,50,300,40);jt2.setBounds(150,200,300,40);
		        jt3.setBounds(150,275,300,40);jt4.setBounds(150,350,300,40);
		        jt5.setBounds(150,425,300,40);jt6.setBounds(150,500,300,40);
		        jb1.setBounds(100,600,100,50);jb2.setBounds(300,600,100,50);
		        //窗体在电脑中的位置及大小
		        this.setBounds(720, 150, 500, 750);
		        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		        //设置窗体不可以拉伸
		        this.setResizable(false);
		        this.setVisible(true);
		    }
		}
		
		
		//教师登录界面
		@SuppressWarnings("serial")
		public static class TeaOperation extends JFrame {
			public TeaOperation() {
				super();
				this.setTitle("教师");
		        //创建容器
		        Container cont = getContentPane();
		        //关闭绝对布局 
		        this.setLayout(null);
		        //创建控件		        
		        JButton jb1 = new JButton("信息查询");JButton jb2 = new JButton("修改信息");
		        JButton jb3 = new JButton("全部课程");JButton jb4 = new JButton("成绩登录");
		        JButton jb5 = new JButton("成绩统计");JButton jb6 = new JButton("返回");
		        //设置信息查询按钮功能
		        jb1.addActionListener(new ActionListener() {
		            
					@Override
		            public void actionPerformed(ActionEvent e) {
						System.out.println("信息查询");
		            }
		        });
		        //设置修改信息按钮功能
		        jb2.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println("修改信息");
		            }
		        });
		        //设置全部课程功能
		        jb3.addActionListener(new ActionListener() {
		        	@Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println("全部课程");
		            }
		        });		        
		        //设置成绩登录功能
				jb4.addActionListener(new ActionListener() {
					@Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println("成绩登录");
		            }
		        });
				//设置成绩统计钮功能
				jb5.addActionListener(new ActionListener() {
					@Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println("成绩统计");
		            }
		        });
				//设置返回按钮功能
				jb6.addActionListener(new ActionListener() {
					@Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println("返回");
		            	new Login();
		            	dispose();
		            }
		        });
				
				
		        //将控件加入容器中		       
		        cont.add(jb1);cont.add(jb2);
		        cont.add(jb3);cont.add(jb4);
		        cont.add(jb5);cont.add(jb6);
		        //控件在容器中的位置及大小
		        
		        jb1.setBounds(100,50,300,75);jb2.setBounds(100,150,300,75);
		        jb3.setBounds(100,250,300,75);jb4.setBounds(100,350,300,75);
		        jb5.setBounds(100,450,300,75);jb6.setBounds(100,550,300,75);
		        //窗体在电脑中的位置及大小
		        this.setBounds(720, 200, 500, 750);
		        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		        //设置窗体不可以拉伸
		        this.setResizable(false);
		        this.setVisible(true);
		    }
		}
		
		
//		//管理员登录界面
//		@SuppressWarnings("serial")
//		public static class AdmOperation extends JFrame {
//			public AdmOperation() {
//				super();
//				this.setTitle("管理员");
//		        //创建容器
//		        Container cont = getContentPane();
//		        //关闭绝对布局 
//		        this.setLayout(null);
//		        //创建控件		        
//		        JButton jb1 = new JButton("Text1");
//		        JButton jb2 = new JButton("Text2");
//		        JButton jb3 = new JButton("Text3");
//		        JButton jb4 = new JButton("Text4");
//		        JButton jb5 = new JButton("返回");
//		        //设置按钮功能
//		        jb1.addActionListener(new ActionListener() {
//		            
//					@Override
//		            public void actionPerformed(ActionEvent e) {
//						System.out.println("Text1");
//		            }
//		        });
//		        //设置按钮功能
//		        jb2.addActionListener(new ActionListener() {
//		            @Override
//		            public void actionPerformed(ActionEvent e) {
//		            	System.out.println("Text2");
//		            }
//		        });
//		        //设置按钮功能
//		        jb3.addActionListener(new ActionListener() {
//		        	@Override
//		            public void actionPerformed(ActionEvent e) {
//		            	System.out.println("Text3");
//		            }
//		        });		        
//		        //设置按钮功能
//				jb4.addActionListener(new ActionListener() {
//					@Override
//		            public void actionPerformed(ActionEvent e) {
//		            	System.out.println("Text4");
//		            }
//		        });
//				//设置按钮功能
//				jb5.addActionListener(new ActionListener() {
//					@Override
//		            public void actionPerformed(ActionEvent e) {
//		            	System.out.println("返回");
//		            	new Login();
//		            	dispose();
//		            }
//		        });
//				
//				
//		        //将控件加入容器中		       
//		        cont.add(jb1);
//		        cont.add(jb2);
//		        cont.add(jb3);
//		        cont.add(jb4);
//		        cont.add(jb5);	       
//		        //控件在容器中的位置及大小
//		        jb1.setBounds(100,50,300,100);
//		        jb2.setBounds(100,200,300,100);
//		        jb3.setBounds(100,350,300,100);
//		        jb4.setBounds(100,500,300,100);
//		        jb5.setBounds(100,650,300,100);
//		        //窗体在电脑中的位置及大小
//		        this.setBounds(720, 200, 500, 850);
//		        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		        //设置窗体不可以拉伸
//		        this.setResizable(false);
//		        this.setVisible(true);
//		    }
//		}
		
		public static void main(String[] args){
		 	new Login();
			
//			Admin HeadMaster = new Admin("000000001", "ZengYong", "Male", "19630101", "Management", "headMaster");
//			Teacher LaoBai = new Teacher("100000001", "BaiZhongjian", "Male", "19800101", "Software_engineering", "lecturer");
//			Teacher FuChong = new Teacher("100000002", "FuChong", "Male", "19800101", "Computer_science", "professor");
//			Student testStudent = new Student("2019091601001", "Unknown", "Male", "20000101", "Software_engineering", "Network_security");
//			Student LvGe = new Student("2019091602004", "CaiSiyuan", "Male", "20010202", "Software_engineering", "Network_security");
//			Student XuanXuanxuan = new Student("2019091602005", "PengXuanyue", "Male", "20000303", "Software_engineering", "Embedded_system");
//			Student YueXinfeng = new Student("2019091602014", "FengXinyue", "Male", "20010404", "Software_engineering", "Network_security");
//			Student HuangLao = new Student("2019091602025", "HuangZizhan", "Male", "20010505", "Software_engineering", "Digital_animation");
//			Student LinShudan = new Student("2019091602027", "LinShudan", "Female", "20010606", "Software_engineering", "System_and_technology");
//			Student XiuEr = new Student("2019091602009", "ShiMaoyuam", "Male", "20060707", "Software_engineering", "Digital_information_processing");
//			Student JiaCheng = new Student("2019458802347", "YuanJiacheng", "Male", "20010808", "Communication_engineering", "Telecommunication");
//			Student LanXin = new Student("2019271020123", "FuLanxin", "Female", "20010909", "Glasgow_Academy", "Communication_engineering");
//			Student Cosmos = new Student("2019451610028", "Cosmos_Von", "Male", "20011010", "Foreign_languages_College", "English");
//
//			AdministratorDao.writeAdmin(HeadMaster);
//			TeacherDao.writeTeacher(LaoBai);
//			TeacherDao.writeTeacher(FuChong);
//			StudentDao.writeStudent(testStudent);
//			StudentDao.writeStudent(LvGe);
//			StudentDao.writeStudent(XuanXuanxuan);
//			StudentDao.writeStudent(YueXinfeng);
//			StudentDao.writeStudent(HuangLao);
//			StudentDao.writeStudent(LinShudan);
//			StudentDao.writeStudent(XiuEr);
//			StudentDao.writeStudent(JiaCheng);
//			StudentDao.writeStudent(LanXin);
//			StudentDao.writeStudent(Cosmos);
			
			
//			String str = "2019271020123";
//			ArrayList<Student> newlist = new ArrayList<>();
//			newlist = StudentDao.findStudent(str);
//			Student foundStudent = newlist.get(0);
//			System.out.println("Name="+foundStudent.getName()+" "+"ID="+foundStudent.getID());
			
	    }
}

