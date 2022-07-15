import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        GameController gameController = new GameController();

        // This is how we set things up to read lines of text from the user.
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // Loop forever
        while(true) {
            // Display a prompt to the user
            System.out.print("INPUT ITEM NAME> ");
            // Read a line from the user
            try {
                String line = in.readLine();
                // if the user types "quit", then quit
                if ((line == null) || line.equals("QUIT")) {
                    System.out.println("Game is end");
                    break;
                }
                if (gameController.isInputAlready(line)) {
                    System.out.println("This input is already validated in the past.");
                    continue;
                }
                if(!line.matches(ItemLetters.pattern)){
                    System.out.println("Input value is wrong format. Please use letter ABCXY with 3-10 length");
                    continue;
                }
                int result = gameController.validateInput(line);
                System.out.println("Input :" +  line);
                if(result == 2){
                    System.out.println("All Combination Pieces are found. Reshuffle Items.");
                    gameController.reshufflePermutationItem();
                }
            }
            // If anything goes wrong, display a generic error message
            catch(Exception e) { System.out.println("Invalid Input"); }
        }

    }

}
