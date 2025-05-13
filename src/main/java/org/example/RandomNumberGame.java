package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomNumberGame implements ActionListener {

    //Generate and assign random number
    Random r= new Random();
    int r1 = r.nextInt(1000);
    int numberToGuess = r1;

    //Wording
    String play = "Lets Play!";
    String less = "Less";
    String more = "More";
    String correct = "Correct!";


    //GUI Stuff
    JLabel label;
    JLabel label2;
    JButton button;
    JFrame frame;
    JPanel panel;
    JTextField textField;

    //This builds the frame of the GUI
    public RandomNumberGame() {
        //creating a frame
        frame = new JFrame();

        //what to display on frame
        label = new JLabel("Guess the number I'm thinking of between 0-999");
        textField = new JTextField(10);
        button = new JButton("Submit");
        label2 = new JLabel(play);
        button.addActionListener(this);

        //formatting panel
        panel = new JPanel();
        button.setPreferredSize(new Dimension(50, 40));
        panel.setPreferredSize(new Dimension(500,500));
        textField.setMaximumSize(new Dimension(100, 30));
        panel.setBorder(BorderFactory.createEmptyBorder(30,50,10,50));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        //adding to panel
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        panel.add(label2);

        //adding to frame
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Our GUI");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new RandomNumberGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // on click to use that random number and display if the user left or right of it
        try {
            //get the user's input and convert to integer
            int userGuess = Integer.parseInt(textField.getText().trim());

            int howFarAway = Math.abs(numberToGuess - userGuess);
            //compare with the random number
            if (userGuess < numberToGuess) {
                label2.setText(more + ", only " + howFarAway + " away from the answer");
            } else if (userGuess > numberToGuess) {
                label2.setText(less + ", only " + howFarAway + " away from the answer");
            } else {
                label2.setText(correct);
                button.setEnabled(false);
            }
        } catch (NumberFormatException ex) {
            label2.setText("Please enter a valid number.");
        }
    }
}
