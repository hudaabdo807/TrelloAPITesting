package utilties;
//import all the data needed in the User data file
import UserData.*;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Board {

    public static Response createBoard(String boardName)
    {

        return given()
                .baseUri(Data.boardsUrl)
                .header("Content-Type","application/json")
                //the name of the board is required
                .queryParams("key",Data.key,"token",Data.token,"name",boardName)
                .when()
                .post();
    }


    //get the board by ID
    public static Response getBoard(String bID)
    {
        return given()
                .baseUri(Data.boardsUrl+"/"+bID)
                .header("Content-Type","application/json")

                .queryParams("key",Data.key,"token",Data.token)
                .when()
                .get();
    }


    public static Response putBoard(String bID)
    {
        return given()
                .baseUri(Data.boardsUrl+"/"+bID)
                .header("Content-Type","application/json")
                .queryParams("key",Data.key,"token",Data.token)
                //update the description of the board
                .queryParam("desc","The board is updated")
                .when()
                .put();
    }

    public static Response delBoard(String bID)
    {
        return given()
                .baseUri(Data.boardsUrl+"/"+bID)
                .header("Content-Type","application/json")
                .queryParams("key",Data.key,"token",Data.token)
                .when()
                .delete();
    }
}
