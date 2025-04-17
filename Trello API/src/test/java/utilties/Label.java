package utilties;

import UserData.*;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class Label {

    public static Response createLabel(String labelName,String bID,String color)
    {
        return given()
                .baseUri(Data.labelsUrl)
                .header("Content-Type","application/json")
                .queryParams("key",Data.key,"token",Data.token,"name",labelName,"idBoard",bID,"color",color)
                .when()
                .post();
    }

    public static Response getLabel(String laID)
    {
        return given()
                .baseUri(Data.labelsUrl+"/"+laID)
                .header("Content-Type","application/json")
                .queryParams("key",Data.key,"token",Data.token,"fields","all")
                .when()
                .get();
    }

    public static Response putLabel(String laID)
    {
        return given()
                .baseUri(Data.labelsUrl+"/"+laID)
                .header("Content-Type","application/json")
                .queryParams("key",Data.key,"token",Data.token)
                .queryParam("name","lbl123")
                .when()
                .put();
    }

    public static Response delLabel(String laID)
    {
        return given()
                .baseUri(Data.labelsUrl+"/"+laID)
                .header("Content-Type","application/json")
                .queryParams("key",Data.key,"token",Data.token)
                .when()
                .delete();
    }
}
