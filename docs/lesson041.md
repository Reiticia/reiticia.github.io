---
lang: zh-CN
title: setConverter和converterProperty().set
---



# setConverter和converterProperty().set

* setConverter使用
  
    ```java
    comboBox.setConverter(new StringConverter<String>() {  
        // 输出时处理每一项的方法
        @Override  
        public String toString(String object) {  
            return object+" - AO";  
        }  
        // 输入时处理每一项的方法
        @Override  
        public String fromString(String string) {  
            System.out.println(Color.GREEN + "setConverter");  
            return string + " - AI";  
        }  
    });
    ```

* converterProperty().set  

    **定义了此项会替代setConverter()方法的数据处理**
    
    ```java
    comboBox.converterProperty().set(new StringConverter<String>() {  
        @Override  
        public String toString(String object) {  
            return object + " - BO";  
        }  
        @Override  
        public String fromString(String string) {  
            System.out.println(Color.BLUE + "converterProperty");  
            return string+" - BI";  
        }  
    });
    ```

* setCellFactory

    **定义了此项会在初始渲染数据使用代替setConverter()和converterProperty().set()；但处理ComboBox自带输入框的输入数据和点击某一项进行展示时不会被调用**
    
    ```java
    comboBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {  
        @Override  
        public ListCell<String> call(ListView<String> param) {  
            ListCell<String> listCell = new ListCell<String>() {  
                @Override  
                protected void updateItem(String item, boolean empty) {  
                    // 如果删除了此行，则会导致下拉列表无法选择  
                    super.updateItem(item, empty);  
                    if (!empty) {  
                        System.out.println(Color.GREEN + "setCellFactory");  
                        this.setText(item + " - C");  
                    }  
                }  
            };  
            return listCell;  
        }  
    });
    ```

* cellFactoryProperty().set
    
    **定义了此项会替代setCellFactory()方法的数据处理**
    
    ```java
    comboBox.cellFactoryProperty().set(new Callback<ListView<String>, ListCell<String>>() {  
        @Override  
        public ListCell<String> call(ListView<String> param) {  
            ListCell<String> listCell = new ListCell<String>() {  
                @Override  
                protected void updateItem(String item, boolean empty) {  
                    // 如果删除了此行，则会导致下拉列表无法选择  
                    super.updateItem(item, empty);  
                    if (!empty) {  
                        System.out.println(Color.BLUE + "cellFactoryProperty");  
                        this.setText(item + " - D");  
                    }  
                }  
            };  
            return listCell;  
        }  
    });
    ```
