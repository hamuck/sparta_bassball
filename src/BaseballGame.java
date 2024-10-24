import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

//숫자야구게임 클래스
//사용자에게서 숫자를 입력받고, 값을 비교해 결과를 출력합니다

public class BaseballGame {
    Scanner sc = new Scanner(System.in);
    MakeNumber mkNumber = new MakeNumber();

    //입력 값 해쉬셋, 입력 값 리스트, 실행횟수 기록용 리스트
    private HashSet<Integer> inputNumbersHashSet = new HashSet<>();
    private ArrayList<Integer> inputNumbersList = new ArrayList<>();
    private ArrayList<Integer> counts = new ArrayList<>();

    //입력받은 값이 정답 숫자와 같은 자릿수인지 검사하는 메서드 (boolean값으로 리턴)
    public boolean checkInputNumber(){
        boolean check;
        if (inputNumbersHashSet.size() == mkNumber.getCorrectNumbersHashSet().size()){
            check = true;
        }else {
            check = false;
        }
        return check;
    }

    //입력받은 값을 해쉬셋, 리스트에 넣어주는 메서드
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

    //회차당 도전횟수를 기록하는 리스트에 값을 추가해주는 메서드
    public void setCounts(int cnt) {
        this.counts.add(cnt);
    }

    //지금까지의 도전횟수를 출력하는 메서드
    public void getCounts(){
        for (int i = 0; i < this.counts.size(); i++){
            System.out.println((i+1)+"번째 게임 : 시도 횟수 - "+this.counts.get(i));
        }
    }

    //입력 값이 있는 리스트에서 매개변수에 맞는 순서의 값을 리턴한다
    public int getInputNumbersList(int arrayNumber) {
        return this.inputNumbersList.get(arrayNumber);
    }

    //입력받은 해쉬셋을 초기화 시켜주는 메서드
    public void clearInputNumbersHashSet() {
        this.inputNumbersHashSet.clear();
    }

    //입력받은 리스트를 초기화 시켜주는 메서드
    public void clearInputNumberList() {
        this.inputNumbersList.clear();
    }

    //테스트때 사용한 getter 메서드들 (해쉬셋, 리스트)
    public ArrayList<Integer> getInputNumbersList() {
        return this.inputNumbersList;
    }

    public HashSet<Integer> getInputNumbersHashSet() {
        return this.inputNumbersHashSet;
    }

    //입력받은 값과 정답 값을 비교하는 함수
    public int compareNumber() {
        //makenumber로 만든 정답 숫자를 correctNumber라는 해쉬셋에 저장
        HashSet<Integer> correctNumber = mkNumber.getCorrectNumbersHashSet();
        //게임 진행을 위한 스트라이크, 볼, 아웃 변수
        int strike = 0;
        int ball = 0;
        int out = 0;

        //입력받은 숫자 리스트 사이즈 만큼 For문 진행
        //리스트가 같은 인덱스, 같은 숫자일시 -> 스트라이크, 숫자가 같진 않으나 해쉬셋에 포함되어있을경우 -> 볼, 나머지 -> 아웃
        for (int i = 0; i < inputNumbersList.size(); i++) {
            if (mkNumber.getCorrectNumbersList(i) == getInputNumbersList(i)) {
                strike++;

            } else if (correctNumber.contains(i)) {
                ball++;

            } else {
                out++;
            }
        }
        //스트라이크, 볼, 아웃 출력
        //입력값 초기화 (해쉬셋, 리스트)
        System.out.println("strike: " + strike + " ball: " + ball + " out: " + out);
        clearInputNumbersHashSet();
        clearInputNumberList();

        //정답 여부 확인을 위해 스트라이크 값을 리턴한다.
        return strike;
    }

        //게임을 진행하는 메서드
        public void startGame(int digit) {

            //digit은 난이도 설정때 고른 자리수 값 (설정하지 않았을 시 기본 값 3)
            //MakeNumber클래스의 makeNumber 메서드를 사용해 조건에 맞는 정답 숫자를 만든다.
            //또한, 리스트로 순서를 비교해야 하므로 setCorrectNumberList로 makeNumber에서 만들어진 숫자를 리스트에 넣는다.
            mkNumber.makeNumber(digit);
            mkNumber.setCorrectNumberList();
            //실행횟수를 카운트하는 변수
            int tries = 0;

            //System.out.println("정답리스트"+mkNumber.getCorrectNumbersList()); <- 정답 숫자를 출력하는 코드(테스트용으로 작성)

            //break가 나올 때 까지 반복
            while (true) {
                try{
                    System.out.println("숫자를 입력해 주세요");
                    int input1 = sc.nextInt();
                    sc.nextLine();
                    tries++;
                    setInputNumbers(input1);
                    if (!checkInputNumber()){
                        System.out.println(digit+" 자릿수의 숫자를 입력해 주세요");
                    }
                }catch (InputMismatchException e) {
                    System.out.println("잘못된 입력입니다");
                    sc.nextLine();
                    mkNumber.clearCorrectNumbersHashSet();
                    mkNumber.clearCorrectNumberList();
                    break;
                }

                if (compareNumber() == digit) {
                    System.out.println("정답입니다! : "+mkNumber.getCorrectNumbersList());
                    mkNumber.clearCorrectNumbersHashSet();
                    mkNumber.clearCorrectNumberList();
                    setCounts(tries);
                    break;
                }
            }
        }

}
