[Go](http://golang.org/) is around since 2007 and has matured into an interesting language. It is a *strong typed*, *compiled* and *Unicode safe* language that has been designed as a systems language, but provides basic packages that are enough for a web ecosystem to develop around it.

Thus, **Go** provides a built-in web server that takes advantage of it's unique multi-threading paradigm based on channels. Anyone who has written at least one small utility that makes use of multi-threading in any other language knows that it is a tedious and error-prone task. Some other modern languages have followed the path opened by Go and now implement similar mechanisms due to it's unparalleled simplicity. Also, Go has basic primitives for *request* and *response*, a *routing* mechanism and a simple template system, which makes it ready for web development.

Two other features of Go that make it attractive are the ability to use online code using the *go get* utility and the automatic code formatting provided by *gofmt*.

To improve on the missing features of the basic http package, some interesting frameworks have emerged. We are keeping an eye on [web.go](http://www.webgo.io) and [Martini](http://martini.codegangsta.io/).
