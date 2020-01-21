package InfoSys.view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import InfoSys.vo.Student;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;
public class Gui_stu {
	//界面的主要窗体组件 
	protected JFrame frame;
	protected Container contentPane;
	protected CardLayout card = new CardLayout();
	protected JPanel cardPan = new JPanel();
	
	//包含各种按钮的选择面板上的组件
	protected JPanel selPan = new JPanel();
	protected JButton stuBt = new JButton("学生详细信息");
	protected JButton allStuBt = new JButton("所有学生清单");
	
	//显示单个学生的面板上的组件
	protected JPanel stuPan=new JPanel(); 
	protected JLabel idLb=new JLabel("ID");
	protected JLabel nameLb=new JLabel("学生姓名");
	protected JLabel ageLb=new JLabel("学生年龄");
	protected JLabel scoreLb=new JLabel("学生成绩");
	
	 public static JTextField idTf=new JTextField(25);
	 public static JTextField nameTf=new JTextField(25);
	 public static JTextField ageTf=new JTextField(25);
	 public static JTextField scoreTf=new JTextField(25);
	
	 protected JButton addBt=new JButton("添加学生");
	 protected JButton delBt=new JButton("删除学生");
	 protected JButton findByIDBt=new JButton("按ID查找学生");
	 protected JButton findByNameBt=new JButton("按姓名关键字查找学生");
	 protected JButton modBt=new JButton("修改学生信息");
	 protected JButton showBt=new JButton("更新信息");
	 
	 //列举所有学生的面板上的组件
	 protected JPanel allStuPan=new JPanel();
	 protected JLabel allStuLb=new JLabel("所有学生清单 ",SwingConstants.CENTER);
	 protected JTextArea allStuTa=new JTextArea();
	 protected JScrollPane allStuSp=new JScrollPane(allStuTa);
	 
	 String[] tableHeaders={"ID","姓名","年龄","成绩"}; 
	 JTable table;
	 JScrollPane tablePane; 
	 DefaultTableModel tableModel; 
	 
	//日志面板上的组件
	 protected JPanel logPan=new JPanel();
	 protected JLabel logLb=new JLabel("操作日志 ",SwingConstants.CENTER);
	 protected JTextArea logTa=new JTextArea(9,50); 
	 protected JScrollPane logSp=new JScrollPane(logTa); 
	 
	 /** 显示单个学生面板 StuPan */ 
	 public void refreshStuPane(Student stu){ 
		    showCard("student"); 
		    if(stu==null || stu.getID().equals(-1)){ 
		      idTf.setText(null); 
		      nameTf.setText(null); 
		      ageTf.setText(null); 
		      scoreTf.setText(null); 
		      return; 
		    } 
		    idTf.setText(new Long(stu.getID()).toString()); 
		    nameTf.setText(stu.getName().trim()); 
		    ageTf.setText(String.valueOf(stu.getAge())); 
		    scoreTf.setText(String.valueOf(stu.getScore())); 
		  } 
	 
	 /** 显示所有客户面板 allStuPan */ 
	  public void refreshAllStuPan(Set stus){ 
	    showCard("allstudents"); 
	    String newData[][]; 
	    newData=new String[stus.size()][4]; 
	    Iterator it=stus.iterator(); 
	    int i=0;  
	    while(it.hasNext()){ 
	      Student stu=(Student) it.next(); 
	      newData[i][0]=new Integer(stu.getID()).toString(); 
	      newData[i][1]=stu.getName(); 
	      newData[i][2]=String.valueOf(stu.getAge()); 
	      newData[i][3]=String.valueOf(stu.getScore());
	      i++;  
	    } 
	    tableModel.setDataVector(newData,tableHeaders); 
	  } 
	  
	  /** 在日志面板 log Pan 中添加日志信息 */ 
	  public void updateLog(String msg){ 
	    logTa.append(msg+"\n"); 
	  } 
	  
	  /** 获得学生面板 stuPan 上用户输入的 ID */ 
	  public int getStuIdOnCustPan(){ 
		    try{ 
		        return Integer.parseInt(idTf.getText().trim()); 
		      }catch(Exception e){ 
		        updateLog(e.getMessage()); 
		        return -1; 
		      } 
		   } 
	  
