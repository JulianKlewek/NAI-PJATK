package knn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Knn {

	private List<String> readedTrainingFile = new ArrayList<>();
	private List<String> readedTestFile = new ArrayList<>();
	double sampleSize;
	double succNumber;

	
	public Knn() {
	
	}
	
	

	
	public void readTrainingFile(String path) throws IOException {
		  FileReader fileReader = new FileReader(path);
		  BufferedReader bufferedReader = new BufferedReader(fileReader);
		  
		  String textLine = bufferedReader.readLine();
		  
		  do {
//		    System.out.println(textLine);
			textLine = textLine.replace(",", ".");
			readedTrainingFile.add(textLine);
			
		    textLine = bufferedReader.readLine();
		    
		    
		  } while(textLine != null);

		  bufferedReader.close();
		  System.out.println(readedTrainingFile);
		}
	
	public void readTestFile(String path) throws IOException {
		  FileReader fileReader = new FileReader(path);
		  BufferedReader bufferedReader = new BufferedReader(fileReader);
		  
		  String textLine = bufferedReader.readLine();
		  
		  do {
//		    System.out.println(textLine);
			textLine = textLine.replace(",", ".");
			readedTestFile.add(textLine);
			sampleSize++;
		    
		    textLine = bufferedReader.readLine();
		    
		    
		  } while(textLine != null);

		  bufferedReader.close();
		  System.out.println(readedTestFile);
		}
	
	
	public void comparingTest() {
		
		Scanner scan = new Scanner(System.in);
		String k = scan.nextLine();
		int limit = Integer.parseInt(k);
		int half = (limit/2) + 1;
		String wynik = null;

		
		
		for( String s : readedTestFile) {
			
			List<Double> neighbors = new ArrayList<>();
			List<String> neighborName = new ArrayList<>();
			List<String> limitNeighborName = new ArrayList<>();
			String[] line = s.split("\\s+");
			int podobienstwo = 0;
			
			
			double firstValue = Double.parseDouble(line[1]);
			double secondValue = Double.parseDouble(line[2]);
			double thirdValue = Double.parseDouble(line[3]);
			double fourthValue = Double.parseDouble(line[4]);
			String fifthValue = line[5];
			
			
//			System.out.println(line[5]);
			for(String a : readedTrainingFile) {
				
				String[] trainingLine = a.split("\\s+");
				double firstVal = Double.parseDouble(trainingLine[1]);
				double secondVal = Double.parseDouble(trainingLine[2]);
				double thirdVal = Double.parseDouble(trainingLine[3]);
				double fourthVal = Double.parseDouble(trainingLine[4]);
				String fifthVal = trainingLine[5];
			
				double first = Math.pow((firstValue - firstVal), 2.0);
				double second = Math.pow((secondValue - secondVal), 2.0);
				double third = Math.pow((thirdValue - thirdVal), 2.0);
				double fourth = Math.pow((fourthValue - fourthVal), 2.0);
				
				double distance = Math.sqrt(first + second + third + fourth);
//				System.out.println(distance);
				
//				neighbors.add(distance);
//				Collections.sort(neighbors);
				
				neighborName.add(String.valueOf(distance) + " " + fifthVal);
				Collections.sort(neighborName);

				
			}
			


			for(int i = 0; i <limit; i++) {
				limitNeighborName.add(neighborName.get(i));
			}
//			System.out.println(limitNeighborName);
			
			for(int j = 0; j<limit; j++) {
				if(limitNeighborName.get(j).contains(fifthValue)) {
					podobienstwo++;
				}
			}
			if(podobienstwo >= half) {
				succNumber++;
			}
			
//			System.out.println(succNumber);
			wynik = "skuteczność wynosi : " + ((succNumber * 100)/sampleSize) + "%";

			
		}
		System.out.println("Poprawnie zaklasyfikowano : " + (int)succNumber + " przykladow.");
		System.out.println(wynik);				
		
	}
	
	public void newTest() {
		
		Scanner scan = new Scanner(System.in);
//		String answer = scan.nextLine();
		
			System.out.println("Prosze podac pierwszy atrybut");
			double a1 = scan.nextDouble();
			System.out.println("Prosze podac drugi atrybut");
			double a2 = scan.nextDouble();
			System.out.println("Prosze podac trzeci atrybut");
			double a3 = scan.nextDouble();
			System.out.println("Prosze podac czwarty atrybut");
			double a4 = scan.nextDouble();
			System.out.println("Prosze podac liczbe k");
			int k = scan.nextInt();
			int half = (k/2) + 1;
			int irisSetosa=0;
			int irisVersicolor = 0;
			int irisVirginica =0;
//			System.out.println("Prosze podac atrybut decyzyjny");
//			String a5 = scan.nextLine();
			
			List<Double> neighbors = new ArrayList<>();
			List<String> neighborName = new ArrayList<>();
			List<String> limitNeighborName = new ArrayList<>();
			List<Integer> flower = new ArrayList<>();
			
			for(String a : readedTrainingFile) {
				
				
				String[] trainingLine = a.split("\\s+");
				double firstVal = Double.parseDouble(trainingLine[1]);
				double secondVal = Double.parseDouble(trainingLine[2]);
				double thirdVal = Double.parseDouble(trainingLine[3]);
				double fourthVal = Double.parseDouble(trainingLine[4]);
				String fifthVal = trainingLine[5];
			
				double first = Math.pow((a1 - firstVal), 2.0);
				double second = Math.pow((a2 - secondVal), 2.0);
				double third = Math.pow((a3 - thirdVal), 2.0);
				double fourth = Math.pow((a4 - fourthVal), 2.0);
				
				double distance = Math.sqrt(first + second + third + fourth);
//				System.out.println(distance);
				
//				neighbors.add(distance);
//				Collections.sort(neighbors);
				
				neighborName.add(String.valueOf(distance) + " " + fifthVal);
				Collections.sort(neighborName);

			}
			
			for(int i = 0; i <k; i++) {
				limitNeighborName.add(neighborName.get(i));
			}
			System.out.println(limitNeighborName);
			
			for(int i = 0; i<k; i++) {
				if(limitNeighborName.get(i).contains("Iris-setosa")) {
					irisSetosa++;
				}
				else if(limitNeighborName.get(i).contains("Iris-versicolor")) {
					irisVersicolor++;
				}
				else if(limitNeighborName.get(i).contains("Iris-virginica")) {
					irisVirginica++;
				}
			}
			
			flower.add(irisSetosa);
			flower.add(irisVersicolor);
			flower.add(irisVirginica);
			
			
			if(irisSetosa > irisVersicolor && irisSetosa > irisVirginica) {
				System.out.println("Wynik przydziału: iris-setosa");
			}else if(irisVersicolor > irisSetosa && irisVersicolor > irisVirginica) {
				System.out.println("Wynik przydziału: iris-versicolor");
			}else {
				System.out.println("Wynik przydziału: iris-virginica");
			}
			
		
	}
	

}

