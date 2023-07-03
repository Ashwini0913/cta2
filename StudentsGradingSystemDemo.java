package sdmce.cse.oop;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class IAMarksException extends Throwable {
	public String toString() {
		return "Invalid IA marks";
	}
}

class CTAMarksException extends Throwable {
	public String toString() {
		return "Invalid CTA Marks";
	}
}

class CIEMarksException extends Throwable {
	public String toString() {
		return "Student is detained from taking SEE";
	}
}

class SEEMarksException extends Throwable {
	public String toString() {
		return "F Grade";
	}
}

class StudentsGradingSystem extends JFrame implements ActionListener {
	Container contentPane;
	JButton b;
	JLabel lt, lg, lG, l1, l2, l3, l4, l5, l6;
	JTextField t1, t2, t3, t4, t5;
	JPanel p1, p2, p3, p4;

	public StudentsGradingSystem(String title) {
		super(title);
		contentPane = this.getContentPane();

		b = new JButton("Calculate");
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		lt = new JLabel("Total Marks");
		lg = new JLabel("Grade");
		lG = new JLabel("Grade Calculator");
		l1 = new JLabel("Enter IA-1 Marks");
		l2 = new JLabel("Enter IA-2 Marks");
		l3 = new JLabel("Enter IA-3 Marks");
		l4 = new JLabel("Enter CTA Marks");
		l5 = new JLabel("Enter SEE Marks");
		l6 = new JLabel("Note:If absent enter marks as 0");
		t1 = new JTextField(5);
		t2 = new JTextField(5);
		t3 = new JTextField(5);
		t4 = new JTextField(5);
		t5 = new JTextField(5);
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));

		p2.setLayout(new GridLayout(6, 2));
		//		p3.setPreferredSize(new Dimension(2,15));
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		p4.setLayout(new GridLayout(4, 1));
		p1.add(lG, BorderLayout.CENTER);

		p2.add(l1);
		p2.add(t1);
		p2.add(l2);
		p2.add(t2);
		p2.add(l3);
		p2.add(t3);
		p2.add(l4);
		p2.add(t4);
		p2.add(l5);
		p2.add(t5);
		p4.add(p3);
		p3.add(b);
		p4.add(lt);
		p4.add(lg);
		p4.add(l6);

		contentPane.setLayout(new BorderLayout());

		contentPane.add(p1, BorderLayout.NORTH);

		contentPane.add(p2, BorderLayout.CENTER);

		//	contentPane.add(p3, BorderLayout.SOUTH);
		contentPane.add(p4, BorderLayout.SOUTH);

		b.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		int c=calculate();
		if(c!=-1) {
		lt.setText("Total marks is"+c);
		lg.setText(grade(c));
	}
		else{
			lt.setText(" ");
			lg.setText(" ");
		}
		}
		

	int calculate() throws NumberFormatException {
		int ia1 = 0, ia2 = 0, ia3 = 0, cta = 0,see = 0,cie=0;
		try {
			

			ia1 = Integer.parseInt(t1.getText());
			ia2 = Integer.parseInt(t2.getText());
			ia3 = Integer.parseInt(t3.getText());
			cta = Integer.parseInt(t4.getText());
			see = Integer.parseInt(t5.getText());
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
		return -1;
		}
		if (ia1 < 0 || ia1 > 20 || ia2 < 0 || ia2 > 20 || ia3 < 0 || ia3 > 20) {
			JOptionPane.showMessageDialog(this, "Invalid IA marks", "Error", JOptionPane.ERROR_MESSAGE);
			return -1;
		}

		if (cta < 0 || cta > 10) {
			JOptionPane.showMessageDialog(this, "Invalid cta marks", "Error", JOptionPane.ERROR_MESSAGE);
			return -1;
		}
		
		else {
			
		
		int min = ia1;
		if (ia2 < min)
			min = ia2;
		else if (ia3 < min)
			min = ia3;
		else
			min = ia1;
		 cie = ia1 + ia2 + ia3 - min + cta;
		}
		if (cie < 20) {
			JOptionPane.showMessageDialog(this, "Student detained", "Error", JOptionPane.ERROR_MESSAGE);
			return -1;
		}
		else {
			if(see<38) {
	        	JOptionPane.showMessageDialog(this, "f grade", "Warning", JOptionPane.ERROR_MESSAGE);
	        	return -1;
	        }
        
		if (see == 38 || see == 39)
			see = 40;
		if(see%2==0)
			see = see / 2;
		else
			see=(see+1)/2;
		int total=cie + see;          
		return total ;
		}
	}

	String grade(int a) {
		if (a <= 100 && a >= 90)
			return "S";
		else if (a < 90 && a >= 80)
			return "A";
		else if (a < 80 && a >= 70)
			return "B";
		else if (a < 70 && a >= 60)
			return "C";
		else if (a < 60 && a >= 50)
			return "D";
		else if (a < 50 && a >= 40)
			return "E";
		else
			return "F";

	}
}


public class StudentsGradingSystemDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new StudentsGradingSystem("Students Grading System");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 400, 300);
		f.setVisible(true);
	}

}
