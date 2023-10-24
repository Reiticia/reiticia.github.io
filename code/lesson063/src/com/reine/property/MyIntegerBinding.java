package com.reine.property;

import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.SimpleIntegerProperty;

public class MyIntegerBinding extends IntegerBinding {
    private SimpleIntegerProperty value = new SimpleIntegerProperty(0);

    public MyIntegerBinding(Integer value){
        this.bind(this.value);
        this.value.set(value);
    }

    @Override
    public Integer getValue() {
        return value.get();
    }

    public SimpleIntegerProperty valueProperty() {
        return value;
    }

    public void setValue(Integer value) {
        this.value.set(value);
    }

    /**
     * 自定义绑定计算
     * @return 计算结果
     */
    @Override
    protected int computeValue() {
        return this.value.get()*4;
    }
}
