package com.github.pertuumpixel.crowservice.common.block.coin_press;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;
import org.apache.logging.log4j.core.jmx.Server;

import javax.annotation.Nullable;

public class CoinPressBlock extends Block {

	public static final DirectionProperty FACING = HorizontalBlock.FACING;


	public CoinPressBlock() {
		super(AbstractBlock.Properties
				.of(Material.HEAVY_METAL)
				.sound(SoundType.METAL)
				.strength(4f, 20f));

	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}


	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new CoinPressTileEntity();
	}


	@SuppressWarnings("deprecation")
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult rayTrace) {
		if(worldIn.isClientSide){
			return ActionResultType.SUCCESS;
		}
		this.interactWith(worldIn, pos, playerIn);
		return ActionResultType.CONSUME;
	}

	private void interactWith(World worldIn, BlockPos pos, PlayerEntity playerIn) {
		TileEntity tileEntity = worldIn.getBlockEntity(pos);
		if(tileEntity instanceof CoinPressTileEntity && playerIn instanceof ServerPlayerEntity){
			CoinPressTileEntity te = (CoinPressTileEntity) tileEntity;
			NetworkHooks.openGui((ServerPlayerEntity) playerIn, te, te::encodeExtraData);
		}
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onRemove(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (!state.is(newState.getBlock())){
			TileEntity tileEntity = worldIn.getBlockEntity(pos);
			if(tileEntity instanceof IInventory) {
				InventoryHelper.dropContents(worldIn, pos, (IInventory) tileEntity);
				worldIn.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, worldIn, pos, newState, isMoving);
		}
	}

	@Override
	public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}



	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}


	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
}
