package gg.scala.buildtools.scoreboard

import gg.scala.buildtools.warp.WarpService
import gg.scala.flavor.service.Service
import net.evilblock.cubed.scoreboard.ScoreboardAdapter
import net.evilblock.cubed.scoreboard.ScoreboardAdapterRegister
import net.evilblock.cubed.util.CC
import net.evilblock.cubed.util.nms.MinecraftReflection
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.util.*

/**
 * @author Topu
 * @date 2/27/2025
 */
@Service
@ScoreboardAdapterRegister
object BuildToolsScoreboardAdapter : ScoreboardAdapter()
{
 override fun getLines(board: LinkedList<String>, player: Player) {

  val ping = MinecraftReflection.getPing(player)

  board += ""
  board += "${CC.WHITE}Online: ${CC.PRI}${Bukkit.getOnlinePlayers().size}${CC.GRAY}/${CC.PRI}${Bukkit.getMaxPlayers()}"
  board += "Warps: ${CC.PRI}${WarpService.all().size}"
  board += ""
  board += "Ping: ${CC.PRI}${ping}ms"
  board += "World: ${CC.PRI}${player.location.world?.name}"
  board += "GameMode: ${CC.PRI}${player.gameMode.name}"
  board += ""
  board += CC.GRAY + "scala.gg" + "          " + CC.GRAY + "      " + CC.GRAY + "  " + CC.GRAY

 }

 override fun getTitle(player: Player): String = ScoreboardTitleService.getCurrentTitle()
}