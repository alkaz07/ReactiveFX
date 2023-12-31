package com.example.reactivefx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class HelloController {
    @FXML
    private TextField txtVal;
    @FXML
    Button incBtn, decBtn;

    @FXML
    Slider sliderVal;

    @FXML
    Button mult2Btn;

    //Model mod=new Model();
    ObservableModel model = new ObservableModel();


    public void initialize()
    {
        //incBtn.setOnAction(actionEvent -> incrementVal());
        // txtVal.setText(String.valueOf(mod.a));
        incBtn.setOnAction(actionEvent ->  model.incr());   //кнопка связана с методом модели
        decBtn.setOnAction(actionEvent -> model.decr());

//        model.b.addListener((x, number, t1) ->{
//            refreshView(x);
//        });

        /*sliderVal.setOnMouseReleased(mouseEvent -> {
            model.b.set((int) sliderVal.getValue());
        });*/

        mult2Btn.setOnAction(actionEvent -> model.multByTwo());     //кнопка связана с методом модели

        model.b.bindBidirectional(sliderVal.valueProperty());               //свойство модели связано со слайдером
        //model.b.bindBidirectional(txtVal.textProperty());
        txtVal.textProperty().bindBidirectional(model.b, new DecimalFormat());  //текст поля ввода связан со свойством модели
    }

    private void refreshView(ObservableValue<? extends Number> x) {
        txtVal.setText(x.getValue().toString());
        sliderVal.adjustValue((int) x.getValue());
    }
   /* @FXML
    private void incrementVal(){
        //int a = Integer.parseInt(txtVal.getText());
        //a++;
        //mod.incr();
        model.incr();
        //txtVal.setText(String.valueOf(mod.a));
        //sliderVal.adjustValue(mod.a);
    }
    @FXML
    private void decrementVal(){
        model.decr();
        //txtVal.setText(String.valueOf(mod.a));
        //sliderVal.adjustValue(mod.a);
    }*/
}