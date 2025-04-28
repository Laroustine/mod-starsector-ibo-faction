/**
 * @ Author: Laroustine
 * @ Modified time: 2025/04/23 00:22
 * @ Modified by: Laroustine
 * @ Description: This script has been made by me ↖(^▽^)↗
 */

package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.impl.campaign.ids.Stats;

import data.scripts.ids.IboHullmods;

public class AhabReactorSleeping extends BaseHullMod {

    public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {
        float fxc = (Float) AhabReactor.FLUX_CAPACITY.get(hullSize);
        float fxd = (Float) AhabReactor.FLUX_DISPATION.get(hullSize);
        float mult = stats.getDynamic().getValue(Stats.DMOD_EFFECT_MULT);

        stats.getFluxCapacity().modifyFlat(id, -fxc * mult);
        stats.getFluxDissipation().modifyFlat(id, -fxd * mult);
        stats.getSensorProfile().modifyFlat(id, -AhabReactor.DETECTION * mult);
        stats.getSensorStrength().modifyFlat(id, -AhabReactor.DETECTION * mult);
    }

    public boolean isApplicableToShip(ShipAPI ship) {
        return ship.getHullSpec().getBuiltInMods().contains(IboHullmods.AHAB_REACTOR);
    }

  public String getDescriptionParam(int index, HullSize hullSize, ShipAPI ship) {
    float mult = ship == null ? 1f : ship.getMutableStats().getDynamic().getValue(Stats.DMOD_EFFECT_MULT);
    // FLUX CAPACITY
    switch (index) {
      case 0:
        return ("" +
            (int) (((Float) AhabReactor.FLUX_CAPACITY.get(HullSize.FRIGATE)).intValue() *
                mult));
      case 1:
        return ("" +
            (int) (((Float) AhabReactor.FLUX_CAPACITY.get(HullSize.DESTROYER)).intValue() *
                mult));
      case 2:
        return ("" +
            (int) (((Float) AhabReactor.FLUX_CAPACITY.get(HullSize.CRUISER)).intValue() *
                mult));
      case 3:
        return ("" +
            (int) (((Float) AhabReactor.FLUX_CAPACITY.get(HullSize.CAPITAL_SHIP)).intValue() *
                mult));
      case 4:
        return ("" +
            (int) (((Float) AhabReactor.FLUX_DISPATION.get(HullSize.FRIGATE)).intValue() *
                mult));
      case 5:
        return ("" +
            (int) (((Float) AhabReactor.FLUX_DISPATION.get(HullSize.DESTROYER)).intValue() *
                mult));
      case 6:
        return ("" +
            (int) (((Float) AhabReactor.FLUX_DISPATION.get(HullSize.CRUISER)).intValue() *
                mult));
      case 7:
        return ("" +
            (int) (((Float) AhabReactor.FLUX_DISPATION.get(HullSize.CAPITAL_SHIP)).intValue() *
                mult));
      case 8:
        return ("" + (int) (AhabReactor.DETECTION * mult) + "%");
      case 9:
        return ("" + (int) (AhabReactor.DETECTION * mult) + "%");
      default:
        return null;
    }
  }
}
