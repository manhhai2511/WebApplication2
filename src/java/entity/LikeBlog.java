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
public class LikeBlog {
    private int accountID;
    private int blogID;

    public LikeBlog() {
    }

    public LikeBlog(int accountID, int blogID) {
        this.accountID = accountID;
        this.blogID = blogID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getBlogID() {
        return blogID;
    }

    public void setBlogID(int blogID) {
        this.blogID = blogID;
    }
    
    
}
