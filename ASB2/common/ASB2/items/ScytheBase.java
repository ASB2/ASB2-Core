package ASB2.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import ASB2.utils.IBlockCycle;
import ASB2.utils.UtilBlock;

public class ScytheBase extends ToolBase implements IBlockCycle {

    public ScytheBase(int id, float speed, EnumToolMaterial material, String iconLocation) {
        super(id, speed, material, new Block[0], iconLocation);
    }

    public ScytheBase(int id, EnumToolMaterial material, String iconLocation) {
        super(id, material.getEfficiencyOnProperMaterial(), material, new Block[0], iconLocation);
    }

    public float getStrVsBlock(ItemStack itemStack, Block block) {

        if(block.blockMaterial == Material.leaves || block.blockMaterial == Material.plants) {

            return this.speed;
        }
        return 1.0F;
    }
    public boolean onBlockDestroyed(ItemStack itemStack, World world, int id, int x, int y, int z, EntityLivingBase entity) {

        if ((double)Block.blocksList[id].getBlockHardness(world, x, y, z) != 0.0D) {

            itemStack.damageItem(1, entity);
        }

        UtilBlock.cycle3DBlock(entity, world, x, y, z, ForgeDirection.DOWN, 5, this, 0);
        return true;
    }

    @Override
    public boolean execute(EntityLivingBase player, World world, int x, int y, int z, ForgeDirection side, int id) {

        if(Block.blocksList[world.getBlockId(x, y, z)] != null) {

            if(Block.blocksList[world.getBlockId(x, y, z)].blockMaterial != null) {            

                if(Block.blocksList[world.getBlockId(x, y, z)].blockMaterial == Material.leaves) {

                    UtilBlock.breakBlock(world, x, y, z);
                }
            }
        }
        return false;
    }
}
