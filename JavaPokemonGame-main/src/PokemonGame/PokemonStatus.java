
public class PokemonStatus {
    private String name;
    private String type;
    private int level;
    private int maxHP;
    private int currentHP;
    private int attack;
    private int defense;
    private String introduce;

    public PokemonStatus(String name, String type, int level, int attack, int defense, int maxHP) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
    }

    public void setPokemonStatus(String name, String type, int level, int attack, int defense, int maxHP){
    
        this.name = name;
        this.type = type;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.maxHP = maxHP;
        this.currentHP = maxHP;

    }

    public void attack(PokemonStatus opponent) {
        int damage = (int) (this.attack * ((double) this.level / opponent.getDefense()));
        opponent.takeDamage(damage);
        System.out.println(this.name + "이(가) " + opponent.getName() + "에게 " + damage + "의 데미지를 입혔습니다.");
    }

    private void takeDamage(int damage) {
        this.currentHP -= damage;
        if (this.currentHP <= 0) {
            this.currentHP = 0;
            System.out.println(this.name + "이(가) 쓰러졌습니다.");
        }
    }

    public void heal(int amount) {
        this.currentHP += amount;
        if (this.currentHP > this.maxHP) {
            this.currentHP = this.maxHP;
        }
    }

    public void evolve() {
        //파이리
        if(this.name.equals("파이리")&&this.level>=15)
        {
            System.out.println("어..? 파이리의 상태가..?");
            setPokemonStatus("리자드", "불", this.level, this.attack+5, this.defense+5, this.maxHP+10);
            System.out.println("축하합니다! 파이리는 리자드로 진화했습니다!");
        }

        if(this.name.equals("리자드")&&this.level>=30)
        {
            System.out.println("어..? 리자드의 상태가..?");
            setPokemonStatus("리자몽", "불", this.level, this.attack+8, this.defense+8, this.maxHP+15);
            System.out.println("축하합니다! 리자드는 리자몽으로 진화했습니다!");
        }
        //꼬부기
        if(this.name.equals("꼬부기")&&this.level>=15)
        {
            System.out.println("어..? 꼬부기의 상태가..?");
            setPokemonStatus("어니부기", "물", this.level, this.attack+5, this.defense+5, this.maxHP+10);
            System.out.println("축하합니다! 꼬부기는 어니부기로 진화했습니다!");
        }

        if(this.name.equals("어니부기")&&this.level>=30)
        {
            System.out.println("어..? 어니부기의 상태가..?");
            setPokemonStatus("어니부기", "물", this.level, this.attack+8, this.defense+8, this.maxHP+15);
            System.out.println("축하합니다! 어니부기는 거북왕으로 진화했습니다!");
        }
        //이상해씨
        if(this.name.equals("이상해씨")&&this.level>=15)
        {
            System.out.println("어..? 이상해씨의 상태가..?");
            setPokemonStatus("이상해풀", "풀", this.level, this.attack+5, this.defense+5, this.maxHP+10);
            System.out.println("축하합니다! 이생해씨는 이상해풀로 진화했습니다!");
        }
        
        if(this.name.equals("이상해풀")&&this.level>=30)
        {
            System.out.println("어..? 이상해풀의 상태가..?");
            setPokemonStatus("이상해꽃", "풀", this.level, this.attack+8, this.defense+8, this.maxHP+15);
            System.out.println("축하합니다! 이상해풀은 이상해꽃으로 진화했습니다!");
        }
        //꼬렛
        if(this.name.equals("꼬렛")&&this.level>=10)
        {
            System.out.println("어..? 꼬렛의 상태가..?");
            setPokemonStatus("레트라", "노말", this.level, this.attack+5, this.defense+5, this.maxHP+10);
            System.out.println("축하합니다! 꼬렛은 레트라로 진화했습니다!");
        }
        //피카츄
        if(this.name.equals("피카츄")&&this.level>=10)
        {
            System.out.println("어..? 피카츄의 상태가..?");
            setPokemonStatus("라이츄", "전기", this.level, this.attack+5, this.defense+5, this.maxHP+10);
            System.out.println("축하합니다! 피카츄는 라이츄로 진화했습니다!");
        }
    }

    public void levelUp() {
        this.level++;
        this.attack += 5;
        this.defense += 5;
        this.maxHP += 10;
        this.currentHP = this.maxHP;
        System.out.println(this.name + "이(가) 레벨업 했습니다!");
        evolve();//레벨업 할때마다 진화 확인  
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getLevel() {
        return this.level;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getMaxHP() {
        return this.maxHP;
    }

    public int getCurrentHP() {
        return this.currentHP;
    }

    public void setAttack(int attack){
        this.attack=attack;
    }
    public void setDefense(int defense){
        this.defense=defense;
    }
    public void Revived(Boolean revive){
        if(revive==true)this.currentHP=this.maxHP;
    }
}
   