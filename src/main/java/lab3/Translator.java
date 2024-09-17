package main.java.lab3;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Translator {
    private final HashMap<String, String> dictionary = new HashMap<>();
    private String translateText = "";
    private String textTranslatedOutput = "";

    public void loadDictionary(String dictFilePath) throws IOException {
        dictionary.clear();

        FileReader fileReader = new FileReader(dictFilePath);
        try (Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int indexOfSeparator = line.indexOf('|');
                if (indexOfSeparator == -1) {
                    continue;
                }
                String key = line.substring(0, indexOfSeparator - 1).toLowerCase();
                String value = line.substring(indexOfSeparator + 2).toLowerCase();

                dictionary.put(key, value);
            }
        }
    }

    public void loadText(String inputFilePath) throws IOException {
        FileReader fileReader = new FileReader(inputFilePath);
        try (Scanner scanner = new Scanner(fileReader)) {
            translateText = "";
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                translateText = (translateText + line).toLowerCase();
                if (scanner.hasNextLine()) {
                    if (!" ".equals(line.substring(line.length() - 2, line.length() - 1))) {
                        translateText = translateText + " ";
                    }
                }
            }
        }
    }

    public void getTranslatedText(String[] textInputArray) {
        for (int i = 0; i < textInputArray.length; i++) {
            String textInputWord = textInputArray[i];
            if (dictionary.containsKey(textInputWord)) {
                String resultWord = dictionary.get(textInputWord);
                for (int j = i + 1; j < textInputArray.length; j++) {
                    textInputWord = textInputWord + " " + textInputArray[j];
                    if (dictionary.containsKey(textInputWord)) {
                        resultWord = dictionary.get(textInputWord);
                        i = i + 1;
                    } else {
                        i = j - 1;
                        break;
                    }
                }
                setTextTranslatedOutput(resultWord);
            } else {
                boolean isExist = false;
                String resultWord = textInputWord;
                for (int j = i + 1; j < textInputArray.length; j++) {
                    textInputWord = textInputWord + " " + textInputArray[j];
                    if (dictionary.containsKey(textInputWord)) {
                        resultWord = dictionary.get(textInputWord);
                        isExist = true;
                    } else if (isExist) {
                        i = j - 1;
                        break;
                    }
                }
                setTextTranslatedOutput(resultWord);
            }
        }
    }

    public String[] getArrayFromString() {
        return translateText.toLowerCase().split(" ");
    }

    public String getTextTranslatedOutput() {
        return textTranslatedOutput;
    }

    public void setTextTranslatedOutput(String resultWord) {
        if (textTranslatedOutput.equals("")) {
            textTranslatedOutput = resultWord;
        } else {
            textTranslatedOutput = textTranslatedOutput + " " + resultWord;
        }
    }
}
