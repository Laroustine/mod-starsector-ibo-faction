/**
 * @ Author: Laroustine
 * @ Modified time: 22/04/2025 18:15
 * @ Modified by: Laroustine
 * @ Description: This script has been made by me ↖(^▽^)↗
 */

package data.scripts.world.systems;

import java.util.Random;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.campaign.StarSystemAPI;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.impl.campaign.ids.Conditions;
import com.fs.starfarer.api.impl.campaign.ids.Industries;
import com.fs.starfarer.api.impl.campaign.ids.Submarkets;

public class GjaStationMaker {

  final String faction = "gjallarhorn";

  public void generate(SectorAPI sector, String starSystem) {
    StarSystemAPI system = sector.getStarSystem(starSystem);
    SectorEntityToken station = system.addCustomEntity(
        null,
        null,
        "station_gja",
        faction);
    MarketAPI market = Global
        .getFactory()
        .createMarket(
            "st_gja_" + starSystem.toLowerCase(),
            "Admiministrative Station",
            3);

    station.setCircularOrbitPointingDown(
        system.getStar(),
        new Random().nextInt(360),
        new Random().nextInt(2500) + 2800,
        new Random().nextInt(120) + 60);

    market.setPrimaryEntity(station);
    market.setFactionId(faction);
    market.getTariff().modifyFlat("generator", 0.35f);
    market.setPlanetConditionMarketOnly(false);
    market.addCondition(Conditions.POPULATION_3);
    market.addCondition(Conditions.OUTPOST);
    market.addSubmarket(Submarkets.GENERIC_MILITARY);
    market.addIndustry(Industries.BATTLESTATION_MID);
    market.addIndustry(Industries.HIGHCOMMAND);
    market.addIndustry(Industries.POPULATION);
    market.addIndustry(Industries.SPACEPORT);
    market.addIndustry(Industries.WAYSTATION);
    market.getUpkeepMult().modifyFlat("generator", 0);

    station.setMarket(market);
    sector.getEconomy().addMarket(market, true);

    system.updateAllOrbits();
  }
}
