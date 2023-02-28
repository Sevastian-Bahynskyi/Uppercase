package com.example.ex1.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public interface Model
{
    String convert(String source) throws Exception;
    void addLog(String log);
    ArrayList<String> getLogs();
}
