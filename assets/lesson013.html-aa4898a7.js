import{_ as n,o as s,c as a,a as t}from"./app-d6f5df65.js";const p="/assets/Pasted image 20220512111653-fbd27b09.png",o="/assets/Pasted image 20220512112100-d7c29dfd.png",c="/assets/VeryCapture_20220512114447-f0687e81.gif",e={},u=t(`<h1 id="anchorpane-布局-绝对布局" tabindex="-1"><a class="header-anchor" href="#anchorpane-布局-绝对布局" aria-hidden="true">#</a> AnchorPane 布局（绝对布局）</h1><ul><li><p>创建AnchorPane 布局<code>AnchorPane ap = new AnchorPane();</code></p></li><li><p>设置样式<code>ap.setStyle(&quot;-fx-background-color: red;&quot;);</code></p></li><li><p>设置鼠标点击事件</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code>ap<span class="token punctuation">.</span><span class="token function">setOnMouseClicked</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">EventHandler</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">MouseEvent</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">handle</span><span class="token punctuation">(</span><span class="token class-name">MouseEvent</span> event<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;click&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
<span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div></li><li><p>添加子组件和设置子组件位置</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code><span class="token class-name">Button</span> button <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Button</span><span class="token punctuation">(</span><span class="token string">&quot;btn0&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">Button</span> button1 <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Button</span><span class="token punctuation">(</span><span class="token string">&quot;btn1&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token comment">// 设置内边距，单独设置无效，需配合下面四行中的任意几行才有效果</span>
ap<span class="token punctuation">.</span><span class="token function">setPadding</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">Insets</span><span class="token punctuation">(</span><span class="token number">10</span><span class="token punctuation">,</span> <span class="token number">10</span><span class="token punctuation">,</span> <span class="token number">10</span><span class="token punctuation">,</span> <span class="token number">10</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token comment">// 管理子组件的位置，当父组件与子组件的设置冲突时，子组件设置无效</span>
<span class="token class-name">AnchorPane</span><span class="token punctuation">.</span><span class="token function">setTopAnchor</span><span class="token punctuation">(</span>button<span class="token punctuation">,</span> <span class="token number">10.0</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">AnchorPane</span><span class="token punctuation">.</span><span class="token function">setLeftAnchor</span><span class="token punctuation">(</span>button<span class="token punctuation">,</span> <span class="token number">10.0</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">AnchorPane</span><span class="token punctuation">.</span><span class="token function">setBottomAnchor</span><span class="token punctuation">(</span>button<span class="token punctuation">,</span> <span class="token number">10.0</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">AnchorPane</span><span class="token punctuation">.</span><span class="token function">setRightAnchor</span><span class="token punctuation">(</span>button<span class="token punctuation">,</span> <span class="token number">10.0</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token comment">// 无效设置  </span>
button<span class="token punctuation">.</span><span class="token function">setLayoutX</span><span class="token punctuation">(</span><span class="token number">20</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
button<span class="token punctuation">.</span><span class="token function">setLayoutY</span><span class="token punctuation">(</span><span class="token number">20</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
ap<span class="token punctuation">.</span><span class="token function">getChildren</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">addAll</span><span class="token punctuation">(</span>button<span class="token punctuation">,</span> button1<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p><img src="`+p+`" alt=""></p></li><li><p>添加group布局</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code><span class="token class-name">Button</span> button <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Button</span><span class="token punctuation">(</span><span class="token string">&quot;btn0&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">Button</span> button1 <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Button</span><span class="token punctuation">(</span><span class="token string">&quot;btn1&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">Group</span> group1 <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Group</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
group<span class="token punctuation">.</span><span class="token function">getChildren</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">add</span><span class="token punctuation">(</span>button<span class="token punctuation">)</span><span class="token punctuation">;</span>  
group1<span class="token punctuation">.</span><span class="token function">getChildren</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">add</span><span class="token punctuation">(</span>button1<span class="token punctuation">)</span><span class="token punctuation">;</span>  
ap<span class="token punctuation">.</span><span class="token function">getChildren</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">addAll</span><span class="token punctuation">(</span>group<span class="token punctuation">,</span> group1<span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">AnchorPane</span><span class="token punctuation">.</span><span class="token function">setTopAnchor</span><span class="token punctuation">(</span>group<span class="token punctuation">,</span> <span class="token number">10.0</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">AnchorPane</span><span class="token punctuation">.</span><span class="token function">setBottomAnchor</span><span class="token punctuation">(</span>group1<span class="token punctuation">,</span> <span class="token number">10.0</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p><img src="`+o+`" alt=""></p></li><li><p>添加AnchorPane布局</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code><span class="token comment">// 创建两个AnchorPane布局</span>
<span class="token class-name">AnchorPane</span> anchorPane <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">AnchorPane</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
anchorPane<span class="token punctuation">.</span><span class="token function">setStyle</span><span class="token punctuation">(</span><span class="token string">&quot;-fx-background-color: green;&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">AnchorPane</span> anchorPane1 <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">AnchorPane</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
anchorPane1<span class="token punctuation">.</span><span class="token function">setStyle</span><span class="token punctuation">(</span><span class="token string">&quot;-fx-background-color: yellow;&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
anchorPane<span class="token punctuation">.</span><span class="token function">getChildren</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">add</span><span class="token punctuation">(</span>anchorPane1<span class="token punctuation">)</span><span class="token punctuation">;</span>  
primaryStage<span class="token punctuation">.</span><span class="token function">setScene</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">Scene</span><span class="token punctuation">(</span>anchorPane<span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
primaryStage<span class="token punctuation">.</span><span class="token function">setTitle</span><span class="token punctuation">(</span><span class="token string">&quot;JavaFx&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
primaryStage<span class="token punctuation">.</span><span class="token function">setHeight</span><span class="token punctuation">(</span><span class="token number">300</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
primaryStage<span class="token punctuation">.</span><span class="token function">setWidth</span><span class="token punctuation">(</span><span class="token number">300</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
primaryStage<span class="token punctuation">.</span><span class="token function">show</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
anchorPane<span class="token punctuation">.</span><span class="token function">setTopAnchor</span><span class="token punctuation">(</span>anchorPane1<span class="token punctuation">,</span> <span class="token number">0.0</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
anchorPane<span class="token punctuation">.</span><span class="token function">setBottomAnchor</span><span class="token punctuation">(</span>anchorPane1<span class="token punctuation">,</span> anchorPane<span class="token punctuation">.</span><span class="token function">getHeight</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">/</span> <span class="token number">2</span> <span class="token operator">-</span> anchorPane1<span class="token punctuation">.</span><span class="token function">getHeight</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">/</span> <span class="token number">2</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
anchorPane<span class="token punctuation">.</span><span class="token function">setLeftAnchor</span><span class="token punctuation">(</span>anchorPane1<span class="token punctuation">,</span> <span class="token number">0.0</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
anchorPane<span class="token punctuation">.</span><span class="token function">setRightAnchor</span><span class="token punctuation">(</span>anchorPane1<span class="token punctuation">,</span> anchorPane<span class="token punctuation">.</span><span class="token function">getWidth</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">/</span> <span class="token number">2</span> <span class="token operator">-</span> anchorPane1<span class="token punctuation">.</span><span class="token function">getWidth</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">/</span> <span class="token number">2</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div></li><li><p>添加宽高属性监听器</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code>anchorPane<span class="token punctuation">.</span><span class="token function">heightProperty</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">addListener</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">ChangeListener</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Number</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">changed</span><span class="token punctuation">(</span><span class="token class-name">ObservableValue</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token operator">?</span> <span class="token keyword">extends</span> <span class="token class-name">Number</span><span class="token punctuation">&gt;</span></span> observable<span class="token punctuation">,</span> <span class="token class-name">Number</span> oldValue<span class="token punctuation">,</span> <span class="token class-name">Number</span> newValue<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        anchorPane<span class="token punctuation">.</span><span class="token function">setBottomAnchor</span><span class="token punctuation">(</span>anchorPane1<span class="token punctuation">,</span> anchorPane<span class="token punctuation">.</span><span class="token function">getHeight</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">/</span> <span class="token number">2</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
<span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
anchorPane<span class="token punctuation">.</span><span class="token function">widthProperty</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">addListener</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">ChangeListener</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Number</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">changed</span><span class="token punctuation">(</span><span class="token class-name">ObservableValue</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token operator">?</span> <span class="token keyword">extends</span> <span class="token class-name">Number</span><span class="token punctuation">&gt;</span></span> observable<span class="token punctuation">,</span> <span class="token class-name">Number</span> oldValue<span class="token punctuation">,</span> <span class="token class-name">Number</span> newValue<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        anchorPane<span class="token punctuation">.</span><span class="token function">setRightAnchor</span><span class="token punctuation">(</span>anchorPane1<span class="token punctuation">,</span> anchorPane<span class="token punctuation">.</span><span class="token function">getWidth</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">/</span> <span class="token number">2</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
<span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p><img src="`+c+'" alt=""></p></li></ul>',2),l=[u];function i(k,r){return s(),a("div",null,l)}const m=n(e,[["render",i],["__file","lesson013.html.vue"]]);export{m as default};
