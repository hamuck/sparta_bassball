import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class MakeNumber {
    private HashSet<Integer> correctNumbers = new HashSet<>();
    private int correctNumber = 0;
    Random random = new Random();
    Iterator iter = correctNumbers.iterator();

    public void makeNumber(int n) {
        while (correctNumbers.size() < n) {
            int inputNumber = random.nextInt(9) + 1;
            if (!correctNumbers.contains(inputNumber)) {
                correctNumbers.add(inputNumber);
                System.out.println("add number: " + inputNumber);
            } else {
                System.out.println("중복");
            }
        }
    }
    public void setCorrectNumber(){
        String combineNumber = "";
        for(Integer i : this.correctNumbers){
            combineNumber += String.valueOf(i);
        }
        this.correctNumber = Integer.valueOf(combineNumber);
    }

    public int getCorrectNumber(){
        System.out.println("정답 Int: " + this.correctNumber);
        return this.correctNumber;
    }

    public HashSet getCorrectNumbers(){
        System.out.println("정답 HashSet: "+correctNumbers);
        return correctNumbers;
    }

    public void clearCorrectNumbers(){
        this.correctNumbers.clear();
    }




}
