package org.project;

import org.project.entity.players.*;
import org.project.entity.enemies.*;
import org.project.object.armors.*;
import org.project.object.weapons.*;
import org.project.object.consumables.*;
import org.project.location.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static Player player;
    private static List<Location> locations;
    private static List<Consumable> inventory;

    public static void main(String[] args) {
        initializeGame();
        gameLoop();
        endGame();
    }

    private static void initializeGame() {
        System.out.println("WELCOME TO THE" + ANSI.YELLOW + " JAVA RING" + ANSI.RESET);
        createPlayer();
        createLocations();
        initializeInventory();
    }

    private static void createPlayer() {
        // Character selection
        System.out.println("\nChoose your character:");
        System.out.println("1. " + ANSI.CYAN + "Knight " + ANSI.RESET + "(High HP, Strong Kick)");
        System.out.println("2. " + ANSI.YELLOW + "Wizard " + ANSI.RESET + "(Magic Spells, Healing)");
        System.out.println("3. " + ANSI.RED + "Assassin " + ANSI.RESET + "(Stealth, Critical Hits)");

        int characterChoice = getUserChoice(3);

        // Weapon selection
        System.out.println("\nChoose your weapon:");
        System.out.println("1. " + ANSI.CYAN + "Royal Greatsword" + ANSI.RESET + " (Damage: 20, Mana Cost: 0)");
        System.out.println("2. " + ANSI.YELLOW + "Golden Order Seal" + ANSI.RESET + " (Damage: 10, Mana Cost: 5)");
        System.out.println("3. " + ANSI.RED + "Rivers of Blood" + ANSI.RESET + " (Damage: 15, Mana Cost: 3)");

        int weaponChoice = getUserChoice(3);
        Weapon chosenWeapon = createWeapon(weaponChoice);

        // Armor selection
        System.out.println("\nChoose your armor:");
        System.out.println("1. " + ANSI.CYAN + "Knight Armor " + ANSI.RESET + "(Defense: 15, Durability: 50)");
        System.out.println("2. " + ANSI.YELLOW + "Wizard Armor " + ANSI.RESET + "(Defense: 5, Durability: 100)");
        System.out.println("3. " + ANSI.RED + "Assassin Armor " + ANSI.RESET + "(Defense: 15, Durability: 75)");

        int armorChoice = getUserChoice(3);
        Armor chosenArmor = createArmor(armorChoice);

        // Create player
        player = switch (characterChoice) {
            case 1 -> new Knight("Knight", 120, 40, chosenWeapon, chosenArmor);
            case 2 -> new Wizard("Wizard", 80, 80, chosenWeapon, chosenArmor);
            case 3 -> new Assassin("Assassin", 100, 50, chosenWeapon, chosenArmor);
            default -> throw new IllegalStateException("INVALID CHARACTER CHOICE");
        };

        System.out.println("\n" + ANSI.GREEN + player.getName() + " created successfully!" + ANSI.RESET);
        displayPlayerStats();
    }

    private static Weapon createWeapon(int choice) {
        return switch (choice) {
            case 1 -> new Sword("Royal Great sword", 20, 0);
            case 2 -> new Sword("Golden Order Seal", 10, 5);
            case 3 -> new Sword("Rivers of Blood", 15, 3);
            default -> throw new IllegalStateException("Invalid weapon choice");
        };
    }

    private static Armor createArmor(int choice) {
        return switch (choice) {
            case 1 -> new KnightArmor();
            case 2 -> new WizardArmor();
            case 3 -> new AssassinArmor();
            default -> throw new IllegalStateException("INVALID ARMOR CHOICE");
        };
    }

    private static void createLocations() {
        // Create enemies
        Enemy goblin = new Goblin("Goblin", 50, 20, new Sword("Rusty Sword", 10, 0));
        Enemy skeleton = new Skeleton("Skeleton", 70, 30, new Sword("Bone Blade", 15, 0));
        Enemy dragon = new Dragon("Dragon", 120, 50, new Sword("Dragon Slayer", 25, 0));

        locations = new ArrayList<>();

        Location forest = new Location("Forest");
        forest.addEnemy(goblin);

        Location mountain = new Location("Mountain");
        mountain.addEnemy(skeleton);

        Location cave = new Location("Cave");
        cave.addEnemy(dragon);

        // Connecting locations
        forest.connectTo(mountain);
        mountain.connectTo(cave);

        locations.add(forest);
        locations.add(mountain);
        locations.add(cave);
    }

    private static void initializeInventory() {
        inventory = new ArrayList<>();
        inventory.add(new Flask("Health Flask", "Restores 30% HP", 30, 2));
        inventory.add(new Flask("Mana Flask", "Restores 30% MP", 0, 2));
    }

    private static void gameLoop() {
        while (player.isAlive() && !allLocationsCleared()) {
            displayGameStatus();
            Location currentLocation = chooseLocation();
            exploreLocation(currentLocation);
        }
    }

    private static void displayGameStatus() {
        System.out.println("\n=== GAME STATUS ===");
        displayPlayerStats();
        System.out.println("\nAvailable Locations:");
        for (int i = 0; i < locations.size(); i++) {
            String status = locations.get(i).isCleared() ? ANSI.GREEN + " (Cleared)" + ANSI.RESET : ANSI.RED + " (Enemies remain)" + ANSI.RESET;
            System.out.println((i + 1) + ". " + locations.get(i).getName() + status);
        }
    }

    private static void displayPlayerStats() {
        System.out.println("\n" + ANSI.BLUE + "=== PLAYER STATS ===" + ANSI.RESET);
        System.out.println("Name: " + player.getName());
        System.out.println("HP: " + player.getCurrentHP() + "/" + player.getMaxHP());
        System.out.println("MP: " + player.getCurrentMP() + "/" + player.getMaxMP());
        System.out.println("Weapon: " + player.getWeapon().getName() + " (Damage: " + player.getWeapon().getDamage() + ")");
        System.out.println("Armor: " + player.getArmor().getName() + " (Defense: " + player.getArmor().getDefense() + ")");

        if (player instanceof Knight knight) {
            System.out.println("Strong Kick: " + (knight.getRoundsSinceLastKick() >= knight.getKickCooldown() ?
                    ANSI.GREEN + "Ready" + ANSI.RESET :
                    ANSI.RED + "Cooldown: " + (knight.getKickCooldown() - knight.getRoundsSinceLastKick()) + " turns" + ANSI.RESET));
        } else if (player instanceof Wizard) {
            System.out.println("Magic Strike: " + (player.getCurrentMP() >= 20 ?
                    ANSI.GREEN + "Ready (Cost: 20 MP)" + ANSI.RESET :
                    ANSI.RED + "Not enough MP" + ANSI.RESET));
        } else if (player instanceof Assassin assassin) {
            System.out.println("Stealth: " + (assassin.isInvisible() ?
                    ANSI.GREEN + "Active" + ANSI.RESET :
                    ANSI.YELLOW + "Ready" + ANSI.RESET));
        }
    }

    private static Location chooseLocation() {
        System.out.print("\nChoose a location to explore: ");
        int choice = getUserChoice(locations.size());
        return locations.get(choice - 1);
    }

    private static void exploreLocation(Location location) {
        System.out.println("\nYou enter the " + location.getName() + "...");

        if (location.isCleared()) {
            System.out.println(ANSI.GREEN + "This area is clear of enemies." + ANSI.RESET);
            return;
        }

        Enemy enemy = location.getEnemies().getFirst();
        System.out.println(ANSI.RED + "A wild " + enemy.getName() + " appears!" + ANSI.RESET);

        battleLoop(player, enemy);

        if (!enemy.isAlive()) {
            location.removeEnemy(enemy);
            System.out.println(ANSI.GREEN + "You defeated the " + enemy.getName() + "!" + ANSI.RESET);

            if (random.nextDouble() < 0.3) {
                Flask reward = new Flask("Small Flask", "Restores 15% HP", 15, 1);
                inventory.add(reward);
                System.out.println(ANSI.YELLOW + "You found a " + reward.getName() + "!" + ANSI.RESET);
            }
        }
    }

    private static void battleLoop(Player player, Enemy enemy) {
        boolean fled = false;

        while (player.isAlive() && enemy.isAlive() && !fled) {
            System.out.println("\n" + ANSI.BLUE + player.getName() + ANSI.RESET +
                    " HP: " + ANSI.RED + player.getCurrentHP() + ANSI.RESET + "/" + player.getMaxHP() +
                    " MP: " + ANSI.CYAN + player.getCurrentMP() + ANSI.RESET + "/" + player.getMaxMP() +
                    " | " + ANSI.YELLOW + enemy.getName() + ANSI.RESET +
                    " HP: " + ANSI.RED + enemy.getCurrentHP() + ANSI.RESET + "/" + enemy.getMaxHP());

            int action = chooseBattleAction();

            switch (action) {
                case 1 -> handleAttack(player, enemy);
                case 2 -> player.defend();
                case 3 -> handleSpecialAction(player, enemy);
                case 4 -> fled = handleFlee(player, enemy);
                case 5 -> useItem();
            }

            if (enemy.isAlive() && !fled) {
                enemyTurn(enemy, player);
            }

            if (player instanceof Knight) {
                ((Knight) player).endTurn();
            }
        }
    }

    private static int chooseBattleAction() {
        System.out.println("\nChoose an action:");
        System.out.println("1. Attack");
        System.out.println("2. Defend");
        System.out.println("3. Special Action");
        System.out.println("4. Try to Flee");
        System.out.println("5. Use Item");
        return getUserChoice(5);
    }

    private static void handleAttack(Player player, Enemy enemy) {
        player.attack(enemy);
    }

    private static void handleSpecialAction(Player player, Enemy enemy) {
        if (player instanceof Knight) {
            ((Knight) player).strongKick(enemy);
        } else if (player instanceof Wizard) {
            ((Wizard) player).magicStrike(enemy);
        } else if (player instanceof Assassin) {
            if (!((Assassin) player).isInvisible()) {
                ((Assassin) player).enterStealth();
            } else {
                player.attack(enemy);
            }
        }
    }

    private static boolean handleFlee(Player player, Enemy enemy) {
        int fleeChance = 60;
        if (player instanceof Assassin) fleeChance += 20;

        if (random.nextInt(100) < fleeChance) {
            System.out.println(ANSI.YELLOW + "You successfully fled from battle!" + ANSI.RESET);
            enemy.restoreHealth();
            return true;
        } else {
            System.out.println(ANSI.RED + "You failed to escape!" + ANSI.RESET);
            return false;
        }
    }

    private static void useItem() {
        if (inventory.isEmpty()) {
            System.out.println(ANSI.RED + "Your inventory is empty!" + ANSI.RESET);
            return;
        }

        System.out.println("\nInventory:");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i));
        }
        System.out.println((inventory.size() + 1) + ". Cancel");

        System.out.print("Choose an item to use: ");
        int choice = getUserChoice(inventory.size() + 1) - 1;

        if (choice == inventory.size()) {
            System.out.println(ANSI.YELLOW + "Item use cancelled." + ANSI.RESET);
            return;
        }

        try {
            Consumable item = inventory.get(choice);
            if (item.getQuantity() <= 0) {
                System.out.println(ANSI.RED + "This item is out of stock!" + ANSI.RESET);
                inventory.remove(choice);
                return;
            }

            item.use(player);
            if (item.getQuantity() <= 0) {
                inventory.remove(choice);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(ANSI.RED + "Invalid item selection!" + ANSI.RESET);
        }
    }

    private static void enemyTurn(Enemy enemy, Player player) {
        if (enemy instanceof Dragon && random.nextDouble() < 0.3) {
            ((Dragon) enemy).attackAll(List.of(player));
        } else if (enemy instanceof Skeleton && ((Skeleton) enemy).getCurrentHP() < enemy.getMaxHP() / 2 && random.nextDouble() < 0.4) {
            enemy.heal(10);
        } else {
            enemy.attack(player);
        }
    }

    private static boolean allLocationsCleared() {
        return locations.stream().allMatch(Location::isCleared);
    }

    private static void endGame() {
        if (allLocationsCleared()) {
            System.out.println(ANSI.GREEN + "\nCongratulations! You have defeated all enemies and won the game!" + ANSI.RESET);
        } else {
            System.out.println(ANSI.RED + "\nGame Over. You have been defeated." + ANSI.RESET);
        }
    }

    private static int getUserChoice(int maxOptions) {
        while (true) {
            try {
                System.out.print("Enter your choice (1-" + maxOptions + "): ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= 1 && choice <= maxOptions) {
                    return choice;
                }
                System.out.println(ANSI.RED + "PLEASE ENTER A NUMBER BETWEEN 1 AND " + maxOptions + ANSI.RESET);
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println(ANSI.RED + "INVALID INPUT. PLEASE ENTER A NUMBER." + ANSI.RESET);
            }
        }
    }

    private static class ANSI {
        public static final String RESET = "\u001B[0m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String CYAN = "\u001B[36m";
    }
}