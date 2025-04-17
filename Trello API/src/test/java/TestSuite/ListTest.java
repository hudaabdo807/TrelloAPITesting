package TestSuite;
import UserData.*;
import utilties.Board;
import utilties.List;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;


public class ListTest {

    public static String boardID ;
    public static String listID ;

    @BeforeClass
    public void createBoardForList()
    {
        Response response = Board.createBoard(Data.boardName);
        response.then().log().all();
        assertEquals(response.getStatusCode(),200);
        boardID=response.path("id");
    }

    // the name of new list and id board  is required
    @Test(priority = 0)
    public void createList(){
        Response response = List.createList(boardID);
        response.then().log().all();
        assertEquals(response.getStatusCode(),200);
        listID=response.path("id");
    }

    // the id of the list is required
    @Test(dependsOnMethods = "createList",priority = 1)
    public void updateList()
    {
        Response response = List.putList(listID);
        response.
                then().log().all().assertThat().statusCode(200)
                .body("name", equalTo("l123"));

    }


    //the id of the list is required
    @Test(dependsOnMethods = "updateList",priority = 1)
    public void validGetList()
    {
        Response response = List.getList(listID);
        response.
                then().log().all().assertThat().statusCode(200)
                .body("id", equalTo(listID));

    }




}



