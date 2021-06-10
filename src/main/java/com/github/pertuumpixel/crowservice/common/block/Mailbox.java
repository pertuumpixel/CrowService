package com.github.pertuumpixel.crowservice.common.block;

import java.util.Calendar;

import com.github.pertuumpixel.crowservice.common.item.SealedEnvelope;
import com.github.pertuumpixel.crowservice.core.events.CheckMailboxEvent;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class Mailbox extends Block {

	private long time = 0;

	public Mailbox() {
		super(AbstractBlock.Properties.of(Material.WOOD).harvestTool(ToolType.AXE).sound(SoundType.WOOD).strength(10f,
				15f));

	}

	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult trace) {

		if (player.getItemInHand(handIn).getItem() instanceof SealedEnvelope) {
			SealedEnvelope se = (SealedEnvelope)player.getItemInHand(handIn).getItem();
			player.getItemInHand(handIn).setCount(0);
			return ActionResultType.SUCCESS;
		}

		long current = Calendar.getInstance().getTimeInMillis() / 1000;
		if (time == 0 || current - time > 3) {
			time = current;
			CheckMailboxEvent.getMessage(player);
			return ActionResultType.SUCCESS;

		} else {
			return ActionResultType.FAIL;
		}

	}

}
