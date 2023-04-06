package ObjectsAndClasses;
import java.util.Scanner;

public class Articles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] articleData = scanner.nextLine().split(", ");
        Article article = new Article(articleData[0], articleData[1], articleData[2]);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commandData = scanner.nextLine().split(": ");
            String command = commandData[0];
            String data = commandData[1];

            switch (command) {
                case "Edit":
                    article.edit(data);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(data);
                    break;
                case "Rename":
                    article.rename(data);
                    break;
            }
        }

        System.out.println(article.toString());
    }

    public static class Article {
        private String title;
        private String content;
        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public void edit(String newContent) {
            this.content = newContent;
        }

        public void changeAuthor(String newAuthor) {
            this.author = newAuthor;
        }

        public void rename(String newTitle) {
            this.title = newTitle;
        }

        public String getContent() {
            return this.content;
        }

        public String getAuthor() {
            return this.author;
        }

        public String getTitle() {
            return this.title;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", this.title, this.content, this.author);
        }
    }


}

