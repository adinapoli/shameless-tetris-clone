resolvers += {
    Resolver.url("Scala Tools Snapshots" , new URL("http://scala-tools.org/repo-snapshots/"))
    Resolver.url("sbt-plugin-releases", new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)
    Resolver.url("sbt-idea-repo", new URL("http://mpeltonen.github.com/maven/"))(Patterns("com/github/mpeltonen/sbt-idea_2.9.1_0.11.2/1.0.0/sbt-idea-1.0.0.pom") )
}

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.0.0")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.7.4")

libraryDependencies += "org.scalaz" %% "scalaz-core" % "6.0.4"
