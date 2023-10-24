### IntegerBinding自定义绑定计算

1. 继承`IntegerBinding`
  
   ```java
   class MyIntegerBinding extends IntegerBinding{  
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
   ```

2. 测试代码
  
   ```java
   SimpleIntegerProperty integerProperty = new SimpleIntegerProperty(10);  
   MyIntegerBinding integerBinding = new MyIntegerBinding(20);  
   System.out.println("integerProperty.get() = " + integerProperty.get());  
   System.out.println("integerBinding.get() = " + integerBinding.get());  
   integerProperty.bind(integerBinding);  
   System.out.println("integerProperty.get() = " + integerProperty.get());  
   System.out.println("integerBinding.get() = " + integerBinding.get());  
   integerBinding.setValue(35);  
   System.out.println("integerProperty.get() = " + integerProperty.get());  
   System.out.println("integerBinding.get() = " + integerBinding.get());
   ```
   
   > integerProperty.get() = 10  
   > integerBinding.get() = 80  
   > integerProperty.get() = 80  
   > integerBinding.get() = 80  
   > integerProperty.get() = 140  
   > integerBinding.get() = 140  
