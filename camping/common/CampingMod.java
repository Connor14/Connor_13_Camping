package Connor_13_Camping.camping.common;

import Connor_13_Camping.camping.common.blocks.*;
import Connor_13_Camping.camping.common.items.*;
import Connor_13_Camping.camping.common.tile_entities.*;
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

//File Names
	/* Put Camping, Adventure, or Hunting Prefix based on the part of the mod they belong to. 
	 * CampingBlockLantern or AdventureEntityATV
	 */

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
	/*fix item drops from custom blocks
	 * 
	 * 
	 */

//Bugs
	/*
	 * 
	 */

public class CampingMod 
{
    public static final String modid = "Connor_Camping";
	
	@SidedProxy(clientSide = "Connor_13_Camping.camping.client.ClientProxyConnor_13_Camping", serverSide = "Connor_13_Camping.camping.common.CommonProxyConnor_13_Camping")
	public static CommonProxyConnor_13_Camping proxy;
	
	public static CreativeTabs Camping = new CreativeTabCamping("Camping");

	public static Item TentPlacer;
	public static Block TentBlock;
	
	public static Block lantern;
	public static Item lanternIcon;
	public static Block lanternstand;
	public static Item lanternstandIcon;
	public static Block table;
	public static Item tableIcon;
	public static Block firepit;
	public static Item firepitIcon;
	
	public static Block extratallgrassTop;
	public static Block extratallgrassMiddle;
	public static Block extratallgrassBase;
	public static Item extratallgrassIcon;

	@Init
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		
		LanguageRegistry.instance().addStringLocalization("itemGroup.Camping", "en_US", "Camping");

		TentPlacer = new CampingItemTentPlacer(251).setUnlocalizedName("tentplacer").setCreativeTab(CampingMod.Camping);//add in the rest
		TentBlock = new CampingBlockCabinBlock(252, true).setHardness(3.0F).setResistance(10.0F).setUnlocalizedName("tentblock").setCreativeTab(CampingMod.Camping);//add in the rest
		
		lantern = (new CampingBlockLantern(212, CampingTileEntityLantern.class)).setHardness(.2F).setLightValue(.9F).setUnlocalizedName("lantern");
		lanternIcon = (new CampingItemCustomBlock(213, lantern)).setCreativeTab(CampingMod.Camping).setUnlocalizedName("lanternIcon");
		lanternstand = (new CampingBlockLanternStand(214, CampingTileEntityLanternStand.class)).setHardness(.2F).setUnlocalizedName("lanternstand");
		lanternstandIcon = (new CampingItemCustomBlock(215, lanternstand)).setCreativeTab(CampingMod.Camping).setUnlocalizedName("lanternstandIcon");
		table = (new CampingBlockTable(216, CampingTileEntityTable.class)).setHardness(.2F).setUnlocalizedName("table");
		tableIcon = (new CampingItemCustomBlock(217, table)).setCreativeTab(CampingMod.Camping).setUnlocalizedName("tableIcon");
		firepit = (new CampingBlockFirePit(218, CampingTileEntityFirePit.class)).setHardness(.2F).setUnlocalizedName("firepit");
		firepitIcon = (new CampingItemCustomBlock(219, firepit)).setCreativeTab(CampingMod.Camping).setUnlocalizedName("firepitIcon");

		extratallgrassTop = (new HuntingBlockExtraTallGrass(220)).setCreativeTab(CampingMod.Camping).setUnlocalizedName("extratallgrassTop");
		
		LanguageRegistry.addName(TentPlacer, "Tent Placer");	
		LanguageRegistry.addName(TentBlock, "Tent Block");
		LanguageRegistry.addName(lanternIcon, "Lantern");
		LanguageRegistry.addName(lanternstandIcon, "Lantern Stand");
		LanguageRegistry.addName(tableIcon, "Table");
		LanguageRegistry.addName(firepitIcon, "Firepit");
		LanguageRegistry.addName(extratallgrassTop, "Block");
		
		GameRegistry.registerBlock(TentBlock);
		GameRegistry.registerBlock(lantern);
		GameRegistry.registerBlock(lanternstand);
		GameRegistry.registerBlock(table);
		GameRegistry.registerBlock(firepit);
		GameRegistry.registerBlock(extratallgrassTop);
		GameRegistry.registerTileEntity(CampingTileEntityLantern.class, "TileEntityLantern");
		GameRegistry.registerTileEntity(CampingTileEntityLanternStand.class, "TileEntityLanternStand");
		GameRegistry.registerTileEntity(CampingTileEntityTable.class, "TileEntityTable");
		GameRegistry.registerTileEntity(CampingTileEntityFirePit.class, "TileEntityFirePit");

		
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
		GameRegistry.addRecipe(new ItemStack(lanternstandIcon, 1), new Object[]
		{
			" X ", " X ", " X ", 'X', Block.sand
		});
		GameRegistry.addRecipe(new ItemStack(tableIcon, 1), new Object[]
		{
			" X ", " X ", " X ", 'X', Block.wood
		});
	}
}
