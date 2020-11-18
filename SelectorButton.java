package com.tictactoe;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class SelectorButton extends JButton implements ActionListener{
    ImageIcon X,O;
    byte value=0;


    // value represents the state of each button- 0:nothing, 1:X, 2:O

    public SelectorButton() {
        X = new ImageIcon(this.getClass().getResource("X.png"));
        O = new ImageIcon(this.getClass().getResource("O.png"));
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (TicTacToe.isPlayerTurn && value == 0) {
            value = 1;
            if (TicTacToe.isSinglePlayer){
                Random rand = new Random();
                int randomizer = rand.nextInt(9);
                System.out.println(randomizer);
                for (SelectorButton button: TicTacToe.buttons) {
                    if (button.value == 0) {
                        button.value = 2;
                        button.setIcon(O);
                        break;
                    }
                }
            }
            else {
                TicTacToe.isPlayerTurn = false;
            }
        }
        else if (value == 0) {
            value = 2;
            TicTacToe.isPlayerTurn = true;
        }
        TicTacToe.checkForWin();
        switch (value) {
            case 1 -> setIcon(X);
            case 2 -> setIcon(O);
        }
    }
}