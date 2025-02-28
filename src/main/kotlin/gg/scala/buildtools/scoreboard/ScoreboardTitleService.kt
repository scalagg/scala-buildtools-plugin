package gg.scala.buildtools.scoreboard

import gg.scala.commons.scoreboard.TextAnimator
import gg.scala.commons.scoreboard.animations.TextFadeAnimation
import gg.scala.flavor.service.Close
import gg.scala.flavor.service.Configure
import gg.scala.flavor.service.Service
import net.evilblock.cubed.util.CC
import org.bukkit.ChatColor

/**
 * @author Topu
 * @date 2/27/2025
 */
@Service
object ScoreboardTitleService
{
    private val titleAnimator = TextAnimator.of(
        TextFadeAnimation(
            "${CC.BOLD}Build",
            ChatColor.GOLD,
            ChatColor.YELLOW,
            ChatColor.WHITE
        )
    )

    fun getCurrentTitle() = titleAnimator.current().text

    @Configure
    fun configure()
    {
        titleAnimator.schedule()
    }

    @Close
    fun close()
    {
        titleAnimator.dispose()
    }
}