package WorkFlows.ApiWorkFlows;

import Utilities.CommonOps;
import io.qameta.allure.Step;

public class ApiFindUserById extends CommonOps {

    @Step("WorkFlow Find user by id using api")
    public static String findUserById(String id) {
        res = req.get("users/" + id);
        jp = res.jsonPath();

        return jp.get("login") + " " + jp.get("email");
    }

}
