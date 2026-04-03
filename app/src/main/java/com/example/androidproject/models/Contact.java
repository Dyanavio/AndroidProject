package com.example.androidproject.models;

public class Contact
{
    private int imageId;
    private String name;
    private boolean isMuted;
    private boolean isVerified;
    private String date;
    private boolean isPrivate;
    private int lastUserImageId;
    private String lastMessage;
    private int unreadMessages;

    public Contact(int imageId, String name, boolean isMuted, boolean isVerified, String date, boolean isPrivate, int lastUserImageId, String lastMessage, int unreadMessages) {
        this.imageId = imageId;
        this.name = name;
        this.isMuted = isMuted;
        this.isVerified = isVerified;
        this.date = date;
        this.isPrivate = isPrivate;
        this.lastUserImageId = lastUserImageId;
        this.lastMessage = lastMessage;
        this.unreadMessages = unreadMessages;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMuted() {
        return isMuted;
    }

    public void setMuted(boolean muted) {
        isMuted = muted;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLastUserImageId() {
        return lastUserImageId;
    }

    public void setLastUserImageId(int lastUserImageId) {
        this.lastUserImageId = lastUserImageId;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public int getUnreadMessages() {
        return unreadMessages;
    }

    public void setUnreadMessages(int unreadMessages) {
        this.unreadMessages = unreadMessages;
    }
}
