package LinearAndBinarySearch;
public class WordSearchInSentences {
    public static void main(String[] args) {
        String[] sentences = {
            "The sun is shining",
            "Java is powerful",
            "Practice makes perfect",
            "Let's learn programming"
        };

        String word = "Java";
        String result = "Not Found";

        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                result = sentence;
                break;
            }
        }

        System.out.println("Result: " + result);
    }
}

