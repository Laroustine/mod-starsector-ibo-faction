/*
 * Author: Laroustine
 * Project: IBO Faction
 * Version: 1.0.0a
 * Game Version: 0.95.1a-RC6
 * File Created: 07/03/2022
 */

package data.scripts.plugins;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;

import data.scripts.world.IBOFGen;

public class IBOFPlugin extends BaseModPlugin {

  private void initIBOF() {
    new IBOFGen().generate(Global.getSector());
  }

  private void initExerelinIBO() {
    boolean corvusMode = Global
        .getSector()
        .getMemoryWithoutUpdate()
        .getBoolean("$nex_corvusMode");

    if (corvusMode) {
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
