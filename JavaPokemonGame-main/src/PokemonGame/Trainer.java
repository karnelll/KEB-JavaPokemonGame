
import java.util.Scanner;

public class Trainer {
	MainScreen mainScreen = new MainScreen();
	
	public void trainer() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("===============");
		System.out.println("현재 사탕 개수: " + MainScreen.candy);
		System.out.println("현재 트레이너 레벨: " + MainScreen.trainer_level);
		System.out.println("===============");
		System.out.println("<트레이너 정보>");
		System.out.println("1. 사탕 사용하기"); 
		System.out.println("2. 메인 화면으로 이동"); 
		System.out.print("\n숫자를 입력해주세요: "); 
		int choice = scanner.nextInt();
		
		
		if(choice == 1) { // 포켓몬 레벨 상승
			System.out.println("===============");
			
			if(MainScreen.myPokemonNumber == 0) 
			{
				System.out.println("가방에 포켓몬이 없습니다!!");
			}
			else 
			{
				for(int i=0;i<MainScreen.myPokemon.length;i++) {
					if(MainScreen.myPokemon[i] != null) {
						System.out.println(i + "번 : " + MainScreen.myPokemon[i].getName());
					}
					else {
						break;
					}
				}
				
				System.out.print("포켓몬을 선택해주세요>> ");
				int levelupPokemon = scanner.nextInt();
				int pokemonLevel = MainScreen.myPokemon[levelupPokemon].getLevel();
				MainScreen.myPokemon[levelupPokemon].levelUp();
				System.out.println(pokemonLevel + " >> " + (pokemonLevel + 1));
				MainScreen.candy -= 1;
				MainScreen.myPokemon[levelupPokemon].evolve();
			}
			trainer();
		}
		
		if(choice == 2) { // 메인화면으로 이동
			MainScreen.main(null);
		}
	}
}
