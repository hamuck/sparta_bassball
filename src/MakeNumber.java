import java.util.*;

public class MakeNumber {
    private HashSet<Integer> correctNumbersHashSet = new HashSet<>();
    private List<Integer> correctNumbersList = new ArrayList<>();
    Random random = new Random();
    private int digit = 0;

    public void makeNumber(int n) {
        setDigit(n);
        while (correctNumbersHashSet.size() < n) {
            int inputNumber = random.nextInt(9) + 1;
            if (!correctNumbersHashSet.contains(inputNumber)) {
                correctNumbersHashSet.add(inputNumber);
            }
        }
    }
    public void setDigit(int digit) {
        this.digit = digit;
    }
    public int getDigit(){
        return digit;
    }
    public void setCorrectNumberList(){
        for(Integer i : this.correctNumbersHashSet){
            correctNumbersList.add(i);
        }
        Collections.shuffle(correctNumbersList);
    }

    public List<Integer> getCorrectNumbersList(){
        return this.correctNumbersList;
    }

    public int getCorrectNumbersList(int arrayNumber){
        return this.correctNumbersList.get(arrayNumber);
    }

    public HashSet getCorrectNumbersHashSet(){
        return correctNumbersHashSet;
    }

    public void clearCorrectNumbersHashSet(){
        this.correctNumbersHashSet.clear();
    }


    public void clearCorrectNumberList(){
        this.correctNumbersList.clear();
    }





}
