package gg.scala.buildtools.command.essentials

import gg.scala.commons.acf.annotation.CommandAlias
import gg.scala.commons.acf.annotation.CommandCompletion
import gg.scala.commons.acf.annotation.CommandPermission
import gg.scala.commons.acf.annotation.Default
import gg.scala.commons.annotations.commands.AutoRegister
import gg.scala.commons.command.ScalaCommand
import gg.scala.commons.issuer.ScalaPlayer
import net.evilblock.cubed.util.CC
import org.bukkit.command.CommandSender

/**
 * @author GrowlyX
 * @since 10/13/2022
 */
@AutoRegister
@CommandAlias("workbench|wb|craft|crafting")
@CommandPermission("buildtools.command.workbench")
object WorkbenchCommand : ScalaCommand()
{
    @Default
    fun onDefault(player: ScalaPlayer)
    {
        player.bukkit().openWorkbench(player.bukkit().location, true)

        player.sendMessage(
            "${CC.GREEN}You've opened the workbench."
        )
    }

    @Default
    @CommandCompletion("@players")
    @CommandPermission("buildtools.command.clear.other")
    fun onDefaultOther(
        sender: CommandSender, player: ScalaPlayer
    )
    {
        player.bukkit().openWorkbench(player.bukkit().location, true)

        sender.sendMessage(
            "${CC.SEC}You've opened the workbench for ${player.bukkit().name}${CC.SEC}."
        )
    }
}
