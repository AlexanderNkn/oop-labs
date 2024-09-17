package main.java.lab1;

import javax.swing.*;

import main.java.lab1.actions.Fly;
import main.java.lab1.actions.Ride;
import main.java.lab1.actions.Walk;
import main.java.lab1.person.Hero;

import java.awt.*;
import java.awt.event.ActionEvent;

public class HeroConsoleApp extends JFrame {
    public String activity = "";

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                HeroConsoleApp frame = new HeroConsoleApp();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public HeroConsoleApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JRadioButton buttonWalk = new JRadioButton("Герой идет.");
        buttonWalk.setBounds(27, 80, 350, 23);
        contentPane.add(buttonWalk);

        JRadioButton buttonRide = new JRadioButton("Герой едет на лошади.");
        buttonRide.setBounds(27, 130, 350, 23);
        contentPane.add(buttonRide);

        JRadioButton buttonFly = new JRadioButton("Герой летит.");
        buttonFly.setBounds(27, 180, 350, 23);
        contentPane.add(buttonFly);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(buttonWalk);
        buttonGroup.add(buttonRide);
        buttonGroup.add(buttonFly);

        JLabel labelMotion = new JLabel("Выберите движение:");
        labelMotion.setBounds(27, 36, 350, 23);
        contentPane.add(labelMotion);

        JTextField answer = new JTextField();

        JButton buttonMove = new JButton("Выполнить");
        buttonMove.addActionListener(arg0 -> {
            if (arg0.getSource() == buttonMove) {
                String movement = "";
                Hero hero = new Hero();
                if (buttonWalk.isSelected()) {
                    hero.setHeroAction(new Walk());
                    movement = hero.runAction();
                } else if (buttonRide.isSelected()) {
                    hero.setHeroAction(new Ride());
                    movement = hero.runAction();
                } else if (buttonFly.isSelected()) {
                    hero.setHeroAction(new Fly());
                    movement = hero.runAction();
                } else {
                    movement = "Вы не выбрали движение.";
                }
                answer.setText(movement);
            }
            setVisible(true);
        });
        buttonMove.setBounds(350, 500, 115, 23);
        contentPane.add(buttonMove);

        answer.setBounds(30, 300, 600, 46);
        answer.setEditable(false);
        contentPane.add(answer);

        JLabel answerLabel = new JLabel("Выполняется следующее движение:");
        answerLabel.setBounds(30, 277, 350, 23);
        contentPane.add(answerLabel);

        JButton buttonExit = new JButton("Выход");
        buttonExit.addActionListener((ActionEvent e) -> {
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        });
        buttonExit.setBounds(500, 500, 95, 23);
        contentPane.add(buttonExit);
    }
}
