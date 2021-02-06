import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class TemperatureConverter extends JFrame implements ActionListener{
    Image icon;
    JPanel topPanel;
    JPanel bottomPanel;
    JLabel topLabel;
    JLabel tempIcon;
    JComboBox leftBox;
    String[] temperatures = {"Fahrenheit","Celsius","Kelvin"};
    JComboBox rightBox;
    JTextField temperatureInput;
    JTextField temperatureOutput;
    double inputNumber;
    JButton convertButton;
    JButton clearButton;
    public TemperatureConverter(){
        this.setSize(600,800);
        this.setTitle("Temperature Converter by Chris Martin");
        icon = Toolkit.getDefaultToolkit().getImage("C://Users"
                + "//Christopher Martin//Documents//NetBeansProjects//"
                + "Temperature Converter (2021)//src//temperatueIcon.jpg");
        this.setIconImage(icon);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setBounds(0,0,600,100);
        topPanel.setBackground(new Color(75, 100, 200));
        tempIcon = new JLabel(new ImageIcon("src//tempIcon.png"));
        tempIcon.setBounds(130,0,100,100);
        topPanel.add(tempIcon);
        topLabel = new JLabel("Temperature Converter");
        topLabel.setFont(new Font("Algerian",Font.BOLD,20));
        topLabel.setForeground(Color.BLACK);
        topLabel.setBounds(195,0,500,100);
        topPanel.add(topLabel);
        this.add(topPanel);
        
        bottomPanel = new JPanel();
        bottomPanel.setLayout(null);
        bottomPanel.setBounds(0,100,600,700);
        bottomPanel.setBackground(new Color(75, 156, 211));
        leftBox = new JComboBox(temperatures);
        leftBox.setBounds(130,200,100,25);
        bottomPanel.add(leftBox);
        rightBox = new JComboBox(temperatures);
        rightBox.setBounds(350,200,100,25);
        bottomPanel.add(rightBox);
        convertButton = new JButton("Convert");
        convertButton.setBounds(130,300,100,25);
        convertButton.addActionListener(this);
        convertButton.setFocusable(false);
        bottomPanel.add(convertButton);
        clearButton = new JButton("Clear");
        clearButton.setBounds(360,300,100,25);
        clearButton.setFocusable(false);
        clearButton.addActionListener(this);
        bottomPanel.add(clearButton);
        temperatureInput = new JTextField();
        temperatureInput.setBounds(80,250,200,25);
        temperatureInput.setHorizontalAlignment(JTextField.CENTER);
        bottomPanel.add(temperatureInput);
        temperatureOutput = new JTextField();
        temperatureOutput.setBounds(320,250,200,25);
        temperatureOutput.setHorizontalAlignment(JTextField.CENTER);
        bottomPanel.add(temperatureOutput);
        this.add(bottomPanel);
        this.setVisible(true);
    }
    
    public void convertFahrenheit2Fahrenheit(double number){
        clear();
        temperatureOutput.setText(String.valueOf(number));    
    }
    public void convertFahrenheit2Celsius(double number){
        clear();
        double temperature = (number - 32) * (5.0/9.0);
        temperatureOutput.setText(String.valueOf(temperature));  
    }
    public void convertFahrenheit2Kelvin(double number){
       clear();
       double temperature = ((number - 32) * (5.0/9.0)) + 273.15;
       temperatureOutput.setText(String.valueOf(temperature));            
    }
    public void convertCelsius2Celsius(double number){
        clear();
        temperatureOutput.setText(String.valueOf(number));   
    }
    public void convertCelsius2Fahrenheit(double number){
         clear();
         double temperature = (number * (9.0/5.0)) + 32;
         temperatureOutput.setText(String.valueOf(temperature));   
    }
    public void convertCelsius2Kelvin(double number){
         clear();
         double temperature = (number + 273.15);
         temperatureOutput.setText(String.valueOf(temperature));   
    }
    public void convertKelvin2Kelvin(double number){
        clear();
        temperatureOutput.setText(String.valueOf(number));   
    }
    public void convertKelvin2Fahrenheit(double number){
         clear();
         double temperature = ((number - 273.15) * (9/5)) + 32;
         temperatureOutput.setText(String.valueOf(temperature));   
    }
    public void convertKelvin2Celsius(double number){
         clear();
         double temperature = (number - 273.15);
         temperatureOutput.setText(String.valueOf(temperature));   
    }
    public void clear(){
        temperatureInput.setText("");
        temperatureOutput.setText("");
    }
    public static void main(String[] args) {
        TemperatureConverter temperatureConverter = new TemperatureConverter();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== convertButton){
            if(leftBox.getSelectedItem().equals("Fahrenheit")){
                if(rightBox.getSelectedItem().equals("Fahrenheit")){
                    convertFahrenheit2Fahrenheit(Double.parseDouble
                    (temperatureInput.getText()));
                }
                else if(rightBox.getSelectedItem().equals("Celsius")){
                    convertFahrenheit2Celsius(Double.
                    parseDouble(temperatureInput.getText()));
                }
                else if(rightBox.getSelectedItem().equals("Kelvin")){
                    convertFahrenheit2Kelvin(Double.
                    parseDouble(temperatureInput.getText()));
                }
            }
            if(leftBox.getSelectedItem().equals("Celsius")){
                if(rightBox.getSelectedItem().equals("Celsius")){
                    convertCelsius2Celsius(Double.
                    parseDouble(temperatureInput.getText()));
                }
                else if(rightBox.getSelectedItem().equals("Fahrenheit")){
                    convertCelsius2Fahrenheit(Double.
                    parseDouble(temperatureInput.getText()));                
                }
                else if(rightBox.getSelectedItem().equals("Kelvin")){
                    convertCelsius2Kelvin(Double.
                    parseDouble(temperatureInput.getText()));
                }
            }
            if(leftBox.getSelectedItem().equals("Kelvin")){
                if(rightBox.getSelectedItem().equals("Kelvin")){
                    convertKelvin2Kelvin(Double.
                    parseDouble(temperatureInput.getText()));
                
                }
                else if(rightBox.getSelectedItem().equals("Fahrenheit")){
                    convertKelvin2Fahrenheit(Double.
                    parseDouble(temperatureInput.getText()));
                }
                else if(rightBox.getSelectedItem().equals("Celsius")){
                    convertKelvin2Celsius(Double.
                    parseDouble(temperatureInput.getText()));
                }
            }
        }
        if(e.getSource() == clearButton){
           clear();
        }
        
    }
}