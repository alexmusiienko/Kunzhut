package com.example.alexm.kunzhutproject;

enum MessageType { BOT, USER }

public class InformationForRecyclerView {

    static final int iconId = R.mipmap.bot_face;

    MessageType type;
    String title;

    InformationForRecyclerView(MessageType type, String text) {
        this.type = type;
        title = text;
    }
}
