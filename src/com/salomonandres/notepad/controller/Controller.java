package com.salomonandres.notepad.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.salomonandres.notepad.model.Model;
import com.salomonandres.notepad.view.View;

public class Controller {
  private Model model;
  private View view;
  private JFileChooser fileChooser = new JFileChooser();
  private File file;
  private FileNameExtensionFilter filter = new FileNameExtensionFilter("Text",
      "txt");

  public Controller(Model model, View view) {
    this.model = model;
    this.view = view;
    view.newFile().addActionListener(e -> newFile());
    view.openFile().addActionListener(e -> openFile());
    view.saveFile().addActionListener(e -> saveFile());
    view.exitFile().addActionListener(e -> exit());
  }

  public void newFile() {

  }

  public void openFile() {
    fileChooser.setDialogTitle("Open a File");
    fileChooser.setFileFilter(filter);
    fileChooser.addChoosableFileFilter(filter);
    fileChooser.showOpenDialog(null);

    try {
      view.changeTitle(fileChooser.getSelectedFile().getName());
      view.setTextArea(
          model.loadFile(fileChooser.getSelectedFile().getAbsolutePath()));
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

  }

  public void saveFile() {
    fileChooser.setDialogTitle("Save your File");
    fileChooser.setFileFilter(filter);
    fileChooser.showSaveDialog(null);
    try {
      model.saveFile(view.getTextArea().getText(),
          fileChooser.getSelectedFile().getAbsolutePath());
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void exit() {
    System.exit(0);
  }

}
