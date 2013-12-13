package ASB2.utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import ASB2.vector.Vector3;
import cpw.mods.fml.client.FMLClientHandler;

public class UtilEntity {

    public static double[] getPlayerCursorCoords(World world, EntityPlayer entityplayer) {

        float f = 1.0F;
        float f1 = entityplayer.prevRotationPitch + (entityplayer.rotationPitch - entityplayer.prevRotationPitch) * f;
        float f2 = entityplayer.prevRotationYaw + (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f;
        double d = entityplayer.prevPosX + (entityplayer.posX - entityplayer.prevPosX) * f;
        double d1 = (entityplayer.prevPosY + (entityplayer.posY - entityplayer.prevPosY) * f + 1.6200000000000001D) - entityplayer.yOffset;
        double d2 = entityplayer.prevPosZ + (entityplayer.posZ - entityplayer.prevPosZ) * f;
        Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
        float f3 = MathHelper.cos(-f2 * 0.01745329F - (float) Math.PI);
        float f4 = MathHelper.sin(-f2 * 0.01745329F - (float) Math.PI);
        float f5 = -MathHelper.cos(-f1 * 0.01745329F);
        float f6 = MathHelper.sin(-f1 * 0.01745329F);
        float f7 = f4 * f5;
        float f8 = f6;
        float f9 = f3 * f5;
        double d3 = 5000D;
        Vec3 vec3d1 = vec3d.addVector(f7 * d3, f8 * d3, f9 * d3);
        MovingObjectPosition movingobjectposition = world.rayTraceBlocks_do_do(vec3d, vec3d1, false, true);

        if (!(movingobjectposition == null)) {

            if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) {

                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;
                return new double[] { i, j, k };
            }
        }
        return null;
    }

    public static int[] getPayerCoords(Entity entity) {

        Vector3 position = new Vector3(entity);
        return new int[] {position.intX(), position.intY(), position.intX()};
    }

    public static ForgeDirection getEntityYawDirection(Entity entity) {

        int roatation = MathHelper.floor_double(entity.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

        switch (roatation) {

            case 0:
                return ForgeDirection.SOUTH;
            case 1:
                return ForgeDirection.WEST;
            case 2:
                return ForgeDirection.NORTH;
            case 3:
                return ForgeDirection.EAST;
        }
        return ForgeDirection.UNKNOWN;
    }


    public static ForgeDirection getEntityPitchDirection(Entity entity) {

        if (entity.rotationPitch >= 90 && entity.rotationPitch <= 180) {

            return ForgeDirection.DOWN;
        } 
        else if (entity.rotationPitch <= 90) {

            return ForgeDirection.UP;
        }
        return ForgeDirection.UNKNOWN;
    }

    public static void damageEntity(World world, Entity entity, DamageSource source, int damage) {

        entity.attackEntityFrom(source, damage);
    }

    public static void sendClientChat(String message) {

        FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(message);
    }

    public static void sendChatToPlayer(EntityPlayer player, String message) {

        if (!player.worldObj.isRemote) {

            player.addChatMessage(message);
        }
    }
}
