package 里程碑2;
import java.io.IOException;
import java.util.*;
public class test {

	public static void main(String args[]) throws IOException {
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
				stuCenter.start();
				break;
			case 2:
				employeeCenter.start();
				break;
				case 3:
					flag=true;
					break;
			}
			if(flag) break;
		}
	}
}

