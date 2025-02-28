package gg.scala.buildtools.command.essentials.teleport

import gg.scala.commons.acf.annotation.CommandAlias
import gg.scala.commons.acf.annotation.CommandCompletion
import gg.scala.commons.acf.annotation.CommandPermission
import gg.scala.commons.annotations.commands.AutoRegister
import gg.scala.commons.command.ScalaCommand
import gg.scala.commons.issuer.ScalaPlayer
import net.evilblock.cubed.util.CC

/**
 * @author GrowlyX
 * @since 10/13/2022
 */
@AutoRegister
object TeleportHereCommand : ScalaCommand()
{
    @CommandCompletion("@players")
    @CommandAlias("teleporthere|tphere|tph")
    @CommandPermission("buildtools.command.teleporthere")
    fun onTpHere(
        sender: ScalaPlayer, player: ScalaPlayer
    )
    {
        player.bukkit().teleport(sender.bukkit())

        sender.sendMessage(
            "${CC.SEC}You've teleported ${player.bukkit().name}${CC.SEC} to you."
        )
    }
}
