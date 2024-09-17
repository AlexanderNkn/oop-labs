package main.java.lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodsConsoleApp extends JFrame {

    public MethodsConsoleApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 550);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel exceptionLabel = new JLabel("Ошибки:");
        exceptionLabel.setBounds(27, 63, 400, 23);
        contentPane.add(exceptionLabel);

        JTextField exceptionField = new JTextField();
        exceptionField.setBounds(27, 86, 500, 23);
        exceptionField.setColumns(500);
        exceptionField.setEditable(false);
        contentPane.add(exceptionField);

        JLabel outputTextLabel = new JLabel("Вывод программы:");
        outputTextLabel.setBounds(27, 110, 400, 23);
        contentPane.add(outputTextLabel);

        JTextArea outputTextField = new JTextArea();
        outputTextField.setBounds(27, 133, 600, 300);
        outputTextField.setColumns(500);
        outputTextField.setEditable(false);
        contentPane.add(outputTextField);

        JButton btnGetMethod = new JButton("Вызвать методы");
        btnGetMethod.addActionListener(arg0 -> {
            if(arg0.getSource() == btnGetMethod) {
                for (Method method : Animal.class.getDeclaredMethods()) {
                    if (method.isAnnotationPresent(RepeatCallAnnotation.class)) {
                        RepeatCallAnnotation annotation = method.getAnnotation(RepeatCallAnnotation.class);
                        method.setAccessible(true);
                        int modifiers = method.getModifiers();
                        boolean isPrivateOrProtected = Modifier.isPrivate(modifiers) || Modifier.isProtected(modifiers);
                        for (int j = 0; j < annotation.count(); j++) {
                            try {
                                if (isPrivateOrProtected) {
                                    Object voice = method.invoke(new Animal());
                                    outputTextField.setText(outputTextField.getText() + voice + "\n");
                                }
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                exceptionField.setText("IllegalAccessException | InvocationTargetException");
                                e.printStackTrace();
                            }
                        }
                        if (isPrivateOrProtected) {
                            outputTextField.setText(outputTextField.getText() + '\n');
                        }
                    }
                }
            }
            setVisible(true);
        });
        btnGetMethod.setBounds(27, 20, 600, 40);
        contentPane.add(btnGetMethod);

        JButton btnExit = new JButton("Выход");
        btnExit.addActionListener((ActionEvent e) -> {
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        });
        btnExit.setBounds(532, 450, 95, 23);
        contentPane.add(btnExit);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MethodsConsoleApp frame = new MethodsConsoleApp();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
