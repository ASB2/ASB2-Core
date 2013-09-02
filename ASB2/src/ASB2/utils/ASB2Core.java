package ASB2.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid =ASB2Core.MODDID, name = ASB2Core.NAME, version = ASB2Core.VERSION, dependencies = "required-after:Forge@[7.7.1.829,)")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public final class ASB2Core {

    public static final String MODDID = "ASB2-Core";
    public static final String NAME = "ASB2-Core";
    public static final String VERSION = "1.0.0";
    
    @Instance(ASB2Core.MODDID)
    public static ASB2Core instance;
    public static Logger logger = Logger.getLogger(ASB2Core.MODDID);

    public ASB2Core() {
        
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        logger.setParent(FMLLog.getLogger());

        logger.log(Level.INFO," Beginning destruction of known world");

        if (Loader.isModLoaded("Natura") || Loader.isModLoaded("TConstruct")) {

            logger.log(Level.INFO, " Joining mods in world domination");
        }
        instance = this;
    }

    @EventHandler
    public void mainInit(FMLInitializationEvent event) {
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}
