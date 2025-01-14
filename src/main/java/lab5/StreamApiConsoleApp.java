package main.java.lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiConsoleApp extends JFrame{
    List<Integer> list1;
    List<String> list2;
    List<Integer> list3;
    List<String> list4;
    List<Integer> list5;
    int[] a6;
    List<String> list7;

    public StreamApiConsoleApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 600);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //Task 1
        JLabel task1Label = new JLabel("Задача 1:");
        task1Label.setBounds(27, 60, 250, 23);
        contentPane.add(task1Label);

        JLabel task1InputDatalabel = new JLabel("Исходные данные:");
        task1InputDatalabel.setBounds(27, 83, 250, 23);
        contentPane.add(task1InputDatalabel);

        JTextField task1InputDataField = new JTextField();
        task1InputDataField.setBounds(27, 106, 250, 23);
        task1InputDataField.setColumns(500);
        task1InputDataField.setEditable(false);
        contentPane.add(task1InputDataField);

        JLabel task1OutputDatalabel = new JLabel("Результат:");
        task1OutputDatalabel.setBounds(27, 129, 250, 23);
        contentPane.add(task1OutputDatalabel);

        JTextField task1OutputDataField = new JTextField();
        task1OutputDataField.setBounds(27, 152, 250, 23);
        task1OutputDataField.setColumns(500);
        task1OutputDataField.setEditable(false);
        contentPane.add(task1OutputDataField);

        //Task 2
        JLabel task2Label = new JLabel("Задача 2:");
        task2Label.setBounds(327, 60, 350, 23);
        contentPane.add(task2Label);

        JLabel task2InputDatalabel = new JLabel("Исходные данные:");
        task2InputDatalabel.setBounds(327, 83, 350, 23);
        contentPane.add(task2InputDatalabel);

        JTextField task2InputDataField = new JTextField();
        task2InputDataField.setBounds(327, 106, 350, 23);
        task2InputDataField.setColumns(500);
        task2InputDataField.setEditable(false);
        contentPane.add(task2InputDataField);

        JLabel task2OutputDatalabel = new JLabel("Результат:");
        task2OutputDatalabel.setBounds(327, 129, 350, 23);
        contentPane.add(task2OutputDatalabel);

        JTextField task2OutputDataField = new JTextField();
        task2OutputDataField.setBounds(327, 152, 350, 23);
        task2OutputDataField.setColumns(500);
        task2OutputDataField.setEditable(false);
        contentPane.add(task2OutputDataField);

        //Task 3
        JLabel task3Label = new JLabel("Задача 3:");
        task3Label.setBounds(27, 176, 250, 23);
        contentPane.add(task3Label);

        JLabel task3InputDatalabel = new JLabel("Исходные данные:");
        task3InputDatalabel.setBounds(27, 199, 250, 23);
        contentPane.add(task3InputDatalabel);

        JTextField task3InputDataField = new JTextField();
        task3InputDataField.setBounds(27, 222, 250, 23);
        task3InputDataField.setColumns(500);
        task3InputDataField.setEditable(false);
        contentPane.add(task3InputDataField);

        JLabel task3OutputDatalabel = new JLabel("Результат:");
        task3OutputDatalabel.setBounds(27, 245, 250, 23);
        contentPane.add(task3OutputDatalabel);

        JTextField task3OutputDataField = new JTextField();
        task3OutputDataField.setBounds(27, 268, 250, 23);
        task3OutputDataField.setColumns(500);
        task3OutputDataField.setEditable(false);
        contentPane.add(task3OutputDataField);

        //Task 4
        JLabel task4Label = new JLabel("Задача 4:");
        task4Label.setBounds(327, 176, 350, 23);
        contentPane.add(task4Label);

        JLabel task4InputDatalabel = new JLabel("Исходные данные:");
        task4InputDatalabel.setBounds(327, 199, 350, 23);
        contentPane.add(task4InputDatalabel);

        JTextField task4InputDataField = new JTextField();
        task4InputDataField.setBounds(327, 222, 350, 23);
        task4InputDataField.setColumns(500);
        task4InputDataField.setEditable(false);
        contentPane.add(task4InputDataField);

        JLabel task4OutputDatalabel = new JLabel("Результат:");
        task4OutputDatalabel.setBounds(327, 245, 350, 23);
        contentPane.add(task4OutputDatalabel);

        JTextField task4OutputDataField = new JTextField();
        task4OutputDataField.setBounds(327, 268, 350, 23);
        task4OutputDataField.setColumns(500);
        task4OutputDataField.setEditable(false);
        contentPane.add(task4OutputDataField);

        //Task 5
        JLabel task5Label = new JLabel("Задача 5:");
        task5Label.setBounds(27, 291, 250, 23);
        contentPane.add(task5Label);

        JLabel task5InputDatalabel = new JLabel("Исходные данные:");
        task5InputDatalabel.setBounds(27, 314, 250, 23);
        contentPane.add(task5InputDatalabel);

        JTextField task5InputDataField = new JTextField();
        task5InputDataField.setBounds(27, 337, 250, 23);
        task5InputDataField.setColumns(500);
        task5InputDataField.setEditable(false);
        contentPane.add(task5InputDataField);

        JLabel task5OutputDatalabel = new JLabel("Результат:");
        task5OutputDatalabel.setBounds(27, 360, 250, 23);
        contentPane.add(task5OutputDatalabel);

        JTextField task5OutputDataField = new JTextField();
        task5OutputDataField.setBounds(27, 383, 250, 23);
        task5OutputDataField.setColumns(500);
        task5OutputDataField.setEditable(false);
        contentPane.add(task5OutputDataField);

        //Task 6
        JLabel task6Label = new JLabel("Задача 6:");
        task6Label.setBounds(327, 291, 350, 23);
        contentPane.add(task6Label);

        JLabel task6InputDatalabel = new JLabel("Исходные данные:");
        task6InputDatalabel.setBounds(327, 314, 350, 23);
        contentPane.add(task6InputDatalabel);

        JTextField task6InputDataField = new JTextField();
        task6InputDataField.setBounds(327, 337, 350, 23);
        task6InputDataField.setColumns(500);
        task6InputDataField.setEditable(false);
        contentPane.add(task6InputDataField);

        JLabel task6OutputDatalabel = new JLabel("Результат:");
        task6OutputDatalabel.setBounds(327, 360, 350, 23);
        contentPane.add(task6OutputDatalabel);

        JTextField task6OutputDataField = new JTextField();
        task6OutputDataField.setBounds(327, 383, 350, 23);
        task6OutputDataField.setColumns(500);
        task6OutputDataField.setEditable(false);
        contentPane.add(task6OutputDataField);


        //Task 7
        JLabel task7Label = new JLabel("Задача 7:");
        task7Label.setBounds(27, 406, 350, 23);
        contentPane.add(task7Label);

        JLabel task7InputDatalabel = new JLabel("Исходные данные:");
        task7InputDatalabel.setBounds(27, 429, 350, 23);
        contentPane.add(task7InputDatalabel);

        JTextField task7InputDataField = new JTextField();
        task7InputDataField.setBounds(27, 452, 350, 23);
        task7InputDataField.setColumns(500);
        task7InputDataField.setEditable(false);
        contentPane.add(task7InputDataField);

        JLabel task7OutputDatalabel = new JLabel("Результат:");
        task7OutputDatalabel.setBounds(27, 475, 350, 23);
        contentPane.add(task7OutputDatalabel);

        JTextField task7OutputDataField = new JTextField();
        task7OutputDataField.setBounds(27, 498, 350, 23);
        task7OutputDataField.setColumns(500);
        task7OutputDataField.setEditable(false);
        contentPane.add(task7OutputDataField);

        JButton btnGetInputData = new JButton("Сгенерить исходные данные");
        btnGetInputData.addActionListener(arg0 -> {
            if(arg0.getSource() == btnGetInputData) {
                list1 = getIntegerList();
                list2 = getStringList('z');
                list3 =  getIntegerList();
                list4 = getStringList('c');
                list5 = getIntegerList();
                a6 = getIntegerArray();
                list7 = getStringList('z');

                task1InputDataField.setText(list1.toString());
                task2InputDataField.setText(list2.toString());
                task3InputDataField.setText(list3.toString());
                task4InputDataField.setText(list4.toString());
                task5InputDataField.setText(list5.toString());
                task6InputDataField.setText(Arrays.toString(a6));
                task7InputDataField.setText(list7.toString());
            }
            setVisible(true);
        });

        btnGetInputData.setBounds(27, 20, 600, 40);
        contentPane.add(btnGetInputData);

        JButton btnGetResult = new JButton("Рассчитать");
        btnGetResult.addActionListener(arg0 -> {
            if(arg0.getSource() == btnGetResult) {
                task1OutputDataField.setText(String.valueOf(StreamApiMethods.getAverageValue(list1)));
                task2OutputDataField.setText(String.valueOf(StreamApiMethods.getUppercaseStrings(list2)));
                task3OutputDataField.setText(String.valueOf(StreamApiMethods.getSquaresList(list3)));
                task4OutputDataField.setText(String.valueOf(StreamApiMethods.getSortedStrings(list4, "a")));
                try {
                    task5OutputDataField.setText(String.valueOf(StreamApiMethods.getLastElementOfCollection(list5)));
                } catch (NoSuchElementException e) {
                    task5OutputDataField.setText("Exception");
                }

                task6OutputDataField.setText(String.valueOf(StreamApiMethods.getSumEvenNumber(a6)));

                try {
                    task7OutputDataField.setText(String.valueOf(StreamApiMethods.getStringMap(list7)));
                } catch (IllegalStateException e) {
                    task7OutputDataField.setText("Дублируется ключ");
                }
            }
            setVisible(true);
        });
        btnGetResult.setBounds(527, 456, 150, 60);
        contentPane.add(btnGetResult);

        JButton btnExit = new JButton("Выход");
        btnExit.addActionListener((ActionEvent e) -> {
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        });
        btnExit.setBounds(582, 525, 95, 23);
        contentPane.add(btnExit);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                StreamApiConsoleApp frame = new StreamApiConsoleApp();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static List<Integer> getIntegerList() {
        int n = 5;
        List<Integer> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            result.add((int) ((Math.random()*100)/10));
        }
        return result;
    }

    private static int[] getIntegerArray() {
        int n = 5;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = (int) ((Math.random()*100)/10);
        }
        return result;
    }

    private static List<String> getStringList(char lastLetter) {
        return Stream.generate(() -> {
                    int length = new Random().nextInt(5) + 1;
                    StringBuilder sb = new StringBuilder();
                    new Random().ints(length, 'a', lastLetter + 1)
                            .forEach(randomChar -> sb.append((char) randomChar));
                    return sb.toString();
                })
                .limit(5)
                .collect(Collectors.toList());
    }
}
