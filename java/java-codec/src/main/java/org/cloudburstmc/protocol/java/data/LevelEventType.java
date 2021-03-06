package org.cloudburstmc.protocol.java.data;

public enum LevelEventType {
    // Sounds
    SOUND_CLICK,
    SOUND_CLICK_FAIL,
    SOUND_LAUNCH,
    SOUND_EYE_OF_ENDER_DEATH,
    SOUND_FIREWORK,
    SOUND_IRON_DOOR_OPEN,
    SOUND_WOODEN_DOOR_OPEN,
    SOUND_WOODEN_TRAPDOOR_OPEN,
    SOUND_FENCE_GATE_OPEN,
    SOUND_EXTINGUISH,
    SOUND_PLAY_RECORDING,
    SOUND_IRON_DOOR_CLOSE,
    SOUND_WOODEN_DOOR_CLOSE,
    SOUND_WOODEN_TRAPDOOR_CLOSE,
    SOUND_FENCE_GATE_CLOSE,
    SOUND_GHAST_WARNING,
    SOUND_GHAST_FIREBALL,
    SOUND_DRAGON_FIREBALL,
    SOUND_BLAZE_FIREBALL,
    SOUND_ZOMBIE_WOODEN_DOOR_BUMP,
    SOUND_ZOMBIE_IRON_DOOR_BUMP,
    SOUND_ZOMBIE_DOOR_CRASH,
    SOUND_WITHER_BLOCK_BREAK,
    SOUND_WITHER_SPAWN,
    SOUND_WITHER_SHOOT,
    SOUND_BAT_TAKEOFF,
    SOND_ZOMBIE_INFECTED,
    SOUND_ZOMBIE_CONVERTED,
    SOUND_DRAGON_DAETH,
    SOUND_ANVIL_BROKEN,
    SOUND_ANVIL_LAND,
    SOUND_PORTAL_TRAVEL,
    SOUND_CHORUS_FLOWER_GROW,
    SOUND_CHORUS_FLOWER_DEATH,
    SOUND_BREWING_STAND_USED,
    SOUND_IRON_TRAPDOOR_OPEN,
    SOUND_IRON_TRAPDOOR_CLOSE,
    SOUND_END_PORTAL_CREATE,
    SOUND_PHANTOM_BITE,
    SOUND_ZOMBIE_CONVERTED_TO_DROWNED,
    SOUND_HUSK_CONVERTED,
    SOUND_GRINDSTONE_USED,
    SOUND_BOOK_PAGE_TURNED,

    // Particles
    PARTICLE_COMPOSTER_COMPOST,
    PARTICLE_CONVERT_BLOCK,
    PARTICLE_REDSTONE_TORCH_BURN,
    PARTICLE_EYE_OF_ENDER_PLACE,
    PARTICLE_SHOOT,
    PARTICLE_DESTROY_BLOCK,
    PARTICLE_POTION_SPLASH,
    PARTICLE_EYE_OF_ENDER_DEATH,
    PARTICLE_MOB_BLOCK_SPAWN,
    PARTICLE_CROP_GROWTH,
    PARTICLE_DRAGONS_BREATH,
    PARTICLE_POTION_SPLASH_INSTANT,
    PARTICLE_DRAGON_DESTROY_BLOCK,
    PARTICLE_SPONGE_VAPORIZE,

    // Level
    END_GATEWAY_SPAWN,
    DRAGON_GROWL;

    private static final LevelEventType[] VALUES = values();

    public static LevelEventType getById(int id) {
        return VALUES[id];
    }
}
