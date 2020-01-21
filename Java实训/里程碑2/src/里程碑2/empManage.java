package 里程碑2;


import java.util.ArrayList;


public class empManage implements personoperate{
	private ArrayList al=null;
	
	public empManage() {
		al=new ArrayList();
		
	}
	
	//添加新进入的雇员
	public void add(Emp emp) {
		
		al.add(emp);
		System.out.println("添加成功！");
	}
	
	//根据输入的雇员编号打印雇员信息
	public void find(String empNo) {
		for(int i=0;i<al.size();i++) {
			Emp emp=(Emp)al.get(i);
			if(emp.getID().equals(empNo)) {
				System.out.println("名字："+emp.getName()+"年龄："+emp.getAge()+"工作："+emp.getJob()+"薪水："+emp.getEmpsal());
			}
		}
	}
	
	//打印全部雇员的所有信息
	public void showAll() {
		for(int i=0;i<al.size();i++) {
			Emp emp=(Emp)al.get(i);
			System.out.println("编号："+emp.getID()+"名字："+emp.getName()+"年龄："+emp.getAge()+"工作："+emp.getJob()+"薪水："+emp.getEmpsal());
		}
	}
	
	//修改某个雇员的薪水
	public void update(String empNo,double newSal) {
		for(int i=0;i<al.size();i++) {
			Emp emp=(Emp)al.get(i);
			if(emp.getID().equals(empNo)) {
				emp.setEmpsal(newSal);
			}
		}
		System.out.println("修改成功！");
	}
	
	//删除某个雇员
	public void delete(String empNo) {
		for(int i=0;i<al.size();i++) {
			Emp emp=(Emp)al.get(i);
			if(emp.getID().equals(empNo)) {
				al.remove(emp);
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

