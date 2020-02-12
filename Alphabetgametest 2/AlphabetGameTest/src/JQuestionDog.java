import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JQuestionDog {
	protected static JPanel q5Panel;
	private static JLabel question;
	private static JLabel DogIcon;
	static JButton hint;
	static JButton choiceD;
	static JButton choiceN;
	static JButton choiceO;
	static JButton choiceX;
	static JPanel choicesPanel;
	

	
	static JPanel build(){
		question = new JLabel("What letter does this picture start with?");
		question.setFont(new Font("Serif", Font.PLAIN,25));
		DogIcon = new JLabel();
		DogIcon.setIcon(new ImageIcon(new ImageIcon("image/dog-waiting-to-walk-clipart-vector-11958061.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
		
		choicesPanel = new JPanel();
		
		choiceD = new JButton(new ImageIcon("image/d.gif"));
		choiceN = new JButton(new ImageIcon("image/n.gif"));
		choiceO = new JButton(new ImageIcon("image/o.gif"));
		choiceX = new JButton(new ImageIcon("image/x.gif"));
		hint = new JButton("HINT");
		choiceD.setPreferredSize(new java.awt.Dimension(150,150));
		choiceN.setPreferredSize(new java.awt.Dimension(150,150));
		choiceO.setPreferredSize(new java.awt.Dimension(150,150));
		choiceX.setPreferredSize(new java.awt.Dimension(150,150));
		hint.setFont(new Font("Serif", Font.BOLD,10));
		//choiceP.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceL.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceX.setFont(new Font("Serif", Font.PLAIN, 50));
		//choiceO.setFont(new Font("Serif", Font.PLAIN, 50));
		choicesPanel.add(choiceD);
		choicesPanel.add(choiceN);
		choicesPanel.add(choiceO);
		choicesPanel.add(choiceX);
		
		q5Panel = new JPanel();
		q5Panel.setPreferredSize(new Dimension(600,600));
		
		q5Panel.add(question);
		q5Panel.add(DogIcon);
		q5Panel.add(choicesPanel);
		q5Panel.setBackground(Color.MAGENTA );
		q5Panel.add(hint);
		
		choiceD.addActionListener(new RightListener());
		choiceN.addActionListener(new WrongListener());
		choiceO.addActionListener(new WrongListener());
		choiceX.addActionListener(new WrongListener());
		hint.addActionListener(new HintListener());
		return q5Panel;
		
	}
	
	static  class HintListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(hint, "Its an animal that loves to play fetch");
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

