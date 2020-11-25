package com.cn.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.cn.dao.CourseDao;
import com.cn.dao.CourseStuDao;
import com.cn.dao.ScoreDao;
import com.cn.dao.StudentDao;
import com.cn.dao.TeacherDao;
import com.cn.model.Course;
import com.cn.model.CourseStu;
import com.cn.model.Score;
import com.cn.model.Student;
import com.cn.model.Teacher;
import com.cn.util.StringUtil;

import view.Main;


public class GUI {
			static String finalId = "-1";
			static String finalCourseId = "-1";
			
			//学生登录界面
			@SuppressWarnings("serial")
			public static class StuOperation extends JFrame {
				public StuOperation(String finalId) {
					super();
					this.setTitle("学生");
			        //创建容器
			        Container cont = getContentPane();
			        //关闭绝对布局 
			        this.setLayout(null);
			        //创建控件		        
			        JButton jb1 = new JButton("信息查询");JButton jb2 = new JButton("成绩查询");
			        JButton jb3 = new JButton("课程查询");JButton jb4 = new JButton("修改信息");
			        JButton jb5 = new JButton("退出登录");
			        //设置信息查询按钮功能
			        jb1.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
							ArrayList<Student> newlist = new ArrayList<>();
			    			newlist = StudentDao.findStudent(finalId);
			    			Student foundStudent = newlist.get(0);
			    			JOptionPane.showMessageDialog(null, "ID = "+foundStudent.getID()+"\n"+"Name = "+foundStudent.getName()+"\n"+"Gender = "+foundStudent.getGender()
			    					+"\n"+"Birthday = "+foundStudent.getBirthday()+"\n"+"Faculty = "+foundStudent.getFaculty()+"\n"+"Major = "+foundStudent.getMajor());
			            }
			        });
			        
			        //设置成绩查询按钮功能
			        jb2.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	System.out.println("成绩查询");
			            	new stuScoreCheck(finalId);
			            }
			        });
			        
			        //设置课程查询功能
			        jb3.addActionListener(new ActionListener() {
			        	@Override
			            public void actionPerformed(ActionEvent e) {
			            	System.out.println("课程查询");
			            	new stuCourseCheck(finalId);
			            }
			        });		        
			        //设置修改信息功能
					jb4.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
			            	System.out.println("修改信息");
			            	new StuEdit(finalId);
			            	dispose();
			            }
			        });
					//设置退出按钮功能
					jb5.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
			            	System.out.println("退出登录");
			            	new Main.Login();
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
				public StuEdit(String finalId) {
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
			        JPasswordField jpf1 = new JPasswordField();JPasswordField jpf2 = new JPasswordField();
			        jpf1.setEchoChar('*');jpf2.setEchoChar('*');
			        JRadioButton jr1 = new JRadioButton("男",true);JRadioButton jr2 = new JRadioButton("女");
			        ButtonGroup G=new ButtonGroup();
			        
			        //设置提交按钮功能
			        jb1.addActionListener(new ActionListener() {
						@SuppressWarnings("deprecation")
						@Override
			            public void actionPerformed(ActionEvent e) {
							//内容合法性校验
							if(jt1.getText().equals("")||jt2.getText().equals("")|| jt3.getText().equals("")||jt4.getText().equals("")||jpf1.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "请正确填写信息！");
								new StuEdit(finalId);
								dispose();
								return ;
							}
							//密码一致性校验
							if(!(jpf1.getText().equals(jpf2.getText()))) {							
								JOptionPane.showMessageDialog(null, "两次密码不匹配！！");					
								jpf2.setText("");							
								new StuEdit(finalId);
								dispose();
								return ;						
							}
							//日期格式合法性校验
							if(StringUtil.isNumeric(jt2.getText())) {
								JOptionPane.showMessageDialog(null, "日期格式非法！！");	
								JOptionPane.showMessageDialog(null, "格式参考：yyyy-MM-dd");	
								jpf2.setText("");							
								new StuEdit(finalId);
								dispose();
								return ;
							}
							//校验通过
							StudentDao.delStudent(finalId);
							String genderTemp = "Error";
							if(jr1.isSelected()) {genderTemp = "Male";} 
							else {genderTemp = "Female";}
							Student newStu = new Student(finalId, jt1.getText(), genderTemp, jt2.getText(), jt3.getText(), jt4.getText());
							StudentDao.writeStudent(newStu);
							JOptionPane.showMessageDialog(null, "修改成功！");
							new StuOperation(finalId);
			            	dispose();
			            }
			        });
			        
					//设置返回按钮功能
					jb2.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
			            	new StuOperation(finalId);
			            	dispose();
			            }
			        });
					
			        //将控件加入容器中		       
					cont.add(jl1);cont.add(jl2);cont.add(jl3);cont.add(jl4);
					cont.add(jl5);cont.add(jl6);cont.add(jb1);cont.add(jb2);
			        cont.add(jt1);cont.add(jt2);cont.add(jt3);cont.add(jt4);
			        cont.add(jpf1);cont.add(jpf2);cont.add(jr1);cont.add(jr2);		        
			        G.add(jr1);G.add(jr2);
			        
			        //控件在容器中的位置及大小
			        jl1.setBounds(50,50,75,40);jr1.setBounds(150,125,75,40);
			        jr2.setBounds(250,125,75,40);jl2.setBounds(50,200,75,40);
			        jl3.setBounds(50,275,75,40);jl4.setBounds(50,350,75,40);
			        jl5.setBounds(50,425,75,40);jl6.setBounds(50,500,75,40);
			        jt1.setBounds(150,50,300,40);jt2.setBounds(150,200,300,40);
			        jt3.setBounds(150,275,300,40);jt4.setBounds(150,350,300,40);
			        jpf1.setBounds(150,425,300,40);jpf2.setBounds(150,500,300,40);
			        jb1.setBounds(100,600,100,50);jb2.setBounds(300,600,100,50);
			        
			        //窗体在电脑中的位置及大小
			        this.setBounds(720, 150, 500, 750);
			        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			        //设置窗体不可以拉伸
			        this.setResizable(false);
			        this.setVisible(true);
			    }
			}
			
			//学生成绩查询页面
			@SuppressWarnings("serial")
			public static class stuScoreCheck extends JFrame {
				private JTable table;
			    private JPanel contentPane;
			    private DefaultTableModel defaultTableModel;
			    private int DEFAULE_HEIGH = 600;
			    private int DEFAULE_WIDTH = 1000;
			    Toolkit toolkit = Toolkit.getDefaultToolkit();	    
			    int Location_x = (int) (toolkit.getScreenSize().getWidth() - DEFAULE_WIDTH) / 2;
			    int Location_y = (int) (toolkit.getScreenSize().getHeight() - DEFAULE_HEIGH) / 2;
			    //自适应的屏幕缩放
			    
			    public stuScoreCheck(String finalId) {
			        contentPane = new JPanel();
			        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			        contentPane.setLayout(new BorderLayout());
			        
			        ArrayList<Score> newlist1 = new ArrayList<>();
			        newlist1 = ScoreDao.findScore("Java", finalId);
			        
			        ArrayList<Score> newlist2 = new ArrayList<>();
			        newlist2 = ScoreDao.findScore("C", finalId);
			        
			        String[] n1 = { newlist1.get(0).getcourseId(), newlist1.get(0).getcourseName(), newlist1.get(0).getcourseTeacherId(), newlist1.get(0).getcourseTeacherName(),
			        		newlist1.get(0).getstudentId(), newlist1.get(0).getstudentName(), newlist1.get(0).getstudentScore()};
			        String[] n2 = { newlist2.get(0).getcourseId(), newlist2.get(0).getcourseName(), newlist2.get(0).getcourseTeacherId(), newlist2.get(0).getcourseTeacherName(),
			        		newlist2.get(0).getstudentId(), newlist2.get(0).getstudentName(), newlist2.get(0).getstudentScore()};
			        Object[][] p = {n1, n2};
			        String[] n = { "课程代码", "课程名称", "教师ID", "教师姓名", "学号", "学生姓名","成绩"};

			        
			        defaultTableModel = new DefaultTableModel(p, n); // 用双数组创建DefaultTableModel对象
			        table = new JTable(defaultTableModel);// 创建表格组件
			        table.setRowHeight(30);// 设置表格行宽
			        		        
			        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);// 创建滚动条组件并初始化列表组件
			        contentPane.add(scrollPane, BorderLayout.CENTER);

			        setVisible(true);
			        setTitle("成绩查询");
			        setContentPane(contentPane);
			        setLocation(Location_x, Location_y);
			        setSize(DEFAULE_WIDTH, DEFAULE_HEIGH);
			        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//default = JFrame.EXIT_ON_CLOSE;
			    }
			}
			    
			//学生课程查询界面
			@SuppressWarnings("serial")
			public static class stuCourseCheck extends JFrame{
				private JPanel contentPane;
			    private DefaultTableModel defaultTableModel;
			    private JTable table;
			    Toolkit toolkit = Toolkit.getDefaultToolkit();
			    private int DEFAULE_WIDTH = 1000;
			    private int DEFAULE_HEIGH = 600;
			    int Location_x = (int) (toolkit.getScreenSize().getWidth() - DEFAULE_WIDTH) / 2;
			    int Location_y = (int) (toolkit.getScreenSize().getHeight() - DEFAULE_HEIGH) / 2;
			    //自适应的屏幕缩放
			    
			    public stuCourseCheck(String finalId) {

			        contentPane = new JPanel();
			        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			        contentPane.setLayout(new BorderLayout());
			        
			        ArrayList<CourseStu> list1 = new ArrayList<>();
			        list1 = CourseStuDao.findCourseStu(finalId,"java");
			        ArrayList<CourseStu> list2 = new ArrayList<>();
			        list2 = CourseStuDao.findCourseStu(finalId,"c");
			        String str1 = list1.get(0).getCourseId();
			        String str2 = list2.get(0).getCourseId();
			        
			        ArrayList<Course> newlist1 = new ArrayList<>();
			        newlist1 = CourseDao.findCourse(str1);
			        ArrayList<Course> newlist2 = new ArrayList<>();
			        newlist2 = CourseDao.findCourse(str2);
			        
//			        CourseStu.ifCourseStuExist("java", finalId);
			        String[] s = {"","","",""};
			        String[] n = { "课程代码", "课程名称", "学分", "学时", "任课教师"};
			        String[] n1 = { newlist1.get(0).getcourseId(), newlist1.get(0).getcourseName(), newlist1.get(0).getcourseCredit(), newlist1.get(0).getcourseHours(), newlist1.get(0).getcourseTeacherName()};
			        String[] n2 = { newlist2.get(0).getcourseId(), newlist2.get(0).getcourseName(), newlist2.get(0).getcourseCredit(), newlist1.get(0).getcourseHours(), newlist1.get(0).getcourseTeacherName()};
			        if(list1.isEmpty() && list2.isEmpty()) {
			        	Object[][] p = {s, s};
			        	defaultTableModel = new DefaultTableModel(p, n); // 用双数组创建DefaultTableModel对象
			        }
			        else if(!list1.isEmpty() && list2.isEmpty()) {
			        	Object[][] p = {n1, s};
			        	defaultTableModel = new DefaultTableModel(p, n); // 用双数组创建DefaultTableModel对象
			        }
			        else if(list1.isEmpty() && !list2.isEmpty()) {
			        	Object[][] p = {n2, s};
			        	defaultTableModel = new DefaultTableModel(p, n); 
			        }
			        else {
			        	Object[][] p = {n1, n2};
			        	defaultTableModel = new DefaultTableModel(p, n); 
			        }
			        
			        table = new JTable(defaultTableModel);// 创建表格组件
			        table.setRowHeight(30);// 设置表格行宽
			        
			        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);// 创建滚动条组件，默认滚动条始终出现，初始化列表组件
			        contentPane.add(scrollPane, BorderLayout.CENTER);

			        setVisible(true);
			        setTitle("课表查询");
			        setContentPane(contentPane);
			        setLocation(Location_x, Location_y);
			        setSize(DEFAULE_WIDTH, DEFAULE_HEIGH);
			        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//default = JFrame.EXIT_ON_CLOSE;
			    }
			}
			
			//教师登录界面
			@SuppressWarnings("serial")
			public static class TeaOperation extends JFrame {
				public TeaOperation(String finalId) {
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
							ArrayList<Teacher> newlist = new ArrayList<>();
					    	newlist = TeacherDao.findTeacher(finalId);
					    	Teacher foundTeacher = newlist.get(0);
					    	JOptionPane.showMessageDialog(null, "ID="+foundTeacher.getID()+"\n"+"Name="+foundTeacher.getName()+"\n"+"Gender="+foundTeacher.getGender()
					    				+"\n"+"Birthday="+foundTeacher.getBirthday()+"\n"+"Faculty="+foundTeacher.getFaculty()+"\n"+"Title="+foundTeacher.getTitle());
					    }
					});

			        //设置修改信息按钮功能
			        jb2.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	new TeaEdit(finalId);
			            	dispose();
			            }
			        });
			        //查看全部课程功能
			        jb3.addActionListener(new ActionListener() {
			        	@Override
			            public void actionPerformed(ActionEvent e) {
			            	System.out.println("全部课程");
			            	new teaCourseCheck(finalId);
			            }
			        });		        
			        //设置成绩登录功能
					jb4.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
			            	System.out.println("成绩登录");
			            	new teaScoreManage(finalId);
			            }
			        });
					//设置成绩统计钮功能
					jb5.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
			            	System.out.println("成绩统计");
			            	new teaScoreAnalysis(finalId); 
			            }
			        });
					//设置返回按钮功能
					jb6.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
			            	System.out.println("返回");
			            	new Main.Login();
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
			
			//教师信息修改界面
			@SuppressWarnings("serial")
			public static class TeaEdit extends JFrame {
				public TeaEdit(String finalId) {
					super();
					this.setTitle("信息修改");
			        //创建容器
			        Container cont = getContentPane();
			        //关闭绝对布局 
			        this.setLayout(null);
			        //创建控件
			        JLabel jl1 = new JLabel("姓名");JLabel jl2 = new JLabel("生日");
			        JLabel jl3 = new JLabel("专业");JLabel jl4 = new JLabel("职称");
			        JLabel jl5 = new JLabel("新密码");JLabel jl6 = new JLabel("确认密码");
			        JButton jb1 = new JButton("提交");JButton jb2 = new JButton("返回");
			        JTextField jt1 = new JTextField("",20);JTextField jt2 = new JTextField("",20);
			        JTextField jt3 = new JTextField("",20);JTextField jt4 = new JTextField("",20);
			        JPasswordField jpf1 = new JPasswordField();JPasswordField jpf2 = new JPasswordField();
			        jpf1.setEchoChar('*');jpf2.setEchoChar('*');
			        JRadioButton jr1 = new JRadioButton("男",true);JRadioButton jr2 = new JRadioButton("女");
			        ButtonGroup G=new ButtonGroup();
			        
			        //设置提交按钮功能
			        jb1.addActionListener(new ActionListener() {
						@SuppressWarnings("deprecation")
						@Override
			            public void actionPerformed(ActionEvent e) {
							//内容合法性校验
							if(jt1.getText().equals("")||jt2.getText().equals("")|| jt3.getText().equals("")||jt4.getText().equals("")||jpf1.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "请正确填写信息！");
								new TeaEdit(finalId);
								dispose();
								return ;
							}
							//密码一致性校验
							if(!(jpf1.getText().equals(jpf2.getText()))) {							
								JOptionPane.showMessageDialog(null, "两次密码不匹配！！");					
								jpf2.setText("");							
								new TeaEdit(finalId);
								dispose();
								return ;						
							}
							//日期格式合法性校验
							if(StringUtil.isNumeric(jt2.getText())) {
								JOptionPane.showMessageDialog(null, "日期格式非法！！");	
								JOptionPane.showMessageDialog(null, "格式参考：yyyy-MM-dd");	
								jpf2.setText("");							
								new TeaEdit(finalId);
								dispose();
								return ;
							}
							//校验通过
							TeacherDao.delTeacher(finalId);
							String genderTemp = "Error";
							if(jr1.isSelected()) {genderTemp = "Male";} 
							else {genderTemp = "Female";}
							Teacher newTea = new Teacher(finalId, jt1.getText(), genderTemp, jt2.getText(), jt3.getText(), jt4.getText());
							TeacherDao.writeTeacher(newTea);
							JOptionPane.showMessageDialog(null, "修改成功！");
							new TeaOperation(finalId);
			            	dispose();
			            }
			        });
			        
					//设置返回按钮功能
					jb2.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
			            	new TeaOperation(finalId);
			            	dispose();
			            }
			        });
					
			        //将控件加入容器中		       
					cont.add(jl1);cont.add(jl2);cont.add(jl3);cont.add(jl4);
					cont.add(jl5);cont.add(jl6);cont.add(jb1);cont.add(jb2);
			        cont.add(jt1);cont.add(jt2);cont.add(jt3);cont.add(jt4);
			        cont.add(jpf1);cont.add(jpf2);cont.add(jr1);cont.add(jr2);		        
			        G.add(jr1);G.add(jr2);
			        
			        //控件在容器中的位置及大小
			        jl1.setBounds(50,50,75,40);jr1.setBounds(150,125,75,40);
			        jr2.setBounds(250,125,75,40);jl2.setBounds(50,200,75,40);
			        jl3.setBounds(50,275,75,40);jl4.setBounds(50,350,75,40);
			        jl5.setBounds(50,425,75,40);jl6.setBounds(50,500,75,40);
			        jt1.setBounds(150,50,300,40);jt2.setBounds(150,200,300,40);
			        jt3.setBounds(150,275,300,40);jt4.setBounds(150,350,300,40);
			        jpf1.setBounds(150,425,300,40);jpf2.setBounds(150,500,300,40);
			        jb1.setBounds(100,600,100,50);jb2.setBounds(300,600,100,50);
			        
			        //窗体在电脑中的位置及大小
			        this.setBounds(720, 150, 500, 750);
			        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			        //设置窗体不可以拉伸
			        this.setResizable(false);
			        this.setVisible(true);
			    }
			}
			
			//教师课程查询界面
			@SuppressWarnings("serial")
			public static class teaCourseCheck extends JFrame{
				private JPanel contentPane;
			    private DefaultTableModel defaultTableModel;
			    private JTable table;
			    Toolkit toolkit = Toolkit.getDefaultToolkit();
			    private int DEFAULE_WIDTH = 1000;
			    private int DEFAULE_HEIGH = 600;
			    int Location_x = (int) (toolkit.getScreenSize().getWidth() - DEFAULE_WIDTH) / 2;
			    int Location_y = (int) (toolkit.getScreenSize().getHeight() - DEFAULE_HEIGH) / 2;
			    //自适应的屏幕缩放
			    
			    public teaCourseCheck(String finalId) {

			        contentPane = new JPanel();
			        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			        contentPane.setLayout(new BorderLayout());
			        
			        ArrayList<Course> list1 = new ArrayList<>();
			        list1 = CourseDao.findCourseTea(finalId);
//			        ArrayList<Course> list2 = new ArrayList<>();
//			        list2 = CourseDao.findCourseTea(finalId);
			        String str1 = list1.get(0).getcourseId();
//			        String str2 = list2.get(0).getcourseId();
			        
			        ArrayList<Course> newlist1 = new ArrayList<>();
			        newlist1 = CourseDao.findCourse(str1);
//			        ArrayList<Course> newlist2 = new ArrayList<>();
//			        newlist2 = CourseDao.findCourse(str2);
			        
			        String[] n1 = { newlist1.get(0).getcourseId(), newlist1.get(0).getcourseName(), newlist1.get(0).getcourseCredit(), newlist1.get(0).getcourseHours()};
//			        String[] n2 = { newlist2.get(0).getcourseId(), newlist2.get(0).getcourseName(), newlist2.get(0).getcourseCredit(), newlist1.get(0).getcourseHours()};
			        Object[][] p = {n1};
			        String[] n = { "课程代码", "课程名称", "学分", "学时"};

			        defaultTableModel = new DefaultTableModel(p, n); // 用双数组创建DefaultTableModel对象
			        table = new JTable(defaultTableModel);// 创建表格组件
			        table.setRowHeight(30);// 设置表格行宽
			        
			        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);// 创建滚动条组件，默认滚动条始终出现，初始化列表组件
			        contentPane.add(scrollPane, BorderLayout.CENTER);

			        setVisible(true);
			        setTitle("课表查询");
			        setContentPane(contentPane);
			        setLocation(Location_x, Location_y);
			        setSize(DEFAULE_WIDTH, DEFAULE_HEIGH);
			        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//default = JFrame.EXIT_ON_CLOSE;
			    }
			}
			
			//教师成绩登录界面
			@SuppressWarnings("serial")
			public static class teaScoreManage extends JFrame {
				public teaScoreManage(String finalId) {
					super();
					this.setTitle("成绩录入");
			        //创建容器
			        Container cont = getContentPane();
			        //关闭绝对布局 
			        this.setLayout(null);
			        //创建控件
			        JLabel jl1 = new JLabel("课程号");JLabel jl2 = new JLabel("学号");
			        JLabel jl3 = new JLabel("姓名");JLabel jl4 = new JLabel("成绩");
			        JButton jb1 = new JButton("提交");JButton jb2 = new JButton("退出");
			        JTextField jt1 = new JTextField("",20);JTextField jt2 = new JTextField("",20);
			        JTextField jt3 = new JTextField("",20);JTextField jt4 = new JTextField("",20);
			        
			        //设置提交按钮功能
			        jb1.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
							String courseName = CourseDao.findCourse(jt1.getText()).get(0).getcourseName();
							//内容合法性校验
							if(jt1.getText().equals("")||jt2.getText().equals("")|| jt3.getText().equals("")||jt4.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "请正确填写信息！");
								new teaScoreManage(finalId);
								dispose();
								return ;
							}
							//教师权限检验
							if(CourseDao.findCourseTea(finalId).isEmpty() || (!CourseDao.findCourseTea(finalId).get(0).getcourseId().equals(jt1.getText()))) {
								JOptionPane.showMessageDialog(null, "您无权限修改本课程！");
								new teaScoreManage(finalId);
								dispose();
								return ;
							}
							//学号存在性校验
							if(StudentDao.findStudent(jt2.getText()).isEmpty()) {
								JOptionPane.showMessageDialog(null, "学号不存在！");
								new teaScoreManage(finalId);
								dispose();
								return ;
							}
							//学号匹配性校验
							if(!StudentDao.findStudent(jt2.getText()).get(0).getName().equals(jt3.getText())) {
								JOptionPane.showMessageDialog(null, "学号与姓名不匹配！");
								new teaScoreManage(finalId);
								dispose();
								return ;
							}
							//学生是否选课校验
							if(CourseStuDao.findCourseStu(jt2.getText(), courseName).isEmpty()) {
								JOptionPane.showMessageDialog(null, "该生未选课！");
								new teaScoreManage(finalId);
								dispose();
								return ;
							}
							//校验通过
							
							if(CourseStuDao.findCourseStu(jt2.getText(), courseName).isEmpty()) {
								Score newStu = new Score(jt1.getText(), courseName, finalId, TeacherDao.findTeacher(finalId).get(0).getName(), 
														jt2.getText(), jt3.getText(), jt4.getText());
								ScoreDao.writeScore(newStu, courseName);
							}
							
							else {
								ScoreDao.delScore(jt2.getText(), courseName);
								Score newStu = new Score(jt1.getText(), courseName, finalId, TeacherDao.findTeacher(finalId).get(0).getName(), 
														jt2.getText(), jt3.getText(), jt4.getText());
								ScoreDao.writeScore(newStu, courseName);
							}
							JOptionPane.showMessageDialog(null, "修改成功！");
							new teaScoreManage(finalId);
			            	dispose();
			            }
			        });
			        
					//设置返回按钮功能
					jb2.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
			            	new TeaOperation(finalId);
			            	dispose();
			            }
			        });
					
			        //将控件加入容器中		       
					cont.add(jl1);cont.add(jl2);cont.add(jl3);cont.add(jl4);cont.add(jb1);
					cont.add(jb2);cont.add(jt1);cont.add(jt2);cont.add(jt3);cont.add(jt4);
			        
			        
			        //控件在容器中的位置及大小
			        jl1.setBounds(50,50,75,40);jl2.setBounds(50,125,75,40);
			        jl3.setBounds(50,200,75,40);jl4.setBounds(50,275,75,40);
			        jt1.setBounds(150,50,300,40);jt2.setBounds(150,125,300,40);
			        jt3.setBounds(150,200,300,40);jt4.setBounds(150,275,300,40);
			        jb1.setBounds(100,400,100,50);jb2.setBounds(300,400,100,50);
			        
			        //窗体在电脑中的位置及大小
			        this.setBounds(720, 150, 500, 500);
			        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			        //设置窗体不可以拉伸
			        this.setResizable(false);
			        this.setVisible(true);
			    }
			}
			
			//教师成绩分析界面
			@SuppressWarnings("serial")
			public static class teaScoreAnalysis extends JFrame {
				public teaScoreAnalysis(String finalId) {
					super();
					this.setTitle("成绩统计结果");
			        //创建容器
			        Container cont = getContentPane();
			        //关闭绝对布局 
			        this.setLayout(null);
			        //创建控件
			        JLabel jl1 = new JLabel("课程号");JLabel jl2 = new JLabel("优秀");
			        JLabel jl3 = new JLabel("良好");JLabel jl4 = new JLabel("及格");JLabel jl5 = new JLabel("不及格");
			        JButton jb1 = new JButton("统计");JButton jb2 = new JButton("退出");
			        JTextField jt1 = new JTextField("",20);JTextField jt2 = new JTextField("",20);
			        JTextField jt3 = new JTextField("",20);JTextField jt4 = new JTextField("",20);JTextField jt5 = new JTextField("",20);
			        
			        //设置提交按钮功能
			        jb1.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
							//课程存在性校验
					        if(CourseDao.findCourse(jt1.getText()).isEmpty()) {
								JOptionPane.showMessageDialog(null, "课程不存在！");
								new TeaOperation(finalId);
								dispose();
								return ;
							}
							String stuId;
							String str = CourseDao.findCourse(jt1.getText()).get(0).getcourseName();
							int best=0,better=0,good=0,normal=0;
							ArrayList<Score> foundScore = ScoreDao.readScore(str);
							for(int i = 0; i < foundScore.size(); i++) {
								stuId = ScoreDao.readScore(str).get(i).getstudentId();
								String score = ScoreDao.findScore(str, stuId).get(0).getstudentScore();
								int flag = Integer.parseInt(score);
								if(flag<=100 && flag >=85) {best+=1;}
								else if(flag<85 && flag >=75) {better+=1;}
								else if(flag<75 && flag >=60) {good+=1;}
								else if(flag<60 && flag >=0) {normal+=1;}
							}
							jt2.setText(Integer.toString(best));jt3.setText(Integer.toString(better));
							jt4.setText(Integer.toString(good));jt5.setText(Integer.toString(normal));
			            }
			        });
			        
					//设置返回按钮功能
					jb2.addActionListener(new ActionListener() {
						@Override
			            public void actionPerformed(ActionEvent e) {
			            	dispose();
			            }
			        });
					
			        //将控件加入容器中		       
					cont.add(jl1);cont.add(jl2);cont.add(jl3);cont.add(jl4);cont.add(jl5);cont.add(jb1);
					cont.add(jb2);cont.add(jt1);cont.add(jt2);cont.add(jt3);cont.add(jt4);cont.add(jt5);
			        		        
			        //控件在容器中的位置及大小
			        jl1.setBounds(50,50,75,40);jl2.setBounds(50,125,75,40);
			        jl3.setBounds(50,200,75,40);jl4.setBounds(50,275,75,40);jl5.setBounds(50,350,75,40);
			        jt1.setBounds(150,50,300,40);jt2.setBounds(150,125,300,40);
			        jt3.setBounds(150,200,300,40);jt4.setBounds(150,275,300,40);jt5.setBounds(150,350,300,40);
			        jb1.setBounds(100,450,100,50);jb2.setBounds(300,450,100,50);
			        
			        //窗体在电脑中的位置及大小
			        this.setBounds(720, 150, 550, 600);
			        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			        //设置窗体不可以拉伸
			        this.setResizable(false);
			        this.setVisible(true);
			    }
			}
