package io.github.wreed12345;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class QuestionAsker implements Runnable{
	
	//is this needed?
	private volatile boolean questioning;
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
			//if 10 seconds is up ask a question
			if((time - startTime.get() > intermediateTime) && !questioning) {
				startTime.set(System.currentTimeMillis());
				questioning = true;
				System.out.println("ask a question");
				//TODO: ask a question
			}
			//if 20 seconds disengage question mode and say something
			if((time - startTime.get() > 20000)){
				questioning = false;
				System.out.println("no longer question");
			}
			
			//dont spam the loop stalling a second should be ok
			try {
				//get rid of wait, considered an 'old' method of stalling thread,
				//need java concurrency in practice
				wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * True once designated time interval has ran out. (10 seconds)
	 * Disengages after 30 seconds of no reply.
	 */
	public boolean isQuestioning() {
		return questioning;
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