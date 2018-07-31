package teamrapture.etherealalchemy.registry.events;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.items.ItemHandlerHelper;
import teamrapture.etherealalchemy.entity.EntityInvincible;
import teamrapture.etherealalchemy.registry.ModBlocks;
import teamrapture.etherealalchemy.registry.ModItems;

@Mod.EventBusSubscriber
public class EtherealEvents {

    @SubscribeEvent
    public static void gentleSoulExtraction(LivingDeathEvent event) {
        if (event.getEntityLiving() instanceof EntityAnimal) {
            if (event.getSource().getTrueSource() instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
                if (!player.getHeldItemOffhand().isEmpty()) {
                    if (ItemHandlerHelper.canItemStacksStack(player.getHeldItemOffhand(), new ItemStack(ModItems.soulPhial))) {
                        player.sendStatusMessage(new TextComponentString(TextFormatting.BOLD.DARK_PURPLE + I18n.format("gentle_soul_extracted.msg")), true);
                        player.world.playSound(null, player.getPosition(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.PLAYERS, 1.0F, -2.0F);
                        player.setHeldItem(EnumHand.OFF_HAND, new ItemStack(ModItems.filledSoulPhial));
                    }
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onEntityJoinWorld(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        if (!event.getWorld().isRemote) {
            if (entity instanceof EntityItem) {
                EntityItem entityItem = (EntityItem) entity;
                if (!entityItem.getItem().isEmpty() && entityItem.getItem().getItem() == ModItems.unFiredSoulPhial) {
                    EntityInvincible entityInvincible = new EntityInvincible(entityItem);
                    entityItem.setDead();
                    event.getWorld().loadedEntityList.add(entityInvincible);
                    event.getWorld().playSound(null,event.getEntity().getPosition(),SoundEvents.BLOCK_END_PORTAL_FRAME_FILL, SoundCategory.BLOCKS,1.0F,0.5F);
                    event.getWorld().onEntityAdded(entityInvincible);
                    entityInvincible.setEntityInvulnerable(true);
                    event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onBlockPlaced(BlockEvent.PlaceEvent event) {
        IBlockState state = event.getPlacedBlock();
        BlockPos pos = event.getPos();
        World world = event.getWorld();
        if(state.getBlock() == ModBlocks.blockSoulChamber) {
            if(world.isAirBlock(pos.up())) {
                world.setBlockState(pos.up(), ModBlocks.blockSoulChamberTop.getDefaultState());
            }else {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        IBlockState state = event.getState();
        BlockPos pos = event.getPos();
        World world = event.getWorld();
        if(state.getBlock() == ModBlocks.blockSoulChamber) {
            world.setBlockToAir(pos.up());
        }else if(state.getBlock() == ModBlocks.blockSoulChamberTop) {
            world.setBlockToAir(pos.down());
        }
    }
}
