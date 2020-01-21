package controller;

import java.util.List;
import java.util.Set;

import model.InfoSysModel;
import view.StudentGui;
import view.InfoSysView;
import vo.Student;

public class ControllerImpl implements Controller  
{  
    private InfoSysModel infoSysModel;  
    private InfoSysView infoSysView;  
    public ControllerImpl(InfoSysModel model,InfoSysView view)  
    {  
        try{  
            infoSysModel=model;  
            infoSysView=view;  
            view.addUserGestureListener(this);  
        }catch(Exception e)  
        {  
            reportException(e);  
        }  
    }  
    //�����쳣  
    private void reportException(Object o)  
    {  
        try{  
            infoSysView.showDisplay(o);  
        }catch(Exception e)  
        {  
            System.out.println("ControllerImpl reportException "+e);  
        }  
    }  
 
	@Override
	public void handleAddGesture(Student stu) { 
		        try{  
		            infoSysModel.add(stu);
		            infoSysModel.fireModelChangeEvent(stu);
		        }catch(Exception e)  
		        {  
		            reportException(e);  
		        }  
		
	}
	public void handleShowGesture(Student stu) throws Exception {
		 try{  
	            infoSysModel.show(stu);  
	        }catch(Exception e)  
	        {  
	            reportException(e);  
	        }  
		
	}
	public void handleFindByIDGesture(String id) throws Exception {
		Student stu=null;  
		
        try{  
            stu=infoSysModel.findByID(id);//����Model����ȥ���ݿ��ȡָ��ID����Ա����  
            infoSysView.showDisplay(stu);//ͨ��View��ʾ����  
        }catch(Exception e)  
        {  
            reportException(e);  
            stu=new Student(id);  
            try{  
                infoSysView.showDisplay(stu);  
            }catch(Exception ex)  
            {  
                reportException(ex);  
            }  
        }  
	}
	
	public void handleFindByNameGesture(String name) throws Exception {
		Student stu=null;  
        try{  
            stu=infoSysModel.findByName(name);//����Model����ȥ���ݿ��ȡָ��name����Ա����  
            infoSysView.showDisplay(stu);//ͨ��View��ʾ����  
        }catch(Exception e)  
        {  
            reportException(e);  
            stu=new Student(name);  
            try{  
                infoSysView.showDisplay(stu);  
            }catch(Exception ex)  
            {  
                reportException(ex);  
            }  
        }  
		
	}
	
	public void handleDelGesture(Student stu) throws Exception {
		try{  
            infoSysModel.del(stu);  
        }catch(Exception e)  
        {  
            reportException(e);  
        }  
		
	}
	public void handleModGesture(Student stu) throws Exception {

        try{  
            infoSysModel.update(stu);  
        }catch(Exception e)  
        {  
            reportException(e);  
        }  
		
	}
	@Override
	public Object handleReadGesture() throws Exception {
		 try{  
	            infoSysModel.read();  
	        }catch(Exception e)  
	        {  
	            reportException(e);  
	        }
		return null;  
	}
	@Override
	public void handleSaveGesture(List<Student> it) throws Exception {
		 try{  
	            infoSysModel.save(it);  
	        }catch(Exception e)  
	        {  
	            reportException(e);  
	        }  
		
	}
	@Override
	public void handleGetAllStudent() {
		   
	        try{  
	        	Set<Student> students=null;
	        	students=infoSysModel.getAllStudent();//ͨ��Model������������Ա��Ϣ  
	        	infoSysView.showDisplay(students);//ͨ��View��ʾ����
	             
	        }catch(Exception e)  
	        {  
	            reportException(e);  
	        }  
		
	}  
  
}  