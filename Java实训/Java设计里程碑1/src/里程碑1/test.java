package 里程碑1;
import java.util.*;
public class test {
	public static int n=0;
	public static student[] stu=new student[10];
	public static Employee[] emp=new Employee[10];
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		boolean flag=false;
		int choose1;
		while(true) {
			System.out.println("学校信息管理程序");
			System.out.println("\t 1.学生信息管理");
			System.out.println("\t 2.工人信息管理");
			System.out.println("\t 3.退出系统");
			choose1=sc.nextInt();
			switch(choose1) {
				case 1:
					StuMenu.start();
					break;
				case 2:
					EmployeeMenu.start();
					break;
				case 3:
					flag=true;
					break;
			}
			if(flag) break;
		}
	}
}
