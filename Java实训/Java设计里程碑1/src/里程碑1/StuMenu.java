package 里程碑1;
import java.util.*;
public class StuMenu{
	static void start() {
		Scanner sc=new Scanner(System.in);
		int choose2, age, ID, num;
		boolean f=false;
		float grade;
		String name;
		while(true){
			System.out.println("学生信息管理");
			System.out.println("\t 1.增加学生信息");
			System.out.println("\t 2.列出全部学生信息");
			System.out.println("\t 3.查询学生信息");
			System.out.println("\t 4.删除学生信息");
			System.out.println("\t 5.修改学生信息");
			System.out.println("\t 6.返回上一级菜单");
			choose2=sc.nextInt();
			switch(choose2) {
			case 1:
				System.out.println("输入学生姓名");
				name=sc.next();
				System.out.println("输入学生年龄");
				age=sc.nextInt();
				System.out.println("输入学生学号");
				ID=sc.nextInt();
				System.out.println("输入学生成绩");
				grade=sc.nextFloat();
				test.n++;
				System.out.println(test.n);
				test.stu[test.n]=new student(name, age, ID, grade);
				test.stu[test.n].print();
				break;
			case 2:
				for(int i=1; i<=test.n; i++) {
					test.stu[i].print();
				}
				break;
			case 3:
				System.out.println("输入要查找的学生学号");
				num=sc.nextInt();
				for(int i=1; i<=test.n; i++) {
					if(test.stu[i].search(num)) {
						test.stu[i].print();
						break;
					}
				}
				break;
			case 4:
				boolean flag=false;
				System.out.println("输入要删除的学生ID");
				num=sc.nextInt();
				for(int i=1; i<=test.n-1; i++) {
					if(test.stu[i].search(num)) flag=true;
					if(flag) {
						test.stu[i].age=test.stu[i+1].age;
						test.stu[i].ID=test.stu[i+1].ID;
						test.stu[i].name=test.stu[i+1].name;
						test.stu[i].score=test.stu[i+1].score;
					}
				}
				test.n--;
				break;
			case 5:
				System.out.println("输入要修改的学生ID");
				num=sc.nextInt();
				for(int i=1; i<=test.n; i++) {
					if(test.stu[i].search(num)) {
						test.stu[i].print();
						System.out.println("修改的姓名");
						name=sc.next();
						System.out.println("修改的年龄");
						age=sc.nextInt();
						System.out.println("修改的学号");
						ID=sc.nextInt();
						System.out.println("修改的分数");
						grade=sc.nextFloat();
						test.stu[i].set(name, age, ID, grade);
						break;
					}
				}
				break;
			case 6:
				f=true;
				break;
			}
			if(f) {
				break;
			}
		}
	}
}
