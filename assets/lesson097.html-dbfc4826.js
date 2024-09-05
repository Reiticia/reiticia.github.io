import{_ as n,o as s,c as a,a as t}from"./app-d6f5df65.js";const p="/assets/Pasted image 20220606152405-a8786c6c.png",e="/assets/Pasted image 20220606152503-da5e30df.png",o="/assets/Pasted image 20220606162535-5a4a4ea9.png",c="/assets/Pasted image 20220606162636-c5e39985.png",l="/assets/Pasted image 20220606162749-d41685be.png",u={},i=t(`<h1 id="tableview5中内置的tablecell" tabindex="-1"><a class="header-anchor" href="#tableview5中内置的tablecell" aria-hidden="true">#</a> TableView5中内置的TableCell</h1><ul><li><p>设置列排列方式<code>tableView.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);</code></p></li><li><p>创建tableView和添加列</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code><span class="token class-name">TableView</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">StudentProperty</span><span class="token punctuation">&gt;</span></span> tableView <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">TableView</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span>list<span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token comment">// 每一列  </span>
<span class="token class-name">TableColumn</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">StudentProperty</span><span class="token punctuation">,</span> <span class="token class-name">String</span><span class="token punctuation">&gt;</span></span> nameCol <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">TableColumn</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token string">&quot;姓名&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
nameCol<span class="token punctuation">.</span><span class="token function">setCellValueFactory</span><span class="token punctuation">(</span>cellData <span class="token operator">-&gt;</span> cellData<span class="token punctuation">.</span><span class="token function">getValue</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">nameProperty</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token comment">// 对于数字类型的字段必须，必须使用其抽象类Number定义泛型  </span>
<span class="token class-name">TableColumn</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">StudentProperty</span><span class="token punctuation">,</span> <span class="token class-name">Number</span><span class="token punctuation">&gt;</span></span> ageCol <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">TableColumn</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token string">&quot;年龄&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
ageCol<span class="token punctuation">.</span><span class="token function">setCellValueFactory</span><span class="token punctuation">(</span>cellData <span class="token operator">-&gt;</span> cellData<span class="token punctuation">.</span><span class="token function">getValue</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">ageProperty</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token comment">// TableColumn&lt;StudentProperty, Number&gt; scoreCol = new TableColumn&lt;&gt;(&quot;成绩&quot;);  </span>
<span class="token comment">// scoreCol.setCellValueFactory(cellData -&gt; cellData.getValue().scoreProperty());  </span>
<span class="token comment">// 此行用于替换上面两行，为了下面ProgressBarTableCell的演示  </span>
<span class="token class-name">TableColumn</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">StudentProperty</span><span class="token punctuation">,</span> <span class="token class-name">Double</span><span class="token punctuation">&gt;</span></span> scoreCol <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">TableColumn</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token string">&quot;充能&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
scoreCol<span class="token punctuation">.</span><span class="token function">setCellValueFactory</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">PropertyValueFactory</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token string">&quot;score&quot;</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token class-name">TableColumn</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">StudentProperty</span><span class="token punctuation">,</span> <span class="token class-name">Boolean</span><span class="token punctuation">&gt;</span></span> isBoyCol <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">TableColumn</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token string">&quot;性别&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
isBoyCol<span class="token punctuation">.</span><span class="token function">setCellValueFactory</span><span class="token punctuation">(</span>cellData <span class="token operator">-&gt;</span> cellData<span class="token punctuation">.</span><span class="token function">getValue</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">genderProperty</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div></li><li><p>设置可编辑<code>tableView.setEditable(true);</code></p></li><li><p>TextFieldTableCell</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code>nameCol<span class="token punctuation">.</span><span class="token function">setCellFactory</span><span class="token punctuation">(</span><span class="token class-name">TextFieldTableCell</span><span class="token punctuation">.</span><span class="token function">forTableColumn</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">StringConverter</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">String</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">toString</span><span class="token punctuation">(</span><span class="token class-name">String</span> object<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">return</span> object<span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">fromString</span><span class="token punctuation">(</span><span class="token class-name">String</span> string<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">return</span> string<span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
<span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p>效果图 <img src="`+p+`" alt=""></p></li><li><p>ChoiceBoxTableCell</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code>ageCol<span class="token punctuation">.</span><span class="token function">setCellFactory</span><span class="token punctuation">(</span><span class="token class-name">ChoiceBoxTableCell</span><span class="token punctuation">.</span><span class="token function">forTableColumn</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">StringConverter</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Number</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">toString</span><span class="token punctuation">(</span><span class="token class-name">Number</span> object<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">if</span> <span class="token punctuation">(</span>object <span class="token operator">==</span> <span class="token keyword">null</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
            <span class="token keyword">return</span> <span class="token keyword">null</span><span class="token punctuation">;</span>  
        <span class="token punctuation">}</span>  
        <span class="token keyword">return</span> object<span class="token punctuation">.</span><span class="token function">toString</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token class-name">Number</span> <span class="token function">fromString</span><span class="token punctuation">(</span><span class="token class-name">String</span> string<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">return</span> <span class="token keyword">new</span> <span class="token class-name">Integer</span><span class="token punctuation">(</span>string<span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
<span class="token punctuation">}</span><span class="token punctuation">,</span> <span class="token number">15</span><span class="token punctuation">,</span> <span class="token number">16</span><span class="token punctuation">,</span> <span class="token number">17</span><span class="token punctuation">,</span> <span class="token number">18</span><span class="token punctuation">,</span> <span class="token number">19</span><span class="token punctuation">,</span> <span class="token number">20</span><span class="token punctuation">,</span> <span class="token number">21</span><span class="token punctuation">,</span> <span class="token number">22</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p>效果图 <img src="`+e+`" alt=""></p></li><li><p>ProgressBarTableCell</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code>scoreCol<span class="token punctuation">.</span><span class="token function">setCellFactory</span><span class="token punctuation">(</span><span class="token class-name">ProgressBarTableCell</span><span class="token punctuation">.</span><span class="token function">forTableColumn</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div></div></div><p>效果图 <img src="`+o+`" alt=""></p></li><li><p>ComboBoxTableCell</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code>isBoyCol<span class="token punctuation">.</span><span class="token function">setCellFactory</span><span class="token punctuation">(</span><span class="token class-name">ComboBoxTableCell</span><span class="token punctuation">.</span><span class="token function">forTableColumn</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">StringConverter</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Boolean</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">toString</span><span class="token punctuation">(</span><span class="token class-name">Boolean</span> object<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">return</span> object <span class="token operator">?</span> <span class="token string">&quot;男&quot;</span> <span class="token operator">:</span> <span class="token string">&quot;女&quot;</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">public</span> <span class="token class-name">Boolean</span> <span class="token function">fromString</span><span class="token punctuation">(</span><span class="token class-name">String</span> string<span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">return</span> string<span class="token punctuation">.</span><span class="token function">equals</span><span class="token punctuation">(</span><span class="token string">&quot;男&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
<span class="token punctuation">}</span><span class="token punctuation">,</span> <span class="token boolean">true</span><span class="token punctuation">,</span> <span class="token boolean">false</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p>效果图 <img src="`+c+`" alt=""></p></li><li><p>CheckBoxTableCell</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code>isBoyCol<span class="token punctuation">.</span><span class="token function">setCellFactory</span><span class="token punctuation">(</span><span class="token class-name">CheckBoxTableCell</span><span class="token punctuation">.</span><span class="token function">forTableColumn</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">TableColumn</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div></div></div><p>效果图 <img src="`+l+`" alt=""></p></li></ul><h2 id="使用定时任务使进度条-progressbartablecell-加载" tabindex="-1"><a class="header-anchor" href="#使用定时任务使进度条-progressbartablecell-加载" aria-hidden="true">#</a> 使用定时任务使进度条（ProgressBarTableCell）加载</h2><ol><li><p>自定义定时任务类</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code><span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">MyService</span> <span class="token keyword">extends</span> <span class="token class-name">ScheduledService</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Double</span><span class="token punctuation">&gt;</span></span> <span class="token punctuation">{</span>  
    <span class="token keyword">double</span> value <span class="token operator">=</span> <span class="token number">0</span><span class="token punctuation">;</span>  

    <span class="token annotation punctuation">@Override</span>  
    <span class="token keyword">protected</span> <span class="token class-name">Task</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Double</span><span class="token punctuation">&gt;</span></span> <span class="token function">createTask</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
        <span class="token keyword">return</span> <span class="token keyword">new</span> <span class="token class-name">Task</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Double</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
            <span class="token annotation punctuation">@Override</span>  
            <span class="token keyword">protected</span> <span class="token class-name">Double</span> <span class="token function">call</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">Exception</span> <span class="token punctuation">{</span>  
                value <span class="token operator">+=</span> <span class="token number">0.1</span><span class="token punctuation">;</span>  
                <span class="token keyword">return</span> value<span class="token punctuation">;</span>  
            <span class="token punctuation">}</span>  
        <span class="token punctuation">}</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span>  
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div></li><li><p>设置参数并启动</p><div class="language-java line-numbers-mode" data-ext="java"><pre class="language-java"><code><span class="token class-name">MyService</span> service <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">MyService</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
service<span class="token punctuation">.</span><span class="token function">setDelay</span><span class="token punctuation">(</span><span class="token class-name">Duration</span><span class="token punctuation">.</span><span class="token constant">ZERO</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
service<span class="token punctuation">.</span><span class="token function">setPeriod</span><span class="token punctuation">(</span><span class="token class-name">Duration</span><span class="token punctuation">.</span><span class="token function">seconds</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
service<span class="token punctuation">.</span><span class="token function">valueProperty</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">addListener</span><span class="token punctuation">(</span><span class="token punctuation">(</span>observable<span class="token punctuation">,</span> oldValue<span class="token punctuation">,</span> newValue<span class="token punctuation">)</span> <span class="token operator">-&gt;</span> <span class="token punctuation">{</span>  
    <span class="token class-name">Optional</span><span class="token punctuation">.</span><span class="token function">ofNullable</span><span class="token punctuation">(</span>newValue<span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">ifPresent</span><span class="token punctuation">(</span>aDouble <span class="token operator">-&gt;</span> <span class="token punctuation">{</span>  
        <span class="token keyword">if</span> <span class="token punctuation">(</span>aDouble <span class="token operator">&gt;</span> <span class="token number">1.0</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>  
            service<span class="token punctuation">.</span><span class="token function">cancel</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
            <span class="token keyword">new</span> <span class="token class-name">Alert</span><span class="token punctuation">(</span><span class="token class-name">Alert<span class="token punctuation">.</span>AlertType</span><span class="token punctuation">.</span><span class="token constant">INFORMATION</span><span class="token punctuation">,</span> <span class="token string">&quot;充能完成&quot;</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">show</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
        <span class="token punctuation">}</span>  
        student1<span class="token punctuation">.</span><span class="token function">setScore</span><span class="token punctuation">(</span>newValue<span class="token punctuation">)</span><span class="token punctuation">;</span>  
    <span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>  
<span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div></li></ol>`,4),k=[i];function r(d,v){return s(),a("div",null,k)}const b=n(u,[["render",r],["__file","lesson097.html.vue"]]);export{b as default};
