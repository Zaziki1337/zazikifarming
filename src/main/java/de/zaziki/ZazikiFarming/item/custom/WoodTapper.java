package de.zaziki.ZazikiFarming.item.custom;


import de.zaziki.ZazikiFarming.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WoodTapper extends Item {

    public WoodTapper(Properties pProperties) {
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

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        ItemStack itemInHand = context.getItemInHand();

        if (!world.isClientSide) {
            if (world.getBlockState(pos).is(BlockTags.LOGS)) {
                ServerPlayer player = (ServerPlayer) context.getPlayer();

                ItemStack reward = new ItemStack(ModItems.SAP.get());
                if (player != null && !player.getInventory().add(reward)) {
                    player.drop(reward, false);
                }

                itemInHand.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(context.getHand()));
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.FAIL;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.zazikifarming.wood_tapper.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
