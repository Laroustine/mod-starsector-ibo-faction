package data.scripts.world;

import com.fs.starfarer.api.campaign.SectorAPI;

import data.scripts.world.systems.GjaStationMaker;

public class GjaStationList {

  public void generate(SectorAPI sector) {
    // Hegemony
    new GjaStationMaker().generate(sector, "Aztlan");
    new GjaStationMaker().generate(sector, "Corvus");
    new GjaStationMaker().generate(sector, "Samarra");
    // Persean League
    new GjaStationMaker().generate(sector, "Thule");
    new GjaStationMaker().generate(sector, "Tyle");
    new GjaStationMaker().generate(sector, "Zagan");
    // Independent
    new GjaStationMaker().generate(sector, "Arcadia");
    new GjaStationMaker().generate(sector, "Eos Exodus");
  }
}
