package com.noobanidus.compham.init;

import com.noobanidus.compham.CompressedHammers;
import com.noobanidus.compham.item.ItemCHRod;
import com.noobanidus.compham.item.ItemCHTool;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

@SuppressWarnings("WeakerAccess")
@Mod.EventBusSubscriber
public class Items {
    private static final Item.ToolMaterial TOOL_MATERIAL_COMPRESSED_COBBLESTONE = EnumHelper.addToolMaterial("EX:COMPRESSED_COBBLESTONE", 1, 490, 3.2f, 1.0f, 15);
    private static final Item.ToolMaterial TOOL_MATERIAL_DOUBLE_COMPRESSED_COBBLESTONE = EnumHelper.addToolMaterial("EX:DOUBLE_COMPRESSED_COBBLESTONE", 1, 980, 3.8f, 1.0f, 15);

    public static ItemCHTool itemHammer;
    public static ItemCHTool itemCCHammer;
    public static ItemCHTool itemDCCHammer;

    public static ItemCHRod itemStoneRod;
    public static ItemCHRod itemCompressedRod;
    public static ItemCHRod itemDoubleRod;
    public static ItemCHRod itemIronRod;

    public static ItemStack toolHammer;
    public static ItemStack toolCCHammer;
    public static ItemStack toolDCCHammer;

    public static ItemStack stoneRod;
    public static ItemStack compressedRod;
    public static ItemStack doubleRod;
    public static ItemStack ironRod;

    public static void preInit() {
        if (TOOL_MATERIAL_COMPRESSED_COBBLESTONE == null || TOOL_MATERIAL_DOUBLE_COMPRESSED_COBBLESTONE == null) {
            NullPointerException e = new NullPointerException();
            CompressedHammers.LOG.error("Compressed tool materials are null.", e);
            throw e;
        }

        itemHammer = new ItemCHTool(Item.ToolMaterial.STONE);
        itemHammer.setRepairIngot("").setTranslationKey("hammer_stone").setRegistryName("compham", "stone_hammer");
        itemHammer.setCreativeTab(CompressedHammers.TAB);

        itemCCHammer = new ItemCHTool(TOOL_MATERIAL_COMPRESSED_COBBLESTONE);
        itemCCHammer.setRepairIngot("").setTranslationKey("hammer_compressed").setRegistryName("compham", "compressed_hammer");
        itemCCHammer.setCreativeTab(CompressedHammers.TAB);

        itemDCCHammer = new ItemCHTool(TOOL_MATERIAL_DOUBLE_COMPRESSED_COBBLESTONE);
        itemDCCHammer.setRepairIngot("").setTranslationKey("hammer_double").setRegistryName("compham", "double_hammer");
        itemDCCHammer.setCreativeTab(CompressedHammers.TAB);

        toolDCCHammer = new ItemStack(itemDCCHammer);
        toolCCHammer = new ItemStack(itemCCHammer);
        toolHammer = new ItemStack(itemHammer);

        itemStoneRod = new ItemCHRod();
        itemStoneRod.setTranslationKey("rod_stone").setRegistryName("compham", "stone_rod").setCreativeTab(CompressedHammers.TAB);

        itemDoubleRod = new ItemCHRod();
        itemDoubleRod.setTranslationKey("rod_double").setRegistryName("compham", "double_rod").setCreativeTab(CompressedHammers.TAB);

        itemCompressedRod = new ItemCHRod();
        itemCompressedRod.setTranslationKey("rod_compressed").setRegistryName("compham", "compressed_rod").setCreativeTab(CompressedHammers.TAB);

        itemIronRod = new ItemCHRod();
        itemIronRod.setTranslationKey("rod_iron").setRegistryName("compham", "iron_rod").setCreativeTab(CompressedHammers.TAB);

        stoneRod = new ItemStack(itemStoneRod);
        doubleRod = new ItemStack(itemDoubleRod);
        compressedRod = new ItemStack(itemCompressedRod);
        ironRod = new ItemStack(itemIronRod);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.registerAll(itemHammer, itemCCHammer, itemDCCHammer, itemStoneRod, itemCompressedRod, itemDoubleRod, itemIronRod);

        OreDictionary.registerOre("rodStone", itemStoneRod);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(itemHammer, 0, new ModelResourceLocation(new ResourceLocation("compham", "stone_hammer"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(itemCCHammer, 0, new ModelResourceLocation(new ResourceLocation("compham", "compressed_hammer"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(itemDCCHammer, 0, new ModelResourceLocation(new ResourceLocation("compham", "double_hammer"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(itemStoneRod, 0, new ModelResourceLocation(new ResourceLocation("compham", "stone_rod"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(itemCompressedRod, 0, new ModelResourceLocation(new ResourceLocation("compham", "compressed_rod"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(itemDoubleRod, 0, new ModelResourceLocation(new ResourceLocation("compham", "double_rod"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(itemIronRod, 0, new ModelResourceLocation(new ResourceLocation("compham", "iron_rod"), "inventory"));
    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
    }
}
