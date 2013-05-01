package Connor_13_Camping.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import Connor_13_Camping.common.CampingRenderLantern;
import Connor_13_Camping.common.CampingTileEntityLantern;
import Connor_13_Camping.common.CommonProxyConnor_13_Camping;

public class ClientProxyConnor_13_Camping extends CommonProxyConnor_13_Camping
{
	@Override
	public void registerRenderThings()
	{
		MinecraftForgeClient.preloadTexture("");
    	ClientRegistry.bindTileEntitySpecialRenderer(CampingTileEntityLantern.class, new CampingRenderLantern());
	}
}
