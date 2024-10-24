import java.util.InputMismatchException;
import java.util.Scanner;

//메인함수가 있는 App 클래스

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String inputMenu = "";
        //Baseball 클래스 객체 선언
        BaseballGame baseballGame = new BaseballGame();
        //기본 설정 난이도는 3
        int difficulty = 3;

        //inputMenu가 3이 될때까지 반복
        while(!inputMenu.equals("3")){
            System.out.println("게임을 시작하시려면 원하시는 메뉴를 입력 해 주세요.");
            System.out.println("0. 난이도 설정하기 | 1. 게임 시작하기 | 2. 게임 기록 보기 | 3. 종료하기");
            inputMenu = sc.nextLine();

            switch(inputMenu){
                //inputMenu에서 0 입력시 자리수 설정
                case "0":
                    System.out.println("설정하고자 하는 자리수를 입력하세요.");
                    System.out.println("현재 자리수 : "+difficulty);
                    difficulty = sc.nextInt();
                    sc.nextLine();
                    if (difficulty >= 5 || difficulty <= 3){
                        throw new InputMismatchException("3, 4, 5 범위 내에 숫자만 가능합니다.");
                    }
                    System.out.println(difficulty+"자리수 난이도로 설정되었습니다.");
                //inputMenu에서 1 입력시 게임 시작
                case "1":
                    baseballGame.startGame(difficulty);
                    inputMenu = "";
                    break;
                //inputMenu에서 2 입력시 이전 기록들 출력
                case "2":
                    baseballGame.getCounts();
                    inputMenu = "";
                    break;
                //inputMenu에서 3 입력시 게임 종료
                case "3":
                    System.out.println("게임을 종료합니다.");
                    break;
                //inputMenu에서 이외의 값 입력시 아래 문장 출력
                default:
                    System.out.println("잘못된 입력입니다");
            }
        }
    }
}