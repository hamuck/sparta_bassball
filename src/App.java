import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputMenu = "";
        BaseballGame baseballGame = new BaseballGame();
        int difficulty = 3;
        while(!inputMenu.equals("3")){
            System.out.println("게임을 시작하시려면 원하시는 메뉴를 입력 해 주세요.");
            System.out.println("0. 난이도 설정하기 | 1. 게임 시작하기 | 2. 게임 기록 보기 | 3. 종료하기");
            inputMenu = sc.nextLine();

            switch(inputMenu){
                case "0":
                    System.out.println("설정하고자 하는 자리수를 입력하세요.");
                    System.out.println("현재 자리수 : "+difficulty);
                    difficulty = sc.nextInt();
                    sc.nextLine();
                    if (difficulty >= 6 || difficulty <= 3){
                        //커스텀예외처리기능추가하기
                    }
                    System.out.println(difficulty+"자리수 난이도로 설정되었습니다.");
                case "1":
                    baseballGame.startGame(difficulty);
                    inputMenu = "";
                    break;
                case "2":
                    baseballGame.getCounts();
                    inputMenu = "";
                    break;
                case "3":
                    System.out.println("게임을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 입력입니다");
            }
        }
    }
}