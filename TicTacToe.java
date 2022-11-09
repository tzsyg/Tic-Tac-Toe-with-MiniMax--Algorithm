import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener {
    MiniMax miniMax = new MiniMax();
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    String player = "O";
    String ai = "X";
    boolean player1_turn = false;

    //The board set-up
    TicTacToe()
    {
        ImageIcon img = new ImageIcon("C:\\Users\\Dom\\Downloads\\tictactoe.png");
        frame.setIconImage(img.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(255,255,255));
        textfield.setFont(new Font("MV Boli", Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,600,70);

        button_panel.setLayout(new GridLayout(3,3));



        for(int i =0; i < 9;i++)
        {

            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(new Color(255,255,255));
            buttons[i].setForeground(new Color(0,0,0));


        }

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

    //Call of the function that draws who will start
        firstTurn();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0;i < 9; i++)
        {

            if(e.getSource() == buttons[i])
            {
                if(player1_turn)
                {
                    if(buttons[i].getText().equals(""))
                    {

                        buttons[i].setText(player);
                        player1_turn = false;
                        textfield.setText("X turn");
                        ai();
                        check();

                    }
                }
            }

        }

    }
    //Function responsible for picking the ai move
    public void ai()
    {
        buttons[miniMax.bestMove(buttons)].setText(ai);
        player1_turn = true;
        textfield.setText("O turn");

    }
    //Function that draws who will start
    public void firstTurn()
    {
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        if(random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("O turn");
        }
        else
        {
            player1_turn = false;
            textfield.setText("X turn");
            ai();
        }
    }
    //Checking if anybody has won
    public void check()
    {
        //For tie
        int counter=0;
        for(int i =0; i < 9;i++)
        {

            if(!buttons[i].getText().equals(""))
            {
                counter++;
            }

        }

        if(counter == 9)
        {
            tie();
        }
        //Check Horizontally for X
        if(buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")){
            xWins(0,1,2);
        }
        else if (buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X")){
            xWins(3,4,5);
        }
        else if (buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X")){
            xWins(6,7,8);
        }//Check Diagonally for X
        else if (buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X")) {
            xWins(0,3,6);
        }
        else if (buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")) {
            xWins(1,4,7);
        }
        else if (buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")){
            xWins(2,5,8);
        }//Bias check for X
        else if (buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X")) {
            xWins(0,4,8);
        }
        else if (buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X")) {
            xWins(2,4,6);
        }
        //Check Horizontally for O
        else if(buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")) {
            oWins(0,1,2);
        }
        else if (buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O")) {
            oWins(3,4,5);
        }
        else if (buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O")){
            oWins(6,7,8);
        }//Check Diagonally for X
        else if (buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O")) {
            oWins(0,3,6);
        }
        else if (buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O")) {
            oWins(1,4,7);
        }
        else if (buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")){
            oWins(2,5,8);
        }//Bias check for X
        else if (buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O")) {
            oWins(0,4,8);
        }
        else if (buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O")) {
            oWins(2,4,6);
        }


    }
    //Setting board UI for X Win
    public void xWins(int a, int b, int c)
    {
        buttons[a].setBackground(new Color(0,0,0));
        buttons[b].setBackground(new Color(0,0,0));
        buttons[c].setBackground(new Color(0,0,0));

        for(int i = 0;i < 9; i++)
        {


            buttons[i].setForeground(new Color(255,255,255));



        }
        textfield.setText("X WINS");
    }
    //Setting board UI for O Win
    public void oWins(int a, int b, int c)
    {
        buttons[a].setBackground(new Color(0,0,0));
        buttons[b].setBackground(new Color(0,0,0));
        buttons[c].setBackground(new Color(0,0,0));
        for(int i = 0;i < 9; i++)
        {
            //buttons[i].setEnabled(false);
            buttons[i].setForeground(new Color(255,255,255));
        }
        textfield.setText("O WINS");

    }
    //Setting board UI for Tie
    public void tie()
    {
        for(int i =0;i<9;i++)
        {
            buttons[i].setBackground(Color.gray);
        }

        textfield.setText("TIE");

    }

}
