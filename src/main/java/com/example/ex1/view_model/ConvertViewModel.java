package com.example.ex1.view_model;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import com.example.ex1.model.*;
import com.example.ex1.view.*;
import com.example.ex1.view_model.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ConvertViewModel
{
    private Model model;
    private StringProperty request;
    private StringProperty reply;
    private StringProperty error;
//    private PropertyChangeSupport support;

    public ConvertViewModel(Model model){
        this.model = model;
        request = new SimpleStringProperty();
        reply = new SimpleStringProperty();
        error = new SimpleStringProperty();
//        this.support = new PropertyChangeSupport(this);
    }

    public void convert()
    {
        try{
            reply.set(model.convert(request.get()));
            error.set(null);
        }
        catch (Exception e)
        {
            error.set(e.getMessage());
        }
    }

    public void bindRequest(StringProperty property)
    {
        property.bindBidirectional(request);
    }

    public void bindReply(StringProperty property)
    {
        property.bindBidirectional(reply);
    }

    public void bindError(StringProperty property)
    {
        property.bindBidirectional(error);
    }

//    public void addPropertyChangeListener(PropertyChangeListener listener)
//    {
//        support.addPropertyChangeListener(listener);
//    }
//
//    public void removePropertyChangeListener(PropertyChangeListener listener)
//    {
//        support.removePropertyChangeListener(listener);
//    }
}
