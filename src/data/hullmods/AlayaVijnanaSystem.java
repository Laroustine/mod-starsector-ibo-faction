/**
 * @ Author: Laroustine
 * @ Modified time: 22/04/2025 18:15
 * @ Modified by: Laroustine
 * @ Description: This script has been made by me ↖(^▽^)↗
 */

package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class AlayaVijnanaSystem extends BaseHullMod {

  public static final float MANEUVER_BONUS = 50.0f;
  public static final float ACCURACY_BONUS = 80.0f;

  public void applyEffectsBeforeShipCreation(
      HullSize hullSize,
      MutableShipStatsAPI stats,
      String id) {
    stats.getAutofireAimAccuracy().modifyPercent(id, ACCURACY_BONUS);
    stats.getAcceleration().modifyPercent(id, MANEUVER_BONUS);
    stats.getDeceleration().modifyPercent(id, MANEUVER_BONUS);
    stats.getTurnAcceleration().modifyPercent(id, MANEUVER_BONUS);
    stats.getMaxTurnRate().modifyPercent(id, MANEUVER_BONUS);
  }

  public String getDescriptionParam(int index, HullSize hullSize) {
    switch (index) {
      case 0:
        return "" + (int) MANEUVER_BONUS + "%";
      case 1:
        return "" + (int) ACCURACY_BONUS + "%";
      default:
        return null;
    }
  }

  @Override
  public boolean isApplicableToShip(ShipAPI ship) {
    return false;
  }

  public String getUnapplicableReason(ShipAPI ship) {
    return "Cannot be installed on ships";
  }
}
