import java.util.Scanner;

public class Pokemon {
    private String name;
    private String type;
    private int level;
    private int attack;
    private int defense;
    private int hp;

    public Pokemon(String name, String type, int level, int attack, int defense, int hp) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHP() {
        return hp;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Level: " + level);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
        System.out.println("HP: " + hp);
        System.out.println();
    }

    public static void main(String[] args) {
        Pokemon[] pokemons = new Pokemon[13];
        pokemons[0] = new Pokemon("피카츄", "전기", 1, 10, 5, 50);
        pokemons[1] = new Pokemon("파이리", "불", 1, 8, 6, 55);
        pokemons[2] = new Pokemon("꼬부기", "물", 1, 7, 7, 60);
        pokemons[3] = new Pokemon("이상해씨", "풀", 1, 6, 8, 65);
        pokemons[4] = new Pokemon("캐터피", "벌레", 1, 3, 3, 20);
        pokemons[5] = new Pokemon("야도란", "노말", 1, 5, 5, 40);
        pokemons[6] = new Pokemon("또가스", "독", 1, 4, 6, 35);
        pokemons[7] = new Pokemon("푸린", "페어리", 1, 3, 4, 45);
        pokemons[8] = new Pokemon("꼬렛", "노말", 1, 4, 5, 30);
        pokemons[9] = new Pokemon("딱구리", "바위", 1, 7, 8, 70);
        pokemons[10] = new Pokemon("프리져", "물", 1, 10, 8, 70);
        pokemons[11] = new Pokemon("썬더", "전기", 1, 10, 8, 70);
        pokemons[12] = new Pokemon("파이어", "불", 1, 10, 8, 70);

        Scanner scanner = new Scanner(System.in);
        System.out.println("포켓몬 번호를 입력하세요 (0부터 12까지):");
        int pokemonNumber = scanner.nextInt();

        if (pokemonNumber >= 0 && pokemonNumber < pokemons.length) {
            Pokemon selectedPokemon = pokemons[pokemonNumber];
            System.out.println("선택한 포켓몬 정보:");
            selectedPokemon.printInfo();
        } else {
            System.out.println("잘못된 포켓몬 번호입니다.");
        }
    }
}

