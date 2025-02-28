package gg.scala.buildtools.warp

import gg.scala.store.storage.storable.IDataStoreObject
import net.evilblock.cubed.util.CC
import org.bukkit.Location
import org.bukkit.entity.Player
import java.util.*

/**
 * @author Topu
 * @date 2/27/2025
 */
data class Warp(
    val id: String,
    val createdOn: String,
    private val handle: Location,
    override val identifier: UUID = UUID.randomUUID()
) : IDataStoreObject
{
    fun teleportTo(player: Player)
    {
            player.teleport(handle)
            player.sendMessage("${CC.SEC}You've been warped to ${CC.PRI}$id${CC.SEC}.")
    }
}