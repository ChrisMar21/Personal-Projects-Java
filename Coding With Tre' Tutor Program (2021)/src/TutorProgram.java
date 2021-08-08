import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
public class TutorProgram extends JFrame implements ActionListener,MouseListener{
    Image windowIcon;
    ImageIcon logo;
    FileWriter fw;
    PrintWriter usernameWriter;
    File tutorUsernames = new File("src//TutorUsernames.txt");
    File tutorPasswords = new File("src//TutorPasswords.txt");     
    FileWriter fw2;
    PrintWriter passwordWriter;
    FileWriter fw3;
    PrintWriter usernameWriter2;
    File studentUsernames = new File("src//StudentUsernames.txt");
    File studentPasswords = new File("src//StudentPasswords.txt");
    FileWriter fw4;
    PrintWriter passwordWriter2;
    boolean isValidTutorUsername = false;
    boolean isValidTutorPassword = false;
    boolean isValidStudentUsername = false;
    boolean isValidStudentPassword = false;
    //***********************Left Panel GUI Components**************************
    JPanel leftPanel;
    JLabel leftIcon1;
    JLabel leftIcon2;
    //***********************Right Panel GUI Components*************************
    JPanel rightPanel;
    JLabel topRightLabel;
    JLabel rightLabel;
    JLabel usernameLabel;
    JTextField userName;
    JLabel passwordLabel;
    JPasswordField passWord;
    JButton signinButton;
    JButton signupButton;
    //**********************Register Options GUI Components*********************
    JLabel topRegistrationLabel;
    JPanel topRegistrationPanel;
    JPanel rightTutorPanel;
    JPanel rightStudentPanel;
    ButtonGroup buttonGroup;
    JRadioButton tutorOption;
    JRadioButton studentOption;
    JButton nextButton1;
    //*********************Tutor Registration GUI Components********************
    JPanel tutorPanel;
    JLabel tutorFName;
    JTextField tutorFirstName; 
    JLabel tutorLName;
    JTextField tutorLastName;
    JLabel tutorUsernameLabel;
    JTextField tutorUsername;
    JLabel tutorPasswordLabel;
    JTextField tutorPassword;
    JButton nextButton2;
    boolean isTutorSetUpPage = false;
    boolean isTutorRegistration = false;
    //*******************Student Registration GUI Components********************
    JPanel studentPanel;
    JLabel studentFName;
    JTextField studentFirstName;
    JLabel studentLName;
    JTextField studentLastName;
    JLabel studentUsernameLabel;
    JTextField studentUsername;
    JLabel studentPasswordLabel;
    JTextField studentPassword;
    JButton nextButton3;
    boolean isStudentSetUpPage = false;
    boolean isStudentRegistration = false;
    //******************Registration Results************************************
    JPanel resultsPanel;
    JLabel Name;
    JLabel Username;
    JLabel Password;
    JButton changeInfo;
    JButton keepResults;
    //*******************Tutor Account GUI Components***************************
    JPanel tutorImagePanel;
    JLabel tutorImage;
    JPanel tutorUsernamePanel;
    JLabel tutorUserLabel;
    JPanel tutorRatingsPanel;
    JLabel tutorRatingsLabel;
    JButton tutorOptions;
    JButton tutorSignOut;
    //*******************Student Account GUI Components*************************
    public TutorProgram() throws IOException{
        setTitle("Coding With Tre' Tutor Program");
        logo = new ImageIcon("src//hashtagLogo.png");
        this.setIconImage(logo.getImage());
        setLayout(null);
        setSize(1000,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
                 
        leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBounds(0,0,500,700);
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, 
                new Color(75, 156, 211)));
        
        leftIcon1 = new JLabel();
        leftIcon1.setIcon(new ImageIcon("src//logoIcon1.png"));
        leftIcon1.setBackground(Color.WHITE);
        leftIcon1.setOpaque(true);
        leftIcon1.setBounds(55,50,350,200);
        leftPanel.add(leftIcon1);
        this.add(leftPanel);
        
