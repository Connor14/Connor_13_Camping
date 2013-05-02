package Connor_13_Camping.common;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@Mod(modid = CampingMod.modid, name = "Camping", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

//Seprate Mod
	//Cooking Mod
		//Peppers
		//Spices
		//New Food
		//Drinks

//Textures
	/*textures go here: minecraft.jar - /mods/Connor_Camping/textures/blocks or /items
	*all textures must be named block.unlocalizedName.png
	*all files must have this:
	*/
		/**
		@SideOnly(Side.CLIENT)
		public void updateIcons(IconRegister par1IconRegister)
		{
			this.iconIndex or this.blockIcon = par1IconRegister.registerIcon(CampingMod.modid + ":" + this.getUnlocalizedName());
		}
		*/

//To do list
	/*try making 1 file for all custom block TileEntities
	 * 
	 * 
	 */

public class CampingMod 
{
    public static final String modid = "Connor_Camping";
	
	@SidedProxy(clientSide = "Connor_13_Camping.client.ClientProxyConnor_13_Camping", serverSide = "Connor_13_Camping.common.CommonProxyConnor_13_Camping")
	public static CommonProxyConnor_13_Camping proxy;
	
	public static CreativeTabs Camping = new CreativeTabCamping("Camping");

	public static Item TentPlacer;
	public static Block TentBlock;
	
	public static Block lantern;
	public static Item lanternIcon;

	@Init
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		
		LanguageRegistry.instance().addStringLocalization("itemGroup.Camping", "en_US", "Camping");

		TentPlacer = new CampingItemTentPlacer(251).setUnlocalizedName("tentplacer").setCreativeTab(CampingMod.Camping);//add in the rest
		TentBlock = new CampingBlockCabinBlock(252, true).setHardness(3.0F).setResistance(10.0F).setUnlocalizedName("tentblock").setCreativeTab(CampingMod.Camping);//add in the rest
		
		lantern = (new CampingBlockLantern(212, CampingTileEntityLantern.class)).setHardness(.2F).setLightValue(.9F).setUnlocalizedName("lantern");
		lanternIcon = (new CampingItemLantern(213, lantern)).setUnlocalizedName("lanternIcon").setCreativeTab(CampingMod.Camping);
		
		LanguageRegistry.addName(TentPlacer, "Tent Placer");	
		LanguageRegistry.addName(TentBlock, "Tent Block");
		LanguageRegistry.addName(lanternIcon, "Lantern");
		
		GameRegistry.registerBlock(TentBlock);
		GameRegistry.registerBlock(lantern);
		GameRegistry.registerTileEntity(CampingTileEntityLantern.class, "TileEntityLantern");

		GameRegistry.addRecipe(new ItemStack(TentPlacer, 1), new Object[]
		{
			" X ", " X ", " X ", 'X', Block.pumpkin
		});
		
		GameRegistry.addRecipe(new ItemStack(TentBlock, 1), new Object[]
		{
			" X ", " X ", " X ", 'X', Block.dirt
		});
		GameRegistry.addRecipe(new ItemStack(lanternIcon, 1), new Object[]
		{
			" X ", " X ", " X ", 'X', Block.gravel
		});
	}
}
