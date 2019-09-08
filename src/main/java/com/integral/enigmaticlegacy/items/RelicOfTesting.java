package com.integral.enigmaticlegacy.items;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.integral.enigmaticlegacy.handlers.SuperpositionHandler;
import com.integral.enigmaticlegacy.helpers.LoreHelper;

import net.minecraft.client.gui.screen.ControlsScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class RelicOfTesting extends Item {
	
 public static Properties integratedProperties = new Item.Properties();
 public static Random lootRandomizer = new Random();

 public RelicOfTesting(Properties properties) {
		super(properties);
 }
 
 public static Properties setupIntegratedProperties() {
	 //integratedProperties.group(EnigmaticLegacy.enigmaticTab);
	 integratedProperties.maxStackSize(1);
	 integratedProperties.rarity(Rarity.EPIC);
	 
	 return integratedProperties;
 
 }
 
 public static void initConfigValues() {}
 
 @OnlyIn(Dist.CLIENT)
 public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> list, ITooltipFlag flagIn) {
	 if(ControlsScreen.hasShiftDown()) {
		 LoreHelper.addLocalizedString(list, "tooltip.enigmaticlegacy.relicOfTesting1");
	 } else {
		 LoreHelper.addLocalizedString(list, "tooltip.enigmaticlegacy.holdShift");
	 }
	 
	 LoreHelper.addLocalizedString(list, "tooltip.enigmaticlegacy.void");
 }
 
 
 @Override
 public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
	 
	 ItemStack itemstack = playerIn.getHeldItem(handIn);
	 playerIn.setActiveHand(handIn);
	 	 
	 SuperpositionHandler.setSpellstoneCooldown(playerIn, 0);
	 
	 playerIn.swingArm(handIn);

     return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
        
 }
 
 /*
 public ActionResultType onItemUse(ItemUseContext context) {
	 PlayerEntity player = context.getPlayer();
	 World world = context.getWorld();
	 //ItemStack stack = context.getItem();
	 
	 if (world.getBlockState(context.getPos()).hasTileEntity()) {
		 if (world.getTileEntity(context.getPos()) instanceof ChestTileEntity) {
			 ChestTileEntity chest = (ChestTileEntity) world.getTileEntity(context.getPos());
			 
			 
			 if (context.getFace() != Direction.UP) {
				 chest.clear();
		 	 } else {
				 chest.setLootTable(LootTables.CHESTS_SIMPLE_DUNGEON, lootRandomizer.nextLong());
				 chest.fillWithLoot(player);
			 }
			 
			 return ActionResultType.SUCCESS;
		 }
	 }
	 
     return ActionResultType.PASS;
  }
 */
  
}