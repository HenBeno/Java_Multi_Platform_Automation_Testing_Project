package Extension;

import io.qameta.allure.Step;
import org.json.simple.JSONObject;

public class ApiAction {

    @Step
    public static void putAction(String key, String value, JSONObject params) {
        params.put(key, value);
    }

}
