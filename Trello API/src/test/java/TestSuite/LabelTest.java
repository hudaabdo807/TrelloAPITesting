package TestSuite;

import UserData.*;
import utilties.Board;
import utilties.Card;
import utilties.Label;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

import static org.testng.Assert.assertEquals;
public class LabelTest {

    public static String boardID ;
    public static String labelID ;

    @BeforeClass
    public void createBoardForLabel()
    {
        Response response = Board.createBoard(Data.boardName);
        response.then().log().all();
        assertEquals(response.getStatusCode(),200);
        boardID=response.path("id");
    }


    @Test(priority = 0)
    public void createLabel(){
        Response response = Label.createLabel(Data.labelName,boardID,"yellow");
        response.then().log().all();
        assertEquals(response.getStatusCode(),200);
        labelID=response.path("id");
    }

    @Test(dependsOnMethods = "createLabel",priority = 1)
    public void updateLabel()
    {
        Response response = Label.putLabel(labelID);
        response.
                then().log().all().assertThat().statusCode(200)
                .body("name", equalTo("lbl123"));

    }

    @Test(dependsOnMethods = "updateLabel",priority = 1)
    public void validGetLabel()
    {
        Response response = Label.getLabel(labelID);
        response.
                then().log().all().assertThat().statusCode(200)
                .body("id", equalTo(labelID));

    }

//    @Test(dependsOnMethods = "validGetLabel",priority = 1)
//    public void deleteLabel()
//    {
//        Response response = Label.delLabel(labelID);
//        response.
//                then().log().all().assertThat().statusCode(200);
//        Assert.assertEquals(response.getBody().asString(),"{\"limits\":{}}");
//
//    }

//    @Test(dependsOnMethods = "deleteLabel",priority = 4)
//    public void deleteBoardForLabel()
//    {
//        Response response = Board.delBoard(boardID);
//        response.
//                then().log().all().assertThat().statusCode(200)
//                .body("_value",equalTo(null));
//    }
}
