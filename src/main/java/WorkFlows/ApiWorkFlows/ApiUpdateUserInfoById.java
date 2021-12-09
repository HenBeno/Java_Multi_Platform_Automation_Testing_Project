package WorkFlows.ApiWorkFlows;

import Extension.ApiAction;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;

public class ApiUpdateUserInfoById extends CommonOps {

    @Step("WorkFlow Update user by id using api")
    public static String updateUserInfoById(String id, String email, String login) {
        params = new JSONObject();

        res = req.get("users/" + id);
        jp = res.jsonPath();

        ApiAction.putAction("email", email, params);
        ApiAction.putAction("login", login, params);

        req.body(params.toJSONString());
        res = req.put("users/" + id);
        res.prettyPrint();
        return ApiFindUserById.findUserById(saveLastId);
    }
}
