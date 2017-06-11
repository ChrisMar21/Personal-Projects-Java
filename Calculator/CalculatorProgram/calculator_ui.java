package calculatorprogram;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import javafx.scene.paint.Color;
import javax.swing.*;

public class calculator_ui implements ActionListener{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel(new FlowLayout());
    
    JTextArea text = new JTextArea(1,20);
    //Numbers
    JButton but1 = new JButton("1");
    JButton but2 = new JButton("2");
    JButton but3 = new JButton("3");
    JButton but4 = new JButton("4");
    JButton but5 = new JButton("5");
    JButton but6 = new JButton("6");
    JButton but7 = new JButton("7");
    JButton but8 = new JButton("8");
    JButton but9 = new JButton("9");
    JButton but10 = new JButton("0");
    
    //Operators
    JButton add = new JButton("+");
    JButton minus = new JButton("-");
    JButton multi = new JButton("*");
    JButton div = new JButton("/");
    JButton equals = new JButton("=");
    JButton clear = new JButton("C");
    
    Double num1,num2,result;
    int addc = 0;
    int subc = 0;
    int multic = 0;
    int divc = 0;
    
    public void ui(){
        frame.setVisible(true);
        frame.setSize(250, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(panel);
        panel.setBackground(java.awt.Color.blue.brighter().brighter().brighter());
        panel.add(text);
        panel.add(but1);
        panel.add(but2);
        panel.add(but3);
        panel.add(but4);
        panel.add(but5);
        panel.add(but6);
        panel.add(but7);
        panel.add(but8);
        panel.add(but9);
        panel.add(but10);
        
        panel.add(add);
        panel.add(minus);
        panel.add(multi);
        panel.add(div);
        panel.add(equals);
        panel.add(clear);
        
        //Adding action for numbers
        but1.addActionListener(this);
        but2.addActionListener(this);
        but3.addActionListener(this);
        but4.addActionListener(this);
        but5.addActionListener(this);
        but6.addActionListener(this);
        but7.addActionListener(this);
        but8.addActionListener(this);
        but9.addActionListener(this);
        but10.addActionListener(this);
        
        //Adding 
        add.addActionListener(this);
        minus.addActionListener(this);
        multi.addActionListener(this);
        div.addActionListener(this);
        equals.addActionListener(this);
        clear.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //Just learned something new for action Listener
        
        Object source = ae.getSource();
        
        if(source == clear){
           num1 = 0.0;
           num2 = 0.0;       
           text.setText("");
        
        
        }
        
        
        
        
        if(source == but1){
            text.append("1");
        }
        if(source == but2){
            text.append("2");
        }
        if(source == but3){
            text.append("3");
        }
        if(source == but4){
            text.append("4");
        }
        if(source == but5){
            text.append("5");
        }
        if(source == but6){
            text.append("6");
        }
        if(source == but7){
            text.append("7");
        }
        if(source == but8){
            text.append("8");
        }
        if(source == but9){
            text.append("9");
        }
        if(source == but10){
            text.append("0");
            
        }
        
        if(source == add){
            num1 = number_reader();
            text.setText("");
            addc = 1;
            subc = 0;
            multic = 0;
            divc = 0;
            
                    
        }
        if(source ==  minus){
            num1 = number_reader();
            text.setText("");
            addc = 0;
            subc = 1;
            multic = 0;
            divc = 0;
        
        }
        if(source == multi){
            num1 = number_reader();
            text.setText("");
            addc = 0;
            subc = 0;
            multic = 1;
            divc = 0;
            
        }
        if(source == div){
            num1 = number_reader();
            text.setText("");
            addc = 0;
            subc = 0;
            multic = 0;
            divc = 1;
        
        }
        if(source == equals){
            num2 = number_reader();
            if(addc > 0){
                result = num1 + num2;
                text.setText(Double.toString(result));
                
            
            }
            if(subc > 0){
                result = num1 - num2;
                text.setText(Double.toString(result));
                
            
            }
            if(multic > 0){
                result = num1 * num2;
                text.setText(Double.toString(result));
                
            
            }
            if(divc > 0){
                result = num1 / num2;
                text.setText(Double.toString(result));
                
            
            }
                
        }
                  
    }

    public double number_reader(){
        Double num1;
        String s;
        s = text.getText();
        num1 = Double.valueOf(s);
        
       return num1;
    }



}
