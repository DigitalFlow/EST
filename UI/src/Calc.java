import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Calc extends JFrame implements ActionListener{

	private JLabel resultField = new JLabel();
	private JButton Button0 = new JButton("0");	
	private JButton Button1 = new JButton("1");
	private JButton Button2 = new JButton("2");
	private JButton Button3 = new JButton("3");
	private JButton Button4 = new JButton("4");
	private JButton Button5 = new JButton("5");
	private JButton Button6 = new JButton("6");
	private JButton Button7 = new JButton("7");
	private JButton Button8 = new JButton("8");
	private JButton Button9 = new JButton("9");
	private JButton ButtonPlus = new JButton("+");
	private JButton ButtonMinus = new JButton("-");
	private JButton ButtonMul = new JButton("*");
	private JButton ButtonDiv = new JButton("/");
	private JButton ButtonEq = new JButton("=");
	
	
	public Calc()
	{
		super("Calc");

		Dimension size = new Dimension(500, 800);
		
		this.setSize(size);
		this.setLayout(new FlowLayout());
		
		
		resultField.setPreferredSize(new Dimension(size.width, 100));
		resultField.setOpaque(true);
		resultField.setBackground(Color.white);
		
		
		Button0.setPreferredSize(new Dimension(100, 100));
		Button1.setPreferredSize(new Dimension(100, 100));
		Button2.setPreferredSize(new Dimension(100, 100));
		Button3.setPreferredSize(new Dimension(100, 100));
		Button4.setPreferredSize(new Dimension(100, 100));
		Button5.setPreferredSize(new Dimension(100, 100));
		Button6.setPreferredSize(new Dimension(100, 100));
		Button7.setPreferredSize(new Dimension(100, 100));
		Button8.setPreferredSize(new Dimension(100, 100));
		Button9.setPreferredSize(new Dimension(100, 100));
		ButtonPlus.setPreferredSize(new Dimension(100, 100));
		ButtonMinus.setPreferredSize(new Dimension(100, 100));
		ButtonMul.setPreferredSize(new Dimension(100, 100));
		ButtonDiv.setPreferredSize(new Dimension(100, 100));
		ButtonEq.setPreferredSize(new Dimension(100, 100));
		
		Button0.addActionListener(this);
		Button1.addActionListener(this);
		Button2.addActionListener(this);
		Button3.addActionListener(this);
		Button4.addActionListener(this);
		Button5.addActionListener(this);
		Button6.addActionListener(this);
		Button7.addActionListener(this);
		Button8.addActionListener(this);
		Button9.addActionListener(this);
		ButtonPlus.addActionListener(this);
		ButtonMinus.addActionListener(this);
		ButtonMul.addActionListener(this);
		ButtonDiv.addActionListener(this);
		ButtonEq.addActionListener(this);
		
		this.add(resultField);
		this.add(Button0);
		this.add(Button1);
		this.add(Button2);
		this.add(Button3);
		this.add(Button4);
		this.add(Button5);
		this.add(Button6);
		this.add(Button7);
		this.add(Button8);
		this.add(Button9);
		this.add(ButtonPlus);
		this.add(ButtonMinus);
		this.add(ButtonMul);
		this.add(ButtonDiv);
		this.add(ButtonEq);
		
		this.setVisible(true);
		
	}
	
	public void actionPerformed (ActionEvent e){
        // Die Quelle wird mit getSource() abgefragt und mit den
        // Buttons abgeglichen. Wenn die Quelle des ActionEvents einer
        // der Buttons ist, wird der Text des JLabels entsprechend geändert
		
        if(e.getSource() == this.Button1){
            resultField.setText(resultField.getText() + "1");
        }
        else if(e.getSource() == this.Button2){
            resultField.setText(resultField.getText() + "2");
        }
        else if(e.getSource() == this.Button3){
            resultField.setText(resultField.getText() + "3");
        }
        else if(e.getSource() == this.Button4){
            resultField.setText(resultField.getText() + "4");
        }
        else if(e.getSource() == this.Button5){
            resultField.setText(resultField.getText() + "5");
        }
        else if(e.getSource() == this.Button6){
            resultField.setText(resultField.getText() + "6");
        }
        else if(e.getSource() == this.Button7){
            resultField.setText(resultField.getText() + "7");
        }
        else if(e.getSource() == this.Button8){
            resultField.setText(resultField.getText() + "8");
        }
        else if(e.getSource() == this.Button9){
            resultField.setText(resultField.getText() + "9");
        }
        else if(e.getSource() == this.Button0){
            resultField.setText(resultField.getText() + "0");
        }
        else if(e.getSource() == this.ButtonPlus){
            resultField.setText(resultField.getText() + "+");
        }
        else if(e.getSource() == this.ButtonMinus){
            resultField.setText(resultField.getText() + "-");
        }
        else if(e.getSource() == this.ButtonMul){
            resultField.setText(resultField.getText() + "*");
        }
        else if(e.getSource() == this.ButtonDiv){
            resultField.setText(resultField.getText() + "/");
        }
        else if(e.getSource() == this.ButtonEq){
            resultField.setText(this.Calculate(resultField.getText()));
        }
    }
	
	public String Calculate(String params)
	{
		String[] split = params.split("[0-9]+");
		
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(split));
		
		for(int i = 1; i < list.size(); i++)
		{
			if(list.size() < 3)
			{
				break;
			}
			
			String current = list.get(i);
			String previous = list.get(i-1);
			String next = list.get(i+1);
			
			System.out.println("Curr: " + current + ", Prev: " + previous + next);
			
			if(current == "*")
			{
				list.set(i, String.valueOf(Integer.parseInt(previous) * Integer.parseInt(next)));
				list.remove(i-1);
				list.remove(i+1);
			}
			else if(current == "/")
			{
				list.set(i, String.valueOf(Integer.parseInt(previous) / Integer.parseInt(next)));
				list.remove(i-1);
				list.remove(i+1);
			}
		}
		
		for(int i = 0; i < list.size(); i++)
		{
			if(list.size() < 3)
			{
				break;
			}
			
			String first = list.get(i);
			String next = list.get(i+1);
			String afterNext = list.get(i+2);
						
			if(next == "+")
			{
				list.set(i, String.valueOf(Integer.parseInt(first) + Integer.parseInt(afterNext)));
				list.remove(i+1);
				list.remove(i+2);
			}
			else if(next == "-")
			{
				list.set(i, String.valueOf(Integer.parseInt(first) - Integer.parseInt(afterNext)));
				list.remove(i+1);
				list.remove(i+2);
			}
		}
		
		return String.valueOf(list.get(0));
	}
	
	public static void main(String[] args) {
		Calc calc = new Calc();
	}
	
}
