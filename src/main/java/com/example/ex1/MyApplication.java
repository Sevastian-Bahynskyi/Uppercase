package com.example.ex1;

import com.example.ex1.model.Model;
import com.example.ex1.model.*;
import com.example.ex1.view.*;
import com.example.ex1.view_model.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application
{
    public void start(Stage primaryStage)
    {
        Model model = new ModelManager();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler view = new ViewHandler(viewModelFactory);
        view.start(primaryStage);
    }
}