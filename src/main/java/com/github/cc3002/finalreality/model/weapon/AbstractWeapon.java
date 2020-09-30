package com.github.cc3002.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class AbstractWeapon implements IWeapon {

  protected final String name;
  protected final int weight;

  /**
   * Class that holds the properties for a weapon with a name, a base damage and speed.
   *
   */
  public AbstractWeapon(final String name, final int weight) {
    this.name = name;
    this.weight = weight;
  }

  public String getName() {
    return this.name;
  }

  public int getWeight() {
    return this.weight;
  }

  public abstract String getType();


}
