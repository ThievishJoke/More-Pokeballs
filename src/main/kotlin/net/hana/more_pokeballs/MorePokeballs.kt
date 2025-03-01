package net.hana.more_pokeballs

import net.fabricmc.api.ModInitializer
import net.hana.more_pokeballs.balls.ModPokeBalls

class MorePokeballs : ModInitializer {

    override fun onInitialize() {
        ModPokeBalls.registerItems()
    }
}
