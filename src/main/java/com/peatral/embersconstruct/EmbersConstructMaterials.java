package com.peatral.embersconstruct;

import com.google.common.eventbus.Subscribe;
import com.peatral.embersconstruct.util.OreDictValues;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class EmbersConstructMaterials {

    public static final Map<String, Material> materials;
    public static final Map<String, MaterialIntegration> materialIntegrations;
    public static final Map<String, CompletionStage<?>> materialIntegrationStages;
    public static final Map<String, String> materialOreDicts;

    static {
        materials = new LinkedHashMap();
        materialIntegrations = new Object2ObjectOpenHashMap();
        materialIntegrationStages = new Object2ObjectOpenHashMap();
        materialOreDicts = new Object2ObjectOpenHashMap();
    }

    public static final Material wroughtiron = mat("wroughtiron", 0xcacaca);

    public static void main() {
        initMaterials();
        addStats();
        integrate();
    }

    public static void initMaterials() {
        //wroughtiron.addCommonItems("Iron");
        wroughtiron.addItem(EmbersConstructItems.WroughtIronIngot, 1, OreDictValues.INGOT.getValue());
        wroughtiron.setRepresentativeItem(EmbersConstructItems.WroughtIronIngot);
        wroughtiron.addTrait(TinkerTraits.magnetic2, MaterialTypes.HEAD).addTrait(TinkerTraits.magnetic);
        wroughtiron.setCraftable(true);
    }

    public static void addStats() {
        TinkerRegistry.addMaterialStats(wroughtiron,
                new HeadMaterialStats(194, 6.00f, 4.00f, HarvestLevels.DIAMOND),
                new HandleMaterialStats(0.85f, 60),
                new ExtraMaterialStats(32),
                new BowMaterialStats(0.5f, 1.5f, 7f));
    }

    public static void integrate() {
        materials.forEach((k, v) -> {
            if (!materialIntegrations.containsKey(k)) {
                ((CompletionStage)materialIntegrationStages.getOrDefault(k, CompletableFuture.completedFuture((Object)null))).thenRun(() -> {
                    MaterialIntegration mi = new MaterialIntegration(v);

                    if (materialOreDicts.containsKey(k)) {
                        mi.representativeItem = (String)materialOreDicts.get(k);
                    }

                    TinkerRegistry.integrate(mi).preInit();
                    materialIntegrations.put(k, mi);
                });
            }

        });
    }

    private static Material mat(String name, int color) {
        // make materials hidden by default, integration will make them visible if integrated
        Material mat = new Material(name, color, true);
        materials.put(name, mat);
        return mat;
    }


}
