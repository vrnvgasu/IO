package ru.edu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter
{
    private static final String FILE = "filesForTests/test.txt";

    public static void main( String[] args ) throws IOException {
        // ищет из корня проекта
        File file = new File(FILE);

        System.out.println("file.exists(): " + file.exists());
        System.out.println("file.isDirectory(): " + file.isDirectory());
        System.out.println("file.isFile(): " + file.isFile());

        // Запись
        FileWriter fileWriter = new FileWriter(FILE);
        // создает или перезаписывает
        fileWriter.write("Привет, ");
        fileWriter.write("world!\n");
        fileWriter.write("Ф");
        fileWriter.close();


        // Чтение байт
        // Русские символы не осилит, т.к. они занимают 2 байта
        FileInputStream inputStream = new FileInputStream(FILE);
        int symbol;
        // читаем по 1 символу
        while ((symbol = inputStream.read()) != -1) {
            System.out.println("symbol = " + symbol + "(" + (char) symbol + ")");
        }
        inputStream.close();


        // Чтение символом.
        // Подходит для русских символов, т.к. в символе 2 байта
        FileReader fileReader = new FileReader(FILE);
        int character;
        // читаем по 1 символу
        while ((character = fileReader.read()) != -1) {
            System.out.println("character = " + character + "(" + (char) character + ")");
        }
        fileReader.close();

        // Чтение построчно. Увеличивает производительность.
        // Повышаем уровень абстракции.
        System.out.println("BufferedReader");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
