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
  public static final float ACCURACY_BONUS = 80.0f;

  public void applyEffectsBeforeShipCreation(
    HullSize hullSize,
    MutableShipStatsAPI stats,
    String id
  ) {
    stats.getAutofireAimAccuracy().modifyPercent(id, 100 + ACCURACY_BONUS);
    stats.getAcceleration().modifyPercent(id, 100 + MANEUVER_BONUS);
    stats.getDeceleration().modifyPercent(id, 100 + MANEUVER_BONUS);
    stats.getTurnAcceleration().modifyPercent(id, 100 + MANEUVER_BONUS);
    stats.getMaxTurnRate().modifyPercent(id, 100 + MANEUVER_BONUS);
  }

  public String getDescriptionParam(int index, HullSize hullSize) {
    if (index == 0) return "" + (int) MANEUVER_BONUS + "%";
    if (index == 1) return "" + (int) ACCURACY_BONUS + "%";
    return null;
  }
}
