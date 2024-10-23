import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BaseballGame {
    Scanner sc = new Scanner(System.in);
    MakeNumber mkNumber = new MakeNumber();
    private HashSet<Integer> inputNumbersHashSet = new HashSet<>();
    private ArrayList<Integer> inputNumbersList = new ArrayList<>();

    public void setInputNumbers(int inputNumber) {
        try {
            inputNumbersHashSet.add(inputNumber);
            inputNumbersList.add(inputNumber);
        } catch (InputMismatchException e) {
            System.out.println("1 ~ 9 범위의 정수만 입력이 가능합니다!");
        }
    }

    public int getInputNumbersList(int arrayNumber) {
        return this.inputNumbersList.get(arrayNumber);
    }


    public ArrayList<Integer> getInputNumbersList() {
        return this.inputNumbersList;
    }

    public HashSet<Integer> getInputNumbersListHashSet() {
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
                System.out.println(mkNumber.getCorrectNumbersList(i)+"는 입력 "+getInputNumbersList(i)+"스트라이크");

            } else if (correctNumber.contains(i)) {
                ball++;
                System.out.println(mkNumber.getCorrectNumbersList(i)+"는 입력 "+getInputNumbersList(i)+"볼");

            } else {
                out++;
                System.out.println(mkNumber.getCorrectNumbersList(i)+"는 입력 "+getInputNumbersList(i)+"아웃");
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

            System.out.println("해쉬셋"+getInputNumbersListHashSet());
            System.out.println("정답리스트"+mkNumber.getCorrectNumbersList());

            while (true) {
                System.out.println("첫번째 숫자를 입력해 주세요");
                int input1 = sc.nextInt();
                setInputNumbers(input1);
                System.out.println("두번째 숫자를 입력해 주세요");
                int input2 = sc.nextInt();
                setInputNumbers(input2);
                System.out.println("세번째 숫자를 입력해 주세요");
                int input3 = sc.nextInt();
                setInputNumbers(input3);

                System.out.println("해쉬셋"+getInputNumbersListHashSet());

                int strike = compareNumber();

                if (strike == 3) {
                    mkNumber.clearCorrectNumbersHashSet();
                    mkNumber.clearCorrectNumberList();
                    break;
                }
            }
        }

}
