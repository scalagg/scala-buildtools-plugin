package gg.scala.buildtools.customizer

import gg.scala.buildtools.warp.Warp
import gg.scala.buildtools.warp.WarpService
import gg.scala.commons.acf.ConditionFailedException
import gg.scala.commons.annotations.commands.customizer.CommandManagerCustomizer
import gg.scala.commons.command.ScalaCommandManager
import net.evilblock.cubed.util.CC

/**
 * @author Topu
 * @date 2/27/2025
 */
object BuildToolsCommandCustomizer
{
    @CommandManagerCustomizer
    fun customize(
        commandManager: ScalaCommandManager
    ) {
        commandManager.commandContexts.registerContext(Warp::class.java) {
            val arg = it.popFirstArg()

            return@registerContext WarpService.find(arg)
                ?: throw ConditionFailedException("There is no warp with the name ${CC.YELLOW}${arg}${CC.RED}.")
        }
    }
}