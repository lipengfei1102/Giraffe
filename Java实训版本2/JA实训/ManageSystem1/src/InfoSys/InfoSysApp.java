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
            
            StudentGui.updateLog("����ʹ�����������Ϣ");
            StudentGui.updateLog("ɾ�����޸ġ���ID���Ҿ��Ǹ���ID�������������ı���������Ҫ������ID");
            StudentGui.updateLog("���������Ҿ��Ǹ��������ؼ��ֽ��в����������������ı�������Ҫ����������(�ؼ���)");
            
        }  
        catch(Exception e)  
        {  
            e.printStackTrace();  
        }  
    }  
}  