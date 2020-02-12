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
//decleration
public class JQuestionIgloo {
	protected static JPanel q1Panel;
	private static JLabel question;
	private static JLabel IglooIcon;
	static JButton hint;
	static JButton choiceJ;
	static JButton choiceI;
	static JButton choiceG;
	static JButton choiceA;
	static JPanel choicesPanel;
	
//build panels
	
	static JPanel build(){
		question = new JLabel("What letter does this picture start with?");
		question.setFont(new Font("Serif", Font.PLAIN,25));
		IglooIcon = new JLabel();
		IglooIcon.setIcon(new ImageIcon(new ImageIcon("image/Igloo.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));

		
		choicesPanel = new JPanel();
		
		choiceJ = new JButton(new ImageIcon("image/j.gif"));
		choiceI = new JButton(new ImageIcon("image/i.gif"));
		choiceG = new JButton(new ImageIcon("image/g.gif"));
		choiceA = new JButton(new ImageIcon("image/a.gif"));
		hint = new JButton("HINT");
		choiceJ.setPreferredSize(new java.awt.Dimension(150,150));
		choiceI.setPreferredSize(new java.awt.Dimension(150,150));
		choiceG.setPreferredSize(new java.awt.Dimension(150,150));
		choiceA.setPreferredSize(new java.awt.Dimension(150,150));
		hint.setFont(new Font("Serif", Font.BOLD,10));

		//choiceJ.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceI.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceG.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceO.setFont(new Font("Serif", Font.PLAIN, 50));
		choicesPanel.add(choiceJ);
		choicesPanel.add(choiceI);
		choicesPanel.add(choiceG);
		choicesPanel.add(choiceA);
		//add panels
		q1Panel = new JPanel();
		q1Panel.setPreferredSize(new Dimension(600, 600));
		q1Panel.setBackground(Color.MAGENTA );

		q1Panel.add(question);
		q1Panel.add(IglooIcon);
		q1Panel.add(choicesPanel);
		q1Panel.add(hint);
		
		choiceI.addActionListener(new RightListener());
		choiceJ.addActionListener(new WrongListener());
		choiceG.addActionListener(new WrongListener());
		choiceA.addActionListener(new WrongListener());
		hint.addActionListener(new HintListener());
		return q1Panel;
		
	}
	
	static  class HintListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(hint, "Made of ice and most often found in cold places");
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
