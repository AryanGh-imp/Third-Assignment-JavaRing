# Java Ring: A Turn-Based RPG

## Introduction

**Java Ring** is a turn-based role-playing game (RPG) implemented in Java. Players choose a character, equip them with weapons and armor, and battle against enemies in different locations. The objective is to defeat all enemies and clear all locations to win the game.

## Game Mechanics

### Character Selection

Players can choose from three different character classes, each with unique attributes:

1. **Knight** - High HP, strong physical attacks.
2. **Wizard** - Uses magic spells and can heal.
3. **Assassin** - Specializes in stealth and critical hits.

### Weapon Selection

Each character can equip one of the following weapons:

1. **Royal Greatsword** (High damage, no mana cost)
2. **Golden Order Seal** (Moderate damage, consumes mana)
3. **Rivers of Blood** (Balanced damage and mana usage)

### Armor Selection

Players must also choose an armor set to enhance their defense:

1. **Knight Armor** - High durability and defense.
2. **Wizard Armor** - Lower defense but high durability.
3. **Assassin Armor** - Balanced defense and durability.

## Gameplay Loop

The game follows a structured loop:

1. **Character and Equipment Selection** - Players choose their character, weapon, and armor.
2. **Exploration** - Players explore different locations, encountering enemies.
3. **Combat** - Battles are turn-based, allowing players to attack, defend, use special abilities, flee, or use items.
4. **Victory or Defeat** - If all enemies are defeated, the game is won; if the player dies, the game is over.

## Combat System

During battles, players can:

- **Attack** - Perform a basic attack using their equipped weapon.
- **Defend** - Reduce incoming damage.
- **Use Special Abilities**:
    - Knight: Strong Kick (high damage, cooldown required)
    - Wizard: Magic Strike (costs mana)
    - Assassin: Stealth (invisibility for evasion and critical hits)
- **Use Items** - Restore health or mana using consumables.
- **Flee** - Attempt to escape from battle (based on chance, higher chance for Assassins).

Enemies have their own unique abilities:

- **Goblin** - Basic attacks.
- **Skeleton** - Can heal itself when low on health.
- **Dragon** - Uses fiery breath to damage all opponents.

## Winning and Losing Conditions

- **Victory**: All locations must be cleared of enemies.
- **Defeat**: If the player's HP reaches zero, the game ends.

## Inventory System

Players can collect and use consumable items such as:

- **Health Flask** - Restores 30% HP.
- **Mana Flask** - Restores 30% MP.
- **Small Flask** - Restores 15% HP (found randomly after battles).

## Have fun !