package com.github.pertuumpixel.crowservice;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.pertuumpixel.crowservice.core.init.BlockInit;
import com.github.pertuumpixel.crowservice.setup.Registration;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(CrowService.MOD_ID)
public class CrowService {
	
	
	public static final CrowServiceGroup TAB_GROUP = new CrowServiceGroup("crowtab");
	public static final String MOD_ID = "crowservice";
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LogManager.getLogger();

	public CrowService() {
		
		Registration.register();
		
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);

		
		

		MinecraftForge.EVENT_BUS.register(this);
		
		
	}

	private void setup(final FMLCommonSetupEvent event) {

	}
	
	public static class CrowServiceGroup extends ItemGroup {

		public CrowServiceGroup(String label) {
			super(label);
			// TODO Auto-generated constructor stub
		}

		@Override
		public ItemStack makeIcon() {
			// TODO Auto-generated method stub
			return BlockInit.MAILBOX.get().asItem().getDefaultInstance();
		}
		
	}

}
