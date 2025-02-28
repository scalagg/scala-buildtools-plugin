package gg.scala.buildtools.menu

import net.evilblock.cubed.menu.Button
import net.evilblock.cubed.menu.pagination.PaginatedMenu
import net.evilblock.cubed.util.CC
import net.evilblock.cubed.util.bukkit.ItemBuilder
import org.bukkit.Material
import org.bukkit.entity.Player

/**
 * @author Topu
 * @date 2/27/2025
 */
class SecretBlocksMenu : PaginatedMenu() {

    companion object {
        val slots = listOf(
            10, 11, 12, 13, 14, 15, 16,
            19, 20, 21, 22, 23, 24, 25,
            28, 29, 30, 31, 32, 33, 34
        )
    }

    var mushroomB64: String =
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2ZhMzljY2Y0Nzg4ZDkxNzlhODc5NWU2YjcyMzgyZDQ5Mjk3YjM5MjE3MTQ2ZWRhNjhhZTc4Mzg0MzU1YjEzIn19fQ=="
    var stemB64: String =
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODRkNTQxMjc1YzdmOTI0YmNiOWViMmRiYmY0Yjg2NmI3NjQ5YzMzMGE2YTAxM2I1M2Q1ODRmZDRkZGYxODZjYSJ9fX0="
    var fullStemB64: String =
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjU1ZmE2NDJkNWViY2JhMmM1MjQ2ZmU2NDk5YjFjNGY2ODAzYzEwZjE0ZjUyOTljOGU1OTgxOWQ1ZGMifX19"
    var doubleSlabB64: String =
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWVjZTM2OWE0YTE0YzdiOGU3ZWNhYmJjOWQ4MzIzOGI1ZjU1YzQ3Mzg0NjNmNjY4NzhjOTZiNGM3MjE1M2UifX19"
    var stoneB64: String =
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGRkMGNkMTU4YzJiYjY2MTg2NTBlMzk1NGIyZDI5MjM3ZjViNGMwZGRjN2QyNThlMTczODBhYjY5NzlmMDcxIn19fQ=="
    var sandstoneB64: String =
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDM2ZTk4NjI4MzJhNmZjYzQ4NTVmYTc5YzFhYWU1ZTczYjkxOTdlYzZiYmQzOGY2MzEyZWZhYzY4MGM2MzI4NSJ9fX0="
    var redSandstoneB64: String =
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTJkYTdhYTFhZTZjYzlkNmMzNmMxOGE0NjBkMjM5ODE2MmVkYzIyMDdmZGZjOWUyOGE3YmY4NGQ3NDQxYjhhMiJ9fX0="
    var oakB64: String =
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTA1NWFjNzE1YmVkMjdiYTMyODkwNzFmN2QxYjFjNWFiOTRkMTJjNDA5ZjkwNDc1MGMxM2NkM2QwYWI0YTQifX19"
    var spruceB64: String =
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmZmODk2MWRhODQ3ZTM3YmJkMTE0ZWUxZjc5ODg4MmE5ZWY1NTFjNjkyZjE2NWNhYWFlNGNmNWJmZWVmIn19fQ=="
    var birchB64: String =
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGIxMjM5NzMxZTM5ZjMxYTFhZDFkYmNkMmI3ODI4YzU5ZmVjY2RlNzhhNzhhNzJmMjVkZjNjMWUyMjY3MzRlYyJ9fX0="
    var jungleB64: String =
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTkyYmE5MzYxYmRkODVlMjI2OWU3ZjBiZTEzMWNjMzI1NDFkMWUzOGM2YmExMzdlOGQyMWM2MmY2MjZhYWIxIn19fQ=="
    var acaciaB64: String =
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTM5ZmE2ZjFhOTY0NTExMWIyNzk2M2E3NmI4YzY2MTE2YTA3MGJjMzkzMDdjNWI5ODU2NzVjODE0ZTI2NSJ9fX0="
    var darkOakB64: String =
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWU1YjQ4YTU5MmUxZWI4NGRkMjMwMWU2OWUyYWFhNTFlN2I3YWZjODJmMzFmZjRkMzYzMzFmZTczNzVjNzIifX19"

    init {
        placeholdBorders = true
    }

    override fun getAllPagesButtonSlots(): List<Int> = slots
    override fun size(buttons: Map<Int, Button>): Int = 45
    override fun getMaxItemsPerPage(player: Player): Int = slots.size
    override fun getPrePaginatedTitle(player: Player): String = "Secret Blocks"

    override fun getGlobalButtons(player: Player): Map<Int, Button> = mapOf(
        4 to ItemBuilder.of(Material.BOOK)
            .name("${CC.GOLD}Secret Blocks")
            .addToLore(
                "${CC.GRAY}These are special blocks that",
                "${CC.GRAY}are normally unobtainable.",
                "",
                "${CC.YELLOW}Click on a block to receive it!"
            )
            .toButton()
    )

    private val blocks = listOf(
        SecretBlock(Material.HUGE_MUSHROOM_1, "Brown Mushroom Block"),
        SecretBlock(Material.HUGE_MUSHROOM_2, "Red Mushroom Block"),
        SecretBlock(Material.SKULL_ITEM, "Mushroom Block","99:0", mushroomB64),
        SecretBlock(Material.SKULL_ITEM, "Mushroom Stem","99:10", stemB64),
        SecretBlock(Material.SKULL_ITEM, "Mushroom Full Stem","99:15", fullStemB64),
        SecretBlock(Material.SKULL_ITEM, "Double Stone Slab","43:0", doubleSlabB64),
        SecretBlock(Material.SKULL_ITEM, "Smooth Stone","43:8", stoneB64),
        SecretBlock(Material.SKULL_ITEM, "Smooth Sandstone","43:9", sandstoneB64),
        SecretBlock(Material.SKULL_ITEM, "Smooth Red Sandstone", "181:8", redSandstoneB64),
        SecretBlock(Material.SKULL_ITEM, "Full Bark Oak","17:12", oakB64),
        SecretBlock(Material.SKULL_ITEM, "Full Bark Spruce","17:13", spruceB64),
        SecretBlock(Material.SKULL_ITEM, "Full Bark Birch","17:14", birchB64),
        SecretBlock(Material.SKULL_ITEM, "Full Bark Jungle","17:15", jungleB64),
        SecretBlock(Material.SKULL_ITEM, "Full Bark Acacia","162:12", acaciaB64),
        SecretBlock(Material.SKULL_ITEM, "Full Bark Dark Oak","162:13", darkOakB64),
        SecretBlock(Material.MOB_SPAWNER, "Spawner Cage"),
        SecretBlock(Material.BARRIER, "Barrier"),
        SecretBlock(Material.DRAGON_EGG, "Dragon Egg"),
    )

    override fun getAllPagesButtons(player: Player): Map<Int, Button> {
        return blocks.mapIndexed { index, block ->
            index to block.toButton()
        }.toMap()
    }

    data class SecretBlock(val material: Material, val name: String, val id: String? = null, val base64: String? = null) {
        fun toButton(): Button {
            val item = if (base64 != null) {
                ItemBuilder.of(material)
                    .data(3)
                    .setBase64Head(base64)
                    .addToLore(
                        "${CC.B_GRAY}ID${CC.GRAY} $id"
                    )
            } else {
                ItemBuilder.of(material)
            }
            return item.name("${CC.YELLOW}$name").addToLore("", "${CC.GREEN}Click to receive.")
                .toButton { player, _ ->
                player!!.inventory.addItem(item.build())
                player.sendMessage("${CC.GREEN}You received: ${CC.WHITE}$name")
            }
        }
    }
}

