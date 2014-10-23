package a1;

import java.util.*;

public class SimulationDriver {
    private static IClickerService core = new IClickerService();

    public static void main(String[] args) {
        trueOrFalse();
        System.out.println();
        quizQuestion();
    }

    public static void trueOrFalse() {
        String question = "Is Question question?";
        Set<String> correctAnswer = new HashSet<String>();
        Map<String, String> choices = new HashMap<String, String>();
        choices.put("1", "True");
        choices.put("2", "False");
        correctAnswer.add("1");
        Question q2 = new Question(question, correctAnswer, choices);

        responses(q2);
    }

    public static void quizQuestion() {
        String question = "When was Abraham Lincoln born?";
        Set<String> correctAnswer = new HashSet<String>();
        Map<String, String> choices = new HashMap<String, String>();
        choices.put("A", "1910");
        choices.put("B", "1809");
        choices.put("C", "1234");
        choices.put("D", "3000");
        correctAnswer.add("B");
        Question q1 = new Question(question, correctAnswer, choices);

        responses(q1);
    }

    public static void responses(Question question) {
        Random rand = new Random();
        core.setCurrentQuestion(question);
        core.displayQuestion();
        for (int i = 0; i < 45; i++) {
            Student s1 = new Student();
            Set<String> responses = new HashSet<String>();
            List<String> keys = new ArrayList<String>(question.getChoices().keySet());
            String randomKey = keys.get(rand.nextInt(keys.size()));
            responses.add(randomKey);
            core.submitResponse(question, s1, responses);
        }
        core.displayResults();
    }
}
