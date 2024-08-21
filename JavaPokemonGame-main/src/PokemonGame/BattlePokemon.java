import java.util.Scanner;
import java.util.Random;

public class BattlePokemon {
	PokemonItem Item = new PokemonItem();
	MainScreen mainScreen = new MainScreen();
	Pokemon_arr pokemon_arr = new Pokemon_arr();
	int trainer_exp=0;
	
	public static void giveReward(int trainer_exp, int poketmon_exp, int candy) {
		System.out.println("전투에서 승리했습니다!!");
		System.out.println("보상으로 캔디 " + candy + "를 얻었습니다!!");
		
	}

	public void iceSkill() {
		System.out.println("프리져가 얼음뭉치를 사용합니다!");
	}
		
	public void thunderSkill() {
		System.out.println("썬더가 전자포를 사용합니다!");	
	}
		
	public void fireSkill() {
		System.out.println("파이어가 불꽃세례를 사용합니다!");	
	}

	public void battleMode() {
		if(MainScreen.mybattleNumber != 3) {
			System.out.println("전투 포켓몬이 부족합니다!!");
			MainScreen.main(null);
		}
		Scanner s = new Scanner(System.in);
		Random rand = new Random();
		
		int ran_choice = rand.nextInt(10);
		
		PokemonStatus[] p1Monsters = new PokemonStatus[3];
		
		for(int i=0;i<3;i++) {
			p1Monsters[i] = MainScreen.battlePokemon[i];
		}
		
		int[] myHP = new int[3];
		int[] myAttack = new int[3];
		int[] myDefense = new int[3];
		String[] myName = new String[3];
		String[] myType = new String[3];
		for(int i=0;i<3;i++) {
			myHP[i] = p1Monsters[i].getCurrentHP();
			myDefense[i] = p1Monsters[i].getDefense();
			myName[i] = p1Monsters[i].getName();
			myType[i] = p1Monsters[i].getType();
			myAttack[i] = p1Monsters[i].getAttack();
		}
		
		// AI 선택
		PokemonStatus aiMonsters = pokemon_arr.pokemons[ran_choice];
		int level = MainScreen.trainer_level;
		int ai_hp = aiMonsters.getCurrentHP();
		int ai_attack = aiMonsters.getAttack();
		int ai_defense = aiMonsters.getDefense();
		String ai_name = aiMonsters.getName();
		String ai_type = aiMonsters.getType();
		
		System.out.println("<대전모드 시작>");
		
		int turn = 0;
		int GameOvernum = 0;
		// 플레이어의 선택
        

		System.out.println("===============");
		System.out.println("<전투 포켓몬 가방>");
		
        for(int i=0;i<3;i++) {
        	System.out.println(i + "번 :" + myName[i]);
        }
        System.out.println("전투 포켓몬을 선택하세요(0~2)>> ");
        int playerChoice = s.nextInt(3);
        PokemonStatus p1Pokemon = p1Monsters[playerChoice];

		
		while ((GameOvernum==0) && !((myHP[0]<=0) && (myHP[1]<=0) && (myHP[2]<=0)) && (!(ai_hp<=0))) 
		{
			turn++;
            System.out.println("=======================");
			System.out.println("상대는 "+aiMonsters.getName()+"꺼냈다!!");
            System.out.println(turn + "턴 "  + "시작");    
            
            double result = TypeCheck.check(p1Pokemon, aiMonsters);
            int ai_damage = (int)(result*(5*level * ai_attack/myDefense[playerChoice])) + 1;	//ai너무 약함
            int my_damage = (int)(result*(5*myAttack[playerChoice]/ai_defense)) + 1;
            
            // 플레이어 행동선택
            System.out.println("1. 공격 / 2. 교체 / 3. 아이템 사용 / 4. 포기 ");
            int choose = s.nextInt();
            
            if(choose==1) {
				System.out.println("플레이어차례");
            	if(myName[playerChoice] == "프리져") {
            		if(rand.nextInt(2) == 0) { // 50% 확률로 스킬 발동
            			iceSkill();
            			System.out.println(myName[playerChoice] + " --" + (my_damage+2) + "--> " + ai_name );
            			ai_hp -= (my_damage+5);
            		}
            		else {
            			System.out.println(myName[playerChoice] + " --" + my_damage + "--> " + ai_name );
            			ai_hp -= my_damage;
            		}
            	}
            	else if(myName[playerChoice] == "썬더") {
            		if(rand.nextInt(4) == 0) { // 25% 확률로 스킬 발동
            			thunderSkill();
            			System.out.println(myName[playerChoice] + " --" + my_damage*2 + "--> " + ai_name );
            			ai_hp -= my_damage*2;
            		}
            		else {
            			System.out.println(myName[playerChoice] + " --" + my_damage + "--> " + ai_name );
            			ai_hp -= my_damage;
            		}
            	}
            	else if(myName[playerChoice] == "파이어") {
            		if(rand.nextInt(3) == 0) { // 30% 확률로 스킬 발동
            			fireSkill();
            			System.out.println(myName[playerChoice] + " --" + (my_damage+7) + "--> " + ai_name );
            			ai_hp -= (my_damage+7);
            		}
            		else {
            			System.out.println(myName[playerChoice] + " --" + my_damage + "--> " + ai_name );
            			ai_hp -= my_damage;
            		}
            	}
            	else {
            		System.out.println(myName[playerChoice] + " --" + my_damage + "--> " + ai_name );
            		ai_hp -= my_damage;
            	}
            	System.out.println(ai_name + "의 체력은 " + ai_hp + "이 남았습니다.");
            	System.out.println("\nai차례");
            	System.out.println(ai_name+ " --" + ai_damage + "--> " + myName[playerChoice] );
            	myHP[playerChoice] -= ai_damage;
				System.out.println(myName[playerChoice] + "의 체력은 " + myHP[playerChoice] + "이 남았습니다.");

				if(myHP[playerChoice]<=0){
				int backUpNumber = playerChoice;
            	System.out.println("===============");
        		System.out.println("<전투 포켓몬 가방>");
        		
                for(int i=0;i<3;i++) {
                	System.out.println(i + "번 :" + myName[i]);
                }
            	System.out.println("교체할 포켓몬을 선택하세요(0~2)>> ");
				while(true){
            	playerChoice = s.nextInt();
            	if(myHP[playerChoice]<=0) {
            		System.out.println("\n대상 포켓몬의 체력이 없어 교체가 불가합니다. 상대에게 턴을 넘깁니다.");
            		myName[playerChoice] = myName[backUpNumber];
            		myHP[playerChoice] = myHP[backUpNumber];System.out.println("\nai차례");
                	System.out.println(ai_name+ " --" + ai_damage + "--> " + myName[playerChoice] );
                	myHP[playerChoice] -= ai_damage;
                	System.out.println(myName[playerChoice] + "의 체력은 " + myHP[playerChoice] + "이 남았습니다.");
            	}
            	else {
            	System.out.println(myName[backUpNumber] + "을(를) " + myName[playerChoice] + "로 변경합니다.");
                System.out.println("\nai차례");
            	System.out.println(ai_name+ " --" + ai_damage + "--> " + myName[playerChoice] );
            	myHP[playerChoice] -= ai_damage;
            	System.out.println(myName[playerChoice] + "의 체력은 " + myHP[playerChoice] + "이 남았습니다.");
				break;
            	}
			}
			
				
			}
            else if (choose==2) {
            	int backUpNumber = playerChoice;
            	System.out.println("===============");
        		System.out.println("<전투 포켓몬 가방>");
        		
                for(int i=0;i<3;i++) {
                	System.out.println(i + "번 :" + myName[i]);
                }
            	System.out.println("교체할 포켓몬을 선택하세요(0~2)>> ");
            	playerChoice = s.nextInt();
            	if(myHP[playerChoice]<=0) {
            		System.out.println("대상 포켓몬의 체력이 없어 교체가 불가합니다. 상대에게 턴을 넘깁니다.");
            		myName[playerChoice] = myName[backUpNumber];
            		myHP[playerChoice] = myHP[backUpNumber];System.out.println("\nai차례");
                	System.out.println(ai_name+ " --" + ai_damage + "--> " + myName[playerChoice] );
                	myHP[playerChoice] -= ai_damage;
                	System.out.println(myName[playerChoice] + "의 체력은 " + myHP[playerChoice] + "이 남았습니다.");
            	}
            	else {
            	System.out.println(myName[backUpNumber] + "을(를) " + myName[playerChoice] + "로 변경합니다.");
                System.out.println("\nai차례");
            	System.out.println(ai_name+ " --" + ai_damage + "--> " + myName[playerChoice] );
            	myHP[playerChoice] -= ai_damage;
            	System.out.println(myName[playerChoice] + "의 체력은 " + myHP[playerChoice] + "이 남았습니다.");
            	}
            }
            
            else if(choose==3) {
            	Item.useItem(p1Pokemon);
            	System.out.println("\nai차례");
            	System.out.println(ai_name+ " --" + ai_damage + "--> " + myName[playerChoice] );
            	myHP[playerChoice] -= ai_damage;
            	System.out.println(myName[playerChoice] + "의 체력은 " + myHP[playerChoice] + "이 남았습니다.");
            }
            
            else if(choose==4) {
            	System.out.println("게임을 포기합니다...");
            	GameOvernum=1;
            }    
		}
            // 승리 or 패배 
		if(ai_hp <= 0) {
        	trainer_exp += 100;
        	MainScreen.candy += 1;
        	System.out.println("===============");
        	System.out.println("전투에서 승리하였습니다.");
        	System.out.println("보상으로 사탕 1개와 경험치 100이 증가하였습니다.");
        	if((MainScreen.trainer_level*100)==trainer_exp) {
        		System.out.println("트레이너의 레벨이 증가하였습니다.");
        		System.out.println(MainScreen.trainer_level + " -> " + (MainScreen.trainer_level+1));
        		MainScreen.trainer_level++;
        		MainScreen.main(null);
        	}
        	else {
        		MainScreen.main(null);
        	}
        }
		else if(((myHP[0]<=0) && (myHP[1]<=0) && (myHP[2]<=0)) || GameOvernum==1) { 
        	System.out.println("전투에서 패배했습니다...");
			MainScreen.main(null);
		}
	}
	}
}