package a1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IClickerService {
    private Map<Question, Map<Student, Set>> questions = new HashMap<Question, Map<Student, Set>>();

    private Question currentQuestion;

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public void displayQuestion() {
        currentQuestion.display();
    }

    public void displayResults() {
        Map<String, Integer> responses = new HashMap<String, Integer>();
        Map<Student, Set> q = questions.get(currentQuestion);
        for(Map.Entry<Student,Set> entry : q.entrySet()) {
            String en = Arrays.toString(entry.getValue().toArray());
            if (responses.containsKey(en)) {
                responses.put(en, responses.get(en) + 1);
            } else {
                responses.put(en, 1);
            }
        }
        for(Map.Entry<String, Integer> entry : responses.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("Correct answer: " + Arrays.toString(currentQuestion.getCorrectAnswer().toArray()));
    }

    public void submitResponse(Question question, Student student, Set<String> response) {
        if (!questions.containsKey(question)) {
            questions.put(question, new HashMap<Student, Set>());
        }
        questions.get(question).put(student, response);
    }

}
