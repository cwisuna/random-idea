import java.util.Random;
import java.util.Scanner;

public class Game {
    private int maxEnemyHealth = 100;
    private int enemyAttackDamage  = 25;
    private int playerHealth = 100;
    private int attackDamage = 40;
    private int medKits = 2;
    private int medKitHealAmount = 30;
    private boolean running = true;
    private String[] enemies = {"Demon", "Vampire", "Werewolf", "Angel"};

    Scanner input = new Scanner(System.in);
    Random random = new Random();
    public void run(){

        System.out.println(" THIS IS SUPERNATURAL");

        GAME:
        while(running){
            System.out.println("---------------------------------");

            int enemyHealth = random.nextInt(maxEnemyHealth);
            String enemy = enemies[random.nextInt(enemies.length)];
            System.out.println(" A " + enemy + " has appeared");
            System.out.println();

            while(enemyHealth > 0){
                System.out.println(" Your health: " + playerHealth);
                System.out.println(" The " + enemy + "'s health: " + enemyHealth);
                System.out.println();
                System.out.println(" 1. Attack");
                System.out.println(" 2. Use med kit");
                System.out.println(" 3. Run away");

                String choice = input.nextLine();

                if(choice.equals("1")){
                    int damageDealt = random.nextInt(attackDamage);
                    int damageTaken = random.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    playerHealth -= damageTaken;

                    System.out.println("You have hurt " + enemy + " for " + damageDealt + " damage ");
                    System.out.println("The enemy has hurt you " + damageTaken + " times ");

                    if(playerHealth < 1) {
                        System.out.println("You have died... ");
                    }
                }else if (choice.equals("2")){
                    if(medKits > 0){
                        playerHealth += medKitHealAmount;
                        medKits--;
                        System.out.println("That med kit came in handy!! ");
                        System.out.println("You just healed yourself for " + medKitHealAmount);
                        System.out.println("You have this many heals left " + medKits);
                    }
                }else if(choice.equals("3")){
                    System.out.println("You ran away from the " + enemy);
                    continue GAME;
                }
                else{
                    System.out.println("Not an option!! ");
                }

            }
        }

    }

}
