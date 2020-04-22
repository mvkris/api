package less5;

import retrofit2.Call;
import retrofit2.http.*;

public interface Trelloapi {

    @POST("/1/boards/")
    Call<Board> createBoard(@Body Board board, @Query("name") String name);

    @PUT ("/1/boards/{id}")
    Call<Board> updateBoard(@Body Board board, @Path("id") String id);

    @POST("/1/lists/")
    Call<TrelloList> createList(@Body TrelloList trelloList, @Query("name") String name, @Query("idBoard") String idBoard);

    @POST("/1/cards/")
    Call<TrelloCard> createCard(@Body TrelloCard trelloCard, @Query("name") String name, @Query("idList") String idList);

    @PUT ("/1/cards/{id}/")
    Call<TrelloCard> updateCard(@Body TrelloCard trelloCard, @Path("id") String id);

    @DELETE ("/1/cards/{id}/")
    Call<Board> delateCard(@Path("id") String id, @Query("key") String key, @Query("token") String token);




}
