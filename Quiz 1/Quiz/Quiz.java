
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

public class Quiz extends JFrame {

    private ImageIcon image;
    private JLabel label;

    public Quiz() {
        setSize(1200, 800);
        setTitle("Quiz");
        image = new ImageIcon(getClass().getResource("FotorCreated1.jpg"));
        label = new JLabel(image);
        label.setBounds(1180, 780, 1200, 800);
        add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    
    public static void main(String[] args) {
        //Code for window
        Quiz window = new Quiz();
        JFrame w = new JFrame();
        window.setVisible(true);
        //Code for Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        //Code for buttons
        JButton start = new JButton("Yes");
        //Code for start button
        start.setBackground(Color.green);
        start.setForeground(Color.white);
        start.setBounds(580, 200, 130, 80);
        start.addActionListener(new startButton());
        panel.add(start);
        //Code for end button
        JButton end = new JButton("No");
        end.setBackground(Color.red);
        end.setForeground(Color.white);
        end.setBounds(580, 425, 130, 80);
        end.addActionListener(new endButton());
        panel.add(end);
        window.add(panel);

    }

    public static void run() throws FileNotFoundException {
        double points = 0;
        int numQuestions = 0, questionCounter = 0;
        String answer, question, quest;
        Scanner questionReader = new Scanner(new File("Questions.in"));
        Scanner answerReader = new Scanner(new File("Answers.in"));

        numQuestions = questionReader.nextInt();
        quest = questionReader.nextLine();
        
        while (questionCounter < numQuestions) {
            questionCounter++;
            quest = questionReader.nextLine();
            answer = answerReader.nextLine();
            question = JOptionPane.showInputDialog(null,quest);
            if (questionCounter == 1) {
                if (question.equalsIgnoreCase(answer)
                        || question.equalsIgnoreCase("six")) {
                    points++;
                }
            }
            if (questionCounter == 2) {
                if (question.equalsIgnoreCase(answer)
                        || question.equalsIgnoreCase("Eighty-one")) {
                    points++;
                }

            }
            if(questionCounter == 3){
                if(question.equalsIgnoreCase(answer) ||
                   question.equalsIgnoreCase("AI")){
                    points++;
                }
            }

        }
        JOptionPane.showMessageDialog(null, "Here is your score: "
                + getScore(points, numQuestions) + "%");

        System.exit(0);
    }

    private static class startButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                run();
            } catch (FileNotFoundException ex) {
                //
            }
        }

    }

    private static class endButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            System.exit(0);
        }

    }

    public static double getScore(double points, double questions) {
        return (points / questions) * 100;
    }

}
