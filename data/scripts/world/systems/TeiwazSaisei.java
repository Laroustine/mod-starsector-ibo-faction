/*
 * Author: Laroustine
 * Project: IBO Faction
 * Version: 1.0.0a
 * Game Version: 0.95.1a-RC6
 * File Created: 07/03/2022
 */

package data.scripts.world.systems;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.PersonImportance;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.campaign.StarSystemAPI;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.characters.FullName;
import com.fs.starfarer.api.characters.FullName.Gender;
import com.fs.starfarer.api.characters.PersonAPI;
import com.fs.starfarer.api.impl.campaign.ids.Conditions;
import com.fs.starfarer.api.impl.campaign.ids.Industries;
import com.fs.starfarer.api.impl.campaign.ids.Personalities;
import com.fs.starfarer.api.impl.campaign.ids.Submarkets;

public class TeiwazSaisei {

  String starSystem = "Valhalla";
  String planetId = "yggdrasil";

  public void generate(SectorAPI sector) {
    PersonAPI mc = makeAdmin();
    StarSystemAPI system = sector.getStarSystem(starSystem);
    SectorEntityToken saisei = system.addCustomEntity(
      null,
      null,
      "station_saisei",
      "teiwaz"
    );
    MarketAPI market = Global
      .getFactory()
      .createMarket("saisei_market", "Saisei", 3);

    saisei.setCircularOrbitPointingDown(
      system.getEntityById(planetId),
      225,
      730,
      30
    );

    mc.setMarket(market);

    market.setPrimaryEntity(saisei);
    market.setFactionId("teiwaz");
    market.getTariff().modifyFlat("generator", 0.05f);
    market.setPlanetConditionMarketOnly(false);
    market.addCondition(Conditions.POPULATION_4);
    market.addSubmarket(Submarkets.SUBMARKET_OPEN);
    market.addSubmarket(Submarkets.GENERIC_MILITARY);
    market.addSubmarket(Submarkets.LOCAL_RESOURCES);
    market.addIndustry(Industries.POPULATION);
    market.addIndustry(Industries.MEGAPORT);
    market.addIndustry(Industries.TECHMINING);
    market.addIndustry(Industries.HIGHCOMMAND);
    market.addIndustry(Industries.WAYSTATION);
    market.addIndustry(Industries.ORBITALWORKS);
    market.setAdmin(mc);

    saisei.setMarket(market);
    Global.getSector().getEconomy().addMarket(market, true);

    system.updateAllOrbits();
  }

  private PersonAPI makeAdmin() {
    PersonAPI mc = Global.getSettings().createPerson();

    mc.setFaction("teiwaz");
    mc.setName(new FullName("McMurdo", "Barriston", Gender.MALE));
    mc.setPortraitSprite("graphics/portraits/mcmurdo.png");
    mc.setPersonality(Personalities.CAUTIOUS);
    mc.setImportance(PersonImportance.HIGH);

    return mc;
  }
}
