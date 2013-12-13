package ASB2.utils;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public final class UtilRender {

    public static RenderItem renderItemInstance = new RenderItem();
    public static RenderBlocks renderBlockInstance = new RenderBlocks();

    public static void renderLine(double xStart, double yStart, double zStart, double xEnd, double yEnd, double zEnd) {

        Tessellator tessellator = Tessellator.instance;

        GL11.glDisable(2884);
        GL11.glDisable(3553);
        GL11.glDisable(2896);
        
        if(!tessellator.isDrawing) {
            
            tessellator.startDrawing(3);
            tessellator.setColorOpaque_I(16733525);
            tessellator.addVertex(xStart, yStart, zStart);
            tessellator.addVertex(xEnd, yEnd, zEnd);
            tessellator.draw();
        }
        
        GL11.glEnable(2884);
        GL11.glEnable(3553);
        GL11.glEnable(2896);
    }

    public static void renderBox(double xStart, double yStart, double zStart, double xEnd, double yEnd, double zEnd) {

        GL11.glColor3d(1, 1, 1);

        Tessellator tessellator = Tessellator.instance;

        GL11.glDisable(2884);
        GL11.glDisable(3553);
        GL11.glDisable(2896);

        tessellator.startDrawing(3);
        tessellator.setColorOpaque_I(16733525);
        tessellator.addVertex(xStart, yStart, zStart);
        tessellator.addVertex(xStart + xEnd, yStart, zStart);
        tessellator.draw();

        tessellator.startDrawing(3);
        tessellator.setColorOpaque_I(16777184);
        tessellator.addVertex(xStart, yStart, zStart);
        tessellator.addVertex(xStart, yStart, zStart + zEnd);
        tessellator.draw();

        tessellator.startDrawing(3);
        tessellator.setColorOpaque_I(16755370);
        tessellator.addVertex(xStart, yStart, zStart);
        tessellator.addVertex(xStart, yStart + yEnd, zStart);

        GL11.glColor3f(1.0F, 1.0F, 0.8F);

        tessellator.draw();
        tessellator.startDrawing(3);
        tessellator.setColorOpaque_I(16777184);
        tessellator.addVertex(xStart + xEnd, yStart + yEnd, zStart + zEnd);
        tessellator.addVertex(xStart, yStart + yEnd, zStart + zEnd);
        tessellator.draw();

        tessellator.startDrawing(3);
        tessellator.setColorOpaque_I(16733525);
        tessellator.addVertex(xStart + xEnd, yStart + yEnd, zStart + zEnd);
        tessellator.addVertex(xStart + xEnd, yStart + yEnd, zStart);
        tessellator.draw();

        tessellator.startDrawing(3);
        tessellator.setColorOpaque_I(16755370);
        tessellator.addVertex(xStart + xEnd, yStart + yEnd, zStart + zEnd);
        tessellator.addVertex(xStart + xEnd, yStart, zStart + zEnd);
        tessellator.draw();

        tessellator.startDrawing(3);
        tessellator.setColorOpaque_I(16733525);
        tessellator.addVertex(xStart, yStart + yEnd, zStart);
        tessellator.addVertex(xStart + xEnd, yStart + yEnd, zStart);
        tessellator.draw();

        tessellator.startDrawing(3);
        tessellator.setColorOpaque_I(16777184);
        tessellator.addVertex(xStart, yStart + yEnd, zStart);
        tessellator.addVertex(xStart, yStart + yEnd, zStart + zEnd);
        tessellator.draw();

        tessellator.startDrawing(3);
        tessellator.setColorOpaque_I(16733525);
        tessellator.addVertex(xStart + xEnd, yStart, zStart);
        tessellator.addVertex(xStart + xEnd, yStart + yEnd, zStart);
        tessellator.draw();

        tessellator.startDrawing(3);
        tessellator.setColorOpaque_I(16777184);
        tessellator.addVertex(xStart, yStart, zStart + zEnd);
        tessellator.addVertex(xStart, yStart + yEnd, zStart + zEnd);
        tessellator.draw();

        tessellator.startDrawing(3);
        tessellator.setColorOpaque_I(16777184);
        tessellator.addVertex(xStart + xEnd, yStart, zStart + zEnd);
        tessellator.addVertex(xStart, yStart, zStart + zEnd);
        tessellator.draw();

        tessellator.startDrawing(3);
        tessellator.setColorOpaque_I(16733525);
        tessellator.addVertex(xStart + xEnd, yStart, zStart + zEnd);
        tessellator.addVertex(xStart + xEnd, yStart, zStart);
        tessellator.draw();

        GL11.glEnable(2896);
        GL11.glEnable(3553);
    }

    public static void renderIcon(double x, double y, Icon icon, double xChange, double yChange) {

        int zLevel = 1;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x, y + yChange, zLevel, icon.getMinU(), icon.getMaxV());
        tessellator.addVertexWithUV(x + xChange, y + yChange, zLevel, icon.getMaxU(), icon.getMaxV());
        tessellator.addVertexWithUV(x + xChange, y, zLevel, icon.getMaxU(), icon.getMinV());
        tessellator.addVertexWithUV(x, y, zLevel, icon.getMinU(), icon.getMinV());
        tessellator.draw();
    }

    public static void renderIcon(double x, double y, double z, Icon icon, double xChange, double yChange, double zChange) {

        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x, y + yChange, z + zChange, icon.getMinU(), icon.getMaxV());
        tessellator.addVertexWithUV(x + xChange, y + yChange, z + zChange, icon.getMaxU(), icon.getMaxV());
        tessellator.addVertexWithUV(x + xChange, y, z + zChange, icon.getMaxU(), icon.getMinV());
        tessellator.addVertexWithUV(x, y, z + zChange, icon.getMinU(), icon.getMinV());
        tessellator.draw();
    }

    public static void bindBlockTextures() {

        UtilRender.renderTexture(TextureMap.locationBlocksTexture);
    }

    public static void bindItemTextures() {

        UtilRender.renderTexture(TextureMap.locationItemsTexture);
    }

    public static void renderTexture(ResourceLocation texture) {

        if(texture != null) {

            if(FMLClientHandler.instance().getClient() != null && texture != null) {

                FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture);
            }
        }
    }

    public static void renderFX(EntityFX fx) {

        if(FMLClientHandler.instance().getClient() != null) {

            Minecraft mc = Minecraft.getMinecraft();
            int settings = mc.gameSettings.particleSetting;

            if(!(settings == 2 || settings == 1 && fx.worldObj.rand.nextInt(3) == 0)) {

                Minecraft.getMinecraft().effectRenderer.addEffect(fx);
            }
        }
    }

    public static void renderByOrientation(double x, double y, double z, ForgeDirection direction) {

        switch(direction.getOpposite()) {

            case DOWN: {// Down
                GL11.glTranslatef((float) x + 0.5F, (float) y + -.5F, (float) z + .5F);
                break;
            }
            case UP: {// Up
                GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + .5F);
                GL11.glRotatef(180F, 1F, 0F, 0F);
                break;
            }

            case NORTH: {// South
                GL11.glTranslatef((float) x + 0.5F, (float) y + .5F, (float) z - 0.5F);
                GL11.glRotatef(90F, 1F, 0F, 0F);
                break;
            }
            case SOUTH: {// North
                GL11.glTranslatef((float) x + 0.5F, (float) y + .5F, (float) z + 1.5F);
                GL11.glRotatef(-90F, 1F, 0F, 0F);
                break;
            }
            case EAST: {// West
                GL11.glTranslatef((float) x + 1.5F, (float) y + .5F, (float) z + .5F);
                GL11.glRotatef(90F, 0F, 0F, 1F);
                break;
            }
            case WEST: {// East
                GL11.glTranslatef((float) x - .5F, (float) y + .5F, (float) z + .5F);
                GL11.glRotatef(-90F, 0F, 0F, 1F);
                break;
            }
            default: {// Other
                break;
            }
        }
    }

    public static void renderByOrientation(double x, double y, double z, int metadata) {

        GL11.glScalef(1.0F, 1.0F, 1.0F);

        switch(metadata) {

            case 0: {// Down
                GL11.glTranslatef((float) x + 0.5F, (float) y + -.5F, (float) z + .5F);
                break;
            }
            case 1: {// Up
                GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + .5F);
                GL11.glRotatef(180F, 1F, 0F, 0F);
                break;
            }

            case 2: {// South
                GL11.glTranslatef((float) x + 0.5F, (float) y + .5F, (float) z - 0.5F);
                GL11.glRotatef(90F, 1F, 0F, 0F);
                break;
            }
            case 3: {// North
                GL11.glTranslatef((float) x + 0.5F, (float) y + .5F, (float) z + 1.5F);
                GL11.glRotatef(-90F, 1F, 0F, 0F);
                break;
            }
            case 5: {// West
                GL11.glTranslatef((float) x + 1.5F, (float) y + .5F, (float) z + .5F);
                GL11.glRotatef(90F, 0F, 0F, 1F);
                break;
            }
            case 4: {// East
                GL11.glTranslatef((float) x - .5F, (float) y + .5F, (float) z + .5F);
                GL11.glRotatef(-90F, 0F, 0F, 1F);
                break;
            }
            default: {// Other
                break;
            }
        }
    }

    public static void renderFakeBlock(RenderBlocks renderer, Block block, int x, int y, int z, Icon icon, int red, int green, int blue, int alfa, int brightness) {

        Tessellator tess = Tessellator.instance;

        tess.setBrightness(brightness);
        tess.setColorRGBA(red, green, blue, alfa);

        renderer.renderFaceXNeg(block, x, y, z, icon);
        renderer.renderFaceXPos(block, x, y, z, icon);

        renderer.renderFaceYNeg(block, x, y, z, icon);
        renderer.renderFaceYPos(block, x, y, z, icon);

        renderer.renderFaceZNeg(block, x, y, z, icon);
        renderer.renderFaceZPos(block, x, y, z, icon);
    }

    public static void renderFakeSide(RenderBlocks renderer, Block block, ForgeDirection direction, int x, int y, int z, Icon icon, int red, int green, int blue, int alfa, int brightness) {

        if(icon != null) {

            Tessellator tess = Tessellator.instance;

            tess.setBrightness(brightness);
            tess.setColorRGBA(red, green, blue, alfa);

            switch(direction) {

                case DOWN:
                    renderer.renderFaceYNeg(block, x, y, z, icon);
                    break;
                case UP:
                    renderer.renderFaceYPos(block, x, y, z, icon);
                    break;
                case NORTH:
                    renderer.renderFaceZNeg(block, x, y, z, icon);
                    break;
                case SOUTH:
                    renderer.renderFaceZPos(block, x, y, z, icon);
                    break;
                case WEST:
                    renderer.renderFaceXNeg(block, x, y, z, icon);
                    break;
                case EAST:
                    renderer.renderFaceXPos(block, x, y, z, icon);
                    break;
                default:
                    break;
            }
        }
    }

    public static void renderStandardInvBlock(RenderBlocks renderblocks, Block block, int meta) {

        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1F, 0.0F);
        renderblocks.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, meta));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderblocks.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(1, meta));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1F);
        renderblocks.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(2, meta));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderblocks.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(3, meta));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1F, 0.0F, 0.0F);
        renderblocks.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(4, meta));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderblocks.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(5, meta));
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    public static void renderStandardInvBlock(RenderBlocks renderblocks, Block block, Icon icon) {

        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1F, 0.0F);
        renderblocks.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderblocks.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1F);
        renderblocks.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderblocks.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1F, 0.0F, 0.0F);
        renderblocks.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderblocks.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    public static void renderStandardInvBlock(RenderBlocks renderblocks, Block block, Icon icon, int red, int green, int blue, int alfa) {

        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA(red, green, blue, alfa);
        tessellator.setNormal(0.0F, -1F, 0.0F);
        renderblocks.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();
        
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA(red, green, blue, alfa);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderblocks.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();
        
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA(red, green, blue, alfa);
        tessellator.setNormal(0.0F, 0.0F, -1F);
        renderblocks.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();
        
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA(red, green, blue, alfa);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderblocks.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();
        
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA(red, green, blue, alfa);
        tessellator.setNormal(-1F, 0.0F, 0.0F);
        renderblocks.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();
        
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA(red, green, blue, alfa);
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderblocks.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    public static boolean renderMetadataBlock(Block block, int metadata, int x, int y, int z, RenderBlocks renderer, IBlockAccess world) {

        int var5 = block.colorMultiplier(world, x, y, z);
        float var6 = (var5 >> 16 & 255) / 255.0F;
        float var7 = (var5 >> 8 & 255) / 255.0F;
        float var8 = (var5 & 255) / 255.0F;

        if(EntityRenderer.anaglyphEnable) {
            float var9 = (var6 * 30.0F + var7 * 59.0F + var8 * 11.0F) / 100.0F;
            float var10 = (var6 * 30.0F + var7 * 70.0F) / 100.0F;
            float var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
            var6 = var9;
            var7 = var10;
            var8 = var11;
        }

        return Minecraft.isAmbientOcclusionEnabled() && Block.lightValue[block.blockID] == 0 ? renderMetadataBlockWithAmbientOcclusion(block, metadata, x, y, z, var6, var7, var8, renderer, world) : renderMetadataBlockWithColorMultiplier(block, metadata, x, y, z, var6, var7, var8, renderer, world);
    }

    public static boolean renderMetadataBlockWithAmbientOcclusion(Block block, int metadata, int xPos, int yPos, int zPos, float colorRed, float colorGreen, float colorBlue, RenderBlocks render, IBlockAccess world) {
        render.enableAO = true;
        boolean flag = false;
        float f3 = 0.0F;
        float f4 = 0.0F;
        float f5 = 0.0F;
        float f6 = 0.0F;
        boolean flag1 = true;
        int l = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos);
        Tessellator tessellator = Tessellator.instance;
        tessellator.setBrightness(983055);

        if(render.getBlockIcon(block).getIconName().equals("grass_top")) {
            flag1 = false;
        }
        else if(render.hasOverrideBlockTexture()) {
            flag1 = false;
        }

        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        float f7;
        int i1;

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos, yPos - 1, zPos, 0)) {
            if(render.renderMinY <= 0.0D) {
                --yPos;
            }

            render.aoBrightnessXYNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos, zPos);
            render.aoBrightnessYZNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos - 1);
            render.aoBrightnessYZNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos + 1);
            render.aoBrightnessXYPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos, zPos);
            render.aoLightValueScratchXYNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos, zPos);
            render.aoLightValueScratchYZNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos, zPos - 1);
            render.aoLightValueScratchYZNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos, zPos + 1);
            render.aoLightValueScratchXYPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos, zPos);
            flag3 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos + 1, yPos - 1, zPos)];
            flag2 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos - 1, yPos - 1, zPos)];
            flag5 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos, yPos - 1, zPos + 1)];
            flag4 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos, yPos - 1, zPos - 1)];

            if(!flag4 && !flag2) {
                render.aoLightValueScratchXYZNNN = render.aoLightValueScratchXYNN;
                render.aoBrightnessXYZNNN = render.aoBrightnessXYNN;
            }
            else {
                render.aoLightValueScratchXYZNNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos, zPos - 1);
                render.aoBrightnessXYZNNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos, zPos - 1);
            }

            if(!flag5 && !flag2) {
                render.aoLightValueScratchXYZNNP = render.aoLightValueScratchXYNN;
                render.aoBrightnessXYZNNP = render.aoBrightnessXYNN;
            }
            else {
                render.aoLightValueScratchXYZNNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos, zPos + 1);
                render.aoBrightnessXYZNNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos, zPos + 1);
            }

            if(!flag4 && !flag3) {
                render.aoLightValueScratchXYZPNN = render.aoLightValueScratchXYPN;
                render.aoBrightnessXYZPNN = render.aoBrightnessXYPN;
            }
            else {
                render.aoLightValueScratchXYZPNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos, zPos - 1);
                render.aoBrightnessXYZPNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos, zPos - 1);
            }

            if(!flag5 && !flag3) {
                render.aoLightValueScratchXYZPNP = render.aoLightValueScratchXYPN;
                render.aoBrightnessXYZPNP = render.aoBrightnessXYPN;
            }
            else {
                render.aoLightValueScratchXYZPNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos, zPos + 1);
                render.aoBrightnessXYZPNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos, zPos + 1);
            }

            if(render.renderMinY <= 0.0D) {
                ++yPos;
            }

            i1 = l;

            if(render.renderMinY <= 0.0D || !render.blockAccess.isBlockOpaqueCube(xPos, yPos - 1, zPos)) {
                i1 = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos - 1, zPos);
            }

            f7 = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos - 1, zPos);
            f3 = (render.aoLightValueScratchXYZNNP + render.aoLightValueScratchXYNN + render.aoLightValueScratchYZNP + f7) / 4.0F;
            f6 = (render.aoLightValueScratchYZNP + f7 + render.aoLightValueScratchXYZPNP + render.aoLightValueScratchXYPN) / 4.0F;
            f5 = (f7 + render.aoLightValueScratchYZNN + render.aoLightValueScratchXYPN + render.aoLightValueScratchXYZPNN) / 4.0F;
            f4 = (render.aoLightValueScratchXYNN + render.aoLightValueScratchXYZNNN + f7 + render.aoLightValueScratchYZNN) / 4.0F;
            render.brightnessTopLeft = render.getAoBrightness(render.aoBrightnessXYZNNP, render.aoBrightnessXYNN, render.aoBrightnessYZNP, i1);
            render.brightnessTopRight = render.getAoBrightness(render.aoBrightnessYZNP, render.aoBrightnessXYZPNP, render.aoBrightnessXYPN, i1);
            render.brightnessBottomRight = render.getAoBrightness(render.aoBrightnessYZNN, render.aoBrightnessXYPN, render.aoBrightnessXYZPNN, i1);
            render.brightnessBottomLeft = render.getAoBrightness(render.aoBrightnessXYNN, render.aoBrightnessXYZNNN, render.aoBrightnessYZNN, i1);

            if(flag1) {
                render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = colorRed * 0.5F;
                render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = colorGreen * 0.5F;
                render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = colorBlue * 0.5F;
            }
            else {
                render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = 0.5F;
                render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = 0.5F;
                render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = 0.5F;
            }

            render.colorRedTopLeft *= f3;
            render.colorGreenTopLeft *= f3;
            render.colorBlueTopLeft *= f3;
            render.colorRedBottomLeft *= f4;
            render.colorGreenBottomLeft *= f4;
            render.colorBlueBottomLeft *= f4;
            render.colorRedBottomRight *= f5;
            render.colorGreenBottomRight *= f5;
            render.colorBlueBottomRight *= f5;
            render.colorRedTopRight *= f6;
            render.colorGreenTopRight *= f6;
            render.colorBlueTopRight *= f6;
            render.renderFaceYNeg(block, xPos, yPos, zPos, block.getBlockTexture(render.blockAccess, xPos, yPos, zPos, 0));
            flag = true;
        }

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos, yPos + 1, zPos, 1)) {
            if(render.renderMaxY >= 1.0D) {
                ++yPos;
            }

            render.aoBrightnessXYNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos, zPos);
            render.aoBrightnessXYPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos, zPos);
            render.aoBrightnessYZPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos - 1);
            render.aoBrightnessYZPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos + 1);
            render.aoLightValueScratchXYNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos, zPos);
            render.aoLightValueScratchXYPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos, zPos);
            render.aoLightValueScratchYZPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos, zPos - 1);
            render.aoLightValueScratchYZPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos, zPos + 1);
            flag3 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos + 1, yPos + 1, zPos)];
            flag2 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos - 1, yPos + 1, zPos)];
            flag5 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos, yPos + 1, zPos + 1)];
            flag4 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos, yPos + 1, zPos - 1)];

            if(!flag4 && !flag2) {
                render.aoLightValueScratchXYZNPN = render.aoLightValueScratchXYNP;
                render.aoBrightnessXYZNPN = render.aoBrightnessXYNP;
            }
            else {
                render.aoLightValueScratchXYZNPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos, zPos - 1);
                render.aoBrightnessXYZNPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos, zPos - 1);
            }

            if(!flag4 && !flag3) {
                render.aoLightValueScratchXYZPPN = render.aoLightValueScratchXYPP;
                render.aoBrightnessXYZPPN = render.aoBrightnessXYPP;
            }
            else {
                render.aoLightValueScratchXYZPPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos, zPos - 1);
                render.aoBrightnessXYZPPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos, zPos - 1);
            }

            if(!flag5 && !flag2) {
                render.aoLightValueScratchXYZNPP = render.aoLightValueScratchXYNP;
                render.aoBrightnessXYZNPP = render.aoBrightnessXYNP;
            }
            else {
                render.aoLightValueScratchXYZNPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos, zPos + 1);
                render.aoBrightnessXYZNPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos, zPos + 1);
            }

            if(!flag5 && !flag3) {
                render.aoLightValueScratchXYZPPP = render.aoLightValueScratchXYPP;
                render.aoBrightnessXYZPPP = render.aoBrightnessXYPP;
            }
            else {
                render.aoLightValueScratchXYZPPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos, zPos + 1);
                render.aoBrightnessXYZPPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos, zPos + 1);
            }

            if(render.renderMaxY >= 1.0D) {

                --yPos;
            }

            i1 = l;

            if(render.renderMaxY >= 1.0D || !render.blockAccess.isBlockOpaqueCube(xPos, yPos + 1, zPos)) {
                i1 = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos + 1, zPos);
            }

            f7 = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos + 1, zPos);
            f6 = (render.aoLightValueScratchXYZNPP + render.aoLightValueScratchXYNP + render.aoLightValueScratchYZPP + f7) / 4.0F;
            f3 = (render.aoLightValueScratchYZPP + f7 + render.aoLightValueScratchXYZPPP + render.aoLightValueScratchXYPP) / 4.0F;
            f4 = (f7 + render.aoLightValueScratchYZPN + render.aoLightValueScratchXYPP + render.aoLightValueScratchXYZPPN) / 4.0F;
            f5 = (render.aoLightValueScratchXYNP + render.aoLightValueScratchXYZNPN + f7 + render.aoLightValueScratchYZPN) / 4.0F;
            render.brightnessTopRight = render.getAoBrightness(render.aoBrightnessXYZNPP, render.aoBrightnessXYNP, render.aoBrightnessYZPP, i1);
            render.brightnessTopLeft = render.getAoBrightness(render.aoBrightnessYZPP, render.aoBrightnessXYZPPP, render.aoBrightnessXYPP, i1);
            render.brightnessBottomLeft = render.getAoBrightness(render.aoBrightnessYZPN, render.aoBrightnessXYPP, render.aoBrightnessXYZPPN, i1);
            render.brightnessBottomRight = render.getAoBrightness(render.aoBrightnessXYNP, render.aoBrightnessXYZNPN, render.aoBrightnessYZPN, i1);
            render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = colorRed;
            render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = colorGreen;
            render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = colorBlue;
            render.colorRedTopLeft *= f3;
            render.colorGreenTopLeft *= f3;
            render.colorBlueTopLeft *= f3;
            render.colorRedBottomLeft *= f4;
            render.colorGreenBottomLeft *= f4;
            render.colorBlueBottomLeft *= f4;
            render.colorRedBottomRight *= f5;
            render.colorGreenBottomRight *= f5;
            render.colorBlueBottomRight *= f5;
            render.colorRedTopRight *= f6;
            render.colorGreenTopRight *= f6;
            render.colorBlueTopRight *= f6;
            render.renderFaceYPos(block, xPos, yPos, zPos, block.getBlockTexture(render.blockAccess, xPos, yPos, zPos, 1));
            flag = true;
        }

        Icon icon;

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos, yPos, zPos - 1, 2)) {
            if(render.renderMinZ <= 0.0D) {
                --zPos;
            }

            render.aoLightValueScratchXZNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos, zPos);
            render.aoLightValueScratchYZNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos - 1, zPos);
            render.aoLightValueScratchYZPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos + 1, zPos);
            render.aoLightValueScratchXZPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos, zPos);
            render.aoBrightnessXZNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos, zPos);
            render.aoBrightnessYZNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos - 1, zPos);
            render.aoBrightnessYZPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos + 1, zPos);
            render.aoBrightnessXZPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos, zPos);
            flag3 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos + 1, yPos, zPos - 1)];
            flag2 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos - 1, yPos, zPos - 1)];
            flag5 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos, yPos + 1, zPos - 1)];
            flag4 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos, yPos - 1, zPos - 1)];

            if(!flag2 && !flag4) {
                render.aoLightValueScratchXYZNNN = render.aoLightValueScratchXZNN;
                render.aoBrightnessXYZNNN = render.aoBrightnessXZNN;
            }
            else {
                render.aoLightValueScratchXYZNNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos - 1, zPos);
                render.aoBrightnessXYZNNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos - 1, zPos);
            }

            if(!flag2 && !flag5) {
                render.aoLightValueScratchXYZNPN = render.aoLightValueScratchXZNN;
                render.aoBrightnessXYZNPN = render.aoBrightnessXZNN;
            }
            else {
                render.aoLightValueScratchXYZNPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos + 1, zPos);
                render.aoBrightnessXYZNPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos + 1, zPos);
            }

            if(!flag3 && !flag4) {
                render.aoLightValueScratchXYZPNN = render.aoLightValueScratchXZPN;
                render.aoBrightnessXYZPNN = render.aoBrightnessXZPN;
            }
            else {
                render.aoLightValueScratchXYZPNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos - 1, zPos);
                render.aoBrightnessXYZPNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos - 1, zPos);
            }

            if(!flag3 && !flag5) {
                render.aoLightValueScratchXYZPPN = render.aoLightValueScratchXZPN;
                render.aoBrightnessXYZPPN = render.aoBrightnessXZPN;
            }
            else {
                render.aoLightValueScratchXYZPPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos + 1, zPos);
                render.aoBrightnessXYZPPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos + 1, zPos);
            }

            if(render.renderMinZ <= 0.0D) {
                ++zPos;
            }

            i1 = l;

            if(render.renderMinZ <= 0.0D || !render.blockAccess.isBlockOpaqueCube(xPos, yPos, zPos - 1)) {
                i1 = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos - 1);
            }

            f7 = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos, zPos - 1);
            f3 = (render.aoLightValueScratchXZNN + render.aoLightValueScratchXYZNPN + f7 + render.aoLightValueScratchYZPN) / 4.0F;
            f4 = (f7 + render.aoLightValueScratchYZPN + render.aoLightValueScratchXZPN + render.aoLightValueScratchXYZPPN) / 4.0F;
            f5 = (render.aoLightValueScratchYZNN + f7 + render.aoLightValueScratchXYZPNN + render.aoLightValueScratchXZPN) / 4.0F;
            f6 = (render.aoLightValueScratchXYZNNN + render.aoLightValueScratchXZNN + render.aoLightValueScratchYZNN + f7) / 4.0F;
            render.brightnessTopLeft = render.getAoBrightness(render.aoBrightnessXZNN, render.aoBrightnessXYZNPN, render.aoBrightnessYZPN, i1);
            render.brightnessBottomLeft = render.getAoBrightness(render.aoBrightnessYZPN, render.aoBrightnessXZPN, render.aoBrightnessXYZPPN, i1);
            render.brightnessBottomRight = render.getAoBrightness(render.aoBrightnessYZNN, render.aoBrightnessXYZPNN, render.aoBrightnessXZPN, i1);
            render.brightnessTopRight = render.getAoBrightness(render.aoBrightnessXYZNNN, render.aoBrightnessXZNN, render.aoBrightnessYZNN, i1);

            if(flag1) {
                render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = colorRed * 0.8F;
                render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = colorGreen * 0.8F;
                render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = colorBlue * 0.8F;
            }
            else {
                render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = 0.8F;
                render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = 0.8F;
                render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = 0.8F;
            }

            render.colorRedTopLeft *= f3;
            render.colorGreenTopLeft *= f3;
            render.colorBlueTopLeft *= f3;
            render.colorRedBottomLeft *= f4;
            render.colorGreenBottomLeft *= f4;
            render.colorBlueBottomLeft *= f4;
            render.colorRedBottomRight *= f5;
            render.colorGreenBottomRight *= f5;
            render.colorBlueBottomRight *= f5;
            render.colorRedTopRight *= f6;
            render.colorGreenTopRight *= f6;
            render.colorBlueTopRight *= f6;
            icon = block.getBlockTexture(render.blockAccess, xPos, yPos, zPos, 2);
            render.renderFaceZNeg(block, xPos, yPos, zPos, icon);

            flag = true;
        }

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos, yPos, zPos + 1, 3)) {
            if(render.renderMaxZ >= 1.0D) {
                ++zPos;
            }

            render.aoLightValueScratchXZNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos, zPos);
            render.aoLightValueScratchXZPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos, zPos);
            render.aoLightValueScratchYZNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos - 1, zPos);
            render.aoLightValueScratchYZPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos + 1, zPos);
            render.aoBrightnessXZNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos, zPos);
            render.aoBrightnessXZPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos, zPos);
            render.aoBrightnessYZNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos - 1, zPos);
            render.aoBrightnessYZPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos + 1, zPos);
            flag3 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos + 1, yPos, zPos + 1)];
            flag2 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos - 1, yPos, zPos + 1)];
            flag5 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos, yPos + 1, zPos + 1)];
            flag4 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos, yPos - 1, zPos + 1)];

            if(!flag2 && !flag4) {
                render.aoLightValueScratchXYZNNP = render.aoLightValueScratchXZNP;
                render.aoBrightnessXYZNNP = render.aoBrightnessXZNP;
            }
            else {
                render.aoLightValueScratchXYZNNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos - 1, zPos);
                render.aoBrightnessXYZNNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos - 1, zPos);
            }

            if(!flag2 && !flag5) {
                render.aoLightValueScratchXYZNPP = render.aoLightValueScratchXZNP;
                render.aoBrightnessXYZNPP = render.aoBrightnessXZNP;
            }
            else {
                render.aoLightValueScratchXYZNPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos + 1, zPos);
                render.aoBrightnessXYZNPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos + 1, zPos);
            }

            if(!flag3 && !flag4) {
                render.aoLightValueScratchXYZPNP = render.aoLightValueScratchXZPP;
                render.aoBrightnessXYZPNP = render.aoBrightnessXZPP;
            }
            else {
                render.aoLightValueScratchXYZPNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos - 1, zPos);
                render.aoBrightnessXYZPNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos - 1, zPos);
            }

            if(!flag3 && !flag5) {
                render.aoLightValueScratchXYZPPP = render.aoLightValueScratchXZPP;
                render.aoBrightnessXYZPPP = render.aoBrightnessXZPP;
            }
            else {
                render.aoLightValueScratchXYZPPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos + 1, zPos);
                render.aoBrightnessXYZPPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos + 1, zPos);
            }

            if(render.renderMaxZ >= 1.0D) {
                --zPos;
            }

            i1 = l;

            if(render.renderMaxZ >= 1.0D || !render.blockAccess.isBlockOpaqueCube(xPos, yPos, zPos + 1)) {
                i1 = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos + 1);
            }

            f7 = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos, zPos + 1);
            f3 = (render.aoLightValueScratchXZNP + render.aoLightValueScratchXYZNPP + f7 + render.aoLightValueScratchYZPP) / 4.0F;
            f6 = (f7 + render.aoLightValueScratchYZPP + render.aoLightValueScratchXZPP + render.aoLightValueScratchXYZPPP) / 4.0F;
            f5 = (render.aoLightValueScratchYZNP + f7 + render.aoLightValueScratchXYZPNP + render.aoLightValueScratchXZPP) / 4.0F;
            f4 = (render.aoLightValueScratchXYZNNP + render.aoLightValueScratchXZNP + render.aoLightValueScratchYZNP + f7) / 4.0F;
            render.brightnessTopLeft = render.getAoBrightness(render.aoBrightnessXZNP, render.aoBrightnessXYZNPP, render.aoBrightnessYZPP, i1);
            render.brightnessTopRight = render.getAoBrightness(render.aoBrightnessYZPP, render.aoBrightnessXZPP, render.aoBrightnessXYZPPP, i1);
            render.brightnessBottomRight = render.getAoBrightness(render.aoBrightnessYZNP, render.aoBrightnessXYZPNP, render.aoBrightnessXZPP, i1);
            render.brightnessBottomLeft = render.getAoBrightness(render.aoBrightnessXYZNNP, render.aoBrightnessXZNP, render.aoBrightnessYZNP, i1);

            if(flag1) {
                render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = colorRed * 0.8F;
                render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = colorGreen * 0.8F;
                render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = colorBlue * 0.8F;
            }
            else {
                render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = 0.8F;
                render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = 0.8F;
                render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = 0.8F;
            }

            render.colorRedTopLeft *= f3;
            render.colorGreenTopLeft *= f3;
            render.colorBlueTopLeft *= f3;
            render.colorRedBottomLeft *= f4;
            render.colorGreenBottomLeft *= f4;
            render.colorBlueBottomLeft *= f4;
            render.colorRedBottomRight *= f5;
            render.colorGreenBottomRight *= f5;
            render.colorBlueBottomRight *= f5;
            render.colorRedTopRight *= f6;
            render.colorGreenTopRight *= f6;
            render.colorBlueTopRight *= f6;
            icon = block.getBlockTexture(render.blockAccess, xPos, yPos, zPos, 3);
            render.renderFaceZPos(block, xPos, yPos, zPos, icon);

            flag = true;
        }

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos - 1, yPos, zPos, 4)) {
            if(render.renderMinX <= 0.0D) {
                --xPos;
            }

            render.aoLightValueScratchXYNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos - 1, zPos);
            render.aoLightValueScratchXZNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos, zPos - 1);
            render.aoLightValueScratchXZNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos, zPos + 1);
            render.aoLightValueScratchXYNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos + 1, zPos);
            render.aoBrightnessXYNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos - 1, zPos);
            render.aoBrightnessXZNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos - 1);
            render.aoBrightnessXZNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos + 1);
            render.aoBrightnessXYNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos + 1, zPos);
            flag3 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos - 1, yPos + 1, zPos)];
            flag2 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos - 1, yPos - 1, zPos)];
            flag5 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos - 1, yPos, zPos - 1)];
            flag4 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos - 1, yPos, zPos + 1)];

            if(!flag5 && !flag2) {
                render.aoLightValueScratchXYZNNN = render.aoLightValueScratchXZNN;
                render.aoBrightnessXYZNNN = render.aoBrightnessXZNN;
            }
            else {
                render.aoLightValueScratchXYZNNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos - 1, zPos - 1);
                render.aoBrightnessXYZNNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos - 1, zPos - 1);
            }

            if(!flag4 && !flag2) {
                render.aoLightValueScratchXYZNNP = render.aoLightValueScratchXZNP;
                render.aoBrightnessXYZNNP = render.aoBrightnessXZNP;
            }
            else {
                render.aoLightValueScratchXYZNNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos - 1, zPos + 1);
                render.aoBrightnessXYZNNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos - 1, zPos + 1);
            }

            if(!flag5 && !flag3) {
                render.aoLightValueScratchXYZNPN = render.aoLightValueScratchXZNN;
                render.aoBrightnessXYZNPN = render.aoBrightnessXZNN;
            }
            else {
                render.aoLightValueScratchXYZNPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos + 1, zPos - 1);
                render.aoBrightnessXYZNPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos + 1, zPos - 1);
            }

            if(!flag4 && !flag3) {
                render.aoLightValueScratchXYZNPP = render.aoLightValueScratchXZNP;
                render.aoBrightnessXYZNPP = render.aoBrightnessXZNP;
            }
            else {
                render.aoLightValueScratchXYZNPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos + 1, zPos + 1);
                render.aoBrightnessXYZNPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos + 1, zPos + 1);
            }

            if(render.renderMinX <= 0.0D) {
                ++xPos;
            }

            i1 = l;

            if(render.renderMinX <= 0.0D || !render.blockAccess.isBlockOpaqueCube(xPos - 1, yPos, zPos)) {
                i1 = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos, zPos);
            }

            f7 = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos, zPos);
            f6 = (render.aoLightValueScratchXYNN + render.aoLightValueScratchXYZNNP + f7 + render.aoLightValueScratchXZNP) / 4.0F;
            f3 = (f7 + render.aoLightValueScratchXZNP + render.aoLightValueScratchXYNP + render.aoLightValueScratchXYZNPP) / 4.0F;
            f4 = (render.aoLightValueScratchXZNN + f7 + render.aoLightValueScratchXYZNPN + render.aoLightValueScratchXYNP) / 4.0F;
            f5 = (render.aoLightValueScratchXYZNNN + render.aoLightValueScratchXYNN + render.aoLightValueScratchXZNN + f7) / 4.0F;
            render.brightnessTopRight = render.getAoBrightness(render.aoBrightnessXYNN, render.aoBrightnessXYZNNP, render.aoBrightnessXZNP, i1);
            render.brightnessTopLeft = render.getAoBrightness(render.aoBrightnessXZNP, render.aoBrightnessXYNP, render.aoBrightnessXYZNPP, i1);
            render.brightnessBottomLeft = render.getAoBrightness(render.aoBrightnessXZNN, render.aoBrightnessXYZNPN, render.aoBrightnessXYNP, i1);
            render.brightnessBottomRight = render.getAoBrightness(render.aoBrightnessXYZNNN, render.aoBrightnessXYNN, render.aoBrightnessXZNN, i1);

            if(flag1) {
                render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = colorRed * 0.6F;
                render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = colorGreen * 0.6F;
                render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = colorBlue * 0.6F;
            }
            else {
                render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = 0.6F;
                render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = 0.6F;
                render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = 0.6F;
            }

            render.colorRedTopLeft *= f3;
            render.colorGreenTopLeft *= f3;
            render.colorBlueTopLeft *= f3;
            render.colorRedBottomLeft *= f4;
            render.colorGreenBottomLeft *= f4;
            render.colorBlueBottomLeft *= f4;
            render.colorRedBottomRight *= f5;
            render.colorGreenBottomRight *= f5;
            render.colorBlueBottomRight *= f5;
            render.colorRedTopRight *= f6;
            render.colorGreenTopRight *= f6;
            render.colorBlueTopRight *= f6;
            icon = block.getBlockTexture(render.blockAccess, xPos, yPos, zPos, 4);
            render.renderFaceXNeg(block, xPos, yPos, zPos, icon);

            flag = true;
        }

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos + 1, yPos, zPos, 5)) {
            if(render.renderMaxX >= 1.0D) {
                ++xPos;
            }

            render.aoLightValueScratchXYPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos - 1, zPos);
            render.aoLightValueScratchXZPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos, zPos - 1);
            render.aoLightValueScratchXZPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos, zPos + 1);
            render.aoLightValueScratchXYPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos + 1, zPos);
            render.aoBrightnessXYPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos - 1, zPos);
            render.aoBrightnessXZPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos - 1);
            render.aoBrightnessXZPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos + 1);
            render.aoBrightnessXYPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos + 1, zPos);
            flag3 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos + 1, yPos + 1, zPos)];
            flag2 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos + 1, yPos - 1, zPos)];
            flag5 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos + 1, yPos, zPos + 1)];
            flag4 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos + 1, yPos, zPos - 1)];

            if(!flag2 && !flag4) {
                render.aoLightValueScratchXYZPNN = render.aoLightValueScratchXZPN;
                render.aoBrightnessXYZPNN = render.aoBrightnessXZPN;
            }
            else {
                render.aoLightValueScratchXYZPNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos - 1, zPos - 1);
                render.aoBrightnessXYZPNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos - 1, zPos - 1);
            }

            if(!flag2 && !flag5) {
                render.aoLightValueScratchXYZPNP = render.aoLightValueScratchXZPP;
                render.aoBrightnessXYZPNP = render.aoBrightnessXZPP;
            }
            else {
                render.aoLightValueScratchXYZPNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos - 1, zPos + 1);
                render.aoBrightnessXYZPNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos - 1, zPos + 1);
            }

            if(!flag3 && !flag4) {
                render.aoLightValueScratchXYZPPN = render.aoLightValueScratchXZPN;
                render.aoBrightnessXYZPPN = render.aoBrightnessXZPN;
            }
            else {
                render.aoLightValueScratchXYZPPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos + 1, zPos - 1);
                render.aoBrightnessXYZPPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos + 1, zPos - 1);
            }

            if(!flag3 && !flag5) {
                render.aoLightValueScratchXYZPPP = render.aoLightValueScratchXZPP;
                render.aoBrightnessXYZPPP = render.aoBrightnessXZPP;
            }
            else {
                render.aoLightValueScratchXYZPPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos + 1, zPos + 1);
                render.aoBrightnessXYZPPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos + 1, zPos + 1);
            }

            if(render.renderMaxX >= 1.0D) {
                --xPos;
            }

            i1 = l;

            if(render.renderMaxX >= 1.0D || !render.blockAccess.isBlockOpaqueCube(xPos + 1, yPos, zPos)) {
                i1 = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos, zPos);
            }

            f7 = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos, zPos);
            f3 = (render.aoLightValueScratchXYPN + render.aoLightValueScratchXYZPNP + f7 + render.aoLightValueScratchXZPP) / 4.0F;
            f4 = (render.aoLightValueScratchXYZPNN + render.aoLightValueScratchXYPN + render.aoLightValueScratchXZPN + f7) / 4.0F;
            f5 = (render.aoLightValueScratchXZPN + f7 + render.aoLightValueScratchXYZPPN + render.aoLightValueScratchXYPP) / 4.0F;
            f6 = (f7 + render.aoLightValueScratchXZPP + render.aoLightValueScratchXYPP + render.aoLightValueScratchXYZPPP) / 4.0F;
            render.brightnessTopLeft = render.getAoBrightness(render.aoBrightnessXYPN, render.aoBrightnessXYZPNP, render.aoBrightnessXZPP, i1);
            render.brightnessTopRight = render.getAoBrightness(render.aoBrightnessXZPP, render.aoBrightnessXYPP, render.aoBrightnessXYZPPP, i1);
            render.brightnessBottomRight = render.getAoBrightness(render.aoBrightnessXZPN, render.aoBrightnessXYZPPN, render.aoBrightnessXYPP, i1);
            render.brightnessBottomLeft = render.getAoBrightness(render.aoBrightnessXYZPNN, render.aoBrightnessXYPN, render.aoBrightnessXZPN, i1);

            if(flag1) {
                render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = colorRed * 0.6F;
                render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = colorGreen * 0.6F;
                render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = colorBlue * 0.6F;
            }
            else {
                render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = 0.6F;
                render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = 0.6F;
                render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = 0.6F;
            }

            render.colorRedTopLeft *= f3;
            render.colorGreenTopLeft *= f3;
            render.colorBlueTopLeft *= f3;
            render.colorRedBottomLeft *= f4;
            render.colorGreenBottomLeft *= f4;
            render.colorBlueBottomLeft *= f4;
            render.colorRedBottomRight *= f5;
            render.colorGreenBottomRight *= f5;
            render.colorBlueBottomRight *= f5;
            render.colorRedTopRight *= f6;
            render.colorGreenTopRight *= f6;
            render.colorBlueTopRight *= f6;
            icon = block.getBlockTexture(render.blockAccess, xPos, yPos, zPos, 5);
            render.renderFaceXPos(block, xPos, yPos, zPos, icon);

            flag = true;
        }

        render.enableAO = false;
        return flag;
    }

    static boolean renderMetadataBlockWithColorMultiplier(Block block, int metadata, int xPos, int yPos, int zPos, float colorRed, float colorGreen, float colorBlue, RenderBlocks render, IBlockAccess world) {
        render.enableAO = false;
        Tessellator tessellator = Tessellator.instance;
        boolean flag = false;
        float f3 = 0.5F;
        float f4 = 1.0F;
        float f5 = 0.8F;
        float f6 = 0.6F;
        float f7 = f4 * colorRed;
        float f8 = f4 * colorGreen;
        float f9 = f4 * colorBlue;
        float f10 = f3;
        float f11 = f5;
        float f12 = f6;
        float f13 = f3;
        float f14 = f5;
        float f15 = f6;
        float f16 = f3;
        float f17 = f5;
        float f18 = f6;

        if(block != Block.grass) {
            f10 = f3 * colorRed;
            f11 = f5 * colorRed;
            f12 = f6 * colorRed;
            f13 = f3 * colorGreen;
            f14 = f5 * colorGreen;
            f15 = f6 * colorGreen;
            f16 = f3 * colorBlue;
            f17 = f5 * colorBlue;
            f18 = f6 * colorBlue;
        }

        int l = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos);

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos, yPos - 1, zPos, 0)) {
            tessellator.setBrightness(render.renderMinY > 0.0D ? l : block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos - 1, zPos));
            tessellator.setColorOpaque_F(f10, f13, f16);
            render.renderFaceYNeg(block, xPos, yPos, zPos, block.getBlockTexture(render.blockAccess, xPos, yPos, zPos, 0));
            flag = true;
        }

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos, yPos + 1, zPos, 1)) {
            tessellator.setBrightness(render.renderMaxY < 1.0D ? l : block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos + 1, zPos));
            tessellator.setColorOpaque_F(f7, f8, f9);
            render.renderFaceYPos(block, xPos, yPos, zPos, block.getBlockTexture(render.blockAccess, xPos, yPos, zPos, 1));
            flag = true;
        }

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos, yPos, zPos - 1, 2)) {
            tessellator.setBrightness(render.renderMinZ > 0.0D ? l : block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos - 1));
            tessellator.setColorOpaque_F(f11, f14, f17);
            render.renderFaceZNeg(block, xPos, yPos, zPos, block.getBlockTexture(render.blockAccess, xPos, yPos, zPos, 2));

            flag = true;
        }

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos, yPos, zPos + 1, 3)) {
            tessellator.setBrightness(render.renderMaxZ < 1.0D ? l : block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos + 1));
            tessellator.setColorOpaque_F(f11, f14, f17);
            render.renderFaceZPos(block, xPos, yPos, zPos, block.getBlockTexture(render.blockAccess, xPos, yPos, zPos, 3));

            flag = true;
        }

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos - 1, yPos, zPos, 4)) {
            tessellator.setBrightness(render.renderMinX > 0.0D ? l : block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos, zPos));
            tessellator.setColorOpaque_F(f12, f15, f18);
            render.renderFaceXNeg(block, xPos, yPos, zPos, block.getBlockTexture(render.blockAccess, xPos, yPos, zPos, 4));

            flag = true;
        }

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos + 1, yPos, zPos, 5)) {
            tessellator.setBrightness(render.renderMaxX < 1.0D ? l : block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos, zPos));
            tessellator.setColorOpaque_F(f12, f15, f18);
            render.renderFaceXPos(block, xPos, yPos, zPos, block.getBlockTexture(render.blockAccess, xPos, yPos, zPos, 5));

            flag = true;
        }

        return flag;
    }

    public static Icon renderConnectedTexture(IBlockAccess blockAccess, Icon[] icons, int id, int x, int y, int z, int side) {

        boolean isOpenUp = false, isOpenDown = false, isOpenLeft = false, isOpenRight = false;

        switch(side) {

            case 0:

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x, y - 1, z), blockAccess.getBlockMetadata(x, y - 1, z))) {

                    return icons[15];
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x - 1, y, z), blockAccess.getBlockMetadata(x - 1, y, z))) {
                    isOpenDown = true;
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x + 1, y, z), blockAccess.getBlockMetadata(x + 1, y, z))) {
                    isOpenUp = true;
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x, y, z - 1), blockAccess.getBlockMetadata(x, y, z - 1))) {
                    isOpenLeft = true;
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x, y, z + 1), blockAccess.getBlockMetadata(x, y, z + 1))) {
                    isOpenRight = true;
                }

                if(isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[15];
                }
                else if(isOpenUp && isOpenDown && isOpenLeft) {
                    return icons[11];
                }
                else if(isOpenUp && isOpenDown && isOpenRight) {
                    return icons[12];
                }
                else if(isOpenUp && isOpenLeft && isOpenRight) {
                    return icons[13];
                }
                else if(isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[14];
                }
                else if(isOpenDown && isOpenUp) {
                    return icons[5];
                }
                else if(isOpenLeft && isOpenRight) {
                    return icons[6];
                }
                else if(isOpenDown && isOpenLeft) {
                    return icons[8];
                }
                else if(isOpenDown && isOpenRight) {
                    return icons[10];
                }
                else if(isOpenUp && isOpenLeft) {
                    return icons[7];
                }
                else if(isOpenUp && isOpenRight) {
                    return icons[9];
                }
                else if(isOpenDown) {
                    return icons[3];
                }
                else if(isOpenUp) {
                    return icons[4];
                }
                else if(isOpenLeft) {
                    return icons[2];
                }
                else if(isOpenRight) {
                    return icons[1];
                }
                break;

            case 1:

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x, y + 1, z), blockAccess.getBlockMetadata(x, y + 1, z))) {

                    return icons[15];
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x - 1, y, z), blockAccess.getBlockMetadata(x - 1, y, z))) {
                    isOpenDown = true;
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x + 1, y, z), blockAccess.getBlockMetadata(x + 1, y, z))) {
                    isOpenUp = true;
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x, y, z - 1), blockAccess.getBlockMetadata(x, y, z - 1))) {
                    isOpenLeft = true;
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x, y, z + 1), blockAccess.getBlockMetadata(x, y, z + 1))) {
                    isOpenRight = true;
                }

                if(isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[15];
                }
                else if(isOpenUp && isOpenDown && isOpenLeft) {
                    return icons[11];
                }
                else if(isOpenUp && isOpenDown && isOpenRight) {
                    return icons[12];
                }
                else if(isOpenUp && isOpenLeft && isOpenRight) {
                    return icons[13];
                }
                else if(isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[14];
                }
                else if(isOpenDown && isOpenUp) {
                    return icons[5];
                }
                else if(isOpenLeft && isOpenRight) {
                    return icons[6];
                }
                else if(isOpenDown && isOpenLeft) {
                    return icons[8];
                }
                else if(isOpenDown && isOpenRight) {
                    return icons[10];
                }
                else if(isOpenUp && isOpenLeft) {
                    return icons[7];
                }
                else if(isOpenUp && isOpenRight) {
                    return icons[9];
                }
                else if(isOpenDown) {
                    return icons[3];
                }
                else if(isOpenUp) {
                    return icons[4];
                }
                else if(isOpenLeft) {
                    return icons[2];
                }
                else if(isOpenRight) {
                    return icons[1];
                }
                break;

            case 2:

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x, y, z - 1), blockAccess.getBlockMetadata(x, y, z - 1))) {

                    return icons[15];
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x, y - 1, z), blockAccess.getBlockMetadata(x, y - 1, z))) {
                    isOpenDown = true;
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x, y + 1, z), blockAccess.getBlockMetadata(x, y + 1, z))) {
                    isOpenUp = true;
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x - 1, y, z), blockAccess.getBlockMetadata(x - 1, y, z))) {
                    isOpenLeft = true;
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x + 1, y, z), blockAccess.getBlockMetadata(x + 1, y, z))) {
                    isOpenRight = true;
                }

                if(isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[15];
                }
                else if(isOpenUp && isOpenDown && isOpenLeft) {
                    return icons[13];
                }
                else if(isOpenUp && isOpenDown && isOpenRight) {
                    return icons[14];
                }
                else if(isOpenUp && isOpenLeft && isOpenRight) {
                    return icons[11];
                }
                else if(isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[12];
                }
                else if(isOpenDown && isOpenUp) {
                    return icons[6];
                }
                else if(isOpenLeft && isOpenRight) {
                    return icons[5];
                }
                else if(isOpenDown && isOpenLeft) {
                    return icons[9];
                }
                else if(isOpenDown && isOpenRight) {
                    return icons[10];
                }
                else if(isOpenUp && isOpenLeft) {
                    return icons[7];
                }
                else if(isOpenUp && isOpenRight) {
                    return icons[8];
                }
                else if(isOpenDown) {
                    return icons[1];
                }
                else if(isOpenUp) {
                    return icons[2];
                }
                else if(isOpenLeft) {
                    return icons[4];
                }
                else if(isOpenRight) {
                    return icons[3];
                }
                break;

            case 3:

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x, y, z + 1), blockAccess.getBlockMetadata(x, y, z + 1))) {

                    return icons[15];
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x, y - 1, z), blockAccess.getBlockMetadata(x, y - 1, z))) {
                    isOpenDown = true;
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x, y + 1, z), blockAccess.getBlockMetadata(x, y + 1, z))) {
                    isOpenUp = true;
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x - 1, y, z), blockAccess.getBlockMetadata(x - 1, y, z))) {
                    isOpenLeft = true;
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x + 1, y, z), blockAccess.getBlockMetadata(x + 1, y, z))) {
                    isOpenRight = true;
                }

                if(isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[15];
                }
                else if(isOpenUp && isOpenDown && isOpenLeft) {
                    return icons[14];
                }
                else if(isOpenUp && isOpenDown && isOpenRight) {
                    return icons[13];
                }
                else if(isOpenUp && isOpenLeft && isOpenRight) {
                    return icons[11];
                }
                else if(isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[12];
                }
                else if(isOpenDown && isOpenUp) {
                    return icons[6];
                }
                else if(isOpenLeft && isOpenRight) {
                    return icons[5];
                }
                else if(isOpenDown && isOpenLeft) {
                    return icons[10];
                }
                else if(isOpenDown && isOpenRight) {
                    return icons[9];
                }
                else if(isOpenUp && isOpenLeft) {
                    return icons[8];
                }
                else if(isOpenUp && isOpenRight) {
                    return icons[7];
                }
                else if(isOpenDown) {
                    return icons[1];
                }
                else if(isOpenUp) {
                    return icons[2];
                }
                else if(isOpenLeft) {
                    return icons[3];
                }
                else if(isOpenRight) {
                    return icons[4];
                }
                break;

            case 4:

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x - 1, y, z), blockAccess.getBlockMetadata(x - 1, y, z))) {

                    return icons[15];
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x, y - 1, z), blockAccess.getBlockMetadata(x, y - 1, z))) {
                    isOpenDown = true;
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x, y + 1, z), blockAccess.getBlockMetadata(x, y + 1, z))) {
                    isOpenUp = true;
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x, y, z - 1), blockAccess.getBlockMetadata(x, y, z - 1))) {
                    isOpenLeft = true;
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x, y, z + 1), blockAccess.getBlockMetadata(x, y, z + 1))) {
                    isOpenRight = true;
                }

                if(isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[15];
                }
                else if(isOpenUp && isOpenDown && isOpenLeft) {
                    return icons[14];
                }
                else if(isOpenUp && isOpenDown && isOpenRight) {
                    return icons[13];
                }
                else if(isOpenUp && isOpenLeft && isOpenRight) {
                    return icons[11];
                }
                else if(isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[12];
                }
                else if(isOpenDown && isOpenUp) {
                    return icons[6];
                }
                else if(isOpenLeft && isOpenRight) {
                    return icons[5];
                }
                else if(isOpenDown && isOpenLeft) {
                    return icons[10];
                }
                else if(isOpenDown && isOpenRight) {
                    return icons[9];
                }
                else if(isOpenUp && isOpenLeft) {
                    return icons[8];
                }
                else if(isOpenUp && isOpenRight) {
                    return icons[7];
                }
                else if(isOpenDown) {
                    return icons[1];
                }
                else if(isOpenUp) {
                    return icons[2];
                }
                else if(isOpenLeft) {
                    return icons[3];
                }
                else if(isOpenRight) {
                    return icons[4];
                }
                break;

            case 5:

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x + 1, y, z), blockAccess.getBlockMetadata(x + 1, y, z))) {

                    return icons[15];
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x, y - 1, z), blockAccess.getBlockMetadata(x, y - 1, z))) {
                    isOpenDown = true;
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x, y + 1, z), blockAccess.getBlockMetadata(x, y + 1, z))) {
                    isOpenUp = true;
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x, y, z - 1), blockAccess.getBlockMetadata(x, y, z - 1))) {
                    isOpenLeft = true;
                }

                if(UtilRender.shouldConnectToBlock(blockAccess, id, x, y, z, blockAccess.getBlockId(x, y, z + 1), blockAccess.getBlockMetadata(x, y, z + 1))) {
                    isOpenRight = true;
                }

                if(isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[15];
                }
                else if(isOpenUp && isOpenDown && isOpenLeft) {
                    return icons[13];
                }
                else if(isOpenUp && isOpenDown && isOpenRight) {
                    return icons[14];
                }
                else if(isOpenUp && isOpenLeft && isOpenRight) {
                    return icons[11];
                }
                else if(isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[12];
                }
                else if(isOpenDown && isOpenUp) {
                    return icons[6];
                }
                else if(isOpenLeft && isOpenRight) {
                    return icons[5];
                }
                else if(isOpenDown && isOpenLeft) {
                    return icons[9];
                }
                else if(isOpenDown && isOpenRight) {
                    return icons[10];
                }
                else if(isOpenUp && isOpenLeft) {
                    return icons[7];
                }
                else if(isOpenUp && isOpenRight) {
                    return icons[8];
                }
                else if(isOpenDown) {
                    return icons[1];
                }
                else if(isOpenUp) {
                    return icons[2];
                }
                else if(isOpenLeft) {
                    return icons[4];
                }
                else if(isOpenRight) {
                    return icons[3];
                }
                break;
        }

        return icons[0];
    }

    private static boolean shouldConnectToBlock(IBlockAccess blockAccess, int idToMatch, int x, int y, int z, int id, int meta) {

        return id == idToMatch;
    }

    public static boolean renderFakeBlock(Icon texture, int x, int y, int z, RenderBlocks renderer, IBlockAccess world) {

        Block block = Block.stone;
        int var5 = block.colorMultiplier(world, x, y, z);
        float var6 = (var5 >> 16 & 255) / 255.0F;
        float var7 = (var5 >> 8 & 255) / 255.0F;
        float var8 = (var5 & 255) / 255.0F;

        if(EntityRenderer.anaglyphEnable) {
            float var9 = (var6 * 30.0F + var7 * 59.0F + var8 * 11.0F) / 100.0F;
            float var10 = (var6 * 30.0F + var7 * 70.0F) / 100.0F;
            float var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
            var6 = var9;
            var7 = var10;
            var8 = var11;
        }

        return Minecraft.isAmbientOcclusionEnabled() ? renderFakeBlockWithAmbientOcclusion(texture, x, y, z, var6, var7, var8, renderer, world) : renderFakeBlockWithColorMultiplier(texture, x, y, z, var6, var7, var8, renderer, world);
    }

    public static boolean renderFakeBlock(Icon texture, int x, int y, int z, RenderBlocks renderer, IBlockAccess world, int colorMultiplier) {

        int var5 = colorMultiplier;
        float var6 = (var5 >> 16 & 255) / 255.0F;
        float var7 = (var5 >> 8 & 255) / 255.0F;
        float var8 = (var5 & 255) / 255.0F;

        if(EntityRenderer.anaglyphEnable) {
            float var9 = (var6 * 30.0F + var7 * 59.0F + var8 * 11.0F) / 100.0F;
            float var10 = (var6 * 30.0F + var7 * 70.0F) / 100.0F;
            float var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
            var6 = var9;
            var7 = var10;
            var8 = var11;
        }

        return Minecraft.isAmbientOcclusionEnabled() ? renderFakeBlockWithAmbientOcclusion(texture, x, y, z, var6, var7, var8, renderer, world) : renderFakeBlockWithColorMultiplier(texture, x, y, z, var6, var7, var8, renderer, world);
    }

    static boolean renderFakeBlockWithAmbientOcclusion(Icon texture, int xPos, int yPos, int zPos, float colorRed, float colorGreen, float colorBlue, RenderBlocks render, IBlockAccess world) {
        Block block = Block.stone;
        render.enableAO = true;
        boolean flag = false;
        float f3 = 0.0F;
        float f4 = 0.0F;
        float f5 = 0.0F;
        float f6 = 0.0F;
        boolean flag1 = true;
        int l = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos);
        Tessellator tessellator = Tessellator.instance;
        tessellator.setBrightness(983055);

        if(render.getBlockIcon(block).getIconName().equals("grass_top")) {
            flag1 = false;
        }
        else if(render.hasOverrideBlockTexture()) {
            flag1 = false;
        }

        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        float f7;
        int i1;

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos, yPos - 1, zPos, 0)) {
            if(render.renderMinY <= 0.0D) {
                --yPos;
            }

            render.aoBrightnessXYNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos, zPos);
            render.aoBrightnessYZNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos - 1);
            render.aoBrightnessYZNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos + 1);
            render.aoBrightnessXYPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos, zPos);
            render.aoLightValueScratchXYNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos, zPos);
            render.aoLightValueScratchYZNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos, zPos - 1);
            render.aoLightValueScratchYZNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos, zPos + 1);
            render.aoLightValueScratchXYPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos, zPos);
            flag3 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos + 1, yPos - 1, zPos)];
            flag2 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos - 1, yPos - 1, zPos)];
            flag5 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos, yPos - 1, zPos + 1)];
            flag4 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos, yPos - 1, zPos - 1)];

            if(!flag4 && !flag2) {
                render.aoLightValueScratchXYZNNN = render.aoLightValueScratchXYNN;
                render.aoBrightnessXYZNNN = render.aoBrightnessXYNN;
            }
            else {
                render.aoLightValueScratchXYZNNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos, zPos - 1);
                render.aoBrightnessXYZNNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos, zPos - 1);
            }

            if(!flag5 && !flag2) {
                render.aoLightValueScratchXYZNNP = render.aoLightValueScratchXYNN;
                render.aoBrightnessXYZNNP = render.aoBrightnessXYNN;
            }
            else {
                render.aoLightValueScratchXYZNNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos, zPos + 1);
                render.aoBrightnessXYZNNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos, zPos + 1);
            }

            if(!flag4 && !flag3) {
                render.aoLightValueScratchXYZPNN = render.aoLightValueScratchXYPN;
                render.aoBrightnessXYZPNN = render.aoBrightnessXYPN;
            }
            else {
                render.aoLightValueScratchXYZPNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos, zPos - 1);
                render.aoBrightnessXYZPNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos, zPos - 1);
            }

            if(!flag5 && !flag3) {
                render.aoLightValueScratchXYZPNP = render.aoLightValueScratchXYPN;
                render.aoBrightnessXYZPNP = render.aoBrightnessXYPN;
            }
            else {
                render.aoLightValueScratchXYZPNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos, zPos + 1);
                render.aoBrightnessXYZPNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos, zPos + 1);
            }

            if(render.renderMinY <= 0.0D) {
                ++yPos;
            }

            i1 = l;

            if(render.renderMinY <= 0.0D || !render.blockAccess.isBlockOpaqueCube(xPos, yPos - 1, zPos)) {
                i1 = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos - 1, zPos);
            }

            f7 = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos - 1, zPos);
            f3 = (render.aoLightValueScratchXYZNNP + render.aoLightValueScratchXYNN + render.aoLightValueScratchYZNP + f7) / 4.0F;
            f6 = (render.aoLightValueScratchYZNP + f7 + render.aoLightValueScratchXYZPNP + render.aoLightValueScratchXYPN) / 4.0F;
            f5 = (f7 + render.aoLightValueScratchYZNN + render.aoLightValueScratchXYPN + render.aoLightValueScratchXYZPNN) / 4.0F;
            f4 = (render.aoLightValueScratchXYNN + render.aoLightValueScratchXYZNNN + f7 + render.aoLightValueScratchYZNN) / 4.0F;
            render.brightnessTopLeft = render.getAoBrightness(render.aoBrightnessXYZNNP, render.aoBrightnessXYNN, render.aoBrightnessYZNP, i1);
            render.brightnessTopRight = render.getAoBrightness(render.aoBrightnessYZNP, render.aoBrightnessXYZPNP, render.aoBrightnessXYPN, i1);
            render.brightnessBottomRight = render.getAoBrightness(render.aoBrightnessYZNN, render.aoBrightnessXYPN, render.aoBrightnessXYZPNN, i1);
            render.brightnessBottomLeft = render.getAoBrightness(render.aoBrightnessXYNN, render.aoBrightnessXYZNNN, render.aoBrightnessYZNN, i1);

            if(flag1) {
                render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = colorRed * 0.5F;
                render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = colorGreen * 0.5F;
                render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = colorBlue * 0.5F;
            }
            else {
                render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = 0.5F;
                render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = 0.5F;
                render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = 0.5F;
            }

            render.colorRedTopLeft *= f3;
            render.colorGreenTopLeft *= f3;
            render.colorBlueTopLeft *= f3;
            render.colorRedBottomLeft *= f4;
            render.colorGreenBottomLeft *= f4;
            render.colorBlueBottomLeft *= f4;
            render.colorRedBottomRight *= f5;
            render.colorGreenBottomRight *= f5;
            render.colorBlueBottomRight *= f5;
            render.colorRedTopRight *= f6;
            render.colorGreenTopRight *= f6;
            render.colorBlueTopRight *= f6;
            render.renderFaceYNeg(block, xPos, yPos, zPos, texture);
            flag = true;
        }

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos, yPos + 1, zPos, 1)) {
            if(render.renderMaxY >= 1.0D) {
                ++yPos;
            }

            render.aoBrightnessXYNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos, zPos);
            render.aoBrightnessXYPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos, zPos);
            render.aoBrightnessYZPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos - 1);
            render.aoBrightnessYZPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos + 1);
            render.aoLightValueScratchXYNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos, zPos);
            render.aoLightValueScratchXYPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos, zPos);
            render.aoLightValueScratchYZPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos, zPos - 1);
            render.aoLightValueScratchYZPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos, zPos + 1);
            flag3 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos + 1, yPos + 1, zPos)];
            flag2 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos - 1, yPos + 1, zPos)];
            flag5 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos, yPos + 1, zPos + 1)];
            flag4 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos, yPos + 1, zPos - 1)];

            if(!flag4 && !flag2) {
                render.aoLightValueScratchXYZNPN = render.aoLightValueScratchXYNP;
                render.aoBrightnessXYZNPN = render.aoBrightnessXYNP;
            }
            else {
                render.aoLightValueScratchXYZNPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos, zPos - 1);
                render.aoBrightnessXYZNPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos, zPos - 1);
            }

            if(!flag4 && !flag3) {
                render.aoLightValueScratchXYZPPN = render.aoLightValueScratchXYPP;
                render.aoBrightnessXYZPPN = render.aoBrightnessXYPP;
            }
            else {
                render.aoLightValueScratchXYZPPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos, zPos - 1);
                render.aoBrightnessXYZPPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos, zPos - 1);
            }

            if(!flag5 && !flag2) {
                render.aoLightValueScratchXYZNPP = render.aoLightValueScratchXYNP;
                render.aoBrightnessXYZNPP = render.aoBrightnessXYNP;
            }
            else {
                render.aoLightValueScratchXYZNPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos, zPos + 1);
                render.aoBrightnessXYZNPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos, zPos + 1);
            }

            if(!flag5 && !flag3) {
                render.aoLightValueScratchXYZPPP = render.aoLightValueScratchXYPP;
                render.aoBrightnessXYZPPP = render.aoBrightnessXYPP;
            }
            else {
                render.aoLightValueScratchXYZPPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos, zPos + 1);
                render.aoBrightnessXYZPPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos, zPos + 1);
            }

            if(render.renderMaxY >= 1.0D) {
                --yPos;
            }

            i1 = l;

            if(render.renderMaxY >= 1.0D || !render.blockAccess.isBlockOpaqueCube(xPos, yPos + 1, zPos)) {
                i1 = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos + 1, zPos);
            }

            f7 = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos + 1, zPos);
            f6 = (render.aoLightValueScratchXYZNPP + render.aoLightValueScratchXYNP + render.aoLightValueScratchYZPP + f7) / 4.0F;
            f3 = (render.aoLightValueScratchYZPP + f7 + render.aoLightValueScratchXYZPPP + render.aoLightValueScratchXYPP) / 4.0F;
            f4 = (f7 + render.aoLightValueScratchYZPN + render.aoLightValueScratchXYPP + render.aoLightValueScratchXYZPPN) / 4.0F;
            f5 = (render.aoLightValueScratchXYNP + render.aoLightValueScratchXYZNPN + f7 + render.aoLightValueScratchYZPN) / 4.0F;
            render.brightnessTopRight = render.getAoBrightness(render.aoBrightnessXYZNPP, render.aoBrightnessXYNP, render.aoBrightnessYZPP, i1);
            render.brightnessTopLeft = render.getAoBrightness(render.aoBrightnessYZPP, render.aoBrightnessXYZPPP, render.aoBrightnessXYPP, i1);
            render.brightnessBottomLeft = render.getAoBrightness(render.aoBrightnessYZPN, render.aoBrightnessXYPP, render.aoBrightnessXYZPPN, i1);
            render.brightnessBottomRight = render.getAoBrightness(render.aoBrightnessXYNP, render.aoBrightnessXYZNPN, render.aoBrightnessYZPN, i1);
            render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = colorRed;
            render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = colorGreen;
            render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = colorBlue;
            render.colorRedTopLeft *= f3;
            render.colorGreenTopLeft *= f3;
            render.colorBlueTopLeft *= f3;
            render.colorRedBottomLeft *= f4;
            render.colorGreenBottomLeft *= f4;
            render.colorBlueBottomLeft *= f4;
            render.colorRedBottomRight *= f5;
            render.colorGreenBottomRight *= f5;
            render.colorBlueBottomRight *= f5;
            render.colorRedTopRight *= f6;
            render.colorGreenTopRight *= f6;
            render.colorBlueTopRight *= f6;
            render.renderFaceYPos(block, xPos, yPos, zPos, texture);
            flag = true;
        }

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos, yPos, zPos - 1, 2)) {
            if(render.renderMinZ <= 0.0D) {
                --zPos;
            }

            render.aoLightValueScratchXZNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos, zPos);
            render.aoLightValueScratchYZNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos - 1, zPos);
            render.aoLightValueScratchYZPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos + 1, zPos);
            render.aoLightValueScratchXZPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos, zPos);
            render.aoBrightnessXZNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos, zPos);
            render.aoBrightnessYZNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos - 1, zPos);
            render.aoBrightnessYZPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos + 1, zPos);
            render.aoBrightnessXZPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos, zPos);
            flag3 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos + 1, yPos, zPos - 1)];
            flag2 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos - 1, yPos, zPos - 1)];
            flag5 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos, yPos + 1, zPos - 1)];
            flag4 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos, yPos - 1, zPos - 1)];

            if(!flag2 && !flag4) {
                render.aoLightValueScratchXYZNNN = render.aoLightValueScratchXZNN;
                render.aoBrightnessXYZNNN = render.aoBrightnessXZNN;
            }
            else {
                render.aoLightValueScratchXYZNNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos - 1, zPos);
                render.aoBrightnessXYZNNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos - 1, zPos);
            }

            if(!flag2 && !flag5) {
                render.aoLightValueScratchXYZNPN = render.aoLightValueScratchXZNN;
                render.aoBrightnessXYZNPN = render.aoBrightnessXZNN;
            }
            else {
                render.aoLightValueScratchXYZNPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos + 1, zPos);
                render.aoBrightnessXYZNPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos + 1, zPos);
            }

            if(!flag3 && !flag4) {
                render.aoLightValueScratchXYZPNN = render.aoLightValueScratchXZPN;
                render.aoBrightnessXYZPNN = render.aoBrightnessXZPN;
            }
            else {
                render.aoLightValueScratchXYZPNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos - 1, zPos);
                render.aoBrightnessXYZPNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos - 1, zPos);
            }

            if(!flag3 && !flag5) {
                render.aoLightValueScratchXYZPPN = render.aoLightValueScratchXZPN;
                render.aoBrightnessXYZPPN = render.aoBrightnessXZPN;
            }
            else {
                render.aoLightValueScratchXYZPPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos + 1, zPos);
                render.aoBrightnessXYZPPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos + 1, zPos);
            }

            if(render.renderMinZ <= 0.0D) {
                ++zPos;
            }

            i1 = l;

            if(render.renderMinZ <= 0.0D || !render.blockAccess.isBlockOpaqueCube(xPos, yPos, zPos - 1)) {
                i1 = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos - 1);
            }

            f7 = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos, zPos - 1);
            f3 = (render.aoLightValueScratchXZNN + render.aoLightValueScratchXYZNPN + f7 + render.aoLightValueScratchYZPN) / 4.0F;
            f4 = (f7 + render.aoLightValueScratchYZPN + render.aoLightValueScratchXZPN + render.aoLightValueScratchXYZPPN) / 4.0F;
            f5 = (render.aoLightValueScratchYZNN + f7 + render.aoLightValueScratchXYZPNN + render.aoLightValueScratchXZPN) / 4.0F;
            f6 = (render.aoLightValueScratchXYZNNN + render.aoLightValueScratchXZNN + render.aoLightValueScratchYZNN + f7) / 4.0F;
            render.brightnessTopLeft = render.getAoBrightness(render.aoBrightnessXZNN, render.aoBrightnessXYZNPN, render.aoBrightnessYZPN, i1);
            render.brightnessBottomLeft = render.getAoBrightness(render.aoBrightnessYZPN, render.aoBrightnessXZPN, render.aoBrightnessXYZPPN, i1);
            render.brightnessBottomRight = render.getAoBrightness(render.aoBrightnessYZNN, render.aoBrightnessXYZPNN, render.aoBrightnessXZPN, i1);
            render.brightnessTopRight = render.getAoBrightness(render.aoBrightnessXYZNNN, render.aoBrightnessXZNN, render.aoBrightnessYZNN, i1);

            if(flag1) {
                render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = colorRed * 0.8F;
                render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = colorGreen * 0.8F;
                render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = colorBlue * 0.8F;
            }
            else {
                render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = 0.8F;
                render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = 0.8F;
                render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = 0.8F;
            }

            render.colorRedTopLeft *= f3;
            render.colorGreenTopLeft *= f3;
            render.colorBlueTopLeft *= f3;
            render.colorRedBottomLeft *= f4;
            render.colorGreenBottomLeft *= f4;
            render.colorBlueBottomLeft *= f4;
            render.colorRedBottomRight *= f5;
            render.colorGreenBottomRight *= f5;
            render.colorBlueBottomRight *= f5;
            render.colorRedTopRight *= f6;
            render.colorGreenTopRight *= f6;
            render.colorBlueTopRight *= f6;
            render.renderFaceZNeg(block, xPos, yPos, zPos, texture);

            flag = true;
        }

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos, yPos, zPos + 1, 3)) {
            if(render.renderMaxZ >= 1.0D) {
                ++zPos;
            }

            render.aoLightValueScratchXZNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos, zPos);
            render.aoLightValueScratchXZPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos, zPos);
            render.aoLightValueScratchYZNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos - 1, zPos);
            render.aoLightValueScratchYZPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos + 1, zPos);
            render.aoBrightnessXZNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos, zPos);
            render.aoBrightnessXZPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos, zPos);
            render.aoBrightnessYZNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos - 1, zPos);
            render.aoBrightnessYZPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos + 1, zPos);
            flag3 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos + 1, yPos, zPos + 1)];
            flag2 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos - 1, yPos, zPos + 1)];
            flag5 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos, yPos + 1, zPos + 1)];
            flag4 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos, yPos - 1, zPos + 1)];

            if(!flag2 && !flag4) {
                render.aoLightValueScratchXYZNNP = render.aoLightValueScratchXZNP;
                render.aoBrightnessXYZNNP = render.aoBrightnessXZNP;
            }
            else {
                render.aoLightValueScratchXYZNNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos - 1, zPos);
                render.aoBrightnessXYZNNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos - 1, zPos);
            }

            if(!flag2 && !flag5) {
                render.aoLightValueScratchXYZNPP = render.aoLightValueScratchXZNP;
                render.aoBrightnessXYZNPP = render.aoBrightnessXZNP;
            }
            else {
                render.aoLightValueScratchXYZNPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos + 1, zPos);
                render.aoBrightnessXYZNPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos + 1, zPos);
            }

            if(!flag3 && !flag4) {
                render.aoLightValueScratchXYZPNP = render.aoLightValueScratchXZPP;
                render.aoBrightnessXYZPNP = render.aoBrightnessXZPP;
            }
            else {
                render.aoLightValueScratchXYZPNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos - 1, zPos);
                render.aoBrightnessXYZPNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos - 1, zPos);
            }

            if(!flag3 && !flag5) {
                render.aoLightValueScratchXYZPPP = render.aoLightValueScratchXZPP;
                render.aoBrightnessXYZPPP = render.aoBrightnessXZPP;
            }
            else {
                render.aoLightValueScratchXYZPPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos + 1, zPos);
                render.aoBrightnessXYZPPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos + 1, zPos);
            }

            if(render.renderMaxZ >= 1.0D) {
                --zPos;
            }

            i1 = l;

            if(render.renderMaxZ >= 1.0D || !render.blockAccess.isBlockOpaqueCube(xPos, yPos, zPos + 1)) {
                i1 = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos + 1);
            }

            f7 = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos, zPos + 1);
            f3 = (render.aoLightValueScratchXZNP + render.aoLightValueScratchXYZNPP + f7 + render.aoLightValueScratchYZPP) / 4.0F;
            f6 = (f7 + render.aoLightValueScratchYZPP + render.aoLightValueScratchXZPP + render.aoLightValueScratchXYZPPP) / 4.0F;
            f5 = (render.aoLightValueScratchYZNP + f7 + render.aoLightValueScratchXYZPNP + render.aoLightValueScratchXZPP) / 4.0F;
            f4 = (render.aoLightValueScratchXYZNNP + render.aoLightValueScratchXZNP + render.aoLightValueScratchYZNP + f7) / 4.0F;
            render.brightnessTopLeft = render.getAoBrightness(render.aoBrightnessXZNP, render.aoBrightnessXYZNPP, render.aoBrightnessYZPP, i1);
            render.brightnessTopRight = render.getAoBrightness(render.aoBrightnessYZPP, render.aoBrightnessXZPP, render.aoBrightnessXYZPPP, i1);
            render.brightnessBottomRight = render.getAoBrightness(render.aoBrightnessYZNP, render.aoBrightnessXYZPNP, render.aoBrightnessXZPP, i1);
            render.brightnessBottomLeft = render.getAoBrightness(render.aoBrightnessXYZNNP, render.aoBrightnessXZNP, render.aoBrightnessYZNP, i1);

            if(flag1) {
                render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = colorRed * 0.8F;
                render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = colorGreen * 0.8F;
                render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = colorBlue * 0.8F;
            }
            else {
                render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = 0.8F;
                render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = 0.8F;
                render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = 0.8F;
            }

            render.colorRedTopLeft *= f3;
            render.colorGreenTopLeft *= f3;
            render.colorBlueTopLeft *= f3;
            render.colorRedBottomLeft *= f4;
            render.colorGreenBottomLeft *= f4;
            render.colorBlueBottomLeft *= f4;
            render.colorRedBottomRight *= f5;
            render.colorGreenBottomRight *= f5;
            render.colorBlueBottomRight *= f5;
            render.colorRedTopRight *= f6;
            render.colorGreenTopRight *= f6;
            render.colorBlueTopRight *= f6;
            render.renderFaceZPos(block, xPos, yPos, zPos, texture);

            flag = true;
        }

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos - 1, yPos, zPos, 4)) {
            if(render.renderMinX <= 0.0D) {
                --xPos;
            }

            render.aoLightValueScratchXYNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos - 1, zPos);
            render.aoLightValueScratchXZNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos, zPos - 1);
            render.aoLightValueScratchXZNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos, zPos + 1);
            render.aoLightValueScratchXYNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos + 1, zPos);
            render.aoBrightnessXYNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos - 1, zPos);
            render.aoBrightnessXZNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos - 1);
            render.aoBrightnessXZNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos + 1);
            render.aoBrightnessXYNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos + 1, zPos);
            flag3 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos - 1, yPos + 1, zPos)];
            flag2 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos - 1, yPos - 1, zPos)];
            flag5 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos - 1, yPos, zPos - 1)];
            flag4 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos - 1, yPos, zPos + 1)];

            if(!flag5 && !flag2) {
                render.aoLightValueScratchXYZNNN = render.aoLightValueScratchXZNN;
                render.aoBrightnessXYZNNN = render.aoBrightnessXZNN;
            }
            else {
                render.aoLightValueScratchXYZNNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos - 1, zPos - 1);
                render.aoBrightnessXYZNNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos - 1, zPos - 1);
            }

            if(!flag4 && !flag2) {
                render.aoLightValueScratchXYZNNP = render.aoLightValueScratchXZNP;
                render.aoBrightnessXYZNNP = render.aoBrightnessXZNP;
            }
            else {
                render.aoLightValueScratchXYZNNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos - 1, zPos + 1);
                render.aoBrightnessXYZNNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos - 1, zPos + 1);
            }

            if(!flag5 && !flag3) {
                render.aoLightValueScratchXYZNPN = render.aoLightValueScratchXZNN;
                render.aoBrightnessXYZNPN = render.aoBrightnessXZNN;
            }
            else {
                render.aoLightValueScratchXYZNPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos + 1, zPos - 1);
                render.aoBrightnessXYZNPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos + 1, zPos - 1);
            }

            if(!flag4 && !flag3) {
                render.aoLightValueScratchXYZNPP = render.aoLightValueScratchXZNP;
                render.aoBrightnessXYZNPP = render.aoBrightnessXZNP;
            }
            else {
                render.aoLightValueScratchXYZNPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos + 1, zPos + 1);
                render.aoBrightnessXYZNPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos + 1, zPos + 1);
            }

            if(render.renderMinX <= 0.0D) {
                ++xPos;
            }

            i1 = l;

            if(render.renderMinX <= 0.0D || !render.blockAccess.isBlockOpaqueCube(xPos - 1, yPos, zPos)) {
                i1 = block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos, zPos);
            }

            f7 = block.getAmbientOcclusionLightValue(render.blockAccess, xPos - 1, yPos, zPos);
            f6 = (render.aoLightValueScratchXYNN + render.aoLightValueScratchXYZNNP + f7 + render.aoLightValueScratchXZNP) / 4.0F;
            f3 = (f7 + render.aoLightValueScratchXZNP + render.aoLightValueScratchXYNP + render.aoLightValueScratchXYZNPP) / 4.0F;
            f4 = (render.aoLightValueScratchXZNN + f7 + render.aoLightValueScratchXYZNPN + render.aoLightValueScratchXYNP) / 4.0F;
            f5 = (render.aoLightValueScratchXYZNNN + render.aoLightValueScratchXYNN + render.aoLightValueScratchXZNN + f7) / 4.0F;
            render.brightnessTopRight = render.getAoBrightness(render.aoBrightnessXYNN, render.aoBrightnessXYZNNP, render.aoBrightnessXZNP, i1);
            render.brightnessTopLeft = render.getAoBrightness(render.aoBrightnessXZNP, render.aoBrightnessXYNP, render.aoBrightnessXYZNPP, i1);
            render.brightnessBottomLeft = render.getAoBrightness(render.aoBrightnessXZNN, render.aoBrightnessXYZNPN, render.aoBrightnessXYNP, i1);
            render.brightnessBottomRight = render.getAoBrightness(render.aoBrightnessXYZNNN, render.aoBrightnessXYNN, render.aoBrightnessXZNN, i1);

            if(flag1) {
                render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = colorRed * 0.6F;
                render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = colorGreen * 0.6F;
                render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = colorBlue * 0.6F;
            }
            else {
                render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = 0.6F;
                render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = 0.6F;
                render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = 0.6F;
            }

            render.colorRedTopLeft *= f3;
            render.colorGreenTopLeft *= f3;
            render.colorBlueTopLeft *= f3;
            render.colorRedBottomLeft *= f4;
            render.colorGreenBottomLeft *= f4;
            render.colorBlueBottomLeft *= f4;
            render.colorRedBottomRight *= f5;
            render.colorGreenBottomRight *= f5;
            render.colorBlueBottomRight *= f5;
            render.colorRedTopRight *= f6;
            render.colorGreenTopRight *= f6;
            render.colorBlueTopRight *= f6;
            render.renderFaceXNeg(block, xPos, yPos, zPos, texture);

            flag = true;
        }

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos + 1, yPos, zPos, 5)) {
            if(render.renderMaxX >= 1.0D) {
                ++xPos;
            }

            render.aoLightValueScratchXYPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos - 1, zPos);
            render.aoLightValueScratchXZPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos, zPos - 1);
            render.aoLightValueScratchXZPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos, zPos + 1);
            render.aoLightValueScratchXYPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos + 1, zPos);
            render.aoBrightnessXYPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos - 1, zPos);
            render.aoBrightnessXZPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos - 1);
            render.aoBrightnessXZPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos + 1);
            render.aoBrightnessXYPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos + 1, zPos);
            flag3 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos + 1, yPos + 1, zPos)];
            flag2 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos + 1, yPos - 1, zPos)];
            flag5 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos + 1, yPos, zPos + 1)];
            flag4 = Block.canBlockGrass[render.blockAccess.getBlockId(xPos + 1, yPos, zPos - 1)];

            if(!flag2 && !flag4) {
                render.aoLightValueScratchXYZPNN = render.aoLightValueScratchXZPN;
                render.aoBrightnessXYZPNN = render.aoBrightnessXZPN;
            }
            else {
                render.aoLightValueScratchXYZPNN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos - 1, zPos - 1);
                render.aoBrightnessXYZPNN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos - 1, zPos - 1);
            }

            if(!flag2 && !flag5) {
                render.aoLightValueScratchXYZPNP = render.aoLightValueScratchXZPP;
                render.aoBrightnessXYZPNP = render.aoBrightnessXZPP;
            }
            else {
                render.aoLightValueScratchXYZPNP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos - 1, zPos + 1);
                render.aoBrightnessXYZPNP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos - 1, zPos + 1);
            }

            if(!flag3 && !flag4) {
                render.aoLightValueScratchXYZPPN = render.aoLightValueScratchXZPN;
                render.aoBrightnessXYZPPN = render.aoBrightnessXZPN;
            }
            else {
                render.aoLightValueScratchXYZPPN = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos + 1, zPos - 1);
                render.aoBrightnessXYZPPN = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos + 1, zPos - 1);
            }

            if(!flag3 && !flag5) {
                render.aoLightValueScratchXYZPPP = render.aoLightValueScratchXZPP;
                render.aoBrightnessXYZPPP = render.aoBrightnessXZPP;
            }
            else {
                render.aoLightValueScratchXYZPPP = block.getAmbientOcclusionLightValue(render.blockAccess, xPos, yPos + 1, zPos + 1);
                render.aoBrightnessXYZPPP = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos + 1, zPos + 1);
            }

            if(render.renderMaxX >= 1.0D) {
                --xPos;
            }

            i1 = l;

            if(render.renderMaxX >= 1.0D || !render.blockAccess.isBlockOpaqueCube(xPos + 1, yPos, zPos)) {
                i1 = block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos, zPos);
            }

            f7 = block.getAmbientOcclusionLightValue(render.blockAccess, xPos + 1, yPos, zPos);
            f3 = (render.aoLightValueScratchXYPN + render.aoLightValueScratchXYZPNP + f7 + render.aoLightValueScratchXZPP) / 4.0F;
            f4 = (render.aoLightValueScratchXYZPNN + render.aoLightValueScratchXYPN + render.aoLightValueScratchXZPN + f7) / 4.0F;
            f5 = (render.aoLightValueScratchXZPN + f7 + render.aoLightValueScratchXYZPPN + render.aoLightValueScratchXYPP) / 4.0F;
            f6 = (f7 + render.aoLightValueScratchXZPP + render.aoLightValueScratchXYPP + render.aoLightValueScratchXYZPPP) / 4.0F;
            render.brightnessTopLeft = render.getAoBrightness(render.aoBrightnessXYPN, render.aoBrightnessXYZPNP, render.aoBrightnessXZPP, i1);
            render.brightnessTopRight = render.getAoBrightness(render.aoBrightnessXZPP, render.aoBrightnessXYPP, render.aoBrightnessXYZPPP, i1);
            render.brightnessBottomRight = render.getAoBrightness(render.aoBrightnessXZPN, render.aoBrightnessXYZPPN, render.aoBrightnessXYPP, i1);
            render.brightnessBottomLeft = render.getAoBrightness(render.aoBrightnessXYZPNN, render.aoBrightnessXYPN, render.aoBrightnessXZPN, i1);

            if(flag1) {
                render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = colorRed * 0.6F;
                render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = colorGreen * 0.6F;
                render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = colorBlue * 0.6F;
            }
            else {
                render.colorRedTopLeft = render.colorRedBottomLeft = render.colorRedBottomRight = render.colorRedTopRight = 0.6F;
                render.colorGreenTopLeft = render.colorGreenBottomLeft = render.colorGreenBottomRight = render.colorGreenTopRight = 0.6F;
                render.colorBlueTopLeft = render.colorBlueBottomLeft = render.colorBlueBottomRight = render.colorBlueTopRight = 0.6F;
            }

            render.colorRedTopLeft *= f3;
            render.colorGreenTopLeft *= f3;
            render.colorBlueTopLeft *= f3;
            render.colorRedBottomLeft *= f4;
            render.colorGreenBottomLeft *= f4;
            render.colorBlueBottomLeft *= f4;
            render.colorRedBottomRight *= f5;
            render.colorGreenBottomRight *= f5;
            render.colorBlueBottomRight *= f5;
            render.colorRedTopRight *= f6;
            render.colorGreenTopRight *= f6;
            render.colorBlueTopRight *= f6;
            render.renderFaceXPos(block, xPos, yPos, zPos, texture);

            flag = true;
        }

        render.enableAO = false;
        return flag;
    }

    public static boolean renderFakeBlockWithColorMultiplier(Icon texture, int xPos, int yPos, int zPos, float colorRed, float colorGreen, float colorBlue, RenderBlocks render, IBlockAccess world) {
        Block block = Block.stone;
        render.enableAO = false;
        Tessellator tessellator = Tessellator.instance;
        boolean flag = false;
        float f3 = 0.5F;
        float f4 = 1.0F;
        float f5 = 0.8F;
        float f6 = 0.6F;
        float f7 = f4 * colorRed;
        float f8 = f4 * colorGreen;
        float f9 = f4 * colorBlue;
        float f10 = f3;
        float f11 = f5;
        float f12 = f6;
        float f13 = f3;
        float f14 = f5;
        float f15 = f6;
        float f16 = f3;
        float f17 = f5;
        float f18 = f6;

        if(block != Block.grass) {
            f10 = f3 * colorRed;
            f11 = f5 * colorRed;
            f12 = f6 * colorRed;
            f13 = f3 * colorGreen;
            f14 = f5 * colorGreen;
            f15 = f6 * colorGreen;
            f16 = f3 * colorBlue;
            f17 = f5 * colorBlue;
            f18 = f6 * colorBlue;
        }

        int l = block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos);

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos, yPos - 1, zPos, 0)) {
            tessellator.setBrightness(render.renderMinY > 0.0D ? l : block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos - 1, zPos));
            tessellator.setColorOpaque_F(f10, f13, f16);
            render.renderFaceYNeg(block, xPos, yPos, zPos, texture);
            flag = true;
        }

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos, yPos + 1, zPos, 1)) {
            tessellator.setBrightness(render.renderMaxY < 1.0D ? l : block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos + 1, zPos));
            tessellator.setColorOpaque_F(f7, f8, f9);
            render.renderFaceYPos(block, xPos, yPos, zPos, texture);
            flag = true;
        }

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos, yPos, zPos - 1, 2)) {
            tessellator.setBrightness(render.renderMinZ > 0.0D ? l : block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos - 1));
            tessellator.setColorOpaque_F(f11, f14, f17);
            render.renderFaceZNeg(block, xPos, yPos, zPos, texture);

            flag = true;
        }

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos, yPos, zPos + 1, 3)) {
            tessellator.setBrightness(render.renderMaxZ < 1.0D ? l : block.getMixedBrightnessForBlock(render.blockAccess, xPos, yPos, zPos + 1));
            tessellator.setColorOpaque_F(f11, f14, f17);
            render.renderFaceZPos(block, xPos, yPos, zPos, texture);

            flag = true;
        }

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos - 1, yPos, zPos, 4)) {
            tessellator.setBrightness(render.renderMinX > 0.0D ? l : block.getMixedBrightnessForBlock(render.blockAccess, xPos - 1, yPos, zPos));
            tessellator.setColorOpaque_F(f12, f15, f18);
            render.renderFaceXNeg(block, xPos, yPos, zPos, texture);

            flag = true;
        }

        if(render.renderAllFaces || block.shouldSideBeRendered(render.blockAccess, xPos + 1, yPos, zPos, 5)) {
            tessellator.setBrightness(render.renderMaxX < 1.0D ? l : block.getMixedBrightnessForBlock(render.blockAccess, xPos + 1, yPos, zPos));
            tessellator.setColorOpaque_F(f12, f15, f18);
            render.renderFaceXPos(block, xPos, yPos, zPos, texture);

            flag = true;
        }

        return flag;
    }
}
