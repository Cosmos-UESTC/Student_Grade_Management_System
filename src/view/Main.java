package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main{
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
		            
					@SuppressWarnings("deprecation")
					@Override
		            public void actionPerformed(ActionEvent e) {
		            	System.out.println(jt.getText());
//		            	System.out.println(jpf.getText());
		            	
		            	jt.setText("");//此处原则上应改写为加密后的ID号
//		                jpf.setText("");	//次数可以为“*******”	 
		                if(jt.getText().equals("123")){
		                    System.out.println("登陆成功！");
		                    JOptionPane.showMessageDialog(null, "登录成功！");
		                }
		                //why it don't work?		     
		                else {
		                    System.out.println("登录失败！");
		                    JOptionPane.showMessageDialog(null, "登录失败！");
		                    int flag = 1;
		                    switch(flag) {
		                    	case 0:
		                    		new StuOperation();dispose();
		                    		break;
		                    	case 1:
		                    		new TeaOperation();dispose();
		                    		break;
		                    	case 2:
		                    		new AdmOperation();dispose();
		                    		break;
		                    }
		                }
		            //姑且先把测试放在这里
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
		        JButton jb1 = new JButton("信息查询");
		        JButton jb2 = new JButton("成绩查询");
		        JButton jb3 = new JButton("课程查询");
		        JButton jb4 = new JButton("修改信息");
		        JButton jb5 = new JButton("返回");
		        //设置信息查询按钮功能
		        jb1.addActionListener(new ActionListener() {
		            
					@Override
		            public void actionPerformed(ActionEvent e) {
						System.out.println("信息查询");
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
		        cont.add(jb1);
		        cont.add(jb2);
		        cont.add(jb3);
		        cont.add(jb4);
		        cont.add(jb5);	       
		        //控件在容器中的位置及大小
		        
		        jb1.setBounds(100,50,300,100);
		        jb2.setBounds(100,200,300,100);
		        jb3.setBounds(100,350,300,100);
		        jb4.setBounds(100,500,300,100);
		        jb5.setBounds(100,650,300,100);
		        //窗体在电脑中的位置及大小
		        this.setBounds(720, 200, 500, 850);
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
		        JButton jb1 = new JButton("信息查询");
		        JButton jb2 = new JButton("修改信息");
		        JButton jb3 = new JButton("全部课程");
		        JButton jb4 = new JButton("成绩登录");
		        JButton jb5 = new JButton("成绩统计");
		        JButton jb6 = new JButton("返回");
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
		        cont.add(jb1);
		        cont.add(jb2);
		        cont.add(jb3);
		        cont.add(jb4);
		        cont.add(jb5);
		        cont.add(jb6);
		        //控件在容器中的位置及大小
		        
		        jb1.setBounds(100,50,300,75);
		        jb2.setBounds(100,150,300,75);
		        jb3.setBounds(100,250,300,75);
		        jb4.setBounds(100,350,300,75);
		        jb5.setBounds(100,450,300,75);
		        jb6.setBounds(100,550,300,75);
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
	    }
}

