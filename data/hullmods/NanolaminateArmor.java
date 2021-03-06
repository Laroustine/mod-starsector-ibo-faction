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
    String id
  ) {
    stats.getEnergyDamageTakenMult().modifyPercent(id, 100 + BEAM_RED);
    stats.getBeamDamageTakenMult().modifyPercent(id, 100 + BEAM_RED);
    // stats.getEmpDamageTakenMult().modifyPercent(id, 100 + EMP_INC);
    // FLUX INCREASE
    stats.getBeamWeaponFluxCostMult().modifyPercent(id, 100 + FLUX_INC);
    stats.getEnergyWeaponFluxCostMod().modifyPercent(id, 100 + FLUX_INC);
    stats.getMissileWeaponFluxCostMod().modifyPercent(id, 100 + FLUX_INC);
    stats.getBallisticWeaponFluxCostMod().modifyPercent(id, 100 + FLUX_INC);
  }

  public String getDescriptionParam(int index, HullSize hullSize) {
    if (index == 0) return "" + (int) -BEAM_RED + "%";
    if (index == 1) return "" + (int) -ENERGY_RED + "%";
    // if (index == 2) return "" + (int) EMP_INCREASE + "%";
    if (index == 2) return "" + (int) FLUX_INC + "%";
    return null;
  }
}
