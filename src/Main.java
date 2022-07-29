import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        //GameController gameController = new GameController();
        ItemRankConfiguration itemRankConfiguration = new ItemRankConfiguration();
        SetupRankItems(itemRankConfiguration);
        GameController gameController = new GameController(itemRankConfiguration);

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

    public static void SetupRankItems(ItemRankConfiguration itemRankConfiguration){
        // This is how we set things up to read lines of text from the user.
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // Display a prompt to the user
        System.out.println("START ITEM RANKS SETUP");
        System.out.println("DEFINE LETTER LENGTH OF D RANK > (MIN MAX)");
        // Loop forever
        while(true) {
            // Read a line from the user
            try {
                String line = in.readLine();

                // if the user types "quit", then quit
                if ((line == null) || line.equals("QUIT")) {
                    System.out.println("Game is end");
                    break;
                }
                if(!line.matches(ItemLetters.rankDefinition)){
                    System.out.println("Input is not correct format. Should be <min>(space)<max>.");
                    continue;
                }
                String[] params = line.split(" ");
                if (params.length!=2) {
                    System.out.println("Input is not correct format. Should be <min>(space)<max>.");
                    continue;
                }
                int min = Integer.parseInt(params[0]);
                int max = Integer.parseInt(params[1]);
                if(min<3 || min>10 || max<3 || max>10 || min> max){
                    System.out.println("Value of Min or Max is wrong. It should be between 3 - 10 and Min <= Max");
                    continue;
                }
                if(!itemRankConfiguration.validateDrankItems(min, max)){
                    System.out.println("Cannot create enough number of item from given definition");
                    continue;
                }
                System.out.println("Create item with this definition? (Y or N)");
                String confirm = in.readLine();
                if(confirm.equals("N")){
                    System.out.println("DEFINE LETTER LENGTH OF D RANK > (MIN MAX)");
                    continue;
                }
                itemRankConfiguration.initiateDrankItems(min, max);
                break;
            }
            // If anything goes wrong, display a generic error message
            catch(Exception e) { System.out.println("Invalid Input"); }
        }

        System.out.println("DEFINE LETTER LENGTH OF C RANK > (MIN MAX)");
        // Loop forever
        while(true) {
            // Read a line from the user
            try {
                String line = in.readLine();

                // if the user types "quit", then quit
                if ((line == null) || line.equals("QUIT")) {
                    System.out.println("Game is end");
                    break;
                }
                if(!line.matches(ItemLetters.rankDefinition)){
                    System.out.println("Input is not correct format. Should be <min>(space)<max>.");
                    continue;
                }
                String[] params = line.split(" ");
                if (params.length!=2) {
                    System.out.println("Input is not correct format. Should be <min>(space)<max>.");
                    continue;
                }
                int min = Integer.parseInt(params[0]);
                int max = Integer.parseInt(params[1]);
                if(min<3 || min>10 || max<3 || max>10 || min> max){
                    System.out.println("Value of Min or Max is wrong. It should be between 3 - 10 and Min <= Max");
                    continue;
                }
                if(!itemRankConfiguration.validateCrankItems(min, max)){
                    System.out.println("Cannot create enough number of item from given definition");
                    continue;
                }
                System.out.println("Create item with this definition? (Y or N)");
                String confirm = in.readLine();
                if(confirm.equals("N")){
                    System.out.println("DEFINE LETTER LENGTH OF C RANK > (MIN MAX)");
                    continue;
                }
                itemRankConfiguration.initiateCrankItems(min, max);
                break;
            }
            // If anything goes wrong, display a generic error message
            catch(Exception e) { System.out.println("Invalid Input"); }
        }

        System.out.println("DEFINE LETTER LENGTH OF B RANK > (MIN MAX)");
        System.out.println("B RANK will include one Y letter.");
        // Loop forever
        while(true) {
            // Read a line from the user
            try {
                String line = in.readLine();

                // if the user types "quit", then quit
                if ((line == null) || line.equals("QUIT")) {
                    System.out.println("Game is end");
                    break;
                }
                if(!line.matches(ItemLetters.rankDefinition)){
                    System.out.println("Input is not correct format. Should be <min>(space)<max>.");
                    continue;
                }
                String[] params = line.split(" ");
                if (params.length!=2) {
                    System.out.println("Input is not correct format. Should be <min>(space)<max>.");
                    continue;
                }
                int min = Integer.parseInt(params[0]);
                int max = Integer.parseInt(params[1]);
                if(min<3 || min>10 || max<3 || max>10 || min> max){
                    System.out.println("Value of Min or Max is wrong. It should be between 3 - 10 and Min <= Max");
                    continue;
                }
                if(!itemRankConfiguration.validateBrankItems(min-1, max-1)){
                    System.out.println("Cannot create enough number of item from given definition");
                    continue;
                }
                System.out.println("Create item with this definition? (Y or N)");
                String confirm = in.readLine();
                if(confirm.equals("N")){
                    System.out.println("DEFINE LETTER LENGTH OF B RANK > (MIN MAX)");
                    continue;
                }
                itemRankConfiguration.initiateBrankItems(min-1, max-1);
                break;
            }
            // If anything goes wrong, display a generic error message
            catch(Exception e) { System.out.println("Invalid Input"); }
        }

        System.out.println("DEFINE LETTER LENGTH OF A RANK > (MIN MAX)");
        System.out.println("A RANK will include two Y letters.");
        // Loop forever
        while(true) {
            // Read a line from the user
            try {
                String line = in.readLine();

                // if the user types "quit", then quit
                if ((line == null) || line.equals("QUIT")) {
                    System.out.println("Game is end");
                    break;
                }
                if(!line.matches(ItemLetters.rankDefinition)){
                    System.out.println("Input is not correct format. Should be <min>(space)<max>.");
                    continue;
                }
                String[] params = line.split(" ");
                if (params.length!=2) {
                    System.out.println("Input is not correct format. Should be <min>(space)<max>.");
                    continue;
                }
                int min = Integer.parseInt(params[0]);
                int max = Integer.parseInt(params[1]);
                if(min<5 || min>10 || max<5 || max>10 || min> max){
                    System.out.println("Value of Min or Max is wrong. It should be between 5 - 10 and Min <= Max");
                    continue;
                }
                if(!itemRankConfiguration.validateArankItems(min-2, max-2)){
                    System.out.println("Cannot create enough number of item from given definition");
                    continue;
                }
                System.out.println("Create item with this definition? (Y or N)");
                String confirm = in.readLine();
                if(confirm.equals("N")){
                    System.out.println("DEFINE LETTER LENGTH OF A RANK > (MIN MAX)");
                    continue;
                }
                itemRankConfiguration.initiateArankItems(min-2, max-2);
                break;
            }
            // If anything goes wrong, display a generic error message
            catch(Exception e) { System.out.println("Invalid Input"); }
        }

        System.out.println("DEFINE LETTER LENGTH OF S RANK > (MIN MAX)");
        System.out.println("S RANK will include one X letter and two Y letters.");
        // Loop forever
        while(true) {
            // Read a line from the user
            try {
                String line = in.readLine();

                // if the user types "quit", then quit
                if ((line == null) || line.equals("QUIT")) {
                    System.out.println("Game is end");
                    break;
                }
                if(!line.matches(ItemLetters.rankDefinition)){
                    System.out.println("Input is not correct format. Should be <min>(space)<max>.");
                    continue;
                }
                String[] params = line.split(" ");
                if (params.length!=2) {
                    System.out.println("Input is not correct format. Should be <min>(space)<max>.");
                    continue;
                }
                int min = Integer.parseInt(params[0]);
                int max = Integer.parseInt(params[1]);
                if(min<5 || min>10 || max<5 || max>10 || min> max){
                    System.out.println("Value of Min or Max is wrong. It should be between 5 - 10 and Min <= Max");
                    continue;
                }
                if(!itemRankConfiguration.validateSrankItems(min-3, max-3)){
                    System.out.println("Cannot create enough number of item from given definition");
                    continue;
                }
                System.out.println("Create item with this definition? (Y or N)");
                String confirm = in.readLine();
                if(confirm.equals("N")){
                    System.out.println("DEFINE LETTER LENGTH OF S RANK > (MIN MAX)");
                    continue;
                }
                itemRankConfiguration.initiateSrankItems(min-3, max-3);
                break;
            }
            // If anything goes wrong, display a generic error message
            catch(Exception e) { System.out.println("Invalid Input"); }
        }

        try {
            System.out.println("CREATE 10 COMBINATION PIECE ITEM");
            System.out.println("CHOOSE BASE STRING FROM LIST");
            String go = in.readLine();
            itemRankConfiguration.printCombinationPieceCandidate();
            while (true) {
                // Read a line from the user

                String line = in.readLine();

                // if the user types "quit", then quit
                if ((line == null) || line.equals("QUIT")) {
                    System.out.println("Game is end");
                    break;
                }
                if (!line.matches(ItemLetters.combinationPiecePattern)) {
                    System.out.println("Input is not correct format. Should be 10 letters including one Y.");
                    continue;
                }

                if (!itemRankConfiguration.validateCombinationPieceCandidate(line)) {
                    System.out.println("Input is not correct value. Should choose from candidate list");
                    continue;
                }
                System.out.println("Create 10 Permutation items from this base string? (Y or N)");
                String confirm = in.readLine();
                if (confirm.equals("N")) {
                    System.out.println("CHOOSE BASE STRING FROM LIST");
                    continue;
                }
                itemRankConfiguration.generatePermutationOfCombinationPieces(line);
                itemRankConfiguration.printCombinationPieceSet();
                break;
            }
        }
        // If anything goes wrong, display a generic error message
        catch(Exception e) { System.out.println("Invalid Input"); }
    }

}
