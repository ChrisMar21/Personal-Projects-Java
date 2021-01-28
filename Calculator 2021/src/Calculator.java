import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.*;
public class Calculator extends JFrame implements ActionListener{
    JTextField textField;
    JButton button0;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton buttonPlus;
    JButton buttonMinus;
    JButton buttonMulti;
    JButton buttonDiv;
    JButton buttonMod;
    JButton buttonClear;
    JButton buttonDelete;
    JButton buttonEquals;
    JButton buttonNeg;
    JButton buttonDot;
    JButton colorChanger;
    double num1;
    double num2;
    double result;
    String operator;
    int color;
    Image icon = Toolkit.getDefaultToolkit().getImage("src//Me25.png");
      
    Calculator(){
        //Requirements for my Calculator's Window
        this.setSize(350,480);
        this.setTitle("Calculator by Chris Martin");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(255,165,0));
        this.setIconImage(icon);
        this.setLocationRelativeTo(null);
        
        //Color Option's position for Calculator Window referenced inside of 
        //array inside of actionPerformed() method.
        color = 0;
        
        //Numbers being entered into the calculator
        num1 = 0;
        num2 = 0;
        result = 0;
        operator = "";
        
        //Text Field
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setFont(new Font("TimesRoman",Font.BOLD,25));
        
        //Size and Bounds of the Text Field
        textField.setBounds(5,5,335,50);
        
        //Calculator
        //1st Row of Calculator Buttons
//------------------------------------------------------------------------------         
        button0 = new JButton("0");
        button0.setFocusable(false);
        button1 = new JButton("1");
        button1.setFocusable(false);
        button2 = new JButton("2");
        button2.setFocusable(false);
        buttonPlus = new JButton("+");
        buttonPlus.setFocusable(false);
//------------------------------------------------------------------------------
        //2nd Row of Calculator Buttons
        button3 = new JButton("3");
        button3.setFocusable(false);
        button4 = new JButton("4");
        button4.setFocusable(false);
        button5 = new JButton("5");
        button5.setFocusable(false);
        buttonMinus = new JButton("-");
        buttonMinus.setFocusable(false);
//------------------------------------------------------------------------------         
        //3rd Row of Calculator Buttons
        button6 = new JButton("6");
        button6.setFocusable(false);
        button7 = new JButton("7");
        button7.setFocusable(false);
        button8 = new JButton("8");
        button8.setFocusable(false);
        buttonMulti = new JButton("*");
        buttonMulti.setFocusable(false);
//------------------------------------------------------------------------------
        //4th Row of Calculator Buttons
        buttonDelete = new JButton("Del");
        buttonDelete.setFocusable(false);
        buttonClear = new JButton("Clear");
        buttonClear.setFocusable(false);
        button9 = new JButton("9");
        button9.setFocusable(false);
        buttonDiv = new JButton("/");
        buttonDiv.setFocusable(false);
//------------------------------------------------------------------------------
        //5th Row Calculator Buttons
        buttonDot = new JButton(".");
        buttonDot.setFocusable(false);
        buttonNeg = new JButton("Neg");
        buttonNeg.setFocusable(false);
        buttonMod = new JButton("mod");
        buttonMod.setFocusable(false);
        buttonEquals = new JButton("=");
        buttonEquals.setFocusable(false);
//------------------------------------------------------------------------------
        //Last Row contains button to change Calculator's Background Color
        colorChanger = new JButton("Change Background Color");
        colorChanger.setFocusable(false);
//------------------------------------------------------------------------------        
        //Button Bounds
        //1st Row of Buttons
        button1.setBounds(8,60,70,60);
        button2.setBounds(95,60,70,60);
        button3.setBounds(182,60,70,60);
        buttonPlus.setBounds(266,60,70,60);
        
        //2nd Row of Buttons
        button4.setBounds(8,125,70,60);
        button5.setBounds(95,125,70,60);
        button6.setBounds(182,125,70,60);
        buttonMinus.setBounds(266,125,70,60);
        
        //3rd Row of Buttons
        button7.setBounds(8,190,70,60);
        button8.setBounds(95,190,70,60);
        button9.setBounds(182,190,70,60);
        buttonMulti.setBounds(266,190,70,60);
        
        //4th Row of Buttons
        buttonDelete.setBounds(8,255,70,60);
        buttonClear.setBounds(95,255,70,60);
        button0.setBounds(182,255,70,60);
        buttonDiv.setBounds(266,255,70,60);
        
        //5th Row of Buttons
        buttonDot.setBounds(8,320,70,60);
        buttonNeg.setBounds(95,320,70,60);
        buttonMod.setBounds(182,320,70,60);
        buttonEquals.setBounds(266,320,70,60);
        
        //Last Row contains Button for Color Changer to Change Background
       colorChanger.setBounds(5,390,335,50);
       
       //Add Action Listener to Buttons
       //Number Buttons
       button0.addActionListener(this);
       button1.addActionListener(this);
       button2.addActionListener(this);
       button3.addActionListener(this); 
       button4.addActionListener(this); 
       button5.addActionListener(this);
       button6.addActionListener(this);
       button7.addActionListener(this);
       button8.addActionListener(this);
       button9.addActionListener(this);
       
       //Operator Buttons
       buttonPlus.addActionListener(this);
       buttonMinus.addActionListener(this);
       buttonMulti.addActionListener(this);
       buttonDiv.addActionListener(this);
       buttonMod.addActionListener(this);
       buttonEquals.addActionListener(this);
       
