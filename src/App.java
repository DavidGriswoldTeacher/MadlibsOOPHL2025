public class App {
    private Madlib myMadlib;
    private Printer printer = new Printer();

    /**
     * Where the program begins!
     */
    public void start() {
        myMadlib = readMadlib("madlib.txt");
        promptForAnswers();
        printMadlib();
    }


    public Madlib readMadlib(String filename) {
        Madlib m = new Madlib();
        String story = "";
        try {
            printer.openFile(filename);
            while (printer.fileHasNextLine()) {
                story = story + printer.getNextLine() + "\n";
            }
            m.setStory(story);
            
            int i = 0;
            while (i < story.length()) {
                i = story.indexOf("[",i);
                if (i == -1) break;
                int j = story.indexOf("]",i);
                String q = story.substring(i+1,j);
                i = j+1;
                m.addQuestion(q);
            }
        } catch (Exception e) {
            printer.output(e.toString());
        }
        return m;
    }

    public void promptForAnswers() {
        for (int i = 0; i < myMadlib.getNumQuestions(); i++) {
            printer.output(myMadlib.getQuestion(i));
            myMadlib.addAnswer(printer.input());
        }
    }

    public void printMadlib() {
        printer.output(myMadlib.getFullStory());
    }

    
    public static void main(String[] args) throws Exception {
        new App().start();
    }
}
