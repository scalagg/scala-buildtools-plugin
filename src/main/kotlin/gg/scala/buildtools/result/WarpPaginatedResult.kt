package gg.scala.buildtools.result

import gg.scala.buildtools.warp.Warp
import net.evilblock.cubed.util.CC
import net.evilblock.cubed.util.bukkit.PaginatedResult

/**
 * @author Topu
 * @date 2/27/2025
 */
object WarpPaginatedResult : PaginatedResult<Warp>()
{
 override fun format(result: Warp, resultIndex: Int): String
 {
  return "${CC.GRAY} - ${CC.WHITE}${result.id}"
 }

 override fun getHeader(page: Int, maxPages: Int): String
 {
  return "${CC.PRI}=== ${CC.WHITE}Warps ${CC.GRAY}($page/$maxPages)${CC.PRI} ==="
 }
}