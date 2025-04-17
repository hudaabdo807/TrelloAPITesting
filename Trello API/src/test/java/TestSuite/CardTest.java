package TestSuite;

import UserData.*;
import utilties.Board;
import utilties.Card;
import utilties.List;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

import static org.testng.Assert.assertEquals;

public class CardTest {

    public static String boardID ;
    public static String listID ;
    public static String cardID ;

    @BeforeClass
    public void createBoardForList()
    {
        Response response = Board.createBoard(Data.boardName);
        response.then().log().all();
        assertEquals(response.getStatusCode(),200);
        boardID=response.path("id");
    }

    //name of the new list and id of specified board required
    @Test(priority = 0)
    public void createList(){
        Response response = List.createList(boardID);
        response.then().log().all();
        assertEquals(response.getStatusCode(),200);
        listID=response.path("id");
    }

    // the id of list is required
    @Test(dependsOnMethods = "createList",priority = 1)
    public void createCard(){
        Response response = Card.createCard(Data.cardName, listID);
        response.then().log().all();
        assertEquals(response.getStatusCode(),200);
        cardID=response.path("id");
    }

    //The ID of the Card is required
    @Test(dependsOnMethods = "createCard",priority = 1)
    public void updateCard()
    {
        Response response = Card.putCard(cardID);
        response.
                then().log().all().assertThat().statusCode(200)
                .body("name", equalTo("c123"));

    }

    //The ID of the Card is required

    @Test(dependsOnMethods = "updateCard",priority = 1)
    public void validGetCard()
    {
        Response response = Card.getCard(cardID);
        response.
                then().log().all().assertThat().statusCode(200)
                .body("id", equalTo(cardID))
                .body("name", equalTo("c123"));

    }
//    @Test(dependsOnMethods = "validGetCard",priority = 1)
//    public void deleteCard()
//    {
//        Response response = Card.delCard(cardID);
//        response.
//                then().log().all().assertThat().statusCode(200);
//        Assert.assertEquals(response.getBody().asString(),"{\"limits\":{}}");
//    }
//
//    @Test(dependsOnMethods = "deleteCard",priority = 1)
//    public void invalidGetCard()
//    {
//        Response response = Card.getCard(cardID);
//        response.
//                then().log().all().assertThat().statusCode(404);
//        Assert.assertEquals(response.getBody().asString(),"The requested resource was not found.");
//    }

}
