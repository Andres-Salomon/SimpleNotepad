package com.salomonandres.notepad.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Model {
  private StringBuilder sb = new StringBuilder();
  private String s;
  private FileReader fr;
  private FileWriter fw;
  private int column = 1;
  private int row = 1;

  public Model() {
  }

  public String loadFile(String fileLocation) throws IOException {
    fr = new FileReader(fileLocation);

    int frValue = fr.read();
    while (frValue != -1) {
      try {
        sb.append((char) frValue);
        frValue = fr.read();
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
    fr.close();
    s = new String(sb);
    return s;
  }

  public void saveFile(String fileLocation) throws IOException {
    fw = new FileWriter(fileLocation);
    fw.write("pruebadeguardado");
    fw.close();
  }

}
