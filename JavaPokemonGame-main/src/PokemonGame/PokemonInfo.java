import java.util.*;

public class PokemonInfo {
    public void pokemonInfo(){
        
        MainScreen mainScreen = new MainScreen();

        while(true){ 
        System.out.println("\n===============");
        System.out.println("  포켓몬 정보  ");
        System.out.println("===============");
        System.out.println("1. 가진 전체 포켓몬 정보 보기");
        System.out.println("2. 전투 포켓몬 설정 및 포켓몬 버리기");
        System.out.println("3. 메인화면 돌아가기");


        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        
          
        if(choice == 1) {

            for(int i=0;i<MainScreen.myPokemon.length;i++) {
                if(MainScreen.myPokemon[i] != null) {
                    System.out.println(i + "번 : " + MainScreen.myPokemon[i].getName());
                }
                else {
                    break;
                }
            }
            
            System.out.print("\n포켓몬을 선택해주세요>> ");
            int choicePokemonInfo = scanner.nextInt();

            if(MainScreen.myPokemon[choicePokemonInfo]!=null){
                System.out.println("\n이름 : "+MainScreen.myPokemon[choicePokemonInfo].getName());
                System.out.println("레벨 : "+MainScreen.myPokemon[choicePokemonInfo].getLevel());
                System.out.println("타입 : "+MainScreen.myPokemon[choicePokemonInfo].getType());
                System.out.println("체력 : "+MainScreen.myPokemon[choicePokemonInfo].getMaxHP());
                System.out.println("공격력 : "+MainScreen.myPokemon[choicePokemonInfo].getAttack());
                System.out.println("방어력 : "+MainScreen.myPokemon[choicePokemonInfo].getDefense());
            }else continue;

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
					if(choice_pp == 3) continue;
				}
				
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
                    System.out.println("바이바이! "+MainScreen.myPokemon[deletePokemon].getName());
					strList.remove(MainScreen.myPokemon[deletePokemon]);
					MainScreen.myPokemon = strList.toArray(new PokemonStatus[0]);
					MainScreen.myPokemonNumber -= 1;
					
					
				}   	
			}
			if(choice_p == 3) {
				continue;
			    }
		    }
			else if(choice == 3) mainScreen.main(null);
        }
    }
}