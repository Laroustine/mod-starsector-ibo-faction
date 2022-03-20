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

import org.json.JSONException;
import org.json.JSONObject;

import data.scripts.ConfigJson;
import data.scripts.world.systems.Don;
import data.scripts.world.systems.TeiwazSaisei;

public class IBOFGen implements SectorGeneratorPlugin {

  JSONObject options;

  @Override
  public void generate(SectorAPI sector) {
    JSONObject config = new ConfigJson().loadSettings();

    try {
      initFactionRelationships(sector, config);
      //load systems
      if (config.getBoolean("Teiwaz")) {
        new TeiwazSaisei().generate(sector);
      }
      if (config.getBoolean("Gjallarhorn")) {
        new GjaStationList().generate(sector);
        new Don().generate(sector);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  public static void initFactionRelationships(
    SectorAPI sector,
    JSONObject config
  )
    throws JSONException {
    FactionAPI teiwaz = sector.getFaction("teiwaz");
    FactionAPI gjallarhorn = sector.getFaction("gjallarhorn");

    // Teiwaz
    if (config.getBoolean("Teiwaz")) {
      teiwaz.setRelationship("pirates", RepLevel.HOSTILE);
    } else {
      sector.getAllFactions().remove(teiwaz);
    }
    // Gjallarhorn
    if (config.getBoolean("Gjallarhorn")) {
      gjallarhorn.setRelationship("pirates", RepLevel.HOSTILE);
      gjallarhorn.setRelationship("luddic_path", RepLevel.HOSTILE);
      gjallarhorn.setRelationship("tritachyon", RepLevel.HOSTILE);
      gjallarhorn.setRelationship("player", RepLevel.SUSPICIOUS);
      gjallarhorn.setRelationship("hegemony", RepLevel.WELCOMING);
      gjallarhorn.setRelationship("persean", RepLevel.WELCOMING);
    } else {
      sector.getAllFactions().remove(gjallarhorn);
    }
    //
  }
}
