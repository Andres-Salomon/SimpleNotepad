package com.salomonandres.notepad;

import com.salomonandres.notepad.controller.Controller;
import com.salomonandres.notepad.model.Model;
import com.salomonandres.notepad.view.View;

public class Main {

  public static void main(String[] args) {

    Controller c = new Controller(new Model(), new View());

  }
}
