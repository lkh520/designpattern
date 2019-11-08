# JAVA23种设计模式及面向对象设计的原则

## 1.原则
>在软件开发中，为了提高软件系统的可维护性和可复用性，增加软件的可扩展性和灵活性，程序员要尽量根据 7 条原则来开发程序，从而提高软件开发效率、节约软件开发成本和维护成本。

>里氏替换原则告诉我们不要破坏继承体系；依赖倒置原则告诉我们要面向接口编程；单一职责原则告诉我们实现类要职责单一；接口隔离原则告诉我们在设计接口的时候要精简单一；迪米特法则告诉我们要降低耦合；组合复用法则告诉我们尽量使用组合而非继承。而开闭原则是总纲，他告诉我们要对扩展开放，对修改关闭
### 面向对象设计的7 条原则详解
>>[开闭原则——面向对象设计原则](document/principle/1.md)</br  >
>>[里氏替换原则——面向对象设计原则](document/principle/2.md)</br  >
>>[依赖倒置原则——面向对象设计原则](document/principle/3.md)</br  >
>>[单一职责原则——面向对象设计原则](document/principle/4.md)</br  >
>>[接口隔离原则——面向对象设计原则](document/principle/5.md)</br  >
>>[迪米特法则——面向对象设计原则](document/principle/6.md)</br  >
>>[组合复用法则——面向对象设计原则](document/principle/7.md)</br  >

## 2.模式

<table  border="1" >
<tbody><tr><th style="width:5%;">序号</th><th style="width:45%;">模式 &amp; 描述</th><th>包括</th></tr>
<tr><td align="center">1</td><td><b>创建型模式</b><br>这些设计模式提供了一种在创建对象的同时隐藏创建逻辑的方式，而不是使用 new 运算符直接实例化对象。这使得程序在判断针对某个给定实例需要创建哪些对象时更加灵活。</td>
<td>
<ul>
<li>工厂模式（Factory Pattern）</li>
<li>抽象工厂模式（Abstract Factory Pattern）</li>
<li><a href="design-mode/singleton/README.md">单例模式（Singleton Pattern）</a></li>
<li>建造者模式（Builder Pattern）</li>
<li>原型模式（Prototype Pattern）</li>
</ul>
</td>
</tr>
<tr><td align="center">2</td><td><b>结构型模式</b><br>这些设计模式关注类和对象的组合。继承的概念被用来组合接口和定义组合对象获得新功能的方式。</td>
<td>
<ul>
<li>适配器模式（Adapter Pattern）</li>
<li>桥接模式（Bridge Pattern）</li>
<li>过滤器模式（Filter、Criteria Pattern）</li>
<li>组合模式（Composite Pattern）</li>
<li>装饰器模式（Decorator Pattern）</li>
<li>外观模式（Facade Pattern）</li>
<li>享元模式（Flyweight Pattern）</li>
<li>代理模式（Proxy Pattern）</li>
</ul>
</td>
</tr>
<tr><td align="center">3</td><td><b>行为型模式</b><br>这些设计模式特别关注对象之间的通信。</td>
<td>
<ul>
<li>责任链模式（Chain of Responsibility Pattern）</li>
<li>命令模式（Command Pattern）</li>
<li>解释器模式（Interpreter Pattern）</li>
<li>迭代器模式（Iterator Pattern）</li>
<li>中介者模式（Mediator Pattern）</li>
<li>备忘录模式（Memento Pattern）</li>
<li>观察者模式（Observer Pattern）</li>
<li>状态模式（State Pattern）</li>
<li>空对象模式（Null Object Pattern）</li>
<li>策略模式（Strategy Pattern）</li>
<li>模板模式（Template Pattern）</li>
<li>访问者模式（Visitor Pattern）</li>
</ul>
</td>
</tr>
<tr><td align="center">4</td><td><b>J2EE 模式</b><br>这些设计模式特别关注表示层。这些模式是由 Sun Java Center 鉴定的。</td>
<td>
<ul>
<li>MVC 模式（MVC Pattern）</li>
<li>业务代表模式（Business Delegate Pattern）</li>
<li>组合实体模式（Composite Entity Pattern）</li>
<li>数据访问对象模式（Data Access Object Pattern）</li>
<li>前端控制器模式（Front Controller Pattern）</li>
<li>拦截过滤器模式（Intercepting Filter Pattern）</li>
<li>服务定位器模式（Service Locator Pattern）</li>
<li>传输对象模式（Transfer Object Pattern）</li>
</ul>
</td>
</tr>
</tbody></table>

### 23种设计模式详解
>>