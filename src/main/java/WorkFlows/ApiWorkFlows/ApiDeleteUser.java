package WorkFlows.ApiWorkFlows;

import Utilities.CommonOps;
import io.qameta.allure.Step;

public class ApiDeleteUser extends CommonOps {

    @Step("WorkFlow Delete user by id using api")
    public static String deleteUserById(String id) {
        res = req.delete("admin/users/" + id);
        return String.valueOf(res.getStatusCode());
    }
}
