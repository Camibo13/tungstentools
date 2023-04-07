package com.smilerpunk.tungstentools.item;

import com.smilerpunk.tungstentools.Tungstentools;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Tungstentools.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab TUNGSTEN_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        TUNGSTEN_TAB = event.registerCreativeModeTab(new ResourceLocation(Tungstentools.MOD_ID, "tungsten_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.TUNGSTEN_INGOT.get()))
                        .title(Component.translatable("creativemodetab.tungsten_tab")));
    }
}
