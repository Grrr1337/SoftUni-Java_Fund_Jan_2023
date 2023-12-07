package Tests;

import ObjectsAndClasses.Articles.Article;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArticleTest {

    @Test
    public void testEdit() {
        Article article = new Article("Some title", "Some content", "Some author");
        article.edit("Better content");
//        assertEquals("Better content", article.getContent());
        assertOutputEquals("Better content", article.getContent());
    }

    @Test
    public void testChangeAuthor() {
        Article article = new Article("Some title", "Some content", "Some author");
        article.changeAuthor("Better author");
//        assertEquals("Better author", article.getAuthor());
        assertOutputEquals("Better author", article.getAuthor());
    }

    @Test
    public void testRename() {
        Article article = new Article("Some title", "Some content", "Some author");
        article.rename("Better title");
//        assertEquals("Better title", article.getTitle());
        assertOutputEquals("Better title", article.getTitle());
    }

    @Test
    public void testToString() {
        Article article = new Article("Some title", "Some content", "Some author");
//        assertEquals("Some title - Some content: Some author", article.toString());
        assertOutputEquals("Some title - Some content: Some author", article.toString());
    }

    public static void assertOutputEquals(String expectedOutput, String actualOutput) {
        String normalizedExpected = expectedOutput.replaceAll("\\r\\n", "\n").trim();
        String normalizedActual = actualOutput.replaceAll("\\r\\n", "\n").trim();
        Assertions.assertEquals(normalizedExpected, normalizedActual);
    }

}
