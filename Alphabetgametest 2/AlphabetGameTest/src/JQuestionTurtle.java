/******************************************************************************************************************
*Name : Mehul Kalsi, Vraj Patel, Anastasia Makhniaieva, Danny Collan, Yukti Vijay
*Course : CS170-02 
*Lab # GroupProject
*Submission Date : (11/24) at 10:00pm
*Brief Description: This is an operational class that builds a two panels, two labels, and four choices buttons.
* The question label prints the question and the choice button implements ImageIcon to display images. 
* We use actionEvent and actionListener for the right and wrong choice option.
**************************************************************************************************************** */ 

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;




public class JQuestionTurtle {
	protected static JPanel q1Panel;
	private static JLabel question;
	private static JLabel TurtleIcon;
	static JButton hint;
	static JButton choice1;
	static JButton choice2;
	static JButton choice3;
	static JButton choice4;
	static JPanel choicesPanel;
	
	static JPanel build(){
		question = new JLabel("What letter does this word start with?");
		question.setFont(new Font("Serif", Font.PLAIN,20));
		TurtleIcon = new JLabel();
		TurtleIcon.setIcon(new ImageIcon(new ImageIcon("image/Turtle-.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));

		choicesPanel = new JPanel();
		hint = new JButton("HINT");
		choice1 = new JButton(new ImageIcon("image/t.gif"));
		choice2 = new JButton(new ImageIcon("image/r.gif"));
		choice3 = new JButton(new ImageIcon("image/u.gif"));
		choice4 = new JButton(new ImageIcon("image/h.gif"));
		
		choice1.setPreferredSize(new java.awt.Dimension(150, 150));
		choice2.setPreferredSize(new java.awt.Dimension(150, 150));
		choice3.setPreferredSize(new java.awt.Dimension(150, 150));
		choice4.setPreferredSize(new java.awt.Dimension(150, 150));
		
		choicesPanel.add(choice1);
		choicesPanel.add(choice2);
		choicesPanel.add(choice3);
		choicesPanel.add(choice4);
		
		q1Panel = new JPanel();
		q1Panel.setPreferredSize(new Dimension(600, 600));
		q1Panel.setBackground(Color.MAGENTA );
		q1Panel.add(question);
		q1Panel.add(TurtleIcon);
		q1Panel.add(choicesPanel);
		q1Panel.add(hint);

		choice1.addActionListener(new RightListener());
		choice2.addActionListener(new WrongListener());
		choice3.addActionListener(new WrongListener());
		choice4.addActionListener(new WrongListener());
		hint.addActionListener(new HintListener());

		return q1Panel;
		
	}
	
	static  class HintListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(hint, "Hint: It has a shell on its back.");
		}
	}
	
	static class RightListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null, "Correct!");
			ALFrame.totalScore += 1;
			ALFrame.totalScoreField.setText(Integer.toString(ALFrame.totalScore));
			ALFrame.count++;
			ALFrame.questionPanel.remove(q1Panel);
			ALFrame.PickQuestion();
			}
	}
	static class WrongListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e){
	JOptionPane.showMessageDialog(null, "Wrong");
	ALFrame.count++;  // count should now equal 2
	ALFrame.questionPanel.remove(q1Panel);
	ALFrame.PickQuestion();
	}
	}

}
