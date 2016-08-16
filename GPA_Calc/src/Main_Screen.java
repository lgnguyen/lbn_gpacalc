import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
//import java.awt.GraphicsEnvironment;

public class Main_Screen extends JFrame{
	public static void main(String[] args){
		Main_Screen start = new Main_Screen();
//		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
//		for(int i = 0; i < fonts.length; i++)
//			System.out.println(fonts[i]);
	}
	public Main_Screen(){
		setSize(500,300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("GPA Calculator v1.0");
		
//		List<Screen> screens = new ArrayList<Screen>();
		
		//initialize screens and data needed
		Screen home = new Screen();
		Screen inputGrades = new Screen();
		home.setOtherScreen(inputGrades);
		inputGrades.setOtherScreen(home);
		home.setFrame(this);
		inputGrades.setFrame(this);
		
		//setup the home screen
		home.setLayout(new BorderLayout());
		JPanel hButtons = new JPanel();
		hButtons.add(new CalculateButton("Calculate GPA"));
		hButtons.add(new EditButton("Edit Grades", inputGrades, home, this));
		hButtons.setBackground(Color.LIGHT_GRAY);
		home.add(hButtons, BorderLayout.SOUTH);
		JTextArea homeText = new JTextArea("Welcome to the GPA Calculator!"
				+ "\n- Click the 'Edit Grades' button to enter in or edit your"
				+ "\nsemester grades"
				+ "\n- Click the 'Calculate GPA' button to get your overall GPA");
		homeText.setEditable(false);
		homeText.setBackground(Color.LIGHT_GRAY);
		homeText.setFont(new Font("Myanmar Text", Font.PLAIN, 19));
		homeText.setLineWrap(true);
		home.add(homeText, BorderLayout.CENTER);
		add(home);
		
		//setup the input grades screen
		inputGrades.setLayout(new BorderLayout());
		JPanel gButtons = new JPanel();
//		gButtons.add(new SaveButton("Save Grades"));
		gButtons.add(new JButton("Save Grades"));
		gButtons.setBackground(Color.LIGHT_GRAY);
		inputGrades.add(gButtons, BorderLayout.SOUTH);
		JPanel input = new JPanel();
		input.setLayout(new GridLayout(9,12));
		input.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		input.setBackground(Color.LIGHT_GRAY);
		input.add(new JLabel("Sem. 1"));
		input.add(new JLabel("Sem. 2"));
		input.add(new JLabel("Sem. 1"));
		input.add(new JLabel("Sem. 2"));
		input.add(new JLabel("Sem. 1"));
		input.add(new JLabel("Sem. 2"));
		input.add(new JLabel("Sem. 1"));
		input.add(new JLabel("Sem. 2"));
		
		
		
		inputGrades.add(input, BorderLayout.CENTER);
		
		setVisible(true);
	}
}
