package org.example.auro.leetcode.hard.designATextEditor;

class Test {

    public static void main(String[] args) {
        final TextEditor textEditor = new TextEditor();
        textEditor.addText("howdyboy");
        textEditor.printContent();
        System.out.println(textEditor.cursorLeft(5));
        textEditor.printContent();
        textEditor.addText("kkkkk");
        textEditor.printContent();
        textEditor.cursorRight(3);
        textEditor.printContent();
        textEditor.addText("bbb");
        textEditor.printContent();
        System.out.println(textEditor.deleteText(5));
        textEditor.printContent();

        System.out.println(textEditor.cursorRight(50));
        textEditor.printContent();
        System.out.println(textEditor.deleteText(50));
        textEditor.printContent();
        textEditor.addText("le");
        textEditor.printContent();
        textEditor.cursorLeft(5);
        textEditor.printContent();
        textEditor.deleteText(1);
        textEditor.printContent();
        textEditor.cursorRight(5);
        textEditor.printContent();
        textEditor.deleteText(1);
        textEditor.printContent();
    }
}
