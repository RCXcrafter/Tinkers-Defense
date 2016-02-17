package lance5057.tDefense;

import java.util.Vector;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class TD_Config
{
	public int AeonsteelMatID;	
	public int QueensGoldMatID;	
	public int DogbeariumMatID;
	public int RedMintMatID;
	public int GreenMintMatID;
	
	public int DazeID;
	public int CrestFeathersID;
	public int CrestMirrorsID;
	public int CrestLegendsID;
	public int CrestBladesID;
	
	public int ArmorProtectionID;
	
	public int MaterialIndex;
	
	public boolean BotaniaAddon;
	public int CorpseIvyModID;
	
	public TD_Config(FMLPreInitializationEvent e)
	{
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		
		config.load();
		
		MaterialIndex = config.get("Material Index", "Highest material ID - TDefense - 206 MFR - 1001 ExtraTIC - 1024", 206).getInt();
		
		AeonsteelMatID = config.get("Material Configs", "Aeonsteel Material ID", 201).getInt();
		QueensGoldMatID = config.get("Material Configs", "QueensGold Material ID", 202).getInt();
		DogbeariumMatID = config.get("Material Configs", "Dogbearium Material ID", 203).getInt();
		RedMintMatID = config.get("Material Configs", "RedMint Material ID", 204).getInt();
		GreenMintMatID = config.get("Material Configs", "GreenMint Material ID", 205).getInt();

		DazeID = config.get("Modifier Configs", "Daze ID", 18).getInt();
		CrestFeathersID = config.get("Modifier Configs", "Crest of Feathers ID", 19).getInt();
		CrestMirrorsID = config.get("Modifier Configs", "Crest of Mirrors ID", 20).getInt();
		CrestLegendsID = config.get("Modifier Configs", "Crest of Legends ID", 21).getInt();
		CrestLegendsID = config.get("Modifier Configs", "Crest of Legends ID", 22).getInt();
		
		ArmorProtectionID = config.getInt("Protection ID", "Armor Modifier Configs", 40, 0, Integer.MAX_VALUE, "");
		
		BotaniaAddon = config.getBoolean("Enable Botania Addon", "Botania Addon", true, "Still requires Botania to use");
		CorpseIvyModID = config.getInt("Corpse Drinker Ivy Modifier ID", "Botania Addon", 60, 0, Integer.MAX_VALUE, "");
		
		config.save();
	}
}