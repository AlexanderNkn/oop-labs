package main.java.lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MatrixConsoleApp extends JFrame {
    private String pathToInputFile = "";
    private boolean append = true;

    private final String pathToOutputFile = "./src/main/data/lab2/matrixOut.txt";

    public MatrixConsoleApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 1000);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel pathToInputFileLabel = new JLabel("Путь к файлу с размером матрицы:");
        pathToInputFileLabel.setBounds(27, 16, 400, 23);
        contentPane.add(pathToInputFileLabel);

        JTextField pathToInputFileField = new JTextField();
        pathToInputFileField.setBounds(27, 39, 500, 23);
        pathToInputFileField.setColumns(500);
        pathToInputFileField.setEditable(false);
        contentPane.add(pathToInputFileField);

        JButton btnSelectInputFile = new JButton("Выберите путь");
        btnSelectInputFile.setBounds(527, 39, 140, 23);
        contentPane.add(btnSelectInputFile);

        JFileChooser pathInputFileChooser = new JFileChooser("./src/main/data/lab2/");
        btnSelectInputFile.addActionListener(e -> {
            pathInputFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = pathInputFileChooser.showOpenDialog(MatrixConsoleApp.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                pathToInputFileField.setText(String.valueOf(pathInputFileChooser.getSelectedFile()));
                pathToInputFile = pathToInputFileField.getText();
            }
        });

        JLabel calculationResultsLabel = new JLabel("Результаты вычислений:");
        calculationResultsLabel.setBounds(27, 120, 400, 23);
        contentPane.add(calculationResultsLabel);

        JLabel exceptionLabel = new JLabel("Исключения в ходе выполнения программы:");
        exceptionLabel.setBounds(27, 150, 400, 23);
        contentPane.add(exceptionLabel);

        JTextField exceptionField = new JTextField();
        exceptionField.setBounds(27, 173, 500, 23);
        exceptionField.setColumns(500);
        contentPane.add(exceptionField);

        JLabel pathToOutputFileLabel = new JLabel("Путь к файлу с результатами:");
        pathToOutputFileLabel.setBounds(27, 200, 400, 23);
        contentPane.add(pathToOutputFileLabel);

        JTextField pathToOutputFileField = new JTextField();
        pathToOutputFileField.setBounds(27, 223, 500, 23);
        pathToOutputFileField.setColumns(500);
        pathToOutputFileField.setText(pathToOutputFile);
        pathToOutputFileField.setEditable(false);
        contentPane.add(pathToOutputFileField);

        JLabel originalMatrixLabel = new JLabel("Исходная матрица:");
        originalMatrixLabel.setBounds(727, 46, 450, 23);
        contentPane.add(originalMatrixLabel);

        JTextArea originalMatrixField = new JTextArea();
        originalMatrixField.setBounds(727, 69, 138, 138);
        originalMatrixField.setColumns(500);
        originalMatrixField.setEditable(false);
        contentPane.add(originalMatrixField);

        JLabel rotated90Label = new JLabel("Поворот на 90 градусов:");
        rotated90Label.setBounds(27, 246, 300, 23);
        contentPane.add(rotated90Label);

        JTextArea rotated90Field = new JTextArea();
        rotated90Field.setBounds(27, 269, 138, 138);
        rotated90Field.setColumns(500);
        rotated90Field.setEditable(false);
        contentPane.add(rotated90Field);

        JLabel rotated90DevidedLabel = new JLabel("Поворот на 90 градусов и деление на сумму соседних:");
        rotated90DevidedLabel.setBounds(300, 246, 600, 23);
        contentPane.add(rotated90DevidedLabel);

        JTextArea rotated90DevidedField = new JTextArea();
        rotated90DevidedField.setBounds(300, 269, 188, 138);
        rotated90DevidedField.setColumns(500);
        rotated90DevidedField.setEditable(false);
        contentPane.add(rotated90DevidedField);

        JLabel rotated180Label = new JLabel("Поворот на 180 градусов:");
        rotated180Label.setBounds(27, 410, 300, 23);
        contentPane.add(rotated180Label);

        JTextArea rotated180Field = new JTextArea();
        rotated180Field.setBounds(27, 430, 138, 138);
        rotated180Field.setColumns(500);
        rotated180Field.setEditable(false);
        contentPane.add(rotated180Field);

        JLabel rotated180DevidedLabel = new JLabel("Поворот на 180 и деление на сумму соседних");
        rotated180DevidedLabel.setBounds(300, 410, 600, 23);
        contentPane.add(rotated180DevidedLabel);

        JTextArea rotated180DevidedField = new JTextArea();
        rotated180DevidedField.setBounds(300, 430, 188, 138);
        rotated180DevidedField.setColumns(500);
        rotated180DevidedField.setEditable(false);
        contentPane.add(rotated180DevidedField);

        JLabel rotatedMatrix270Label = new JLabel("Поворот на 270 градусов:");
        rotatedMatrix270Label.setBounds(27, 568, 300, 23);
        contentPane.add(rotatedMatrix270Label);

        JTextArea rotated270Field = new JTextArea();
        rotated270Field.setBounds(27, 591, 138, 138);
        rotated270Field.setColumns(500);
        rotated270Field.setEditable(false);
        contentPane.add(rotated270Field);

        JLabel rotated270DevidedLabel = new JLabel("Поворот на 270 и деление на сумму соседних");
        rotated270DevidedLabel.setBounds(300, 568, 600, 23);
        contentPane.add(rotated270DevidedLabel);

        JTextArea rotated270DevidedField = new JTextArea();
        rotated270DevidedField.setBounds(300, 591, 188, 138);
        rotated270DevidedField.setColumns(500);
        rotated270DevidedField.setEditable(false);
        contentPane.add(rotated270DevidedField);

        JButton btnCalculate = new JButton("Рассчитать");
        btnCalculate.addActionListener(arg0 -> {
            if (arg0.getSource() == btnCalculate) {
                pathToOutputFileField.setText("");
                originalMatrixField.setText("");
                rotated90Field.setText("");
                rotated90DevidedField.setText("");
                rotated180Field.setText("");
                rotated180DevidedField.setText("");
                rotated270Field.setText("");
                rotated270DevidedField.setText("");
                exceptionField.setText("");

                MatrixCalculation matrixCalculation = new MatrixCalculation(contentPane);
                int matrixSize = matrixCalculation.readMatrixSize(pathToInputFile);
                int[][] matrix = matrixCalculation.createMatrix(matrixSize);
                pathToOutputFileField.setText(pathToOutputFile);

                originalMatrixField
                        .setText(matrixCalculation.writeMatrix(matrix, pathToOutputFile, "Исходная матрица\n", append=false));

                int[][] matrix_90 = matrixCalculation.rotateMatrix(matrix);
                rotated90Field.setText(matrixCalculation.writeMatrix(matrix_90, pathToOutputFile,
                        "Поворот на 90 градусов\n", append=true));
                rotated90DevidedField.setText(matrixCalculation.writeMatrix(
                        matrixCalculation.devideElementsMatrix(matrix_90), pathToOutputFile,
                        "Поворот на 90 градусов и деление на сумму соседних\n",
                        append));

                int[][] matrix_180 = matrixCalculation.rotateMatrix(matrix_90);
                rotated180Field.setText(matrixCalculation.writeMatrix(matrix_180, pathToOutputFile,
                        "Поворот на 180 градусов\n", append=true));
                rotated180DevidedField.setText(matrixCalculation.writeMatrix(
                        matrixCalculation.devideElementsMatrix(matrix_180), pathToOutputFile,
                        "Поворот на 180 градусов и деление на сумму соседни\n",
                        append));

                int[][] matrix_270 = matrixCalculation.rotateMatrix(matrix_180);
                rotated270Field.setText(matrixCalculation.writeMatrix(matrix_270, pathToOutputFile,
                        "Поворот на 270 градусов\n", append=true));
                rotated270DevidedField.setText(matrixCalculation.writeMatrix(
                        matrixCalculation.devideElementsMatrix(matrix_270), pathToOutputFile,
                        "Поворот на 270 градусов и деление на сумму соседни\n",
                        append));
            }
            setVisible(true);
        });
        btnCalculate.setBounds(27, 80, 600, 40);
        contentPane.add(btnCalculate);

        JButton btnExit = new JButton("Выход");
        btnExit.addActionListener((ActionEvent e) -> {
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        });
        btnExit.setBounds(707, 706, 95, 23);
        contentPane.add(btnExit);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MatrixConsoleApp frame = new MatrixConsoleApp();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}