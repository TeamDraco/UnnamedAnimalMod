package teamdraco.unnamedanimalmod.common.item;

import teamdraco.unnamedanimalmod.common.entity.item.GreaterPrairieChickenEggEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.Level;

public class GreaterPrairieChickenEggItem extends Item {
    public GreaterPrairieChickenEggItem(Item.Properties builder) {
        super(builder);
    }

    public ActionResult<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.EGG_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!worldIn.isClientSide) {
            GreaterPrairieChickenEggEntity chickeneggentity = new GreaterPrairieChickenEggEntity(worldIn, playerIn);
            chickeneggentity.setItem(itemstack);
            chickeneggentity.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 1.5F, 1.0F);
            worldIn.addFreshEntity(chickeneggentity);
        }

        playerIn.awardStat(Stats.ITEM_USED.get(this));
        if (!playerIn.abilities.instabuild) {
            itemstack.shrink(1);
        }

        return ActionResult.sidedSuccess(itemstack, worldIn.isClientSide());
    }
}
