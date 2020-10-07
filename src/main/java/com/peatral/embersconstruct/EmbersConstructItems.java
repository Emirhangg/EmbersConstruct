package com.peatral.embersconstruct;

import com.peatral.embersconstruct.item.ItemEmbersConstruct;
import com.peatral.embersconstruct.item.ItemStamp;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@GameRegistry.ObjectHolder(EmbersConstruct.MODID)
public class EmbersConstructItems {
    public static List<Item> items = new ArrayList<>();
    public static final Item StampRaw = new ItemStamp(true);
    public static final Item Stamp = new ItemStamp();

    public static final Item WroughtIronIngot = new ItemEmbersConstruct();

    public static void main(IForgeRegistry<Item> registry) {
        registerItems(registry);
    }

    public static void registerItems(IForgeRegistry<Item> registry) {
        registry.register(init(StampRaw, "stamp_raw"));
        registry.register(init(Stamp, "stamp"));
        registry.register(init(WroughtIronIngot, "wroughtIronIngot"));
    }

    public static Item init(Item item, String name) {
        item = item.setUnlocalizedName(EmbersConstruct.MODID + "." + name).setRegistryName(new ResourceLocation(EmbersConstruct.MODID, name));
        items.add(item);
        return item;
    }
}
