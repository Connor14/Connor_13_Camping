package Connor_13_Camping.camping.common.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import Connor_13_Camping.camping.common.CampingMod;
import Connor_13_Camping.camping.common.tile_entities.CampingTileEntityFirePit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CampingBlockFirePit extends BlockContainer
{
	private Class TestEntityClass;

	public CampingBlockFirePit(int i,Class tClass)
	{
	  super(i,Material.rock);
	  TestEntityClass = tClass;
      float f = 0F;
      setBlockBounds(0F, 0F, 0F, 1F, .25F, 1F);
      this.setTickRandomly(true);
	}
    
    private boolean isActive1 = false;
    
    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	int metadata = par1World.getBlockMetadata(par2, par3, par4);
    	boolean isActive = (metadata & 1) == 1;
    	if(par5EntityPlayer.getCurrentEquippedItem() != null)
        {
        	if(isActive && par5EntityPlayer.getCurrentEquippedItem().itemID == Item.bucketWater.itemID)
        	{
                par1World.setBlock(par2, par3, par4, this.blockID, metadata + 1, 3);
        		return true;
        	}
        	else if (!isActive && par5EntityPlayer.getCurrentEquippedItem().itemID == Item.flintAndSteel.itemID)
        	{
                par1World.setBlock(par2, par3, par4, this.blockID, metadata + 1, 3);
        		return true;
        	}
        }
        
        return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getLightValue(IBlockAccess world, int x, int y, int z)
    {
    	return (world.getBlockMetadata(x, y, z) & 1) == 1 ? 13 : 0;    	
    }
    
    @SideOnly(Side.CLIENT)
    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {    	
    	int metadata = par1World.getBlockMetadata(par2, par3, par4);
    	boolean isActive = (metadata & 1) == 1;
        if (isActive)
        {
            double d0 = (double)((float)par2 + 0.53125F);
            double d1 = (double)((float)par3 + 0.25F);
            double d2 = (double)((float)par4 + 0.53125F);
            
            //Smoke and flame for EXACT center (0.53125)
            par1World.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
            
            //Offset Z (0.265625)
            //(-)
            par1World.spawnParticle("smoke", d0, d1, d2 - 0.265625, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", d0, d1, d2 - 0.265625, 0.0D, 0.0D, 0.0D);
            //(+)
            par1World.spawnParticle("smoke", d0, d1, d2 + 0.265625, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", d0, d1, d2 + 0.265625, 0.0D, 0.0D, 0.0D);
            
            //Offset X (0.265625)
            //(-)
            par1World.spawnParticle("smoke", d0 - 0.265625, d1, d2, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", d0 - 0.265625, d1, d2, 0.0D, 0.0D, 0.0D);
            //(+)
            par1World.spawnParticle("smoke", d0 + 0.265625, d1, d2, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", d0 + 0.265625, d1, d2, 0.0D, 0.0D, 0.0D);
            
            //Increase Y
            par1World.spawnParticle("smoke", d0, d1 + 0.25, d2, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", d0, d1 + 0.25, d2, 0.0D, 0.0D, 0.0D);
            
            par1World.spawnParticle("smoke", d0, d1 + 0.5, d2, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", d0, d1 + 0.5, d2, 0.0D, 0.0D, 0.0D);
        }
    }

    public int idDropped(int i, Random random, int j)
    {
        return CampingMod.firepitIcon.itemID;
    }
    
    public int quanityDropped(Random random)
    {
    	  return 1;
    }
    
    public int getRenderType()
    {
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

	@Override
	public TileEntity createNewTileEntity(World world) 
	{
		return new CampingTileEntityFirePit();
	}

}

