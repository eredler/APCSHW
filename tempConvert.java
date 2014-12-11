import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tempConvert extends JFrame implements ActionListener {
  
  private Container pane;
  private JTextField input;
  private JButton FtoC, CtoF;
  private JButton convert, clear;
  private JLabel answer;

  public GuiTempConvert() {
    this.setTitle("Temperature Converter");
    this.setSize(500, 500);
    this.setLocation(100, 100);
    this.setResizable(false);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    pane.setLayout(new FlowLayout());
    
    FtoC = new JButton("Fahrenheit to Celcius");
    CtoF = new JButton("Celcius to Fahrenheit");
    input = new JTextField(10);
    answer = new JLabel("",null,JLabel.center);
    
    FtoC.setActionCommand("FtoC");
	  FtoC.addActionListener(this);
  	CtoF.setActionCommand("CtoF");
  	CtoF.addActionListener(this);
    
    pane.add(input);
  	pane.add(FtoC);
  	pane.add(CtoF);
  	pane.add(answer);
  }

  public void actionPerformed(ActionEvent e) {
    String action = e.getActionCommand();
  	if (action.equals("FtoC")){
	  	String s = panel.getText();
	  	int num = Integer.parseInt(s);
  		double ans = num;
  		ans = (ans-32)*5/9;
	  	result.setText(""+ans);
  	}
	    
  	if (action.equals("CtoF")){
	    String s = input.getText();
	    int num = Integer.parseInt(s);
	    double ans = num;
	    ans = ans * 9/5 + 32;
	    result.setText(""+ans);		  
  	} 
  }
  
  
 public static void main(String[] args) {
        GuiTempConvert x = new GuiTempConvert();
        x.setVisible(true);
   }
  }   

