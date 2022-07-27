/**
 * @ Author: Laroustine
 * @ Modified time: 27/07 20:05
 * @ Modified by: Laroustine
 * @ Description: This script has been made by me ↖(^▽^)↗
 */

package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class NanolaminateArmor extends BaseHullMod {

  public static final float BEAM_RED = -50f;
  public static final float ENERGY_RED = -70f;
  // public static final float EMP_INC = 15f;
  public static final float FLUX_INC = 12f;

  public void applyEffectsBeforeShipCreation(
      HullSize hullSize,
      MutableShipStatsAPI stats,
      String id) {
    stats.getEnergyDamageTakenMult().modifyPercent(id, BEAM_RED);
    stats.getBeamDamageTakenMult().modifyPercent(id, BEAM_RED);
    // stats.getEmpDamageTakenMult().modifyPercent(id, EMP_INC);
    // FLUX INCREASE
    stats.getBeamWeaponFluxCostMult().modifyPercent(id, FLUX_INC);
    stats.getEnergyWeaponFluxCostMod().modifyPercent(id, FLUX_INC);
    stats.getMissileWeaponFluxCostMod().modifyPercent(id, FLUX_INC);
    stats.getBallisticWeaponFluxCostMod().modifyPercent(id, FLUX_INC);
  }

  public String getDescriptionParam(int index, HullSize hullSize) {
    switch (index) {
      case 0:
        return "" + (int) -BEAM_RED + "%";
      case 1:
        return "" + (int) -ENERGY_RED + "%";
      case 2:
        return "" + (int) FLUX_INC + "%";
      default:
        return null;
    }
  }
}
