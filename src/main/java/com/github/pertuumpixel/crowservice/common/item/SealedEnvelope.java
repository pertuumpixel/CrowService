package com.github.pertuumpixel.crowservice.common.item;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.glfw.GLFW;

import com.github.pertuumpixel.crowservice.CrowService;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SealedEnvelope extends Item {

	
	private String sender = "";
	private String reciever = "";

	public SealedEnvelope() {
		super(new Item.Properties().tab(CrowService.TAB_GROUP).stacksTo(1));

	}

	public SealedEnvelope setSender(String name) {
		sender = name;
		return this;
	}

	public SealedEnvelope setReciever(String name) {
		reciever = name;
		return this;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		if (InputMappings.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
			tooltip.add(new StringTextComponent("§6Sender: " + sender));
			tooltip.add(new StringTextComponent("§6Reciever: " + reciever));
		} else {
			tooltip.add(new TranslationTextComponent("tooltip.sealed_envelope.hold_shift"));
		}
	}


	
}
