import java.util.*;

public class ItemSet {
    Set<String> combinationSet;
    Set<String> permutationSet;

    public ItemSet(){
        combinationSet = new TreeSet<String>();
        permutationSet = new HashSet<String>();
    }

    public void addItem(String item){
        permutationSet.add(item);
        char[] itemChars = item.toCharArray();
        Arrays.sort(itemChars, 0, itemChars.length);
        combinationSet.add(String.valueOf(itemChars));
    }

    public void generateInitialItemSet(String[] items){
        for (int i=0; i<items.length; i++){
            addItem(items[i]);
        }
    }



    public boolean isContainInCombinationSet(String newItem){
        char[] itemChars = newItem.toCharArray();
        Arrays.sort(itemChars, 0, itemChars.length);
        return combinationSet.contains(String.valueOf(itemChars));

    }

    public boolean isContainInPermutationSet(String newItem){
        return permutationSet.contains(newItem);

    }

    public void reshufflePermutationSet(){
        permutationSet.clear();
        Iterator<String> itr = combinationSet.iterator();
        while (itr.hasNext()) {
            permutationSet.add(ItemUtils.shuffleItem(itr.next()));
        }
    }

    public void printCombinationSet(){
        Iterator<String> itr = combinationSet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public void printPermutationSet(){
        Iterator<String> itr = permutationSet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }


}
