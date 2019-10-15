package com.noobanidus.compham.hammerlib.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemTool;

import java.util.Set;

public class ItemHammer extends ItemTool {

	protected ItemHammer (float attackDamageIn, float attackSpeedIn, ToolMaterial materialIn, Set<Block> effectiveBlocksIn) {
		super(attackDamageIn, attackSpeedIn, materialIn, effectiveBlocksIn);
	}

	protected ItemHammer (ToolMaterial materialIn, Set<Block> effectiveBlocksIn) {
		super(materialIn, effectiveBlocksIn);
	}
}
