/*
 * Author: Laroustine
 * Project: IBO Faction
 * Version: 1.0.0a
 * Game Version: 0.95.1a-RC6
 * File Created: 07/03/2022
 */

package data.scripts;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;

import data.scripts.world.IBOFGen;

public class IBOFPlugin extends BaseModPlugin {

  private static void initIBOF() {
    new IBOFGen().generate(Global.getSector());
  }

  private static void initExerelinIBO() {
    if (false) { // This is to change for not random mode | Global.getSector().getStarSystem("Corvus")
      new IBOFGen().generate(Global.getSector());
    }
  }

  @Override
  public void onNewGame() {
    boolean haveNexerelin = Global
      .getSettings()
      .getModManager()
      .isModEnabled("nexerelin");

    if (haveNexerelin) {
      initExerelinIBO();
    } else {
      initIBOF();
    }
  }
}
