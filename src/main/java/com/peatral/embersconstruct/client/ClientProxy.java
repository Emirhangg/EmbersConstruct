package com.peatral.embersconstruct.client;

import com.peatral.embersconstruct.client.render.EmbersConstructRenderer;
import com.peatral.embersconstruct.common.CommonProxy;
import com.peatral.embersconstruct.common.EmbersConstruct;
import com.peatral.embersconstruct.common.EmbersConstructItems;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void registerItemRenders() {
        registerItemRender(EmbersConstructItems.StampRaw);
        registerItemRender(EmbersConstructItems.Stamp);
    }

    public void registerItemRender(Item item) {
        EmbersConstructRenderer.registerItemRender(EmbersConstruct.MODID, item);
    }
}