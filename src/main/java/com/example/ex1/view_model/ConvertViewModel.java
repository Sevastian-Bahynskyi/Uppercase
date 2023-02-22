package com.example.ex1.view_model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import com.example.ex1.model.*;
import com.example.ex1.view.*;
import com.example.ex1.view_model.*;

public class ConvertViewModel
{
    private Model model;
    private StringProperty request;
    private StringProperty reply;
    private StringProperty error;

    public ConvertViewModel(Model model){
        this.model = model;
        request = new SimpleStringProperty();
        reply = new SimpleStringProperty();
        error = new SimpleStringProperty();
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

    public String getRequest()
    {
        return request.get();
    }

    public String getReply()
    {
        return reply.get();
    }

    public String getError()
    {
        return error.get();
    }
}
