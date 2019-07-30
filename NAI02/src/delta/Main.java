package delta;

import java.io.IOException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Perceptron testFile = new Perceptron();
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
		testFile.fillListOfWeight();
		testFile.learn();
		testFile.test();
//		System.out.println(listOfWeight.get(0) + " " + listOfWeight.get(1) + " " + listOfWeight.get(2) + " " + listOfWeight.get(3)+ " ");
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
