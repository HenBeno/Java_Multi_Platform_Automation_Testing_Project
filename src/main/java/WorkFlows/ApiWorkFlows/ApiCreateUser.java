package WorkFlows.ApiWorkFlows;

import Extension.ApiAction;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;

import java.util.Arrays;

public class ApiCreateUser extends CommonOps {

    @Step("WorkFlow Create user using api")
    public static String createUser(String name, String email, String login, String password) {
        params = new JSONObject();
        ApiAction.putAction("name", name, params);
        ApiAction.putAction("email", email, params);
        ApiAction.putAction("login", login, params);
        ApiAction.putAction("password", password, params);
        req.body(params.toJSONString());
        res = req.post("admin/users");

        String[] cleanResponse = res.print().replaceAll("[{}]", "").split(":");

        if (cleanResponse.length == 3) {
            saveLastId = cleanResponse[1].replaceAll("[a-zA-Z' ',\"]", "");
            return cleanResponse[2];
        }
        return Arrays.toString(cleanResponse);

    }
}
