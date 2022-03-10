/*
 * Author: Laroustine
 * Project: IBO Faction
 * Version: 1.0.0a
 * Game Version: 0.95.1a-RC6
 * File Created: 07/03/2022
 */

package data.scripts.world.systems;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.campaign.StarSystemAPI;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.impl.campaign.ids.Conditions;
import com.fs.starfarer.api.impl.campaign.ids.Industries;
import com.fs.starfarer.api.impl.campaign.ids.Submarkets;

public class GjaTest {

  final String starSystem = "Corvus";
  final String planetId = "asharu";
  final String faction = "gjallarhorn";

  public void generate(SectorAPI sector) {
    StarSystemAPI system = sector.getStarSystem(starSystem);
    SectorEntityToken saisei = system.addCustomEntity(
      null,
      null,
      "station_saisei",
      faction
    );
    MarketAPI market = Global.getFactory().createMarket("gja_01", "HELL", 3);

    saisei.setCircularOrbitPointingDown(
      system.getEntityById(planetId),
      225,
      730,
      30
    );

    market.setPrimaryEntity(saisei);
    market.setFactionId(faction);
    market.getTariff().modifyFlat("generator", 0.05f);
    market.setPlanetConditionMarketOnly(false);
    market.addCondition(Conditions.POPULATION_4);
    market.addSubmarket(Submarkets.SUBMARKET_STORAGE);
    market.addSubmarket(Submarkets.GENERIC_MILITARY);
    market.addIndustry(Industries.POPULATION);
    market.addIndustry(Industries.MEGAPORT);
    market.addIndustry(Industries.HIGHCOMMAND);
    market.addIndustry(Industries.WAYSTATION);

    saisei.setMarket(market);
    Global.getSector().getEconomy().addMarket(market, true);

    system.updateAllOrbits();
  }
}
