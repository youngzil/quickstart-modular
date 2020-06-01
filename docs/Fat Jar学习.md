https://www.javacodegeeks.com/2012/11/packing-your-java-application-as-one-or-fat-jar.html
https://www.cnblogs.com/oldtrafford/p/6901149.html

FatJar也就叫做UberJar，是一种可执行的Jar包(Executable Jar)。FatJar和普通的jar不同在于它包含了依赖的jar包。


fat jar是jar，它包含所有库的类，你的项目依赖于这些类，当然还有当前项目的类。
在不同的构建系统中，fat jar的创建方式不同，例如，在Gradle中，可以使用（instruction）创建它：
task fatJar(type: Jar) {
    manifest {
        attributes 'Main-Class': 'com.example.Main'
    }
    baseName = project.name + '-all'
    from { configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } }
    with jar
}


在Maven中，它是按照这种方式完成的（在建立普通的jar之后）：
<pluginrepositories>
    <pluginrepository>
        <id>onejar-maven-plugin.googlecode.com</id>
        <url>http://onejar-maven-plugin.googlecode.com/svn/mavenrepo</url>
    </pluginrepository>
</pluginrepositories>

<!-- ... -->

<plugin>
    <groupid>org.dstovall</groupid>
    <artifactid>onejar-maven-plugin</artifactid>
    <version>1.4.4</version>
    <executions>
        <execution>
            <configuration>
                <onejarversion>0.97</onejarversion>
                <classifier>onejar</classifier>
            </configuration>
            <goals>
                <goal>one-jar</goal>
            </goals>
        </execution>
   </executions>
</plugin>

