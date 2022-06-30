package org.example.auro.leetcode.hard.designATextEditor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

/**
 * Problem Statement: https://leetcode.com/problems/design-a-text-editor/
 */

class TextEditor {

    private static final Logger LOGGER = LogManager.getLogger(TextEditor.class);

    private final static int MAX_CALLS = 20000;
    private final static int MAX_LEN = 10;

    private int currentTotalCalls = 0;
    private final Node cursor;

    TextEditor() {
        this.cursor = new Node('|');
    }

    private boolean callExceeded() {
        if (currentTotalCalls < MAX_CALLS) {
            currentTotalCalls++;
            return false;
        }
        LOGGER.warn("Call Exceeded");
        return true;
    }

    private boolean isValid(final String text) {
        if (text == null || text.length() == 0 || text.equals(" ")) {
            LOGGER.warn("Invalid Text: {}" + text);
            return false;
        }

        for (final char c : text.toCharArray()) {
            if (!(c >= 'a' && c <= 'z')) {
                LOGGER.warn("Invalid Character {} in Text: {}", c, text);
                return false;
            }
        }
        return true;
    }

    @NotNull
    private String readContent() {
        Node temp = cursor;
        for (int i = 1; temp.getPrev() != null && i <= MAX_LEN; i++) {
            temp = temp.getPrev();
        }
        final StringBuilder stringBuilder = new StringBuilder();
        while (temp != cursor) {
            stringBuilder.append(temp.getValue());
            temp = temp.getNext();
        }
        return stringBuilder.toString();
    }

    public void addText(final String text) {

        if (callExceeded() || !isValid(text)) {
            return;
        }

        for (final char c : text.toCharArray()) {
            final Node n = new Node(c);
            final Node cPrev = cursor.getPrev();
            if (cPrev != null) {
                cPrev.setNext(n);
                n.setPrev(cPrev);
            }
            n.setNext(cursor);
            cursor.setPrev(n);
        }
    }

    public void printContent() {
        Node temp = cursor;
        while (temp.getPrev() != null) {
            temp = temp.getPrev();
        }
        final StringBuffer stringBuffer = new StringBuffer();
        while (temp != null) {
            stringBuffer.append(temp.getValue());
            temp = temp.getNext();
        }
        LOGGER.info("Current Content: {}", stringBuffer);
    }

    public int deleteText(int k) {
        int totalDeleted = 0;

        if (!callExceeded()) {
            Node t = cursor;
            while (t.getPrev() != null && k-- > 0) {
                totalDeleted++;
                t = t.getPrev();
            }
            if (t != cursor) {
                final Node tPrev = t.getPrev();
                final Node cPrev = cursor.getPrev();

                if (tPrev != null) {
                    tPrev.setNext(cursor);
                    cursor.setPrev(tPrev);
                    cPrev.setNext(null);
                    t.setPrev(null);
                } else {
                    cursor.setPrev(null);
                    cPrev.setNext(null);
                }
            }
        }
        return totalDeleted;
    }

    public String cursorLeft(int k) {

        if (callExceeded()) {
            return "";
        }

        Node t = cursor;
        while (t.getPrev() != null && k-- > 0) {
            t = t.getPrev();
        }
        if (t != cursor) {
            final Node tPrev = t.getPrev();
            final Node cPrev = cursor.getPrev();
            final Node cNext = cursor.getNext();
            cPrev.setNext(cNext);
            if (cNext != null) {
                cNext.setPrev(cPrev);
            }
            if (tPrev != null) {
                tPrev.setNext(cursor);
                cursor.setPrev(tPrev);
            } else {
                cursor.setPrev(null);
            }
            cursor.setNext(t);
            t.setPrev(cursor);
        }

        return readContent();
    }

    public String cursorRight(int k) {

        if (callExceeded()) {
            return "";
        }

        Node t = cursor;
        while (t.getNext() != null && k-- > 0) {
            t = t.getNext();
        }
        if (t != cursor) {
            final Node tNext = t.getNext();
            final Node cPrev = cursor.getPrev();
            final Node cNext = cursor.getNext();

            cNext.setPrev(cPrev);
            if (cPrev != null) {
                cPrev.setNext(cNext);
            }
            if (tNext != null) {
                tNext.setPrev(cursor);
                cursor.setNext(tNext);
            } else {
                cursor.setNext(null);
            }
            cursor.setPrev(t);
            t.setNext(cursor);
        }

        return readContent();
    }
}
