package vo;

import vo.Person;

public class Worker extends Person {
	int salary;
	String position;
	public Worker(String id,String name,int age,int salary,String position){
		super(id,name,age);
		this.salary=salary;
		this.position=position;
	}
	 public void putSalary(int salary){
		 this.salary=salary;
	 }
	 public void putPosition(String position){
		 this.position=position;
	 }
	 public int getSalary(){
		 return salary;
	 }
	 public String getPosition(){
		 return position;
	 }
	 public  String toString(){ 
		 return "ID"+this.getID()+"\t姓名"+this.getName()+"\t年龄"+this.getAge() +"\t薪水"+salary+"\tְ职位"+position;
	 }//ת��Ϊ�ַ���
}
