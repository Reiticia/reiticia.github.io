import{_ as n,o as s,c as a,a as t}from"./app-d6f5df65.js";const p={},o=t(`<h1 id="rotate旋转" tabindex="-1"><a class="header-anchor" href="#rotate旋转" aria-hidden="true">#</a> Rotate旋转</h1><ul><li><p>以组件(100,100)的位置为中心，顺时针旋转45°<code>Rotate rotate = new Rotate(45, 100, 100);</code></p></li><li><p>以组件(0,0)的位置为中心(即左上角)，逆时针旋转45°<code>Rotate rotate = new Rotate(-45, 0, 0);</code></p></li><li><p>设置旋转<code>button2.getTransforms().add(rotate);</code></p></li><li><p>设置旋转45°<code>button2.setRotate(45);</code></p></li><li><p>获取宽高</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code>button2<span class="token punctuation">.</span><span class="token function">setOnAction</span><span class="token punctuation">(</span>event <span class="token operator">-&gt;</span> <span class="token punctuation">{</span>  
    <span class="token comment">// 输出原始组件的宽高  </span>
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>button2<span class="token punctuation">.</span><span class="token function">getPrefWidth</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>button2<span class="token punctuation">.</span><span class="token function">getPrefHeight</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token comment">// 获取组件相对与父组件的位移量，获取到的是原始组件左上角变换后的坐标  </span>
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">printf</span><span class="token punctuation">(</span><span class="token string">&quot;相对于父组件的坐标：(%.2f,%.2f)\\n&quot;</span><span class="token punctuation">,</span> button2<span class="token punctuation">.</span><span class="token function">getLocalToParentTransform</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">getTx</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">,</span> button2<span class="token punctuation">.</span><span class="token function">getLocalToParentTransform</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">getTy</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token class-name">Bounds</span> bounds <span class="token operator">=</span> button2<span class="token punctuation">.</span><span class="token function">getLayoutBounds</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token class-name">Bounds</span> localToParent <span class="token operator">=</span> button2<span class="token punctuation">.</span><span class="token function">localToParent</span><span class="token punctuation">(</span>bounds<span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token comment">// 输出目视宽高  </span>
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;宽度：&quot;</span> <span class="token operator">+</span> localToParent<span class="token punctuation">.</span><span class="token function">getWidth</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;高度：&quot;</span> <span class="token operator">+</span> localToParent<span class="token punctuation">.</span><span class="token function">getHeight</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token comment">// 输出边框坐标  </span>
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">printf</span><span class="token punctuation">(</span><span class="token string">&quot;右下角边框相对于自身坐标为(%.2f,%.2f)\\n&quot;</span><span class="token punctuation">,</span> localToParent<span class="token punctuation">.</span><span class="token function">getMaxX</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">-</span> localToParent<span class="token punctuation">.</span><span class="token function">getMinX</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">,</span> localToParent<span class="token punctuation">.</span><span class="token function">getMaxY</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">-</span> localToParent<span class="token punctuation">.</span><span class="token function">getMinY</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><blockquote><p>200.0 200.0 相对于父组件的坐标：(200.00,58.58) 宽度：282.84271240234375 高度：282.84271240234375 右下角边框相对于自身坐标为(282.84,282.84)</p></blockquote></li></ul>`,2),c=[o];function e(u,l){return s(),a("div",null,c)}const k=n(p,[["render",e],["__file","lesson124.html.vue"]]);export{k as default};
