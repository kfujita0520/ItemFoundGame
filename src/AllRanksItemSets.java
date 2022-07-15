import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AllRanksItemSets {

    ItemSet Srank;
    ItemSet Arank;
    ItemSet Brank;
    ItemSet Crank;
    ItemSet Drank;

    String combinationPiece;
    Set<String> combinationPieceSet;

    public AllRanksItemSets(){
        Srank = new ItemSet();
        Arank = new ItemSet();
        Brank = new ItemSet();
        Crank = new ItemSet();
        Drank = new ItemSet();
        combinationPieceSet = new HashSet<String>();

        initiateSrankItems();
        initiateArankItems();
        initiateBrankItems();
        initiateCrankItems();
        initiateDrankItems();
        initiateCombinationPieces();

    }

    public void initiateCombinationPieces()
    {
        String item;
        boolean isCreated = false;

        while(!isCreated){
            item = generateCombinationArtifact(10);
            if(!Crank.isContainInCombinationSet(item)){
                combinationPiece  = item;
                generatePermutationOfCombinationPieces(combinationPiece);
                isCreated = true;
            }
        }
        printCombinationPieceSet();

    }

    public void generatePermutationOfCombinationPieces(String item){
        String itemVariants;
        int count = 0;
        while (count < 10){
            itemVariants = ItemUtils.shuffleItem(item);
            if(!combinationPieceSet.contains(itemVariants)){
                combinationPieceSet.add(itemVariants);
                count++;
            }
        }
    }

    public void reshuffleAllRankPermutationSet(){
        Srank.reshufflePermutationSet();
        Arank.reshufflePermutationSet();
        Brank.reshufflePermutationSet();
        Crank.reshufflePermutationSet();
        Drank.reshufflePermutationSet();

    }

    public void initiateSrankItems()
    {
        String item;
        int count = 0;
        while(count!=10){
            item = generateCombinationArtifact(7);
            item += ItemLetters.X + ItemLetters.Y + ItemLetters.Y;
            if(!Srank.isContainInCombinationSet(item)){

                Srank.addItem(ItemUtils.shuffleItem(item));
                count++;
            }
        }

    }

    public void initiateArankItems()
    {
        String item;
        int count = 0;
        while(count!=12){
            item = generateCombinationArtifact(8);
            item += ItemLetters.Y + ItemLetters.Y;
            if(!Arank.isContainInCombinationSet(item)){

                Arank.addItem(ItemUtils.shuffleItem(item));
                count++;
            }
        }
        count =0;
        while(count!=8){
            item = generateCombinationArtifact(7);
            item += ItemLetters.Y + ItemLetters.Y;
            if(!Arank.isContainInCombinationSet(item)){

                Arank.addItem(ItemUtils.shuffleItem(item));
                count++;
            }
        }

    }


    public void initiateBrankItems()
    {
        String item;
        int count = 0;
        while(count!=12){
            item = generateCombinationArtifact(7);
            item += ItemLetters.Y;
            if(!Brank.isContainInCombinationSet(item)){

                Brank.addItem(ItemUtils.shuffleItem(item));
                count++;
            }
        }
        count =0;
        while(count!=10){
            item = generateCombinationArtifact(6);
            item += ItemLetters.Y;
            if(!Brank.isContainInCombinationSet(item)){

                Brank.addItem(ItemUtils.shuffleItem(item));
                count++;
            }
        }
        count =0;
        while(count!=5){
            item = generateCombinationArtifact(5);
            item += ItemLetters.Y;
            if(!Brank.isContainInCombinationSet(item)){

                Brank.addItem(ItemUtils.shuffleItem(item));
                count++;
            }
        }
        count =0;
        while(count!=3){
            item = generateCombinationArtifact(4);
            item += ItemLetters.Y;
            if(!Brank.isContainInCombinationSet(item)){

                Brank.addItem(ItemUtils.shuffleItem(item));
                count++;
            }
        }

    }


    public void initiateCrankItems()
    {
        String item;
        int count = 0;
        while(count!=25){
            item = generateCombinationArtifact(9);
            if(!Crank.isContainInCombinationSet(item)){

                Crank.addItem(ItemUtils.shuffleItem(item));
                count++;
            }
        }
        count =0;
        while(count!=25){
            item = generateCombinationArtifact(10);
            if(!Crank.isContainInCombinationSet(item)){

                Crank.addItem(ItemUtils.shuffleItem(item));
                count++;
            }
        }

    }

    public void initiateDrankItems()
    {
        String item;
        int count = 0;
        while(count!=3){
            item = generateCombinationArtifact(3);
            if(!Drank.isContainInCombinationSet(item)){

                Drank.addItem(ItemUtils.shuffleItem(item));
                count++;
            }
        }
        count =0;
        while(count!=7){
            item = generateCombinationArtifact(4);
            if(!Drank.isContainInCombinationSet(item)){

                Drank.addItem(ItemUtils.shuffleItem(item));
                count++;
            }
        }
        count =0;
        while(count!=10){
            item = generateCombinationArtifact(5);
            if(!Drank.isContainInCombinationSet(item)){

                Drank.addItem(ItemUtils.shuffleItem(item));
                count++;
            }
        }
        count =0;
        while(count!=15){
            item = generateCombinationArtifact(6);
            if(!Drank.isContainInCombinationSet(item)){

                Drank.addItem(ItemUtils.shuffleItem(item));
                count++;
            }
        }
        count =0;
        while(count!=22){
            item = generateCombinationArtifact(7);
            if(!Drank.isContainInCombinationSet(item)){

                Drank.addItem(ItemUtils.shuffleItem(item));
                count++;
            }
        }
        count =0;
        while(count!=33){
            item = generateCombinationArtifact(8);
            if(!Drank.isContainInCombinationSet(item)){

                Drank.addItem(ItemUtils.shuffleItem(item));
                count++;
            }
        }

    }


    public String generateCombinationArtifact(int n)
    {

        String commonLetters = "ABC";
        String[] commonLetterArray = {ItemLetters.A, ItemLetters.B, ItemLetters.C};

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
        int[] letterNum = new int[commonLetterArray.length];
        int count = n;

        for (int k=0; k<letterNum.length; k++){
            if(k!=letterNum.length-1){
                letterNum[k] = (int) ((count+1) * Math.random());
                count -= letterNum[k];
            } else { //k==letterNum.length-1
                letterNum[k] = count;
                count = 0;
            }
        }

        for (int i=0; i< letterNum.length; i++){
            for(int j=0; j<letterNum[i]; j++){
                //sb.append(commonLetters.charAt(i));
                sb.append(commonLetterArray[i]);
            }
        }

        return sb.toString();
    }

    public void printCombinationPieceSet(){
        Iterator<String> itr = combinationPieceSet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public ItemSet getSrank() {
        return Srank;
    }

    public ItemSet getArank() {
        return Arank;
    }

    public ItemSet getBrank() {
        return Brank;
    }

    public ItemSet getCrank() {
        return Crank;
    }

    public ItemSet getDrank() {
        return Drank;
    }

    public String getCombinationPiece() {
        return combinationPiece;
    }

    public Set<String> getCombinationPieceSet() {
        return combinationPieceSet;
    }
}
