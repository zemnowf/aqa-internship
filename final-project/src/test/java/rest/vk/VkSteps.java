package rest.vk;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class VkSteps {
    private static final String uri = "https://api.vk.com/";
    private static final String token = "TOKEN";
    private static final String version = "5.131";
    private static final String userId = "148400320";

    @Step("Create record on the page")
    public String createRecord(String text){
        Response rs = given().baseUri(uri)
                .basePath("method/")
                .param("v", version)
                .param("access_token", token)
                .param("message", text)
                .when().post("wall.post");
        System.out.println(rs.asString());
        JSONObject root = new JSONObject(rs.asString());
        Integer postId = root.getJSONObject("response").getInt("post_id");
        return postId.toString();
    }

    @Step("Validate record")
    public String getTextFromPost(String post_id){
        Response record = given()
                .baseUri(uri)
                .basePath("method/")
                .param("access_token", token)
                .param("v", version)
                .param("posts", userId+"_"+post_id)
                .when().get("wall.getById");
        System.out.println(record.asString());
        JSONObject root = new JSONObject(record.asString());
        JSONArray posts = root.getJSONArray("response");
        JSONObject post = posts.getJSONObject(0);
        return post.getString("text");
    }

    @Step
    public String getLikesFromPost(String post_id){
        Response record = given()
                .baseUri(uri)
                .basePath("method/")
                .param("access_token", token)
                .param("v", version)
                .param("posts", userId+"_"+post_id)
                .when().get("wall.getById");
        System.out.println(record.asString());
        JSONObject root = new JSONObject(record.asString());
        JSONArray posts = root.getJSONArray("response");
        JSONObject post = posts.getJSONObject(0);
        JSONObject likes = post.getJSONObject("likes");
        Integer user_likes = likes.getInt("user_likes");
        return user_likes.toString();
    }

    @Step
    public String getCommentsFromPost(String post_id){
        Response record = given()
                .baseUri(uri)
                .basePath("method/")
                .param("access_token", token)
                .param("v", version)
                .param("posts", userId+"_"+post_id)
                .when().get("wall.getById");
        System.out.println(record.asString());
        JSONObject root = new JSONObject(record.asString());
        JSONArray posts = root.getJSONArray("response");
        JSONObject post = posts.getJSONObject(0);
        JSONObject comments = post.getJSONObject("comments");
        Integer count = comments.getInt("count");
        return count.toString();
    }


    @Step("Like record")
    public void likeRecord(String postId){
        given()
                .baseUri(uri)
                .basePath("method/")
                .param("access_token", token)
                .param("v", version)
                .param("post_id", postId)
                .when().post("wall.addLike");
    }

    @Step("Comment record")
    public void createComment(String postId, String commentText) {
        given()
                .baseUri(uri)
                .basePath("method/wall.createComment")
                .param("access_token", token)
                .param("v", version)
                .param("post_id", postId)
                .param("message", commentText)
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .extract().jsonPath().get();
    }


}

