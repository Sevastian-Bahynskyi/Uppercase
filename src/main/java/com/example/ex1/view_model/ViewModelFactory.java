package com.example.ex1.view_model;


import com.example.ex1.model.*;
import com.example.ex1.view.*;
import com.example.ex1.view_model.*;

public class ViewModelFactory
{
    private ConvertViewModel convertViewModel;
    private ViewHandler viewHandler;
    public ViewModelFactory(Model model){
        convertViewModel = new ConvertViewModel(model);
    }

    public ConvertViewModel getConvertViewModel()
    {
        return convertViewModel;
    }

    public ViewHandler getViewHandler()
    {
        return viewHandler;
    }
}
