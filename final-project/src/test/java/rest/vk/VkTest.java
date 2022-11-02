package rest.vk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("VK API tests")
public class VkTest {

    private static final String text = "text";
    private static final String comment = "comment";

    @Test
    @DisplayName("Wall record validation")
    public void validateWallRecord(){
        VkSteps vkSteps = new VkSteps();
        String postId = vkSteps.createRecord(text);
        vkSteps.likeRecord(postId);
        vkSteps.createComment(postId, comment);
        vkSteps.getTextFromPost(postId);
        Assertions.assertAll(() -> assertEquals(text, vkSteps.getTextFromPost(postId)),
                () -> assertEquals("1", vkSteps.getLikesFromPost(postId)),
                () -> assertEquals("1", vkSteps.getCommentsFromPost(postId)));
    }

}
