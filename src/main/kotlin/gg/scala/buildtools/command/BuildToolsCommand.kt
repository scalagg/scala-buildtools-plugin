package gg.scala.buildtools.command

import gg.scala.buildtools.menu.ArmorMenu
import gg.scala.buildtools.menu.SecretBlocksMenu
import gg.scala.commons.acf.CommandHelp
import gg.scala.commons.acf.annotation.*
import gg.scala.commons.annotations.commands.AutoRegister
import gg.scala.commons.command.ScalaCommand
import gg.scala.commons.issuer.ScalaPlayer
import net.evilblock.cubed.util.CC

/**
 * @author Topu
 * @date 2/27/2025
 */
@AutoRegister
@CommandAlias("buildtools")
@CommandPermission("op")
object BuildToolsCommand : ScalaCommand()
{

    @Default
    @HelpCommand
    @Syntax("[help]")
    fun onHelp(help: CommandHelp)
    {
        help.showHelp()
    }

    @Subcommand("blocks")
    fun onBlocks(player: ScalaPlayer)
    {
        SecretBlocksMenu().openMenu(player.bukkit())
    }

    @Subcommand("armor")
    fun onArmor(player: ScalaPlayer)
    {
        player.sendMessage("${CC.RED}WIP!")
        ArmorMenu().openMenu(player.bukkit())
    }

    @Subcommand("banners")
    fun onBanners(player: ScalaPlayer)
    {
        player.sendMessage("${CC.RED}Coming soon!")
//        BannerPatternMenu().openMenu(player.bukkit())
    }
}