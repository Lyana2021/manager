package model;

import javafx.beans.property.SimpleStringProperty;

public class Story {
    public SimpleStringProperty usernameProperty() {
        return username;
    }
    public SimpleStringProperty passwordProperty() {
        return password;
    }
    SimpleStringProperty username;
    SimpleStringProperty password;
    SimpleStringProperty siteURL;
    SimpleStringProperty sitename;
    SimpleStringProperty comment;
    SimpleStringProperty category;
    SimpleStringProperty date;

    public String getSitename() {
        return sitename.get();
    }
    public void setSitename(String sitename) {
        this.sitename.set(sitename);
    }
    public String getComment() {
        return comment.get();
    }
    public void setComment(String comment) {
        this.comment.set(comment);
    }
    public String getCategory() {
        return category.get();
    }
    public void setCategory(String category) {
        this.category.set(category);
    }
    public String getDate() {
        return date.get();
    }
    public void setDate(String date) {
        this.date.set(date);
    }

    public Story( String username, String password, String siteURL, String sitename, String comment, String category, String date) {
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.siteURL = new SimpleStringProperty(siteURL);
        this.sitename = new SimpleStringProperty(sitename);
        this.comment = new SimpleStringProperty(comment);
        this.category = new SimpleStringProperty(category);
        this.date = new SimpleStringProperty(date);
    }
    public String getSiteURL() {
        return siteURL.get();
    }
    public void setSiteURL(String siteURL) {
        this.siteURL.set(siteURL);
    }
    public String getUsername() {
        return username.get();
    }
    public void setUsername(String username) {
        this.username.set(username);
    }
    public String getPassword(){return  password.get();}
    public void setPassword(String password){this.password.set(password);}
}
