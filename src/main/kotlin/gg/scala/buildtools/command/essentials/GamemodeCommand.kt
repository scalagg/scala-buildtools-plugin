package gg.scala.buildtools.command.essentials

import gg.scala.commons.acf.annotation.CommandAlias
import gg.scala.commons.acf.annotation.CommandCompletion
import gg.scala.commons.acf.annotation.CommandPermission
import gg.scala.commons.acf.annotation.Optional
import gg.scala.commons.annotations.commands.AutoRegister
import gg.scala.commons.command.ScalaCommand
import gg.scala.commons.issuer.ScalaPlayer
import net.evilblock.cubed.util.CC
import org.bukkit.GameMode

/**
 * @author Topu
 * @date 2/28/2025
 */
@AutoRegister
object GamemodeCommand : ScalaCommand()
{
    @CommandAlias("gmc")
    @CommandCompletion("@players")
    @CommandPermission("buildtools.command.gmc")
    fun onGmc(
        player: ScalaPlayer, @Optional target: ScalaPlayer?
    )
    {
        performGamemodeSwitch(
            player = player,
            target = target,
            gameMode = GameMode.CREATIVE
        )
    }

    @CommandAlias("gms")
    @CommandCompletion("@players")
    @CommandPermission("buildtools.command.gms")
    fun onGms(
        player: ScalaPlayer, @Optional target: ScalaPlayer?
    )
    {
        performGamemodeSwitch(
            player = player,
            target = target,
            gameMode = GameMode.SURVIVAL
        )
    }

    @CommandAlias("gmsp")
    @CommandCompletion("@players")
    @CommandPermission("buildtools.command.gmsp")
    fun onGmsp(
        player: ScalaPlayer, @Optional target: ScalaPlayer?
    )
    {
        performGamemodeSwitch(
            player = player,
            target = target,
            gameMode = GameMode.SPECTATOR
        )
    }

    @CommandAlias("gma")
    @CommandCompletion("@players")
    @CommandPermission("buildtools.command.gma")
    fun onGma(
        player: ScalaPlayer, @Optional target: ScalaPlayer?
    )
    {
        performGamemodeSwitch(
            player = player,
            target = target,
            gameMode = GameMode.ADVENTURE
        )
    }

    private fun performGamemodeSwitch(
        player: ScalaPlayer, target: ScalaPlayer?, gameMode: GameMode
    )
    {
        if (target != null)
        {
            player.sendMessage(
                "${CC.SEC}You've set ${target.bukkit().name}'s${CC.SEC} gamemode to ${CC.GREEN}${gameMode.name.lowercase()}${CC.SEC}."
            )

            target.bukkit().gameMode = gameMode
            return
        }

        player.sendMessage(
            "${CC.SEC}You've set your gamemode to ${CC.GREEN}${gameMode.name.lowercase()}${CC.SEC}."
        )

        player.bukkit().gameMode = gameMode
    }
}