	  /** 获得单个学生面板 stuPan 上用户输入的学生信息 */ 
	  public Student getStudentOnCustPan(){ 
	    try{ 
	      return new Student(idTf.getText().trim(), 
	        nameTf.getText().trim(),Integer.parseInt(ageTf.getText().trim()), 
	        Integer.parseInt(ageTf.getText().trim())); 
	    }catch(Exception e){ 
	      updateLog(e.getMessage()); 
	      return null;  
	    } 
	  } 
	 
	 /** 显示单个客户面板 stuPan 或者所有客户面板 allStuPan */ 
	  private void showCard(String cardStr){ 
	    card.show(cardPan,cardStr); 
	  } 
	  
	  /** 构造方法 */ 
	  public Gui_stu(){ 
	    buildDisplay(); 
	  } 
	  
	  /** 创建图形界面 */ 
	  private void buildDisplay(){ 
	   frame=new JFrame("学生信息管理系统"); 
	   buildSelectionPanel(); 
	   buildStuPanel(); 
	   buildAllStuPanel(); 
	   buildLogPanel(); 

	   /** carPan 采用 CardLayout 布局管理器，包括 stuPan 和
	   allStuPan 两张卡片 */ 
      cardPan.setLayout(card); 
      cardPan.add(stuPan,"student"); 
      cardPan.add(allStuPan,"allstudents"); 
      //向主窗体中加入各种面板 
      contentPane=frame.getContentPane(); 
      contentPane.setLayout(new BorderLayout()); 
      contentPane.add(cardPan,BorderLayout.CENTER); 
      contentPane.add(selPan,BorderLayout.NORTH); 
      contentPane.add(logPan,BorderLayout.SOUTH); 
      frame.pack(); 
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      frame.setVisible(true); 
	  }   
	  
	  /** 创建选择面板 selPan */  
	  private void buildSelectionPanel(){
		  selPan.add(stuBt);  
	      selPan.add(allStuBt);  
	  } 
	  
	  /** 为选择面板 selPan 中的两个按钮注册监听器 */ 
	  public void addSelectionPanelListeners(ActionListener a[]){ 
	   int len=a.length; 
	   if(len!=2){ return;} 
	   stuBt.addActionListener(a[0]); 
	   allStuBt.addActionListener(a[1]); 
	  } 
	  
	  /**  创建单个客户stuPan 面板 */ 
	  private void buildStuPanel(){
	  	stuPan.setLayout(new GridLayout(7,2,2,2));  
	  	stuPan.add(idLb);  
	  	stuPan.add(idTf);  
	  	stuPan.add(nameLb);  
	  	stuPan.add(nameTf);  
	  	stuPan.add(ageLb);  
	  	stuPan.add(ageTf);  
	  	stuPan.add(scoreLb);  
	  	stuPan.add(scoreTf);  
	  	stuPan.add(addBt);  
	  	stuPan.add(delBt);  
	  	stuPan.add(findByIDBt);  
	  	stuPan.add(findByNameBt); 
	  	stuPan.add(modBt);  
	  	stuPan.add(showBt); 
	  } 
	   
	  /** 为单个客户面板 stuPan 中的6 个按钮注册监听器 */ 
	  public void addStuPanelListeners(ActionListener a[]){ 
	    int len=a.length; 
	    if(len!=6){ return;} 
	   addBt.addActionListener(a[0]); 
	   delBt.addActionListener(a[1]); 
	   findByIDBt.addActionListener(a[2]); 
	   findByNameBt.addActionListener(a[3]); 
	   modBt.addActionListener(a[4]); 
	   showBt.addActionListener(a[5]); 
	  } 

	  /** 创建所有学生 allStuPan 面板 */ 
	  private void buildAllStuPanel(){ 
	    allStuPan.setLayout(new BorderLayout()); 
	    allStuPan.add(allStuLb,BorderLayout.NORTH);
	    allStuTa.setText("all student display"); 
	    tableModel=new DefaultTableModel(tableHeaders,10); 
	    table=new JTable(tableModel); 
	    tablePane=new JScrollPane(table); 
	    allStuPan.add(tablePane,BorderLayout.CENTER); 
	    Dimension dim=new Dimension(500,150); 
	    table.setPreferredScrollableViewportSize(dim); //设置此表视口的首选大小。
	  } 
	   
	  /** 创建日志面板*/ 
	  private void buildLogPanel(){
		logPan.setLayout(new BorderLayout());  
        logSp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        logSp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        logPan.add(logLb,BorderLayout.NORTH);  
        this.logPan.add(logSp,BorderLayout.CENTER);  } 
	


}
