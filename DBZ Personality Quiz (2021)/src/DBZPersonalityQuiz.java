import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
/**
 * "Dragonball Z" Personality Quiz that tells the user what character in the
 * popular television series "Dragonball Z" that matches their personality
 * @author: Christopher Martin
 */
public class DBZPersonalityQuiz extends JFrame implements ActionListener,MouseListener{
    //Components for Main Menu
    Image icon;
    JPanel panelTop;
    JLabel labelTop;
    ImageIcon labelImage;
    JPanel panelMiddle;
    JLabel labelMiddle;
    ImageIcon iconMiddle;
    JPanel panelBottom;
    JLabel arrow;
    ImageIcon arrowImage;
    JButton startButton;
    ImageIcon startLogo;
    JButton exitButton;
    ImageIcon exitLogo;
    
    //Components for the Quiz Options
    JPanel quizOptionsPanel;
    JPanel leftPanel;
    JPanel midQuizPanel;
    JPanel rightPanel;
    JLabel veggokuLabel;
    JLabel krillinand18Label;
    JLabel piccolobeerusLabel;
    JButton vegetagokuButton;
    JButton krillinand18Button;
    JButton piccolobeerusButton;
    
    //Components for 1st Quiz
    boolean isVegGokuQuiz = false;
    JPanel topPanelQuiz1;
    JPanel bottomPanelQuiz1;
    JLabel questionsLabel;
    JRadioButton answer1;
    JRadioButton answer2;
    ButtonGroup buttonGroup1;
    JButton nextquestionButton;
    int gokuPoints = 0;
    int vegetaPoints = 0;
    String[] quiz1Questions;
    String[]answersQuiz1 = {"I would happily help them.",
        "Tell them, \"Get lost,and do it yourself!\"", 
        "\"To be the best!!\"","\"Someone else!!\"",
        "\"No, I don't even know what he looks like.\"","\"Hell Yeah!!\"",
        "\"I want to keep competing until I've reached my limits!!\"",
        "\"I want to be the best, not 2nd to that fool, Kakarot!!!\""};
    int questionNumber1 = 1;
    int answerNumber1 = 0;
    JButton getResults1;
    JPanel gokuPanel;
    JPanel vegetaPanel;
    JLabel gokuResult;
    JLabel goku2;
    JLabel vegetaResult;
    JLabel vegeta2;
    JPanel vegitoPanel;
    JLabel vegitoResult;
    JLabel vegito;
    JPanel vegitoLeft;
    JPanel vegitoRight;
    JPanel gogetaPanel;
    JPanel gogetaLeft;
    JPanel gogetaRight;
    JLabel gogetaResult;
    JLabel gogeta;
    String musicfilePath;
    AudioStream audioStream1;
    Clip quizClip;
    Clip gokuClip;
    Clip vegetaClip;
    Clip vegitoClip;
    Clip gogetaClip;
    
    //Components for the 2nd Quiz
    boolean Krillinand18Quiz = false;
    int krillinPoints = 0;
    int android18Points = 0;
    String[] quiz2Questions;
    String[] answersQuiz2 = 
    {"\"Yeah, they've changed my perception of them so much.\"",
     "\"I love them just the way they are.\"",
     "\"I guess you could say that I am a \"beta\"",
     "\"I am definitely the \"alpha\"",
     "\"Yes\"",
     "\"Hell no!!!\""};
    int questionNumber2 = 1;
    int answerNumber2 = 0;
    JPanel krillinPanel;
    JPanel android18Panel;
    JLabel krillinResult;
    JLabel krillin;
    JLabel android18Result;
    JLabel android18;
    Clip krillinClip;
    Clip android18Clip;
    
