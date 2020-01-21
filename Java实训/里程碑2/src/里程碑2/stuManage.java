package 里程碑2;


import java.util.ArrayList;


public class stuManage implements personoperate{
	private ArrayList al=null;
	
	public stuManage() {
		al=new ArrayList();
		
	}
	
	//添加新进入的雇员
	public void add(Stu stu) {
		
		al.add(stu);
		System.out.println("添加成功！");
	}
	
	//根据输入的雇员编号打印雇员信息
	public void find(String stuNo) {
		for(int i=0;i<al.size();i++) {
			Stu stu=(Stu)al.get(i);
			if(stu.getID().equals(stuNo)) {
				System.out.println("名字："+stu.getName()+"年龄："+stu.getAge()+"成绩："+stu.getGrade());
			}
		}
	}
	
	//打印全部雇员的所有信息
	public void showAll() {
		for(int i=0;i<al.size();i++) {
			Stu stu=(Stu)al.get(i);
			System.out.println("编号："+stu.getID()+"名字："+stu.getName()+"年龄："+stu.getAge()+"成绩："+stu.getGrade());
		}
	}
	
	//修改某个雇员的薪水
	public void update(String stuNo,double newgrade) {
		for(int i=0;i<al.size();i++) {
			Stu stu=(Stu)al.get(i);
			if(stu.getID().equals(stuNo)) {
				stu.setGrade(newgrade);
			}
		}
		System.out.println("修改成功！");
	}
	
	//删除某个雇员
	public void delete(String stuNo) {
		for(int i=0;i<al.size();i++) {
			Stu stu=(Stu)al.get(i);
			if(stu.getID().equals(stuNo)) {
				al.remove(stu);
			}
		}
		System.out.println("删除成功！");
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		
	}



}

