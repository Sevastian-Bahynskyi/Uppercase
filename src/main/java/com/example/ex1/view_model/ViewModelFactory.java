package com.example.ex1.view_model;


import com.example.ex1.model.*;
import com.example.ex1.view.*;
import com.example.ex1.view_model.*;

public class ViewModelFactory
{
    private ConvertViewModel convertViewModel;
    private ShowLogViewModel showLogViewModel;
    public ViewModelFactory(Model model){
        convertViewModel = new ConvertViewModel(model);
        showLogViewModel = new ShowLogViewModel(model);
    }


    public ConvertViewModel getConvertViewModel()
    {
        return convertViewModel;
    }
    public ShowLogViewModel getShowLogViewModel()
    {
        return showLogViewModel;
    }
}
