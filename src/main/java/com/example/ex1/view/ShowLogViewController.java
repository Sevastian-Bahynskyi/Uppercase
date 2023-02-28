package com.example.ex1.view;

import com.example.ex1.view_model.ConvertViewModel;
import com.example.ex1.view_model.ShowLogViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;

import javax.swing.text.View;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ShowLogViewController
{
    @FXML
    private ListView<String> logList;
    private Region root;
    private ViewHandler viewHandler;
    private ShowLogViewModel viewModel;
    public void init(ViewHandler viewHandler, ShowLogViewModel viewModel, Region root)
    {
        this.root = root;
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        viewModel.bindLogs(logList.itemsProperty());
//        viewModel.addPropertyChangeListener(logList.getItems());
    }

    public Region getRoot()
    {
        return root;
    }

    @FXML
    public void onBack()
    {
        viewHandler.openView(ViewFactory.CONVERT);
    }

//    @Override
//    public void propertyChange(PropertyChangeEvent evt)
//    {
//        viewHandler.openView(ViewFactory.SHOW_LOG);
//    }
}
