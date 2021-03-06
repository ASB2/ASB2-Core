package ASB2.utils;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.IFluidBlock;

/**
 * 
 * @author ASB2
 * 
 */
public class UtilBlock {
    
    public static boolean isWaterInfine(World world, int x, int y, int z) {
        
        int around = 0;
        
        if (world.getBlock(x, y, z) == Blocks.water) {
            
            for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) {
                
                if (world.getBlock(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ) == Blocks.water) {
                    
                    around++;
                }
            }
        }
        return around >= 2;
    }
    
    public static boolean isBreakable(World world, int x, int y, int z) {
        
        Block block = world.getBlock(x, y, z);
        
        if (block != null && !UtilBlock.isBlockAir(world, x, y, z)) {
            
            if (!(block instanceof IFluidBlock)) {
                
                if (block.getBlockHardness(world, x, y, z) != -1) {
                    
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean rotateBlock(World world, int x, int y, int z, ForgeDirection face) {
        
        Block block = world.getBlock(x, y, z);
        
        if (block != null) {
            
            return block.rotateBlock(world, x, y, z, face);
        }
        return false;
    }
    
    public static boolean isBlockAir(IBlockAccess world, int x, int y, int z) {
        
        Block blockId = world.getBlock(x, y, z);
        
        return blockId == null || blockId.isAir(world, x, y, z);
    }
    
    public static boolean placeBlockInAir(World world, int x, int y, int z, Block block, int metaData) {
        
        if (!UtilBlock.isBlockAir(world, x, y, z)) {
            
            return world.setBlock(x, y, z, block, metaData, 3);
        }
        if (world.getBlock(x, y, z).getMaterial() == Material.air || world.getBlock(x, y, z).getMaterial().isReplaceable()) {
            
            return world.setBlock(x, y, z, block, metaData, 3);
        }
        return false;
    }
    
    public static boolean isBlockIndirectlyGettingPowered(IBlockAccess world, int x, int y, int z) {
        
        boolean itWorked = false;
        
        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) {
            
            if (world.isBlockProvidingPowerTo(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ, direction.ordinal()) > 0) {
                
                itWorked = true;
            }
        }
        return itWorked;
    }
    
    public static int getHighestRedstoneStrength(IBlockAccess world, int x, int y, int z) {
        
        int highest = 0;
        
        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) {
            
            int temp = world.isBlockProvidingPowerTo(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ, direction.getOpposite().ordinal());
            
            if (temp > highest) {
                
                highest = temp;
            }
        }
        return highest * 15;
    }
    
    public static boolean setBlock(World world, int x, int y, int z, int blockId, int metaData) {
        
        if (world.blockExists(x, y, z)) {
            
            if (blockId == 0) {
                
                world.setBlockToAir(x, y, z);
                return true;
            }
            
            else {
                
                return world.setBlockMetadataWithNotify(x, y, z, blockId, metaData);
            }
        }
        return false;
    }
    
    public static void breakBlock(World world, int x, int y, int z) {
        
        if (!UtilBlock.isBlockAir(world, x, y, z)) {
            
            world.playAuxSFX(2001, x, y, z, 0);
            world.getBlock(x, y, z).dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockToAir(x, y, z);
        }
    }
    
    public static void breakBlockNoDrop(World world, int x, int y, int z) {
        
        if (!UtilBlock.isBlockAir(world, x, y, z)) {
            
            world.playAuxSFX(2001, x, y, z, 0);
            world.setBlockToAir(x, y, z);
        }
    }
    
    public static boolean breakAndAddToInventoryWithCheck(IInventory inventory, World world, int x, int y, int z, boolean doWork) {
        
        return false;
    }
    
    public static boolean breakAndAddToInventory(IInventory inventory, World world, int x, int y, int z, boolean doWork) {
        
        boolean itWorked = false;
        boolean canAddToInventory = false;
        
        Block block = world.getBlock(x, y, z);
        
        if (block != null) {
            
            ArrayList<ItemStack> items = block.getDrops(world, x, y, z, world.getBlockMetadata(x, y, z), 1);
            
            if (!items.isEmpty()) {
                
                for (ItemStack item : items) {
                    
                    if (inventory != null) {
                        
                        canAddToInventory = UtilInventory.addItemStackToInventory(inventory, item, false);
                    }
                }
            }
            else {
                
                canAddToInventory = true;
            }
            
            if (canAddToInventory) {
                
                if (!items.isEmpty()) {
                    
                    for (ItemStack item : items) {
                        
                        if (inventory != null) {
                            
                            itWorked = UtilInventory.addItemStackToInventory(inventory, item, doWork);
                        }
                    }
                }
                else {
                    
                    itWorked = true;
                }
            }
            
            if (doWork && canAddToInventory && itWorked) {
                
                UtilBlock.breakBlock(world, x, y, z);
            }
        }
        return itWorked;
    }
    
    public static boolean breakAndAddToInventorySpawnExcess(IInventory inventory, World world, int x, int y, int z, int fortune, boolean dropExtra) {
        
        boolean itWorked = false;
        
        if (fortune <= 0) fortune = 1;
        Block block = world.getBlock(x, y, z);
        
        if (block != null && !(block.getBlockHardness(world, x, y, z) == -1)) {
            
            ArrayList<ItemStack> items = block.getDrops(world, x, y, z, world.getBlockMetadata(x, y, z), fortune);
            
            for (ItemStack item : items) {
                
                if (world.rand.nextFloat() <= fortune) {
                    
                    if (inventory != null) {
                        
                        if (!UtilInventory.addItemStackToInventory(inventory, item, true)) {
                            
                            if (dropExtra) {
                                
                                UtilBlock.spawnItemStackEntity(world, x, y, z, item, 1);
                            }
                        }
                        else {
                            
                            itWorked = true;
                        }
                    }
                    else if (dropExtra) {
                        
                        UtilBlock.spawnItemStackEntity(world, x, y, z, item, 1);
                    }
                }
            }
            
            UtilBlock.breakBlockNoDrop(world, x, y, z);
        }
        return itWorked;
    }
    
    public static ArrayList<ItemStack> getItemStackDropped(World world, int x, int y, int z, int fortune) {
        
        if (fortune <= 0) fortune = 1;
        
        Block block = world.getBlock(x, y, z);
        
        if (block != null) {
            
            return block.getDrops(world, x, y, z, world.getBlockMetadata(x, y, z), fortune);
        }
        
        return new ArrayList<ItemStack>();
    }
    
    public static void spawnItemStackEntity(World world, double x, double y, double z, ItemStack item, int delayforPickup) {
        
        if (world.getGameRules().getGameRuleBooleanValue("doTileDrops") && !world.isRemote) {
            
            float f = 0.7F;
            double d0 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
            double d1 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
            double d2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
            EntityItem entityitem = new EntityItem(world, x + d0, y + d1, z + d2, item);
            entityitem.delayBeforeCanPickup = delayforPickup;
            world.spawnEntityInWorld(entityitem);
        }
    }
    
    public static boolean cycle2DBlock(EntityLivingBase player, World world, int x, int y, int z, ForgeDirection side, int radius, IBlockCycle cycle, int id) {
        
        boolean isSuccessful = false;
        
        if (side.offsetX != 0) {
            
            for (int i = -radius; i <= radius; i++) {
                
                for (int n = -radius; n <= radius; n++) {
                    
                    if (cycle.execute(player, world, x, y + i, z + n, side, id)) isSuccessful = true;
                }
            }
        }
        
        if (side.offsetY != 0) {
            
            for (int i = -radius; i <= radius; i++) {
                
                for (int n = -radius; n <= radius; n++) {
                    
                    if (cycle.execute(player, world, x + i, y, z + n, side, id)) isSuccessful = true;
                }
            }
        }
        
        if (side.offsetZ != 0) {
            
            for (int i = -radius; i <= radius; i++) {
                
                for (int n = -radius; n <= radius; n++) {
                    
                    if (cycle.execute(player, world, x + i, y + n, z, side, id)) isSuccessful = true;
                }
            }
        }
        
        return isSuccessful;
    }
    
    /*
     * Sends the coordinates of every block within a certain radius
     */
    
    public static boolean cycle3DBlock(EntityLivingBase player, World world, int x, int y, int z, ForgeDirection side, int radius, IBlockCycle cycle, int id) {
        boolean isSuccessful = false;
        
        if (side.offsetX != 0) {
            
            for (int i = -radius; i <= radius; i++) {
                
                if (UtilBlock.cycle2DBlock(player, world, x + i, y, z, side, radius, cycle, id)) isSuccessful = true;
            }
        }
        
        if (side.offsetY != 0) {
            
            for (int i = -radius; i <= radius; i++) {
                
                if (UtilBlock.cycle2DBlock(player, world, x, y + i, z, side, radius, cycle, id)) isSuccessful = true;
            }
        }
        
        if (side.offsetZ != 0) {
            
            for (int i = -radius; i <= radius; i++) {
                
                if (UtilBlock.cycle2DBlock(player, world, x, y, z + 1, side, radius, cycle, id)) isSuccessful = true;
            }
        }
        return isSuccessful;
    }
    
    public static boolean cycle3DBlock(EntityLivingBase player, World world, int x, int y, int z, ForgeDirection side, int radius, int distance, IBlockCycle cycle, int id) {
        boolean isSuccessful = false;
        
        for (int i = 0; i < distance; i++) {
            
            if (side.offsetX != 0) {
                
                if (side.offsetX > 0) {
                    
                    if (UtilBlock.cycle2DBlock(player, world, x - i, y, z, side, radius, cycle, id)) isSuccessful = true;
                }
                
                if (side.offsetX < 0) {
                    
                    if (UtilBlock.cycle2DBlock(player, world, x + i, y, z, side, radius, cycle, id)) isSuccessful = true;
                }
            }
            
            if (side.offsetY != 0) {
                
                if (side.offsetY > 0) {
                    
                    if (UtilBlock.cycle2DBlock(player, world, x, y - i, z, side, radius, cycle, id)) isSuccessful = true;
                }
                
                if (side.offsetY < 0) {
                    
                    if (UtilBlock.cycle2DBlock(player, world, x, y + i, z, side, radius, cycle, id)) isSuccessful = true;
                }
            }
            
            if (side.offsetZ != 0) {
                
                if (side.offsetZ > 0) {
                    
                    if (UtilBlock.cycle2DBlock(player, world, x, y, z - i, side, radius, cycle, id)) isSuccessful = true;
                }
                
                if (side.offsetZ < 0) {
                    
                    if (UtilBlock.cycle2DBlock(player, world, x, y, z + i, side, radius, cycle, id)) isSuccessful = true;
                }
            }
        }
        return isSuccessful;
    }
}
