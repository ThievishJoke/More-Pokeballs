package net.hana.more_pokeballs.balls

import com.cobblemon.mod.common.api.pokeball.catching.modifiers.MultiplierModifier
import com.cobblemon.mod.common.item.PokeBallItem
import com.cobblemon.mod.common.pokeball.PokeBall
import net.hana.more_pokeballs.balls.PokeBalls.createDefault
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModPokeBalls {
    val FIRE_BALL: PokeBall = createDefault(
        name = "fire_ball",
        modifier = MultiplierModifier(3.0f) { _, _ -> true },
        effects = listOf(),
        waterDragValue = 1.0f,
        model2d = Identifier.of("more_pokeballs", "models/item/fire_ball"),
        model3d = Identifier.of("more_pokeballs", "models/item/fire_ball_model"),
        throwPower = 1.5f,
        ancient = false
    )

    fun registerItems() {
        registerItem("fire_ball", PokeBallItem(FIRE_BALL))

        val registeredFireBall = PokeBalls.getPokeBall(Identifier.of("more_pokeballs", "fire_ball"))
        println("Registered Poké Ball: $registeredFireBall")
    }

    private fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registries.ITEM, Identifier.of("more_pokeballs", name), item)
    }
}