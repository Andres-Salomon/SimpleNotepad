package com.salomonandres.notepad.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class View extends JFrame {
  private JMenuBar menuBar = new JMenuBar();
  private JTextArea textArea = new JTextArea();
  private JScrollPane scroll = new JScrollPane(textArea);
  private JLabel columnRowCounter = new JLabel();
  private int column = 0;
  private int row = 0;
  private BorderLayout bl = new BorderLayout();

  public View() {
    initializeSimpleView();
  }

  private void initializeSimpleView() {

    setTitle("Simple Notepad");
    setSize(new Dimension(700, 450));
    setLocationRelativeTo(null);
    setJMenuBar(menuBar());
    add(setScroll(), BorderLayout.CENTER);
    add(setColumnRowCounter(), BorderLayout.PAGE_END);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setVisible(true);
  }

  private JLabel setColumnRowCounter() {
    columnRowCounter.setText("Ln " + row + " || " + "Col " + column);
    columnRowCounter.setHorizontalAlignment(SwingConstants.RIGHT);
    return columnRowCounter;
  }

  private JMenuBar menuBar() {
    JMenu fileMenu = new JMenu("File");
    JMenu editMenu = new JMenu("Edit");
    JMenu formatMenu = new JMenu("Format");
    JMenu viewMenu = new JMenu("View");
    JMenu helpMenu = new JMenu("Help");

    JMenuItem newFile = new JMenuItem("New");
    JMenuItem openFile = new JMenuItem("Open");
    JMenuItem saveFile = new JMenuItem("Save");
    JMenuItem exitFile = new JMenuItem("Exit");

    fileMenu.add(newFile);
    fileMenu.add(openFile);
    fileMenu.add(saveFile);
    fileMenu.add(exitFile);

    menuBar.add(fileMenu);
    menuBar.add(editMenu);
    menuBar.add(formatMenu);
    menuBar.add(viewMenu);
    menuBar.add(helpMenu);

    return menuBar;
  }

  private JScrollPane setScroll() {
    return scroll;
  }
}
