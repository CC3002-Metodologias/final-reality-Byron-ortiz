package com.github.cc3002.finalreality.model.weapon;

import java.util.Objects;

/**
 * Class that holds the properties for a magic weapon with magic damage.
 */
public abstract class AbstractMagicWeapon extends AbstractWeapon {
    private final int magicDamage;

    public AbstractMagicWeapon(String name, int weight, int damage, int magicDamage) {
        super(name, weight, damage);
        this.magicDamage = magicDamage;
    }

    /**
     * Returns the magicDamage of a MagicWeapon.
     */
    public int getMagicDamage() {
        return this.magicDamage;
    }

    @Override
    public boolean equals(Object o) {
        AbstractMagicWeapon that = (AbstractMagicWeapon) o;
        return getMagicDamage() == that.getMagicDamage() &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMagicDamage());
    }
}
