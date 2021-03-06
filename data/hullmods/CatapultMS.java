/*
 * Author: Laroustine
 * Project: IBO Faction
 * Version: 1.3.0a
 * Game Version: 0.95.1a-RC6
 * File Created: 19/03/2022
 */

package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class CatapultMS extends BaseHullMod {

  public static final float TIME_BONUS = 2.0f;

  public void applyEffectsBeforeShipCreation(
    HullSize hullSize,
    MutableShipStatsAPI stats,
    String id
  ) {}

  public void applyEffectsToFighterSpawnedByShip(
    ShipAPI fighter,
    ShipAPI ship,
    String id
  ) {
    fighter.setTimeDeployed(fighter.getFullTimeDeployed() * TIME_BONUS);
    fighter.setFighterTimeBeforeRefit(
      fighter.getFighterTimeBeforeRefit() * TIME_BONUS
    );
  }

  public String getDescriptionParam(int index, HullSize hullSize) {
    if (index == 0) return "" + (int) TIME_BONUS + "";
    return null;
  }
}
