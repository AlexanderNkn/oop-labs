package main.java.lab2;

import javax.swing.*;

import main.java.lab2.exception.MatrixSizeExceededException;
import main.java.lab2.exception.ZeroDevisionException;
import main.java.lab2.exception.FileNotFoundOrPermissionDeniedException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class MatrixCalculation {
    private static final Logger LOGGER = Logger.getLogger(MatrixConsoleApp.class.getName());

    private String exception;

    private final JPanel contentPane;

    public MatrixCalculation(JPanel contentPane) {
        this.contentPane = contentPane;
    }

    public int readMatrixSize(String path) {
        if (path == null) {
            exception = "Не введен путь";
            displayException();
            throw new FileNotFoundOrPermissionDeniedException(exception);
        }
        File file = new File(path);
        if (!file.exists()) {
            exception = "Файл не существует";
            displayException();
            throw new FileNotFoundOrPermissionDeniedException(exception);
        }
        int n = 0;
        try (Scanner scanner = new Scanner(file)) {
            n = scanner.nextInt();
            if (n > 1_000_000) {
                exception = "Превышен допустимый размер матрицы";
                displayException();
                throw new MatrixSizeExceededException("Превышен допустимый размер матрицы");
            }
        } catch (FileNotFoundException e) {
            exception = "Файл не найден";
            displayException();
            throw new FileNotFoundOrPermissionDeniedException(exception);
        } catch (OutOfMemoryError e) {
            exception = "Недостаточно памяти";
            displayException();
            LOGGER.warning(exception);
        }
        return n;
    }

    public int[][] createMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * 2 * n - n);
            }
        }
        return matrix;
    }
    
    public int[][] rotateMatrix(int[][] matrix) {
        int[][] rotatedMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                rotatedMatrix[j][i] = matrix[i][matrix.length - j - 1];
            }
        }
        return rotatedMatrix;
    }

    public double[][] devideElementsMatrix(int[][] matrix) {
        int matrixLength = matrix.length;
        int leftElement;
        int rightElement;
        int upElement;
        int downElement;
        int sumNeighbour;
        double[][] devidedMatrix = new double[matrixLength][matrixLength];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                leftElement = j - 1 >= 0 ? matrix[i][j-1] : 0;
                rightElement = j + 1 < matrixLength ? matrix[i][j+1] : 0;
                upElement = i - 1 >= 0 ? matrix[i-1][j] : 0;
                downElement = i + 1 < matrixLength ? matrix[i+1][j] : 0;
                sumNeighbour = leftElement + rightElement + upElement + downElement;

                getZeroDevisionException(sumNeighbour, i, j);
                devidedMatrix[i][j] = roundedTwoDecimalPlaces((double) matrix[i][j] / sumNeighbour);
            }
        }

        return devidedMatrix;
    }

    public String writeMatrix(double[][] matrix, String path, String outputText, boolean append) {
        String result = "";
        try (FileWriter writer = new FileWriter(path, append)) {
            writer.write("___________________\n");
            writer.write(outputText);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    result = result + matrix[i][j] + "   ";
                    writer.write(matrix[i][j] + "   ");
                }
                result = result + "\n\n";
                writer.write("\n\n");
            }
        } catch (IOException e) {
            exception = "Ошибка ввода-вывода";
            displayException();
            throw new FileNotFoundOrPermissionDeniedException(exception);
        }
        return result;
    }

    public String writeMatrix(int[][] matrix, String path, String outputText, boolean append) {
        String result = "";
        try (FileWriter writer = new FileWriter(path, append)) {
            writer.write("___________________\n");
            writer.write(outputText);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    result = result + matrix[i][j] + "    ";
                    writer.write(matrix[i][j] + "  ");
                }
                result = result + "\n\n";
                writer.write("\n\n");
            }
        } catch (IOException e) {
            exception = "Ошибка ввода-вывода";
            displayException();
            throw new FileNotFoundOrPermissionDeniedException(exception);
        }
        return result;
    }

    public void getZeroDevisionException(double summ, int row, int col) {
        if (summ == 0) {
            exception = "Деление на ноль вокруг позиции " + row + " : " + col;
            displayException();
            throw new ZeroDevisionException(exception);
        }
    }

    public double roundedTwoDecimalPlaces(double value) {
        return Math.round(value * 100) / 100.0;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    private void displayException() {
        JTextField exceptionField = new JTextField();
        exceptionField.setBounds(27, 173, 500, 23);
        exceptionField.setColumns(500);
        exceptionField.setText(exception);
        exceptionField.setEditable(false);
        contentPane.add(exceptionField);
    }
}
