package ASB2.utils;

import java.util.Random;

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

                case 0: return NORTH;
                case 1: return SOUTH;
                case 2: return WEST;
                case 3: return EAST;
                default: return UNKNOWN;
            }
        }        

        if(direction == ForgeDirection.NORTH || direction == ForgeDirection.SOUTH) {

            switch(rand) {

                case 0: return UP;
                case 1: return DOWN;
                case 2: return WEST;
                case 3: return EAST;
                default: return UNKNOWN;
            }
        } 
        
        if(direction == ForgeDirection.WEST || direction == ForgeDirection.EAST) {

            switch(rand) {

                case 0: return UP;
                case 1: return DOWN;
                case 2: return NORTH;
                case 3: return SOUTH;
                default: return UNKNOWN;
            }
        } 
        return ForgeDirection.UNKNOWN;

    }

    public static int[] translateDirectionToCoords(ForgeDirection direction, TileEntity tile) {

        return new int[] { tile.xCoord + direction.offsetX, tile.yCoord + direction.offsetY, tile.zCoord + direction.offsetZ };
    }

    public static int[] translateDirectionToCoords(ForgeDirection direction, int xCoord, int yCoord, int zCoord) {

        return new int[] { xCoord + direction.offsetX, yCoord + direction.offsetY, zCoord + direction.offsetZ };
    }

    public static String translateDirectionToString(ForgeDirection direction) {

        switch (direction) {

            case DOWN: {
                return "Down";
            }
            case UP: {
                return "Up";
            }
            case NORTH: {
                return "North";
            }
            case SOUTH: {
                return "South";
            }
            case WEST: {
                return "West";
            }
            case EAST: {
                return "East";
            }
            default: {

                return "Unknown";
            }
        }
    }

    public static TileEntity translateDirectionToTile(TileEntity tile, IBlockAccess world, ForgeDirection direction) {

        return world.getBlockTileEntity(
                UtilDirection.translateDirectionToCoords(direction, tile)[0],
                UtilDirection.translateDirectionToCoords(direction, tile)[1],
                UtilDirection.translateDirectionToCoords(direction, tile)[2]);
    }

    public static TileEntity translateDirectionToTile(IBlockAccess world, ForgeDirection direction, int xCoord, int yCoord, int zCoord) {

        int[] coords = UtilDirection.translateDirectionToCoords(direction, xCoord, yCoord, zCoord);
        return world.getBlockTileEntity(coords[0], coords[1], coords[2]);
    }

    public static int getTilesNextTo(TileEntity tile, World worldObj) {

        int numberNextTo = 0;
        // Bottom of Tile
        if (worldObj.getBlockTileEntity(tile.xCoord, tile.yCoord - 1, tile.zCoord) instanceof TileEntity) {
            numberNextTo++;
        }
        // top of Tile
        if (worldObj.getBlockTileEntity(tile.xCoord, tile.yCoord + 1, tile.zCoord) instanceof TileEntity) {
            numberNextTo++;
        }
        // left
        if (worldObj.getBlockTileEntity(tile.xCoord, tile.yCoord, tile.zCoord - 1) instanceof TileEntity) {
            numberNextTo++;
        }
        // right
        if (worldObj.getBlockTileEntity(tile.xCoord, tile.yCoord, tile.zCoord + 1) instanceof TileEntity) {
            numberNextTo++;
        }
        // front
        if (worldObj.getBlockTileEntity(tile.xCoord + 1, tile.yCoord, tile.zCoord) instanceof TileEntity) {
            numberNextTo++;
        }
        // back
        if (worldObj.getBlockTileEntity(tile.xCoord - 1, tile.yCoord, tile.zCoord) instanceof TileEntity) {
            numberNextTo++;
        }
        return numberNextTo;
    }

    public static int translateDirectionToBlockId(IBlockAccess world, ForgeDirection direction, int xCoord, int yCoord, int zCoord) {

        int[] coords = UtilDirection.translateDirectionToCoords(direction, xCoord, yCoord, zCoord);

        return world.getBlockId(coords[0], coords[1], coords[2]);
    }

    public static int translateDirectionToBlockId(World world, ForgeDirection direction, TileEntity tile) {

        int[] coords = UtilDirection.translateDirectionToCoords(direction, tile.xCoord, tile.yCoord, tile.zCoord);

        return world.getBlockId(coords[0], coords[1], coords[2]);
    }

    public static int translateDirectionToBlockMeta(World world,
            ForgeDirection direction, int xCoord, int yCoord, int zCoord) {

        int[] coords = UtilDirection.translateDirectionToCoords(direction,
                xCoord, yCoord, zCoord);

        return world.getBlockMetadata(coords[0], coords[1], coords[2]);
    }

    public static int translateDirectionToBlockMeta(World world,
            ForgeDirection direction, TileEntity tile) {

        int[] coords = UtilDirection.translateDirectionToCoords(direction,
                tile.xCoord, tile.yCoord, tile.zCoord);

        return world.getBlockMetadata(coords[0], coords[1], coords[2]);
    }

    public static boolean translateDirectionToIsBlockSolid(World world,
            ForgeDirection direction, int xCoord, int yCoord, int zCoord) {

        int[] coords = UtilDirection.translateDirectionToCoords(direction,
                xCoord, yCoord, zCoord);

        return world.isBlockSolidOnSide(coords[0], coords[1], coords[2],
                direction);
    }
}
