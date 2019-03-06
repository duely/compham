package com.noobanidus.compham.item;

import cofh.core.item.tool.ItemHammerCore;
import com.noobanidus.compham.CompressedHammers;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemCHTool extends ItemHammerCore {
    public ItemCHTool(ToolMaterial toolMaterial) {
        super(toolMaterial);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (!CompressedHammers.CONFIG.ALL_ENABLED) {
            tooltip.add("");
            tooltip.add(TextFormatting.RED + "" + TextFormatting.BOLD + I18n.format("compham.tooltip.disabled"));
        }
    }
}
