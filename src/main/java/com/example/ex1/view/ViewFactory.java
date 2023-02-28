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
    public static final String CONVERT = "convert";
    public static final String SHOW_LOG = "show log";
    private ViewHandler viewHandler;
    private ViewModelFactory viewModelFactory;
    private ConvertViewController convertViewController;
    private ShowLogViewController showLogViewController;
    public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
    {
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
    }

    public Region loadConvertView()
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
        return convertViewController.getRoot();
    }

    public Region loadShowLogView()
    {
        if (showLogViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MyApplication.class.getResource("ShowLogView.fxml"));
            try {
                Region root = loader.load();
                showLogViewController = loader.getController();
                showLogViewController.init(viewHandler, viewModelFactory.getShowLogViewModel(), root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return showLogViewController.getRoot();
    }

    public Region load(String id)
    {
        return switch (id)
        {
            case CONVERT -> loadConvertView();
            case SHOW_LOG -> loadShowLogView();
            default -> throw new IllegalArgumentException("Unknown view: " + id);
        };
    }

}
