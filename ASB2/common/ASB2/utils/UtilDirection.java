package ASB2.utils;

import java.util.Random;

import ASB2.vector.Vector3;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import static net.minecraftforge.common.ForgeDirection.UP;
import static net.minecraftforge.common.ForgeDirection.DOWN;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;
import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.UNKNOWN;

public class UtilDirection {

    public static ForgeDirection translateDirectionToRandomRightAngle(ForgeDirection direction) {

        int rand = new Random().nextInt(4);

        if(direction == ForgeDirection.UP || direction == ForgeDirection.DOWN) {

            switch(rand) {

                case 0:
                    return NORTH;
                case 1:
                    return SOUTH;
                case 2:
                    return WEST;
                case 3:
                    return EAST;
                default:
                    return UNKNOWN;
            }
        }

        if(direction == ForgeDirection.NORTH || direction == ForgeDirection.SOUTH) {

            switch(rand) {

                case 0:
                    return UP;
                case 1:
                    return DOWN;
                case 2:
                    return WEST;
                case 3:
                    return EAST;
                default:
                    return UNKNOWN;
            }
        }

        if(direction == ForgeDirection.WEST || direction == ForgeDirection.EAST) {

            switch(rand) {

                case 0:
                    return UP;
                case 1:
                    return DOWN;
                case 2:
                    return NORTH;
                case 3:
                    return SOUTH;
                default:
                    return UNKNOWN;
            }
        }
        return ForgeDirection.UNKNOWN;

    }

    public static int[] translateDirectionToCoords(ForgeDirection direction, TileEntity tile) {

        return translateDirectionToCoords(direction, tile.xCoord, tile.yCoord, tile.zCoord);
    }

    public static int[] translateDirectionToCoords(ForgeDirection direction, int xCoord, int yCoord, int zCoord) {

        return new int[]{xCoord + direction.offsetX, yCoord + direction.offsetY, zCoord + direction.offsetZ};
    }

    public static TileEntity translateDirectionToTile(TileEntity tile, IBlockAccess world, ForgeDirection direction) {

        return translateDirectionToTile(world, direction, tile.xCoord, tile.yCoord, tile.zCoord);}

    public static TileEntity translateDirectionToTile(Vector3 vector, IBlockAccess world, ForgeDirection direction) {
        
        return translateDirectionToTile(world, direction, vector.intX(), vector.intY(), vector.intZ());
    }

    public static TileEntity translateDirectionToTile(IBlockAccess world, ForgeDirection direction, int xCoord, int yCoord, int zCoord) {

        int[] coords = UtilDirection.translateDirectionToCoords(direction, xCoord, yCoord, zCoord);
        return world.getBlockTileEntity(coords[0], coords[1], coords[2]);
    }

    public static int translateDirectionToBlockId(IBlockAccess world, ForgeDirection direction, int xCoord, int yCoord, int zCoord) {

        int[] coords = UtilDirection.translateDirectionToCoords(direction, xCoord, yCoord, zCoord);

        return world.getBlockId(coords[0], coords[1], coords[2]);
    }

    public static int translateDirectionToBlockId(World world, ForgeDirection direction, TileEntity tile) {

        return translateDirectionToBlockId(world, direction, tile.xCoord, tile.yCoord, tile.zCoord);
    }

    public static int translateDirectionToBlockMeta(World world, ForgeDirection direction, int xCoord, int yCoord, int zCoord) {

        int[] coords = UtilDirection.translateDirectionToCoords(direction, xCoord, yCoord, zCoord);

        return world.getBlockMetadata(coords[0], coords[1], coords[2]);
    }

    public static int translateDirectionToBlockMeta(World world, ForgeDirection direction, TileEntity tile) {

        int[] coords = UtilDirection.translateDirectionToCoords(direction, tile.xCoord, tile.yCoord, tile.zCoord);

        return world.getBlockMetadata(coords[0], coords[1], coords[2]);
    }

    public static boolean translateDirectionToIsBlockSolid(World world, ForgeDirection direction, int xCoord, int yCoord, int zCoord) {

        int[] coords = UtilDirection.translateDirectionToCoords(direction, xCoord, yCoord, zCoord);

        return world.isBlockSolidOnSide(coords[0], coords[1], coords[2], direction);
    }
}
