package coffeecatrailway.hamncheese.common.world;

import coffeecatrailway.hamncheese.HNCMod;
import com.mojang.datafixers.util.Pair;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.structure.DesertVillagePools;
import net.minecraft.world.gen.feature.structure.PlainsVillagePools;
import net.minecraft.world.gen.feature.structure.SnowyVillagePools;
import net.minecraft.world.gen.feature.structure.TaigaVillagePools;
import net.minecraft.world.gen.feature.template.ProcessorLists;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * @author CoffeeCatRailway
 * Created: 4/05/2021
 */
public class VillagePoolsHelper
{
    private static final Logger LOGGER = HNCMod.getLogger("VillagePools");

    public static void bootstrap()
    {
        PlainsVillagePools.bootstrap();
        SnowyVillagePools.bootstrap();
        DesertVillagePools.bootstrap();
        TaigaVillagePools.bootstrap();

        addPiece("plains", HNCMod.SERVER_CONFIG.plainsRestaurantWeight.get());
        addPiece("desert", HNCMod.SERVER_CONFIG.desertRestaurantWeight.get());
        addPiece("snowy", HNCMod.SERVER_CONFIG.snowyRestaurantWeight.get());
        addPiece("taiga", HNCMod.SERVER_CONFIG.taigaRestaurantWeight.get());
    }

    private static void addPiece(final String biome, final int weight)
    {
        ResourceLocation patternId = new ResourceLocation("village/" + biome + "/houses");
        final JigsawPattern pattern = WorldGenRegistries.TEMPLATE_POOL.get(patternId);
        if (pattern == null)
        {
            LOGGER.warn("Jigsaw pattern {} is null", patternId);
            return;
        }

        final JigsawPiece piece = JigsawPiece.legacy(HNCMod.MOD_ID + ":village/" + biome + "/houses/" + biome + "_restaurant_1", ProcessorLists.MOSSIFY_10_PERCENT).apply(JigsawPattern.PlacementBehaviour.RIGID);

        final List<JigsawPiece> templates = ObfuscationReflectionHelper.getPrivateValue(JigsawPattern.class, pattern, "field_214953_e");
        final List<Pair<JigsawPiece, Integer>> rawTemplates = ObfuscationReflectionHelper.getPrivateValue(JigsawPattern.class, pattern, "field_214952_d");
        if (templates == null)
        {
            LOGGER.warn("Template list {} is null", biome);
            return;
        }
        if (rawTemplates == null)
        {
            LOGGER.warn("Raw template list {} is null", biome);
            return;
        }

        for (int i = 0; i < weight; i++)
            templates.add(piece);
        rawTemplates.add(Pair.of(piece, weight));
    }
}
