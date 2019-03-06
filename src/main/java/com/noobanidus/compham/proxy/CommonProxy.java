package com.noobanidus.compham.proxy;

import com.noobanidus.compham.CompHamCT;
import com.noobanidus.compham.CompressedHammers;
import com.noobanidus.compham.init.Config;
import com.noobanidus.compham.init.Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy implements ISidedProxy {
    public void preInit(FMLPreInitializationEvent event) {
        CompressedHammers.TAB = new CompHamCT(CreativeTabs.getNextID(), CompressedHammers.MODID);
        Items.preInit();
    }

    public void init(FMLInitializationEvent event) {
        Config conf = CompressedHammers.CONFIG;
        conf.getStoneEntriesList().forEach( k -> {
            if (k != null && !k.isEmpty()) {
                OreDictionary.registerOre("hammerStone", k);
            }
        });
        conf.getCompressedEntriesList().forEach( k -> {
            if (k != null && !k.isEmpty()) {
                OreDictionary.registerOre("hammerCompressedStone", k);
            }
        });
        conf.getDoubleEntriesList().forEach( k -> {
            if (k != null && !k.isEmpty()) {
                OreDictionary.registerOre("hammerDoubleStone", k);
            }
        });
    }

    public void postInit(FMLPostInitializationEvent event) {
    }

    public void loadComplete(FMLLoadCompleteEvent event) {
        CompressedHammers.LOG.info("CompressedHammers: Load Complete.");
        CompressedHammers.CONFIG.save();
    }

    public void serverStarting(FMLServerStartingEvent event) {
    }

    public void serverStarted(FMLServerStartedEvent event) {
    }
}
