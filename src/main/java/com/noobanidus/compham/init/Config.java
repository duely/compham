package com.noobanidus.compham.init;

import com.noobanidus.compham.CompressedHammers;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Config {
    private final Configuration CONFIG = new Configuration(new File("config", "compham.cfg"), true);

    private final String[] STONE_ENTRIES;
    private final String[] COMPRESSED_ENTRIES;
    private final String[] DOUBLE_ENTRIES;

    private List<ItemStack> stoneEntriesList = null;
    private List<ItemStack> compressedEntriesList = null;
    private List<ItemStack> doubleEntriesList = null;

    public boolean STONE_ENABLED;
    public boolean ALL_ENABLED = true;

    public Config() {
        STONE_ENTRIES = CONFIG.get("General", "StoneTypes", new String[]{"minecraft:stone:0", "minecraft:stone:1", "minecraft:stone:2", "minecraft:stone:3", "minecraft:stone:4", "minecraft:stone:5", "minecraft:stone:6", "ore:blockStone", "ore:cobblestone"}, "List of blocks considered stone for the stone hammer.").getStringList();

        COMPRESSED_ENTRIES = CONFIG.get("General", "CompressedStoneTypes", new String[]{"extrautils2:compressedcobblestone"}, "List of blocks considered compressed stone for the compressed hammer").getStringList();

        DOUBLE_ENTRIES = CONFIG.get("General", "DoubleCompressedStoneTypes", new String[]{"extrautils2:compressedcobblestone:1"}, "List of blocks considered double-compressed stone for the double-compressed hammer").getStringList();

        STONE_ENABLED = CONFIG.get("General", "EnableStoneHammer", true, "Set to false to disable the simple stone hammer recipe.").getBoolean();
    }

    private List<ItemStack> getStacksFromEntry(String[] entryList) {
        List<ItemStack> result = new ArrayList<>();

        for (String entry : entryList) {
            if (entry.startsWith("ore:")) {
                NonNullList<ItemStack> ores = OreDictionary.getOres(entry.substring(4), false);
                result.addAll(ores);
                if (ores.size() == 0) {
                    CompressedHammers.LOG.info(String.format("Specified ore: \"%s\" does not have any entries registered for it.", entry.substring(4)));
                }
            } else {
                String[] split = entry.split(":");
                if (split.length == 2 || split.length == 3) {
                    Item item = Item.REGISTRY.getObject(new ResourceLocation(split[0], split[1]));
                    if (item != null) {
                        int meta = 0;

                        if (split.length == 3) {
                            meta = Integer.parseInt(split[2]);
                        }

                        ItemStack stack = new ItemStack(item, 1, meta);
                        result.add(stack);
                    } else {
                        CompressedHammers.LOG.info(String.format("Specified item \"%s\" does not exist.", entry));
                    }
                }
            }
        }

        return result;
    }

    public List<ItemStack> getStoneEntriesList() {
        if (stoneEntriesList == null) {
            stoneEntriesList = getStacksFromEntry(STONE_ENTRIES);
        }

        return stoneEntriesList;
    }

    public List<ItemStack> getCompressedEntriesList() {
        if (compressedEntriesList == null) {
            compressedEntriesList = getStacksFromEntry(COMPRESSED_ENTRIES);

            if (compressedEntriesList.size() == 0) {
                ALL_ENABLED = false;
            }
        }

        return compressedEntriesList;
    }

    public List<ItemStack> getDoubleEntriesList() {
        if (doubleEntriesList == null) {
            doubleEntriesList = getStacksFromEntry(DOUBLE_ENTRIES);

            if (doubleEntriesList.size() == 0) {
                ALL_ENABLED = false;
            }
        }

        return doubleEntriesList;
    }

    public void save() {
        CONFIG.save();
    }
}
