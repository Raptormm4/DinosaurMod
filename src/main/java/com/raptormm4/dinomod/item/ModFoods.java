package com.raptormm4.dinomod.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;

public class ModFoods {
    public static final FoodProperties RAW_DODO_MEAT = new FoodProperties.Builder()
            .meat().saturationMod(0.3f).nutrition(3).effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.35f).build();
    public static final FoodProperties COOKED_DODO_MEAT = new FoodProperties.Builder()
            .meat().saturationMod(0.7f).nutrition(7).build();

}
