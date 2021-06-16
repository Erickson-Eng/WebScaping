package org.example.entities;

import java.util.Objects;

public class Article {
    private Long id;
    private String url;
    private String articleName;
    private String subtitle;
    private String author;
    private String date;
    private String article;

    public Article() {
    }

    public Article(String url, String articleName, String subtitle, String author, String date, String article) {
        this.setUrl(url);
        this.setArticleName(articleName);
        this.setSubtitle(subtitle);
        this.setAuthor(author);
        this.setDate(date);
        this.setArticle(article);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Article: " + '\n'+
                "id=" + id + '\n' +
                "url=" + getUrl() + '\n' +
                "articleName=" + getArticleName() + '\n' +
                "subtitle=" + getSubtitle() + '\n' +
                "author=" + getAuthor() + '\n' +
                "date=" + getDate() + '\n' +
                "article=" + getArticle() ;
    }
}
