package InfoSys.view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import InfoSys.vo.Student;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;
public class Gui_stu {
	//�������Ҫ������� 
	protected JFrame frame;
	protected Container contentPane;
	protected CardLayout card = new CardLayout();
	protected JPanel cardPan = new JPanel();
	
	//�������ְ�ť��ѡ������ϵ����
	protected JPanel selPan = new JPanel();
	protected JButton stuBt = new JButton("ѧ����ϸ��Ϣ");
	protected JButton allStuBt = new JButton("����ѧ���嵥");
	
	//��ʾ����ѧ��������ϵ����
	protected JPanel stuPan=new JPanel(); 
	protected JLabel idLb=new JLabel("ID");
	protected JLabel nameLb=new JLabel("ѧ������");
	protected JLabel ageLb=new JLabel("ѧ������");
	protected JLabel scoreLb=new JLabel("ѧ���ɼ�");
	
	 public static JTextField idTf=new JTextField(25);
	 public static JTextField nameTf=new JTextField(25);
	 public static JTextField ageTf=new JTextField(25);
	 public static JTextField scoreTf=new JTextField(25);
	
	 protected JButton addBt=new JButton("���ѧ��");
	 protected JButton delBt=new JButton("ɾ��ѧ��");
	 protected JButton findByIDBt=new JButton("��ID����ѧ��");
	 protected JButton findByNameBt=new JButton("�������ؼ��ֲ���ѧ��");
	 protected JButton modBt=new JButton("�޸�ѧ����Ϣ");
	 protected JButton showBt=new JButton("������Ϣ");
	 
	 //�о�����ѧ��������ϵ����
	 protected JPanel allStuPan=new JPanel();
	 protected JLabel allStuLb=new JLabel("����ѧ���嵥 ",SwingConstants.CENTER);
	 protected JTextArea allStuTa=new JTextArea();
	 protected JScrollPane allStuSp=new JScrollPane(allStuTa);
	 
	 String[] tableHeaders={"ID","����","����","�ɼ�"}; 
	 JTable table;
	 JScrollPane tablePane; 
	 DefaultTableModel tableModel; 
	 
	//��־����ϵ����
	 protected JPanel logPan=new JPanel();
	 protected JLabel logLb=new JLabel("������־ ",SwingConstants.CENTER);
	 protected JTextArea logTa=new JTextArea(9,50); 
	 protected JScrollPane logSp=new JScrollPane(logTa); 
	 
	 /** ��ʾ����ѧ����� StuPan */ 
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
	 
	 /** ��ʾ���пͻ���� allStuPan */ 
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
	  
	  /** ����־��� log Pan �������־��Ϣ */ 
	  public void updateLog(String msg){ 
	    logTa.append(msg+"\n"); 
	  } 
	  
	  /** ���ѧ����� stuPan ���û������ ID */ 
	  public int getStuIdOnCustPan(){ 
		    try{ 
		        return Integer.parseInt(idTf.getText().trim()); 
		      }catch(Exception e){ 
		        updateLog(e.getMessage()); 
		        return -1; 
		      } 
		   } 
	  
	  /** ��õ���ѧ����� stuPan ���û������ѧ����Ϣ */ 
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
	 
	 /** ��ʾ�����ͻ���� stuPan �������пͻ���� allStuPan */ 
	  private void showCard(String cardStr){ 
	    card.show(cardPan,cardStr); 
	  } 
	  
	  /** ���췽�� */ 
	  public Gui_stu(){ 
	    buildDisplay(); 
	  } 
	  
	  /** ����ͼ�ν��� */ 
	  private void buildDisplay(){ 
	   frame=new JFrame("ѧ����Ϣ����ϵͳ"); 
	   buildSelectionPanel(); 
	   buildStuPanel(); 
	   buildAllStuPanel(); 
	   buildLogPanel(); 

	   /** carPan ���� CardLayout ���ֹ����������� stuPan ��
	   allStuPan ���ſ�Ƭ */ 
      cardPan.setLayout(card); 
      cardPan.add(stuPan,"student"); 
      cardPan.add(allStuPan,"allstudents"); 
      //���������м��������� 
      contentPane=frame.getContentPane(); 
      contentPane.setLayout(new BorderLayout()); 
      contentPane.add(cardPan,BorderLayout.CENTER); 
      contentPane.add(selPan,BorderLayout.NORTH); 
      contentPane.add(logPan,BorderLayout.SOUTH); 
      frame.pack(); 
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      frame.setVisible(true); 
	  }   
	  
	  /** ����ѡ����� selPan */  
	  private void buildSelectionPanel(){
		  selPan.add(stuBt);  
	      selPan.add(allStuBt);  
	  } 
	  
	  /** Ϊѡ����� selPan �е�������ťע������� */ 
	  public void addSelectionPanelListeners(ActionListener a[]){ 
	   int len=a.length; 
	   if(len!=2){ return;} 
	   stuBt.addActionListener(a[0]); 
	   allStuBt.addActionListener(a[1]); 
	  } 
	  
	  /**  ���������ͻ�stuPan ��� */ 
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
	   
	  /** Ϊ�����ͻ���� stuPan �е�6 ����ťע������� */ 
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

	  /** ��������ѧ�� allStuPan ��� */ 
	  private void buildAllStuPanel(){ 
	    allStuPan.setLayout(new BorderLayout()); 
	    allStuPan.add(allStuLb,BorderLayout.NORTH);
	    allStuTa.setText("all student display"); 
	    tableModel=new DefaultTableModel(tableHeaders,10); 
	    table=new JTable(tableModel); 
	    tablePane=new JScrollPane(table); 
	    allStuPan.add(tablePane,BorderLayout.CENTER); 
	    Dimension dim=new Dimension(500,150); 
	    table.setPreferredScrollableViewportSize(dim); //���ô˱��ӿڵ���ѡ��С��
	  } 
	   
	  /** ������־���*/ 
	  private void buildLogPanel(){
		logPan.setLayout(new BorderLayout());  
        logSp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        logSp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        logPan.add(logLb,BorderLayout.NORTH);  
        this.logPan.add(logSp,BorderLayout.CENTER);  } 
	


}