    //Components for the 3rd Quiz
    boolean PiccoloandBeerusQuiz = false;
    int piccoloPoints = 0;
    int beerusPoints = 0;
    String[] quiz3Questions;
    String []answersQuiz3 = {"\"Yes!\"","\"No!\"",
                "\"Hell yeah, I would.\"","\"Naw, I'll let them slide..\"",
                "\"Are you joking? I love food.\"","\"I'd rather meditate.\""};
    int questionNumber3 = 1;
    int answerNumber3 = 0;
    JPanel piccoloPanel;
    JPanel beerusPanel;
    JLabel piccoloResult;
    JLabel piccolo;
    JLabel beerusResult;
    JLabel beerus;
    Clip picccoloClip;
    Clip beerusClip;
    public DBZPersonalityQuiz(){
        //JFrame window
        icon = Toolkit.getDefaultToolkit().getImage("src//zlogoBall4.png");
        this.setIconImage(icon);
        this.setSize(900,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Dragonball Z Personality Quiz by Chris Martin");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        
        //Top Panel
        panelTop = new JPanel();
        panelTop.setLayout(null);
        panelTop.setBackground(Color.blue);
        panelTop.setBounds(0,0,900,150);
        labelTop = new JLabel();
        labelTop.setBounds(0,0,900,150);
        labelImage = new ImageIcon("src//quizTitleLogo2.png");
        labelTop.setIcon(labelImage);
        panelTop.add(labelTop);
     
        //Middle Panel
        panelMiddle = new JPanel();
        panelMiddle.setLayout(null);
        panelMiddle.setBounds(0,150,900,450);
        labelMiddle = new JLabel();
        labelMiddle.setBounds(0,0,950,450);
        iconMiddle = new ImageIcon("src//middleBG.png");
        labelMiddle.setIcon(iconMiddle);
        panelMiddle.add(labelMiddle);
          
        //Bottom Panel
        panelBottom = new JPanel();
        panelBottom.setLayout(null);
        panelBottom.setBackground(Color.ORANGE);
        panelBottom.setBounds(0,500,900,280);
        panelBottom.setBackground(Color.blue);
        arrow = new JLabel();
        arrow.setBounds(325,120,100,100);
        arrowImage = new ImageIcon("src//arrowLogo.png");
        arrow.setIcon(arrowImage);
        panelBottom.add(arrow);
        startButton = new JButton("Start Game");
        startButton.setBounds(400,155,100,35);
        startLogo = new ImageIcon("src//startButton.png");
        startButton.setIcon(startLogo);
        startButton.addActionListener(this);
        startButton.addMouseListener(this);
        panelBottom.add(startButton);
        exitButton = new JButton();
        exitButton.setBounds(400,200,100,35);
        exitLogo = new ImageIcon("src//exitButton.png");
        exitButton.setIcon(exitLogo);
        exitButton.addActionListener(this);
        exitButton.addMouseListener(this);
        panelBottom.add(exitButton);
        
        this.add(panelTop);
        this.add(panelMiddle);
        this.add(panelBottom);
        this.setVisible(true);
    } 
    /***************************************************************************
     * This method shows the user the "Quiz Options".
     */
    public void gotoQuizOptions(){
         //Clears Window when its time for the user to see their Quiz Options
         panelTop.setVisible(false);
         panelMiddle.setVisible(false);
         panelBottom.setVisible(false);
 
         //Main Panel for Quiz Options
         quizOptionsPanel = new JPanel();
         quizOptionsPanel.setLayout(null);
         quizOptionsPanel.setBounds(0,0,900,800);
       
         //1st Third of the Panel is the 1st Option for Quizzes
         leftPanel = new JPanel();
         leftPanel.setLayout(null);
         leftPanel.setBounds(0,0,300,800);
         veggokuLabel = new JLabel(new ImageIcon("src//VegetaGoku.png"));
         veggokuLabel.setBounds(73,50,150,150);
         veggokuLabel.addMouseListener(this);
         leftPanel.add(veggokuLabel);
         vegetagokuButton = new JButton(
                 new ImageIcon("src//veggokuButton.png"));
         vegetagokuButton.setBounds(54,400,200,120);
          vegetagokuButton.addActionListener(this);
         leftPanel.add(vegetagokuButton);
         JPanel halfPanel1 = new JPanel();
         halfPanel1.setLayout(null);
         halfPanel1.setBounds(0,0,150,800);
         halfPanel1.setBackground(Color.BLUE);
         leftPanel.add(halfPanel1);
         JPanel halfPanel2 = new JPanel();
         halfPanel2.setLayout(null);
         halfPanel2.setBounds(150,0,150,800);
         halfPanel2.setBackground(Color.RED);
         leftPanel.add(halfPanel2);
         
         // 2/3 of the Panel is the 2nd Option for Quizzes
         midQuizPanel = new JPanel();
         midQuizPanel.setLayout(null);
         midQuizPanel.setBounds(300,0,300,800);
      krillinand18Label = new JLabel(new ImageIcon("src//Krillin&18.png"));
      krillinand18Label.setBounds(74,50,150,150);
      krillinand18Label.addMouseListener(this);
      midQuizPanel.add(krillinand18Label);
 krillinand18Button = new JButton(new ImageIcon("src//krillinand18Button.png"));
         krillinand18Button.setBounds(54,400,200,120);
         krillinand18Button.addActionListener(this);
         midQuizPanel.add(krillinand18Button);
         JPanel halfPanel3 = new JPanel();
         halfPanel3.setLayout(null);
         halfPanel3.setBounds(0,0,150,800);
         halfPanel3.setBackground(new Color(242,218,145));
         midQuizPanel.add(halfPanel3);
         JPanel halfPanel4 = new JPanel();
         halfPanel4.setBounds(150,0,150,800);
         halfPanel4.setBackground(new Color(255,69,0));
         midQuizPanel.add(halfPanel4);
         
         //The last third of the Panel is the 3rd Option for Quizzes
         rightPanel = new JPanel();
         rightPanel.setLayout(null);
         rightPanel.setBounds(600,0,300,800);
         piccolobeerusLabel = new JLabel(
                 new ImageIcon("src//PiccoloBeerus.png"));
         piccolobeerusLabel.setBounds(73,50,150,150);
         piccolobeerusLabel.addMouseListener(this);
         rightPanel.add(piccolobeerusLabel);
         piccolobeerusButton = new JButton(new 
         ImageIcon("src//piccolobeerusButton.png"));
         piccolobeerusButton.setBounds(54,400,200,120);
         piccolobeerusButton.addActionListener(this);
         rightPanel.add(piccolobeerusButton);
         JPanel halfPanel5 = new JPanel();
         halfPanel5.setLayout(null);
         halfPanel5.setBounds(0,0,150,800);
         halfPanel5.setBackground(new Color(34,139,34));
         rightPanel.add(halfPanel5);
         JPanel halfPanel6 = new JPanel();
         halfPanel6.setBounds(150,0,150,800);
         halfPanel6.setBackground(new Color(153,50,204));
         rightPanel.add(halfPanel6);
         
         //Quiz Options Panel adds all Quiz Option Panels
         quizOptionsPanel.add(leftPanel);
         quizOptionsPanel.add(midQuizPanel);
         quizOptionsPanel.add(rightPanel);
         this.add(quizOptionsPanel);   
    }
    /**
     * playQuizMusic(): Plays Music when a Quiz is chosen.
     */
    public void playQuizMusic(){
        try{
           musicfilePath = "C://Users//Christopher Martin//Documents//"
        + "NetBeansProjects//DBZ Personality Quiz (2021)//src//LastTimeDBZ.wav";
           AudioInputStream quizMusic = 
           AudioSystem.getAudioInputStream(new File(musicfilePath)); 
           quizClip = AudioSystem.getClip();
           quizClip.open(quizMusic);
           quizClip.start();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error, Song can't be found", 
                    "", JOptionPane.ERROR_MESSAGE, null);
        }
    }
    /***************************************************************************
     * stopQuizMusic(): This method stops the Quiz Music when user is
     * receiving their results on their quiz.
     */
    public void stopQuizMusic(){
        quizClip.stop();
    }
    /***************************************************************************
     * playGoku(): This method plays voice tracks of the DBZ Character Goku
     */
    public void playGoku(){
        try{
            musicfilePath = "C://Users//Christopher Martin//Documents//"
        + "NetBeansProjects//DBZ Personality Quiz (2021)//src//Goku Sounds.wav";
            AudioInputStream gokuVoice = 
            AudioSystem.getAudioInputStream(new File(musicfilePath));
            gokuClip = AudioSystem.getClip();
            gokuClip.open(gokuVoice);
            gokuClip.start();
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Error, Song can't be found", 
           "", JOptionPane.ERROR_MESSAGE, null);         
        }
    }
    /***************************************************************************
     * playVegeta(): This method plays voice tracks of the DBZ Character Vegeta.
     */
    public void playVegeta(){
        try{
        musicfilePath = "C://Users//Christopher Martin//Documents//"
      + "NetBeansProjects//DBZ Personality Quiz (2021)//src//Vegeta Sounds.wav";
            AudioInputStream vegetaVoice = 
            AudioSystem.getAudioInputStream(new File(musicfilePath));
            vegetaClip = AudioSystem.getClip();
            vegetaClip.open(vegetaVoice);
            vegetaClip.start();        
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Error, Song can't be found", 
           "", JOptionPane.ERROR_MESSAGE, null);       
        }
    }
    public void playVegito(){
           try{
        musicfilePath = "C://Users//Christopher Martin//Documents//"
      + "NetBeansProjects//DBZ Personality Quiz (2021)//src//Vegito Sounds.wav";
            AudioInputStream vegitoVoice = 
            AudioSystem.getAudioInputStream(new File(musicfilePath));
            vegitoClip = AudioSystem.getClip();
            vegitoClip.open(vegitoVoice);
            vegitoClip.start();        
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Error, Song can't be found", 
           "", JOptionPane.ERROR_MESSAGE, null);       
        }
    }
    /***************************************************************************
     * playGogeta: This method plays voice tracks of the DBZ Character Gogeta
     */
    public void playGogeta(){
           try{
        musicfilePath = "C://Users//Christopher Martin//Documents//"
      + "NetBeansProjects//DBZ Personality Quiz (2021)//src//Gogeta Sounds.wav";
            AudioInputStream gogetaVoice = 
            AudioSystem.getAudioInputStream(new File(musicfilePath));
            gogetaClip = AudioSystem.getClip();
            gogetaClip.open(gogetaVoice);
            gogetaClip.start();        
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Error, Song can't be found", 
           "", JOptionPane.ERROR_MESSAGE, null);       
        }
    }
    /***************************************************************************
    * playKrillin(): This method plays voice tracks of the DBZ Character Krillin
     */
    public void playKrillin(){
        try{
            musicfilePath = "C://Users//Christopher Martin//Documents//"
     + "NetBeansProjects//DBZ Personality Quiz (2021)//src//Krillin Sounds.wav";
            AudioInputStream krillinVoice =
            AudioSystem.getAudioInputStream(new File(musicfilePath));
            krillinClip = AudioSystem.getClip();
            krillinClip.open(krillinVoice);
            krillinClip.start();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error, Song can't be found", 
           "", JOptionPane.ERROR_MESSAGE, null);      
        }
        
    }
    /**
    * playAndroid18(): This method plays voice tracks of the 
    * DBZ Character Android 18
     */
    public void playAndroid18(){
           try{
            musicfilePath = "C://Users//Christopher Martin//Documents//"
   + "NetBeansProjects//DBZ Personality Quiz (2021)//src//Android18 Sounds.wav";
            AudioInputStream android18Voice =
            AudioSystem.getAudioInputStream(new File(musicfilePath));
            krillinClip = AudioSystem.getClip();
            krillinClip.open(android18Voice);
            krillinClip.start();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error, Song can't be found", 
           "", JOptionPane.ERROR_MESSAGE, null);      
        }
    }
   /***************************************************************************
    * playPiccolo(): This method plays voice tracks of the DBZ Character Piccolo
    */
    public void playPiccolo(){
              try{
            musicfilePath = "C://Users//Christopher Martin//Documents//"
   + "NetBeansProjects//DBZ Personality Quiz (2021)//src//Piccolo Sounds.wav";
            AudioInputStream piccoloVoice =
            AudioSystem.getAudioInputStream(new File(musicfilePath));
            krillinClip = AudioSystem.getClip();
            krillinClip.open(piccoloVoice);
            krillinClip.start();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error, Song can't be found", 
           "", JOptionPane.ERROR_MESSAGE, null);      
        }
    
    }
    /***************************************************************************
     * playBeerus(): This method plays voice tracks of the DBZ Character Beerus
     */
    public void playBeerus(){
              try{
            musicfilePath = "C://Users//Christopher Martin//Documents//"
   + "NetBeansProjects//DBZ Personality Quiz (2021)//src//Beerus Sounds.wav";
            AudioInputStream beerusVoice =
            AudioSystem.getAudioInputStream(new File(musicfilePath));
            krillinClip = AudioSystem.getClip();
            krillinClip.open(beerusVoice);
            krillinClip.start();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error, Song can't be found", 
           "", JOptionPane.ERROR_MESSAGE, null);      
        }
    
    }
    /***************************************************************************
     * startVegetaGokuQuiz(): This method starts the Vegeta/Goku Quiz.
     */
    public void startVegetaGokuQuiz(){
        isVegGokuQuiz = true;
        quizOptionsPanel.setVisible(false);
        this.remove(quizOptionsPanel);
        topPanelQuiz1 = new JPanel();
        topPanelQuiz1.setLayout(null);
        topPanelQuiz1.setBounds(0,0,900,400);  
        JPanel leftHalf = new JPanel();
        leftHalf.setBounds(0,0,450,400);
        leftHalf.setBackground(Color.BLUE);
        JLabel goku = new JLabel(new ImageIcon("src//goku.png"));
        goku.setBounds(225,0,250,400);
        leftHalf.add(goku);
        topPanelQuiz1.add(leftHalf);
        JPanel rightHalf = new JPanel();
        rightHalf.setBounds(450,0,450,400);
        rightHalf.setBackground(Color.red);
        JLabel vegeta = new JLabel(new ImageIcon("src//vegeta.png"));
        vegeta.setBounds(450,0,250,400);
        rightHalf.add(vegeta);
        topPanelQuiz1.add(rightHalf);
        bottomPanelQuiz1 = new JPanel();
        bottomPanelQuiz1.setLayout(null);
        bottomPanelQuiz1.setBounds(0,400,900,400);    
        bottomPanelQuiz1.setBackground(new Color(255,165,0));
        questionsLabel = new JLabel();
        questionsLabel.setFont(new Font("MV Boli",Font.BOLD,17));
        questionsLabel.setBounds(150,-20,900,100); //<------------------
        bottomPanelQuiz1.add(questionsLabel);
        buttonGroup1 = new ButtonGroup(); 
        
        answer1 = new JRadioButton(answersQuiz1[answerNumber1]);
        answer1.setFocusable(false);
        answer1.setFont(new Font("MV Boli",Font.BOLD,20));
        answer1.setBounds(250,50,900,50);
        answer1.setBackground(new Color(255,165,0));
        
        answer2 = new JRadioButton(answersQuiz1[answerNumber1 + 1]);
        answer2.setFocusable(false);
        answer2.setFont(new Font("MV Boli",Font.BOLD,20));
        answer2.setBounds(250,100,900,50);
        answer2.setBackground(new Color(255,165,0));
        buttonGroup1.add(answer1);
        buttonGroup1.add(answer2);
        
        bottomPanelQuiz1.add(answer1);
        bottomPanelQuiz1.add(answer2);
        
        nextquestionButton = new JButton(
                new ImageIcon("src//nextQuestion.png"));
        nextquestionButton.setBounds(325,250,200,50);
        nextquestionButton.addActionListener(this);
        bottomPanelQuiz1.add(nextquestionButton);
        
        this.add(bottomPanelQuiz1);
        this.add(topPanelQuiz1);
        
       quiz1Questions = new String[4];
       quiz1Questions[0] = "If someone asked you for help on their "
                + "homework, " + "what would you do?";
       quiz1Questions[1] = "Do you practice your skills to be better than "
                + "everyone or just someone else?";
       quiz1Questions[2] = "Have you ever met your father?";
       quiz1Questions[3] = "When you compete, is it for your own amusement or "
                + "is it because you desire to be the best?";
       questionsLabel.setText(quiz1Questions[0]);    
    }
    /***************************************************************************
     * startAndroid18KrillinQuiz(): This method starts the 
     * Krillin / Android 18 Quiz
     */
     public void startAndroid18KrillinQuiz(){
        Krillinand18Quiz = true;
        quizOptionsPanel.setVisible(false);
        this.remove(quizOptionsPanel);
        topPanelQuiz1 = new JPanel();
        topPanelQuiz1.setLayout(null);
        topPanelQuiz1.setBounds(0,0,900,400);  
        JPanel leftHalf = new JPanel();
        leftHalf.setBounds(0,0,450,400);
        leftHalf.setBackground(new Color(242,218,145));
        JLabel krillin1 = new JLabel(new ImageIcon("src//Krillin.png"));
        krillin1.setBounds(225,0,250,400);
        leftHalf.add(krillin1);
        topPanelQuiz1.add(leftHalf);
        JPanel rightHalf = new JPanel();
        rightHalf.setBounds(450,0,450,400);
        rightHalf.setBackground(new Color(255,69,0));
        JLabel android181 = new JLabel(new ImageIcon("src//Android 18.png"));
        android181.setBounds(450,0,250,400);
        rightHalf.add(android181);
        topPanelQuiz1.add(rightHalf);
         
        bottomPanelQuiz1 = new JPanel();
        bottomPanelQuiz1.setLayout(null);
        bottomPanelQuiz1.setBounds(0,400,900,400);    
        bottomPanelQuiz1.setBackground(new Color(255,165,0));
        questionsLabel = new JLabel();
        questionsLabel.setFont(new Font("MV Boli",Font.BOLD,20));
        questionsLabel.setBounds(180,-20,900,100); 
        bottomPanelQuiz1.add(questionsLabel);
        
        buttonGroup1 = new ButtonGroup(); 
        answer1 = new JRadioButton(answersQuiz2[answerNumber2]);
        answer1.setFocusable(false);
        answer1.setFont(new Font("MV Boli",Font.BOLD,20));
        answer1.setBounds(150,50,900,50);
        answer1.setBackground(new Color(255,165,0));
        
        answer2 = new JRadioButton(answersQuiz2[answerNumber2 + 1]);
        answer2.setFocusable(false);
        answer2.setFont(new Font("MV Boli",Font.BOLD,20));
        answer2.setBounds(150,100,900,50);
        answer2.setBackground(new Color(255,165,0));
        buttonGroup1.add(answer1);
        buttonGroup1.add(answer2);
        
        bottomPanelQuiz1.add(answer1);
        bottomPanelQuiz1.add(answer2);
        
        nextquestionButton = new JButton(
                new ImageIcon("src//nextQuestion.png"));
        nextquestionButton.setBounds(325,250,200,50);
        nextquestionButton.addActionListener(this);
        bottomPanelQuiz1.add(nextquestionButton);
       this.add(topPanelQuiz1); 
       this.add(bottomPanelQuiz1);
       quiz2Questions = new String[3];
       quiz2Questions[0] = "Is your partner better than you expected?";
       quiz2Questions[1] =  "Do you consider yourself the \"alpha\" or the "
                             + "\"beta\" in your relationship?";
       quiz2Questions[2] = "Is your partner taller than you?";
       questionsLabel.setText(quiz2Questions[0]);  
    }
     /**
      * startPiccoloBeerusQuiz(): This method starts the Piccolo/Beerus Quiz
      */
     public void startPiccoloBeerusQuiz(){
         PiccoloandBeerusQuiz = true;
         quizOptionsPanel.setVisible(false);
         this.remove(quizOptionsPanel);
         
         topPanelQuiz1 = new JPanel();
         topPanelQuiz1.setLayout(null);
         topPanelQuiz1.setBounds(0,0,900,400);  
         JPanel leftHalf = new JPanel();
         leftHalf.setBounds(0,0,450,400);
         leftHalf.setBackground(new Color(34,139,34));
         JLabel beerus1 = new JLabel(new ImageIcon("src//Beerus.png"));
         beerus1.setBounds(450,0,250,400);
         leftHalf.add(beerus1);
         topPanelQuiz1.add(leftHalf);
         JPanel rightHalf = new JPanel();
         rightHalf.setBounds(450,0,450,400);
         rightHalf.setBackground(new Color(153,50,204));
         JLabel piccolo1 = new JLabel(new ImageIcon("src//Piccolo.png"));
         piccolo1.setBounds(225,0,250,400);
         rightHalf.add(piccolo1);
         topPanelQuiz1.add(rightHalf);
         
         bottomPanelQuiz1 = new JPanel();
         bottomPanelQuiz1.setLayout(null);
         bottomPanelQuiz1.setBounds(0,400,900,400);    
         bottomPanelQuiz1.setBackground(new Color(255,165,0));
         questionsLabel = new JLabel();
         questionsLabel.setFont(new Font("MV Boli",Font.BOLD,20));
         questionsLabel.setBounds(330,-20,900,100); 
         bottomPanelQuiz1.add(questionsLabel);
         
         buttonGroup1 = new ButtonGroup(); 
         answer1 = new JRadioButton(answersQuiz3[answerNumber3]);
         answer1.setFocusable(false);
         answer1.setFont(new Font("MV Boli",Font.BOLD,20));
         answer1.setBounds(300,50,900,50);
         answer1.setBackground(new Color(255,165,0));
        
         answer2 = new JRadioButton(answersQuiz3[answerNumber3 + 1]);
         answer2.setFocusable(false);
         answer2.setFont(new Font("MV Boli",Font.BOLD,20));
         answer2.setBounds(300,100,900,50);
         answer2.setBackground(new Color(255,165,0));
         buttonGroup1.add(answer1);
         buttonGroup1.add(answer2);
         bottomPanelQuiz1.add(answer1);
         bottomPanelQuiz1.add(answer2);
        
        nextquestionButton = new JButton(
                new ImageIcon("src//nextQuestion.png"));
        nextquestionButton.setBounds(325,250,200,50);
        nextquestionButton.addActionListener(this);
        bottomPanelQuiz1.add(nextquestionButton);
        this.add(topPanelQuiz1); 
        this.add(bottomPanelQuiz1);
        
        quiz3Questions = new String[3];
        quiz3Questions[0] = "Do you love pizza?";
        quiz3Questions[1] =  "If you had the power to, "
                + "would you destroy everyone that annoyed you?";
        quiz3Questions[2] = "Would you rather meditate, or eat "
                + "at a buffet until your gut exploded?";
        questionsLabel.setText(quiz3Questions[0]);      
     }
    /*************************************************************************/
    /**
     * go2NextQuestion1(String[] questions): This method goes to the next
     * question of the Vegeta/Goku Quiz.
     * @param questions
     * @param question 
     */
    public void go2NextQuestion1(String[]questions){
              buttonGroup1.clearSelection();
              questionNumber1 += 1;
         if(questionNumber1 == 2){             
             questionsLabel.setText(questions[questionNumber1 - 1]); 
             questionsLabel.setBounds(150,-20,900,100);
             
              answer1.setText(answersQuiz1[answerNumber1 + 2]);      
              answer1.setFont(new Font("MV Boli",Font.BOLD,20));
              answer1.setBounds(300,50,900,50);
                
              answer2.setText(answersQuiz1[answerNumber1 + 3]);
              answer2.setFont(new Font("MV Boli",Font.BOLD,20));
              answer2.setBounds(300,100,900,50);
          }
         if(questionNumber1 == 3){             
             questionsLabel.setText(questions[questionNumber1 - 1]);
             questionsLabel.setBounds(280,-20,900,100);
             
              answer1.setFocusable(false);
              answer1.setText(answersQuiz1[answerNumber1 + 4]);
              answer1.setFont(new Font("MV Boli",Font.BOLD,20));   
              answer1.setBounds(200,50,900,50);
             
              answer2.setText(answersQuiz1[answerNumber1 + 5]);
              answer2.setFont(new Font("MV Boli",Font.BOLD,20));
              answer2.setBounds(200,100,900,50);
              
        }
         if(questionNumber1 == 4){         
             questionsLabel.setText(questions[questionNumber1 - 1]);
             questionsLabel.setBounds(20,-20,900,100);
             
              answer1.setText(answersQuiz1[answerNumber1 + 6]);
              answer1.setFont(new Font("MV Boli",Font.BOLD,20));
              answer1.setBounds(150,50,900,50);
              answer2.setText(answersQuiz1[answerNumber1 + 7]);          
              answer2.setFont(new Font("MV Boli",Font.BOLD,20));
              answer2.setBounds(150,100,900,50);
                 
              getResults1 = new JButton(
                new ImageIcon("src//getResults.png"));
              getResults1.addActionListener(this);
              nextquestionButton.setVisible(false);
              getResults1.setBounds(325,250,200,50);          
              bottomPanelQuiz1.add(getResults1);
        }     
    }
    /**
     * go2NextQuestion2(String[] questions): This method goes to the next
     * question of the Krillin/Android 18 Quiz.
     * @param questions 
     */
    public void go2NextQuestion2(String[]questions){
            buttonGroup1.clearSelection();
            questionNumber2 += 1;
             
         if(questionNumber2 == 2){             
             questionsLabel.setText(questions[questionNumber2 - 1]); 
             questionsLabel.setBounds(100,-20,900,100);
             
              answer1.setText(answersQuiz2[answerNumber2 + 2]);      
              answer1.setFont(new Font("MV Boli",Font.BOLD,20));
              answer1.setBounds(200,50,900,50);
                
              answer2.setText(answersQuiz2[answerNumber2 + 3]);
              answer2.setFont(new Font("MV Boli",Font.BOLD,20));
              answer2.setBounds(200,100,900,50);
          }
            if(questionNumber2 == 3){         
             questionsLabel.setText(questions[questionNumber2 - 1]);
             questionsLabel.setBounds(300,-20,900,100);

              answer1.setText(answersQuiz2[answerNumber2 + 4]);
              answer1.setFont(new Font("MV Boli",Font.BOLD,20));
              answer1.setBounds(280,50,900,50);
              
              answer2.setFont(new Font("MV Boli",Font.BOLD,20));
              answer2.setText(answersQuiz2[answerNumber2 + 5]);          
              answer2.setBounds(280,100,900,50);
              
              nextquestionButton.setVisible(false);
              getResults1 = new JButton(
                new ImageIcon("src//getResults.png"));
              getResults1.addActionListener(this);
              
              getResults1.setBounds(325,250,200,50);          
              bottomPanelQuiz1.add(getResults1);
        }
    }
    /**
     * go2NextQuestion3(String[] questions): This method goes to the next
     * question of the Piccolo/Beerus Quiz.
     * @param questions 
     */
    public void go2NextQuestion3(String[] questions){
            buttonGroup1.clearSelection();
            questionNumber3 += 1;
             
         if(questionNumber3 == 2){             
             questionsLabel.setText(questions[questionNumber3 - 1]); 
             questionsLabel.setBounds(30,-20,900,100);
             
              answer1.setText(answersQuiz3[answerNumber3 + 2]);      
              answer1.setFont(new Font("MV Boli",Font.BOLD,20));
              answer1.setBounds(300,50,900,50);
                
              answer2.setText(answersQuiz3[answerNumber3 + 3]);
              answer2.setFont(new Font("MV Boli",Font.BOLD,20));
              answer2.setBounds(300,100,900,50);
          }
            if(questionNumber3 == 3){         
             questionsLabel.setText(questions[questionNumber3 - 1]);
             questionsLabel.setBounds(30,-20,900,100);

              answer1.setText(answersQuiz3[answerNumber3 + 4]);
              answer1.setFont(new Font("MV Boli",Font.BOLD,20));
              answer1.setBounds(300,50,900,50);
              
              answer2.setFont(new Font("MV Boli",Font.BOLD,20));
              answer2.setText(answersQuiz3[answerNumber3 + 5]);          
              answer2.setBounds(300,100,900,50);
              
              nextquestionButton.setVisible(false);
              getResults1 = new JButton(
                new ImageIcon("src//getResults.png"));
              getResults1.addActionListener(this);
              
              getResults1.setBounds(325,250,200,50);          
              bottomPanelQuiz1.add(getResults1);
        }
    
    }
    /*************************************************************************/
    /**
     * showResults(): Gives the user their results for taking the quiz
     * @param vegetaPoints
     * @param gokuPoints
     */
    public void showResults(int vegetaPoints,int gokuPoints){
        this.vegetaPoints = vegetaPoints;
        this.gokuPoints = gokuPoints;
        if(vegetaPoints > gokuPoints){
            showVegetaResultsPage();
        }
        if(gokuPoints > vegetaPoints){
            showGokuResultsPage();
        }
        else if(gokuPoints == vegetaPoints){
            Random fusionOptions = new Random();
            int number = fusionOptions.nextInt(2) + 1;
            if(number == 1){
                showVegitoResultsPage();
            }
       else if(number == 2){
                showGogetaResultsPage();               
            } 
        }
    }
    /***************************************************************************
     * showResults2(): Gives the user their results for taking the quiz
     * @param krillinPoints
     * @param android18Points 
     */
    public void showResults2(int krillinPoints,int android18Points){
        this.krillinPoints = krillinPoints;
        this.android18Points = android18Points;
        if(krillinPoints > android18Points){
            showKrillinResultsPage();
        }
        else if(android18Points > krillinPoints){
            showAndroid18ResultsPage();
        }
    }
    /**
     * showResults3(): Gives the user their results for taking the quiz
     * @param beerusPoints
     * @param piccoloPoints 
     */
    public void showResults3(int beerusPoints,int piccoloPoints){
        this.beerusPoints = beerusPoints;
        this.piccoloPoints = piccoloPoints;
        if(beerusPoints > piccoloPoints){
            showBeerusResultsPage();
        }else if(piccoloPoints > beerusPoints){
            showPiccoloResultsPage(); 
        } 
    }
    /***************************************************************************
     * 
     */
    public void showGokuResultsPage(){
        stopQuizMusic();
        playGoku();
         topPanelQuiz1.setVisible(false);
         bottomPanelQuiz1.setVisible(false);
         gokuPanel = new JPanel();
         gokuPanel.setLayout(null);
         gokuPanel.setBounds(0,0,900,800);
         gokuPanel.setBackground(Color.RED);
         gokuResult = new 
         JLabel("Based on your answers, you are a Goku!!!!!!!");
         gokuResult.setFont(new Font("MV Boli",Font.BOLD,20));
         gokuResult.setForeground(Color.WHITE);
         gokuResult.setBounds(200,0,600,200);
         gokuPanel.add(gokuResult);
         goku2 = new JLabel(new ImageIcon("src//Goku2.png"));
         goku2.setBounds(225,100,400,600);
         gokuPanel.add(goku2);
         this.add(gokuPanel);
    }
    /***************************************************************************
     * 
     */
    public void showVegetaResultsPage(){
        stopQuizMusic();
        playVegeta();
        topPanelQuiz1.setVisible(false);
        bottomPanelQuiz1.setVisible(false);
        vegetaPanel = new JPanel();
        vegetaPanel.setLayout(null);
        vegetaPanel.setBounds(0,0,900,800);
        vegetaPanel.setBackground(Color.BLUE);
        vegetaResult = new 
        JLabel("Based on your answers, you are a Vegeta!!!!!!!");
        vegetaResult.setFont(new Font("MV Boli",Font.BOLD,20));
        vegetaResult.setForeground(Color.WHITE);
        vegetaResult.setBounds(200,0,600,200);
        vegetaPanel.add(vegetaResult);
        vegeta2 = new JLabel(new ImageIcon("src//Vegeta2.png"));
        vegeta2.setBounds(225,100,400,600);
        vegetaPanel.add(vegeta2);
        this.add(vegetaPanel);            
    }
    /***************************************************************************
     * 
     */
    public void showVegitoResultsPage(){
        stopQuizMusic();
        playVegito();
        System.out.println("You are a Vegito!!!");
        topPanelQuiz1.setVisible(false);
        bottomPanelQuiz1.setVisible(false);
        vegitoPanel = new JPanel();
        vegitoPanel.setLayout(null);
        vegitoPanel.setBounds(0,0,900,800);
        vegitoResult = new 
        JLabel("Based on your answers, you are a Vegito!!!!!!!");
        vegitoResult.setBounds(0,0,900,100);
        vegitoResult.setFont(new Font("MV Boli",Font.BOLD,20));
        vegitoResult.setForeground(Color.WHITE);
        vegitoResult.setBounds(200,0,900,100);
        vegitoPanel.add(vegitoResult);
        vegito = new JLabel(new ImageIcon("src//Vegito.png"));
        vegito.setBounds(70,72,700,700);
        vegitoPanel.add(vegito);
        vegitoLeft = new JPanel();
        vegitoLeft.setLayout(null);
        vegitoLeft.setBounds(0,0,450,800);
        vegitoLeft.setBackground(Color.BLUE);
        vegitoPanel.add(vegitoLeft);
        vegitoRight = new JPanel();
        vegitoRight.setLayout(null);
        vegitoRight.setBounds(450,0,450,800);
        vegitoRight.setBackground(Color.RED);
        vegitoPanel.add(vegitoRight);
        this.add(vegitoPanel);
    }
    /***************************************************************************
     * 
     */
    public void showGogetaResultsPage(){
        stopQuizMusic();
        playGogeta();
        topPanelQuiz1.setVisible(false);
        bottomPanelQuiz1.setVisible(false);
        gogetaPanel = new JPanel();
        gogetaPanel.setLayout(null);
        gogetaPanel.setBounds(0,0,900,800);
        gogetaResult = new 
        JLabel("Based on your answers, you are a Gogeta!!!!!!!");
        gogetaResult.setBounds(200,0,900,100);
        gogetaResult.setFont(new Font("MV Boli",Font.BOLD,20));
        gogetaResult.setForeground(Color.WHITE);
        gogetaPanel.add(gogetaResult);
        gogeta = new JLabel(new ImageIcon("src//Gogeta.png"));
        gogeta.setBounds(120,50,600,730);
        gogetaPanel.add(gogeta);
        gogetaLeft = new JPanel();
        gogetaLeft.setLayout(null);
        gogetaLeft.setBounds(0,0,450,800);
        gogetaLeft.setBackground(Color.RED);
        gogetaPanel.add(gogetaLeft);
        gogetaRight = new JPanel();
        gogetaRight.setLayout(null);
        gogetaRight.setBounds(450,0,450,800);
        gogetaRight.setBackground(Color.BLUE);
        gogetaPanel.add(gogetaRight);
        this.add(gogetaPanel);
    }
    /***************************************************************************
     * 
     */
    public void showKrillinResultsPage(){
        stopQuizMusic();
        playKrillin();
        topPanelQuiz1.setVisible(false);
        bottomPanelQuiz1.setVisible(false);
        krillinPanel = new JPanel();
        krillinPanel.setLayout(null);
        krillinPanel.setBounds(0,0,900,800);
        krillinPanel.setBackground(new Color(255,69,0));
        krillinResult = 
        new JLabel("Based on your answers, you are a Krillin!!!!!!!");
        krillinResult.setBounds(200,0,900,100);
        krillinResult.setFont(new Font("MV Boli",Font.BOLD,20));
        krillinResult.setForeground(Color.BLACK);
        krillinPanel.add(krillinResult);
        krillin = new JLabel(new ImageIcon("src//Krillin2.png"));
        krillin.setBounds(140,50,600,730);
        krillinPanel.add(krillin);
        this.add(krillinPanel);
    }
    /***************************************************************************
     * 
     */
    public void showAndroid18ResultsPage(){
        stopQuizMusic();
        playAndroid18();
        topPanelQuiz1.setVisible(false);
        bottomPanelQuiz1.setVisible(false);
        android18Panel = new JPanel();
        android18Panel.setLayout(null);
        android18Panel.setBounds(0,0,900,800);
        android18Panel.setBackground(new Color(242,218,145));
        android18Result = new JLabel("Based on your answers, "
                + "you are an Android 18!!!!!!!");
        android18Result.setBounds(200,0,900,100);
        android18Result.setFont(new Font("MV Boli",Font.BOLD,20));
        android18Result.setForeground(Color.BLACK);
        android18Panel.add(android18Result);
        android18 = new JLabel(new ImageIcon("src//Android18-2.png"));
        android18.setBounds(140,50,600,730);
        android18Panel.add(android18);
        this.add(android18Panel);
    }
    /***************************************************************************
     * 
     */
    public void showBeerusResultsPage(){
         stopQuizMusic();
         playBeerus();
         topPanelQuiz1.setVisible(false);
         bottomPanelQuiz1.setVisible(false);
         beerusPanel = new JPanel();
         beerusPanel.setLayout(null);
         beerusPanel.setBounds(0,0,900,800);
         beerusPanel.setBackground(new Color(153,50,204));
         beerusResult = 
                 new JLabel("Based on your answers, you are a Beerus!!!!!!!");
        beerusResult.setBounds(200,0,900,100);
        beerusResult.setFont(new Font("MV Boli",Font.BOLD,20));
        beerusResult.setForeground(Color.WHITE);
        beerusPanel.add(beerusResult);
        this.add(beerusPanel);
        beerus = new JLabel(new ImageIcon("src//Beerus2.png"));
        beerus.setBounds(140,50,600,730);
        beerusPanel.add(beerus);
        this.add(beerusPanel);
    }
    /***************************************************************************
     * 
     */
    public void showPiccoloResultsPage(){
         stopQuizMusic();
         playPiccolo();
         topPanelQuiz1.setVisible(false);
         bottomPanelQuiz1.setVisible(false);
         piccoloPanel = new JPanel();
         piccoloPanel.setLayout(null);
         piccoloPanel.setBounds(0,0,900,800);
         piccoloPanel.setBackground(new Color(34,139,34));
         piccoloResult = 
                 new JLabel("Based on your answers, you are a Piccolo!!!!!!!");
         piccoloResult.setBounds(200,0,900,100);
         piccoloResult.setFont(new Font("MV Boli",Font.BOLD,20));
         piccoloResult.setForeground(Color.WHITE);
         piccoloPanel.add(piccoloResult);
         piccolo = new JLabel(new ImageIcon("src//Piccolo2.png"));
         piccolo.setBounds(140,50,600,730);
         piccoloPanel.add(piccolo);
         this.add(piccoloPanel);
    }
    /**************************************************************************/
    /**
     * 
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton){
              gotoQuizOptions();
        }
        else if(e.getSource() == exitButton){
            System.exit(0);
        }
       else if(e.getSource() == vegetagokuButton){
            playQuizMusic();
            startVegetaGokuQuiz();
        }
      else if(e.getSource() ==  krillinand18Button){
            playQuizMusic();
            startAndroid18KrillinQuiz();     
        }
      else if(e.getSource() == piccolobeerusButton){
            playQuizMusic();
            startPiccoloBeerusQuiz();    
        }
      else if(e.getSource() == nextquestionButton){
            if(isVegGokuQuiz){
                 if(answer1.isSelected()){
                 gokuPoints += 1;
                 go2NextQuestion1(quiz1Questions);
              }
            if(answer2.isSelected()){
                vegetaPoints += 1;
                go2NextQuestion1(quiz1Questions);
            }          
        }
      if(Krillinand18Quiz){
              if(answer1.isSelected()){
                  krillinPoints += 1;
                  go2NextQuestion2(quiz2Questions);
              }   
              if(answer2.isSelected()){
                  android18Points += 1;
                  go2NextQuestion2(quiz2Questions);
              }     
          }
           if(PiccoloandBeerusQuiz){
                if(answer1.isSelected()){
                    beerusPoints += 1;
                    go2NextQuestion3(quiz3Questions);
                }
                if(answer2.isSelected()){
                    piccoloPoints += 1;
                    go2NextQuestion3(quiz3Questions);
                }
            }  
        }
          if(e.getSource() == getResults1){
            if(isVegGokuQuiz){
                 if(answer1.isSelected()){
                      gokuPoints += 1;
                      showResults(vegetaPoints,gokuPoints);
               }
            else if(answer2.isSelected()){
                       vegetaPoints += 1;
                       showResults(vegetaPoints,gokuPoints);
               }
           }
            if(Krillinand18Quiz){
                if(answer1.isSelected()){
                    krillinPoints += 1;
                    showResults2(krillinPoints,android18Points);
                }
                else if(answer2.isSelected()){
                    android18Points += 1;
                     showResults2(krillinPoints,android18Points);
                }
            }
            if(PiccoloandBeerusQuiz){
                if(answer1.isSelected()){
                    beerusPoints += 1;
                    showResults3(beerusPoints,piccoloPoints);
                }
                else if(answer2.isSelected()){
                    piccoloPoints += 1;
                    showResults3(beerusPoints,piccoloPoints);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Unused Method
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //Unused Method
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //Unused Method
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       if(e.getSource() == startButton){
            arrow.setBounds(325,120,100,100);
       }
       if(e.getSource() == exitButton){
            arrow.setBounds(325,165,100,100);
       }
       if(e.getSource() == veggokuLabel){
           veggokuLabel.setBounds(60,50,180,180);     
       }
       if(e.getSource() == krillinand18Label){
           krillinand18Label.setBounds(62,50,180,180);
       }
       if(e.getSource() == piccolobeerusLabel){
            piccolobeerusLabel.setBounds(62,50,180,180);
       }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == startButton){
            arrow.setBounds(325,120,100,100);
       }
       if(e.getSource() == exitButton){
            arrow.setBounds(325,165,100,100);
       }
        if(e.getSource() == veggokuLabel){
             veggokuLabel.setBounds(73,50,150,150);
       }
       if(e.getSource() == krillinand18Label){
             krillinand18Label.setBounds(74,50,150,150);
       }
       if(e.getSource() == piccolobeerusLabel){
            piccolobeerusLabel.setBounds(73,50,150,150);
       }
    }
    
    public static void main(String[] args) {
        DBZPersonalityQuiz dbzQuiz = new DBZPersonalityQuiz();
    }
}