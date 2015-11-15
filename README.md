This will help to understand implementation of sliding and push menu for angular js.
##Pre-Requisite:
1. https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js
2. https://code.angularjs.org/1.4.7/angular-animate.min.js

Here we have created two menu's <br>
1. Sliding menu for left and right<br>
2. Push menu for left and right

### Menu Position (Left or Right)
For left side push & sliding  menu, we are applying css classes 'menu menu-vertical menu-left' on <nav> element. 
```
<nav class="menu menu-vertical menu-left" id="menu">
</nav>
```
In the same way for right side push & sliding menu, we need to apply css classes 'menu menu-vertical menu-right' on <nav> element.
```
<nav class="menu menu-vertical menu-right" id="menu">
</nav>
```
###Sliding Menu
For sliding menu effect we have created angular directive 'menu' which will help to provide sliding effect. all we need to do is just include 'menu' attribute in button. which will be used to show and hide 
menu.
#Example: 
```
<a menu>Sliding Menu</a>
```

###Push Menu
for push menu first we need to apply css class 'menu-push' to the parent or body element. In our example we have applied it to body element.
Here we have created a 'menupush' directive which provides push effect.
#Example: 
```
<body class="menu-push">
	<a menupush>Push Menu</a>
	#include nav element
</body>
```

You can download these files on your system for demo.


