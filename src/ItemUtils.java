import java.util.*;

public class ItemUtils {
    public static String shuffleItem(String item){
        char[] itemChars = item.toCharArray();
        for (int i = itemChars.length - 1; i > 0; i--){
            int j = (int) (Math.random() * (i + 1));

            char temp = itemChars[i];
            itemChars[i] = itemChars[j];
            itemChars[j] = temp;
        }

        return String.valueOf(itemChars);
    }


    public static Set<String> createLetterCombinationSet(int n, String[] letters){
        Set<String> result = new TreeSet<String>();
        if(letters.length == 1){
            String output = letters[0].repeat(n);
            result.add(output);
            return result;
        } else {

            for(int i=n; i>-1; i--){
                if(n-i==0){
                    result.add(letters[0].repeat(i));
                }else {
                    Set<String> subResult = createLetterCombinationSet(n-i, Arrays.copyOfRange(letters, 1, letters.length));
                    Iterator<String> itr = subResult.iterator();
                    String prefix = letters[0].repeat(i);
                    while (itr.hasNext()) {
                        result.add(prefix+itr.next());
                    }
                }
            }
        }
        return result;
    }


    public static Set<String> createLetterCombinationSetWithPostfix(int n, String[] letters, String postfix){
        Set<String> finalResult = new TreeSet<String>();
        Set<String> result = createLetterCombinationSet(n, letters);
        Iterator<String> itr = result.iterator();
        while (itr.hasNext()){
            finalResult.add(itr.next() + postfix);
        }
        return finalResult;
    }

}
