import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	
public class GetName1 extends JPanel {

	protected static JPanel g1Panel;
	private static JLabel prompt;
	static JTextField nameField;
	static String name;
	static JButton submitNameButton;
	static JLabel nameLabel;

		
		
		
	static JPanel build(){
			
			prompt = new JLabel("Enter your first name:");
			nameField = new JTextField(20);
			
			
			
			submitNameButton = new JButton();//Begin the Game!");
			submitNameButton.addActionListener(new submitListener());
			submitNameButton.setIcon(new ImageIcon("Image/play_button.gif"));
			submitNameButton.setPreferredSize(new java.awt.Dimension(100,50));

			
			g1Panel = new JPanel();
			g1Panel.setPreferredSize(new Dimension(600, 300));
			
			g1Panel.add(prompt);
			g1Panel.add(nameField);
			g1Panel.add(submitNameButton);
			g1Panel.setBackground(Color.CYAN);
			return g1Panel;
			
		}
		
	static class submitListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e){
			name = nameField.getText();
			
			ALFrame.questionPanel.remove(g1Panel);
			ALFrame.count = 1;
			ALFrame.PickQuestion();
			}
	}	

}



