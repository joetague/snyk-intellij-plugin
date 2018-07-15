package io.snyk.plugin

import com.intellij.openapi.project.Project
import org.jetbrains.idea.maven.project.MavenProjectsManager

object RichProject {

  implicit class Adaptor(val p: Project) extends AnyVal {
    def toDepNode: MavenDepNode = {
      val mp = MavenProjectsManager.getInstance(p).getProjects.get(0)
      MavenDepNode.fromMavenProject(mp)
    }
  }

}
