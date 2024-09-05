import{_ as n,o as s,c as a,a as t}from"./app-d6f5df65.js";const p={},e=t(`<h1 id="键盘事件" tabindex="-1"><a class="header-anchor" href="#键盘事件" aria-hidden="true">#</a> 键盘事件</h1><h2 id="键盘按下事件-如果按下按键不放-则会多次触发监听" tabindex="-1"><a class="header-anchor" href="#键盘按下事件-如果按下按键不放-则会多次触发监听" aria-hidden="true">#</a> 键盘按下事件（如果按下按键不放，则会多次触发监听）</h2><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code>button1<span class="token punctuation">.</span><span class="token function">setOnKeyPressed</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">EventHandler</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">KeyEvent</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">handle</span><span class="token punctuation">(</span><span class="token class-name">KeyEvent</span> event<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;event.getCharacter() = &quot;</span> <span class="token operator">+</span> event<span class="token punctuation">.</span><span class="token function">getCharacter</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
        <span class="token comment">// 事件类型  </span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;event.getEventType() = &quot;</span> <span class="token operator">+</span> event<span class="token punctuation">.</span><span class="token function">getEventType</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
        <span class="token comment">// 事件源  </span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;event.getSource() = &quot;</span> <span class="token operator">+</span> event<span class="token punctuation">.</span><span class="token function">getSource</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
        <span class="token comment">// 事件目标  </span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;event.getTarget() = &quot;</span> <span class="token operator">+</span> event<span class="token punctuation">.</span><span class="token function">getTarget</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
        <span class="token comment">// 获得按下的按键名称  </span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;event.getText() = &quot;</span> <span class="token operator">+</span> event<span class="token punctuation">.</span><span class="token function">getText</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;event.isControlDown() = &quot;</span> <span class="token operator">+</span> event<span class="token punctuation">.</span><span class="token function">isControlDown</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
        <span class="token comment">// 判断按下的按键  </span>
        <span class="token keyword">if</span> <span class="token punctuation">(</span>event<span class="token punctuation">.</span><span class="token function">getCode</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">==</span> <span class="token class-name">KeyCode</span><span class="token punctuation">.</span><span class="token constant">SPACE</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
            <span class="token keyword">if</span> <span class="token punctuation">(</span>iTime<span class="token punctuation">.</span><span class="token function">get</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">&lt;=</span> <span class="token number">100</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
                iTime<span class="token punctuation">.</span><span class="token function">set</span><span class="token punctuation">(</span>iTime<span class="token punctuation">.</span><span class="token function">get</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">+</span> <span class="token number">1</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
            <span class="token punctuation">}</span>  
            <span class="token keyword">if</span> <span class="token punctuation">(</span>dTime<span class="token punctuation">.</span><span class="token function">get</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">&lt;=</span> <span class="token number">1</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
                dTime<span class="token punctuation">.</span><span class="token function">set</span><span class="token punctuation">(</span>dTime<span class="token punctuation">.</span><span class="token function">get</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">+</span> <span class="token number">0.01</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
            <span class="token punctuation">}</span>  
        <span class="token punctuation">}</span>  
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;按下了&quot;</span> <span class="token operator">+</span> event<span class="token punctuation">.</span><span class="token function">getCode</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">getName</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
<span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h2 id="松开按键事件" tabindex="-1"><a class="header-anchor" href="#松开按键事件" aria-hidden="true">#</a> 松开按键事件</h2><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code>button1<span class="token punctuation">.</span><span class="token function">setOnKeyReleased</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">EventHandler</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">KeyEvent</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">handle</span><span class="token punctuation">(</span><span class="token class-name">KeyEvent</span> event<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;释放了&quot;</span> <span class="token operator">+</span> event<span class="token punctuation">.</span><span class="token function">getCode</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">getName</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
        <span class="token keyword">if</span> <span class="token punctuation">(</span>event<span class="token punctuation">.</span><span class="token function">getCode</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">==</span> <span class="token class-name">KeyCode</span><span class="token punctuation">.</span><span class="token constant">SPACE</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
            iTime<span class="token punctuation">.</span><span class="token function">set</span><span class="token punctuation">(</span><span class="token number">0</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
            dTime<span class="token punctuation">.</span><span class="token function">set</span><span class="token punctuation">(</span><span class="token number">0</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
        <span class="token punctuation">}</span>  
    <span class="token punctuation">}</span>  
<span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h2 id="作用于有输入焦点的组件的监听器" tabindex="-1"><a class="header-anchor" href="#作用于有输入焦点的组件的监听器" aria-hidden="true">#</a> 作用于有输入焦点的组件的监听器</h2><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code>textField<span class="token punctuation">.</span><span class="token function">setOnKeyTyped</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">EventHandler</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">KeyEvent</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">handle</span><span class="token punctuation">(</span><span class="token class-name">KeyEvent</span> event<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">&quot;event.getCharacter() = &quot;</span> <span class="token operator">+</span> event<span class="token punctuation">.</span><span class="token function">getCharacter</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
<span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div>`,7),o=[e];function c(u,l){return s(),a("div",null,o)}const k=n(p,[["render",c],["__file","lesson072.html.vue"]]);export{k as default};
