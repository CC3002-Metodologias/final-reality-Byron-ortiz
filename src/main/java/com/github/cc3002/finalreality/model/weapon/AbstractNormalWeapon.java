package com.github.cc3002.finalreality.model.weapon;

public abstract class AbstractNormalWeapon extends AbstractWeapon{
    protected final int damage;

    public AbstractNormalWeapon(String name, int weight, int damage) {
        super(name, weight);
        this.damage = damage;
    }


    protected abstract int getDamage();

    @Override
    public abstract String getType();
}
