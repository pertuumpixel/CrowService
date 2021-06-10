package com.github.pertuumpixel.crowservice.common.item;


import com.github.pertuumpixel.crowservice.CrowService;

import com.github.pertuumpixel.crowservice.core.init.ItemInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class EmptyEnvelope extends Item {


	public EmptyEnvelope() {
		super(new Item.Properties().tab(CrowService.TAB_GROUP));
	}

	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {

		int slot = playerIn.inventory.getFreeSlot();
		if (slot == -1) {
			return ActionResult.fail(playerIn.getItemInHand(handIn));
		}


		playerIn.addItem(((SealedEnvelope)ItemInit.SEALED_ENVELOPE.get()).setSender(playerIn.getName().getString()).getDefaultInstance());
		return ActionResult.consume(playerIn.getItemInHand(handIn));

	}

}