        leftIcon2 = new JLabel();
        leftIcon2.setIcon(new ImageIcon("src//leftIcon2.png"));
        leftIcon2.setBackground(Color.WHITE);
        leftIcon2.setBounds(-10,380,480,80);
        leftPanel.add(leftIcon2);
        
        rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(500,0,500,700);
        rightPanel.setBackground(Color.WHITE);
        this.add(rightPanel);
        
        topRightLabel= new JLabel("Welcome, book your session today");
        topRightLabel.setFont(new Font("Agency FB",Font.BOLD,35));
        topRightLabel.setForeground(new Color(75,156,211));
        topRightLabel.setBounds(50,50,450,100);
        rightPanel.add(topRightLabel);
        
        usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Agency FB",Font.BOLD,20)); 
        usernameLabel.setForeground(Color.BLACK);
        usernameLabel.setBounds(50,150,200,50);
        rightPanel.add(usernameLabel);
        
        userName = new JTextField();
        userName.setFont(new Font("Times New Roman",Font.BOLD,20));
        userName.setBounds(50,200,300,50);
        userName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, 
                                         new Color(75, 156, 211)));
        rightPanel.add(userName);
        
        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Agency FB",Font.BOLD,20));
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setBounds(50,270,200,50);
        rightPanel.add(passwordLabel);
        
        passWord = new JPasswordField();
        passWord.setFont(new Font("Times New Roman",Font.BOLD,20));
        passWord.setBounds(50,320,300,50);
        passWord.setBorder(BorderFactory.createMatteBorder
                                         (0, 0, 1, 0, new Color(75, 156, 211)));
        rightPanel.add(passWord);
        
        signinButton = new JButton("Sign In");
        signinButton.setFont(new Font("Times New Roman",Font.BOLD,18));
        signinButton.setForeground(Color.WHITE);
        signinButton.setBackground(new Color(75, 156, 211));
        signinButton.setFocusable(false);
        signinButton.setBounds(50,450,120,50);
        signinButton.addActionListener(this);
        signinButton.addMouseListener(this);
        rightPanel.add(signinButton);
        
        signupButton = new JButton("Sign Up");
        signupButton.setFont(new Font("Times New Roman",Font.BOLD,18));
        signupButton.setForeground(Color.WHITE);
        signupButton.setBackground(new Color(75,156,211));
        signupButton.setFocusable(false);
        signupButton.setBounds(230,450,120,50);
        signupButton.addActionListener(this);
        signupButton.addMouseListener(this);
        rightPanel.add(signupButton);
        setVisible(true);
    }
    /***************************************************************************
     * go2REgisterOptions():
     */
    public void go2RegisterOptions(){
        rightPanel.setVisible(false);
        
        topRegistrationLabel = new JLabel("I Want to Register as a...");
        topRegistrationLabel.setFont(new Font("Agency FB",Font.BOLD,45));
        topRegistrationLabel.setForeground(new Color(75,156,211));
        topRegistrationLabel.setBounds(80,40,500,100);
        
        topRegistrationPanel = new JPanel();
        topRegistrationPanel.setLayout(null);
        topRegistrationPanel.setBackground(Color.WHITE);
        topRegistrationPanel.setBounds(500,0,500,160);
        topRegistrationPanel.add(topRegistrationLabel);
        this.add(topRegistrationPanel);
        
        rightTutorPanel = new JPanel();
        rightTutorPanel.setLayout(null);
        rightTutorPanel.setBounds(500,160,500,200);
        rightTutorPanel.setBackground(new Color(75, 156, 211));
        buttonGroup = new ButtonGroup();
               
        rightStudentPanel = new JPanel();
        rightStudentPanel.setLayout(null);
        rightStudentPanel.setBounds(500,360,500,200);
        rightStudentPanel.setBackground(Color.WHITE);
              
        tutorOption = new JRadioButton("Tutor");
        tutorOption.setFont(new Font("Agency FB",Font.BOLD,30));
        tutorOption.setForeground(Color.WHITE);
        tutorOption.setBackground(new Color(75, 156, 211));
        tutorOption.setBounds(200,100,200,50);
        tutorOption.setFocusable(false);
        rightTutorPanel.add(tutorOption);
        buttonGroup.add(tutorOption);
        this.add(rightTutorPanel);
        
        studentOption = new JRadioButton("Student");
        studentOption.setFont(new Font("Agency FB",Font.BOLD,30));
        studentOption.setForeground(new Color(75, 156, 211));
        studentOption.setBackground(Color.WHITE);
        studentOption.setBounds(200,100,200,50);
        studentOption.setFocusable(false);
        rightStudentPanel.add(studentOption);
        buttonGroup.add(studentOption);
        
        nextButton1 = new JButton("Next");
        nextButton1.setFont(new Font("Agency FB",Font.BOLD,26));
        nextButton1.setForeground(Color.WHITE);
        nextButton1.setBackground(new Color(75,156,211));
        nextButton1.setFocusable(false);
        nextButton1.setBounds(500,560,500,102);
        nextButton1.addActionListener(this);
        this.add(nextButton1);
        this.add(rightStudentPanel);
        
    }
    /***************************************************************************
     * go2TutorSetupPage():
     */
    public void go2TutorSetupPage(){
      if(isTutorSetUpPage){
         topRegistrationPanel.setVisible(false);
         rightTutorPanel.setVisible(false);
         rightStudentPanel.setVisible(false);
         nextButton1.setVisible(false);
         
         tutorPanel = new JPanel();
         tutorPanel.setLayout(null);
         tutorPanel.setBackground(Color.WHITE);
         tutorPanel.setBounds(500,0,500,700);
         
         tutorFName = new JLabel("First Name");
         tutorFName.setFont(new Font("Agency FB",Font.BOLD,25));
         tutorFName.setBounds(200,20,200,50);
         tutorPanel.add(tutorFName);
         
         tutorFirstName = new JTextField();
         tutorFirstName.setFont(new Font("Times New Roman",Font.BOLD,20));
         tutorFirstName.setHorizontalAlignment(JTextField.CENTER);
         tutorFirstName.setBounds(85,70,300,50);
         tutorFirstName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, 
                                         new Color(75, 156, 211)));
         tutorPanel.add(tutorFirstName);
         
         tutorLName = new JLabel("Last Name");
         tutorLName.setFont(new Font("Agency FB",Font.BOLD,25));
         tutorLName.setBounds(200,150,200,50);
         tutorPanel.add(tutorLName);
         
         tutorLastName = new JTextField();
         tutorLastName.setFont(new Font("Times New Roman",Font.BOLD,20));
         tutorLastName.setHorizontalAlignment(JTextField.CENTER);
         tutorLastName.setBounds(85,190,300,50);
         tutorLastName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, 
                                         new Color(75, 156, 211)));
         tutorPanel.add(tutorLastName);
         
         tutorUsernameLabel = new JLabel("Username");
         tutorUsernameLabel.setFont(new Font("Agency FB",Font.BOLD,25));
         tutorUsernameLabel.setBounds(200,260,200,50);
         tutorPanel.add(tutorUsernameLabel);
         
         tutorUsername = new JTextField();
         tutorUsername.setFont(new Font("Times New Roman",Font.BOLD,20));
         tutorUsername.setHorizontalAlignment(JTextField.CENTER);
         tutorUsername.setBounds(85,300,300,50);
         tutorUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, 
                                         new Color(75, 156, 211)));
         tutorPanel.add(tutorUsername);
         
         tutorPasswordLabel = new JLabel("Password");
         tutorPasswordLabel.setFont(new Font("Agency FB",Font.BOLD,25));
         tutorPasswordLabel.setBounds(200,370,200,50);
         tutorPanel.add(tutorPasswordLabel);
         
         tutorPassword = new JTextField();
         tutorPassword.setFont(new Font("Times New Roman",Font.BOLD,20));
         tutorPassword.setHorizontalAlignment(JTextField.CENTER);
         tutorPassword.setBounds(85,410,300,50);
         tutorPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, 
                                         new Color(75, 156, 211)));
         tutorPanel.add(tutorPassword);
         
         nextButton2 = new JButton("Register");
         nextButton2.setFont(new Font("Agency FB",Font.BOLD,22));
         nextButton2.setForeground(new Color(75,156,211));
         nextButton2.setBackground(Color.WHITE);
         nextButton2.setBorder(new LineBorder(new Color(75,156,211)));
         nextButton2.setFocusable(false);
         nextButton2.setBounds(85,525,300,50);
         nextButton2.addActionListener(this);
         tutorPanel.add(nextButton2);
         this.add(tutorPanel);
      }
   }
     /**************************************************************************
     * go2TutorRegistrationPage():
     */
    public void go2TutorRegistrationPage(){
        if(isTutorRegistration){
            isTutorSetUpPage = false;     
            tutorPanel.setVisible(false);
            resultsPanel = new JPanel();
            resultsPanel.setLayout(null);
            resultsPanel.setBackground(Color.WHITE);
            resultsPanel.setBounds(500,0,500,700);
            this.add(resultsPanel);
        
            tutorFName.setText("Full Name:");
            tutorFName.setBounds(150,100,200,50);
            resultsPanel.add(tutorFName);
        
            Name = new JLabel(tutorFirstName.getText() +  " " + 
                          tutorLastName.getText());
            Name.setFont(new Font("Agency FB",Font.BOLD,25));
            Name.setBounds(250,100,200,50);
            resultsPanel.add(Name);
        
            tutorUsernameLabel.setText("Username:");
            tutorUsernameLabel.setBounds(150,200,200,50);
            resultsPanel.add(tutorUsernameLabel);
        
            Username = new JLabel(tutorUsername.getText());
            Username.setFont(new Font("Agency FB",Font.BOLD,25));
            Username.setBounds(250,200,200,50);
            resultsPanel.add(Username);
        
            tutorPasswordLabel.setText("Password:");
            tutorPasswordLabel.setBounds(150,300,200,50);
            resultsPanel.add(tutorPasswordLabel);
        
            Password = new JLabel(tutorPassword.getText());
            Password.setFont(new Font("Agency FB",Font.BOLD,25));
            Password.setBounds(250,300,200,50);
            resultsPanel.add(Password);
        
            changeInfo = new JButton("Change Your Info.");
            changeInfo.setFont(new Font("Agency FB",Font.BOLD,22));
            changeInfo.setForeground(new Color(75,156,211));
            changeInfo.setBackground(Color.WHITE);
            changeInfo.setBorder(new LineBorder(new Color(75,156,211)));
            changeInfo.setFocusable(false);
            changeInfo.setBounds(50,500,150,50);
            changeInfo.addActionListener(this);
            changeInfo.addMouseListener(this);
            resultsPanel.add(changeInfo);
        
            keepResults = new JButton("Register My Info.");
            keepResults.setFont(new Font("Agency FB",Font.BOLD,22));
            keepResults.setForeground(new Color(75,156,211));
            keepResults.setBackground(Color.WHITE);
            keepResults.setBorder(new LineBorder(new Color(75,156,211)));
            keepResults.setFocusable(false);
            keepResults.setBounds(250,500,150,50);
            keepResults.addActionListener(this);
            keepResults.addMouseListener(this);
            resultsPanel.add(keepResults);
     }    
 }
    /***************************************************************************
     * addTutor(Tutor newTutor): Adds a tutor to the Tutoring System through
     *                           text files.
     * @param newTutor
     * @throws IOException 
     */
     public void addTutor(Tutor newTutor) throws IOException{        
         //FileWriter and a PrintWriter to store Tutor's Account Information
         //into the system.
        fw = new FileWriter(tutorUsernames);
        usernameWriter = new PrintWriter(fw);
        //Adds Tutor's Username to a Separate Textfile.
        System.out.println(newTutor.getUsername());
        usernameWriter.println(newTutor.getUsername());
        usernameWriter.close();
        
        fw2 =  new FileWriter(tutorPasswords);
        passwordWriter = new PrintWriter(fw2);
        //Adds Tutor's Password to a Separate Textfile.
        System.out.println(newTutor.getPassword());
        passwordWriter.println(newTutor.getPassword());
        passwordWriter.close();
        
    }
     /**************************************************************************
     * isValidTutor():
     * @return 
     */
    public boolean isValidTutorUser(String userName,String passWord) throws FileNotFoundException{
            //Reading from the separate textfile of Tutor Usernames.
            Scanner tutorUsernameReader = new Scanner(tutorUsernames);       
            String usernameOfTutor;
            while(tutorUsernameReader.hasNext()){
                usernameOfTutor = tutorUsernameReader.nextLine();
                if(userName.equals(usernameOfTutor)){
                    isValidTutorUsername = true;
                }
            }
            //Reading from the separate textfile of Tutor Passwords.
            Scanner tutorPasswordReader = new Scanner(tutorPasswords);
            String passwordOfTutor;
            while(tutorPasswordReader.hasNext()){
                passwordOfTutor = tutorPasswordReader.nextLine();
                if(passWord.equals(passwordOfTutor)){
                    isValidTutorPassword = true;
                }
            }
            
            //It will return true if credentials are corret for logging in
            if((isValidTutorUsername && isValidTutorPassword)){
                return true;
            }
            else{
                return false;
            }      
    }
    /***************************************************************************
     * 
     */
    public void go2TutorAccount(String userName,String passWord){
        leftPanel.setVisible(false);
        rightPanel.setVisible(false);
        
    
    
    }
     /**************************************************************************
      * go2HomePage():
      */
    public void go2HomePage(){
        if(isTutorRegistration){
            changeInfo.setVisible(false);
            keepResults.setVisible(false);
            rightPanel.setVisible(true);
            isTutorSetUpPage = false;
            isTutorRegistration = false;   
        }
        else if(isStudentRegistration){
            changeInfo.setVisible(false);
            keepResults.setVisible(false);
            rightPanel.setVisible(true);
            isStudentSetUpPage = false;
            isStudentRegistration = false;
        }
    }
    
    /***************************************************************************
     * 
     */
    public void go2StudentSetupPage(){
      if(isStudentSetUpPage){
        topRegistrationPanel.setVisible(false);
        rightTutorPanel.setVisible(false);
        rightStudentPanel.setVisible(false);
        nextButton1.setVisible(false);    
        studentPanel = new JPanel();
        studentPanel.setLayout(null);
        studentPanel.setBackground(Color.WHITE);
        studentPanel.setBounds(500,0,500,700);
        
        studentFName = new JLabel("First Name");
        studentFName.setFont(new Font("Agency FB",Font.BOLD,25));
        studentFName.setBounds(200,20,200,50);
        studentPanel.add(studentFName);
        
        studentFirstName = new JTextField();
        studentFirstName.setFont(new Font("Times New Roman",Font.BOLD,20));
        studentFirstName.setHorizontalAlignment(JTextField.CENTER);
        studentFirstName.setBounds(85,70,300,50);
        studentFirstName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, 
                                         new Color(75, 156, 211)));
        studentPanel.add(studentFirstName);
        
        studentLName = new JLabel("Last Name");
        studentLName.setFont(new Font("Agency FB",Font.BOLD,25));
        studentLName.setBounds(200,150,200,50);
        studentPanel.add(studentLName);
         
        studentLastName = new JTextField();
        studentLastName.setFont(new Font("Times New Roman",Font.BOLD,20));
        studentLastName.setHorizontalAlignment(JTextField.CENTER);
        studentLastName.setBounds(85,190,300,50);
        studentLastName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, 
                                         new Color(75, 156, 211)));
        studentPanel.add(studentLastName);
         
        studentUsernameLabel = new JLabel("Username");
        studentUsernameLabel.setFont(new Font("Agency FB",Font.BOLD,25));
        studentUsernameLabel.setBounds(200,260,200,50);
        studentPanel.add(studentUsernameLabel);
         
        studentUsername = new JTextField();
        studentUsername.setFont(new Font("Times New Roman",Font.BOLD,20));
        studentUsername.setHorizontalAlignment(JTextField.CENTER);
        studentUsername.setBounds(85,300,300,50);
        studentUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, 
                                         new Color(75, 156, 211)));
        studentPanel.add(studentUsername);
        
        studentPasswordLabel = new JLabel("Password");
        studentPasswordLabel.setFont(new Font("Agency FB",Font.BOLD,25));
        studentPasswordLabel.setBounds(200,370,200,50);
        studentPanel.add(studentPasswordLabel);
         
        studentPassword = new JTextField();
        studentPassword.setFont(new Font("Times New Roman",Font.BOLD,20));
        studentPassword.setHorizontalAlignment(JTextField.CENTER);
        studentPassword.setBounds(85,410,300,50);
        studentPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, 
                                         new Color(75, 156, 211)));
        studentPanel.add(studentPassword);
         
        nextButton3 = new JButton("Register");
        nextButton3.setFont(new Font("Agency FB",Font.BOLD,22));
        nextButton3.setForeground(new Color(75,156,211));
        nextButton3.setBackground(Color.WHITE);
        nextButton3.setBorder(new LineBorder(new Color(75,156,211)));
        nextButton3.setFocusable(false);
        nextButton3.setBounds(85,525,300,50);
        nextButton3.addActionListener(this);
        studentPanel.add(nextButton3);   
        this.add(studentPanel);
      }
   }
    /***************************************************************************
     * 
     */
    public void go2StudentRegistrationPage(){
        if(isStudentRegistration){
            isStudentSetUpPage = false;     
            studentPanel.setVisible(false);
            resultsPanel = new JPanel();
            resultsPanel.setLayout(null);
            resultsPanel.setBackground(Color.WHITE);
            resultsPanel.setBounds(500,0,500,700);
            this.add(resultsPanel);
        
            studentFName.setText("Full Name:");
            studentFName.setBounds(150,100,200,50);
            resultsPanel.add(studentFName);
        
            Name = new JLabel(studentFirstName.getText() +  " " + 
                          studentLastName.getText());
            Name.setFont(new Font("Agency FB",Font.BOLD,25));
            Name.setBounds(250,100,200,50);
            resultsPanel.add(Name);
        
            studentUsernameLabel.setText("Username:");
            studentUsernameLabel.setBounds(150,200,200,50);
            resultsPanel.add(studentUsernameLabel);
        
            Username = new JLabel(studentUsername.getText());
            Username.setFont(new Font("Agency FB",Font.BOLD,25));
            Username.setBounds(250,200,200,50);
            resultsPanel.add(Username);
        
            studentPasswordLabel.setText("Password:");
            studentPasswordLabel.setBounds(150,300,200,50);
            resultsPanel.add(studentPasswordLabel);
        
            Password = new JLabel(studentPassword.getText());
            Password.setFont(new Font("Agency FB",Font.BOLD,25));
            Password.setBounds(250,300,200,50);
            resultsPanel.add(Password);
        
            changeInfo = new JButton("Change Your Info.");
            changeInfo.setFont(new Font("Agency FB",Font.BOLD,22));
            changeInfo.setForeground(new Color(75,156,211));
            changeInfo.setBackground(Color.WHITE);
            changeInfo.setBorder(new LineBorder(new Color(75,156,211)));
            changeInfo.setFocusable(false);
            changeInfo.setBounds(50,500,150,50);
            changeInfo.addActionListener(this);
            changeInfo.addMouseListener(this);
            resultsPanel.add(changeInfo);
        
            keepResults = new JButton("Register My Info.");
            keepResults.setFont(new Font("Agency FB",Font.BOLD,22));
            keepResults.setForeground(new Color(75,156,211));
            keepResults.setBackground(Color.WHITE);
            keepResults.setBorder(new LineBorder(new Color(75,156,211)));
            keepResults.setFocusable(false);
            keepResults.setBounds(250,500,150,50);
            keepResults.addActionListener(this);
            keepResults.addMouseListener(this);
            resultsPanel.add(keepResults);
        
      }   
  }
    /***************************************************************************
     * 
     * @param student
     * @throws IOException 
     */
    public void addStudent(Student student) throws IOException{
         //FileWriter and a PrintWriter to store Student's Account Information
        //intto the system.
        fw3 = new FileWriter(studentUsernames);
        usernameWriter2 = new PrintWriter(fw3);
        fw4 = new FileWriter(studentPasswords);
        passwordWriter2 = new PrintWriter(fw4);  
    }
    /***************************************************************************
     * 
     * @param student 
     */
    public void go2StudentAccount(Student student){
        
    
    
    }
    /**
     * 
     * @param e 
     * @throws java.io.IOException 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == signinButton){
             try {
                 if(isValidTutorUser(userName.getText(),passWord.getText())){
                     go2TutorAccount(userName.getText(),
                     passWord.getText());
                     
                 }
             } catch (FileNotFoundException ex) {
                 ex.printStackTrace();
             }
         }
         if(e.getSource() == signupButton){
             go2RegisterOptions();
         }
         if(e.getSource() == nextButton1){
             if(tutorOption.isSelected()){
                 isTutorSetUpPage = true;
                 go2TutorSetupPage();
             }
             if(studentOption.isSelected()){
                 isStudentSetUpPage = true;
                 go2StudentSetupPage();
             }
         }
         if(e.getSource() == nextButton2){
             if(tutorFirstName.getText().equals("") && 
                tutorLastName.getText().equals("") &&
                tutorUsername.getText().equals("") &&
                tutorPassword.getText().equals("")){
             }else{
                  isTutorRegistration = true;
                  go2TutorRegistrationPage();
             }
         }
         if(e.getSource() == nextButton3){
             if(studentFirstName.getText().equals("") &&
                studentLastName.getText().equals("") &&
                studentUsername.getText().equals("") &&
                studentPassword.getText().equals("")){
             }else{
                 isStudentRegistration = true;
                 go2StudentRegistrationPage(); 
             }   
         }
         if(e.getSource() == changeInfo){
             if(isTutorRegistration){
                 resultsPanel.setVisible(false);
                 isTutorSetUpPage = true;
                 go2TutorSetupPage();
             }
             if(isStudentRegistration){
                 resultsPanel.setVisible(false);
                 isStudentSetUpPage = true;
                 go2StudentSetupPage();
             }
         }
         if(e.getSource() == keepResults){
             if(isTutorRegistration){
                 try {
                     addTutor((new Tutor(tutorFirstName.getText(),
                     tutorLastName.getText(), tutorUsername.getText(), 
                     tutorPassword.getText())));
                     go2HomePage();
                 } catch (IOException ex) {
                     ex.printStackTrace();
                 }
                 
             }
             if(isStudentRegistration){
                 //addStudent(new Student());
                 go2HomePage();
             }
         }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == signinButton){
             signinButton.setForeground(new Color(75, 156, 211));
             signinButton.setBackground(Color.WHITE); 
        }
        if(e.getSource() == signupButton){
             signupButton.setForeground(new Color(75, 156, 211));
             signupButton.setBackground(Color.WHITE);
        }
        if(e.getSource() == changeInfo){
            changeInfo.setForeground(Color.WHITE);
            changeInfo.setBackground(new Color(75, 156, 211));
        }
        if(e.getSource() == keepResults){
            keepResults.setForeground(Color.WHITE);
            keepResults.setBackground(new Color(75, 156, 211));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == signinButton){
             signinButton.setForeground(Color.WHITE);
             signinButton.setBackground(new Color(75, 156, 211));
        }
        if(e.getSource() == signupButton){
             signupButton.setForeground(Color.WHITE);
             signupButton.setBackground(new Color(75, 156, 211));
        }
        if(e.getSource() == changeInfo){
            changeInfo.setForeground(new Color(75,156,211));
            changeInfo.setBackground(Color.WHITE);
        }
        if(e.getSource() == keepResults){
            keepResults.setForeground(new Color(75,156,211));
            keepResults.setBackground(Color.WHITE);
        }
    }
    
       public static void main(String[] args) throws IOException {
        TutorProgram tutorProgram = new TutorProgram();
    }
}