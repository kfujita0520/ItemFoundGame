import java.util.*;

public class ItemRankConfiguration {

    ItemSet Srank;
    ItemSet Arank;
    ItemSet Brank;
    ItemSet Crank;
    ItemSet Drank;


    Map<String, Set<String>> combinationSetMap;

    Set<String> combinationPieceSet;

    public ItemRankConfiguration(){


        Srank = new ItemSet();
        Arank = new ItemSet();
        Brank = new ItemSet();
        Crank = new ItemSet();
        Drank = new ItemSet();
        combinationSetMap = new HashMap<String, Set<String>>();
        combinationPieceSet = new HashSet<String>();

        initiateLetterCombinationSets();


    }

    public void initiateLetterCombinationSets()
    {
        String[] commonLetterArray = {ItemLetters.A, ItemLetters.B, ItemLetters.C};
        for(int i=3; i<=10; i++){
            String key = String.valueOf(i) + "00";
            combinationSetMap.put(key, ItemUtils.createLetterCombinationSet(i, commonLetterArray));
        }
        for(int i=2; i<=9; i++){ //include Y
            String key = String.valueOf(i) + "01";
            combinationSetMap.put(key, ItemUtils.createLetterCombinationSetWithPostfix(i, commonLetterArray, "Y"));
        }
        for(int i=3; i<=8; i++){ //include YY
            String key = String.valueOf(i) + "02";
            combinationSetMap.put(key, ItemUtils.createLetterCombinationSetWithPostfix(i, commonLetterArray, "YY"));
        }
        //include XYY
        for(int i=2; i<=7; i++){ //include XYY
            String key = String.valueOf(i) + "12";
            combinationSetMap.put(key, ItemUtils.createLetterCombinationSetWithPostfix(i, commonLetterArray, "XYY"));
        }

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


    //Specify min and max value of item letter length
    public void initiateDrankItems(int min, int max)
    {
        //initialization
        int totalStock = 0;
        int[] itemStocks = new int[11];//number of available item for each letter length
        for(int i=min; i<=max; i++){
            int num = combinationSetMap.get(String.valueOf(i) + "00").size();
            //System.out.println("Item letter length: " + i + " Number of item stocks: " + num);
            totalStock +=  num;
            itemStocks[i] = num;
        }
        //System.out.println("total size: " + totalStock);

        //create (or choose) 90 items from stock
        for(int count=0; count<90; count++){
            int index = (int)(totalStock*Math.random())+1;//index represents the item to be picked up
            int letter_length = min;
            while(index > itemStocks[letter_length]){
                //System.out.println("index: " + index );
                //System.out.println("numOfItem: " + numOfItem[letter_length] );
                index -= itemStocks[letter_length];
                letter_length++;
            }

            //convert from Set to LinkedList
            List<String> letterCombList = combinationSetMap.get(String.valueOf(letter_length) + "00").stream().toList();
            String item = letterCombList.get(index-1);


            combinationSetMap.get(String.valueOf(letter_length) + "00").remove(item);
            itemStocks[letter_length]--;
            totalStock--;
            Drank.addItem(ItemUtils.shuffleItem(item));
        }

        Drank.printPermutationSet();


    }

    //Specify min and max value of item letter length
    public void initiateCrankItems(int min, int max)
    {
        //initialization
        int totalStock = 0;
        int[] itemStocks = new int[11];//number of available item for each letter length
        for(int i=min; i<=max; i++){
            int num = combinationSetMap.get(String.valueOf(i) + "00").size();
            //System.out.println("Item letter length: " + i + " Number of item stocks: " + num);
            totalStock +=  num;
            itemStocks[i] = num;
        }
        //System.out.println("total size: " + totalStock);

        //create (or choose) 50 items from stock
        for(int count=0; count<50; count++){
            int index = (int)(totalStock*Math.random())+1;//index represents the item to be picked up
            int letter_length = min;
            while(index > itemStocks[letter_length]){
                //System.out.println("index: " + index );
                //System.out.println("numOfItem: " + numOfItem[letter_length] );
                index -= itemStocks[letter_length];
                letter_length++;
            }

            //convert from Set to LinkedList
            List<String> letterCombList = combinationSetMap.get(String.valueOf(letter_length) + "00").stream().toList();
            String item = letterCombList.get(index-1);


            combinationSetMap.get(String.valueOf(letter_length) + "00").remove(item);
            itemStocks[letter_length]--;
            totalStock--;
            Crank.addItem(ItemUtils.shuffleItem(item));
        }

        Crank.printPermutationSet();

    }

    //Specify min and max value of item letter length
    public void initiateBrankItems(int min, int max)
    {
        //initialization
        int totalStock = 0;
        int[] itemStocks = new int[11];//number of available item for each letter length
        for(int i=min; i<=max; i++){
            int num = combinationSetMap.get(String.valueOf(i) + "01").size();
            //System.out.println("Item letter length: " + i + " Number of item stocks: " + num);
            totalStock +=  num;
            itemStocks[i] = num;
        }
        //System.out.println("total size: " + totalStock);

        //create (or choose) 30 items from stock
        for(int count=0; count<30; count++){
            int index = (int)(totalStock*Math.random())+1;//index represents the item to be picked up
            int letter_length = min;
            while(index > itemStocks[letter_length]){
                //System.out.println("index: " + index );
                //System.out.println("numOfItem: " + numOfItem[letter_length] );
                index -= itemStocks[letter_length];
                letter_length++;
            }

            //convert from Set to LinkedList
            List<String> letterCombList = combinationSetMap.get(String.valueOf(letter_length) + "01").stream().toList();
            String item = letterCombList.get(index-1);


            combinationSetMap.get(String.valueOf(letter_length) + "01").remove(item);
            itemStocks[letter_length]--;
            totalStock--;
            Brank.addItem(ItemUtils.shuffleItem(item));
        }

        Brank.printPermutationSet();

    }

    //Specify min and max value of item letter length
    public void initiateArankItems(int min, int max)
    {
        //initialization
        int totalStock = 0;
        int[] itemStocks = new int[11];//number of available item for each letter length
        for(int i=min; i<=max; i++){
            int num = combinationSetMap.get(String.valueOf(i) + "02").size();
            //System.out.println("Item letter length: " + i + " Number of item stocks: " + num);
            totalStock +=  num;
            itemStocks[i] = num;
        }
        //System.out.println("total size: " + totalStock);

        //create (or choose) 20 items from stock
        for(int count=0; count<20; count++){
            int index = (int)(totalStock*Math.random())+1;//index represents the item to be picked up
            int letter_length = min;
            while(index > itemStocks[letter_length]){
                //System.out.println("index: " + index );
                //System.out.println("numOfItem: " + numOfItem[letter_length] );
                index -= itemStocks[letter_length];
                letter_length++;
            }

            //convert from Set to LinkedList
            List<String> letterCombList = combinationSetMap.get(String.valueOf(letter_length) + "02").stream().toList();
            String item = letterCombList.get(index-1);


            combinationSetMap.get(String.valueOf(letter_length) + "02").remove(item);
            itemStocks[letter_length]--;
            totalStock--;
            Arank.addItem(ItemUtils.shuffleItem(item));
        }

        Arank.printPermutationSet();

    }

    //Specify min and max value of item letter length
    public void initiateSrankItems(int min, int max)
    {
        //initialization
        int totalStock = 0;
        int[] itemStocks = new int[11];//number of available item for each letter length
        for(int i=min; i<=max; i++){
            int num = combinationSetMap.get(String.valueOf(i) + "12").size();
            //System.out.println("Item letter length: " + i + " Number of item stocks: " + num);
            totalStock +=  num;
            itemStocks[i] = num;
        }
        //System.out.println("total size: " + totalStock);

        //create (or choose) 10 items from stock
        for(int count=0; count<10; count++){
            int index = (int)(totalStock*Math.random())+1;//index represents the item to be picked up
            int letter_length = min;
            while(index > itemStocks[letter_length]){
                //System.out.println("index: " + index );
                //System.out.println("numOfItem: " + numOfItem[letter_length] );
                index -= itemStocks[letter_length];
                letter_length++;
            }

            //convert from Set to LinkedList
            List<String> letterCombList = combinationSetMap.get(String.valueOf(letter_length) + "12").stream().toList();
            String item = letterCombList.get(index-1);


            combinationSetMap.get(String.valueOf(letter_length) + "12").remove(item);
            itemStocks[letter_length]--;
            totalStock--;
            Srank.addItem(ItemUtils.shuffleItem(item));
        }

        Srank.printPermutationSet();

    }

    //Specify min and max value of item letter length
    public boolean validateDrankItems(int min, int max)
    {
        //initialization
        int totalStock = 0;//number of available item stock to be chosen
        int[] itemStocks = new int[11];//item stock per item letter length
        for(int i=min; i<=max; i++){
            int num = combinationSetMap.get(String.valueOf(i) + "00").size();
            System.out.println("item length: " + i + " num of items: " + num);
            totalStock +=  num;
            itemStocks[i] = num;
        }
        System.out.println("total size: " + totalStock);
        if(totalStock >=90){
            return true;
        } else {
            System.out.println("We cannot create 90 items from " + totalStock + " stocks");
            return false;
        }


    }

    //Specify min and max value of item letter length
    public boolean validateCrankItems(int min, int max)
    {
        //initialization
        int totalStock = 0;//number of available item stock to be chosen
        int[] itemStocks = new int[11];//item stock per item letter length
        for(int i=min; i<=max; i++){
            int num = combinationSetMap.get(String.valueOf(i) + "00").size();
            System.out.println("item length: " + i + " num of items: " + num);
            totalStock +=  num;
            itemStocks[i] = num;
        }
        System.out.println("total size: " + totalStock);
        if(totalStock >=50){
            return true;
        } else {
            System.out.println("We cannot create 50 items from " + totalStock + " stocks");
            return false;
        }


    }

    //Specify min and max value of item letter length
    public boolean validateBrankItems(int min, int max)
    {
        //initialization
        int totalStock = 0;//number of available item stock to be chosen
        int[] itemStocks = new int[11];//item stock per item letter length
        for(int i=min; i<=max; i++){
            int num = combinationSetMap.get(String.valueOf(i) + "01").size();
            System.out.println("item length: " + (i+1) + " num of items: " + num);
            totalStock +=  num;
            itemStocks[i] = num;
        }
        System.out.println("total size: " + totalStock);
        if(totalStock >=30){
            return true;
        } else {
            System.out.println("We cannot create 30 items from " + totalStock + " stocks");
            return false;
        }

    }


    //Specify min and max value of item letter length
    public boolean validateArankItems(int min, int max)
    {
        //initialization
        int totalStock = 0;//number of available item stock to be chosen
        int[] itemStocks = new int[11];//item stock per item letter length
        for(int i=min; i<=max; i++){
            int num = combinationSetMap.get(String.valueOf(i) + "02").size();
            System.out.println("item length: " + (i+2) + " num of items: " + num);
            totalStock +=  num;
            itemStocks[i] = num;
        }
        System.out.println("total size: " + totalStock);
        if(totalStock >=20){
            return true;
        } else {
            System.out.println("We cannot create 20 items from " + totalStock + " stocks");
            return false;
        }

    }

    //Specify min and max value of item letter length
    public boolean validateSrankItems(int min, int max)
    {
        //initialization
        int totalStock = 0;//number of available item stock to be chosen
        int[] itemStocks = new int[11];//item stock per item letter length
        for(int i=min; i<=max; i++){
            int num = combinationSetMap.get(String.valueOf(i) + "12").size();
            System.out.println("item length: " + (i+3) + " num of items: " + num);
            totalStock +=  num;
            itemStocks[i] = num;
        }
        System.out.println("total size: " + totalStock);
        if(totalStock >=10){
            return true;
        } else {
            System.out.println("We cannot create 10 items from " + totalStock + " stocks");
            return false;
        }

    }

    public void printCombinationPieceCandidate(){
        Set<String> candidates = combinationSetMap.get("901");
        Iterator<String> itr = candidates.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public boolean validateCombinationPieceCandidate(String candidate){
        Set<String> candidates = combinationSetMap.get("901");
        return candidates.contains(candidate);
    }

    public void printCombinationPieceSet(){
        Iterator<String> itr = combinationPieceSet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public void shuffleCombinationPieces()
    {
        Set<String> candidates = combinationSetMap.get("901");
        String item = candidates.stream().toList().get((int)((candidates.size())*Math.random()));
        generatePermutationOfCombinationPieces(item);
        printCombinationPieceSet();

    }

    public void reshuffleAllRankPermutationSet(){
        Srank.reshufflePermutationSet();
        Arank.reshufflePermutationSet();
        Brank.reshufflePermutationSet();
        Crank.reshufflePermutationSet();
        Drank.reshufflePermutationSet();

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


    public Set<String> getCombinationPieceSet() {
        return combinationPieceSet;
    }
}
