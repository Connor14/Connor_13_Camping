package Connor_13_Camping.camping.common.blocks;

import java.util.Random;

import Connor_13_Camping.camping.common.CampingMod;
import Connor_13_Camping.camping.common.tile_entities.CampingTileEntityTable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CampingBlockTable extends BlockContainer
{
	private Class TestEntityClass;

	public CampingBlockTable(int i,Class tClass)
		{
		  super(i,Material.rock);
		  TestEntityClass = tClass;
	      float f = 0F;
	      setBlockBounds(0F, 0.0F, 0F, 1F, 1F, 1F);
		}
   
    public TileEntity getBlockEntity()
    {
            try{
                    return (TileEntity)TestEntityClass.newInstance();
            }
            catch(Exception exception){
                    throw new RuntimeException(exception);
            }
    }
    
    public int idDropped(int i, Random random, int j)
    {
        return CampingMod.lanternIcon.itemID;
    }
    
    public int quanityDropped(Random random)
    {
    	  return 1;
    }
    
    public int getRenderType(){
		return -1;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }

	public TileEntity createNewTileEntity(World world) 
	{
		return new CampingTileEntityTable();
	}

}
