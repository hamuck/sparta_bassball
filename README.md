# 숫자 야구 게임

## IDE : inteliJ
## 사용 언어 : java

------

숫자 야구 게임입니다.

이 프로그램은 랜덤한 n자리수의 숫자를
strike, ball, out 이라는 단서를 통해 추론해 나가는 게임입니다. 

------

# 사용 방법

## 메뉴
 - 0번 입력시 : 난이도 설정
    - 원하는 자리수를 입력해주세요,
    - 자리수는 3, 4, 5 중에 선택 가능합니다.
    - 자리수를 입력하지 않았을 경우, 기본 값인 3자리수로 설정됩니다.
  
      
 - 1번 입력시 : 게임 시작
    - 선택한 자리수만큼의 정수를 입력하세요.
    - 숫자의 위치가 같을 시 -> strike
    - 숫자가 존재하나 위치가 다를 시 -> ball
    - 숫자가 존재하지 않을 시 -> out
    - 설정한 n자리수 만큼 strike 일시, 정답
  
      
 - 2번 입력시 : 이전 기록 확인
   - 이전에 했던 게임들이 몇 번째에 정답을 맞췄는지 확인 할 수 있습니다.

     
 - 3번 입력시 : 게임 종료
   - 게임을 종료합니다.


----

## 구성
 - App.java > 메인
 - BaseballGame.java > 게임을 진행하는 클래스
 - MakeNumber > 게임에 필요한 정답 숫자를 만드는 클래스
