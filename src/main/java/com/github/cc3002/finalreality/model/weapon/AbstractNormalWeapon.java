package com.github.cc3002.finalreality.model.weapon;

/**
 * Class that holds the properties for a normal weapon with normal damage.
 *
 */
public abstract class AbstractNormalWeapon extends AbstractWeapon{
    private final int damage;

    public AbstractNormalWeapon(String name, int weight, int damage) {
        super(name, weight);
        this.damage = damage;
    }

    /**
     * Returns the damage of a normal Weapon
     */
    public int getDamage() {
        return this.damage;
    }

    @Override
    public abstract String getType();
}
