package org.project.location;

import org.project.entity.enemies.Enemy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Location {
    private final String name;
    private final List<Enemy> enemies;

    public Location(String name) {
        this.name = name;
        this.enemies = new ArrayList<>();
    }

    public void addEnemy(Enemy enemy) {
        this.enemies.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        this.enemies.remove(enemy);
    }

    public String getName() {
        return name;
    }

    public List<Enemy> getEnemies() {
        return Collections.unmodifiableList(enemies);
    }

    public void reset() {
        enemies.forEach(Enemy::restoreHealth);
    }

    public boolean isCleared() {
        return enemies.stream().noneMatch(Enemy::isAlive);
    }
}