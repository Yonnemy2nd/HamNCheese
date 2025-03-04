package coffeecatrailway.hamncheese.data;

import coffeecatrailway.hamncheese.HNCMod;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

/**
 * @author CoffeeCatRailway
 * Created: 3/05/2021
 */
public class ChoppingBoard
{
    public static final Codec<ChoppingBoard> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.optionalFieldOf("mod", "minecraft").forGetter(board -> board.modId),
            Registry.BLOCK.fieldOf("pressure_plate").forGetter(board -> board.pressurePlate),
            SoundEvent.CODEC.fieldOf("convert_sound").forGetter(board -> board.convertSound),
            ResourceLocation.CODEC.fieldOf("model").forGetter(board -> board.model),
            Codec.STRING.fieldOf("tool_type").forGetter(board -> board.toolType)
    ).apply(instance, ChoppingBoard::new));
    public static final ChoppingBoard DEFAULT = new ChoppingBoard("minecraft", Blocks.STONE_PRESSURE_PLATE, SoundEvents.STONE_PLACE, HNCMod.getLocation("chopping_board/stone"), "pickaxe");

    private final String modId;
    private final Block pressurePlate;
    private final SoundEvent convertSound;
    private final ResourceLocation model;
    private final String toolType;

    private ResourceLocation id;

    public ChoppingBoard(String modId, Block pressurePlate, SoundEvent convertSound, ResourceLocation model, String toolType)
    {
        this.modId = modId;
        this.pressurePlate = pressurePlate;
        this.convertSound = convertSound;
        this.model = model;
        this.toolType = toolType;
    }

    protected ChoppingBoard setId(ResourceLocation id)
    {
        this.id = id;
        return this;
    }

    public ResourceLocation getId()
    {
        return this.id;
    }

    public Block getPressurePlate()
    {
        return this.pressurePlate;
    }

    public SoundEvent getConvertSound()
    {
        return this.convertSound;
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getModel()
    {
        return model;
    }

    public ToolType getToolType()
    {
        return ToolType.get(this.toolType);
    }
}
