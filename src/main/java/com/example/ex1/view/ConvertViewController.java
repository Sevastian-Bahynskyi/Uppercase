package com.example.ex1.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import com.example.ex1.model.*;
import com.example.ex1.view.*;
import com.example.ex1.view_model.*;

public class ConvertViewController
{
    private ConvertViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;
    @FXML
    private TextField requestField;
    @FXML
    private TextField replyField;

    @FXML
    private Label errorLabel;


    public void init(ViewHandler viewHandler, ConvertViewModel viewModel, Region root)
    {
        this.viewModel = viewModel;
        this.viewHandler = viewHandler;
        viewModel.bindRequest(requestField.textProperty());
        viewModel.bindReply(replyField.textProperty());
        viewModel.bindError(errorLabel.textProperty());
        this.root = root;
    }

    public Region getRoot()
    {
        return root;
    }

    public void reset()
    {

    }

    @FXML
    public void onSubmit()
    {
        viewModel.convert();
    }

    @FXML
    public void onEnter()
    {
        viewModel.convert();
    }
}
