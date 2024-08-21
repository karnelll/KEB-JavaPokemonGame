import java.util.Random;
import java.util.Scanner;

class bushfind{
    Scanner playerChoice = new Scanner(System.in);

    public bushfind(){}

    
    public void ezbushfind(){
    do{
        
        System.out.println("탈출 0 수집 1");
        int choice = playerChoice.nextInt();

    Random random = new Random();
    int randomNumber = (random.nextInt())%10;
    
    

        switch(choice){
            case 0: System.out.println("그럼이만"); playerChoice.close(); break;
            case 1: {
                if(randomNumber>=6){
                    System.out.println("포켓몬을 잡았다!");
                }
                else if((randomNumber < 6) && (randomNumber>=1)){
                    if((randomNumber<6)&&(randomNumber>3)){
                        System.out.println("몬스터볼을 얻었다!");
                    }
                    else {
                        System.out.println("상처약을 얻었다!");
                    }
                }
                else{
                    System.out.println("이상한 사탕을 얻었다!");
                }
                continue;
            }
            default: System.out.println("다시 입력"); continue;
            }
            
    }while(true);
    
}

public static void main (String[] args){
    
    bushfind bushfind = new bushfind();
    bushfind.ezbushfind();
}
}