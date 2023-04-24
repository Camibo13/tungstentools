package com.smilerpunk.tungstentools.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier TUNGSTEN = new ForgeTier(4, 2500, 10,
            4f, 10, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.TUNGSTEN_INGOT.get()));
}
