package ASB2.utils;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class UtilDirection {

    public static int[] translateDirectionToCoords(ForgeDirection direction,
            TileEntity tile) {

        return new int[] { tile.xCoord + direction.offsetX,
                tile.yCoord + direction.offsetY,
                tile.zCoord + direction.offsetZ };
    }

    public static int[] translateDirectionToCoords(ForgeDirection direction,
            int xCoord, int yCoord, int zCoord) {

        return new int[] { xCoord + direction.offsetX,
                yCoord + direction.offsetY, zCoord + direction.offsetZ };
    }

    public static int translateDirectionToNumber(ForgeDirection direction) {

        switch (direction) {

            case DOWN: {

                return 0;
            }
            case UP: {

                return 1;
            }
            case NORTH: {

                return 2;
            }
            case SOUTH: {

                return 3;
            }
            case WEST: {

                return 4;
            }
            case EAST: {

                return 5;
            }
            default: {

                return -1;
            }
        }
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