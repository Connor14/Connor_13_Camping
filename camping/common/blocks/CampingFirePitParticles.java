package Connor_13_Camping.camping.common.blocks;

import java.util.Random;

import net.minecraft.world.World;

public class CampingFirePitParticles 
{
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        double d0 = (double)((float)par2 + 0.5F);
        double d1 = (double)((float)par3 + 0.7F);
        double d2 = (double)((float)par4 + 0.5F);
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;
       
        par1World.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
        par1World.spawnParticle("flame", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
    }
}
