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
import org.bukkit.entity.Player

/**
 * @author GrowlyX
 * @since 10/13/2022
 */
@AutoRegister
@CommandAlias("fly|iamabird")
@CommandPermission("buildtools.command.fly")
object FlyCommand : ScalaCommand()
{
    private fun Player.toggleFlight()
    {
        apply {
            if (allowFlight)
            {
                isFlying = false
                allowFlight = false
            } else
            {
                allowFlight = true
                isFlying = true
            }
        }
    }

    @Default
    fun onDefault(player: ScalaPlayer)
    {
        player.bukkit().toggleFlight()

        player.sendMessage(
            "${if (player.bukkit().isFlying) CC.GREEN else CC.RED}You've ${if (player.bukkit().isFlying) "enabled" else "disabled"} flight."
        )
    }

    @Default
    @CommandCompletion("@players")
    @CommandPermission("buildtools.command.fly.other")
    fun onDefaultOther(
        sender: CommandSender, player: ScalaPlayer
    )
    {
        player.bukkit().toggleFlight()

        sender.sendMessage(
            "${CC.SEC}You've ${
                if (player.bukkit().isFlying) "enabled" else "disabled"
            } flight for ${player.bukkit().name}${CC.SEC}."
        )
    }
}
