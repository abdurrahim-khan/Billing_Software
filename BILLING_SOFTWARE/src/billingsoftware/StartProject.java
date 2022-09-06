package billingsoftware;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

class StartProject {
	int delay = 100;
	int i =1;
	JFrame jf;
	JPanel jp;
	int a =0;
	JLabel jl6;
	Timer t = new Timer(delay, new ActionListener()
	 {
		
		@Override
			public void actionPerformed(ActionEvent e) 
		{
				// TODO Auto-generated method stub
			 
			
		        jpb.setValue(i);
		        
		        if(i == 20)
		        {
		        	jl6.setText("Loading the program");
		        }
		        if(i == 40)
		        {
		        	jl6.setText("Loading the modules");
		        }
		        if(i == 60)
		        {
		        	jl6.setText("Organising for you");
		        }
		        if (i == 80)
		        {
		        	jl6.setText("Get Ready");
		        }
		        if(i == 90)
		        {
		        	jl6.setText("There you go");
		        }
		        
		        if(i == 101)
		        {
		        	t.stop();
		        	
		        	LoginPage lp = new LoginPage();
		        	lp.jf.setVisible(true);
		        	jf.setVisible(false);
		        }
		        
		        i++;;
		}
			
	 });
	JProgressBar jpb;
	public StartProject()
	{
		createFrame();
		t.start();
	}
	
	
	
	private void createFrame()
	{
		
		jf = new JFrame();
		jf.setSize(600,500);
		jf.setBounds(400,75,600,500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setUndecorated(true);
		
		jp = new JPanel();
		jp.setSize(600,500);
		jf.add(jp);
		jp.setBackground(Color.MAGENTA);
		jp.setLayout(null);
		
		JLabel jlp = new JLabel("");
		jlp.setIcon(new ImageIcon("C:\\Users\\micro\\Desktop\\myimage.png"));
		jlp.setBounds(5,100,250,300);
		jlp.setSize(300,300);
		jp.add(jlp);
		JLabel jl0 = new JLabel("CREATED BY ABDURRAHIM");
		jl0.setBounds(425,10,300,25);
		jl0.setForeground(Color.WHITE);
		jp.add(jl0);
		JLabel jl1 = new JLabel("BILLING");
		jl1.setBounds(335,200,300,100);
		jl1.setFont(new Font("Arial",Font.BOLD,42));
		jl1.setForeground(Color.WHITE);
		jp.add(jl1);
		JLabel jl2 = new JLabel("SOFTWARE");
		jl2.setBounds(300,250,300,100);
		jl2.setFont(new Font("Arial",Font.BOLD,42));
		jl2.setForeground(Color.WHITE);
		jp.add(jl2);
		jpb = new JProgressBar();
		jpb.setBounds(10, 450, 579, 15);
		jpb.setStringPainted(true);
		jpb.setForeground(Color.RED);
		jp.add(jpb);
		
		jl6 = new JLabel("Initialising");
		jl6.setBounds(10,430,300,20);
		jl6.setForeground(Color.WHITE);
		jp.add(jl6);
	}
}
