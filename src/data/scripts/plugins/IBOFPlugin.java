/**
 * @ Author: Laroustine
 * @ Modified time: 27/07 20:07
 * @ Modified by: Laroustine
 * @ Description: This script has been made by me ↖(^▽^)↗
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
