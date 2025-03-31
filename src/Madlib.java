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

    public int getNumQuestions() {
        return numQuestions;
    }

    public String getQuestion(int i) {
        return questions[i];
    }

    public String getFullStory() {
        String newstory = "";
        // iterate through the story looking for "[" again
        int i = 0; // start pointing at the beginning
        int questionNumber = 0;
        while (i < story.length() && questionNumber < numQuestions) {
            int j = story.indexOf("[",i); // find the start of the next sub
            newstory += story.substring(i,j); //add the substring up to that point
            newstory += answers[questionNumber]; // add the answer
            questionNumber++; 
            i = story.indexOf("]",j) + 1; // move past the next sub
        }
        return newstory + story.substring(i);
    }
}
