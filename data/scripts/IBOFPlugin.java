/*
 * Author: Laroustine
 * Project: IBO Faction
 * Version: 1.0.0a
 * Game Version: 0.95.1a-RC6
 * File Created: 07/03/2022
 */

package data.scripts;

import java.io.IOException;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;

import org.json.JSONException;
import org.json.JSONObject;

import data.scripts.world.IBOFGen;

public class IBOFPlugin extends BaseModPlugin {

  private static final String SETTINGS_FILE = "options.ini";
  private static JSONObject settings;

  private static void initIBOF() {
    new IBOFGen().generate(Global.getSector());
  }

  private static JSONObject loadSettings() throws IOException, JSONException {
    return Global.getSettings().loadJSON(SETTINGS_FILE);
  }

  @Override
  public void onNewGame() {
    initIBOF();
  }
}
