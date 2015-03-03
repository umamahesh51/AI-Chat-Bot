package io.github.wreed12345;

/**
 * Represents a question which may or may not be asked to the user at some point
 */
public class Question {
	private final String text;
	private final QuestionType questionType;

	/**
	 * Creates a new immutable question
	 * @param text The text which will ideally be prompted to the user
	 * @param questionType Type of question to be asked
	 */
	public Question(String text, QuestionType questionType) {
		this.text = text;
		this.questionType = questionType;
	}
	
	public String getText() {
		return text;
	}

	public QuestionType questionType() {
		return questionType;
	}
}
