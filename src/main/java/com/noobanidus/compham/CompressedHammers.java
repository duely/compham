package com.noobanidus.compham;

import com.noobanidus.compham.init.Config;
import com.noobanidus.compham.proxy.ISidedProxy;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod.EventBusSubscriber
@Mod(modid = CompressedHammers.MODID, name = CompressedHammers.MODNAME, version = CompressedHammers.VERSION, dependencies = CompressedHammers.DEPENDS)
@SuppressWarnings("WeakerAccess")
public class CompressedHammers {
    public static final String MODID = "compham";
    public static final String MODNAME = "CompressedHammers";
    public static final String VERSION = "GRADLE:VERSION";
    public static final String DEPENDS = "required-after:cofhcore;";

    @SuppressWarnings("unused")
    public final static Logger LOG = LogManager.getLogger(MODID);
    public final static Config CONFIG = new Config();

    @SidedProxy(modId = MODID, clientSide = "com.noobanidus.compham.proxy.ClientProxy", serverSide = "com.noobanidus.compham.proxy.CommonProxy")
    public static ISidedProxy proxy;

    public static CompHamCT TAB;

    @Mod.Instance(CompressedHammers.MODID)
    public static CompressedHammers instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void loadComplete(FMLLoadCompleteEvent event) {
        proxy.loadComplete(event);
    }

}
