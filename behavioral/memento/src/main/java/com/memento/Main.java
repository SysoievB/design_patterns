package com.memento;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        val document = new Document("Initial content\n");
        val history = new History();

        document.write("Additional content\n");
        history.addMemento(document.createMemento());

        document.write("More content\n");
        history.addMemento(document.createMemento());

        document.restoreFromMemento(history.getMemento(1));

        System.out.println(document.getContent());
    }
}

@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
class Document {
    String content;

    void write(String text) {
        content += text;
    }

    DocumentMemento createMemento() {
        return new DocumentMemento(content);
    }

    void restoreFromMemento(DocumentMemento memento) {
        content = memento.getSavedContent();
    }
}

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class DocumentMemento {
    String content;

    String getSavedContent() {
        return content;
    }
}

@FieldDefaults(level = AccessLevel.PRIVATE)
class History {
    List<DocumentMemento> mementos;

    History() {
        mementos = new ArrayList<>();
    }

    void addMemento(DocumentMemento memento) {
        mementos.add(memento);
    }

    DocumentMemento getMemento(int index) {
        return mementos.get(index);
    }
}