import{_ as n,o as s,c as a,a as t}from"./app-d6f5df65.js";const p="/assets/Pasted image 20220603130603-6cddea22.png",e="/assets/Pasted image 20220603134357-beb12bba.png",c="/assets/Pasted image 20220603134738-ed028735.png",o="/assets/Pasted image 20220603135035-977bd0fa.png",l="/assets/Pasted image 20220603135224-76ce08f3.png",i="/assets/Pasted image 20220603135456-7a0159d2.png",u={},k=t('<h1 id="listview-中" tabindex="-1"><a class="header-anchor" href="#listview-中" aria-hidden="true">#</a> ListView（中）</h1><ul><li><p>设置每一个单元格的高度<code>listView.setFixedCellSize(50);</code></p></li><li><p>阻止获得焦点<code>listView.setFocusTraversable(false);</code></p></li><li><p>索引为2的元素默认获取焦点（可以和设置选中效果共存）<code>listView.getFocusModel().focus(2);</code></p></li><li><p>选中索引为0的元素</p><p>效果图 <img src="'+p+`" alt=""></p></li><li><p>自定义Callback用于展示和修改listView</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code><span class="token class-name">Callback</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">ListView</span><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">&gt;</span><span class="token punctuation">,</span> <span class="token class-name">ListCell</span><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">&gt;</span><span class="token punctuation">&gt;</span></span> cell <span class="token operator">=</span> <span class="token class-name">TextFieldListCell</span><span class="token punctuation">.</span><span class="token function">forListView</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">StringConverter</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">toString</span><span class="token punctuation">(</span><span class="token class-name">Data</span> object<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">if</span> <span class="token punctuation">(</span>object <span class="token operator">==</span> <span class="token keyword">null</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
            <span class="token keyword">return</span> <span class="token string">&quot;&quot;</span><span class="token punctuation">;</span>  
        <span class="token punctuation">}</span>  
        <span class="token keyword">return</span> object<span class="token punctuation">.</span><span class="token function">getName</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token class-name">Data</span> <span class="token function">fromString</span><span class="token punctuation">(</span><span class="token class-name">String</span> string<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">return</span> <span class="token keyword">new</span> <span class="token class-name">Data</span><span class="token punctuation">(</span>string<span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
<span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
listView<span class="token punctuation">.</span><span class="token function">setCellFactory</span><span class="token punctuation">(</span>cell<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div></li><li><p>设置选中要进行编辑索引为2的数据<code>listView.edit(2);</code></p></li><li><p>开始修改监听</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code>listView<span class="token punctuation">.</span><span class="token function">setOnEditStart</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">EventHandler</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">ListView<span class="token punctuation">.</span>EditEvent</span><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">&gt;</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">handle</span><span class="token punctuation">(</span><span class="token class-name">ListView<span class="token punctuation">.</span>EditEvent</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">&gt;</span></span> event<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;开始编辑&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;event.getIndex() = &quot;</span> <span class="token operator">+</span> event<span class="token punctuation">.</span><span class="token function">getIndex</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;event.getNewValue() = &quot;</span> <span class="token operator">+</span> event<span class="token punctuation">.</span><span class="token function">getNewValue</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
<span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div></li><li><p>取消编辑监听（当前选中项输入框被移除是调用，也就是不管有没有条件数据都会调用）</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code>listView<span class="token punctuation">.</span><span class="token function">setOnEditCancel</span><span class="token punctuation">(</span>event <span class="token operator">-&gt;</span> <span class="token punctuation">{</span>  
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;取消编辑&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div></li><li><p>完成编辑监听（使用该方法时需要手动设置新数据，该方法声明后会导致cell中的fromString方法失效）</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code>listView<span class="token punctuation">.</span><span class="token function">setOnEditCommit</span><span class="token punctuation">(</span>event <span class="token operator">-&gt;</span> <span class="token punctuation">{</span>  
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;完成编辑&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;event.getNewValue().getName() = &quot;</span> <span class="token operator">+</span> event<span class="token punctuation">.</span><span class="token function">getNewValue</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">getName</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token comment">// 设置新数据  </span>
    observableList<span class="token punctuation">.</span><span class="token function">set</span><span class="token punctuation">(</span>event<span class="token punctuation">.</span><span class="token function">getIndex</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">,</span> event<span class="token punctuation">.</span><span class="token function">getNewValue</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p>效果图 <img src="`+e+`" alt=""></p></li></ul><h2 id="其他几种编辑效果" tabindex="-1"><a class="header-anchor" href="#其他几种编辑效果" aria-hidden="true">#</a> 其他几种编辑效果</h2><ul><li><p>ComboBoxListCell</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code><span class="token class-name">Callback</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">ListView</span><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">&gt;</span><span class="token punctuation">,</span> <span class="token class-name">ListCell</span><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">&gt;</span><span class="token punctuation">&gt;</span></span> cell <span class="token operator">=</span> <span class="token class-name">ComboBoxListCell</span><span class="token punctuation">.</span><span class="token function">forListView</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">StringConverter</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">toString</span><span class="token punctuation">(</span><span class="token class-name">Data</span> object<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">return</span> object<span class="token punctuation">.</span><span class="token function">getName</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token class-name">Data</span> <span class="token function">fromString</span><span class="token punctuation">(</span><span class="token class-name">String</span> string<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">return</span> <span class="token keyword">new</span> <span class="token class-name">Data</span><span class="token punctuation">(</span>string<span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
<span class="token punctuation">}</span><span class="token punctuation">,</span> <span class="token keyword">new</span> <span class="token class-name">Data</span><span class="token punctuation">(</span><span class="token string">&quot;F&quot;</span><span class="token punctuation">)</span><span class="token punctuation">,</span> <span class="token keyword">new</span> <span class="token class-name">Data</span><span class="token punctuation">(</span><span class="token string">&quot;G&quot;</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
listView<span class="token punctuation">.</span><span class="token function">setCellFactory</span><span class="token punctuation">(</span>cell<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p>效果图 <img src="`+c+`" alt=""></p></li><li><p>传入可观察列表</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code><span class="token class-name">ObservableList</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">&gt;</span></span> observableList1 <span class="token operator">=</span> <span class="token class-name">FXCollections</span><span class="token punctuation">.</span><span class="token function">observableArrayList</span><span class="token punctuation">(</span>observableList<span class="token punctuation">.</span><span class="token function">subList</span><span class="token punctuation">(</span><span class="token number">0</span><span class="token punctuation">,</span> observableList<span class="token punctuation">.</span><span class="token function">size</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">Callback</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">ListView</span><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">&gt;</span><span class="token punctuation">,</span> <span class="token class-name">ListCell</span><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">&gt;</span><span class="token punctuation">&gt;</span></span> cell <span class="token operator">=</span> <span class="token class-name">ComboBoxListCell</span><span class="token punctuation">.</span><span class="token function">forListView</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">StringConverter</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">toString</span><span class="token punctuation">(</span><span class="token class-name">Data</span> object<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">return</span> object<span class="token punctuation">.</span><span class="token function">getName</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token class-name">Data</span> <span class="token function">fromString</span><span class="token punctuation">(</span><span class="token class-name">String</span> string<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">return</span> <span class="token keyword">new</span> <span class="token class-name">Data</span><span class="token punctuation">(</span>string<span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
<span class="token punctuation">}</span><span class="token punctuation">,</span> observableList1<span class="token punctuation">)</span><span class="token punctuation">;</span>
listView<span class="token punctuation">.</span><span class="token function">setCellFactory</span><span class="token punctuation">(</span>cell<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p>效果图 <img src="`+o+`" alt=""></p></li><li><p>ChoiceBoxListCell</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code><span class="token class-name">ObservableList</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">&gt;</span></span> observableList1 <span class="token operator">=</span> <span class="token class-name">FXCollections</span><span class="token punctuation">.</span><span class="token function">observableArrayList</span><span class="token punctuation">(</span>observableList<span class="token punctuation">.</span><span class="token function">subList</span><span class="token punctuation">(</span><span class="token number">0</span><span class="token punctuation">,</span> observableList<span class="token punctuation">.</span><span class="token function">size</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">Callback</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">ListView</span><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">&gt;</span><span class="token punctuation">,</span> <span class="token class-name">ListCell</span><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">&gt;</span><span class="token punctuation">&gt;</span></span> cell <span class="token operator">=</span> <span class="token class-name">ChoiceBoxListCell</span><span class="token punctuation">.</span><span class="token function">forListView</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">StringConverter</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">toString</span><span class="token punctuation">(</span><span class="token class-name">Data</span> object<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">return</span> object<span class="token punctuation">.</span><span class="token function">getName</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token class-name">Data</span> <span class="token function">fromString</span><span class="token punctuation">(</span><span class="token class-name">String</span> string<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">return</span> <span class="token keyword">new</span> <span class="token class-name">Data</span><span class="token punctuation">(</span>string<span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
<span class="token punctuation">}</span><span class="token punctuation">,</span> observableList1<span class="token punctuation">)</span><span class="token punctuation">;</span>
listView<span class="token punctuation">.</span><span class="token function">setCellFactory</span><span class="token punctuation">(</span>cell<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p>效果图 <img src="`+l+`" alt=""></p></li><li><p>CheckBoxListCell（设置除了B默认选中）<strong>使用此方法进行设置可以不用将listView设置为可编辑</strong></p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code><span class="token class-name">ObservableList</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">&gt;</span></span> observableList1 <span class="token operator">=</span> <span class="token class-name">FXCollections</span><span class="token punctuation">.</span><span class="token function">observableArrayList</span><span class="token punctuation">(</span>observableList<span class="token punctuation">.</span><span class="token function">subList</span><span class="token punctuation">(</span><span class="token number">0</span><span class="token punctuation">,</span> observableList<span class="token punctuation">.</span><span class="token function">size</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">Callback</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">ListView</span><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">&gt;</span><span class="token punctuation">,</span> <span class="token class-name">ListCell</span><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">&gt;</span><span class="token punctuation">&gt;</span></span> cell <span class="token operator">=</span> <span class="token class-name">CheckBoxListCell</span><span class="token punctuation">.</span><span class="token function">forListView</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">Callback</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">,</span> <span class="token class-name">ObservableValue</span><span class="token punctuation">&lt;</span><span class="token class-name">Boolean</span><span class="token punctuation">&gt;</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token class-name">ObservableValue</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Boolean</span><span class="token punctuation">&gt;</span></span> <span class="token function">call</span><span class="token punctuation">(</span><span class="token class-name">Data</span> param<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token class-name">SimpleBooleanProperty</span> sbp <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">SimpleBooleanProperty</span><span class="token punctuation">(</span><span class="token boolean">true</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
        <span class="token keyword">if</span> <span class="token punctuation">(</span>param<span class="token punctuation">.</span><span class="token function">getName</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">equals</span><span class="token punctuation">(</span><span class="token string">&quot;B&quot;</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
            sbp<span class="token punctuation">.</span><span class="token function">set</span><span class="token punctuation">(</span><span class="token boolean">false</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
        <span class="token punctuation">}</span>  
        <span class="token keyword">return</span> sbp<span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
<span class="token punctuation">}</span><span class="token punctuation">,</span> <span class="token keyword">new</span> <span class="token class-name">StringConverter</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Data</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">toString</span><span class="token punctuation">(</span><span class="token class-name">Data</span> object<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">return</span> object<span class="token punctuation">.</span><span class="token function">getName</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token class-name">Data</span> <span class="token function">fromString</span><span class="token punctuation">(</span><span class="token class-name">String</span> string<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">return</span> <span class="token keyword">new</span> <span class="token class-name">Data</span><span class="token punctuation">(</span>string<span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
<span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
listView<span class="token punctuation">.</span><span class="token function">setCellFactory</span><span class="token punctuation">(</span>cell<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p>效果图 <img src="`+i+'" alt=""></p></li></ul>',4),r=[k];function d(v,m){return s(),a("div",null,r)}const g=n(u,[["render",d],["__file","lesson083.html.vue"]]);export{g as default};
