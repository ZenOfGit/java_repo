package com.horserace.model;

import com.horserace.main.RaceRunner;

public class Horse implements Runnable{
	
	int currentlyRunningHorses = 0;
	private int position = 1;
	private int delayTime = 3000;
	private int horseNum;
	boolean winnerAnnounce = true;
	private boolean isRunning;
	private static int threadCount = 0;
	public int lengths;	// Each horse travels 1-4 lengths
	String threadString;
	
	boolean halfAnnounce = true;
	boolean quarterAnnounce = true;
	boolean finishAnnounce = true;
	
	int pace = 4;	
	int num = 0;
	
	private static int nbThreadsStart;
	int raceLength = RaceRunner.getRaceLength();
			
	@Override
	public void run()
	{
		isRunning = true;
		
		while (lengths<raceLength)
		{


			delayThread();
			gallup();

			System.out.println("Horse " + horseNum + " has gone " + lengths);
			
			checkAndAnnounce();
		}
		
		isRunning = false;
		announceFinish();
	}
	
	public Horse()		// Default constructor
	{
		lengths= 0;
		threadCount++;
		horseNum = threadCount;
		nbThreadsStart = threadCount;
		isRunning = true;
	}
	
	public void gallup()
	{
		lengths = lengths + ((int)(Math.random()*pace) + 1);
	}

	public int getLengths()
	{
		return lengths;
	}

	public void setLengths(int distance)
	{
		this.lengths = distance;
	}
	
	public void delayThread()
	{	
		try {
			int waitFor = ((int) ((Math.random() * delayTime)) + 1000);
			Thread.sleep(waitFor);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void checkAndAnnounce()
	{	
		if (halfAnnounce)
		{
			if (lengths > raceLength/2)
			{
			System.out.println("Horse " + horseNum + " is halfway to the finish!"); 
			halfAnnounce  = false;
			}
		}
		
		if (quarterAnnounce)
		{
			if (lengths > (raceLength*.75))
			{
			System.out.println("The jockey's whip is out and horse " + horseNum + " is sprinting!");
			pace = 5;
			delayTime = 2500;
			quarterAnnounce  = false;
			}
		}
	}
	
	public void announceFinish()
	{
		if (lengths >= (raceLength))
		{	
			threadCount--;
			position = (nbThreadsStart - threadCount); 

			if (position == 1)
			{	
				System.out.println("Horse " + horseNum + " has crossed the finnish line first and won the race!!");
				}else
				{
					System.out.println("Horse " + horseNum + " has finished in position: " + (position));
					}	
				}
	}
}
