package com.horserace.main;

import java.util.Scanner;

import com.horserace.model.Horse;

public class RaceRunner {



	public static void main(String[] args)
	{
		int numHorses;
		int n=0;
		

		// Get the number of threads to start
		numHorses = getNumHorses();
		
		//int numFurlongs;
		//numFurlongs = getRaceLength();
		
		Horse[] thisRunner = new Horse[numHorses];	
		
		while (n<numHorses)
		{
			thisRunner[n] = new Horse();
			
			n++;
		}
		
		for (Horse i: thisRunner)
		(new Thread(i)).start();
		//Thread t = Thread.currentThread();
		//String threadNum = ("Horse " + t);
		
		// (new Thread(new Horse())).start();
		
		// Horse raceHorse = new Horse();
		// raceHorse.lengths = 0;
	}
	
	
	//  This method will prompt for and return the number of horses
	public static int getNumHorses()
	{
		int numHorsesInRace;
		Scanner numScanner = new Scanner(System.in);
		
		System.out.println("How many horses in this race?");
		numHorsesInRace = numScanner.nextInt();
		numScanner.close();
		
		return numHorsesInRace;
	}
	
	

	
	// This method will prompt for and return the race length in furlongs
	public static int getRaceLength()
	{
		int raceLength;
		Scanner lengthScanner = new Scanner(System.in);
		
		//System.out.println("How many furlongs is the race?");
		raceLength = 30;  // lengthScanner.nextInt();
		lengthScanner.close();
		
		return raceLength;
	}
}
