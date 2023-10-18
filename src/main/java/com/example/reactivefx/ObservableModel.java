package com.example.reactivefx;

import javafx.beans.property.SimpleIntegerProperty;

public class ObservableModel {
    SimpleIntegerProperty b = new SimpleIntegerProperty();
    public void incr(){
        b.set(b.get()+1);
    }

    public void decr(){
        b.set(b.get()-1);
    }

    public void multByTwo()
    {
        b.set(2*b.get());
    }

    public int getB() {
        return b.get();
    }

    public SimpleIntegerProperty bProperty() {
        return b;
    }

    public void setB(int b) {
        this.b.set(b);
    }
}
