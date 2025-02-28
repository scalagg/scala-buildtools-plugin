package gg.scala.buildtools.customizer

import gg.scala.buildtools.warp.Warp
import gg.scala.buildtools.warp.WarpService
import gg.scala.commons.acf.ConditionFailedException
import gg.scala.commons.annotations.commands.customizer.CommandManagerCustomizer
import gg.scala.commons.command.ScalaCommandManager
import net.evilblock.cubed.util.CC
import net.evilblock.cubed.util.bukkit.enchantment.EnchantmentWrapper
import org.apache.commons.lang.StringUtils
import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.enchantments.Enchantment

/**
 * @author Topu
 * @date 2/27/2025
 */
object BuildToolsCommandCustomizer
{
    @CommandManagerCustomizer
    fun customize(
        commandManager: ScalaCommandManager
    ) {
        commandManager.commandContexts.registerContext(Warp::class.java) {
            val arg = it.popFirstArg()

            return@registerContext WarpService.find(arg)
                ?: throw ConditionFailedException("There is no warp with the name ${CC.YELLOW}${arg}${CC.RED}.")
        }

        commandManager.commandCompletions
            .registerAsyncCompletion("worlds") {
                Bukkit.getWorlds().map(World::getName)
            }

        commandManager.commandCompletions
            .registerAsyncCompletion("enchantments") {
                val input = it.input
                val completions = mutableListOf<String>()

                for (enchantment in EnchantmentWrapper.entries) {
                    for (str in enchantment.parse) {
                        if (StringUtils.startsWithIgnoreCase(str, input)) {
                            completions.add(str)
                        }
                    }

                    if (StringUtils.startsWithIgnoreCase(enchantment.friendlyName, input)) {
                        completions.add(enchantment.friendlyName.lowercase())
                    }

                    if (StringUtils.startsWithIgnoreCase(enchantment.bukkitEnchantment.name, input)) {
                        completions.add(enchantment.friendlyName.lowercase())
                    }
                }

                completions
            }

        commandManager.commandContexts
            .registerContext(World::class.java) {
                val arg = it.popFirstArg()

                Bukkit.getWorlds()
                    .firstOrNull { world ->
                        world.name.lowercase().startsWith(arg, true)
                    }
                    ?: throw ConditionFailedException(
                        "No world matching ${CC.YELLOW}$arg${CC.RED} could be found."
                    )
            }

        commandManager.commandContexts
            .registerContext(Enchantment::class.java) {
                val arg = it.popFirstArg()

                EnchantmentWrapper.parse(arg)?.bukkitEnchantment
                    ?: throw ConditionFailedException(
                        "No enchantment with the name ${CC.YELLOW}$arg${CC.RED} found."
                    )
            }
    }
}