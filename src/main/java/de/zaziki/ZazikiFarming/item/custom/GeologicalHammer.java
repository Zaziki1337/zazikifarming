package de.zaziki.ZazikiFarming.item.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;

public class GeologicalHammer extends PickaxeItem {

    public GeologicalHammer(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return 1024;
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack result = itemStack.copy();

        // Damage the item by 1
        result.setDamageValue(result.getDamageValue() + 1);

        // If the item is broken (damage exceeds max durability), return an empty item stack
        if (result.getDamageValue() >= result.getMaxDamage()) {
            return ItemStack.EMPTY;
        }

        // Return the damaged item stack
        return result;

    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, Player player) {
        return super.onBlockStartBreak(itemstack, pos, player);
    }
}
