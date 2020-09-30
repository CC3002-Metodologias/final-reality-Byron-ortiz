package com.github.cc3002.finalreality.model.weapon;

public abstract class AbstractMagicWeapon extends AbstractWeapon {
    protected final int magicDamage;

    public AbstractMagicWeapon(String name, int weight, int magicDamage) {
        super(name, weight);
        this.magicDamage = magicDamage;
    }

    protected abstract int getMagicDamage();

    @Override
    public abstract String getType();
}
