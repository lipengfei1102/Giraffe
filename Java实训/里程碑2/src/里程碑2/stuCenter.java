package 里程碑2;

import java.io.*;
public class stuCenter {
 
	public static void start() throws IOException {
		// TODO Auto-generated method stub
		//FileReader reader=new FileReader("学生.txt");
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		
		//FileInputStream in=new FileInputStream("src.txt");
		//InputStreamReader isr=new InputStreamReader(in);
		//BufferedReader buf=new BufferedReader(isr);
		//FileOutputStream out=new fileOutputStream("des.txt")
		FileWriter writer=new FileWriter("student.txt",true);
		
		stuManage manage=new stuManage();
		while(true) {
			System.out.println("学生管理系统，请选择功能");
			System.out.println("1.添加学生");
			System.out.println("2.查找学生信息");
			System.out.println("3.查看所有学生信息");
			System.out.println("4.修改学生信息");
			System.out.println("5.退出系统");
			
			String type=buf.readLine();
			int choice =Integer.parseInt(type);
			switch(choice) {
			case 1:
				System.out.println("请输入学生编号:");
				String stuNo=buf.readLine();
				writer.write(stuNo);
				System.out.println("请输入学生姓名：");
				String stuName=buf.readLine();
				writer.write(stuName);
				System.out.println("请输入学生年龄：");
				String stuAge=buf.readLine();
				int age=Integer.parseInt(stuAge);
				writer.write(age);
				
				System.out.println("请输入学生成绩：");
				String stuGrade=buf.readLine();
				
				double grade=Double.parseDouble(stuGrade);
				writer.write(stuGrade);
				
				Stu stu=new Stu(stuNo,stuName,age,grade);
				manage.add(stu);
				
				writer.write("\n");
				
				break;
			
			case 2:
				System.out.println("请输入要查找的学生学号：");
				String stuNo2=buf.readLine();
				manage.find(stuNo2);
				break;
			
			case 3:
				manage.showAll();
				break;
			
			case 4:
				System.out.println("请输入要修改薪水的学生学号：");
				String stuNo3=buf.readLine();
				writer.write(stuNo3);
				System.out.println("请输入修改后的成绩：");
				String stuGrade3=buf.readLine();
				
				double grade3=Double.parseDouble(stuGrade3);
				writer.write(stuGrade3);
				manage.update(stuNo3, grade3);
				writer.write("\n");
				break;
				
			case 5:
				System.out.println("谢谢使用，再见！");
				System.exit(0);
				break;
			
			
			}
			writer.close();
			}
		}
		
	}
 



