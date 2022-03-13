/*
 * Author: Laroustine
 * Project: IBO Faction
 * Version: 1.1.0a
 * Game Version: 0.95.1a-RC6
 * File Created: 09/03/2022
 */

package data.scripts.world;

import com.fs.starfarer.api.campaign.FactionAPI;
import com.fs.starfarer.api.campaign.RepLevel;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.SectorGeneratorPlugin;

import org.json.JSONObject;

import data.scripts.world.systems.Don;
import data.scripts.world.systems.TeiwazSaisei;

public class IBOFGen implements SectorGeneratorPlugin {

  JSONObject options;

  @Override
  public void generate(SectorAPI sector) {
    initFactionRelationships(sector);
    //load systems
    new TeiwazSaisei().generate(sector);
    new GjaStationList().generate(sector);
    new Don().generate(sector);
  }

  public static void initFactionRelationships(SectorAPI sector) {
    FactionAPI teiwaz = sector.getFaction("teiwaz");
    FactionAPI gjallarhorn = sector.getFaction("gjallarhorn");

    // Teiwaz
    teiwaz.setRelationship("pirates", RepLevel.HOSTILE);
    // Gjallarhorn
    gjallarhorn.setRelationship("pirates", RepLevel.HOSTILE);
    gjallarhorn.setRelationship("luddic_path", RepLevel.HOSTILE);
    gjallarhorn.setRelationship("tritachyon", RepLevel.HOSTILE);
    gjallarhorn.setRelationship("player", RepLevel.SUSPICIOUS);
    gjallarhorn.setRelationship("hegemony", RepLevel.WELCOMING);
    gjallarhorn.setRelationship("persean", RepLevel.WELCOMING);
  }
}
