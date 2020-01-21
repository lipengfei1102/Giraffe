package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Writer;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import view.StudentGui;
import view.InfoSysView;
import vo.Student;;
public class InfoSysModelFileImpl implements InfoSysModel  {
	private ArrayList<InfoSysView> changeListeners=new ArrayList<InfoSysView>(10);  
	public static List<Student> stus=new ArrayList<Student>(); 
	public  void L1(List<Student> stu) {
		stus=stu;
	}
	public boolean check (String id){
		Iterator<Student> it= stus.iterator();
		while(it.hasNext()){
			Student stu=it.next();
			if(id.equals(stu.getID())){
				return true;
			}
		}return false;
	}
	
	 /**ע����ͼ���Ա㵱ģ���޸������ݿ��е���Ա��Ϣʱ���Իص���ͼ��ˢ�½���ķ���*/  
    public void addChangeListener(InfoSysView iv) throws RemoteException {  
          
        changeListeners.add(iv);  
    }  
		
		public Object read() throws Exception{
				stus.clear();//��ֹ�����ظ�
				File f = new File("students.txt");
				if(f.exists()) {
					
				InputStream in = new FileInputStream(f); 
		        Scanner s = new Scanner(in); 
				try {
					Scanner l = null;
					String line = null;
					while(s.hasNextLine())
					{
						line = s.nextLine();
						l = new Scanner(line);
						l.useDelimiter("----");
						String id = l.next();
						String name = l.next();
						stus.add(new Student(id,name,l.nextInt(),l.nextFloat()));
		
					}
				}catch(Exception e) {
					throw e;
				}finally {
					try {
						s.close();
					}catch(Exception e) {}
				}
				System.out.println("------��ȡѧ����Ϣ�ɹ�------");
			}
				else
					{System.out.println("�ļ���ȡ���������Ŀ¼�Ƿ�����Ϊstudents���ı�,��û�������ó���������ݲ�����");}
				return stus;
		}
		public void save(List<Student> it) throws Exception{
			Writer out = new FileWriter("students.txt");//,true ׷��д��
			Iterator<Student> iter = ((ArrayList<Student>)stus).iterator();
			while(iter.hasNext()) {
				Student stu = (Student)iter.next();
				out.write(stu.getID()+"----"+stu.getName()+"----"+stu.getAge()+"----"+stu.getGrade()+"\r\n");
			}
			out.flush();
			out.close();
			System.out.println("------����ѧ����Ϣ�ɹ�------");
			
		}
		@Override
		public void add(Student stu) throws Exception {

	
			String id = StudentGui.idTf.getText();
			String name = StudentGui.nameTf.getText();
			int age = Integer.valueOf(StudentGui.ageTf.getText());
			float Grade = Integer.valueOf(StudentGui.GradeTf.getText());
			if(this.check(stu.getID()))
			{StudentGui.updateLog("ID�Ѵ��ڣ�");}
			else
			{	read();
				stus.add(new Student(id,name,age,Grade));
				StudentGui.updateLog("��ӳɹ���");
				save(stus);}
			
		}
		@Override
		public void show(Student stu) throws Exception {
			StudentGui.updateLog("ˢ�³ɹ���");
			
		}
		@Override
		public Student findByID(String id) throws Exception {
			
			boolean Find = false;
	        id= StudentGui.idTf.getText();
	        Iterator<Student> it= stus.iterator();
	        Student stud  = null;
			while(it.hasNext()){
				Student stu=(Student)it.next();
				if(stu.getID().equals(id)){
					StudentGui.nameTf.setText(stu.getName());
					StudentGui.ageTf.setText(String.valueOf(stu.getAge()));
					StudentGui.GradeTf.setText(String.valueOf(stu.getGrade()));
					Find = true;
					StudentGui.updateLog("���ҵ�");
					StudentGui.updateLog(stu.toString());
					stud =  stu;
				}
			} 
			
				if(!Find) {
					StudentGui.updateLog("û����λͬѧ����Ϣ");;}
				return stud;
			
		}
		@Override
		public Student findByName(String name) throws Exception {
			boolean Find = false;
	        name= StudentGui.nameTf.getText();
	        Iterator<Student> it= stus.iterator();
	        Student stud  = null;
			while(it.hasNext()){
				Student stu=(Student)it.next();
				if(stu.getName().matches("(.*)"+name+"(.*)")){
					StudentGui.idTf.setText(stu.getName());
					StudentGui.nameTf.setText(stu.getName());
					StudentGui.ageTf.setText(String.valueOf(stu.getAge()));
					StudentGui.GradeTf.setText(String.valueOf(stu.getGrade()));
					Find = true;
					StudentGui.updateLog("���ҵ�");
					StudentGui.updateLog(stu.toString());
					stud =  stu;
				}
			} 
			
				if(!Find) {
					StudentGui.updateLog("û����λͬѧ����Ϣ");;}
				return stud;
			
		}
		@Override
		public void del(Student stu) throws Exception {
			 String id = StudentGui.idTf.getText();
	         
	         Iterator<Student> it= stus.iterator();
	     	while(it.hasNext()){
	     		    stu=(Student)it.next();
					if(stu.getID().equals(id)){
						it.remove();
						save(stus);
						StudentGui.updateLog("ɾ���ɹ�");
						break;}
					else if(!it.hasNext())
						StudentGui.updateLog("û���ҵ�");
	     		}		
			
		}
		@Override
		public void update(Student stu) throws Exception {
			String id = StudentGui.idTf.getText();
	         
	        Iterator<Student> it= stus.iterator();
	     	while(it.hasNext()){
	     		    stu=(Student)it.next();
					if(stu.getID().equals(id)){
						stu.putName(StudentGui.nameTf.getText());
						stu.putAge(Integer.valueOf(StudentGui.ageTf.getText()));
						stu.putGrade(Integer.valueOf(StudentGui.GradeTf.getText()));
						save(stus);
						StudentGui.updateLog("�޸ĳɹ�");
						break;}
					else if(!it.hasNext())
						StudentGui.updateLog("û���ҵ�");
	     		}		
			
		}
		public Set<Student> getAllStudent() throws Exception {   
			
	          Set<Student> stuset=new HashSet<Student>();  
	          Student stu;  
			  File f = new File("students.txt");
			  if(f.exists()) {
				  StudentGui.updateLog("�ļ��Ѵ���");
				  InputStream in = new FileInputStream(f); 
			        Scanner s = new Scanner(in); 
					try {
						Scanner l = null;
						String line = null;
						while(s.hasNextLine())
						{
							line = s.nextLine();
							l = new Scanner(line);
							l.useDelimiter("----");
							String id = l.next();
							String name = l.next();
							stu = new Student(id,name,l.nextInt(),l.nextFloat());
							stuset.add(stu);
						}
						
					}catch(Exception e) {
						throw e;
					}finally {
						try {
							s.close();
						}catch(Exception e) {}
					}
			  }
			  return stuset;  
		}
		/**�����ݿ�����Ա��Ϣ�����仯ʱ��ͬ��ˢ��������ͼ*/  
	    public void fireModelChangeEvent(Student stu)  
	    {  
	    	InfoSysView v;  
	        for(int i=0;i<changeListeners.size();i++)  
	        {  
	            try{  
	                v=changeListeners.get(i);  
	                v.handleStudentChange(stu);  
	            }catch(Exception e)  
	            {  
	                System.out.println(e.toString());  
	            }  
	        }  
	    }  
}

