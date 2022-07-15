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
}
