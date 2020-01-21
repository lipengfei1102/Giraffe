package InfoSys;


import controller.ControllerImpl;
import controller.Controller;
import model.InfoSysModel;
import model.InfoSysModelFileImpl;
import view.StudentGui;
import view.InfoSysView;
import view.InfoSysViewImpl;  
public class InfoSysApp   
{  
    public static void main(String[]args)  
    {  
        try  
        {   InfoSysModel model;  
        	InfoSysView view;  
        	Controller ctrl;  
        	model=new InfoSysModelFileImpl();
        	view=new InfoSysViewImpl(model);  
            ctrl=new ControllerImpl(model,view);  
            model.read();
            
            StudentGui.updateLog("初次使用请先添加信息");
            StudentGui.updateLog("请先输入要操作的id");
            StudentGui.updateLog("输入要操作的姓名");
            
        }  
        catch(Exception e)  
        {  
            e.printStackTrace();  
        }  
    }  
}  