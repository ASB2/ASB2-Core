package ASB2.vector;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.nbt.NBTTagCompound;

public class Cuboid implements ICuboidIterator {

    boolean is3D = true;
    int xSize, ySize, zSize;
    boolean xNeg, yNeg, zNeg;
    Vector3 corner = new Vector3(), opposite = new Vector3();
    Set<Vector3> composingBlocks = new HashSet<Vector3>(), cornerBlocks = new HashSet<Vector3>(), edges = new HashSet<Vector3>();

    private boolean needsRecalculate = true;

    public Cuboid() {

    }

    public Cuboid(Vector3 firstCorner, Vector3 opositeCorner) {

        corner = firstCorner;
        opposite = opositeCorner;

        Vector3 subsracted = firstCorner.clone().distance(opositeCorner);

        xSize = subsracted.intX();
        if (xSize < 0) {
            xNeg = true;
            xSize = Math.abs(xSize);
        }

        ySize = subsracted.intY();
        if (ySize < 0) {
            yNeg = true;
            ySize = Math.abs(ySize);
        }

        zSize = subsracted.intZ();
        if (zSize < 0) {
            zNeg = true;
            zSize = Math.abs(zSize);
        }

        if (xSize == 0 || ySize == 0 || zSize == 0) {
            is3D = false;
        }
    }

    public Cuboid(Vector3 firstCorner, int relativeXSize, int relativeYSize, int relativeZSize) {
        this(firstCorner, firstCorner.clone().add(relativeXSize, relativeYSize, relativeZSize));
    }

    public Cuboid(Cuboid cuboid) {
        this(cuboid.getCore(), cuboid.getOppositeCore());
    }

    public void setXSize(int newX) {

        this.xSize = newX;
        needsRecalculate = true;
    }

    public int getXSize() {

        return xSize;
    }

    public void setYSize(int newY) {

        this.ySize = newY;
        needsRecalculate = true;
    }

    public int getYSize() {

        return ySize;
    }

    public void setZSize(int newZ) {

        this.zSize = newZ;
        needsRecalculate = true;
    }

    public int getZSize() {

        return zSize;
    }

    public void setRelativeXSize(int newX) {

        if (newX < 0)
            this.xNeg = true;

        this.setXSize(Math.abs(newX));
    }

    public int getRelativeXSize() {

        return xNeg ? this.getXSize() * -1 : this.getXSize();
    }

    public void setRelativeYSize(int newY) {

        if (newY < 0)
            this.yNeg = true;

        this.setYSize(Math.abs(newY));
    }

    public int getRelativeYSize() {

        return yNeg ? this.getYSize() * -1 : this.getYSize();
    }

    public void setRelativeZSize(int newZ) {

        if (newZ < 0)
            this.zNeg = true;

        this.setZSize(Math.abs(newZ));
    }

    public int getRelativeZSize() {

        return zNeg ? this.getZSize() * -1 : this.getZSize();
    }

    public boolean getIs3D() {

        return is3D;
    }

    public void setCore(Vector3 vector) {
        corner = vector;
        needsRecalculate = true;
    }

    public void setOppositeCore(Vector3 vector) {
        opposite = vector;
        needsRecalculate = true;

        Vector3 subsracted = this.getCore().distance(opposite);

        xSize = subsracted.intX();
        if (xSize < 0) {
            xNeg = true;
            xSize = Math.abs(xSize);
        }

        ySize = subsracted.intY();
        if (ySize < 0) {
            yNeg = true;
            ySize = Math.abs(ySize);
        }

        zSize = subsracted.intZ();
        if (zSize < 0) {
            zNeg = true;
            zSize = Math.abs(zSize);
        }

        if (xSize == 0 || ySize == 0 || zSize == 0) {
            is3D = false;
        }
    }

    public Vector3 getCore() {

        return corner.clone();
    }

    public Vector3 getOppositeCore() {

        return opposite.clone();
    }

    /*
     * ASB2 shouldn't touch this method. It is fine how it is;
     */
    public boolean iterate(ICuboidIterator iterator, Object... providedInfo) {

        for (int x = 0; x <= this.xSize; x++) {

            for (int y = 0; y <= this.ySize; y++) {

                for (int z = 0; z <= this.zSize; z++) {

                    if (!iterator.iterate(this.corner.clone().add(new Vector3(xNeg ? x * -1 : x, yNeg ? y * -1 : y, zNeg ? z * -1 : z)), providedInfo)) {

                        return false;
                    }
                }
            }
        }
        return true;
    }

    /*
     * Returns a set of all the blocks that make up this cuboid
     */
    public Set<Vector3> getComposingBlock() {

        if (needsRecalculate) {
            recalculate();
        }
        return composingBlocks;
    }

    /*
     * Returns a the corner block of this cuboid. Max 8 Blocks Min 1 Block
     */

