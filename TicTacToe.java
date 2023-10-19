import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TicTacToe implements ActionListener
{
	private JFrame frame = new JFrame();
	
	private JPanel buttonPanel = new JPanel();
	private JButton[] button = new JButton[9];
	
	private JPanel textPanel = new JPanel();
	private JLabel textField = new JLabel();
	
	private JPanel timePanel = new JPanel();
	private JLabel timeField = new JLabel();

	private boolean playerTurn = true;
	private int numberTurns = 0;
	private boolean currentGame = true;
	private String endGame;
	private long startTime = System.currentTimeMillis();
	
	// TicTacToe constructor
	TicTacToe()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750, 750);
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setTitle("TicTacToe");
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		buttonPanel.setLayout(new GridLayout(3, 3));
		buttonPanel.setBackground(new Color(0, 0, 0));
		
		textPanel.setLayout(new BorderLayout());
		textPanel.setBounds(0, 0, 800, 100);
		
		timePanel.setLayout(new BorderLayout());
		timePanel.setBounds(0, 0, 800, 100);
		
		for(int i = 0; i < 9; i++)
		{
			button[i] = new JButton();
			buttonPanel.add(button[i]);
			button[i].setFont(new Font("Serif", Font.BOLD, 120));
			button[i].setFocusable(false);
			button[i].addActionListener(this);
			button[i].setBackground(Color.white);
		}
		
		textPanel.add(textField);
		frame.add(textPanel, BorderLayout.NORTH);
		
		timePanel.add(timeField);
		frame.add(timePanel, BorderLayout.SOUTH);
		
		frame.add(buttonPanel);
		gameInstance();
	}
	
	// Method functions as an instance of the game
	public void gameInstance()
	{
        try 
        {
        	textField.setText("Starting New Game...");
            Thread.sleep(1000);
            textField.setText("Player X turn.");
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        
		while(currentGame)
		{
			displayTimeEllapsed();
		}
		
        Object[] option={"Restart","Exit"};
        int n=JOptionPane.showOptionDialog(frame, "Game Over\n"+endGame,"Game Over", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
        if(n==0)
        {
            frame.dispose();
            new TicTacToe();
        }
        else
        {
            frame.dispose();
        }
	}
	
	// Method checks if conditions for winning have been met
	public void matchStatus()
	{
        if ((button[0].getText() == "X") && (button[1].getText() == "X") && (button[2].getText() == "X")) 
        {
            playerX(0, 1, 2);
        }
        else if ((button[0].getText() == "X") && (button[4].getText() == "X") && (button[8].getText() == "X")) 
        {
            playerX(0, 4, 8);
        }
        else if ((button[0].getText() == "X") && (button[3].getText() == "X") && (button[6].getText() == "X")) 
        {
            playerX(0, 3, 6);
        }
        else if ((button[1].getText() == "X") && (button[4].getText() == "X") && (button[7].getText() == "X")) 
        {
            playerX(1, 4, 7);
        }
        else if ((button[2].getText() == "X") && (button[4].getText() == "X") && (button[6].getText() == "X")) 
        {
            playerX(2, 4, 6);
        }
        else if ((button[2].getText() == "X") && (button[5].getText() == "X") && (button[8].getText() == "X")) 
        {
            playerX(2, 5, 8);
        }
       else if ((button[3].getText() == "X") && (button[4].getText() == "X") && (button[5].getText() == "X")) 
       {
            playerX(3, 4, 5);
        }
       else if ((button[6].getText() == "X") && (button[7].getText() == "X") && (button[8].getText() == "X")) 
       {
            playerX(6, 7, 8);
       }
        else if ((button[0].getText() == "O") && (button[1].getText() == "O") && (button[2].getText() == "O")) 
        {
            playerO(0, 1, 2);
        }
        else if ((button[0].getText() == "O") && (button[3].getText() == "O") && (button[6].getText() == "O")) 
        {
            playerO(0, 3, 6);
        }
        else if ((button[0].getText() == "O") && (button[4].getText() == "O") && (button[8].getText() == "O")) 
        {
            playerO(0, 4, 8);
        }
        else if ((button[1].getText() == "O") && (button[4].getText() == "O") && (button[7].getText() == "O")) 
        {
            playerO(1, 4, 7);
        }
        else if ((button[2].getText() == "O") && (button[4].getText() == "O") && (button[6].getText() == "O")) 
        {
            playerO(2, 4, 6);
        }
        else if ((button[2].getText() == "O") && (button[5].getText() == "O") && (button[8].getText() == "O")) 
        {
            playerO(2, 5, 8);
        }
        else if ((button[3].getText() == "O") && (button[4].getText() == "O") && (button[5].getText() == "O")) 
        {
            playerO(3, 4, 5);
        } else if ((button[6].getText() == "O") && (button[7].getText() == "O") && (button[8].getText() == "O")) 
        {
            playerO(6, 7, 8);
        }
        else if(numberTurns==9) 
        {
        	endGame = "Draw!";
            currentGame = false;
        }

	}
	// Method to print that Player X wins
    public void playerX(int mark1, int mark2, int mark3) 
    {
    	button[mark1].setBackground(Color.BLACK);
        button[mark2].setBackground(Color.BLACK);
        button[mark3].setBackground(Color.BLACK);

        for (int i = 0; i < 9; i++) 
        {
            button[i].setEnabled(false);
        }
        endGame = "Player X Wins";
        currentGame = false;
    }

    // Method to print that Player O wins
    public void playerO(int mark1, int mark2, int mark3) 
    {
        button[mark1].setBackground(Color.RED);
        button[mark2].setBackground(Color.RED);
        button[mark3].setBackground(Color.RED);

        for (int i = 0; i < 9; i++) 
        {
            button[i].setEnabled(false);
        }
        endGame = "Player O Wins";
        currentGame = false;
    }
    
    // Method for performing action after every turn
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        for (int i = 0; i < 9; i++) 
        {
            if (e.getSource() == button[i]) 
            {
                if (playerTurn) 
                {
                    if (button[i].getText() == "") 
                    {
                    	textField.setText("Player O turn.");
                        button[i].setForeground(Color.BLACK);
                        button[i].setText("X");
                        playerTurn = false;
                        numberTurns++;
                        matchStatus();
                    }
                } 
                else 
                {
                    if (button[i].getText() == "") 
                    {
                    	textField.setText("Player X turn.");
                        button[i].setForeground(Color.RED);
                        button[i].setText("O");
                        playerTurn = true;
                        numberTurns++;
                        matchStatus();
                    }
                }
            }
        }
    }
    
    public void displayTimeEllapsed()
    {
    	long timeLimit = 302000;
    	long minutesToMillis = 60000;
    	long secondsToMillis = 1000;
        long ellapsedTime = (System.currentTimeMillis() - startTime);
        
        if((ellapsedTime < timeLimit))
        {
        	long minutes = (timeLimit - ellapsedTime) / minutesToMillis;
        	String minutesString = String.valueOf(minutes);
        	
        	long seconds = ((timeLimit - ellapsedTime) - (minutes * minutesToMillis)) 
        			/ secondsToMillis;
        	String secondsString = String.valueOf(seconds);
        	if(secondsString.length() < 2)
        	{
        		secondsString = "0" + secondsString;
        	}
        	
        	timeField.setText("Time Remaining: " + minutesString + " : " +
        			secondsString);
        }else
        {
        	currentGame = false;
        	endGame = "Time's Over";
        }
    }
}