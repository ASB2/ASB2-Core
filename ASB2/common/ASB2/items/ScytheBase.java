package ASB2.items;

import java.util.HashSet;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import ASB2.utils.IBlockCycle;
import ASB2.utils.UtilBlock;

public class ScytheBase extends ToolBase implements IBlockCycle {
    
    public ScytheBase(float speed, ToolMaterial material, String iconLocation) {
        super(speed, material, new HashSet<Block>(), iconLocation);
    }
    
    public ScytheBase(ToolMaterial material, String iconLocation) {
        super(material.getEfficiencyOnProperMaterial(), material, new HashSet<Block>(), iconLocation);
    }
    
    public float getStrVsBlock(ItemStack itemStack, Block block) {
        
        if (block.getMaterial() == Material.leaves || block.getMaterial() == Material.plants) {
            
            return this.speed;
        }
        return 1.0F;
    }
    
    public boolean onBlockDestroyed(ItemStack itemStack, World world, int id, int x, int y, int z, EntityLivingBase entity) {
        
        Block block = world.getBlock(x, y, z);
        
        if (block.getBlockHardness(world, x, y, z) != 0.0D) {
            
            itemStack.damageItem(1, entity);
        }
        
        if (block != null && block.getMaterial() != null && (block.getMaterial() == Material.leaves || block.getMaterial() == Material.plants)) {
            
            UtilBlock.cycle3DBlock(entity, world, x, y, z, ForgeDirection.DOWN, 5, this, 0);
        }
        return true;
    }
    
    @Override
    public boolean execute(EntityLivingBase player, World world, int x, int y, int z, ForgeDirection side, int id) {
        
        Block block = world.getBlock(x, y, z);
        
        if (block != null) {
            
            if (block.getMaterial() != null) {
                
                if (block.getMaterial() == Material.leaves || block.getMaterial() == Material.plants) {
                    
                    UtilBlock.breakBlock(world, x, y, z);
                }
            }
        }
        return false;
    }
}
