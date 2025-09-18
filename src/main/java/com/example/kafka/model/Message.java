package com.example.kafka.model;

public class Message {
    private String content;
    private String timestamp;

    public Message() {}

    public Message(String content, String timestamp) {
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
