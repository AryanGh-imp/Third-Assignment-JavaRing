package org.project.location;

import org.project.entity.enemies.Enemy;

import java.util.ArrayList;

public class Location {
    private String name;

    private ArrayList<Location> locations;
    private ArrayList<Enemy> enemies;

    public Location(String name, ArrayList<Location> locations, ArrayList<Enemy> enemies) {
        this.name = name;
        this.locations = new ArrayList<>(locations);
        this.enemies = new ArrayList<>(enemies);
    }

    // دریافت نام موقعیت
    public String getName() {
        return name;
    }

    public ArrayList<Location> getLocations() {
        return new ArrayList<>(locations);
    }

    public ArrayList<Enemy> getEnemies() {
        return new ArrayList<>(enemies);
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public void resetLocation() {
        System.out.println("Resetting location: " + name);
        for (Enemy enemy : enemies) {
            enemy.restoreHealth();
        }
    }
}
