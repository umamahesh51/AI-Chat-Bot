package io.github.wreed12345;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class QuestionAsker implements Runnable{
	
	private volatile boolean questionReady;
	private long time = 0;
	private AtomicLong startTime = new AtomicLong(0);
	private final long intermediateTime = 10000;//10 seconds
	
	//may not be necesary, but would be for multiple stage questions
	private AtomicInteger questionSequence;
	//populate with various questions
	private ArrayList<Question> questions = new ArrayList<>();
	
	//TODO: reset start time once something has been said in chat
	
	@Override
	public void run() {
		startTime.set(System.currentTimeMillis());
		while (true) {
			time = System.currentTimeMillis();
			if(time - startTime.get() > intermediateTime) {
				questionReady = true;
				startTime.set(System.currentTimeMillis());
				
				
			}
			
			//dont spam the loop stalling a second should be ok
			try {
				wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * True once 10 seconds has occurred since last input
	 * @return
	 */
	public boolean isReady() {
		return questionReady;
	}
	
	/**
	 * Resets the timer
	 */
	public void resetTime() {
		startTime.set(System.currentTimeMillis());
	}

}

//Once x time has been reached ask a random question
//Each question has a set answer and a place to put it in the Persons profile
//repeat process