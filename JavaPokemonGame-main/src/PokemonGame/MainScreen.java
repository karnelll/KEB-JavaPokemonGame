import java.util.Scanner;

public class MainScreen {

  // 공통적으로 사용할 변수들 선언 - 값을 넣어놓으니 메인 부를때마다 초기화됨 전역설정
  public static PokemonStatus[] myPokemon = new PokemonStatus[101];
  public static PokemonStatus[] battlePokemon = new PokemonStatus[3];

  public static int monsterBall = 5;
  public static int candy = 5;
  public static int trainer_level = 1;
  public static int attackkit = 1;
  public static int defensekit = 1;
  public static int healingkit = 3;
  public static int revivekit = 0;
  public static int myPokemonNumber = 0;
  public static int mybattleNumber = 0;

  public static void main(String[] args) {
    BattlePokemon battlePokemon = new BattlePokemon();
    Collection collection = new Collection();
    Trainer trainer = new Trainer();
    PokemonInfo pokemonInfo = new PokemonInfo();

    Scanner scanner = new Scanner(System.in);

    System.out.println("===============");
    System.out.println("<POKEMON GAME>\n");
    System.out.println("  (\\__/)");
    System.out.println("  (o^.^)");
    System.out.println("z(_(\")(\")");
    System.out.println("===============");
    System.out.println("1. 대전 모드");
    System.out.println("2. 수집 모드");
    System.out.println("3. 포켓몬 정보");
    System.out.println("4. 트레이너 정보");
    System.out.println("5. 저장/불러오기");
    System.out.println("6. 종료");
    System.out.print("숫자를 입력해주세요>> ");
    int choice = scanner.nextInt();

    if (choice == 1) {
      battlePokemon.battleMode();
    }

    if (choice == 2) {
      collection.collection();
    }

    if (choice == 3) {
      pokemonInfo.pokemonInfo();
    }

    if (choice == 4) {
      trainer.trainer();
    }

    if (choice == 5) {}

    if (choice == 6) {
      System.out.println("\n게임이 종료됩니다...");
      scanner.close();
      System.exit(0);
    }
  }
}
