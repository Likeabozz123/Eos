package xyz.gamars.eos.common.objects.entities.hollowpurple;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.entity.IEntityWithComplexSpawn;
import xyz.gamars.eos.common.objects.EntityTypeInit;
import xyz.gamars.eos.utils.MathUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class HollowPurpleEntity extends Projectile implements IEntityWithComplexSpawn {

    private AABB hitbox;
    private float maxRadius = 10;
    private float radius = 0;
    private int elapsedTicks;

    private static final HashMap<Block, Block> convertMap = new HashMap<>();

    static {
        convertMap.put(Blocks.SAND, Blocks.GLASS);
        convertMap.put(Blocks.STONE, Blocks.MAGMA_BLOCK);
        convertMap.put(Blocks.DEEPSLATE, Blocks.LAVA);
    }

    public HollowPurpleEntity(EntityType<? extends Projectile> entityType, Level level) {
        super(entityType, level);
    }

    public HollowPurpleEntity(Level level, double x, double y, double z) {
        super(EntityTypeInit.HOLLOW_PURPLE.get(), level);
        setPos(x, y, z);
    }



    @Override
    public void tick() {
        super.tick();

        hitbox = new AABB(blockPosition());
        hitbox = hitbox.inflate(radius);

        elapsedTicks++;
        radius = maxRadius * MathUtils.easeInOutCubic(elapsedTicks / (8 * maxRadius));
        if (elapsedTicks >= (8 * maxRadius)) radius = maxRadius;

        if (elapsedTicks >= (8 * maxRadius) * 3) {
            discard();
        }


        Vec3 vec3 = this.getDeltaMovement();
        double d0 = this.getX() + vec3.x;
        double d1 = this.getY() + vec3.y;
        double d2 = this.getZ() + vec3.z;

        this.setDeltaMovement(vec3);
        this.applyGravity();
        this.setPos(d0, d1, d2);

        sphericalClear(level(), blockPosition(), (int) (radius * 2), false);

        ArrayList<LivingEntity> collidingEntities = getEntitiesInSphere();
        for (Entity entity : collidingEntities) {
            if (!(entity instanceof Player)) {
                entity.hurt(level().damageSources().explosion(null), 60.0F);
            }
            if (entity instanceof Player) {
                if (getOwner() != null) {
                    if (!entity.is(getOwner())) {
                        entity.hurt(level().damageSources().explosion(null), 60.0F);
                    }
                }
            }
        }

    }

    private ArrayList<LivingEntity> getEntitiesInSphere() {

        ArrayList<LivingEntity> entitiesInSphere = new ArrayList<>();
        List<Mob> mobsInSphere = level().getEntitiesOfClass(Mob.class, hitbox);
        List<ServerPlayer> playersInSphere = level().getEntitiesOfClass(ServerPlayer.class, hitbox);

        for (LivingEntity livingEntity : mobsInSphere) {
            double distance = this.distanceToSqr(livingEntity);
            if (distance <= radius * radius) {
                entitiesInSphere.add(livingEntity);
            }
        }

        for (ServerPlayer serverPlayer : playersInSphere) {
            double distance = this.distanceToSqr(serverPlayer);
            if (distance <= radius * radius) {
                entitiesInSphere.add(serverPlayer);
            }
        }

        return entitiesInSphere;

    }

    public static void sphericalClear(Level level, BlockPos pos, int diameter, boolean convert) {
        int radius = diameter / 2;
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        Random random = new Random();
        // Perform the initial explosion
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    if (x * x + y * y + z * z <= radius * radius) {
                        mutableBlockPos.set(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
                        if (level.getBlockState(mutableBlockPos).getDestroySpeed(level, mutableBlockPos) != -1.0F) {
                            level.setBlock(mutableBlockPos, Blocks.AIR.defaultBlockState(), 3);
                        }
                    }
                }
            }
        }
        if (convert) {
            int outerRadius = radius + 1;
            for (int x = -outerRadius; x <= outerRadius; x++) {
                for (int y = -outerRadius; y <= outerRadius; y++) {
                    for (int z = -outerRadius; z <= outerRadius; z++) {
                        if (x * x + y * y + z * z > radius * radius && x * x + y * y + z * z <= outerRadius * outerRadius) {
                            mutableBlockPos.set(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
                            if (convertMap.containsKey(level.getBlockState(mutableBlockPos).getBlock())) {
                                int chance = random.nextInt(100);
                                if (chance < 25) {
                                    level.setBlock(mutableBlockPos, convertMap.get(level.getBlockState(mutableBlockPos).getBlock()).defaultBlockState(), 3);
                                }
                            }
                        }
                    }
                }
            }
        }

    }


    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {

    }

    @Override
    public AABB getBoundingBoxForCulling() {
        return AABB.INFINITE;
    }

    @Override
    public void writeSpawnData(RegistryFriendlyByteBuf buffer) {
        buffer.writeFloat(radius);
    }

    @Override
    public void readSpawnData(RegistryFriendlyByteBuf buffer) {
        radius = buffer.readFloat();
    }

    public float getRadius() {
        return radius;
    }


}
