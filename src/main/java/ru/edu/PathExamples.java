package ru.edu;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExamples {

	public static void main(String[] args) {
		// Современное применение, вместо File (легаси)
		Path path = Paths.get("/land/hippo/harry.happy");

		// Перебираем элементы пути от родителя (без корня) к файлу
		System.out.println("The Path Name is: " + path);
		for (int i = 0; i < path.getNameCount(); i++) {
			// Выведет 3 элемента land, hippo и harry.happy
			System.out.println(" Element " + i + " is: " + path.getName(i));
		}
		System.out.println();

		// Получить сразу файл и корень
		System.out.println("Filename is: " + path.getFileName()); // harry.happy
		System.out.println("Root is: " + path.getRoot()); // /
		System.out.println();

		// Перебираем элементы пути от ребенка (без файла) к корню
		Path currentParent = path;
		while ((currentParent = currentParent.getParent()) != null) {
			// Выведет 1. /land/hippo; 2. /land; 3. /
			System.out.println(" Current parent is: " + currentParent);
		}
		System.out.println();

		// Работаем с абсолютным и относительным путем
		Path path1 = Paths.get("/birds/egret.txt");
		System.out.println("Path1 is Absolute? " + path1.isAbsolute()); // true
		System.out.println("Absolute Path1: " + path1.toAbsolutePath()); // /birds/egret.txt
		Path path2 = Paths.get("birds/condor.txt");
		System.out.println("Path2 is Absolute? " + path2.isAbsolute()); // false
		System.out.println("Absolute Path2 " + path2.toAbsolutePath()); // /Users/inputOutput/birds/condor.txt
		System.out.println();

		// вырезаем часть пути
		Path path3 = Paths.get("/mammal/carnivore/raccoon.image");
		System.out.println("Path is: " + path3);
		// 0 - mammal; 1 - carnivore; 2 - raccoon.image
		System.out.println("Subpath from 1 to 3 is: " + path3.subpath(1, 3)); // [1; 3)
		System.out.println();

		Path path10 = Paths.get("dir10");
		Path path11 = Paths.get("dir11");
		// каталоги лежат на одном уровне
		// путь к dir11 относительно dir10. Надо поднять наверх из dir10, а потом перейти в dir11
		System.out.println(path10.relativize(path11)); // ../dir11
		// путь к dir10 относительно dir11
		System.out.println(path11.relativize(path10)); // ../dir10
		System.out.println();

		// Склеиваем пути
		Path path5 = Paths.get("/cats/test/../panther");
		Path path6 = Paths.get("food");
		System.out.println(path5.resolve(path6)); // /cats/test/../panther/food
		System.out.println();

		// Делаем путь нормальным без переходов вниз, потом опять наверх и тд
		// /cats/test/../panther/food -> /cats/panther/food
		System.out.println(path3.resolve(path5.resolve(path6)).normalize());
		System.out.println();

		// Проверка существования реального пути
		Path path13 = Paths.get("C:/Windows/Help/../../work");
		try {
			System.out.println(path13.toRealPath()); // C:/work
			// проверяет существование реального пути
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}


	}

}
