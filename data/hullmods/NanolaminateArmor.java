package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class NanolaminateArmor extends BaseHullMod {

  public static final float BEAM_REDUCTION = 70f;

  public void applyEffectsBeforeShipCreation(
    HullSize hullSize,
    MutableShipStatsAPI stats,
    String id
  ) {
    stats.getEnergyDamageTakenMult().modifyPercent(id, 100 - BEAM_REDUCTION);
  }

  public String getDescriptionParam(int index, HullSize hullSize) {
    if (index == 0) return "" + (int) BEAM_REDUCTION + "%";
    return null;
  }
}
