package gg.scala.buildtools.menu

import net.evilblock.cubed.menu.Button
import net.evilblock.cubed.menu.Menu
import net.evilblock.cubed.menu.pagination.PaginatedMenu
import net.evilblock.cubed.util.CC
import net.evilblock.cubed.util.bukkit.ItemBuilder
import net.evilblock.cubed.util.bukkit.ItemUtils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

/**
 * @author Topu
 * @date 2/28/2025
 */
class ArmorMenu : Menu("Armor Color Creator") {

    init {
        placeholdBorders = true
        autoUpdate = true
    }

    override fun size(buttons: Map<Int, Button>): Int = 54

    override fun getButtons(player: Player): Map<Int, Button> = mapOf(
        4 to ItemBuilder.of(Material.BOOK)
            .name("${CC.GOLD}Armor Color Creator")
            .addToLore(
                "${CC.GRAY}Create your own armor colors!",
                "${CC.GRAY}Click on the buttons to get the armor pieces.",
                "",
                "${CC.GRAY}You can also randomize the colors.",
                "${CC.GRAY}Click on the randomizer buttons to get a random color."
            )
            .toButton(),

        10 to ItemBuilder.of(Material.LEATHER_HELMET)
            .name("${CC.GREEN}Helmet")
            .addToLore("", "${CC.YELLOW}Click to get.")
            .color(Color.fromBGR(255, 0, 0))
            .toButton { _, _ ->
                player.inventory.addItem(ItemStack(Material.LEATHER_HELMET))
            },
        19 to ItemBuilder.of(Material.LEATHER_CHESTPLATE)
            .name("${CC.GREEN}Chestplate")
            .addToLore("", "${CC.YELLOW}Click to get.")
            .toButton { _, _ ->
                player.inventory.addItem(ItemStack(Material.LEATHER_CHESTPLATE))
            },
        28 to ItemBuilder.of(Material.LEATHER_LEGGINGS)
            .name("${CC.GREEN}Leggings")
            .addToLore("", "${CC.YELLOW}Click to get.")
            .toButton { _, _ ->
                player.inventory.addItem(ItemStack(Material.LEATHER_LEGGINGS))
            },
        37 to ItemBuilder.of(Material.LEATHER_BOOTS)
            .name("${CC.GREEN}Boots")
            .addToLore("", "${CC.YELLOW}Click to get.")
            .toButton { _, _ ->
                player.inventory.addItem(ItemStack(Material.LEATHER_BOOTS))
            },
        22 to ItemBuilder.of(Material.SKULL_ITEM)
            .name("${CC.RED}Red Randomizer")
            .data(3)
            .setBase64Head("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTEzMWRlOGU5NTFmZGQ3YjlhM2QyMzlkN2NjM2FhM2U4NjU1YTMzNmI5OTliOWVkYmI0ZmIzMjljYmQ4NyJ9fX0=")
            .addToLore("", "${CC.YELLOW}Click to randomize.")
            .toButton { _, _ ->
                // Randomize the color
            },
        23 to ItemBuilder.of(Material.SKULL_ITEM)
            .name("${CC.GREEN}Green Randomizer")
            .data(3)
            .setBase64Head("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWMzY2VjNjg3NjlmZTljOTcxMjkxZWRiN2VmOTZhNGUzYjYwNDYyY2ZkNWZiNWJhYTFjYmIzYTcxNTEzZTdiIn19fQ==")
            .addToLore("", "${CC.YELLOW}Click to randomize.")
            .toButton { _, _ ->
                // Randomize the color
            },
        24 to ItemBuilder.of(Material.SKULL_ITEM)
            .name("${CC.BLUE}Blue Randomizer")
            .data(3)
            .setBase64Head("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjMyOGYzNzhmMjhhOTg3MjIyNmY1Y2UwNGQ2ZTFkZmExMTE2MTg1ODdmNDhkZmExZmU4MmQwNDMyMTZhNWNmIn19fQ==")
            .addToLore("", "${CC.YELLOW}Click to randomize.")
            .toButton { _, _ ->
                // Randomize the color
            },

        31 to ItemBuilder.of(Material.SKULL_ITEM)
            .name("${CC.RED}Red")
            .data(3)
            .setBase64Head("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2Y0NmMzMWQ2ZWU2ZWE2MTlmNzJlNzg1MjMyY2IwNDhhYjI3MDQ2MmRiMGNiMTQ1NDUxNDQzNjI1MWMxYSJ9fX0=")
            .addToLore(
                "",
                "${CC.GRAY}Left-Click to increase.",
                "${CC.GRAY}Right-Click to decrease.",
                "${CC.GRAY}Shift-Left-Click to change by 5.",
                "",
                "${CC.YELLOW}Click to adjust.")
            .toButton { _, _ ->
                // Adjust the color
            },
        32 to ItemBuilder.of(Material.SKULL_ITEM)
            .name("${CC.GREEN}Green")
            .data(3)
            .setBase64Head("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzZmNjlmN2I3NTM4YjQxZGMzNDM5ZjM2NThhYmJkNTlmYWNjYTM2NmYxOTBiY2YxZDZkMGEwMjZjOGY5NiJ9fX0=")
            .addToLore(
                "",
                "${CC.GRAY}Left-Click to increase.",
                "${CC.GRAY}Right-Click to decrease.",
                "${CC.GRAY}Shift-Left-Click to change by 5.",
                "",
                "${CC.YELLOW}Click to adjust.")
            .toButton { _, _ ->
                // Adjust the color
            },
        33 to ItemBuilder.of(Material.SKULL_ITEM)
            .name("${CC.BLUE}Blue")
            .data(3)
            .setBase64Head("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjgzOWUzODFkOWZlZGFiNmY4YjU5Mzk2YTI3NjQyMzhkY2ViMmY3ZWVhODU2ZGM2ZmM0NDc2N2RhMzgyZjEifX19")
            .addToLore(
                "",
                "${CC.GRAY}Left-Click to increase.",
                "${CC.GRAY}Right-Click to decrease.",
                "${CC.GRAY}Shift-Left-Click to change by 5.",
                "",
                "${CC.YELLOW}Click to adjust.")
            .toButton { _, _ ->
                // Adjust the color
            },
    )
}