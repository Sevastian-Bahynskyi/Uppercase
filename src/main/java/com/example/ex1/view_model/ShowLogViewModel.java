package com.example.ex1.view_model;

import com.example.ex1.model.Model;
import com.example.ex1.model.ModelManager;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ShowLogViewModel implements PropertyChangeListener
{
    private final Model model;
    private final SimpleListProperty<String> logs;
    public ShowLogViewModel(Model model)
    {
        this.model = model;
        this.logs = new SimpleListProperty<>(FXCollections.observableArrayList());
        ModelManager modelManager = (ModelManager) model;
        modelManager.addPropertyChangeListener("logs", this);
    }

    public void bindLogs(ObjectProperty<ObservableList<String>> property)
    {
        property.bind(logs);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        if(evt.getPropertyName().equals("logs"))
        {
            logs.clear();
            logs.addAll(model.getLogs());
        }
    }
}
