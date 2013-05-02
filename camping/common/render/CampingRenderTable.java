package Connor_13_Camping.camping.common.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import Connor_13_Camping.camping.common.models.CampingModelTable;
import Connor_13_Camping.camping.common.tile_entities.CampingTileEntityTable;

public class CampingRenderTable extends TileEntitySpecialRenderer
{

    public CampingRenderTable()
    {
        aModel = new CampingModelTable();
    }
 	
    public void renderAModelAt(CampingTileEntityTable tileentity1, double d, double d1, double d2, float f)
    {   
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.52F, (float)d2 + 0.5F);
        GL11.glRotatef(180F, 0F, 0F, 1F);
        bindTextureByName("/mods/Connor_Camping/textures/blocks/block.table.png");
        GL11.glPushMatrix();
        aModel.renderModel(0.0625F);
        GL11.glPopMatrix();     
        GL11.glPopMatrix();                     
    }

    public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, 
            float f)
    {
        renderAModelAt((CampingTileEntityTable)tileentity, d, d1, d2, f);
    }

    private CampingModelTable aModel;
}
