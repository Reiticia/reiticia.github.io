### 可观察List、Set、Map

#### List

* 创建List监视属性
  
  ```java
  ObservableList<String> list = FXCollections.observableArrayList();  
  for (int i = 0; i < 5; i++) {  
      list.add("item" + i);  
  }  
  SimpleListProperty<String> listProperty = new SimpleListProperty<>(list);
  ```

* 值监听
  
  ```java
  listProperty.addListener((observable, oldValue, newValue) -> {  
      // oldValue与newValue相同  
      oldValue.forEach(System.out::println);  
      System.out.println(Color.YELLOW + "--------------" + Color.RESET);  
      newValue.forEach(System.out::println);  
  });
  ```

* 方法监听
  
  ```java
  listProperty.addListener((ListChangeListener<String>) c -> {  
      // 具体操作  
      System.out.println(c);  
      // { [item5] added at 5 }  
      // 获得元素列表  
      System.out.println("c.getList() = " + c.getList());  
      // next方法必须于判断操作类型前调用，指向下一步操作  
      System.out.println("c.next() = " + c.next());  
      // c.reset();// 撤销c.next()操作 (下面测试中不包含此行代码) 
      // 判断操作类型  
      System.out.println("c.getFrom() = " + c.getFrom());  
      System.out.println("c.getTo() = " + c.getTo());  
      System.out.println("c.wasAdded() = " + c.wasAdded());  
      System.out.println("c.wasRemoved() = " + c.wasRemoved());  
      System.out.println("c.wasReplaced() = " + c.wasReplaced());  
      /* 
     当可观察列表list中的泛型为普通数据类型时基本为false；
     当可观察列表list中的泛型为监视属性时且创建list时指定了callback回调函数,
     则如果列表中监视属性的值发生改变，则返回true
    */
      System.out.println("c.wasUpdated() = " + c.wasUpdated());
      System.out.println("c.getAddedSubList() = " + c.getAddedSubList());// 获取增加或删除的元素列表  
      try {  
          System.out.println("c.wasPermutated() = " + c.wasPermutated());// 是否被排序  
          System.out.println("c.getPermutation(0) = " + c.getPermutation(0));// 获取原来索引为0的元素经过排序后的位置（索引）  
      } catch (IllegalStateException e) {  
          System.out.println(Color.RED + "没有进行排序操作" + Color.RESET);  
      }  
      System.out.println(Color.YELLOW + "----------------------------------" + Color.RESET);  
  });
  ```

* 添加元素`list.add("item5");`
  
  > { [item5] added at 5 }
  > c.getList() = ListProperty [value: [item0, item1, item2, item3, item4, item5]]
  > c.next() = true
  > c.getFrom() = 5
  > c.getTo() = 6
  > c.wasAdded() = true
  > c.wasRemoved() = false
  > c.wasReplaced() = false
  > c.wasUpdated() = false
  > c.getAddedSubList() = [item5]
  > c.wasPermutated() = false
  > 没有进行排序操作

* 追加测试`list.remove("item5");`
  
  > （省略上一条语句测试）
  > { [item5] removed at 5 }
  > c.getList() = ListProperty [value: [item0, item1, item2, item3, item4]]
  > c.next() = true
  > c.getFrom() = 5
  > c.getTo() = 5
  > c.wasAdded() = false
  > c.wasRemoved() = true
  > c.wasReplaced() = false
  > c.wasUpdated() = false
  > c.getAddedSubList() = []
  > c.wasPermutated() = false
  > 没有进行排序操作

