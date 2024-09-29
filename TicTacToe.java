import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe implements ActionListener{
	
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textField = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1Turn;
	
	TicTacToe(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,700);
		frame.getContentPane().setBackground(new Color(50,50,50));  //must include getContentPane() change the color of frame.
		frame.setLayout(new BorderLayout());
		
		textField.setText("Tic Tac Toe");
		textField.setFont(new Font("Ink Free",Font.BOLD,70));
		textField.setPreferredSize(new Dimension(100,110));
		textField.setBackground(new Color(25,25,25));
		textField.setForeground(new Color(25,255,0));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setOpaque(true);
		
		title_panel.setBounds(0, 0, 800, 100);
		title_panel.setLayout(new BorderLayout());   //layout type doesn't matter
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));  //just for checking existence
		
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,110));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}

		title_panel.add(textField);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		firstTurn();
	}
	void firstTurn(){
		
		try {
			Thread.sleep(000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		if(random.nextInt(2)==0) {     //provide random integer 0 or 1
			player1Turn = true;        //0 as player one(O)
			textField.setText("O turn");
		}
		else {
			player1Turn = false;        //1 as player two(X)
			textField.setText("X turn");
		}
			
	}
	void check() {
		//o wins condition - there are 8 possible combination
		if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")) {
			oWins(0,1,2);
		}
		if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")) {
			oWins(3,4,5);
		}
		if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")) {
			oWins(6,7,8);
		}
		if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")) {
			oWins(0,3,6);
		}
		if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")) {
			oWins(1,4,7);
		}
		if((buttons[2].getText()=="O") && (buttons[6].getText()=="O") && (buttons[8].getText()=="O")) {
			oWins(2,6,8);
		}
		if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")) {
			oWins(0,4,8);
		}
		if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")) {
			oWins(2,4,6);
		}
		
		
		//x wins condition
		if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")) {
			xWins(0,1,2);
		}
		if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")) {
			xWins(3,4,5);
		}
		if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")) {
			xWins(6,7,8);
		}
		if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")) {
			xWins(0,3,6);
		}
		if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")) {
			xWins(1,4,7);
		}
		if((buttons[2].getText()=="X") && (buttons[6].getText()=="X") && (buttons[8].getText()=="X")) {
			xWins(2,6,8);
		}
		if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")) {
			xWins(0,4,8);
		}
		if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")) {
			xWins(2,4,6);
		}
	}
	void oWins(int x,int y, int z) {
			textField.setText("O wins");
			buttons[x].setBackground(Color.GREEN);
			buttons[y].setBackground(Color.GREEN);
			buttons[z].setBackground(Color.GREEN);
			for(int i=0;i<9;i++) {
				buttons[i].setEnabled(false);
			}
	}
	void xWins(int x,int y, int z) {
			textField.setText("X wins");
			buttons[x].setBackground(Color.GREEN);
			buttons[y].setBackground(Color.GREEN);
			buttons[z].setBackground(Color.GREEN);
			for(int i=0;i<9;i++) {
				buttons[i].setEnabled(false);
			}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<9;i++) {   
			if(e.getSource() == buttons[i] ) {
				if(player1Turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						textField.setText("X Turn");
						player1Turn = false;
						check();
					}					
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						textField.setText("O Turn");
						player1Turn = true;
						check();
					}	
				}
			}
		}
		
	}
}
