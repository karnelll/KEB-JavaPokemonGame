import java.util.Scanner;

public class PokemonItem {

	static void attackBoosterUse(PokemonStatus pokemon) {
            pokemon.setAttack(pokemon.getAttack() + 10);
            System.out.println(pokemon.getName() + "의 공격력이 10 증가했습니다!");
        }

    
    static void defenseBoosterUse(PokemonStatus pokemon) {
            pokemon.setDefense(pokemon.getDefense() + 10);
            System.out.println(pokemon.getName() + "의 방어력이 10 증가했습니다!");
        }
    
    
    static void recoveryItemUse(PokemonStatus pokemon) {
            pokemon.heal(30);
            System.out.println(pokemon.getName() + "의 체력이 30 회복되었습니다!");
        }
    
    
	static void reviveItemUse(PokemonStatus pokemon) {
            pokemon.Revived(true);
            System.out.println(pokemon.getName() + "이(가) 부활되었습니다!");
        }
    
    

    public void useItem(PokemonStatus pokemons) {
       
        Scanner scanner = new Scanner(System.in);

    while (true) {
    	System.out.println("포켓몬을 선택하세요.");
        for (int i = 0; i < MainScreen.battlePokemon.length; i++) {
            System.out.println("[" + (i) + "] " + MainScreen.battlePokemon[i].getName() + " (" + MainScreen.battlePokemon[i].getType() + ")");
        }
        System.out.print("선택 : ");
        int choice = scanner.nextInt();
        PokemonStatus pokemon = MainScreen.battlePokemon[choice];


	    System.out.println("어떤 아이템을 사용하시겠습니까?");
	    System.out.println("[1] 공격 부스터");
	    System.out.println("[2] 방어 부스터");
	    System.out.println("[3] 회복 아이템");
	    System.out.println("[4] 부활 아이템");
	    System.out.println("[5] 종료");
	
	    System.out.print("선택: ");
	    int action = scanner.nextInt();
	
	    switch (action) {
	        case 1:
				if(MainScreen.attackkit>0){
	            attackBoosterUse(pokemon);
				MainScreen.attackkit--;
	            return;
				}else System.out.println("아이템이 없습니다!");
				
	        case 2:
				if(MainScreen.defensekit>0){
			    defenseBoosterUse(pokemon);
				MainScreen.defensekit--;
	            return;
				}else System.out.println("아이템이 없습니다!");
	        case 3:
				if(MainScreen.healingkit>0){
	            recoveryItemUse(pokemon);
				MainScreen.healingkit--;
	            return;
				}else System.out.println("아이템이 없습니다!");
	        case 4:
				if(MainScreen.revivekit>0){
	            reviveItemUse(pokemon);
	            return;
				}else System.out.println("아이템이 없습니다!");
	        case 5:
	            System.out.println("프로그램을 종료합니다.");
	            return;
	        default:
	            System.out.println("잘못된 입력입니다.");
	            break;
	        }
	            System.out.println();
	        }
	    }
	}
	
