package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static utils.Constants.*;

public class UserClient {

    @Step("Создание пользователя")
    public Response createUser(User user){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(REGISTER_URL);
    }
//    @Step("Авторизация пользователя")
//    public Response loginUser(UserCreds userCreds) {
//        return given()
//                .header("Content-type", "application/json")
//                .and()
//                .body(userCreds)
//                .when()
//                .post(LOGIN_URL);
//    }
    @Step("Удаление пользователя")
    public Response deleteUser(){
        return given()
                .header("Content-type", "application/json")
                .when()
                .delete(USER_URL);
    }

}
