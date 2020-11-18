package com.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame {
    public static SelectorButton[] buttons = new SelectorButton[9];
    public static boolean isPlayerTurn = true;
    public static TicTacToe objectVariable;
    public static boolean isSinglePlayer;

    public TicTacToe() {
        super ("TicTacToe");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(createMainMenu());
        validate();
        setVisible(true);
    }

    public static void main(String[] args) {
        TicTacToe.objectVariable = new TicTacToe();
        System.out.println("Successful start-up");
    }

    public JPanel createMainMenu() {
        JPanel mainPanel = new JPanel();
        JLabel mainLabel = new JLabel("TicTacToe");
        mainLabel.setFont(new java.awt.Font("Arial", Font.PLAIN, 100));
        JButton twoPlayerButton = new JButton("Two Player");
        twoPlayerButton.setFont(new java.awt.Font("Arial", Font.BOLD, 50));
        twoPlayerButton.addActionListener(e -> {
            objectVariable.getContentPane().removeAll();
            objectVariable.getContentPane().invalidate();
            objectVariable.getContentPane().add(createGamePanel());
            objectVariable.getContentPane().revalidate();
            System.out.println("Function should have been called");
        });
        JButton singlePlayerButton = new JButton("Single Player");
        singlePlayerButton.setFont(new java.awt.Font("Arial", Font.BOLD, 50));
        singlePlayerButton.addActionListener(e -> {
            objectVariable.getContentPane().removeAll();
            objectVariable.getContentPane().invalidate();
            objectVariable.getContentPane().add(createGamePanel());
            objectVariable.getContentPane().revalidate();
            System.out.println("Function should have been called");
            isSinglePlayer = true;
        });
        mainPanel.setLayout(new GridLayout(3, 0));
        mainPanel.add(mainLabel);
        mainPanel.add(singlePlayerButton);
        mainPanel.add(twoPlayerButton);
        setVisible(true);
        return mainPanel;
    }

    public JPanel createGamePanel() {
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3, 3));
        for (int i=0; i<9; i++) {
            buttons[i] = new SelectorButton();
            gamePanel.add(buttons[i]);
        }
        return gamePanel;
    }


    public void createEndPanel(int winner) {
        JPanel endPanel = new JPanel();
        endPanel.setLayout(new GridLayout(3, 0));
        if (winner == 1) {
            JLabel endLabel = new JLabel("You Won!");
            endLabel.setFont(new java.awt.Font("Arial", Font.PLAIN, 100));
            endPanel.add(endLabel);
        }
        else if (winner == 2) {
            JLabel endLabel = new JLabel("You Lost");
            endLabel.setFont(new java.awt.Font("Arial", Font.PLAIN, 100));
            endPanel.add(endLabel);
        }
        else if (winner == 0){
            JLabel endLabel = new JLabel("You Tied");
            endLabel.setFont(new java.awt.Font("Arial", Font.PLAIN, 100));
            endPanel.add(endLabel);
        }
        JButton playAgain1 = new JButton("Play Again- Single");
        playAgain1.setFont(new java.awt.Font("Arial", Font.BOLD, 35));
        playAgain1.addActionListener(e -> {
            objectVariable.getContentPane().removeAll();
            objectVariable.getContentPane().invalidate();
            objectVariable.getContentPane().add(createGamePanel());
            objectVariable.getContentPane().revalidate();
            for (SelectorButton button: buttons) {
                button.value = 0;
            }
            isSinglePlayer = true;
        });
        JButton playAgain2 = new JButton("Play Again- Double");
        playAgain2.setFont(new java.awt.Font("Arial", Font.BOLD, 35));
        playAgain2.addActionListener(e -> {
            objectVariable.getContentPane().removeAll();
            objectVariable.getContentPane().invalidate();
            objectVariable.getContentPane().add(createGamePanel());
            objectVariable.getContentPane().revalidate();
            for (SelectorButton button: buttons) {
                button.value = 0;
            }
            isSinglePlayer = false;
        });
        endPanel.add(playAgain1);
        endPanel.add(playAgain2);
        objectVariable.getContentPane().removeAll();
        objectVariable.getContentPane().invalidate();
        objectVariable.getContentPane().add(endPanel);
        objectVariable.getContentPane().revalidate();
    }

    public static void checkForWin() {
        if (((buttons[0].value == 1) && (buttons[1].value == 1) && (buttons[2].value == 1)) ||
                ((buttons[3].value == 1) && (buttons[4].value == 1) && (buttons[5].value == 1)) ||
                ((buttons[6].value == 1) && (buttons[7].value == 1) && (buttons[8].value == 1)) ||
                ((buttons[0].value == 1) && (buttons[3].value == 1) && (buttons[6].value == 1)) ||
                ((buttons[1].value == 1) && (buttons[4].value == 1) && (buttons[7].value == 1)) ||
                ((buttons[2].value == 1) && (buttons[5].value == 1) && (buttons[8].value == 1)) ||
                ((buttons[2].value == 1) && (buttons[4].value == 1) && (buttons[6].value == 1)) ||
                ((buttons[0].value == 1) && (buttons[4].value == 1) && (buttons[8].value == 1))) {
            objectVariable.createEndPanel(1);
        }
        else if (((buttons[0].value == 2) && (buttons[1].value == 2) && (buttons[2].value == 2)) ||
                ((buttons[3].value == 2) && (buttons[4].value == 2) && (buttons[5].value == 2)) ||
                ((buttons[6].value == 2) && (buttons[7].value == 2) && (buttons[8].value == 2)) ||
                ((buttons[0].value == 2) && (buttons[3].value == 2) && (buttons[6].value == 2)) ||
                ((buttons[1].value == 2) && (buttons[4].value == 2) && (buttons[7].value == 2)) ||
                ((buttons[2].value == 2) && (buttons[5].value == 2) && (buttons[8].value == 2)) ||
                ((buttons[2].value == 2) && (buttons[4].value == 2) && (buttons[6].value == 2)) ||
                ((buttons[0].value == 2) && (buttons[4].value == 2) && (buttons[8].value == 2))) {
            objectVariable.createEndPanel(2);
        }
        else if (buttons[0].value > 0 && buttons[1].value > 0 && buttons[2].value > 0 &&
                buttons[3].value > 0 && buttons[4].value > 0 && buttons[5].value > 0 &&
                buttons[6].value > 0 && buttons[7].value > 0 && buttons[8].value > 0) {
            objectVariable.createEndPanel(0);
        }
    }
}