package net.hana.more_pokeballs.balls

import com.cobblemon.mod.common.api.data.DataRegistry
import com.cobblemon.mod.common.api.data.JsonDataRegistry
import com.cobblemon.mod.common.api.pokeball.catching.CaptureEffect
import com.cobblemon.mod.common.api.pokeball.catching.CatchRateModifier
import com.cobblemon.mod.common.api.pokeball.catching.modifiers.MultiplierModifier
import com.cobblemon.mod.common.api.reactive.SimpleObservable
import com.cobblemon.mod.common.pokeball.PokeBall
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import net.minecraft.resource.ResourceType
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Identifier

object PokeBalls : JsonDataRegistry<PokeBall> {

    private val defaults: MutableMap<Identifier, PokeBall> = mutableMapOf()

    @JvmStatic
    fun createDefault(
        name: String,
        modifier: CatchRateModifier = MultiplierModifier(1F) { _, _ -> true },
        effects: List<CaptureEffect> = emptyList(),
        waterDragValue: Float = 0.8F,
        model2d: Identifier  = cobblemonResource(name),
        model3d: Identifier  = cobblemonResource("item/${name}_model"),
        throwPower: Float = 1.25f,
        ancient: Boolean = false
    ): PokeBall {
        val identifier = cobblemonResource(name)
        val pokeBall = PokeBall(identifier, modifier, effects, waterDragValue, model2d, model3d, throwPower, ancient)
        this.defaults[identifier] = pokeBall
        return pokeBall
    }

    override fun reload(data: Map<Identifier, PokeBall>) {
        this.defaults.clear()
        this.defaults.putAll(data)
    }

    fun getPokeBall(name: Identifier): PokeBall? {
        return this.defaults[name]
    }

    private fun cobblemonResource(name: String): Identifier {
        return Identifier.of("cobblemon", name)
    }

    override val gson: Gson
        get() = TODO("Not yet implemented")
    override val id: Identifier
        get() = TODO("Not yet implemented")
    override val observable: SimpleObservable<out DataRegistry>
        get() = TODO("Not yet implemented")
    override val resourcePath: String
        get() = TODO("Not yet implemented")
    override val type: ResourceType
        get() = TODO("Not yet implemented")
    override val typeToken: TypeToken<PokeBall>
        get() = TODO("Not yet implemented")

    override fun sync(player: ServerPlayerEntity) {
        TODO("Not yet implemented")
    }
}
