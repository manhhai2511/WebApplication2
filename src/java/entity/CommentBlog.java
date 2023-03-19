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
public class CommentBlog {
    private int commentID;
    private int accountID;
    private int blogID;
    private String userName;
    private String detailCmt;
    private String dateCmt;

    public CommentBlog() {
    }

    public CommentBlog(int commentID, int accountID, int blogID, String userName, String detailCmt, String dateCmt) {
        this.commentID = commentID;
        this.accountID = accountID;
        this.blogID = blogID;
        this.userName = userName;
        this.detailCmt = detailCmt;
        this.dateCmt = dateCmt;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDetailCmt() {
        return detailCmt;
    }

    public void setDetailCmt(String detailCmt) {
        this.detailCmt = detailCmt;
    }

    public String getDateCmt() {
        return dateCmt;
    }

    public void setDateCmt(String dateCmt) {
        this.dateCmt = dateCmt;
    }
    
    
}
