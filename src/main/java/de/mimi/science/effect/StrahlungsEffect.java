package de.mimi.science.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class StrahlungsEffect extends MobEffect {
    public StrahlungsEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(this == ModEffects.STRAHLUNG.get()) {
            pLivingEntity.hurt(DamageSource.ON_FIRE,0.5F);
        }
        else {

        }
    }
    public boolean isDurationEffectTick(int p_19455_, int p_19456_) {
        if (this == MobEffects.WITHER) {
            int i = 40 >> p_19456_;
            if (i > 0) {
                return p_19455_ % i == 0;
            } else {
            }
        }
                return true;
            }




}
