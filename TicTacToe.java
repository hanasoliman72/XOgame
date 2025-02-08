package com.mycompany.xogame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;



public class TicTacToe implements ActionListener{

    Random rand = new Random();
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();//for title
    JPanel panel2 = new JPanel();//for buttons
    JLabel label_tilte = new JLabel();//for text in panel1
    JButton buttons[] = new JButton[9];
    
    boolean player1Turn;
    
    public TicTacToe() {
        /**create a frame**/
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tic-Tac-Toe");
        frame.setSize(400,400);
        frame.setLocation(550, 250);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.setLayout(new BorderLayout());
        
        
        /**create panel1 for title**/
        panel1.setPreferredSize(new Dimension(400,80));
        panel1.setBackground(Color.black);
        panel1.setLayout(new BorderLayout());
        frame.add(panel1,BorderLayout.NORTH);
        
        
        /**create label for the title**/
        label_tilte.setText("Tic-Tac-Toe");
        label_tilte.setFont(new Font("MV Boli",Font.BOLD,30));
        label_tilte.setForeground(Color.GREEN);
        label_tilte.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(label_tilte);
        
        
        /**create panel2 for buttons**/
        panel2.setSize(new Dimension(400,320));
        //panel2.setBackground(Color.red);
        panel2.setLayout(new GridLayout(3,3));
        frame.add(panel2);
        
        
        /**create buttons**/
        for(int i=0 ; i<9 ; i++){
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,40));
            buttons[i].addActionListener(this);
            buttons[i].setFocusable(false);
            panel2.add(buttons[i]);
        }
        
        
        firstTurn();
        
        frame.setVisible(true);
    }
    
    
    
    public void firstTurn(){
        
        if(rand.nextInt(2) == 1){
            player1Turn = true;
            label_tilte.setText("X Turn");
        }
        else {
            player1Turn = false;
            label_tilte.setText("O Turn");
        }
    }
    
    public void check(){
        
        /**check rows**/
        if(buttons[0].getText().equals(buttons[1].getText()) && buttons[1].getText().equals(buttons[2].getText())){
            if(buttons[0].getText().equals("X")) {
                label_tilte.setText("X Wins");
                wins(0, 1, 2);
            }
            else if(buttons[0].getText().equals("O")) {
                label_tilte.setText("O Wins");
                wins(0, 1, 2);
            }   
        }
        else if(buttons[3].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[5].getText())){
            if(buttons[3].getText().equals("X")) {
                label_tilte.setText("X Wins");
                wins(3,4,5);
            }
            else if(buttons[3].getText().equals("O")) {
                label_tilte.setText("O Wins");
                wins(3,4,5);
            }   
        }
        else if(buttons[6].getText().equals(buttons[7].getText()) && buttons[7].getText().equals(buttons[8].getText())){
            if(buttons[6].getText().equals("X")) {
                label_tilte.setText("X Wins");
                wins(6,7,8);
            }
            else if(buttons[6].getText().equals("O")) {
                label_tilte.setText("O Wins");
                wins(6,7,8);
            }   
        }
        
        
        /**check columns**/
        else if(buttons[0].getText().equals(buttons[3].getText()) && buttons[3].getText().equals(buttons[6].getText())){
            if(buttons[0].getText().equals("X")) {
                label_tilte.setText("X Wins");
                wins(0, 3, 6);
            }
            else if(buttons[0].getText().equals("O")) {
                label_tilte.setText("O Wins");
                wins(0, 3, 6);
            }   
        }
        
        else if(buttons[1].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[7].getText())){
            if(buttons[1].getText().equals("X")) {
                label_tilte.setText("X Wins");
                wins(1,4,7);
            }
            else if(buttons[1].getText().equals("O")) {
                label_tilte.setText("O Wins");
                wins(1,4,7);
            }   
        }
        
        else if(buttons[2].getText().equals(buttons[5].getText()) && buttons[5].getText().equals(buttons[8].getText())){
            if(buttons[2].getText().equals("X")) {
                label_tilte.setText("X Wins");
                wins(2,5,8);
            }
            else if(buttons[2].getText().equals("O")) {
                label_tilte.setText("O Wins");
                wins(2,5,8);
            }   
        }
        
        
        /**check diagonal**/
        else if(buttons[0].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[8].getText())){
            if(buttons[0].getText().equals("X")) {
                label_tilte.setText("X Wins");
                wins(0, 4, 8);
            }
            else if(buttons[0].getText().equals("O")) {
                label_tilte.setText("O Wins");
                wins(0, 4, 8);
            }   
        }
        else if(buttons[2].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[6].getText())){
            if(buttons[2].getText().equals("X")) {
                label_tilte.setText("X Wins");
                wins(2, 4, 6);
            }
            else if(buttons[2].getText().equals("O")) {
                label_tilte.setText("O Wins");
                wins(2, 4, 6);
            }   
        }
        
        else{
            boolean red = true;
            for(int i=0; i<9 ; i++){
                if(buttons[i].getText().equals("")){
                  red = false;
                  break;
                }
            }
            if(red) {
                label_tilte.setText("No one wins");
                for(int i=0 ; i<9 ; i++)
                    buttons[i].setEnabled(false);
            }
        }
         
    }
    
    public void wins(int x,int y,int z){
        buttons[x].setBackground(Color.GREEN);
        buttons[y].setBackground(Color.GREEN);
        buttons[z].setBackground(Color.GREEN);
        
        for(int i=0 ; i<9 ; i++)
            buttons[i].setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i=0 ; i<9 ; i++){
            
            if(e.getSource() == buttons[i]){
                
                if(player1Turn){
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(Color.PINK);
                        buttons[i].setText("X");
                        player1Turn = false;
                        label_tilte.setText("O Turn");
                        check();
                    }
                }
                else {
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("O");
                        player1Turn = true;
                        label_tilte.setText("X Turn");
                        check();
                    }
                }
                
            }
            
            
        }//end for loop
        
    }
}
