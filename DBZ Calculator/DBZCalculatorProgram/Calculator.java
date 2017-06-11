import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Font;
import javax.swing.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Calculator extends JFrame implements ActionListener{
    JPanel panel = new JPanel();
    JButton one = new JButton("1");
    JButton two = new JButton("2");
    JButton three = new JButton("3");
    JButton four = new JButton("4");
    JButton five = new JButton("5");
    JButton six = new JButton("6");
    JButton seven = new JButton("7");
    JButton eight = new JButton("8");
    JButton nine = new JButton("9");
    JButton zero = new JButton("0");
   JButton clear = new JButton("C");
    JButton plus = new JButton("Add");
    JButton minus = new JButton("Sub");
    JButton divide = new JButton("Div");
    JButton multiply = new JButton("Mult");
    JButton equals = new JButton("Eq's");
    JTextField textField = new JTextField();
    JLabel bG;
    ImageIcon backGround = new ImageIcon(getClass().getResource("DBZ3.jpg"));
    JButton changeBackGround = new JButton("Change BackGround");
    JButton musicPlayer = new JButton("Play Theme");
    int number =  1;
    double result;
    double num1;
    double num2;
    int addc = 0;
    int subc = 0;
    int multic = 0;
    int divc = 0;
    Calculator(){
        
        panel.setLayout(null);
        setSize(400,400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(Calculator.EXIT_ON_CLOSE);
        //Choosing positions for each button and background
        bG = new JLabel(backGround);
        bG.setBounds(0,0,400,400);
        one.setBounds(20,60,65,40);
        
        one.setIcon(new ImageIcon(getClass().getResource("Appule.jpg")));
        one.setHorizontalTextPosition(SwingConstants.CENTER);
        one.setForeground(Color.orange);
        one.addActionListener(this);
        
        two.setHorizontalTextPosition(SwingConstants.CENTER);
        two.setForeground(Color.ORANGE);
        two.addActionListener(this);
        three.setHorizontalTextPosition(SwingConstants.CENTER);
        three.setForeground(Color.ORANGE);
        three.addActionListener(this);
        four.setHorizontalTextPosition(SwingConstants.CENTER);
        four.setForeground(Color.ORANGE);
        four.addActionListener(this);
        five.setHorizontalTextPosition(SwingConstants.CENTER);
        five.setForeground(Color.orange);
        five.addActionListener(this);
        six.setHorizontalTextPosition(SwingConstants.CENTER);
        six.setForeground(Color.orange);
        six.addActionListener(this);
        seven.setHorizontalTextPosition(SwingConstants.CENTER);
        seven.setForeground(Color.orange);
        seven.addActionListener(this);
        eight.setHorizontalTextPosition(SwingConstants.CENTER);
        eight.setForeground(Color.orange);
        eight.addActionListener(this);
        nine.setHorizontalTextPosition(SwingConstants.CENTER);
        nine.setForeground(Color.orange);
        nine.addActionListener(this);
        zero.setHorizontalTextPosition(SwingConstants.CENTER);
        zero.setForeground(Color.orange);
        zero.addActionListener(this);
        plus.setHorizontalTextPosition(SwingConstants.CENTER);
        plus.setForeground(Color.orange);
        plus.addActionListener(this);
        minus.setHorizontalTextPosition(SwingConstants.CENTER);
        minus.setForeground(Color.ORANGE);
        minus.addActionListener(this);
        divide.setHorizontalTextPosition(SwingConstants.CENTER);
        divide.setForeground(Color.orange);
        divide.addActionListener(this);
        multiply.setHorizontalTextPosition(SwingConstants.CENTER);
        multiply.setForeground(Color.orange);
        multiply.addActionListener(this);
        musicPlayer.setBackground(Color.orange);
        musicPlayer.setForeground(Color.black);
        musicPlayer.addActionListener(this);
        clear.addActionListener(this);
        equals.addActionListener(this);
        equals.setHorizontalTextPosition(SwingConstants.CENTER);
        two.setIcon(new ImageIcon(getClass().getResource("Bardock.jpg")));
        three.setIcon(new ImageIcon(getClass().getResource("Cooler.jpg")));
        four.setIcon(new ImageIcon(getClass().getResource("Dabura.jpg")));
        five.setIcon(new ImageIcon(getClass().getResource("Frieza.jpg")));
        six.setIcon(new ImageIcon(getClass().getResource("Goku.jpg")));
        seven.setIcon(new ImageIcon(getClass().getResource("Hercule.jpg")));
        eight.setIcon(new ImageIcon(getClass().getResource("Janemba.jpg")));
        nine.setIcon(new ImageIcon(getClass().getResource("Krillin.jpg")));
        zero.setIcon(new ImageIcon(getClass().getResource("dragonballs.jpg")));
        plus.setIcon(new ImageIcon(getClass().getResource("Vegeta.jpg")));
        minus.setIcon(new ImageIcon(getClass().getResource("Gohan.jpg")));
        divide.setIcon(new ImageIcon(getClass().getResource("Piccolo.jpg")));
        multiply.setIcon(new ImageIcon(getClass().getResource("KidBuu.jpg")));
        clear.setIcon(new ImageIcon(getClass().getResource("Eraser.jpg")));
        equals.setIcon(new ImageIcon(getClass().getResource("Fusion.jpg")));
       
        two.setBounds(120,60,65,40);
        three.setBounds(220,60,65,40);
        four.setBounds(20,120,65,40);
        five.setBounds(120,120,65,40);
        six.setBounds(220,120,65,40);
        seven.setBounds(20,180,65,40);
        eight.setBounds(120,180,65,40);
        nine.setBounds(220,180,65,40);
        zero.setBounds(20,240,65,40);
        plus.setBounds(310,60,65,40);
        minus.setBounds(310,120,65,40);
        multiply.setBounds(310,180,65,40);
        divide.setBounds(310,240,65,40);
        clear.setBounds(120,240,65,40);
        textField.setBounds(20,10,355,40);
        changeBackGround.setBounds(20,300,174,22);
        changeBackGround.setBackground(Color.black);
        changeBackGround.setForeground(Color.orange);
        musicPlayer.setBounds(200,300,174,22);
        equals.setForeground(Color.ORANGE);
        equals.setBounds(220,240,65,40);
        changeBackGround.addActionListener(this);
       
        //Adding each button to the calculator
          panel.add(one);
          panel.add(two);
          panel.add(three);
          panel.add(four);
          panel.add(five);
          panel.add(six);
          panel.add(seven);
          panel.add(eight);
          panel.add(nine);
          panel.add(zero);
          panel.add(plus);
          panel.add(minus);
          panel.add(multiply);
          panel.add(divide);
          panel.add(clear);
          panel.add(textField);
          panel.add(bG);
          panel.add(changeBackGround);  
          
          panel.add(musicPlayer);
          panel.add(equals);
          
          
          add(panel);
          setVisible(true);
          
    
    }
    public static void main(String[] args) {
        Calculator c = new Calculator();
        
    }
    public double number_reader(){
        Double num1;
        String s;
        s = textField.getText();
        num1 = Double.valueOf(s);
        
       return num1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == changeBackGround){
            
           ++number;
                if(number == 2){
              ImageIcon newImage = new ImageIcon(getClass().getResource("BG2.jpg"));
              bG.setIcon(newImage);
              
            }
            if(number == 3){
              ImageIcon newImage = new ImageIcon(getClass().getResource("BG3.jpg"));
              bG.setIcon(newImage);
         
            }
            else if(number >= 3){
                bG.setIcon(backGround);
                number = 1;
            
            }   
//           
                    
        }
        if(source == musicPlayer){
            try {
                playMusic();
            } catch (IOException ex) {System.exit(-1);}  
        }
        if(source == zero){
            textField.setText("0");
            textField.setHorizontalAlignment(SwingConstants.RIGHT);
        }
        if(source == one){
            textField.setText("1");
            textField.setHorizontalAlignment(SwingConstants.RIGHT);
        }
        if(source == two){
            textField.setText("2");
            textField.setHorizontalAlignment(SwingConstants.RIGHT);
        }
        if(source == three){
            textField.setText("3");
            textField.setHorizontalAlignment(SwingConstants.RIGHT);
        }
        if(source == four){
            textField.setText("4");
            textField.setHorizontalAlignment(SwingConstants.RIGHT);
        }
        if(source == five){
            textField.setText("5");
            textField.setHorizontalAlignment(SwingConstants.RIGHT);
        }
        if(source == six){
            textField.setText("6");
            textField.setHorizontalAlignment(SwingConstants.RIGHT);
        }
        if(source == seven){
            textField.setText("7");
            textField.setHorizontalAlignment(SwingConstants.RIGHT);
        }
        if(source == eight){
            textField.setText("8");
            textField.setHorizontalAlignment(SwingConstants.RIGHT);
        }
        if(source == nine){
            textField.setText("9");
            textField.setHorizontalAlignment(SwingConstants.RIGHT);
        }
        if(source == clear){
            num1 = 0.0;
            num2 = 0.0;
            textField.setText("");
        
        
        }
        if(source == plus){
            num1 = number_reader();
            textField.setText("");
            addc = 1;
            subc = 0;
            multic = 0;
            divc = 0;
            
                    
        }
        if(source ==  minus){
            num1 = number_reader();
            textField.setText("");
            addc = 0;
            subc = 1;
            multic = 0;
            divc = 0;
        
        }
        if(source == multiply){
            num1 = number_reader();
            textField.setText("");
            addc = 0;
            subc = 0;
            multic = 1;
            divc = 0;
            
        }
        if(source == divide){
            num1 = number_reader();
            textField.setText("");
            addc = 0;
            subc = 0;
            multic = 0;
            divc = 1;
        
        }
         if(source == equals){
            num2 = number_reader();
            if(addc > 0){
                result = num1 + num2;
                textField.setText(Double.toString(result));
                textField.setHorizontalAlignment(SwingConstants.RIGHT);
            
            }
            if(subc > 0){
                result = num1 - num2;
                textField.setText(Double.toString(result));
                textField.setHorizontalAlignment(SwingConstants.RIGHT);
            
            }
            if(multic > 0){
                result = num1 * num2;
                textField.setText(Double.toString(result));
                textField.setHorizontalAlignment(SwingConstants.RIGHT);
            
            }
            if(divc > 0){
                result = num1 / num2;
                
                textField.setText(Double.toString(result));
                textField.setHorizontalAlignment(SwingConstants.RIGHT);
            
            }      
        }       
    }
    public void playMusic() throws IOException{
//         
//       FileInputStream in = new FileInputStream("C:\\Users\\BOGIER\\"
//               + "Music\\nbaTheme.wav");
       FileInputStream in = new FileInputStream("src\\DBZ Theme.wav");
       
       AudioStream as = new AudioStream(in);
       AudioPlayer.player.start(as);
          
    }
    

}
