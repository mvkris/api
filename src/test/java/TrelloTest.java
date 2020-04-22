import less5.Board;
import less5.RetrofitBuilder;
import less5.TrelloCard;
import less5.TrelloList;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class TrelloTest {

    private String boardId;
    private String listId;
    private String cardId;




    @Test(priority = 1)
    public void checkCreateBoard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Board board = new Board();
        String name = "New board Kris";

        Board createBoard = retrofitBuilder.getTrelloapi().createBoard(board, name).execute().body();
        boardId = createBoard.getId();

        Assert.assertEquals(createBoard.getName(), name);
    }

    @Test(priority = 2)
    public void checkUpdateTest() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Board board = new Board();
        String updatedName = "My Board";
        board.setName(updatedName);

        Board updatedBoard = retrofitBuilder.getTrelloapi().updateBoard(board, boardId).execute().body();
        Assert.assertEquals(updatedBoard.getName(), updatedName);


    }

    @Test(priority = 3)
    public void createList() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        TrelloList trelloList = new TrelloList();
        String name = "Kris to do";

        TrelloList createdList = retrofitBuilder.getTrelloapi().createList(trelloList, name, boardId).execute().body();
        listId = createdList.getId();
        Assert.assertEquals(createdList.getName(), name);


    }

    @Test(priority = 4)
    public void createCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        TrelloCard trelloCard = new TrelloCard();
        String name = "I can create tests";

        TrelloCard createdCard = retrofitBuilder.getTrelloapi().createCard(trelloCard, name, listId).execute().body();
        cardId = createdCard.getId();
        Assert.assertEquals(createdCard.getName(), name);
    }

    @Test(priority = 5)
    public void checkUpdateCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        TrelloCard trelloCard = new TrelloCard();
        String updatedName = "My Card";
        trelloCard.setName(updatedName);

        TrelloCard updateCard = retrofitBuilder.getTrelloapi().updateCard(trelloCard, cardId).execute().body();
        Assert.assertEquals(updateCard.getName(), updatedName);

    }

    @Test(priority = 6)
    public void delateCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        TrelloCard trelloCard = new TrelloCard();

        int code = retrofitBuilder.getTrelloapi().delateCard(cardId, trelloCard.getKey(), trelloCard.getToken()).execute().code();

        Assert.assertEquals(code, 200);

    }
}
