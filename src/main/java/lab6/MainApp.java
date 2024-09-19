package main.java.lab6;

import main.java.lab1.HeroConsoleApp;
import main.java.lab2.MatrixConsoleApp;
import main.java.lab3.TranslatorConsoleApp;
import main.java.lab4.MethodsConsoleApp;
import main.java.lab5.StreamApiConsoleApp;

import javax.swing.*;
import java.awt.*;

public class MainApp extends JFrame{
    JMenu menu;
    JMenuItem a1,a2;
    MainApp(){
        super("Лабораторные работы ООП");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 700);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnLab1 = new JButton("Лабораторная работа 1");
        btnLab1.addActionListener(arg0 -> {
            if(arg0.getSource() == btnLab1) {
                EventQueue.invokeLater(() -> {
                    try {
                        HeroConsoleApp frame = new HeroConsoleApp();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            setVisible(true);
        });
        btnLab1.setBounds(27, 20, 250, 100);
        contentPane.add(btnLab1);

        JButton btnLab2 = new JButton("Лабораторная работа 2");
        btnLab2.addActionListener(arg0 -> {
            if(arg0.getSource() == btnLab2) {
                EventQueue.invokeLater(() -> {
                    try {
                        MatrixConsoleApp frame = new MatrixConsoleApp();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            setVisible(true);
        });
        btnLab2.setBounds(27, 130, 250, 100);
        contentPane.add(btnLab2);

        JButton btnLab3 = new JButton("Лабораторная работа 3");
        btnLab3.addActionListener(arg0 -> {
            if(arg0.getSource() == btnLab3) {
                EventQueue.invokeLater(() -> {
                    try {
                        TranslatorConsoleApp frame = new TranslatorConsoleApp();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            setVisible(true);
        });
        btnLab3.setBounds(27, 240, 250, 100);
        contentPane.add(btnLab3);

        JButton btnLab4 = new JButton("Лабораторная работа 4");
        btnLab4.addActionListener(arg0 -> {
            if(arg0.getSource() == btnLab4) {
                EventQueue.invokeLater(() -> {
                    try {
                        MethodsConsoleApp frame = new MethodsConsoleApp();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            setVisible(true);
        });
        btnLab4.setBounds(27, 350, 250, 100);
        contentPane.add(btnLab4);

        JButton btnLab5 = new JButton("Лабораторная работа 5");
        btnLab5.addActionListener(arg0 -> {
            if(arg0.getSource() == btnLab5) {
                EventQueue.invokeLater(() -> {
                    try {
                        StreamApiConsoleApp frame = new StreamApiConsoleApp();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            setVisible(true);
        });
        btnLab5.setBounds(27, 460, 250, 100);
        contentPane.add(btnLab5);

        JButton btnExit = new JButton("Выход");
        btnExit.addActionListener(e -> System.exit(0));
        btnExit.setBounds(182, 570, 95, 30);
        contentPane.add(btnExit);
    }

    public static void main(String args[]){
        EventQueue.invokeLater(() -> {
            try {
                MainApp frame = new MainApp();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
