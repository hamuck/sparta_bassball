import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BaseballGame {
    Scanner sc = new Scanner(System.in);
    MakeNumber mkNumber = new MakeNumber();
    private HashSet<Integer> inputNumbersHashSet = new HashSet<>();
    private ArrayList<Integer> inputNumbersList = new ArrayList<>();
    private ArrayList<Integer> counts = new ArrayList<>();

    public void setInputNumbers(int input) {
        String s = String.valueOf(input);
        int[] inputNumbers = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            inputNumbers[i] = Integer.parseInt(s.charAt(i)+"");
            try {
                inputNumbersHashSet.add(inputNumbers[i]);
                inputNumbersList.add(inputNumbers[i]);
            } catch (InputMismatchException e) {
                System.out.println("1 ~ 9 범위의 정수만 입력이 가능합니다!");
            }
        }
    }

    public void setCounts(int cnt) {
        this.counts.add(cnt);
    }

    public void getCounts(){
        for (int i = 0; i < this.counts.size(); i++){
            System.out.println((i+1)+"번째 시도 횟수 : "+this.counts.get(i));
        }
    }

    public int getInputNumbersList(int arrayNumber) {
        return this.inputNumbersList.get(arrayNumber);
    }


    public ArrayList<Integer> getInputNumbersList() {
        return this.inputNumbersList;
    }

    public HashSet<Integer> getInputNumbersHashSet() {
        return this.inputNumbersHashSet;
    }

    public void clearInputNumbersHashSet() {
        this.inputNumbersHashSet.clear();
    }


    public void clearInputNumberList() {
        this.inputNumbersList.clear();
    }

    public int compareNumber() {
        HashSet<Integer> correctNumber = mkNumber.getCorrectNumbersHashSet();
        int strike = 0;
        int ball = 0;
        int out = 0;
        for (int i = 0; i < inputNumbersList.size(); i++) {
            if (mkNumber.getCorrectNumbersList(i) == getInputNumbersList(i)) {
                strike++;

            } else if (correctNumber.contains(i)) {
                ball++;

            } else {
                out++;
            }
        }
        System.out.println("strike: " + strike + " ball: " + ball + " out: " + out);
        clearInputNumbersHashSet();
        clearInputNumberList();

        return strike;
    }


        public void startGame(int digit) {
            mkNumber.makeNumber(digit);
            mkNumber.setCorrectNumberList();
            int tries = 0;
            System.out.println("정답리스트"+mkNumber.getCorrectNumbersList());

            while (true) {
                try{
                    System.out.println("숫자를 입력해 주세요");
                    int input1 = sc.nextInt();
                    tries++;
                    setInputNumbers(input1);

                }catch (InputMismatchException e) {
                    System.out.println("잘못된 입력입니다");
                    break;
                }

                if (compareNumber() == 3) {
                    mkNumber.clearCorrectNumbersHashSet();
                    mkNumber.clearCorrectNumberList();
                    setCounts(tries);
                    break;
                }
            }
        }

}
