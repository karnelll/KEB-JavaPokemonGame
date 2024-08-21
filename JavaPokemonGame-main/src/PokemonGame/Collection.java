import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Collection {
	Pokemon_arr pokemon_arr = new Pokemon_arr();
	MainScreen mainScreen = new MainScreen();
	Scanner scanner = new Scanner(System.in);
	
	public void collection() {	
		
		System.out.println("\n===============");
		System.out.println("현재 몬스터볼 갯수: " + MainScreen.monsterBall);
		System.out.print("보유한 포켓몬 목록: ");
		
		if(MainScreen.myPokemonNumber == 0){
			System.out.println("포켓몬 가방이 비어있습니다!!");
		}
		else{
			for(int i=0;i<MainScreen.myPokemon.length;i++) {
				if(MainScreen.myPokemon[i] != null) {
					System.out.print("[" + MainScreen.myPokemon[i].getName() + "] ");
				}
				else {
					break;
				}
			}
		}
		
		
		System.out.println("\n===============");
		System.out.println("<수집 모드>");
		System.out.println("1. 수집하기");
		System.out.println("2. 나의 포켓몬 변경하기");
		System.out.println("3. 메인 화면으로 이동");
		System.out.print("\n숫자를 입력해주세요>> ");
		int choice = scanner.nextInt();
		
		if(choice == 1) { // 수집시스템

		Random random = new Random();
		int randomNumber = random.nextInt(100);
		int collectionPokemonNumber = random.nextInt(100);
		int collectionNomal = random.nextInt(10);
		int collectionLegend = random.nextInt(3) + 10;
		
		
			if(randomNumber>=65){
				
				if(MainScreen.monsterBall > 0) {
					for(int i = 0; i < 101; i++) { 
						if(MainScreen.myPokemon[i] == null){
							MainScreen.monsterBall -= 1;
							System.out.println("\n몬스터볼을 사용합니다!");
							if(collectionPokemonNumber >= 20) {// 일반 포켓몬 수집
								MainScreen.myPokemon[i] = pokemon_arr.pokemons[collectionNomal]; 
								System.out.println("[" + MainScreen.myPokemon[i].getName() + "]를 포획했습니다!!");
							}
							
							else if(collectionPokemonNumber >= 10) { // 10% 확률로 수집 실패
								System.out.println("야생의 포켓몬이 도망쳤습니다...");
							}
							
							else { // 10% 확률로 전설 포켓몬 수집
								MainScreen.myPokemon[i] = pokemon_arr.pokemons[collectionLegend];
								System.out.println("축하드립니다!!\n전설포켓몬 [" + MainScreen.myPokemon[i].getName() + "]를 포획했습니다!!");
							}
							MainScreen.myPokemonNumber += 1;
							break;
						}
					}
					collection();
				}
				else {
					System.out.println("\n몬스터볼이 없습니다!");
					collection();
				}
			}
			else if((randomNumber <65) && (randomNumber >= 5)){
				if((randomNumber <65)&&(randomNumber >= 35)){
					System.out.println("\n몬스터볼을 얻었다!");
					MainScreen.monsterBall++;
					collection();
				}
				else if((randomNumber <35)&&(randomNumber>=26)){
					System.out.println("\n상처약을 얻었다!");
					MainScreen.healingkit++;
					collection(); 
				}
				else if((randomNumber <26)&&(randomNumber>=17)){
					System.out.println("\n공격킷을 얻었다!");
					MainScreen.attackkit++;
					collection(); 
				}
				else if((randomNumber <17)&&(randomNumber>=8)){
					System.out.println("\n방어킷을 얻었다!");
					MainScreen.defensekit++;
					collection(); 
				}
				else if((randomNumber <8)&&(randomNumber>=5)){
					System.out.println("\n기력의조각을 얻었다!");
					MainScreen.revivekit++;
					collection(); 
				}
			}
			else{
				System.out.println("\n이상한 사탕을 얻었다!");
				MainScreen.candy++;
				collection();
			}
			
			
		}
		else if(choice == 2) { // 내 포켓몬 변경
			System.out.println("===============");
			System.out.println("1. 전투 포켓몬 변경");
			System.out.println("2. 포켓몬 버리기");
			System.out.println("3. 돌아가기");
			System.out.print("\n숫자를 입력해주세요>> ");
			int choice_p = scanner.nextInt();
			
			if(choice_p == 1) 
			{
				while(true) {
					System.out.println("\n<현재 대전 포켓몬 목록>");
					if(MainScreen.battlePokemon[0]==null){
						System.out.println("전투 포켓몬 가방이 비어있습니다!!");
					}
					else{
						for(int i=0;i<3;i++) {
							if(MainScreen.battlePokemon[i] != null) {
								System.out.print("[" + MainScreen.battlePokemon[i].getName() + "] ");
							}
							else {
								break;
							}
						}
					}
					System.out.println("\n===============");
					System.out.println("1. 전투 포켓몬 선택");
					System.out.println("2. 전투 포켓몬 가방 비우기");
					System.out.println("3. 돌아가기");
					System.out.print("\n숫자를 입력해주세요>> ");
					int choice_pp = scanner.nextInt();
					if(choice_pp == 1) 
					{
						System.out.println("\n===============");
						
						if(MainScreen.myPokemonNumber == 0) 
						{
							System.out.println("선택할 포켓몬이 없습니다!!");
							break;
						}
						
						else if(MainScreen.mybattleNumber == 3)
						{
							System.out.println("전투 포켓몬 가방에 자리가 없습니다!!");
							break;
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
							
							System.out.print("\n포켓몬을 선택해주세요>> ");
							int choiceBattlePokemon = scanner.nextInt();
							
							
							for(int i=0;i<3;i++) {
								if(MainScreen.battlePokemon[i] == MainScreen.myPokemon[choiceBattlePokemon]) {
									System.out.println("중복된 포켓몬입니다!!");
									break; // 중복 포켓몬 금지
								}
								
								
								if(MainScreen.battlePokemon[i] == null) {
									MainScreen.battlePokemon[i] = MainScreen.myPokemon[choiceBattlePokemon];
									System.out.println("등록 완료!!");
									MainScreen.mybattleNumber += 1;
									break;
								}
							}
							
						 }	
					}
					
					if(choice_pp == 2) 
					{
						for(int i = 0; i<3; i++) {
							MainScreen.battlePokemon[i] = null;
						}
						
						System.out.println("전투 포켓몬 가방을 비웠습니다!!");
						MainScreen.mybattleNumber = 0;
					}
					if(choice_pp == 3) collection();
				}
				collection();
				
			}
			if(choice_p == 2) 
			{
				System.out.println("===============");
				if(MainScreen.myPokemonNumber == 0) {
					System.out.println("삭제할 포켓몬이 없습니다!!");
				}
				else {
					for(int i=0;i<MainScreen.myPokemon.length;i++) {
						if(MainScreen.myPokemon[i] != null) {
							System.out.println(i + "번 : " + MainScreen.myPokemon[i].getName());
						}
						else {
							break;
						}
					}
					System.out.print("\n포켓몬을 선택해주세요>> ");
					int deletePokemon = scanner.nextInt();
					List<PokemonStatus> strList = new ArrayList<>(Arrays.asList(MainScreen.myPokemon));
					strList.remove(MainScreen.myPokemon[deletePokemon]);
					MainScreen.myPokemon = strList.toArray(new PokemonStatus[0]);
					MainScreen.myPokemonNumber -= 1;
					
					
				}
				collection();	
			}
			if(choice_p == 3) {
				collection();
			}
		}
		
		if(choice == 3) { // 메인화면으로 이동
			MainScreen.main(null);
		}
	}

}


