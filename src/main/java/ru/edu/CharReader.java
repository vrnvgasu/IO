package ru.edu;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CharReader
{
    public static void main( String[] args ) throws IOException {
        System.out.println("Введите текст");

        InputStream inputStream = System.in;

        // абстракция выше
        // У символов размер 2 байта. Подходит для чтения русских символов
        InputStreamReader streamReader = new InputStreamReader(inputStream);
        int symbol;

        while ((symbol = streamReader.read()) != -1) {
            System.out.println("symbol = " + symbol + "(" + (char) symbol + ")");
        }
    }
}
