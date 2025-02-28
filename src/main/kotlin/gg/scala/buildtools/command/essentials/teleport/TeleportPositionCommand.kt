package gg.scala.buildtools.command.essentials.teleport

import gg.scala.commons.acf.annotation.CommandAlias
import gg.scala.commons.acf.annotation.CommandCompletion
import gg.scala.commons.acf.annotation.CommandPermission
import gg.scala.commons.acf.annotation.Default
import gg.scala.commons.annotations.commands.AutoRegister
import gg.scala.commons.command.ScalaCommand
import gg.scala.commons.issuer.ScalaPlayer
import net.evilblock.cubed.util.CC
import org.bukkit.Location
import org.bukkit.command.CommandSender

/**
 * @author GrowlyX
 * @since 10/13/2022
 */
@AutoRegister
@CommandAlias("teleportposition|teleportpos|tppos|tpposition")
@CommandPermission("buildtools.command.teleportposition")
object TeleportPositionCommand : ScalaCommand()
{
    @Default
    fun onDefault(player: ScalaPlayer)
    {
        player.sendMessage(
            "${CC.SEC}Usage: ${CC.PRI}/teleportposition ${CC.WHITE}<location> [target]"
        )
    }

    @Default
    fun onDefault(
        sender: ScalaPlayer, location: Location
    )
    {
        val locationFormatted = "${location.x}, ${location.y}, ${location.z}${CC.SEC} in the world ${CC.PRI}${location.world.name}${CC.SEC}"
        sender.teleport(location)

        sender.sendMessage(
            "${CC.SEC}You've teleported to ${CC.PRI}$locationFormatted${CC.SEC}."
        )

    }

    @Default
    @CommandCompletion("@players")
    fun onDefault(
        sender: CommandSender, location: Location, player: ScalaPlayer
    )
    {
        val locationFormatted = "${location.x}, ${location.y}, ${location.z}${CC.SEC} in the world ${CC.PRI}${location.world.name}${CC.SEC}"
        player.bukkit().teleport(location)

        sender.sendMessage(
            "${CC.SEC}You've teleported ${player.bukkit().name}${CC.SEC} to ${CC.PRI}$locationFormatted${CC.SEC}."
        )

    }
}
