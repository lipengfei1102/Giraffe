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
	 //监听图形界面上添加人员按钮  
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
  //监听图形界面上删除人员按钮  
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
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} 
	            
	        } 
        	}
        }  
          
    };  
  //监听图形界面上删除人员按钮  
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
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} 
	            
	        } 
        	}
        }  
          
    };  
  //监听图形界面上人员详情信息按钮  
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
    //监听图形界面上所有人员清单按钮  
    transient ActionListener allStusPageHandler=new ActionListener()  
    {  
  
        public void actionPerformed(ActionEvent e)   
        {  if(e.getSource() == gui.allStuBt) {
        	Controller sc;  
            sc=Controllers.get(0);  
            sc.handleGetAllStudent(); }
              
        }  
          
    };  
    //监听图形界面上按名字查找人员按钮  
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
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} 
	            
	        } 
        	}
        }  
          
    };
  //监听图形界面上按ID查找人员按钮  
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
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} 
	            
	        } 
        	}
        }  
          
    };
  //监听图形界面上刷新按钮  
    transient ActionListener showHandler=new ActionListener()  
    {  
  
    	
        public void actionPerformed(ActionEvent e)  
        {   
        	
        }  
          
    };
    //存储监听器  
    transient ActionListener[] stuPanelListeners={stuAddHandler,stuDelHandler,findByIdHandler,findByNameHandler,stuModHandler,showHandler};  
    transient ActionListener[] selectionPanelListeners={stuDetailsPageHandler,allStusPageHandler};
	//注册控制器  
	public void addUserGestureListener(Controller ctrl) throws RemoteException {
		Controllers.add(ctrl);  
		
	}
	//在图形界面上展示参数display指定的数据 
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
	/**刷新界面的人员信息*/  
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
                if(stuIdOnPanel!=stu.getID())//只同步刷新在查询相同人员信息的视图  
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
