package com.msd5.pushpeers.ui.dashboard.fragment;

public class ChatModel {
    public String text;
    public String chatId;
    public boolean isSender;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }
}
