package com.smilerpunk.tungstentools;

import com.mojang.logging.LogUtils;
import com.smilerpunk.tungstentools.block.ModBlocks;
import com.smilerpunk.tungstentools.item.ModCreativeModeTabs;
import com.smilerpunk.tungstentools.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;


@Mod(Tungstentools.MOD_ID)
public class Tungstentools {


    public static final String MOD_ID = "tungstentools";

    private static final Logger LOGGER = LogUtils.getLogger();


    public Tungstentools() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);


        modEventBus.addListener(this::commonSetup);


        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

    }



    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void  addCreative(CreativeModeTabEvent.BuildContents event)  {
    if(event.getTab() == ModCreativeModeTabs.TUNGSTEN_TAB) {
            event.accept(ModItems.TUNGSTEN_INGOT);
            event.accept(ModItems.RAW_TUNGSTEN);
            event.accept(ModItems.TUNGSTEN_SWORD);
            event.accept(ModItems.TUNGSTEN_PICKAXE);
            event.accept(ModItems.TUNGSTEN_AXE);
            event.accept(ModItems.TUNGSTEN_SHOVEL);
            event.accept(ModItems.TUNGSTEN_HOE);
            event.accept(ModItems.TUNGSTEN_HELMET);
            event.accept(ModItems.TUNGSTEN_CHESTPLATE);
            event.accept(ModItems.TUNGSTEN_LEGGINGS);
            event.accept(ModItems.TUNGSTEN_BOOTS);
            event.accept(ModBlocks.TUNGSTEN_BLOCK);
            event.accept(ModBlocks.TUNGSTEN_ORE);
            event.accept(ModBlocks.DEEPSLATE_TUNGSTEN_ORE);
            event.accept(ModBlocks.RAW_TUNGSTEN_BLOCK);
        }

    }
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
