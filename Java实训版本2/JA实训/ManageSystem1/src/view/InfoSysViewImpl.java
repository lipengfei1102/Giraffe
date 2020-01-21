package view;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;
import model.InfoSysModel;
import vo.Student;
public class InfoSysViewImpl extends UnicastRemoteObject implements InfoSysView,Serializable {
	private transient StudentGui gui;  
    private InfoSysModel infosysModel;  
    private Object display;  
    private ArrayList<Controller> Controllers=new ArrayList<Controller>(10);  
	public InfoSysViewImpl(InfoSysModel model) throws RemoteException {
		super();
		try{  
            this.infosysModel=model;  
            model.addChangeListener(this);  
        }catch(Exception e)  
        {  
            System.out.println("ViewImpl constructor "+e);  
        }  
        gui=new StudentGui();  
        gui.setVisible(true);
        gui.addSelectionPanelListeners(selectionPanelListeners);  
        gui.addStuPanelListeners(stuPanelListeners);  
	}
	 //����ͼ�ν����������Ա��ť  
    transient ActionListener stuAddHandler=new ActionListener()  
    {  
  
    	
        public void actionPerformed(ActionEvent e)  
        {   
        	if(e.getSource() == gui.addBt) {
        	Controller sc;  
	        for(int i=0;i<Controllers.size();i++)  
	        {  
	            sc=Controllers.get(i); 
	            sc.handleAddGesture(gui.getStudentOnStuPanel()); 
	            
	        } 
        	}
        }  
          
    };  
  //����ͼ�ν�����ɾ����Ա��ť  
    transient ActionListener stuDelHandler=new ActionListener()  
    {  
  
    	
        public void actionPerformed(ActionEvent e)  
        {   
        	if(e.getSource() == gui.delBt) {
        	Controller sc;  
	        for(int i=0;i<Controllers.size();i++)  
	        {  
	            sc=Controllers.get(i); 
	            try {
					sc.handleDelGesture(gui.getStudentOnStuPanel());
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} 
	            
	        } 
        	}
        }  
          
    };  
  //����ͼ�ν�����ɾ����Ա��ť  
    transient ActionListener stuModHandler=new ActionListener()  
    {  
  
    	
        public void actionPerformed(ActionEvent e)  
        {   
        	if(e.getSource() == gui.modBt) {
        	Controller sc;  
	        for(int i=0;i<Controllers.size();i++)  
	        {  
	            sc=Controllers.get(i); 
	            try {
					sc.handleModGesture(gui.getStudentOnStuPanel());
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} 
	            
	        } 
        	}
        }  
          
    };  
  //����ͼ�ν�������Ա������Ϣ��ť  
    transient ActionListener stuDetailsPageHandler=new ActionListener() 
    {
    	public void actionPerformed(ActionEvent e)   
        {  if(e.getSource() == gui.stuBt) {
                try{  
                    showDisplay(new Student(null));  
                }catch(Exception e1)  
                {  
                    e1.printStackTrace();  
                }  
          
          }   
        }  
          
    };
    //����ͼ�ν�����������Ա�嵥��ť  
    transient ActionListener allStusPageHandler=new ActionListener()  
    {  
  
        public void actionPerformed(ActionEvent e)   
        {  if(e.getSource() == gui.allStuBt) {
        	Controller sc;  
            sc=Controllers.get(0);  
            sc.handleGetAllStudent(); }
              
        }  
          
    };  
    //����ͼ�ν����ϰ����ֲ�����Ա��ť  
    transient ActionListener findByNameHandler=new ActionListener()  
    {  
  
    	
        public void actionPerformed(ActionEvent e)  
        {   
        	if(e.getSource() == gui.findByNameBt) {
        	Controller sc;  
	        for(int i=0;i<Controllers.size();i++)  
	        {  	
	            sc=Controllers.get(i); 
	            try {
					sc.handleFindByNameGesture(StudentGui.nameTf.getText());
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} 
	            
	        } 
        	}
        }  
          
    };
  //����ͼ�ν����ϰ�ID������Ա��ť  
    transient ActionListener findByIdHandler=new ActionListener()  
    {  
  
    	
        public void actionPerformed(ActionEvent e)  
        {   
        	if(e.getSource() == gui.findByIDBt) {
        	Controller sc;  
	        for(int i=0;i<Controllers.size();i++)  
	        {  	
	            sc=Controllers.get(i); 
	            try {
					sc.handleFindByIDGesture(StudentGui.idTf.getText());
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} 
	            
	        } 
        	}
        }  
          
    };
  //����ͼ�ν�����ˢ�°�ť  
    transient ActionListener showHandler=new ActionListener()  
    {  
  
    	
        public void actionPerformed(ActionEvent e)  
        {   
        	
        }  
          
    };
    //�洢������  
    transient ActionListener[] stuPanelListeners={stuAddHandler,stuDelHandler,findByIdHandler,findByNameHandler,stuModHandler,showHandler};  
    transient ActionListener[] selectionPanelListeners={stuDetailsPageHandler,allStusPageHandler};
	//ע�������  
	public void addUserGestureListener(Controller ctrl) throws RemoteException {
		Controllers.add(ctrl);  
		
	}
	//��ͼ�ν�����չʾ����displayָ�������� 
	public void showDisplay(Object display) throws RemoteException {

		
		if(!(display instanceof Exception))  
        {  
            this.display=display;  
        }  
		if(display instanceof Student)  
        {  
            gui.refreshStuPan((Student)display);  
        }  
		if(display instanceof Set)  
        {
            gui.refreshAllStuPan((Set<Student>)display);  
            
        }  
		if(display instanceof Exception)  
        {  
            gui.updateLog(((Exception)display).getMessage());  
        }  
		
	}
	/**ˢ�½������Ա��Ϣ*/  
    public void handleStudentChange(Student stu) throws RemoteException {  
        String stuIdOnPanel="-1";  
        try{  
            if(display instanceof Set)  
            {  
                gui.refreshAllStuPan(infosysModel.getAllStudent());  
                return;  
            }  
            if(display instanceof Student)  
            {  
            	stuIdOnPanel=gui.getStuIdOnStuPan();  
                if(stuIdOnPanel!=stu.getID())//ֻͬ��ˢ���ڲ�ѯ��ͬ��Ա��Ϣ����ͼ  
                {  
                    return;  
                      
                }  
                gui.refreshStuPan(stu);  
            }  
        }catch(Exception e)  
        {  
            System.out.println("ViewImpl processStudent "+e);  
        }  
          
    }  

}
