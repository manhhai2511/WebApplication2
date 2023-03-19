/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class Blog {
    private int ID;
    private String title;
    private String content;
    private String imageLink;
    private String modife;
    private String img;
    private int accountID;

    public Blog() {
    }

    public Blog(int ID, String title, String content, String imageLink, String modife, String img, int accountID) {
        this.ID = ID;
        this.title = title;
        this.content = content;
        this.imageLink = imageLink;
        this.modife = modife;
        this.img = img;
        this.accountID = accountID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getModife() {
        return modife;
    }

    public void setModife(String modife) {
        this.modife = modife;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    
    
}
