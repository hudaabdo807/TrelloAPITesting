package UserData;

import java.util.HashMap;

public class Data {

    //the names needed
    public static String boardName = "NewBoard*";
    public static String listName = "Try123";
    public static String cardName = "NewCard";
    public static String checklistName = "NewChecklist";
    public static String labelName = "NewLabel";

    //the URL needed
    public static String baseUrl ="https://api.trello.com/1/";
    public static String boardsUrl = baseUrl+"boards";
    public static String listsUrl = baseUrl+"lists";
    public static String cardsUrl = baseUrl+"cards";
    public static String checklistUrl = baseUrl+"checklists";
    public static String labelsUrl = baseUrl+"labels";

   //the key and token need for the requests
    public static String key = "bb2a48b9c5da15cee58085045c6a2790";
    public static String token = "ATTA90e3c55823c245be310f8ed1c643b9c9bc33325501a897fd23027ad05a48bb36036A436B";
    public static HashMap<String,String> userQueries = new HashMap<String,String>();

    public static void setUserData()
    {
        userQueries.put("key",key);
        userQueries.put("token",token);
    }
}
