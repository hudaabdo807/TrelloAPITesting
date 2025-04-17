package utilties;
import UserData.*;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
public class List {

    //name of the new list and id of specified board required
    public static Response createList(String bID)
    {
        return given()
                .baseUri(Data.listsUrl)
                .header("Content-Type","application/json")
                .queryParams("key",Data.key,"token",Data.token,"name",Data.listName,"idBoard",bID)
                .when()
                .post();
    }

    // the id of created list is required
    public static Response getList(String lID)
    {
        return given()
                .baseUri(Data.listsUrl+"/"+lID)
                .header("Content-Type","application/json")
                .queryParams("key",Data.key,"token",Data.token,"fields","all")
                .when()
                .get();
    }

    public static Response putList(String lID)
    {
        return given()
                .baseUri(Data.listsUrl+"/"+lID)
                .header("Content-Type","application/json")
                .queryParams("key",Data.key,"token",Data.token)
                .queryParam("name","l123")
                .when()
                .put();
    }




}
