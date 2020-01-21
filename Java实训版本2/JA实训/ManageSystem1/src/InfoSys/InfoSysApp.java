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
            StudentGui.updateLog("删除、修改、按ID查找均是根据ID操作，请先在文本框内输入要操作的ID");
            StudentGui.updateLog("按姓名查找均是根据姓名关键字进行操作，请先在姓名文本框输入要操作的姓名(关键字)");
            
        }  
        catch(Exception e)  
        {  
            e.printStackTrace();  
        }  
    }  
}  