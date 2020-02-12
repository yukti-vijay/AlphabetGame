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


public class JQuestionGiraffe {
	protected static JPanel q5Panel;
	private static JLabel question;
	private static JLabel GiraffeIcon;
	static JButton hint;
	static JButton choiceG;
	static JButton choiceK;
	static JButton choiceT;
	static JButton choiceQ;
	static JPanel choicesPanel;
	

	
	static JPanel build(){
		question = new JLabel("What letter does this picture start with?");
		question.setFont(new Font("Serif", Font.PLAIN,25));
		GiraffeIcon = new JLabel();
		GiraffeIcon.setIcon(new ImageIcon(new ImageIcon("image/giraffe-clip-art-giraffe.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
		
		choicesPanel = new JPanel();
		
		choiceG = new JButton(new ImageIcon("image/g.gif"));
		choiceK = new JButton(new ImageIcon("image/k.gif"));
		choiceT = new JButton(new ImageIcon("image/t.gif"));
		choiceQ = new JButton(new ImageIcon("image/q.gif"));
		hint = new JButton("HINT");
		choiceG.setPreferredSize(new java.awt.Dimension(150,150));
		choiceK.setPreferredSize(new java.awt.Dimension(150,150));
		choiceT.setPreferredSize(new java.awt.Dimension(150,150));
		choiceQ.setPreferredSize(new java.awt.Dimension(150,150));
		hint.setFont(new Font("Serif", Font.BOLD,10));
		//choiceP.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceL.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceX.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceO.setFont(new Font("Serif", Font.PLAIN, 50));
		choicesPanel.add(choiceQ);
		choicesPanel.add(choiceK);
		choicesPanel.add(choiceT);
		choicesPanel.add(choiceG);
		
		q5Panel = new JPanel();
		q5Panel.setPreferredSize(new Dimension(600,600));
		
		q5Panel.add(question);
		q5Panel.add(GiraffeIcon);
		q5Panel.add(choicesPanel);
		q5Panel.setBackground(Color.MAGENTA );
		q5Panel.add(hint);
		
		choiceG.addActionListener(new RightListener());
		choiceK.addActionListener(new WrongListener());
		choiceT.addActionListener(new WrongListener());
		choiceQ.addActionListener(new WrongListener());
		hint.addActionListener(new HintListener());
		return q5Panel;
		
	}
	
	static  class HintListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(hint, "This animal has a really tall neck");
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


