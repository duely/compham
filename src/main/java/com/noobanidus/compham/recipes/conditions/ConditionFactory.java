package com.noobanidus.compham.recipes.conditions;

import com.google.gson.JsonObject;
import com.noobanidus.compham.CompressedHammers;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

import java.util.function.BooleanSupplier;

public class ConditionFactory {
    public static class StoneHammer implements IConditionFactory {
        @Override
        public BooleanSupplier parse(JsonContext context, JsonObject json) {
            return () -> CompressedHammers.CONFIG.STONE_ENABLED && CompressedHammers.CONFIG.ALL_ENABLED;
        }
    }
}
