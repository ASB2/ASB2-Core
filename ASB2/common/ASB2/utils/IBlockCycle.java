package ASB2.utils;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public interface IBlockCycle {

    public boolean execute(EntityLivingBase player, World world, int x, int y, int z, ForgeDirection side, int id);
}
