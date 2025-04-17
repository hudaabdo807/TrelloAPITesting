package utilties;
import UserData.*;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Card {

    public static Response createCard(String cardName,String lID)
    {
        return given()
                .baseUri(Data.cardsUrl)
                .header("Content-Type","application/json")
                .queryParams("key",Data.key,"token",Data.token,"name",cardName,"idList",lID)
                .when()
                .post();
    }

    public static Response getCard(String cID)
    {
        return given()
                .baseUri(Data.cardsUrl+"/"+cID)
                .header("Content-Type","application/json")
                .queryParams("key",Data.key,"token",Data.token,"fields","all")
                .when()
                .get();
    }

    public static Response putCard(String cID)
    {
        return given()
                .baseUri(Data.cardsUrl+"/"+cID)
                .header("Content-Type","application/json")
                .queryParams("key",Data.key,"token",Data.token)
                .queryParam("name","c123")
                .when()
                .put();
    }


    public static Response delCard(String cID)
    {
        return given()
                .baseUri(Data.cardsUrl+"/"+cID)
                .header("Content-Type","application/json")
                .queryParams("key",Data.key,"token",Data.token)
                .when()
                .delete();
    }
}
