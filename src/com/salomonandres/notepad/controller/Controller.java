package com.salomonandres.notepad.controller;

import com.salomonandres.notepad.model.Model;
import com.salomonandres.notepad.view.View;

public class Controller {
	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
}
