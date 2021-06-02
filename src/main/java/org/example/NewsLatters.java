package org.example;

public class NewsLatters {

    private String url;
    private String title;
    private String caption;
    private String author;

    public NewsLatters() {
    }

    public NewsLatters(String url, String title, String caption, String author) {
        this.setUrl(url);
        this.setTitle(title);
        this.setCaption(caption);
        this.setAuthor(author);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "NewsLatters{" +
                "url='" + getUrl() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", caption='" + getCaption() + '\'' +
                ", author='" + getAuthor() + '\'' +
                '}';
    }
}
