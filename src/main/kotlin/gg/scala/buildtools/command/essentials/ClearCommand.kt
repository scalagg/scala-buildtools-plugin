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
@CommandAlias("clear|c|clearinv")
@CommandPermission("buildtools.command.clear")
object ClearCommand : ScalaCommand()
{
    @Default
    fun onDefault(player: ScalaPlayer)
    {
        player.bukkit().inventory.clear()
        player.bukkit().updateInventory()

        player.sendMessage(
            "${CC.GREEN}You've cleared your inventory."
        )
    }

    @Default
    @CommandCompletion("@players")
    @CommandPermission("buildtools.command.clear.other")
    fun onDefaultOther(
        sender: CommandSender, player: ScalaPlayer
    )
    {
        player.bukkit().inventory.clear()
        player.bukkit().updateInventory()

        sender.sendMessage(
            "${CC.SEC}You've cleared ${player.bukkit().name}'s${CC.SEC} inventory."
        )
    }
}
