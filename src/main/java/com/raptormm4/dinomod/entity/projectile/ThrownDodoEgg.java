package com.raptormm4.dinomod.entity.projectile;

import com.raptormm4.dinomod.entity.ModEntities;
import com.raptormm4.dinomod.entity.custom.DodoEntity;
import com.raptormm4.dinomod.item.ModItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class ThrownDodoEgg extends ThrowableItemProjectile {
    public ThrownDodoEgg(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ThrownDodoEgg(Level pLevel) {
        super(ModEntities.THROWN_DODO_EGG.get(), pLevel);
    }

    public ThrownDodoEgg(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.THROWN_DODO_EGG.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.DODO_EGG.get();
    }

    public void handleEntityEvent(byte pId) {
        if (pId == 3) {

            for(int $$2 = 0; $$2 < 8; ++$$2) {
                this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5) * 0.08, ((double)this.random.nextFloat() - 0.5) * 0.08, ((double)this.random.nextFloat() - 0.5) * 0.08);
            }
        }

    }

    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        pResult.getEntity().hurt(this.damageSources().thrown(this, this.getOwner()), 0.0F);
    }

    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide) {
            if (this.random.nextInt(8) == 0) {
                int $$1 = 1;
                if (this.random.nextInt(32) == 0) {
                    $$1 = 4;
                }

                for(int $$2 = 0; $$2 < $$1; ++$$2) {
                    DodoEntity dodo = ModEntities.DODO.get().create(this.level());
                    if (dodo != null) {
                        dodo.setAge(-24000);
                        dodo.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                        this.level().addFreshEntity(dodo);
                    }
                }
            }

            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }

    }
}
