package io.github.wreed12345;

/**
 * Represents a question that would occur in a sequence. This
 * question would have multiple questions that relate in some
 * way
 */
public class QuestionSequence {
	
	private int length;
	private Question[] questions;
	
	public QuestionSequence(int length) {
		this.length = length;
		questions = new Question[length];
		
		//populate questions. parameters?
	}
	
	//might be a little messy when creating this object with
	//this constructor
	public QuestionSequence(Question... questions) {
		this.questions = questions;
	}
	
}
