package ru.edu;

import java.io.IOException;
import java.io.InputStream;

public class ByteReader
{
    public static void main( String[] args ) throws IOException {
        System.out.println("Введите текст");

        InputStream inputStream = System.in;
        int symbol;

        // Считывает в байтах. Русские символы в 1 байт не поместятся (считается в 2 байта)
        // для русских символов подходят потоки, работающие с символами, а не байтами
        while ((symbol = inputStream.read()) != -1) {
            System.out.println("symbol = " + symbol + "(" + (char) symbol + ")");
        }
    }
}
