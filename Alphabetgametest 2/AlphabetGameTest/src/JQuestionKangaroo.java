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
import java.net.*;

public class JQuestionKangaroo {
	protected static JPanel q4Panel;
	private static JLabel question;
	private static JLabel KangarooIcon;
	static JButton hint;
	static JButton choiceZ;
	static JButton choiceC;
	static JButton choiceH;
	static JButton choiceK;
	static JPanel choicesPanel;
	

	
	static JPanel build(){
		question = new JLabel("What letter does this picture start with? Hint: it's a pet.");
		question.setFont(new Font("Serif", Font.PLAIN,25));
		KangarooIcon = new JLabel();
		KangarooIcon.setIcon(new ImageIcon(new ImageIcon("image/kangaroo.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));

		choicesPanel = new JPanel();
		
		choiceZ = new JButton(new ImageIcon("image/z.gif"));
		choiceC = new JButton(new ImageIcon("image/c.gif"));
		choiceH = new JButton(new ImageIcon("image/h.gif"));
		choiceK = new JButton(new ImageIcon("image/k.gif"));
		hint = new JButton("HINT");
		choiceZ.setPreferredSize(new java.awt.Dimension(150,150));
		choiceC.setPreferredSize(new java.awt.Dimension(150,150));
		choiceH.setPreferredSize(new java.awt.Dimension(150,150));
		choiceK.setPreferredSize(new java.awt.Dimension(150,150));
		hint.setFont(new Font("Serif", Font.BOLD,10));
		//choiceZ.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceC.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceH.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceO.setFont(new Font("Serif", Font.PLAIN, 50));
		choicesPanel.add(choiceZ);
		choicesPanel.add(choiceC);
		choicesPanel.add(choiceH);
		choicesPanel.add(choiceK);
		
		q4Panel = new JPanel();
		q4Panel.setPreferredSize(new Dimension(600, 600));
		q4Panel.add(question);
		q4Panel.add(KangarooIcon);
		q4Panel.add(choicesPanel);
		q4Panel.add(hint);
		q4Panel.setBackground(Color.MAGENTA );

		choiceC.addActionListener(new WrongListener());
		choiceZ.addActionListener(new WrongListener());
		choiceH.addActionListener(new WrongListener());
		choiceK.addActionListener(new RightListener());
		hint.addActionListener(new HintListener());
		return q4Panel;
		
	}
	static  class HintListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(hint, "It's animal from australia that is known for jumping");
		}
	}
	static class RightListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null, "Correct!");
			ALFrame.totalScore += 1;
			ALFrame.totalScoreField.setText(Integer.toString(ALFrame.totalScore));
			ALFrame.count++;
			ALFrame.questionPanel.remove(q4Panel);
			ALFrame.PickQuestion();
			}
	}
	static class WrongListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e){
	JOptionPane.showMessageDialog(null, "Wrong");
	ALFrame.count++;  // count should now equal 2
	ALFrame.questionPanel.remove(q4Panel);
	ALFrame.PickQuestion();
	}
	}

}
