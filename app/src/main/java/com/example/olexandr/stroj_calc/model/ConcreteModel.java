package com.example.olexandr.stroj_calc.model;

import android.graphics.drawable.Drawable;

/**
 * Created by olexandr on 24.01.16.
 */
public class ConcreteModel {
    int item;
    int icon;




    public int getIcon() {
        return icon;
    }

    public int getItem() {

        return item;
    }

    public ConcreteModel(int _item, int _icon) {
        this.item = _item;
        this.icon = _icon;

    }


}
