package com.github.cc3002.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class AbstractWeapon implements IWeapon {

    private final String name;
    private final int weight;
    private final int damage;

    public AbstractWeapon(final String name, final int weight, int damage) {
        this.name = name;
        this.weight = weight;
        this.damage = damage;
    }

    public String getName() {
        return this.name;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        IWeapon that = (IWeapon) o;
        return getWeight() == that.getWeight() &&
                getDamage() == that.getDamage() &&
                getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getWeight(), getDamage());
    }
}
