import{_ as n,o as s,c as a,a as t}from"./app-d6f5df65.js";const p={},e=t(`<h1 id="integerbinding自定义绑定计算" tabindex="-1"><a class="header-anchor" href="#integerbinding自定义绑定计算" aria-hidden="true">#</a> IntegerBinding自定义绑定计算</h1><ol><li><p>继承<code>IntegerBinding</code></p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code><span class="token keyword">class</span> <span class="token class-name">MyIntegerBinding</span> <span class="token keyword">extends</span> <span class="token class-name">IntegerBinding</span><span class="token punctuation">{</span>  
    <span class="token keyword">private</span> <span class="token class-name">SimpleIntegerProperty</span> value <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">SimpleIntegerProperty</span><span class="token punctuation">(</span><span class="token number">0</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  

    <span class="token keyword">public</span> <span class="token class-name">MyIntegerBinding</span><span class="token punctuation">(</span><span class="token class-name">Integer</span> value<span class="token punctuation">)</span><span class="token punctuation">{</span>  
        <span class="token keyword">this</span><span class="token punctuation">.</span><span class="token function">bind</span><span class="token punctuation">(</span><span class="token keyword">this</span><span class="token punctuation">.</span>value<span class="token punctuation">)</span><span class="token punctuation">;</span>  
        <span class="token keyword">this</span><span class="token punctuation">.</span>value<span class="token punctuation">.</span><span class="token function">set</span><span class="token punctuation">(</span>value<span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  

    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token class-name">Integer</span> <span class="token function">getValue</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">return</span> value<span class="token punctuation">.</span><span class="token function">get</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  

    <span class="token keyword">public</span> <span class="token class-name">SimpleIntegerProperty</span> <span class="token function">valueProperty</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">return</span> value<span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  

    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">setValue</span><span class="token punctuation">(</span><span class="token class-name">Integer</span> value<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">this</span><span class="token punctuation">.</span>value<span class="token punctuation">.</span><span class="token function">set</span><span class="token punctuation">(</span>value<span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  

    <span class="token doc-comment comment">/**  
  * 自定义绑定计算  
  * <span class="token keyword">@return</span> 计算结果  
  */</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">protected</span> <span class="token keyword">int</span> <span class="token function">computeValue</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">return</span> <span class="token keyword">this</span><span class="token punctuation">.</span>value<span class="token punctuation">.</span><span class="token function">get</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token operator">*</span><span class="token number">4</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div></li><li><p>测试代码</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code><span class="token class-name">SimpleIntegerProperty</span> integerProperty <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">SimpleIntegerProperty</span><span class="token punctuation">(</span><span class="token number">10</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">MyIntegerBinding</span> integerBinding <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">MyIntegerBinding</span><span class="token punctuation">(</span><span class="token number">20</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;integerProperty.get() = &quot;</span> <span class="token operator">+</span> integerProperty<span class="token punctuation">.</span><span class="token function">get</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;integerBinding.get() = &quot;</span> <span class="token operator">+</span> integerBinding<span class="token punctuation">.</span><span class="token function">get</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
integerProperty<span class="token punctuation">.</span><span class="token function">bind</span><span class="token punctuation">(</span>integerBinding<span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;integerProperty.get() = &quot;</span> <span class="token operator">+</span> integerProperty<span class="token punctuation">.</span><span class="token function">get</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;integerBinding.get() = &quot;</span> <span class="token operator">+</span> integerBinding<span class="token punctuation">.</span><span class="token function">get</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
integerBinding<span class="token punctuation">.</span><span class="token function">setValue</span><span class="token punctuation">(</span><span class="token number">35</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;integerProperty.get() = &quot;</span> <span class="token operator">+</span> integerProperty<span class="token punctuation">.</span><span class="token function">get</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;integerBinding.get() = &quot;</span> <span class="token operator">+</span> integerBinding<span class="token punctuation">.</span><span class="token function">get</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><blockquote><p>integerProperty.get() = 10<br> integerBinding.get() = 80<br> integerProperty.get() = 80<br> integerBinding.get() = 80<br> integerProperty.get() = 140<br> integerBinding.get() = 140</p></blockquote></li></ol>`,2),o=[e];function c(i,l){return s(),a("div",null,o)}const k=n(p,[["render",c],["__file","lesson063.html.vue"]]);export{k as default};
