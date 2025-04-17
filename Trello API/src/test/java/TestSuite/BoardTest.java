package TestSuite;
import UserData.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilties.Board;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class BoardTest {
    public static String boardID ;

    @BeforeClass
    public void createBoard(){
        Response response = Board.createBoard(Data.boardName);
        response.then().log().all();
        assertEquals(response.getStatusCode(),200);
        boardID=response.path("id");
    }


    @Test(priority = 1)
    public void validGetBoard()
    {
        Response response = Board.getBoard(boardID);
        response.
                then().log().all().assertThat().statusCode(200)
                .body("id", equalTo(boardID)).body("name",equalTo(Data.boardName));

    }

    @Test(priority = 0)
    public void updateBoard()
    {
        Response response = Board.putBoard(boardID);
        response.
                then().log().all().assertThat().statusCode(200)
                .body("desc", equalTo("The board is updated"));

    }



//    @Test(priority = 2)
//    public void deleteBoard()
//    {
//        Response response = Board.delBoard(boardID);
//        response.
//                then().log().all().assertThat().statusCode(200)
//                .body("_value",equalTo(null));
//
//    }

    //recheck that the board is deleted already
//    @Test(dependsOnMethods = "deleteBoard",priority = 1)
//    public void invalidGetBoard()
//    {
//        Response response = Board.getBoard(boardID);
//        response.
//                then().log().all().assertThat().statusCode(404);
//        Assert.assertEquals(response.getBody().asString(),"The requested resource was not found.");
//
//    }
}
