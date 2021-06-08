package com.github.pertuumpixel.crowservice.core.init;




import com.github.pertuumpixel.crowservice.CrowService;
import com.github.pertuumpixel.crowservice.common.item.CopperCoin;
import com.github.pertuumpixel.crowservice.common.item.EmptyEnvelope;
import com.github.pertuumpixel.crowservice.common.item.GoldCoin;
import com.github.pertuumpixel.crowservice.common.item.SealedEnvelope;
import com.github.pertuumpixel.crowservice.common.item.SilverCoin;
import com.github.pertuumpixel.crowservice.setup.Registration;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ItemInit {
	
	public static void register() {}
	
	

	public static final RegistryObject<Item> EMPTY_ENVELOPE = Registration.ITEMS.register("empty_envelope",
			() -> new EmptyEnvelope());

	public static final RegistryObject<Item> SEALED_ENVELOPE = Registration.ITEMS.register("sealed_envelope",
			() -> new SealedEnvelope());

	
	public static final RegistryObject<Item> SILVER_INGOT = Registration.ITEMS.register("silver_ingot", 
			() -> new Item(new Item.Properties().tab(CrowService.TAB_GROUP)));
	
	public static final RegistryObject<Item> COPPER_INGOT = Registration.ITEMS.register("copper_ingot", 
			() -> new Item(new Item.Properties().tab(CrowService.TAB_GROUP)));
	
	
	
	//Currency
	
	public static final RegistryObject<Item> COPPER_COIN = Registration.ITEMS.register("copper_coin", 
			() -> new CopperCoin());
	
	public static final RegistryObject<Item> SILVER_COIN = Registration.ITEMS.register("silver_coin", 
			() -> new SilverCoin());
	
	public static final RegistryObject<Item> GOLD_COIN = Registration.ITEMS.register("gold_coin", 
			() -> new GoldCoin());
	
	
	
	


}
