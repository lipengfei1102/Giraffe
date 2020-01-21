package vo;

import vo.Person;

public class Student extends Person{
	 float Grade;
	 public Student(String ID,String name,int age,float Grade){
		 super(ID,name,age);
		 this.Grade=Grade;
	 }
	 public Student(String id)  
	    {  	
		 	super(id);
	    } 
	 public void putAge(int age){
		 this.age=age;
	 }

	 public void putGrade(float Grade){
		 this.Grade=Grade;
	 }
	 public float getGrade(){
		 return Grade;
	 }
	 public  String toString(){ 
		 return "学号："+this.getID()+"\t"+"姓名："+this.getName()+"\t年龄："+this.getAge() +"\t成绩："+Grade;
	 }//转化为字符串
}
