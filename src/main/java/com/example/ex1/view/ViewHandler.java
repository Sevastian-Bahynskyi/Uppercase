package com.example.ex1.view;

import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import com.example.ex1.model.*;
import com.example.ex1.view.*;
import com.example.ex1.view_model.*;

public class ViewHandler
{
    private Stage primaryStage;
    private Scene currentScene;
    private ViewFactory viewFactory;


    public ViewHandler(ViewModelFactory viewModelFactory)
    {
        viewFactory = new ViewFactory(this, viewModelFactory);
    }

    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        currentScene = new Scene(viewFactory.loadView("StupidId"));
        openView("StupidId");
    }

    public void openView(String id)
    {
        Region root = viewFactory.loadView(id);
        currentScene.setRoot(root);
        if (root.getUserData() == null) {
            primaryStage.setTitle("");
        } else {
            primaryStage.setTitle(root.getUserData().toString());
        }
        primaryStage.setScene(currentScene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public void closeView()
    {
        primaryStage.close();
    }

}
