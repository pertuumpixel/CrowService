package com.github.pertuumpixel.crowservice.core.events;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;

public class CheckMailboxEvent {

	public static void getMessage(PlayerEntity player) {
		player.sendMessage(new TranslationTextComponent("§6You have no new mail"), null);
	}

}
