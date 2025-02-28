package gg.scala.buildtools

import gg.scala.commons.ExtendedScalaPlugin
import gg.scala.commons.annotations.container.ContainerEnable
import gg.scala.commons.core.plugin.*

/**
 * @author Topu
 * @date 2/27/2025
 */
@Plugin(
    name = "ScBuildTools",
    version = "%remote%/%branch%/%id%"
)
@PluginAuthor("Scala")
@PluginWebsite("https://scala.gg")
@PluginDependencyComposite(
    PluginDependency("scala-commons")
)
class ScalaBuildTools : ExtendedScalaPlugin()
{

    companion object {
        @JvmStatic
        lateinit var instance: ScalaBuildTools
    }

    @ContainerEnable
    fun containerEnable()
    {
        instance = this
    }
}