    public Set<Vector3> getCornerBlocks() {

        if (needsRecalculate) {
            recalculate();
        }
        return cornerBlocks;
    }

    /*
     * Returns an array containing all edjes of the area.
     */

    public Set<Vector3> getEdges() {

        if (needsRecalculate) {
            recalculate();
        }
        return edges;
    }

    // TODO Convert to something more efficient
    public Set<Vector3> getBlocksAtLevel(int level) {

        Set<Vector3> blocks = new HashSet<Vector3>();

        if (this.ySize <= level) {

            for (int x = 0; x <= this.xSize; x++) {

                for (int z = 0; z <= this.zSize; z++) {

                    blocks.add(this.getCore().add(new Vector3(xNeg ? x * -1 : x, yNeg ? ySize * -1 : ySize, zNeg ? z * -1 : z)));
                }
            }
        }
        return blocks;
    }

    @Override
    public boolean iterate(Vector3 vector, Object... providedInfo) {

        if ((int) providedInfo[0] == 0) {
            composingBlocks.add(vector);
        }
        return true;
    }

    public Cuboid clone() {

        return new Cuboid(this);
    }

    public boolean contains(Vector3 vector) {

        return this.getComposingBlock().contains(vector);
    }

    public Cuboid shrink(int xShrink, int yShrink, int zShrink) {

        this.xSize += xShrink;
        this.ySize += yShrink;
        this.zSize += zShrink;
        return this;
    }

    /*
     * Moves the cuboid by the specified amount
     */

    public Cuboid move(int xMove, int yMove, int zMove) {

        this.corner.add(xMove, yMove, zMove);
        return this;
    }

    public Cuboid squareShrink(int xShrink, int yShrink, int zShrink) {

        if (xShrink % 2 == 0 && yShrink % 2 == 0 && zShrink % 2 == 0) {
            this.setXSize(xSize - xShrink);
            this.setYSize(ySize - yShrink);
            this.setZSize(zSize - zShrink);
            this.move(xShrink / 2 * (xNeg ? -1 : 1), xShrink / 2 * (yNeg ? -1 : 1), zShrink / 2 * (zNeg ? -1 : 1));
        }
        return this;
    }

    @Override
    public String toString() {

        return "Cuboid X Size: " + (this.xSize + 1) + ", Y Size: " + (this.ySize + 1) + ", Z Size: " + (this.zSize + 1);
    }

    public NBTTagCompound save(NBTTagCompound tag) {

        tag.setCompoundTag("coreVector", this.getCore().writeToNBT(new NBTTagCompound()));
        tag.setCompoundTag("coreOpposingVector", this.getOppositeCore().writeToNBT(new NBTTagCompound()));
        return tag;
    }

    public static Cuboid load(NBTTagCompound tag) {

        return new Cuboid(Vector3.readFromNBT(tag.getCompoundTag("coreVector")), Vector3.readFromNBT(tag.getCompoundTag("coreOpposingVector")));
    }

    private void recalculate() {

        this.needsRecalculate = false;

        // Composing Blocks
        this.iterate(this, 0);

        // Corners
        cornerBlocks.clear();
        cornerBlocks.add(this.getCore());
        cornerBlocks.add(this.getOppositeCore());
        cornerBlocks.add(this.getCore().add(getRelativeXSize(), 0, 0));
        cornerBlocks.add(this.getCore().add(getRelativeXSize(), getRelativeYSize(), 0));
        cornerBlocks.add(this.getCore().add(getRelativeXSize(), 0, getRelativeZSize()));
        cornerBlocks.add(this.getCore().add(0, getRelativeYSize(), 0));
        cornerBlocks.add(this.getCore().add(0, getRelativeYSize(), getRelativeZSize()));
        cornerBlocks.add(this.getCore().add(0, 0, getRelativeZSize()));

        // Edge Calculation
        edges.clear();

        int yMax = this.getRelativeYSize();

        for (int x = 0; x <= this.xSize; x++) {

            int xCalc = xNeg ? x * -1 : x;

            edges.add(this.getCore().add(xCalc, yMax, 0));
            edges.add(this.getCore().add(xCalc, yMax, this.getRelativeZSize()));
        }

        for (int y = 0; y <= this.ySize; y++) {

            int yCalc = yNeg ? y * -1 : y;

            edges.add(this.getCore().add(0, yCalc, 0));
            edges.add(this.getCore().add(getRelativeXSize(), yCalc, 0));
            edges.add(this.getCore().add(0, yCalc, getRelativeZSize()));
            edges.add(this.getCore().add(getRelativeXSize(), yCalc, getRelativeZSize()));
        }

        for (int z = 0; z <= this.zSize; z++) {

            int zCalc = zNeg ? z * -1 : z;

            edges.add(this.getCore().add(0, yMax, zCalc));
            edges.add(this.getCore().add(this.getRelativeXSize(), yMax, zCalc));
        }
    }
}
