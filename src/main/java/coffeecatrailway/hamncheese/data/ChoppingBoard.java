package coffeecatrailway.hamncheese.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
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
            ResourceLocation.CODEC.fieldOf("texture").forGetter(board -> board.texture),
            Codec.STRING.fieldOf("tool_type").forGetter(board -> board.toolType)
    ).apply(instance, ChoppingBoard::new));

    private final String modId;
    private final Block pressurePlate;
    private final SoundEvent convertSound;
    private final ResourceLocation texture;
    private final String toolType;

    private ResourceLocation id;

    public ChoppingBoard(String modId, Block pressurePlate, SoundEvent convertSound, ResourceLocation texture, String toolType)
    {
        this.modId = modId;
        this.pressurePlate = pressurePlate;
        this.convertSound = convertSound;
        this.texture = texture;
        this.toolType = toolType;
    }

    protected void setId(ResourceLocation id)
    {
        this.id = id;
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
    public ResourceLocation getTexture()
    {
        return texture;
    }

    public ToolType getToolType()
    {
        return ToolType.get(this.toolType);
    }
}
