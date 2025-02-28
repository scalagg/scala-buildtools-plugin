package gg.scala.buildtools.command.essentials.teleport

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
@CommandAlias("teleport|tp")
@CommandPermission("buildtools.command.teleport")
object TeleportCommand : ScalaCommand()
{
    @Default
    fun onDefault(player: ScalaPlayer)
    {
        player.sendMessage(
            "${CC.SEC}Usage: ${CC.PRI}/teleport ${CC.WHITE}<player> [target]"
        )
    }

    @Default
    @CommandCompletion("@players")
    fun onDefault(
        sender: ScalaPlayer, player: ScalaPlayer
    )
    {
        sender.bukkit().teleport(player.bukkit())

        sender.sendMessage(
            "${CC.SEC}You've teleported to ${player.bukkit().name}${CC.SEC}."
        )
    }

    @Default
    @CommandCompletion("@players @players")
    fun onDefault(
        sender: CommandSender, player: ScalaPlayer, target: ScalaPlayer
    )
    {
        player.bukkit().teleport(target.bukkit())

        sender.sendMessage(
            "${CC.SEC}You've teleported ${player.bukkit().name}${CC.SEC} to ${target.bukkit().name}${CC.SEC}."
        )
    }
}
