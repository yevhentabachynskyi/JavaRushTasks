package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.undo.CannotUndoException;
import java.io.*;

/**
 * Created by XPMUser on 12/25/18.
 */
public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public HTMLDocument getDocument() {
        return document;
    }

    public Controller(View view) {
        this.view = view;
    }
    public void init(){
        createNewDocument();
    }

    public void exit(){
        System.exit(0);
    }

    public void resetDocument(){
        if (document != null)
            document.removeUndoableEditListener(view.getUndoListener());
        HTMLEditorKit htmlKit = new HTMLEditorKit();
        document = (HTMLDocument) htmlKit.createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }
    public void setPlainText(String text){
        try {
        resetDocument();
        StringReader stringReader = new StringReader(text);
        HTMLEditorKit htmlKit = new HTMLEditorKit();
        htmlKit.read(stringReader,document,0);
    } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }
    public String getPlainText(){
        StringWriter stringWriter = new StringWriter();
        try {
            HTMLEditorKit htmlKit = new HTMLEditorKit();
            htmlKit.write(stringWriter,document,0,document.getLength());
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }

    public static void main(String[] args) {
        View newView = new View();
        Controller controller = new Controller(newView);
        newView.setController(controller);
        newView.init();
        controller.init();

    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view. setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        int index = jFileChooser.showOpenDialog(view);
        if(index == JFileChooser.APPROVE_OPTION){
            currentFile = jFileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try(FileReader fileReader = new FileReader(currentFile)) {
                HTMLEditorKit htmlKit = new HTMLEditorKit();
                htmlKit.read(fileReader,document,0);
                view.resetUndo();
            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }

        }
    }

    public void saveDocument() {
        view.selectHtmlTab();
        if(currentFile!=null){
            view.setTitle(currentFile.getName());
            try (FileWriter fileWriter = new FileWriter(currentFile)){
                HTMLEditorKit htmlKit = new HTMLEditorKit();
                htmlKit.write(fileWriter,document,0,document.getLength());
            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }

        }else saveDocumentAs();
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        int index = jFileChooser.showSaveDialog(view);
        if(index == JFileChooser.APPROVE_OPTION){
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try (FileWriter fileWriter = new FileWriter(currentFile)){
                HTMLEditorKit htmlKit = new HTMLEditorKit();
                htmlKit.write(fileWriter,document,0,document.getLength());
            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }

        }
    }
}
