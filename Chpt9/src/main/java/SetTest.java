import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class SetTest {
    //Hash: 内部为散列表
    //Set:不重复
    public static void main(String[] args) {
        HashSet<String> words = new HashSet<>();
        long totalTime = 0;

        try(Scanner in = new Scanner(System.in)){
            while(in.hasNext()){
                String word = in.next();
                long callTime = System.currentTimeMillis();
                if (word.equals("exit")) break;
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }
        Iterator<String> iter = words.iterator();
        for (int i = 1; i <= 20 && iter.hasNext(); i++){
            System.out.println(iter.next());
        }
        System.out.println(".....");
        System.out.println(words.size() + " distinct words. "+ totalTime + " milliseconds. ");
    }
}
