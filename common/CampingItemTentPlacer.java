package Connor_13_Camping.common;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class CampingItemTentPlacer extends Item
{

    public CampingItemTentPlacer(int par1)
    {
        super(par1);
    }
    
    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par3World.isRemote)
        {
            return true;
        }
        else if (par7 != 1)
        {
            return false;
        }
        else
        {
            ++par5;

            int rotation = MathHelper.floor_double((double)(par2EntityPlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

            //When z increases (E)
            if (rotation == 0)
            {
                par3World.setBlock(par4, par5, par6, Block.cobblestone.blockID, rotation, 3);
                
            }

            //When x decreases (S)
            if (rotation == 1)
            {
                par3World.setBlock(par4, par5, par6, Block.netherrack.blockID, rotation, 3);

            }
            //When z decreases (W)
            if (rotation == 2)
            {
                par3World.setBlock(par4, par5, par6, Block.dirt.blockID, rotation, 3);

            }

            //When x increases (N)
            if (rotation == 3)
            {
                par3World.setBlock(par4, par5, par6, Block.gravel.blockID, rotation, 3);

            }

            else
            {
                return false;
            }
            
            return true;
        }
    }
}