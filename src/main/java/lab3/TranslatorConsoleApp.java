package main.java.lab3;

import main.java.lab3.exception.IncorrectFileException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class TranslatorConsoleApp extends JFrame {
    private String pathToDictionaryFile;
    private String pathToTextFile;

    private String exception;

    public TranslatorConsoleApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 1000);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel pathToDictionaryFileLabel = new JLabel("Укажите путь к словарю:");
        pathToDictionaryFileLabel.setBounds(27, 16, 400, 23);
        contentPane.add(pathToDictionaryFileLabel);

        JTextField pathToDictionaryFileField = new JTextField();
        pathToDictionaryFileField.setBounds(27, 39, 450, 23);
        pathToDictionaryFileField.setColumns(500);
        pathToDictionaryFileField.setEditable(false);
        contentPane.add(pathToDictionaryFileField);

        JButton btnSelectDictionaryFile = new JButton("Выбрать путь");
        btnSelectDictionaryFile.setBounds(477, 39, 150, 23);
        contentPane.add(btnSelectDictionaryFile);

        JFileChooser pathDictionaryFileChooser = new JFileChooser("./src/main/data/lab3/");
        btnSelectDictionaryFile.addActionListener(e -> {
            pathDictionaryFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = pathDictionaryFileChooser.showOpenDialog(TranslatorConsoleApp.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                pathToDictionaryFileField.setText(String.valueOf(pathDictionaryFileChooser.getSelectedFile()));
                pathToDictionaryFile = pathToDictionaryFileField.getText();
            }
        });

        JLabel pathToTextFileLabel = new JLabel("Укажите путь к тексту для перевода:");
        pathToTextFileLabel.setBounds(27, 78, 400, 23);
        contentPane.add(pathToTextFileLabel);

        JTextField pathToTextFileField = new JTextField();
        pathToTextFileField.setBounds(27, 101, 450, 23);
        pathToTextFileField.setColumns(500);
        pathToTextFileField.setEditable(false);
        contentPane.add(pathToTextFileField);

        JButton btnSelectTextFile = new JButton("Введите путь");
        btnSelectTextFile.setBounds(477, 101, 150, 23);
        contentPane.add(btnSelectTextFile);

        JFileChooser pathTextFileChooser = new JFileChooser("./src/main/data/lab3/");
        btnSelectTextFile.addActionListener(e -> {
            pathTextFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = pathTextFileChooser.showOpenDialog(TranslatorConsoleApp.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                pathToTextFileField.setText(String.valueOf(pathTextFileChooser.getSelectedFile()));
                pathToTextFile = pathToTextFileField.getText();
            }
        });

        JLabel exceptionLabel = new JLabel("Ошибки:");
        exceptionLabel.setBounds(27, 203, 400, 23);
        contentPane.add(exceptionLabel);

        JTextField exceptionField = new JTextField();
        exceptionField.setBounds(27, 226, 500, 23);
        exceptionField.setColumns(500);
        exceptionField.setEditable(false);
        contentPane.add(exceptionField);

        JLabel translatedTextLabel = new JLabel("Перевод:");
        translatedTextLabel.setBounds(27, 250, 400, 23);
        contentPane.add(translatedTextLabel);

        JTextArea translatedTextField = new JTextArea();
        translatedTextField.setBounds(27, 273, 600, 150);
        translatedTextField.setColumns(500);
        translatedTextField.setEditable(false);
        contentPane.add(translatedTextField);

        JButton btnTranslate = new JButton("Перевести");
        btnTranslate.addActionListener(arg0 -> {
            if(arg0.getSource() == btnTranslate) {
                Translator translator = new Translator();
                try {
                    translator.loadDictionary(pathToDictionaryFile);
                } catch (IOException e) {
                    exception = "Dictionary file not found";
                    exceptionField.setText(exception);
                    throw new IncorrectFileException(exception);
                }
                try {
                    translator.loadText(pathToTextFile);
                } catch (IOException e) {
                    exception = "Input text file not found";
                    exceptionField.setText(exception);
                    throw new IncorrectFileException(exception);
                }
                translator.getTranslatedText(translator.getArrayFromString());
                translatedTextField.setText(translator.getTextTranslatedOutput());
            }
            setVisible(true);
        });
        btnTranslate.setBounds(27, 140, 600, 40);
        contentPane.add(btnTranslate);

        JButton btnExit = new JButton("Выход");
        btnExit.addActionListener((ActionEvent e) -> {
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        });
        btnExit.setBounds(522, 425, 105, 23);
        contentPane.add(btnExit);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TranslatorConsoleApp frame = new TranslatorConsoleApp();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
