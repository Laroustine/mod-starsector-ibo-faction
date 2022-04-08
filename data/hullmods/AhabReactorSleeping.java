package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class AhabReactorSleeping extends BaseHullMod {

  public static final float DETECTION = 80f;

  public void applyEffectsBeforeShipCreation(
    HullSize hullSize,
    MutableShipStatsAPI stats,
    String id
  ) {}

  public String getDescriptionParam(int index, HullSize hullSize) {
    return null;
  }
}
