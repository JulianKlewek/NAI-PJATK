package knn;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Knn testFile = new Knn();
		String testFilePath = "C:\\Users\\Julian\\Desktop\\NAI\\iris_test.txt";
		String trainingFilePath = "C:\\Users\\Julian\\Desktop\\NAI\\iris_training.txt";

		
		
	try {
			testFile.readTestFile(testFilePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	try {
		testFile.readTrainingFile(trainingFilePath);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("Proszę podać liczbę k");
//	System.out.println("liczba k: " + k);
	
	testFile.comparingTest();
	System.out.println("Czy chcesz podać nowy obiekt do sprawdzenia klasyfikacji?");
	Scanner scanik = new Scanner(System.in);
	String answer = scanik.nextLine();
	
	if(answer.equals("tak")) {
		testFile.newTest();
		System.out.println("Czy chcesz podać nastepny obiekt do sprawdzenia?");
		String answer1 = scanik.nextLine();
		
		while(answer1.equals("tak")){
				testFile.newTest();
				System.out.println("Czy chcesz podać nastepny obiekt do sprawdzenia?");
				answer1 = scanik.nextLine();
			}
	}else {
		
	}
	
	System.out.println("Dziekuje za skorzystanie z programu");

	
	}

}
