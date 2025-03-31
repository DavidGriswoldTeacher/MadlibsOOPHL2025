public class Madlib {
    private String story = "";
    private String[] questions = new String[100];
    private String[] answers = new String[100];
    private int numQuestions = 0;
    private int numAnswers = 0;

    public void setStory(String s) {
        story = s;
    }

    public void addQuestion(String q) {
        questions[numQuestions] = q;
        numQuestions++;
    }

    public void addAnswer(String a) {
        answers[numAnswers] = a;
        numAnswers++;
    }
}
