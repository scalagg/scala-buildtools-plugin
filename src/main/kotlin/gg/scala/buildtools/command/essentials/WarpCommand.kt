package gg.scala.buildtools.command.essentials

import gg.scala.buildtools.result.WarpPaginatedResult
import gg.scala.buildtools.warp.Warp
import gg.scala.buildtools.warp.WarpService
import gg.scala.commons.acf.CommandHelp
import gg.scala.commons.acf.ConditionFailedException
import gg.scala.commons.acf.annotation.*
import gg.scala.commons.annotations.commands.AutoRegister
import gg.scala.commons.command.ScalaCommand
import net.evilblock.cubed.util.CC
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * @author Topu
 * @date 2/27/2025
 */
@AutoRegister
@CommandAlias("warp|warps")
@CommandPermission("buildtools.command.warp")
object WarpCommand : ScalaCommand()
{
    @Subcommand("to")
    fun onDefault(player: Player, warp: Warp)
    {
        warp.teleportTo(player)
    }

    @Default
    @HelpCommand
    @Syntax("[help]")
    fun onHelp(help: CommandHelp)
    {
        help.showHelp()
    }

    @Subcommand("create")
    @Description("Create a new warp for this server.")
    fun onCreate(player: Player, @Single name: String)
    {
        val existing = WarpService.find(name.lowercase())

        if (existing != null) {
            throw ConditionFailedException("A warp by that name already exists.")
        }

        WarpService.create(name, player.location)

        player.sendMessage("${CC.GREEN}The $name warp has been created.")
    }

    @Syntax("<warp>")
    @Subcommand("delete|remove")
    @Description("Delete an existing warp.")
    fun onDelete(sender: CommandSender, warp: Warp)
    {
        WarpService.delete(warp)

        sender.sendMessage("${CC.GREEN}The ${warp.id} warp has been deleted.")
    }

    @Syntax("[page]")
    @Subcommand("list")
    @Description("List all warps.")
    fun onList(sender: CommandSender, @Optional page: Int?)
    {
        WarpPaginatedResult.display(
            sender = sender,
            results = WarpService.all(),
            page = page ?: 1,
            command = "warp list %s"
        )
    }
}