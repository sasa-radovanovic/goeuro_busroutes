# GoEuro bus challenge

This solution has been coded using SparkJava framework and Java 8.

I just want to make a note about .sh scripts. I had some problems with adapting service.sh to this solution (Due to nature of SparkJava [embedded Jetty server] - I always got wrong PID written to the file and therefore application couldn't be stoped using service.sh). 

Since I have limited time this weekend I went to "go-around" solution. I am aware that this is not the best solution. 

I did not have enough time to code Unit tests (I am aware that this is something which should have been done).

> Main application entrypoint is [App.java]

Although this is a very simple application - I decoupled Service (which in my opinion should handle business logic) and RouteHandler (which should delegate HTTP methods to business logic).

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

   [App.java]: <https://github.com/sasa-radovanovic/goeuro_busroutes/blob/master/src/main/java/sasa_goeuro/goeuro_busroutes/App.java>

