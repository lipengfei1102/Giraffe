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
		 return "ѧ�ţ�"+this.getID()+"\t"+"������"+this.getName()+"\t���䣺"+this.getAge() +"\t�ɼ���"+Grade;
	 }//ת��Ϊ�ַ���
}
