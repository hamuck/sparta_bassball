import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputMenu = "";
        BaseballGame baseballGame = new BaseballGame();
        while(!inputMenu.equals("3")){
            System.out.println("게임을 시작하시려면 원하시는 메뉴를 입력 해 주세요.");
            System.out.println("1. 게임 시작하기 | 2. 게임 기록 보기 | 3. 종료하기");
            inputMenu = sc.nextLine();

            switch(inputMenu){
                case "1":
                    baseballGame.startGame(3);
                    break;
                case "2":
                    baseballGame.getCounts();
                    break;
                case "3":
                    System.out.println("게임을 종료합니다");
                    break;
            }
        }




    }
}