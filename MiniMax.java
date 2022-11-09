import javax.swing.*;

public class MiniMax{
    String player = "O";
    String ai = "X";

    // Evaluate every legal move on the board and return the best one.
    public Integer bestMove(JButton[] buttons) {
        int bestScore = -999;
        int bestMove = 0;

        for (int i = 0; i < 9; i++) {
            //Is the spot available
            if (buttons[i].getText().equals("")) {
                buttons[i].setText(ai);
                int score = minimax(buttons,+1, false);
                buttons[i].setText("");
                if (score > bestScore) {
                    bestScore = score;
                    bestMove = i;
                }
            }
        }

        return bestMove;
    }

    public Integer scores(Integer result) {

    //Returning values depending on the player
        if (result == 1) {
            //For ai win
            return 10;
        } else if (result == 0) {
            //For o win
            return -10;
        } else {
            //Tie
            return 0;
        }

    }
    //Main MiniMax function
    public Integer minimax(JButton[] buttons,int depth, Boolean isMaximizing) {

        int result = checkWinner(buttons);

        if (result != 2 || depth == 6) {
            int score = scores(result);
            return score;
        }
    // Maximising player, find the maximum attainable value.
        if (isMaximizing) {
            int bestScore = -999;
            for (int i = 0; i < 9; i++) {
                //Is the spot available
                if (buttons[i].getText().equals("")) {

                    buttons[i].setText("X");
                    int score = minimax(buttons,+1, false);
                    buttons[i].setText("");

                    if (score > bestScore) {
                        bestScore = score;
                    }
                }
            }
            return bestScore;
            // Minimising player, find the minimum attainable value;
        } else {
            int bestScore = 999;
            for (int i = 0; i < 9; i++) {
                //Is the spot available
                if (buttons[i].getText().equals("")) {
                    buttons[i].setText("O");
                    int score = minimax(buttons, + 1, true);
                    buttons[i].setText("");
                    if (score < bestScore) {
                        bestScore = score;
                    }

                }

            }
            return bestScore;
        }
    }
    //Checking if anybody has won
    public Integer checkWinner(JButton[] buttons) {
        //(1) For X win
        //(0) For O win
        //(2) Nobody wins
        //(3) For tie

        int counter = 0;
        for (int i = 0; i < 9; i++) {
            if (!buttons[i].getText().equals("")) {
                counter++;
            }
        }

        if (counter == 9) {
            return 3;
        }
        //Check Horizontally for X
        if (buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")) {
            return 1;
        } else if (buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X")) {
            return 1;
        } else if (buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X")) {
            return 1;
        }//Check Diagonally for X
        else if (buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X")) {
            return 1;
        } else if (buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")) {
            return 1;
        } else if (buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")) {
            return 1;
        }//Bias check for X
        else if (buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X")) {
            return 1;
        } else if (buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X")) {
            return 1;
        }//Check Horizontally for O
        else if (buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")) {
            return 0;
        } else if (buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O")) {
            return 0;
        } else if (buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O")) {
            return 0;
        }//Check Diagonally for O
        else if (buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O")) {
            return 0;
        } else if (buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O")) {
            return 0;
        } else if (buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")) {
            return 0;
        }//Bias check for O
        else if (buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O")) {
            return 0;
        } else if (buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O")) {
            return 0;
        }//Nobody wins
        else {
            return 2;
        }
    }
}
