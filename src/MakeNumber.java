import java.util.*;

//게임에서 사용되는 정답 숫자를 생성하는 클래스
//random과 shuffle을 사용해 n자리수의 숫자를 생성하고 값을 해쉬셋, 리스트로 저장합니다.

public class MakeNumber {
    private HashSet<Integer> correctNumbersHashSet = new HashSet<>();
    private List<Integer> correctNumbersList = new ArrayList<>();
    Random random = new Random();
    private int digit = 0;

    //정답 숫자를 만들기 위한 makeNumber 메서드
    public void makeNumber(int n) {
        //입력받은 매개변수를 자릿수로 설정해준다
        setDigit(n);
        //설정한 자릿수만큼 도는 while문
        //random으로 숫자를 만들고 해쉬셋에 없는 숫자일시 .add로 해쉬셋에 추가해준다.
        while (correctNumbersHashSet.size() < n) {
            int inputNumber = random.nextInt(9) + 1;
            if (!correctNumbersHashSet.contains(inputNumber)) {
                correctNumbersHashSet.add(inputNumber);
            }
        }
    }

    //자릿수를 설정하는 메서드
    public void setDigit(int digit) {
        this.digit = digit;
    }

    //자릿수를 가져오는 getter 메서드
    public int getDigit(){
        return digit;
    }

    //해쉬셋의 숫자를 리스트로 저장해준다. 이때 해쉬셋은 데이터의 크기대로 출력되므로 shuffle을 통해 리스트의 순서를 섞어준다.
    public void setCorrectNumberList(){
        for(Integer i : this.correctNumbersHashSet){
            correctNumbersList.add(i);
        }
        Collections.shuffle(correctNumbersList);
    }

    //정답 숫자 리스트를 리턴
    public List<Integer> getCorrectNumbersList(){
        return this.correctNumbersList;
    }

    //정답 숫자 리스트에서 매개변수로 받은 순서의 값을 리턴
    public int getCorrectNumbersList(int arrayNumber){
        return this.correctNumbersList.get(arrayNumber);
    }

    //정답 숫자의 해쉬셋을 리턴
    public HashSet getCorrectNumbersHashSet(){
        return correctNumbersHashSet;
    }

    //정답 숫자의 해쉬셋을 초기화
    public void clearCorrectNumbersHashSet(){
        this.correctNumbersHashSet.clear();
    }

    //정답 숫자의 리스트를 초기화
    public void clearCorrectNumberList(){
        this.correctNumbersList.clear();
    }
}
