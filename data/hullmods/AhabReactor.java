package data.hullmods;

import java.util.HashMap;
import java.util.Map;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

@SuppressWarnings("unchecked")
public class AhabReactor extends BaseHullMod {

  public static final float DETECTION = 80f;
  private static final Map FLUX_CAPACITY = new HashMap();
  private static final Map FLUX_DISPATION = new HashMap();

  static {
    // FLUX DISPATION
    FLUX_DISPATION.put(HullSize.FRIGATE, 20f);
    FLUX_DISPATION.put(HullSize.DESTROYER, 40f);
    FLUX_DISPATION.put(HullSize.CRUISER, 80f);
    FLUX_DISPATION.put(HullSize.CAPITAL_SHIP, 120f);
    // FLUX CAPACITY
    FLUX_CAPACITY.put(HullSize.FRIGATE, 100f);
    FLUX_CAPACITY.put(HullSize.DESTROYER, 200f);
    FLUX_CAPACITY.put(HullSize.CRUISER, 300f);
    FLUX_CAPACITY.put(HullSize.CAPITAL_SHIP, 500f);
  }

  public void applyEffectsBeforeShipCreation(
    HullSize hullSize,
    MutableShipStatsAPI stats,
    String id
  ) {
    if (hullSize == HullSize.FIGHTER) {
      stats.getFluxCapacity().modifyFlat(id, 100);
      stats.getFluxDissipation().modifyFlat(id, 20);
    } else {
      stats.getSensorProfile().modifyPercent(id, DETECTION);
      stats
        .getFluxCapacity()
        .modifyFlat(id, (Float) FLUX_CAPACITY.get(hullSize));
      stats
        .getFluxDissipation()
        .modifyFlat(id, (Float) FLUX_DISPATION.get(hullSize));
    }
  }

  public String getDescriptionParam(int index, HullSize hullSize) {
    // FLUX CAPACITY
    if (index == 0) return (
      "" + ((Float) FLUX_CAPACITY.get(HullSize.FRIGATE)).intValue()
    );
    if (index == 1) return (
      "" + ((Float) FLUX_CAPACITY.get(HullSize.DESTROYER)).intValue()
    );
    if (index == 2) return (
      "" + ((Float) FLUX_CAPACITY.get(HullSize.CRUISER)).intValue()
    );
    if (index == 3) return (
      "" + ((Float) FLUX_CAPACITY.get(HullSize.CAPITAL_SHIP)).intValue()
    );
    // FLUX DISPATION
    if (index == 4) return (
      "" + ((Float) FLUX_DISPATION.get(HullSize.FRIGATE)).intValue()
    );
    if (index == 5) return (
      "" + ((Float) FLUX_DISPATION.get(HullSize.DESTROYER)).intValue()
    );
    if (index == 6) return (
      "" + ((Float) FLUX_DISPATION.get(HullSize.CRUISER)).intValue()
    );
    if (index == 7) return (
      "" + ((Float) FLUX_DISPATION.get(HullSize.CAPITAL_SHIP)).intValue()
    );
    // SENSOR PROFILE
    if (index == 8) return "" + (int) DETECTION + "%";
    return null;
  }
}
