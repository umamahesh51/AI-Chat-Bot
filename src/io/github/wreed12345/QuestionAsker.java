package io.github.wreed12345;

public class QuestionAsker implements Runnable{
	
	private volatile boolean questionAsked;
	
	@Override
	public void run() {
		long time = 0;
		long startTime = System.currentTimeMillis();
		while (!questionAsked) {
			time = System.currentTimeMillis();
			if(time- startTime > 10000) {
				questionAsked = true;
				startTime = System.currentTimeMillis();
				
				//if no age known:
				System.out.println("How old are you?");
				
			}
		}
	}
	
	public boolean isReady() {
		return questionAsked;
	}

}
