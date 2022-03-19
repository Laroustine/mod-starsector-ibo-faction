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
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class AlayaVijnanaSystem extends BaseHullMod {

  public static final float MANEUVER_BONUS = 50.0f;

  public void applyEffectsBeforeShipCreation(
    HullSize hullSize,
    MutableShipStatsAPI stats,
    String id
  ) {
    stats.getAcceleration().modifyPercent(id, MANEUVER_BONUS * 2f);
    stats.getDeceleration().modifyPercent(id, MANEUVER_BONUS);
    stats.getTurnAcceleration().modifyPercent(id, MANEUVER_BONUS * 2f);
    stats.getMaxTurnRate().modifyPercent(id, MANEUVER_BONUS);
  }

  public String getDescriptionParam(int index, HullSize hullSize) {
    if (index == 0) return "" + (int) MANEUVER_BONUS + "%";
    return null;
  }
}