* 追加测试`list.replaceAll(s -> s.replaceFirst("item1", "listItem1"));`
  
  > （省略上一条语句测试）
  > { [item0] replaced by [item0] at 0 }
  > c.getList() = ListProperty [value: [item0, item1, item2, item3, item4]]
  > c.next() = true
  > c.getFrom() = 0
  > c.getTo() = 1
  > c.wasAdded() = true
  > c.wasRemoved() = true
  > c.wasReplaced() = true
  > c.wasUpdated() = false
  > c.getAddedSubList() = [item0]
  > c.wasPermutated() = false
  > 
  > 没有进行排序操作
  > 
  > { [item1] replaced by [listItem1] at 1 }
  > c.getList() = ListProperty [value: [item0, listItem1, item2, item3, item4]]
  > c.next() = true
  > c.getFrom() = 1
  > c.getTo() = 2
  > c.wasAdded() = true
  > c.wasRemoved() = true
  > c.wasReplaced() = true
  > c.wasUpdated() = false
  > c.getAddedSubList() = [listItem1]
  > c.wasPermutated() = false
  > 
  > 没有进行排序操作
  > 
  > { [item2] replaced by [item2] at 2 }
  > c.getList() = ListProperty [value: [item0, listItem1, item2, item3, item4]]
  > c.next() = true
  > c.getFrom() = 2
  > c.getTo() = 3
  > c.wasAdded() = true
  > c.wasRemoved() = true
  > c.wasReplaced() = true
  > c.wasUpdated() = false
  > c.getAddedSubList() = [item2]
  > c.wasPermutated() = false
  > 
  > 没有进行排序操作
  > 
  > { [item3] replaced by [item3] at 3 }
  > c.getList() = ListProperty [value: [item0, listItem1, item2, item3, item4]]
  > c.next() = true
  > c.getFrom() = 3
  > c.getTo() = 4
  > c.wasAdded() = true
  > c.wasRemoved() = true
  > c.wasReplaced() = true
  > c.wasUpdated() = false
  > c.getAddedSubList() = [item3]
  > c.wasPermutated() = false
  > 
  > 没有进行排序操作
  > 
  > { [item4] replaced by [item4] at 4 }
  > c.getList() = ListProperty [value: [item0, listItem1, item2, item3, item4]]
  > c.next() = true
  > c.getFrom() = 4
  > c.getTo() = 5
  > c.wasAdded() = true
  > c.wasRemoved() = true
  > c.wasReplaced() = true
  > c.wasUpdated() = false
  > c.getAddedSubList() = [item4]
  > c.wasPermutated() = false
  > 
  > 没有进行排序操作
  
* 追加测试`list.set(3, "ListItem3");`
  
  > { [item3] replaced by [ListItem3] at 3 }
  > c.getList() = ListProperty [value: [item0, listItem1, item2, ListItem3, item4]]
  > c.next() = true
  > c.getFrom() = 3
  > c.getTo() = 4
  > c.wasAdded() = true
  > c.wasRemoved() = true
  > c.wasReplaced() = true
  > c.wasUpdated() = false
  > c.getAddedSubList() = [ListItem3]
  > c.wasPermutated() = false
  > 没有进行排序操作

* 追加测试`list.sort(String::compareTo);`
  
  > { permutated by [1, 4, 2, 0, 3] }
  > c.getList() = ListProperty [value: [ListItem3, item0, item2, item4, listItem1]]
  > c.next() = true
  > c.getFrom() = 0
  > c.getTo() = 5
  > c.wasAdded() = falsec.wasRemoved() = false
  > c.wasReplaced() = false
  > c.wasUpdated() = false
  > c.getAddedSubList() = []
  > c.wasPermutated() = true
  > c.getPermutation(0) = 1
  
  #### Set

* 创建Set监视属性
  
  ```java
  ObservableSet<String> set = FXCollections.observableSet("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");  
  SimpleSetProperty<String> setProperty = new SimpleSetProperty<>(set);
  ```

* 方法监听
  
  ```java
  setProperty.addListener((SetChangeListener<String>) change -> {  
    // 与list相同，但没有next方法  
  });
  ```

* 遍历
  
  ```java
  // iterator迭代器遍历
  Iterator<String> iterator = setProperty.iterator();  
  while (iterator.hasNext()) {  
      System.out.print(iterator.next());  
  }  
  // forEach遍历
  setProperty.forEach(System.out::print);
  ```
  
  #### Map

* 创建Map监视属性
  
  ```java
  ObservableMap<String, String> map = FXCollections.observableHashMap();  
  for (int i = 0; i < 26; i++) {  
      char c = (char) ('A' + i);  
      String s = Character.toString(c);  
      map.put(s, s.toLowerCase(Locale.ROOT));  
  }  
  SimpleMapProperty<String, String> mapProperty = new SimpleMapProperty<>(map);
  ```

* 遍历
  
  ```java
  mapProperty.forEach((s, s2) -> System.out.print(s + "-" + s2 + " "));
  ```