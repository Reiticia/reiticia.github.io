import{_ as n,o as s,c as a,a as t}from"./app-d6f5df65.js";const p="/assets/Pasted image 20220616100213-aec29236.png",o={},c=t(`<h1 id="shadow阴影效果" tabindex="-1"><a class="header-anchor" href="#shadow阴影效果" aria-hidden="true">#</a> Shadow阴影效果</h1><ul><li><p>创建阴影<code>Shadow shadow = new Shadow();</code></p></li><li><p>通过叠加两个相同图层，但下面一层设置阴影效果来实现外阴影</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code><span class="token class-name">Button</span> button <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Button</span><span class="token punctuation">(</span><span class="token string">&quot;button&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">Label</span> label <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Label</span><span class="token punctuation">(</span><span class="token string">&quot;this is text.你好！&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">Rectangle</span> rectangle <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Rectangle</span><span class="token punctuation">(</span><span class="token number">100</span><span class="token punctuation">,</span> <span class="token number">100</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
rectangle<span class="token punctuation">.</span><span class="token function">setFill</span><span class="token punctuation">(</span><span class="token class-name">Color</span><span class="token punctuation">.</span><span class="token function">valueOf</span><span class="token punctuation">(</span><span class="token string">&quot;#ff9999&quot;</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">Circle</span> circle <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Circle</span><span class="token punctuation">(</span><span class="token number">50</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
circle<span class="token punctuation">.</span><span class="token function">setFill</span><span class="token punctuation">(</span><span class="token class-name">Color</span><span class="token punctuation">.</span><span class="token function">valueOf</span><span class="token punctuation">(</span><span class="token string">&quot;#996699&quot;</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">HBox</span> box <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">HBox</span><span class="token punctuation">(</span><span class="token number">50</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
box<span class="token punctuation">.</span><span class="token function">setAlignment</span><span class="token punctuation">(</span><span class="token class-name">Pos</span><span class="token punctuation">.</span><span class="token constant">CENTER</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
box<span class="token punctuation">.</span><span class="token function">getChildren</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">addAll</span><span class="token punctuation">(</span>button<span class="token punctuation">,</span> label<span class="token punctuation">,</span> rectangle<span class="token punctuation">,</span> circle<span class="token punctuation">)</span><span class="token punctuation">;</span>   
box<span class="token punctuation">.</span><span class="token function">getChildren</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">forEach</span><span class="token punctuation">(</span>node <span class="token operator">-&gt;</span> <span class="token punctuation">{</span>  
    node<span class="token punctuation">.</span><span class="token function">setEffect</span><span class="token punctuation">(</span><span class="token function">getEffect</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token comment">// 使用两个图层叠加产生阴影效果  </span>
<span class="token class-name">Button</span> button1 <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Button</span><span class="token punctuation">(</span><span class="token string">&quot;button&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">Label</span> label1 <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Label</span><span class="token punctuation">(</span><span class="token string">&quot;this is text.你好！&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">Rectangle</span> rectangle1 <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Rectangle</span><span class="token punctuation">(</span><span class="token number">100</span><span class="token punctuation">,</span> <span class="token number">100</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
rectangle1<span class="token punctuation">.</span><span class="token function">setFill</span><span class="token punctuation">(</span><span class="token class-name">Color</span><span class="token punctuation">.</span><span class="token function">valueOf</span><span class="token punctuation">(</span><span class="token string">&quot;#ff9999&quot;</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">Circle</span> circle1 <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Circle</span><span class="token punctuation">(</span><span class="token number">50</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
circle1<span class="token punctuation">.</span><span class="token function">setFill</span><span class="token punctuation">(</span><span class="token class-name">Color</span><span class="token punctuation">.</span><span class="token function">valueOf</span><span class="token punctuation">(</span><span class="token string">&quot;#996699&quot;</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">HBox</span> box1 <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">HBox</span><span class="token punctuation">(</span><span class="token number">50</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
box1<span class="token punctuation">.</span><span class="token function">setAlignment</span><span class="token punctuation">(</span><span class="token class-name">Pos</span><span class="token punctuation">.</span><span class="token constant">CENTER</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
box1<span class="token punctuation">.</span><span class="token function">getChildren</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">addAll</span><span class="token punctuation">(</span>button1<span class="token punctuation">,</span> label1<span class="token punctuation">,</span> rectangle1<span class="token punctuation">,</span> circle1<span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">AnchorPane</span> root <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">AnchorPane</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
root<span class="token punctuation">.</span><span class="token function">getChildren</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">addAll</span><span class="token punctuation">(</span>box<span class="token punctuation">,</span> box1<span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">AnchorPane</span><span class="token punctuation">.</span><span class="token function">setTopAnchor</span><span class="token punctuation">(</span>box<span class="token punctuation">,</span> <span class="token number">110.0</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">AnchorPane</span><span class="token punctuation">.</span><span class="token function">setLeftAnchor</span><span class="token punctuation">(</span>box<span class="token punctuation">,</span> <span class="token number">110.0</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">AnchorPane</span><span class="token punctuation">.</span><span class="token function">setTopAnchor</span><span class="token punctuation">(</span>box1<span class="token punctuation">,</span> <span class="token number">100.0</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">AnchorPane</span><span class="token punctuation">.</span><span class="token function">setLeftAnchor</span><span class="token punctuation">(</span>box1<span class="token punctuation">,</span> <span class="token number">100.0</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div></li></ul><p><img src="`+p+'" alt=""></p>',3),e=[c];function l(u,i){return s(),a("div",null,e)}const r=n(o,[["render",l],["__file","lesson148.html.vue"]]);export{r as default};
