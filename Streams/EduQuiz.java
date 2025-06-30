import java.util.*;
class EduQuiz{
    public static int calculateScore(String[] studentAnswers, String[] correctAnswers){
        int score=0;
        for(int i=0; i<studentAnswers.length; i++){
            if(studentAnswers[i].equalsIgnoreCase(correctAnswers[i])){
                score++;
            }
        }
        return score;
    }
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       String[] questions = {
           "What is the capital of France?",
           "What is 2 + 2?",
           "What is the largest planet in our solar system?",
           "Who wrote 'Romeo and Juliet'?",
           "What is the boiling point of water in Celsius?",
           "What is the chemical symbol for gold?",
           "Who painted the Mona Lisa?",
           "What is the hardest natural substance on Earth?",
           "What is the main ingredient in guacamole?",
           "Who discovered penicillin?"
       };
       String[] answers = {
           "Paris",
           "4",
           "Jupiter",
           "William Shakespeare",
           "100",
           "Au",
           "Leonardo da Vinci",
           "Diamond",
           "Avocado",
           "Alexander Fleming"
       };
       String[] studentanswers = new String[questions.length];
       for(int i=0; i<questions.length; i++) {
           System.out.println("Question " + (i + 1) + ": " + questions[i]);
           System.out.print("Your answer: ");
           String s = scanner.nextLine();
           studentanswers[i] = s;
           if(studentanswers[i].trim().isEmpty()) {
               studentanswers[i] = "missing"; // handle missing answers
           }
           else if(studentanswers[i].equalsIgnoreCase(answers[i])){
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect! The correct answer is: " + answers[i]);
           }
       }
        int cc = calculateScore(studentanswers, answers);
        System.out.println("Your score: " + cc + "/" + questions.length);
    }
}