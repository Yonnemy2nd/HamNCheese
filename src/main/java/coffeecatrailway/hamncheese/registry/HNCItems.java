package coffeecatrailway.hamncheese.registry;

import coffeecatrailway.hamncheese.HNCMod;
import coffeecatrailway.hamncheese.common.entity.HNCBoatEntity;
import coffeecatrailway.hamncheese.common.item.*;
import coffeecatrailway.hamncheese.data.gen.HNCLanguage;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.function.Function;

/**
 * @author CoffeeCatRailway
 * Created: 1/02/2021
 */
public class HNCItems
{
    private static final Logger LOGGER = HNCMod.getLogger("Items");
    protected static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HNCMod.MOD_ID);

    // Crafting Ingredients
    public static final RegistryObject<Item> WOODEN_GEAR = registerIdAsName("wooden_gear", Item::new);

    // Tools
    public static final RegistryObject<CraftingToolItem> CURDLER = registerIdAsName("curdler", prop -> new CraftingToolItem(ItemTier.WOOD, 2, 2.5f, prop));
    public static final RegistryObject<CraftingToolItem> ROLLING_PIN = registerIdAsName("rolling_pin", prop -> new CraftingToolItem(ItemTier.WOOD, 1, 2.5f, prop));
    public static final RegistryObject<CraftingToolItem> GRIND_STONES = registerIdAsName("grind_stones", prop -> new CraftingToolItem(ItemTier.STONE, 2, 2.7f, prop));
    public static final RegistryObject<CraftingToolItem> KNIFE = registerIdAsName("knife", prop -> new CraftingToolItem(ItemTier.IRON, 1, 2.5f, prop));

    // Foods
    public static final RegistryObject<Item> CHEESE_SLICE = registerIdAsName("cheese_slice", prop -> new Item(prop.food(HNCFoods.CHEESE_SLICE).stacksTo(32)));

    public static final RegistryObject<Item> ROCK_SALT = registerIdAsName("rock_salt", prop -> new Item(prop.food(HNCFoods.INGREDIENT)));
    public static final RegistryObject<Item> FLOUR = registerIdAsName("flour", prop -> new Item(prop.food(HNCFoods.INGREDIENT)));

    public static final RegistryObject<Item> DOUGH = registerIdAsName("dough", prop -> new Item(prop.food(HNCFoods.DOUGH)));

    public static final RegistryObject<Item> UNBAKED_PIZZA_BASE = registerIdAsName("unbaked_pizza_base", prop -> new Item(prop.food(HNCFoods.DOUGH).stacksTo(32)));
    public static final RegistryObject<Item> BAKED_PIZZA_DUMMY = registerWithName("baked_pizza_dummy", "Baked Pizza Base", prop -> new Item(prop.food(HNCFoods.BREAD_SLICE)));
    public static final RegistryObject<PizzaItem> PIZZA = registerIdAsName("pizza", prop -> new PizzaItem(prop.tab(null).stacksTo(8)));

    public static final RegistryObject<Item> UNBAKED_BREAD = registerIdAsName("unbaked_bread", prop -> new Item(prop.food(HNCFoods.DOUGH)));
    public static final RegistryObject<Item> BREAD_SLICE = registerIdAsName("bread_slice", prop -> new Item(prop.food(HNCFoods.BREAD_SLICE)));
    public static final RegistryObject<Item> TOAST = registerIdAsName("toast", prop -> new Item(prop.food(HNCFoods.TOAST)));

    public static final RegistryObject<Item> UNBAKED_CRACKER = registerIdAsName("unbaked_cracker", prop -> new Item(prop.food(HNCFoods.DOUGH).stacksTo(16)));
    public static final RegistryObject<Item> CRACKER_DUMMY = registerIdAsName("cracker_dummy", prop -> new Item(prop.food(HNCFoods.CRACKER).tab(null)));
    public static final RegistryObject<CrackerItem> CRACKER = registerIdAsName("cracker", prop -> new CrackerItem(prop.stacksTo(16)));

    public static final RegistryObject<Item> CRACKED_EGG = registerIdAsName("cracked_egg", prop -> new Item(prop.food(HNCFoods.CRACKED_EGG).stacksTo(32)));
    public static final RegistryObject<Item> COOKED_EGG = registerIdAsName("cooked_egg", prop -> new Item(prop.food(HNCFoods.COOKED_EGG).stacksTo(32)));
    public static final RegistryObject<GreenFoodItem> GREEN_EGG = registerIdAsName("green_cracked_egg", prop -> new GreenFoodItem(prop, HNCFoods.GREEN_EGG, 32));

    public static final RegistryObject<Item> HAM_SLICE = registerWithName("ham_slice", "Ham Slice", prop -> new Item(prop.food(HNCFoods.HAM_SLICE).stacksTo(32)));
    public static final RegistryObject<Item> COOKED_HAM_SLICE = registerIdAsName("cooked_ham_slice", prop -> new Item(prop.food(HNCFoods.COOKED_HAM_SLICE).stacksTo(32)));
    public static final RegistryObject<GreenFoodItem> GREEN_HAM_SLICE = registerIdAsName("green_ham_slice", prop -> new GreenFoodItem(prop, HNCFoods.GREEN_HAM_SLICE, 32));

    public static final RegistryObject<Item> BACON = registerWithName("bacon", "Raw Bacon", prop -> new Item(prop.food(HNCFoods.BACON).stacksTo(32)));
    public static final RegistryObject<Item> COOKED_BACON = registerWithName("cooked_bacon", "Bacon", prop -> new Item(prop.food(HNCFoods.COOKED_BACON).stacksTo(32)));

    public static final RegistryObject<SandwichItem> SANDWICH = registerIdAsName("sandwich", prop -> new SandwichItem(prop.tab(null).stacksTo(8)));

    public static final RegistryObject<BlockNamedItem> PINEAPPLE_PLANT = registerIdAsName("pineapple_plant", prop -> new BlockNamedItem(HNCBlocks.PINEAPPLE_PLANT.get(), prop));
    public static final RegistryObject<Item> PINEAPPLE = registerIdAsName("pineapple", prop -> new Item(prop.food(HNCFoods.PINEAPPLE).stacksTo(16)));
    public static final RegistryObject<Item> PINEAPPLE_RING = registerIdAsName("pineapple_ring", prop -> new Item(prop.food(HNCFoods.PINEAPPLE_RING).stacksTo(32)));
    public static final RegistryObject<Item> PINEAPPLE_BIT = registerIdAsName("pineapple_bit", prop -> new Item(prop.food(HNCFoods.PINEAPPLE_BIT).stacksTo(32)));

    public static final RegistryObject<Item> TOMATO_SEEDS = registerIdAsName("tomato_seeds", prop -> new BlockNamedItem(HNCBlocks.TOMATO_PLANT.get(), prop));
    public static final RegistryObject<Item> TOMATO = registerIdAsName("tomato", prop -> new Item(prop.food(HNCFoods.TOMATO).stacksTo(32)));
    public static final RegistryObject<Item> TOMATO_SAUCE = registerIdAsName("tomato_sauce", prop -> new Item(prop.food(HNCFoods.TOMATO_SAUCE).stacksTo(1)));
    public static final RegistryObject<Item> TOMATO_SLICE = registerIdAsName("tomato_slice", prop -> new Item(prop.food(HNCFoods.TOMATO_SLICE)));

    public static final RegistryObject<Item> CORN_COB = registerIdAsName("corn_cob", prop -> new BlockNamedItem(HNCBlocks.CORN_PLANT.get(), prop.food(HNCFoods.CORN_COB).stacksTo(32)));
    public static final RegistryObject<Item> CORN_KERNELS = registerIdAsName("corn_kernels", prop -> new Item(prop.food(HNCFoods.CORN_KERNELS)));
    public static final RegistryObject<Item> DRIED_CORN_KERNELS = registerIdAsName("dried_corn_kernels", prop -> new Item(prop.food(HNCFoods.CORN_KERNELS)));

    public static final RegistryObject<Item> POPCORN_BAG = registerIdAsName("popcorn_bag", Item::new);
    public static final RegistryObject<PopcornItem> POPCORN = registerIdAsName("popcorn", prop -> new PopcornItem(prop.food(HNCFoods.POPCORN)));
    public static final RegistryObject<PopcornItem> CHEESY_POPCORN = registerIdAsName("cheesy_popcorn", prop -> new PopcornItem(prop.food(HNCFoods.CHEESY_POPCORN)));
    public static final RegistryObject<PopcornItem> CARAMEL_POPCORN = registerIdAsName("caramel_popcorn", prop -> new PopcornItem(prop.food(HNCFoods.CARAMEL_POPCORN)));
    public static final RegistryObject<PopcornItem> MAPLE_POPCORN = registerIdAsName("maple_popcorn", prop -> new PopcornItem(prop.food(HNCFoods.MAPLE_POPCORN)));

    public static final RegistryObject<Item> MOUSE = registerIdAsName("mouse", prop -> new Item(prop.food(HNCFoods.MOUSE)));
    public static final RegistryObject<Item> COOKED_MOUSE = registerIdAsName("cooked_mouse", prop -> new Item(prop.food(HNCFoods.COOKED_MOUSE)));

    public static final RegistryObject<Item> FOOD_SCRAPS = registerIdAsName("food_scraps", prop -> new Item(prop.food(HNCFoods.FOOD_SCRAPS)));

    // Misc
    public static final RegistryObject<HNCBoatItem> MAPLE_BOAT = registerIdAsName("maple_boat", prop -> new HNCBoatItem(HNCBoatEntity.ModType.MAPLE, prop));

    public static final RegistryObject<BucketItem> MAPLE_SAP_BUCKET = registerIdAsName("maple_sap_bucket", prop -> new BucketItem(HNCFluids.MAPLE_SAP, prop.craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<FoodBottleItem> MAPLE_SAP_BOTTLE = registerIdAsName("maple_sap_bottle", prop -> new FoodBottleItem(prop.food(HNCFoods.MAPLE_SAP_BOTTLE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1)));
    public static final RegistryObject<FoodBottleItem> MAPLE_SYRUP = registerIdAsName("maple_syrup", prop -> new FoodBottleItem(prop.food(HNCFoods.MAPLE_SYRUP).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1)));

    protected static <T extends Item> RegistryObject<T> registerIdAsName(String id, Function<Item.Properties, T> factory)
    {
        return registerWithName(id, null, factory);
    }

    private static <T extends Item> RegistryObject<T> registerWithName(String id, @Nullable String name, Function<Item.Properties, T> factory)
    {
        return register(id, name, true, factory);
    }

    private static <T extends Item> RegistryObject<T> register(String id, @Nullable String name, boolean addLang, Function<Item.Properties, T> factory)
    {
        RegistryObject<T> object = ITEMS.register(id, () -> factory.apply(new Item.Properties().tab(HNCMod.GROUP_ALL)));
        if (addLang)
            HNCLanguage.ITEMS.put(object, name == null ? HNCLanguage.capitalize(id) : name);
        return object;
    }

    public static void load(IEventBus bus)
    {
        LOGGER.debug("Loaded");
        ITEMS.register(bus);
    }
}
