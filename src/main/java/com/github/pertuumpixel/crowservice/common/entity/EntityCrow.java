package com.github.pertuumpixel.crowservice.common.entity;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class EntityCrow extends TameableEntity {

	protected EntityCrow(EntityType<? extends TameableEntity> p_i48574_1_, World p_i48574_2_) {
		super(p_i48574_1_, p_i48574_2_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		// TODO Auto-generated method stub
		return null;
	}

}
