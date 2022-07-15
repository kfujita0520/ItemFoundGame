import java.util.HashSet;
import java.util.Set;

public class GameController {

    AllRanksItemSets allRankItems;
    Set<String> inputList;

    public GameController(){
        allRankItems = new AllRanksItemSets();
        inputList = new HashSet<String>();
    }

    public boolean isInputAlready(String input) {
        return inputList.contains(input);
    }

    //0: no item found, 1: item found, 2 last piece of combination piece is found
    public int validateInput(String input){

        inputList.add(input);

        if(allRankItems.getSrank().isContainInPermutationSet(input)){
            System.out.println("S Rank item is found");
        } else if(allRankItems.getArank().isContainInPermutationSet(input)){
            System.out.println("A Rank item is found");
        } else if(allRankItems.getBrank().isContainInPermutationSet(input)){
            System.out.println("B Rank item is found");
        } else if(allRankItems.getCrank().isContainInPermutationSet(input)){
            System.out.println("C Rank item is found");
        } else if(allRankItems.getDrank().isContainInPermutationSet(input)){
            System.out.println("D Rank item is found");
        } else if(allRankItems.getCombinationPieceSet().contains(input)){
            System.out.println("Combination Piece item is found.");
            allRankItems.getCombinationPieceSet().remove(input);
            int count = allRankItems.getCombinationPieceSet().size();
            System.out.println(10-count + " of 10 piece items have been found so far");
            if (count == 0){
                return 2;
            }
        } else {
            System.out.println("No Item is found");
            return 0;
        }
        return 1;
    }

    public void reshufflePermutationItem() {
        allRankItems.reshuffleAllRankPermutationSet();
        allRankItems.initiateCombinationPieces();
        inputList.clear();
    }
}
