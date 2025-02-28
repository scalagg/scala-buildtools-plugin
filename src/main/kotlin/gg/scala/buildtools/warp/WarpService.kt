package gg.scala.buildtools.warp

import com.mongodb.client.model.Filters
import gg.scala.commons.agnostic.sync.ServerSync
import gg.scala.flavor.service.Configure
import gg.scala.flavor.service.Service
import gg.scala.store.controller.DataStoreObjectController
import gg.scala.store.controller.DataStoreObjectControllerCache
import gg.scala.store.storage.impl.MongoDataStoreStorageLayer
import gg.scala.store.storage.type.DataStoreStorageType
import org.bukkit.Location

/**
 * @author Topu
 * @date 2/27/2025
 */
@Service
object WarpService
{
    private lateinit var handle: DataStoreObjectController<Warp>

    private val warps = mutableMapOf<String, Warp>()

    fun all(): List<Warp>
    {
        return warps.values.toList()
    }

    fun find(id: String): Warp?
    {
        return warps[id]
    }

    fun create(id: String, location: Location)
    {
        val warp = Warp(id.lowercase(), ServerSync.getLocalGameServer().id, location)
        handle.save(warp, DataStoreStorageType.MONGO)

        warps[id.lowercase()] = warp
    }

    fun delete(warp: Warp)
    {
        warps.remove(warp.id)?.let {
            handle.delete(it.identifier, DataStoreStorageType.MONGO)
        }
    }

    @Configure
    fun configure()
    {
        handle = DataStoreObjectControllerCache.create()

        handle.useLayer<MongoDataStoreStorageLayer<Warp>>(
            DataStoreStorageType.MONGO
        ) {
            this.loadAllWithFilter(
                Filters.eq("createdOn", ServerSync.getLocalGameServer().id)
            ).thenAccept {
                it.forEach { entry ->
                    warps[entry.value.id] = entry.value
                }
            }
        }
    }
}