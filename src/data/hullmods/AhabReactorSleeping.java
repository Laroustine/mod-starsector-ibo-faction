package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.impl.campaign.ids.Stats;

public class AhabReactorSleeping extends BaseHullMod {

  public void applyEffectsBeforeShipCreation(
      HullSize hullSize,
      MutableShipStatsAPI stats,
      String id) {
    float fxc = (Float) AhabReactor.FLUX_CAPACITY.get(hullSize);
    float fxd = (Float) AhabReactor.FLUX_DISPATION.get(hullSize);
    float mult = stats.getDynamic().getValue(Stats.DMOD_EFFECT_MULT);

    stats.getFluxCapacity().modifyFlat(id, -fxc * mult);
    stats.getFluxDissipation().modifyFlat(id, -fxd * mult);
  }

  public boolean isApplicableToShip(ShipAPI ship) {
    if (ship.getHullSpec().getBuiltInMods().contains("ibo_ah_reactor")) {
      return true;
    }
    return false;
  }

  public String getDescriptionParam(
      int index,
      HullSize hullSize,
      ShipAPI ship) {
    float mult = ship.getMutableStats().getDynamic().getValue(Stats.DMOD_EFFECT_MULT);
    // FLUX CAPACITY
    if (index == 0)
      return ("" +
          (int) (((Float) AhabReactor.FLUX_CAPACITY.get(HullSize.FRIGATE)).intValue() *
              mult));
    if (index == 1)
      return ("" +
          (int) (((Float) AhabReactor.FLUX_CAPACITY.get(HullSize.DESTROYER)).intValue() *
              mult));
    if (index == 2)
      return ("" +
          (int) (((Float) AhabReactor.FLUX_CAPACITY.get(HullSize.CRUISER)).intValue() *
              mult));
    if (index == 3)
      return ("" +
          (int) (((Float) AhabReactor.FLUX_CAPACITY.get(HullSize.CAPITAL_SHIP)).intValue() *
              mult));
    // FLUX DISPATION
    if (index == 4)
      return ("" +
          (int) (((Float) AhabReactor.FLUX_DISPATION.get(HullSize.FRIGATE)).intValue() *
              mult));
    if (index == 5)
      return ("" +
          (int) (((Float) AhabReactor.FLUX_DISPATION.get(HullSize.DESTROYER)).intValue() *
              mult));
    if (index == 6)
      return ("" +
          (int) (((Float) AhabReactor.FLUX_DISPATION.get(HullSize.CRUISER)).intValue() *
              mult));
    if (index == 7)
      return ("" +
          (int) (((Float) AhabReactor.FLUX_DISPATION.get(HullSize.CAPITAL_SHIP)).intValue() *
              mult));
    return null;
  }
}
