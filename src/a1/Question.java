package a1;

import java.util.*;

public class Question {
    private Map<String, String> choices;
    private Set<String> correctAnswer;
    private String label;

    public Set<String> getCorrectAnswer() {
        return correctAnswer;
    }

    Question (String label, Set<String> correctAnswer, Map<String, String> choices) {
        this.label = label;
        this.correctAnswer = correctAnswer;
        this.choices = choices;
    }

    public void display() {
        System.out.println(label);
        for (Map.Entry<String, String> entry : choices.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public Map<String, String> getChoices() {
        return choices;
    }

}
