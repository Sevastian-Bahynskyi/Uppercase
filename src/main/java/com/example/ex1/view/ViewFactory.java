package com.example.ex1.view;

import com.example.ex1.MyApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;
import com.example.ex1.model.*;
import com.example.ex1.view.*;
import com.example.ex1.view_model.*;

import java.io.IOException;

public class ViewFactory
{
    private ViewHandler viewHandler;
    private ViewModelFactory viewModelFactory;
    private ConvertViewController convertViewController;
    public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
    {
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
    }

    public Region loadView(String id)
    {
        if (convertViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MyApplication.class.getResource("ConvertView.fxml"));
            try {
                Region root = loader.load();
                convertViewController = loader.getController();
                convertViewController.init(viewHandler, viewModelFactory.getConvertViewModel(), root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        convertViewController.reset();
        return convertViewController.getRoot();
    }

}
