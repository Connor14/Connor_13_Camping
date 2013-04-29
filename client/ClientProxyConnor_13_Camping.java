package Connor_13_Camping.client;

import net.minecraftforge.client.MinecraftForgeClient;
import Connor_13_Camping.common.CommonProxyConnor_13_Camping;

public class ClientProxyConnor_13_Camping extends CommonProxyConnor_13_Camping
{
	@Override
	public void registerRenderThings()
	{
		MinecraftForgeClient.preloadTexture("");
	}
}
