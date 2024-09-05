import{_ as n,o as s,c as a,a as t}from"./app-d6f5df65.js";const p="/assets/Pasted image 20220617102007-ded08304.png",e={},c=t(`<h1 id="_2d图形-rectangle矩形" tabindex="-1"><a class="header-anchor" href="#_2d图形-rectangle矩形" aria-hidden="true">#</a> 2D图形 Rectangle矩形</h1><ul><li><p>创建矩形<code>Rectangle rectangle = new Rectangle();</code></p></li><li><p>设置位置<strong>如果父组件拥有对子组件的约束能力，则该设置无效</strong></p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code>rectangle<span class="token punctuation">.</span><span class="token function">setX</span><span class="token punctuation">(</span><span class="token number">100</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
rectangle<span class="token punctuation">.</span><span class="token function">setY</span><span class="token punctuation">(</span><span class="token number">100</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div></div></div></li><li><p>设置宽高</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code>rectangle<span class="token punctuation">.</span><span class="token function">setWidth</span><span class="token punctuation">(</span><span class="token number">200</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
rectangle<span class="token punctuation">.</span><span class="token function">setHeight</span><span class="token punctuation">(</span><span class="token number">100</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div></div></div></li><li><p>设置填充色<code>rectangle.setFill(Color.valueOf(&quot;#ff9999&quot;));</code></p></li><li><p>获取宽高</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code>rectangle<span class="token punctuation">.</span><span class="token function">setOnMouseClicked</span><span class="token punctuation">(</span>event <span class="token operator">-&gt;</span> <span class="token punctuation">{</span>  
    <span class="token keyword">if</span> <span class="token punctuation">(</span>event<span class="token punctuation">.</span><span class="token function">getClickCount</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token operator">&gt;</span><span class="token number">1</span><span class="token punctuation">)</span><span class="token punctuation">{</span>  
        <span class="token keyword">return</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
    <span class="token comment">// 这两个属性可以看出设置XY生效，但组件位置交由父组件管理，故效果没有呈现  </span>
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>rectangle<span class="token punctuation">.</span><span class="token function">getLayoutBounds</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>rectangle<span class="token punctuation">.</span><span class="token function">getBoundsInLocal</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>rectangle<span class="token punctuation">.</span><span class="token function">getBoundsInParent</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><blockquote><p>BoundingBox [minX:100.0, minY:100.0, minZ:0.0, width:200.0, height:100.0, depth:0.0, maxX:300.0, maxY:200.0, maxZ:0.0]<br> BoundingBox [minX:100.0, minY:100.0, minZ:0.0, width:200.0, height:100.0, depth:0.0, maxX:300.0, maxY:200.0, maxZ:0.0]<br> BoundingBox [minX:0.0, minY:0.0, minZ:0.0, width:200.0, height:100.0, depth:0.0, maxX:200.0, maxY:100.0, maxZ:0.0]</p></blockquote></li><li><p>设置圆角<strong>可以将圆角看为¼椭圆，横轴为arcWidth，纵轴为arcHeight</strong></p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code>rectangle1<span class="token punctuation">.</span><span class="token function">setArcWidth</span><span class="token punctuation">(</span><span class="token number">30</span><span class="token punctuation">)</span><span class="token punctuation">;</span> 
rectangle1<span class="token punctuation">.</span><span class="token function">setArcHeight</span><span class="token punctuation">(</span><span class="token number">30</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div></div></div></li><li><p>设置边框属性</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code>rectangle2<span class="token punctuation">.</span><span class="token function">setStroke</span><span class="token punctuation">(</span><span class="token class-name">Color</span><span class="token punctuation">.</span><span class="token function">valueOf</span><span class="token punctuation">(</span><span class="token string">&quot;#996699&quot;</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">// 设置边框颜色  </span>
rectangle2<span class="token punctuation">.</span><span class="token function">setStrokeWidth</span><span class="token punctuation">(</span><span class="token number">5</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">// 设置边框宽度  </span>
rectangle2<span class="token punctuation">.</span><span class="token function">setStrokeType</span><span class="token punctuation">(</span><span class="token class-name">StrokeType</span><span class="token punctuation">.</span><span class="token constant">INSIDE</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">// 设置边框类型  </span>
rectangle3<span class="token punctuation">.</span><span class="token function">getStrokeDashArray</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">addAll</span><span class="token punctuation">(</span><span class="token number">10.0</span><span class="token punctuation">,</span> <span class="token number">30.0</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">// 设置边框虚线</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div></li></ul><p><img src="`+p+'" alt=""></p>',3),o=[c];function l(u,i){return s(),a("div",null,o)}const d=n(e,[["render",l],["__file","lesson165.html.vue"]]);export{d as default};
