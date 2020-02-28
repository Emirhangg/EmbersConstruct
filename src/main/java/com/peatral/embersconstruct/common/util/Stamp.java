package com.peatral.embersconstruct.common.util;

import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.registries.IForgeRegistryEntry;
import slimeknights.tconstruct.library.tinkering.MaterialItem;
import slimeknights.tconstruct.library.tools.IToolPart;

public class Stamp extends IForgeRegistryEntry.Impl<Stamp> {
    private Item item;
    private String name;
    private int cost;
    private Fluid fluid;
    private String oreDictKey;

    public Stamp(String oreDict, String name, int cost) {
        this(null, name, cost, null, oreDict);
    }

    public Stamp(MaterialItem item, String name) {
        this(item, name, item instanceof IToolPart ? ((IToolPart) item).getCost() : MeltingValues.INGOT.getValue());
    }

    public Stamp(Item item, String name, int cost) {
        this(item, name, cost, null, null);
    }

    public Stamp(Item item, String name, int cost, Fluid fluid) {
        this(item, name, cost, fluid, null);
    }

    public Stamp(Item item, String name, int cost, Fluid fluid, String oreDict) {
        this.item = item;
        this.name = name;
        this.cost = cost;
        this.fluid = fluid;
        this.oreDictKey = oreDict;
    }

    public Item getItem() {
        return item;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public Fluid getFluid() {
        return fluid;
    }

    public boolean usesCustomFluid() {
        return fluid != null;
    }

    public String getOreDictKey() {
        return oreDictKey;
    }

    public boolean usesOreDictKey() {
        return oreDictKey != null;
    }


}
