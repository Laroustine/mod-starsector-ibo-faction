package data.scripts;

import java.io.IOException;

import com.fs.starfarer.api.Global;

import org.json.JSONException;
import org.json.JSONObject;

public class ConfigJson {

  private static final String SETTINGS_LOCATION = "";
  private static final String SETTINGS_FILE = "options.json";

  public JSONObject loadSettings() {
    try {
      return Global.getSettings().loadJSON(SETTINGS_LOCATION + SETTINGS_FILE);
    } catch (IOException | JSONException e) {
      e.printStackTrace();
    }
    return null;
  }
}
