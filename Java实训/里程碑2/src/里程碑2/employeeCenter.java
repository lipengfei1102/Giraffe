package 里程碑2;

import java.io.*;
public class employeeCenter {
 
	public static void start() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		FileWriter writer=new FileWriter("employee.txt",true);
		empManage manage=new empManage();
		while(true) {
			System.out.println("雇员管理系统，请选择功能");
			System.out.println("1.添加雇员");
			System.out.println("2.查看雇员信息");
			System.out.println("3.查看所有雇员信息");
			System.out.println("4.修改雇员薪水");
			System.out.println("5.退出系统");
			
			String type=buf.readLine();
			int choice =Integer.parseInt(type);
			switch(choice) {
			case 1:
				System.out.println("请输入雇员编号:");
				String empNo=buf.readLine();
				writer.write(empNo);
				System.out.println("请输入雇员姓名：");
				String empName=buf.readLine();
				writer.write(empName);
				System.out.println("请输入雇员年龄：");
				String empAge=buf.readLine();
				int age=Integer.parseInt(empAge);
				writer.write(age);
				System.out.println("请输入雇员工作：");
				String empJob=buf.readLine();
				writer.write(empJob);
				System.out.println("请输入雇员薪水：");
				String empSal=buf.readLine();
				double sal=Double.parseDouble(empSal);
				writer.write((int) sal);
				Emp emp=new Emp(empNo,empName,age,empJob,sal);
				manage.add(emp);
				writer.write("\n");
				break;
			
			case 2:
				System.out.println("请输入要查找的员工编号：");
				String empNo2=buf.readLine();
				manage.find(empNo2);
				break;
			
			case 3:
				manage.showAll();
				break;
			
			case 4:
				System.out.println("请输入要修改薪水的员工编号：");
				String empNo3=buf.readLine();
				writer.write(empNo3);
				System.out.println("请输入修改后的薪水：");
				String empSal3=buf.readLine();
				double sal3=Double.parseDouble(empSal3);
				writer.write((int) sal3);
				manage.update(empNo3, sal3);
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


