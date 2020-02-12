/******************************************************************************************************************
*Name : Mehul Kalsi, Vraj Patel, Anastasia Makhniaieva, Danny Collan, Yukti Vijay
*Course : CS170-02 
*Lab # GroupProject
*Submission Date : (11/24) at 10:00pm
*Brief Description: This is an operational class that builds a two panels, two labels, and four choices buttons.
* The question label prints the question and the choice button implements ImageIcon to display images. 
* We use actionEvent and actionListener for the right and wrong choice option.
**************************************************************************************************************** */ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JQuestionJar {
	protected static JPanel q5Panel;
	private static JLabel question;
	private static JLabel JarIcon;
	static JButton hint;
	static JButton choiceD;
	static JButton choiceW;
	static JButton choiceK;
	static JButton choiceJ;
	static JPanel choicesPanel;
	

	
	static JPanel build(){
		question = new JLabel("What letter does this picture start with?");
		question.setFont(new Font("Serif", Font.PLAIN,25));
		JarIcon = new JLabel();
		JarIcon.setIcon(new ImageIcon(new ImageIcon("image/cartoon-jar-of-preserve-vector-stock_k20783545.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
		
		choicesPanel = new JPanel();
		
		choiceD = new JButton(new ImageIcon("image/d.gif"));
		choiceW = new JButton(new ImageIcon("image/w.gif"));
		choiceK = new JButton(new ImageIcon("image/k.gif"));
		choiceJ = new JButton(new ImageIcon("image/j.gif"));
		hint = new JButton("HINT");
		choiceD.setPreferredSize(new java.awt.Dimension(150,150));
		choiceW.setPreferredSize(new java.awt.Dimension(150,150));
		choiceK.setPreferredSize(new java.awt.Dimension(150,150));
		choiceJ.setPreferredSize(new java.awt.Dimension(150,150));
		hint.setFont(new Font("Serif", Font.BOLD,10));
		//choiceP.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceL.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceX.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceO.setFont(new Font("Serif", Font.PLAIN, 50));
		choicesPanel.add(choiceD);
		choicesPanel.add(choiceW);
		choicesPanel.add(choiceK);
		choicesPanel.add(choiceJ);
		
		q5Panel = new JPanel();
		q5Panel.setPreferredSize(new Dimension(600,600));
		
		q5Panel.add(question);
		q5Panel.add(JarIcon);
		q5Panel.add(choicesPanel);
		q5Panel.setBackground(Color.MAGENTA );
		q5Panel.add(hint);
		
		choiceJ.addActionListener(new RightListener());
		choiceD.addActionListener(new WrongListener());
		choiceW.addActionListener(new WrongListener());
		choiceK.addActionListener(new WrongListener());
		hint.addActionListener(new HintListener());
		return q5Panel;
		
	}
	
	static  class HintListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(hint, "You can store Jam in here");
		}
	}
	static class RightListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null, "Correct!");
			ALFrame.totalScore += 1;
			ALFrame.totalScoreField.setText(Integer.toString(ALFrame.totalScore));
			ALFrame.count++;
			ALFrame.questionPanel.remove(q5Panel);
			ALFrame.PickQuestion();
			}
	}
	static class WrongListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e){
	JOptionPane.showMessageDialog(null, "Wrong");
	ALFrame.count++;  // count should now equal 2
	ALFrame.questionPanel.remove(q5Panel);
	ALFrame.PickQuestion();
	}
	}
	
	

}

