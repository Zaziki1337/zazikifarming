package de.zaziki.ZazikiFarming.item.custom;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SpinningWheel extends Item {

    public SpinningWheel(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return 100;
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
}
