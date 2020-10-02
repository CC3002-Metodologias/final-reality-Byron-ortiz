package com.github.cc3002.finalreality.model.weapon;

/**
 * Class that holds the properties for a magic weapon with magic damage.
 *
 */
public abstract class AbstractMagicWeapon extends AbstractWeapon {
    private final int magicDamage;

    public AbstractMagicWeapon(String name, int weight, int magicDamage) {
        super(name, weight);
        this.magicDamage = magicDamage;
    }
    /**
     * Returns the magicDamage of a MagicWeapon
     */
    @Override
    public int getDamage() {
        return this.magicDamage;
    }

}
