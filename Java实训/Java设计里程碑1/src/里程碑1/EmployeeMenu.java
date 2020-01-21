package 里程碑1;
import java.util.*;
public class EmployeeMenu{
	static void start() {
		Scanner sc=new Scanner(System.in);
		int cc, age, ID, num;
		boolean f=false;
		float salary;
		String job, name;
		while(true){
			System.out.println("工人信息管理");
			System.out.println("\t 1.增加工人信息");
			System.out.println("\t 2.列出全部工人信息");
			System.out.println("\t 3.查询工人信息");
			System.out.println("\t 4.删除工人信息");
			System.out.println("\t 5.修改工人信息");
			System.out.println("\t 6.返回上一级菜单");
			cc=sc.nextInt();
			switch(cc) {
			case 1:
				System.out.print("工人姓名：");
				name=sc.next();
				System.out.print("工人年龄：");
				age=sc.nextInt();
				System.out.print("工人工号：");
				ID=sc.nextInt();
				System.out.print("工人工作：");
				job=sc.nextLine();
				System.out.print("工人工资：");
				salary=sc.nextFloat();
				test.n++;
				test.emp[test.n]=new Employee(name, age, ID, job, salary);
				break;
			case 2:
				for(int i=1; i<=test.n; i++) {
					test.emp[i].print();
				}
				break;
			case 3:
				System.out.println("请输入要查询的工人ID");
				num=sc.nextInt();
				for(int i=1; i<=test.n; i++) {
					if(test.emp[i].search(num)) {
						test.emp[i].print();
						break;
					}
				}
				break;
			case 4:
				boolean flag=false;
				System.out.println("请输入要删除ID");
				num=sc.nextInt();
				for(int i=1; i<=test.n-1; i++) {
					if(test.emp[i].search(num)) flag=true;
					if(flag) {
						test.emp[i].age=test.emp[i+1].age;
						test.emp[i].ID=test.emp[i+1].ID;
						test.emp[i].name=test.emp[i+1].name;
						test.emp[i].job=test.emp[i+1].job;
						test.emp[i].salary=test.emp[i+1].salary;
					}
				}
				test.n--;
				break;
			case 5:
				System.out.println("请输入要修改的ID");
				num=sc.nextInt();
				for(int i=1; i<=test.n; i++) {
					if(test.emp[i].search(num)) {
						test.emp[i].print();
						System.out.print("修改的姓名：");
						name=sc.next();
						System.out.print("修改的年龄：");
						age=sc.nextInt();
						System.out.print("修改的工号：");
						ID=sc.nextInt();
						System.out.print("修改的工作：");
						job=sc.next();
						System.out.print("修改的工资：");
						salary=sc.nextFloat();
						test.emp[i].set(name, age, ID, job, salary);
						break;
					}
				}
				break;
			case 6:
				f=true;
				break;
			}
			if(f) break;
		}
	}
}