       //Calculator Function Buttons
       buttonClear.addActionListener(this);
       buttonDelete.addActionListener(this);
       buttonDot.addActionListener(this);
       buttonNeg.addActionListener(this);
       colorChanger.addActionListener(this);
       
       //Add Buttons to the JFrame
        this.add(textField);
        this.add(button0);
        this.add(button1);
        this.add(button2);
        this.add(buttonPlus);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(buttonMinus);
        this.add(button6);
        this.add(button7);
        this.add(button8);
        this.add(buttonMulti);
        this.add(button9);
        this.add(buttonDelete);
        this.add(buttonClear);
        this.add(buttonDiv);
        this.add(buttonMod);
        this.add(buttonNeg);
        this.add(buttonEquals);
        this.add(buttonDot);
        this.add(colorChanger);
        
        this.setVisible(true);
    }
     
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       JButton numberButtons[] = new JButton[10];
       numberButtons[0] = button0;
       numberButtons[1] = button1;
       numberButtons[2] = button2;    
       numberButtons[3] = button3;   
       numberButtons[4] = button4; 
       numberButtons[5] = button5; 
       numberButtons[6] = button6;
       numberButtons[7] = button7;
       numberButtons[8] = button8;
       numberButtons[9] = button9;
       
       for(int i = 0;i < numberButtons.length;i++){
           //Every number button typed will be added to Text Field
           if(e.getSource() == numberButtons[i]){
               textField.setText(textField.getText().concat(String.valueOf(i)));  
           }
       }
       
       if(e.getSource() == buttonPlus){
         //Converts String from Text Field to Double  
         num1 = Double.parseDouble(textField.getText());
         operator = "+";
         textField.setText("");
       }
       if(e.getSource() == buttonMinus){
          num1 = Double.parseDouble(textField.getText());
          operator = "-";
          textField.setText("");
       }
       if(e.getSource() == buttonMulti){
          num1 = Double.parseDouble(textField.getText());
          operator = "*";
          textField.setText("");
       }
       if(e.getSource() == buttonDiv){
          num1 = Double.parseDouble(textField.getText());
          operator = "/";
          textField.setText("");
       }
       if(e.getSource() == buttonMod){
          num1 = Double.parseDouble(textField.getText());
          operator = "mod";
          textField.setText("");
       }
       if(e.getSource() == buttonEquals){
           num2 = Double.parseDouble(textField.getText());
           switch(operator){
               case "+":
                         result = add(num1,num2);                       
                         break;
               case "-":
                        result = subtract(num1,num2);                        
                        break;
               case "*":
                         result = multiply(num1,num2);                        
                         break;
               case "/":
                         result = divide(num1,num2);
                         break;
               case "mod":
                         result = mod(num1,num2);
                         break;
             }
            textField.setText(String.valueOf(result));
            num1 = result;
       }
       if(e.getSource() == buttonClear){
           textField.setText("");
       }
       if(e.getSource() == buttonDelete){
          String number = textField.getText();
          textField.setText("");
          for(int i = 0;i < number.length()- 1;i++){
              textField.setText(textField.getText() + number.charAt(i));
          }
       }
       if(e.getSource() == buttonDot){
           textField.setText(textField.getText().concat("."));
       }
       if(e.getSource() == buttonNeg){
           double temp = Double.parseDouble(textField.getText());
           temp *= -1;
           textField.setText(String.valueOf(temp));
       }
       if(e.getSource() == colorChanger){
           Color green = new Color(0,255,0);
           Color carolinaBlue = new Color(75, 156, 211);
           Color red = new Color(255,0,0);
           Color yellow = new Color(255,255,0);
           Color blue = new Color(0,0,255);
           Color pink = new Color(255,192,203);
           
           Color colors[] = new Color[7];
           
           colors[0] = green;
           colors[1] = carolinaBlue;       
           colors[2] = red;       
           colors[3] = yellow;
           colors[4] = blue;
           colors[5] = pink;
           
           this.getContentPane().setBackground(colors[color]);
           color++;
           if(color > 6){
               color = 0;
               this.getContentPane().setBackground(new Color(255,165,0));
           }
       }
    }
    
    /**
     * Addition method that returns the result of the first number + second number
     * @param num1
     * @param num2
     * @return 
     */
    public double add(double num1,double num2){
        this.num1 = num1;
        this.num2 = num2;
        result = num1 + num2;
        return result;
    }
    
    public int add(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
        result = num1 + num2;
        return (int)result;
    }
    
    /**
     * Subtraction Method that returns result of first number - second number
     * @param num1
     * @param num2
     * @return 
     */
    public double subtract(double num1, double num2){
        this.num1 = num1;
        this.num2 = num2;
        result = num1 - num2;
        return result;
    }
    
    /**
     * Multiplication Method that returns of the first number * second
     * @param num1
     * @param num2
     * @return 
     */
    public double multiply(double num1,double num2){
        this.num1 = num1;
        this.num2 = num2;
        result = num1 * num2;
        return result;
    }
    
    /**
     * Division Method that returns the result of the first number / second number
     * @param num1
     * @param num2
     * @return 
     */
    public double divide(double num1,double num2){
        this.num1 = num1;
        this.num2 = num2;
        result = num1/num2;
        return result;
    }
    
    /**
     * Mod method that returns the result of first number modulus second number
     * @param num1
     * @param num2
     * @return 
     */
    public double mod(double num1,double num2){
        this.num1 = num1;
        this.num2 = num2;
        result = num1 % num2;
        return result;
    }
}