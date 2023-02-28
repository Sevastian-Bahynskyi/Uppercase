package com.example.ex1.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ModelManager implements Model
{
    private Converter converter;
    private PropertyChangeSupport support;

    public ModelManager()
    {
        support = new PropertyChangeSupport(this);
        this.converter = new Converter();
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener)
{
    support.addPropertyChangeListener(propertyName, listener);
}

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener)
    {
        support.removePropertyChangeListener(propertyName, listener);
    }

    @Override
    public synchronized String convert(String source)
    {
        String reply = converter.toUpperCase(source);
        addLog("Converting: " + source);
        support.firePropertyChange("logs", null, getLogs());
        return reply;
    }

    @Override
    public synchronized void addLog(String log)
    {
        String logValue = converter.getLogSize() + ": " + log;
        converter.addLog(logValue);
    }

    @Override
    public synchronized ArrayList<String> getLogs()
    {
       return converter.getLogList();
    }
}