//			//管理员登录界面
//			@SuppressWarnings("serial")
//			public static class AdmOperation extends JFrame {
//				public AdmOperation() {
//					super();
//					this.setTitle("管理员");
//			        //创建容器
//			        Container cont = getContentPane();
//			        //关闭绝对布局 
//			        this.setLayout(null);
//			        //创建控件		        
//			        JButton jb1 = new JButton("Text1");
//			        JButton jb2 = new JButton("Text2");
//			        JButton jb3 = new JButton("Text3");
//			        JButton jb4 = new JButton("Text4");
//			        JButton jb5 = new JButton("返回");
//			        //设置按钮功能
//			        jb1.addActionListener(new ActionListener() {
//			            
//						@Override
//			            public void actionPerformed(ActionEvent e) {
//							System.out.println("Text1");
//			            }
//			        });
//			        //设置按钮功能
//			        jb2.addActionListener(new ActionListener() {
//			            @Override
//			            public void actionPerformed(ActionEvent e) {
//			            	System.out.println("Text2");
//			            }
//			        });
//			        //设置按钮功能
//			        jb3.addActionListener(new ActionListener() {
//			        	@Override
//			            public void actionPerformed(ActionEvent e) {
//			            	System.out.println("Text3");
//			            }
//			        });		        
//			        //设置按钮功能
//					jb4.addActionListener(new ActionListener() {
//						@Override
//			            public void actionPerformed(ActionEvent e) {
//			            	System.out.println("Text4");
//			            }
//			        });
//					//设置按钮功能
//					jb5.addActionListener(new ActionListener() {
//						@Override
//			            public void actionPerformed(ActionEvent e) {
//			            	System.out.println("返回");
//			            	new Login();
//			            	dispose();
//			            }
//			        });
//					
//					
//			        //将控件加入容器中		       
//			        cont.add(jb1);
//			        cont.add(jb2);
//			        cont.add(jb3);
//			        cont.add(jb4);
//			        cont.add(jb5);	       
//			        //控件在容器中的位置及大小
//			        jb1.setBounds(100,50,300,100);
//			        jb2.setBounds(100,200,300,100);
//			        jb3.setBounds(100,350,300,100);
//			        jb4.setBounds(100,500,300,100);
//			        jb5.setBounds(100,650,300,100);
//			        //窗体在电脑中的位置及大小
//			        this.setBounds(720, 200, 500, 850);
//			        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//			        //设置窗体不可以拉伸
//			        this.setResizable(false);
//			        this.setVisible(true);
//			    }
//			}
}
