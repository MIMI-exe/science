package de.mimi.science.effect;

import de.mimi.science.Science;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Science.MOD_ID);


    public static final RegistryObject<MobEffect> STRAHLUNG = MOB_EFFECTS.register("strahlung",() -> new StrahlungsEffect(MobEffectCategory.HARMFUL, 456674));

    public ModEffects(MobEffectCategory mobEffectCategory, int color) {
    }

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
