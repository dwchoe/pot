# poc_aspectj

setup in Intellij <br>
1. configure Aspectj/ajc compiler <br>
1.1. download aspectjtools.jar - Aspectj compiler <br>
1.2. Intellij -> Preference -> Build, Execution, Deployment -> Compiler -> Java Compiler <br>
1.3 select Ajc and set path to aspectjtools.jar and click test button <br>
2. enble Aspectj and Spring AOP support plugins <br>
2.1. Intellij -> Prference -> Plugins -> search "aspectj" and enable AspectJ Support and Spring AOP/@Aspectj plugins <br>
3. configure Gradle <br>
3.1. add aspectj plugin <br>
3.2. add nl.eveoh:gradle-aspectj:1.5 <br>
3.3. add aspectjrt, aspectjtools and aspectjweaver jars <br>
