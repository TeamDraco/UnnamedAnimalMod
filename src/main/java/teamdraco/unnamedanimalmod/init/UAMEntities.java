package teamdraco.unnamedanimalmod.init;

import teamdraco.unnamedanimalmod.UnnamedAnimalMod;
import teamdraco.unnamedanimalmod.common.entity.item.GreaterPrairieChickenEggEntity;
import teamdraco.unnamedanimalmod.common.entity.item.MangroveSnakeEggEntity;
import teamdraco.unnamedanimalmod.common.entity.item.MarineIguanaEggEntity;
import teamdraco.unnamedanimalmod.common.entity.item.PlatypusEggEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import teamdraco.unnamedanimalmod.common.entity.*;

public class UAMEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, UnnamedAnimalMod.MOD_ID);

    public static final RegistryObject<EntityType<BlackDiamondStingrayEntity>> BLACK_DIAMOND_STINGRAY = create("black_diamond_stingray", EntityType.Builder.of(BlackDiamondStingrayEntity::new, MobCategory.WATER_CREATURE).sized(0.8f, 0.2f));
    public static final RegistryObject<EntityType<TomatoFrogEntity>> TOMATO_FROG = create("tomato_frog", EntityType.Builder.of(TomatoFrogEntity::new, MobCategory.CREATURE).sized(0.4f, 0.35f));
    public static final RegistryObject<EntityType<SouthernRightWhaleEntity>> SOUTHERN_RIGHT_WHALE = create("southern_right_whale", EntityType.Builder.of(SouthernRightWhaleEntity::new, MobCategory.WATER_CREATURE).sized(5.5f, 4.25f));
    public static final RegistryObject<EntityType<GreaterPrairieChickenEntity>> GREATER_PRAIRIE_CHICKEN = create("greater_prairie_chicken", EntityType.Builder.of(GreaterPrairieChickenEntity::new, MobCategory.CREATURE).sized(0.8f, 0.8f));
    public static final RegistryObject<EntityType<FlashlightFishEntity>> FLASHLIGHT_FISH = create("flashlight_fish", EntityType.Builder.of(FlashlightFishEntity::new, MobCategory.WATER_AMBIENT).sized(0.25f, 0.25f));
    public static final RegistryObject<EntityType<HumpheadParrotfishEntity>> HUMPHEAD_PARROTFISH = create("humphead_parrotfish", EntityType.Builder.of(HumpheadParrotfishEntity::new, MobCategory.WATER_CREATURE).sized(0.9f, 0.7f));
    public static final RegistryObject<EntityType<MuskOxEntity>> MUSK_OX = create("musk_ox", EntityType.Builder.of(MuskOxEntity::new, MobCategory.CREATURE).sized(1.2f, 1.3f));
    public static final RegistryObject<EntityType<BananaSlugEntity>> BANANA_SLUG = create("banana_slug", EntityType.Builder.of(BananaSlugEntity::new, MobCategory.CREATURE).sized(0.4f, 0.3f));
    public static final RegistryObject<EntityType<MarineIguanaEntity>> MARINE_IGUANA = create("marine_iguana", EntityType.Builder.of(MarineIguanaEntity::new, MobCategory.CREATURE).sized(0.6f, 0.4f));
    public static final RegistryObject<EntityType<PlatypusEntity>> PLATYPUS = create("platypus", EntityType.Builder.of(PlatypusEntity::new, MobCategory.CREATURE).sized(0.6f, 0.4f));
    public static final RegistryObject<EntityType<ElephantnoseFishEntity>> ELEPHANTNOSE_FISH = create("elephantnose_fish", EntityType.Builder.of(ElephantnoseFishEntity::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.3f));
    public static final RegistryObject<EntityType<PacmanFrogEntity>> PACMAN_FROG = create("pacman_frog", EntityType.Builder.of(PacmanFrogEntity::new, MobCategory.CREATURE).sized(0.5f, 0.4f));
    public static final RegistryObject<EntityType<CapybaraEntity>> CAPYBARA = create("capybara", EntityType.Builder.of(CapybaraEntity::new, MobCategory.CREATURE).sized(0.8f, 1.1f));
    public static final RegistryObject<EntityType<RocketKillifishEntity>> ROCKET_KILLIFISH = create("rocket_killifish", EntityType.Builder.of(RocketKillifishEntity::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.15f));
    public static final RegistryObject<EntityType<MangroveSnakeEntity>> MANGROVE_SNAKE = create("mangrove_snake", EntityType.Builder.of(MangroveSnakeEntity::new, MobCategory.WATER_AMBIENT).sized(1.0f, 0.3f));
    // public static final RegistryObject<EntityType<BlubberJellyEntity>> BLUBBER_JELLY = create("blubber_jelly", EntityType.Builder.create(BlubberJellyEntity::new, MobCategory.WATER_AMBIENT).size(0.4f, 0.25f));
    public static final RegistryObject<EntityType<FiddlerCrabEntity>> FIDDLER_CRAB = create("fiddler_crab", EntityType.Builder.of(FiddlerCrabEntity::new, MobCategory.CREATURE).sized(0.65f, 0.325f));
    public static final RegistryObject<EntityType<LeafySeadragonEntity>> LEAFY_SEADRAGON = create("leafy_seadragon", EntityType.Builder.of(LeafySeadragonEntity::new, MobCategory.WATER_AMBIENT).sized(0.4f, 0.3f));
    public static final RegistryObject<EntityType<SpottedGardenEelEntity>> SPOTTED_GARDEN_EEL = create("spotted_garden_eel", EntityType.Builder.of(SpottedGardenEelEntity::new, MobCategory.WATER_CREATURE).sized(0.35f, 0.35f));
    public static final RegistryObject<EntityType<MudskipperEntity>> MUDSKIPPER = create("mudskipper", EntityType.Builder.of(MudskipperEntity::new, MobCategory.WATER_CREATURE).sized(0.7f, 0.35f));

    public static final RegistryObject<EntityType<GreaterPrairieChickenEggEntity>> GREATER_PRAIRIE_CHICKEN_EGG = create("greater_prairie_chicken_egg", EntityType.Builder.<GreaterPrairieChickenEggEntity>of(GreaterPrairieChickenEggEntity::new, MobCategory.MISC).sized(0.25f, 0.25f));
    public static final RegistryObject<EntityType<PlatypusEggEntity>> PLATYPUS_EGG = create("platypus_egg", EntityType.Builder.<PlatypusEggEntity>of(PlatypusEggEntity::new, MobCategory.MISC).sized(0.25f, 0.25f));
    public static final RegistryObject<EntityType<MarineIguanaEggEntity>> MARINE_IGUANA_EGG = create("marine_iguana_egg", EntityType.Builder.<MarineIguanaEggEntity>of(MarineIguanaEggEntity::new, MobCategory.MISC).sized(0.25f, 0.25f));
    public static final RegistryObject<EntityType<MangroveBoatEntity>> MANGROVE_BOAT = create("mangrove_boat", EntityType.Builder.<MangroveBoatEntity>of(MangroveBoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));
    public static final RegistryObject<EntityType<MangroveSnakeEggEntity>> MANGROVE_SNAKE_EGG = create("mangrove_snake_egg", EntityType.Builder.<MangroveSnakeEggEntity>of(MangroveSnakeEggEntity::new, MobCategory.MISC).sized(0.25f, 0.25f));

    private static <T extends Entity> RegistryObject<EntityType<T>> create(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.build(UnnamedAnimalMod.MOD_ID + "." + name));
    }
}
