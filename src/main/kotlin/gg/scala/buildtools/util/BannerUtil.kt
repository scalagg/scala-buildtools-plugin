package gg.scala.buildtools.util

import com.cryptomorin.xseries.XMaterial
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.DyeColor
import org.bukkit.Material
import org.bukkit.block.banner.Pattern
import org.bukkit.block.banner.PatternType
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.BannerMeta
import java.lang.reflect.Method
import java.util.*

/**
 * @author Topu
 * @date 2/27/2025
 */
object BannerUtil {

    private val allColors = DyeColor.entries
    private val allPatterns = PatternType.entries.filter { it != PatternType.BASE }

    fun createBanner(name: String, base: DyeColor, lore: String, patterns: List<Pattern> = emptyList()): ItemStack {
        val item = ItemStack(Material.BANNER)
        val meta = item.itemMeta as? BannerMeta ?: return item

        meta.baseColor = base
        meta.patterns = patterns

        if (lore.isNotBlank()) {
            meta.lore = lore.split("__").map { it.replace("&", "§") }
        }

        item.itemMeta = meta
        return item
    }

    fun addPattern(item: ItemStack, pattern: Pattern): ItemStack {
        val meta = item.itemMeta as? BannerMeta ?: return item
        meta.addPattern(pattern)
        item.itemMeta = meta
        return item
    }

    fun getBaseColor(item: ItemStack): DyeColor? {
        val meta = item.itemMeta as? BannerMeta ?: return null
        return meta.baseColor
    }

    fun getPatternType(item: ItemStack): PatternType? {
        val meta = item.itemMeta as? BannerMeta ?: return null
        return meta.patterns.firstOrNull()?.pattern
    }

    fun getColorFromBanner(item: ItemStack): DyeColor? {
        val meta = item.itemMeta as? BannerMeta ?: return null
        return meta.patterns.firstOrNull()?.color
    }

    fun getRandomDye(): DyeColor = allColors.random()
    fun getRandomPattern(): PatternType = allPatterns.random()
}
