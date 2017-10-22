package lance5057.tDefense.core.materials;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.eventbus.Subscribe;

import gnu.trove.map.hash.THashMap;
import gnu.trove.set.hash.THashSet;
import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.materials.MaterialCloth;
import lance5057.tDefense.core.CoreBase;
import lance5057.tDefense.core.blocks.fluid.VibrantFluid;
import lance5057.tDefense.core.blocks.fluid.VileFluid;
import lance5057.tDefense.core.items.TDOreDictItem;
import lance5057.tDefense.core.materials.traits.TraitAxeLover;
import lance5057.tDefense.core.materials.traits.TraitBarbed;
import lance5057.tDefense.core.materials.traits.TraitDogToy;
import lance5057.tDefense.core.materials.traits.TraitDulling;
import lance5057.tDefense.core.materials.traits.TraitFirestarter;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
//import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.shared.TinkerFluids;
import slimeknights.tconstruct.smeltery.block.BlockMolten;
import slimeknights.tconstruct.tools.TinkerMaterials;

public class TDMaterials {

	// public static final List<Material> materials = Lists.newArrayList();

	String SHIELD = ShieldMaterialStats.TYPE;

	public static final Map<String, Material> materials = new THashMap<>();
	public static final Map<String, MaterialIntegration> materialIntegrations = new THashMap<>();
	public static final Collection<String> deferredMaterials = new THashSet<>();

	// public static final Material aeonsteel = mat("aeonsteel", 0xd200d1);
	// public static final Material queensgold = mat("queensgold", 0xdede00);
	// public static final Material dogbearium = mat("dogbearium", 0x604933);

	public static Material black;
	public static Material red;
	public static Material green;
	public static Material brown;
	public static Material blue;
	public static Material purple;
	public static Material cyan;
	public static Material lightgray;
	public static Material gray;
	public static Material pink;
	public static Material lime;
	public static Material yellow;
	public static Material lightblue;
	public static Material magenta;
	public static Material orange;
	public static Material white;

	public static FluidMolten fluidAeonsteel = new FluidMolten("aeonsteel", 0xa470e0);
	public static FluidMolten fluidQueensGold = new FluidMolten("queensgold", 0xdcff00);
	public static FluidMolten fluidDogbearium = new FluidMolten("dogbearium", 0x6d3300);
	public static FluidMolten fluidRedCandy = new FluidMolten("redcandy", 0xff0000);
	public static FluidMolten fluidGreenCandy = new FluidMolten("greencandy", 0x00ff00);
	public static FluidMolten fluidVile = new FluidMolten("vile", 0x111111);
	public static FluidMolten fluidSinisterium = new FluidMolten("sinisterium", 0x210000);
	//public static FluidMolten fluidNihilite = new FluidMolten("nihilite", 0x000021);
	public static FluidMolten fluidVibrant = new FluidMolten("vibrant", 0x76ff00);
	public static FluidMolten fluidOrichalcum = new FluidMolten("orichalcum", 0xffc700);
	public static FluidMolten fluidPandorium = new FluidMolten("pandorium", 0x7f6a00);
	public static FluidMolten fluidChorusJuice = new FluidMolten("chorusjuice", 0xd982ff);
	public static FluidMolten fluidDragonsBreath = new FluidMolten("dragonsbreath", 0x7f00b7);
	public static FluidMolten fluidRoseGold = new FluidMolten("rosegold", 0xff9b84);
	public static FluidMolten fluidPlatinum = new FluidMolten("platinum", 0xe8e8e8);
	public static FluidMolten fluidBrass = new FluidMolten("brass", 0xdbb332);
	public static FluidMolten fluidSilver = new FluidMolten("silver", 0x9e9e9e);
	public static FluidMolten fluidCheese = new FluidMolten("cheese", 0xffe731);
	// public static FluidMolten fluidGold = new FluidMolten("gold", 0xffe330);

	public static TDOreDictItem ingotAeonsteel = new TDOreDictItem("ingot", "aeonsteel");
	public static TDOreDictItem ingotQueensGold = new TDOreDictItem("ingot", "queensgold");
	public static TDOreDictItem ingotDogbearium = new TDOreDictItem("ingot", "dogbearium");
	public static TDOreDictItem ingotRedCandy = new TDOreDictItem("ingot", "redcandy");
	public static TDOreDictItem ingotGreenCandy = new TDOreDictItem("ingot", "greencandy");
	public static TDOreDictItem ingotSinisterium = new TDOreDictItem("ingot", "sinisterium");
	public static TDOreDictItem ingotNihilite = new TDOreDictItem("ingot", "nihilite");
	public static TDOreDictItem ingotOrichalcum = new TDOreDictItem("ingot", "orichalcum");
	public static TDOreDictItem ingotPandorium = new TDOreDictItem("ingot", "pandorium");
	public static TDOreDictItem ingotRoseGold = new TDOreDictItem("ingot", "rosegold");
	public static TDOreDictItem ingotPlatinum = new TDOreDictItem("ingot", "platinum");
	public static TDOreDictItem ingotBrass = new TDOreDictItem("ingot", "brass");
	public static TDOreDictItem ingotSilver = new TDOreDictItem("ingot", "silver");
	public static TDOreDictItem ingotCheese = new TDOreDictItem("ingot", "cheese");

	public static TDOreDictItem nuggetAeonsteel = new TDOreDictItem("nugget", "aeonsteel");
	public static TDOreDictItem nuggetQueensGold = new TDOreDictItem("nugget", "queensgold");
	public static TDOreDictItem nuggetDogbearium = new TDOreDictItem("nugget", "dogbearium");
	public static TDOreDictItem nuggetRedCandy = new TDOreDictItem("nugget", "redcandy");
	public static TDOreDictItem nuggetGreenCandy = new TDOreDictItem("nugget", "greencandy");
	public static TDOreDictItem nuggetSinisterium = new TDOreDictItem("nugget", "sinisterium");
	public static TDOreDictItem nuggetNihilite = new TDOreDictItem("nugget", "nihilite");
	public static TDOreDictItem nuggetOrichalcum = new TDOreDictItem("nugget", "orichalcum");
	public static TDOreDictItem nuggetPandorium = new TDOreDictItem("nugget", "pandorium");
	public static TDOreDictItem nuggetRoseGold = new TDOreDictItem("nugget", "rosegold");
	public static TDOreDictItem nuggetPlatinum = new TDOreDictItem("nugget", "platinum");
	public static TDOreDictItem nuggetBrass = new TDOreDictItem("nugget", "brass");
	public static TDOreDictItem nuggetSilver = new TDOreDictItem("nugget", "silver");
	public static TDOreDictItem nuggetCheese = new TDOreDictItem("nugget", "cheese");

	public static TDOreDictItem dustAeonsteel = new TDOreDictItem("dust", "aeonsteel");
	public static TDOreDictItem dustQueensGold = new TDOreDictItem("dust", "queensgold");
	public static TDOreDictItem dustDogbearium = new TDOreDictItem("dust", "dogbearium");
	public static TDOreDictItem dustRedCandy = new TDOreDictItem("dust", "redcandy");
	public static TDOreDictItem dustGreenCandy = new TDOreDictItem("dust", "greencandy");
	public static TDOreDictItem dustSinisterium = new TDOreDictItem("dust", "sinisterium");
	public static TDOreDictItem dustNihilite = new TDOreDictItem("dust", "nihilite");
	public static TDOreDictItem dustOrichalcum = new TDOreDictItem("dust", "orichalcum");
	public static TDOreDictItem dustPandorium = new TDOreDictItem("dust", "pandorium");
	public static TDOreDictItem dustRoseGold = new TDOreDictItem("dust", "rosegold");
	public static TDOreDictItem dustPlatinum = new TDOreDictItem("dust", "platinum");
	public static TDOreDictItem dustBrass = new TDOreDictItem("dust", "brass");
	public static TDOreDictItem dustSilver = new TDOreDictItem("dust", "silver");
	public static TDOreDictItem dustCheese = new TDOreDictItem("dust", "cheese");
	public static TDOreDictItem dustGold = new TDOreDictItem("dust", "gold");

	public static Material matAeonsteel = new Material("aeonsteel", 0xa470e0);
	public static Material matQueensGold = new Material("queensgold", 0xdcff00);
	public static Material matDogbearium = new Material("dogbearium", 0x6d3300);
	public static Material matRedCandy = new Material("redcandy", 0xff0000);
	public static Material matGreenCandy = new Material("greencandy", 0x00ff00);
	public static Material matSinisterium = new Material("sinisterium", 0x210000);
	public static Material matNihilite = new Material("nihilite", 0x000021);
	public static Material matVibrant = new Material("vibrant", 0x76ff00);
	public static Material matOrichalcum = new Material("orichalcum", 0xffc700);
	public static Material matPandorium = new Material("pandorium", 0x7f6a00);
	public static Material matRoseGold = new Material("rosegold", 0xff9b84);
	public static Material matPlatinum = new Material("platinum", 0xe8e8e8);
	public static Material matBrass = new Material("brass", 0xdbb332);
	public static Material matSilver = new Material("silver", 0x9e9e9e);
	public static Material matCheese = new Material("cheese", 0xffe731);
	public static Material matGold = new Material("gold", 0xffe330);

	public static final AbstractTrait axelover = new TraitAxeLover();
	public static final AbstractTrait dulling = new TraitDulling();
	public static final AbstractTrait firestarter = new TraitFirestarter();
	public static final AbstractTrait barbed = new TraitBarbed();
	public static final AbstractTrait dogtoy = new TraitDogToy();

	private static Material mat(String name, int color) {
		Material mat = new Material(name, color);
		// materials.add(mat);
		return mat;
	}

	@Subscribe
	public void preInit(FMLPreInitializationEvent event) {
		Material.UNKNOWN.addStats(new ShieldMaterialStats(35, 33));

		// TinkerRegistry.addMaterialStats(Material.UNKNOWN,
		// new ShieldMaterialStats(35, 33));

		// TinkerRegistry.addMaterialStats(Material.UNKNOWN,
		// new ShieldMaterialStats(35, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.wood, new ShieldMaterialStats(35, 33));
		TinkerMaterials.wood.addTrait(axelover, SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.stone, new ShieldMaterialStats(120, 33));
		// TinkerRegistry.addMaterialTrait(TinkerMaterials.stone, dulling,
		// SHIELD);
		TinkerMaterials.stone.addTrait(dulling, SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.flint, new ShieldMaterialStats(150, 33));
		TinkerRegistry.addMaterialTrait(TinkerMaterials.flint, firestarter, SHIELD);

		TinkerRegistry.addMaterialStats(TinkerMaterials.cactus, new ShieldMaterialStats(210, 33));
		TinkerRegistry.addMaterialTrait(TinkerMaterials.cactus, barbed, SHIELD);
		
		TinkerRegistry.addMaterialStats(TinkerMaterials.bone, new ShieldMaterialStats(200, 33));
		TinkerRegistry.addMaterialTrait(TinkerMaterials.bone, dogtoy, SHIELD);
		
		TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian, new ShieldMaterialStats(139, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine, new ShieldMaterialStats(430, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.endstone, new ShieldMaterialStats(420, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.paper, new ShieldMaterialStats(12, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.sponge, new ShieldMaterialStats(550, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.firewood, new ShieldMaterialStats(550, 33));

		// Slime
		TinkerRegistry.addMaterialStats(TinkerMaterials.slime, new ShieldMaterialStats(1000, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime, new ShieldMaterialStats(780, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime, new ShieldMaterialStats(850, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime, new ShieldMaterialStats(600, 33));

		// Nether
		TinkerRegistry.addMaterialStats(TinkerMaterials.netherrack, new ShieldMaterialStats(270, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.cobalt, new ShieldMaterialStats(780, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.ardite, new ShieldMaterialStats(990, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn, new ShieldMaterialStats(820, 33));

		// Metals
		TinkerRegistry.addMaterialStats(TinkerMaterials.iron, new ShieldMaterialStats(204, 33));
		TinkerRegistry.addMaterialStats(TinkerMaterials.pigiron, new ShieldMaterialStats(380, 33));

		// Mod Integration
		TinkerRegistry.addMaterialStats(TinkerMaterials.copper, new ShieldMaterialStats(210, 33));

		TinkerRegistry.addMaterialStats(TinkerMaterials.bronze, new ShieldMaterialStats(430, 33));

		TinkerRegistry.addMaterialStats(TinkerMaterials.lead, new ShieldMaterialStats(334, 33));

		TinkerRegistry.addMaterialStats(TinkerMaterials.silver, new ShieldMaterialStats(250, 33));

		TinkerRegistry.addMaterialStats(TinkerMaterials.electrum, new ShieldMaterialStats(50, 33));

		TinkerRegistry.addMaterialStats(TinkerMaterials.steel, new ShieldMaterialStats(540, 33));
		
		//TinkerRegistry.addMaterialStats(matAeonsteel, new ShieldMaterialStats(540, 33));

		/*registerClothMaterials();
		
		addMat("aeonsteel", fluidAeonsteel, nuggetAeonsteel, ingotAeonsteel, dustAeonsteel);
		addMat("queensgold", fluidQueensGold, nuggetQueensGold, ingotQueensGold, dustQueensGold);
		addMat("dogbearium", fluidDogbearium, nuggetDogbearium, ingotDogbearium, dustDogbearium);
		addMat("redcandy", fluidRedCandy, nuggetRedCandy, ingotRedCandy, dustRedCandy);
		addMat("greencandy", fluidGreenCandy, nuggetGreenCandy, ingotGreenCandy, dustGreenCandy);

		addMat("sinisterium", fluidSinisterium, nuggetSinisterium, ingotSinisterium, dustSinisterium);
		//addMat("nihilite", fluidNihilite, nuggetNihilite, ingotNihilite, dustNihilite);

		addMat("orichalcum", fluidOrichalcum, nuggetOrichalcum, ingotOrichalcum, dustOrichalcum);
		addMat("pandorium", fluidPandorium, nuggetPandorium, ingotPandorium, dustPandorium);

		addMat("rosegold", fluidRoseGold, nuggetRoseGold, ingotRoseGold, dustRoseGold);
		addMat("platinum", fluidPlatinum, nuggetPlatinum, ingotPlatinum, dustPlatinum);
		addMat("brass", fluidBrass, nuggetBrass, ingotBrass, dustBrass);
		addMat("silver", fluidSilver, nuggetSilver, ingotSilver, dustSilver);

		addMat("cheese", fluidCheese, nuggetCheese, ingotCheese, dustCheese);

		addMat("chorusjuice", fluidChorusJuice);
		addMat("dragonsbreath", fluidDragonsBreath);

		FluidRegistry.registerFluid(fluidVibrant);
		FluidRegistry.addBucketForFluid(fluidVibrant);
		addMat("vibrantfluid", fluidVibrant, new VibrantFluid(fluidVibrant));

		FluidRegistry.registerFluid(fluidVile);
		FluidRegistry.addBucketForFluid(fluidVile);
		addMat("vilefluid", fluidVile, new VileFluid(fluidVile));

		registerMaterials();

		//integrate(materials, materialIntegrations, deferredMaterials);*/

	}

	@Subscribe
	public void init(FMLInitializationEvent event) {
		
		// registerMaterials();
		// TinkerRegistry.addMaterialStats(aeonsteel, new
		// HeadMaterialStats(1000, 4.0f, 3.00f, COBALT),
		// new HandleMaterialStats(1.10f, 200), new ExtraMaterialStats(500));
		// iron.addItemIngot("ingotIron");
		// iron.setRepresentativeItem(Items.field_151042_j);
		// iron.addTrait(magnetic2, HEAD);
		// iron.addTrait(magnetic);

		// TinkerMaterials.stone.addTrait(TinkerMaterials.cheapskate,
		// ShieldMaterialStats.TYPE);

		// TAIGA TEST
		Collection<Material> mats = TinkerRegistry.getAllMaterials();
		for (Material i : mats) {
			if (!i.hasStats(SHIELD)) {
				if (i.hasStats(MaterialTypes.HEAD)) {
					int dur = ((HeadMaterialStats) i.getStats(MaterialTypes.HEAD)).durability;
					i.addStats(new ShieldMaterialStats(dur, 33));
				}
			}
		}
	}

	void addMat(String name, FluidMolten fluid) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);

		createFluid(name, fluid);
	}

	void addMat(String name, FluidMolten fluid, Item nugget, Item ingot, Item dust) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);

		createFluid(name, fluid);
		createItems(name, nugget, ingot, dust);
	}

	void addMat(String name, FluidMolten fluid, Block fluidBlock) {

		createFluid(name, fluid, fluidBlock);
	}

	void addMat(String name, FluidMolten fluid, Block fluidBlock, Item nugget, Item ingot, Item dust) {

		createFluid(name, fluid, fluidBlock);
		createItems(name, nugget, ingot, dust);
	}

	void createFluid(String name, FluidMolten fluid) {
		BlockMolten block = new BlockMolten(fluid);
		// Sets names
		block.setUnlocalizedName("molten_" + fluid.getName());
		block.setRegistryName(Reference.MOD_ID, "molten_" + fluid.getName());
		// Registers the fluid in its block form and its corresponding item
		// (block/fluid as item in inventory)
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		// Registers the fluid's model but only on the client side
		TinkersDefense.proxy.registerFluidModels(fluid);
	}

	void createFluid(String name, FluidMolten fluid, Block fluidBlock) {
		fluidBlock.setUnlocalizedName("molten_" + fluid.getName());
		fluidBlock.setRegistryName(Reference.MOD_ID, "molten_" + fluid.getName());
		// Registers the fluid in its block form and its corresponding item
		// (block/fluid as item in inventory)
		GameRegistry.register(fluidBlock);
		GameRegistry.register(new ItemBlock(fluidBlock).setRegistryName(fluidBlock.getRegistryName()));
		// Registers the fluid's model but only on the client side
		TinkersDefense.proxy.registerFluidModels(fluid);
	}

	void createItems(String name, Item nugget, Item ingot, Item dust) {
		//nugget.setCreativeTab(CoreBase.tab);
		//ingot.setCreativeTab(CoreBase.tab);
		//dust.setCreativeTab(CoreBase.tab);

		GameRegistry.register(nugget);
		GameRegistry.register(ingot);
		GameRegistry.register(dust);

		if (nugget instanceof TDOreDictItem)
			OreDictionary.registerOre(((TDOreDictItem) nugget).getOreDictPrefix() + StringUtils.capitalize(name),
					nugget);
		if (ingot instanceof TDOreDictItem)
			OreDictionary.registerOre(((TDOreDictItem) ingot).getOreDictPrefix() + StringUtils.capitalize(name), ingot);
		if (dust instanceof TDOreDictItem)
			OreDictionary.registerOre(((TDOreDictItem) dust).getOreDictPrefix() + StringUtils.capitalize(name), dust);
	}

	void createMaterial(String name, Material mat, Fluid fluid, Item item, HeadMaterialStats headstat,
			HandleMaterialStats handlestat, ExtraMaterialStats extrastat, BowMaterialStats bowstat, boolean craftable,
			boolean castable) {

		mat.setFluid(fluid);
		mat.setCraftable(craftable).setCastable(castable);
		mat.addItem(item, 1, Material.VALUE_Ingot);
		mat.setRepresentativeItem(item);

		TinkerRegistry.addMaterialStats(mat, headstat);
		TinkerRegistry.addMaterialStats(mat, handlestat);
		TinkerRegistry.addMaterialStats(mat, extrastat);
		TinkerRegistry.addMaterialStats(mat, bowstat);
		TinkerRegistry.addMaterialStats(mat, new ShieldMaterialStats(0, 0));

		materials.put(name, mat);

		// MaterialIntegration integration = new MaterialIntegration(mat, fluid,
		// name);
		// integration.integrate();
	}

	private void registerClothMaterials() {
		black = new Material("blackCloth", 0x191616);
		red = new Material("redCloth", 0x963430);
		green = new Material("greeCloth", 0x35461B);
		brown = new Material("brownCloth", 0x4F321F);
		blue = new Material("blueCloth", 0x2E388D);
		purple = new Material("purpleCloth", 0x7E3DB5);
		cyan = new Material("cyanCloth", 0x2E6E89);
		lightgray = new Material("lightgrayCloth", 0x9AA1A1);
		gray = new Material("grayCloth", 0x404040);
		pink = new Material("pinkCloth", 0xD08499);
		lime = new Material("limeCloth", 0x41AE38);
		yellow = new Material("yellowCloth", 0xB1A627);
		lightblue = new Material("lightblueCloth", 0x6B8AC9);
		magenta = new Material("magentaCloth", 0xB350BC);
		orange = new Material("orangeCloth", 0xDB7D3E);
		white = new Material("whiteCloth", 0xDDDDDD);

		Material.UNKNOWN.addStats(new MaterialCloth(100));
		black.addItem(new ItemStack(Blocks.WOOL, 15), 1, Material.VALUE_Ingot);
		red.addItem(new ItemStack(Blocks.WOOL, 14), 1, Material.VALUE_Ingot);
		green.addItem(new ItemStack(Blocks.WOOL, 13), 1, Material.VALUE_Ingot);
		brown.addItem(new ItemStack(Blocks.WOOL, 12), 1, Material.VALUE_Ingot);
		blue.addItem(new ItemStack(Blocks.WOOL, 11), 1, Material.VALUE_Ingot);
		purple.addItem(new ItemStack(Blocks.WOOL, 10), 1, Material.VALUE_Ingot);
		cyan.addItem(new ItemStack(Blocks.WOOL, 9), 1, Material.VALUE_Ingot);
		lightgray.addItem(new ItemStack(Blocks.WOOL, 8), 1, Material.VALUE_Ingot);
		gray.addItem(new ItemStack(Blocks.WOOL, 7), 1, Material.VALUE_Ingot);
		pink.addItem(new ItemStack(Blocks.WOOL, 6), 1, Material.VALUE_Ingot);
		lime.addItem(new ItemStack(Blocks.WOOL, 5), 1, Material.VALUE_Ingot);
		yellow.addItem(new ItemStack(Blocks.WOOL, 4), 1, Material.VALUE_Ingot);
		lightblue.addItem(new ItemStack(Blocks.WOOL, 3), 1, Material.VALUE_Ingot);
		magenta.addItem(new ItemStack(Blocks.WOOL, 2), 1, Material.VALUE_Ingot);
		orange.addItem(new ItemStack(Blocks.WOOL, 1), 1, Material.VALUE_Ingot);
		white.addItem(new ItemStack(Blocks.WOOL, 0), 1, Material.VALUE_Ingot);

		black.setRepresentativeItem(new ItemStack(Blocks.WOOL, 15));
		red.setRepresentativeItem(new ItemStack(Blocks.WOOL, 14));
		green.setRepresentativeItem(new ItemStack(Blocks.WOOL, 13));
		brown.setRepresentativeItem(new ItemStack(Blocks.WOOL, 12));
		blue.setRepresentativeItem(new ItemStack(Blocks.WOOL, 11));
		purple.setRepresentativeItem(new ItemStack(Blocks.WOOL, 10));
		cyan.setRepresentativeItem(new ItemStack(Blocks.WOOL, 9));
		lightgray.setRepresentativeItem(new ItemStack(Blocks.WOOL, 8));
		gray.setRepresentativeItem(new ItemStack(Blocks.WOOL, 7));
		pink.setRepresentativeItem(new ItemStack(Blocks.WOOL, 6));
		lime.setRepresentativeItem(new ItemStack(Blocks.WOOL, 5));
		yellow.setRepresentativeItem(new ItemStack(Blocks.WOOL, 4));
		lightblue.setRepresentativeItem(new ItemStack(Blocks.WOOL, 3));
		magenta.setRepresentativeItem(new ItemStack(Blocks.WOOL, 2));
		orange.setRepresentativeItem(new ItemStack(Blocks.WOOL, 1));
		white.setRepresentativeItem(new ItemStack(Blocks.WOOL, 0));

		TinkerRegistry.addMaterial(black);
		TinkerRegistry.addMaterial(red);
		TinkerRegistry.addMaterial(green);
		TinkerRegistry.addMaterial(brown);
		TinkerRegistry.addMaterial(blue);
		TinkerRegistry.addMaterial(purple);
		TinkerRegistry.addMaterial(cyan);
		TinkerRegistry.addMaterial(lightgray);
		TinkerRegistry.addMaterial(gray);
		TinkerRegistry.addMaterial(pink);
		TinkerRegistry.addMaterial(lime);
		TinkerRegistry.addMaterial(yellow);
		TinkerRegistry.addMaterial(lightblue);
		TinkerRegistry.addMaterial(magenta);
		TinkerRegistry.addMaterial(orange);
		TinkerRegistry.addMaterial(white);

		TinkerRegistry.addMaterialStats(black, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(red, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(green, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(brown, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(blue, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(purple, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(cyan, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(lightgray, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(gray, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(pink, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(lime, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(yellow, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(lightblue, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(magenta, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(orange, new MaterialCloth(100));
		TinkerRegistry.addMaterialStats(white, new MaterialCloth(100));
	}

	private void registerMaterials() {
		createMaterial("aeonsteel", matAeonsteel, fluidAeonsteel, ingotAeonsteel,
				new HeadMaterialStats(0, 0, 0, HarvestLevels.COBALT), new HandleMaterialStats(0, 0),
				new ExtraMaterialStats(0), new BowMaterialStats(0, 0, 0), false, true);
		createMaterial("queensgold", matQueensGold, fluidQueensGold, ingotQueensGold,
				new HeadMaterialStats(0, 0, 0, HarvestLevels.COBALT), new HandleMaterialStats(0, 0),
				new ExtraMaterialStats(0), new BowMaterialStats(0, 0, 0), false, true);
		createMaterial("dogbearium", matDogbearium, fluidDogbearium, ingotDogbearium,
				new HeadMaterialStats(0, 0, 0, HarvestLevels.COBALT), new HandleMaterialStats(0, 0),
				new ExtraMaterialStats(0), new BowMaterialStats(0, 0, 0), false, true);
		createMaterial("redcandy", matRedCandy, fluidRedCandy, ingotRedCandy,
				new HeadMaterialStats(0, 0, 0, HarvestLevels.COBALT), new HandleMaterialStats(0, 0),
				new ExtraMaterialStats(0), new BowMaterialStats(0, 0, 0), false, true);
		createMaterial("greencandy", matGreenCandy, fluidGreenCandy, ingotGreenCandy,
				new HeadMaterialStats(0, 0, 0, HarvestLevels.COBALT), new HandleMaterialStats(0, 0),
				new ExtraMaterialStats(0), new BowMaterialStats(0, 0, 0), false, true);

		createMaterial("sinisterium", matSinisterium, fluidSinisterium, ingotSinisterium,
				new HeadMaterialStats(0, 0, 0, HarvestLevels.COBALT), new HandleMaterialStats(0, 0),
				new ExtraMaterialStats(0), new BowMaterialStats(0, 0, 0), false, true);
//		createMaterial("nihilite", matNihilite, fluidNihilite, ingotNihilite,
//				new HeadMaterialStats(0, 0, 0, HarvestLevels.COBALT), new HandleMaterialStats(0, 0),
//				new ExtraMaterialStats(0), new BowMaterialStats(0, 0, 0), false, true);
		createMaterial("orichalcum", matOrichalcum, fluidOrichalcum, ingotOrichalcum,
				new HeadMaterialStats(0, 0, 0, HarvestLevels.COBALT), new HandleMaterialStats(0, 0),
				new ExtraMaterialStats(0), new BowMaterialStats(0, 0, 0), false, true);
		createMaterial("pandorium", matPandorium, fluidPandorium, ingotPandorium,
				new HeadMaterialStats(0, 0, 0, HarvestLevels.COBALT), new HandleMaterialStats(0, 0),
				new ExtraMaterialStats(0), new BowMaterialStats(0, 0, 0), false, true);

		createMaterial("rosegold", matRoseGold, fluidRoseGold, ingotRoseGold,
				new HeadMaterialStats(0, 0, 0, HarvestLevels.COBALT), new HandleMaterialStats(0, 0),
				new ExtraMaterialStats(0), new BowMaterialStats(0, 0, 0), false, true);
		createMaterial("platinum", matPlatinum, fluidPlatinum, ingotPlatinum,
				new HeadMaterialStats(0, 0, 0, HarvestLevels.COBALT), new HandleMaterialStats(0, 0),
				new ExtraMaterialStats(0), new BowMaterialStats(0, 0, 0), false, true);
		createMaterial("brass", matBrass, fluidBrass, ingotBrass, new HeadMaterialStats(0, 0, 0, HarvestLevels.COBALT),
				new HandleMaterialStats(0, 0), new ExtraMaterialStats(0), new BowMaterialStats(0, 0, 0), false, true);
		createMaterial("cheese", matCheese, fluidCheese, ingotCheese,
				new HeadMaterialStats(0, 0, 0, HarvestLevels.COBALT), new HandleMaterialStats(0, 0),
				new ExtraMaterialStats(0), new BowMaterialStats(0, 0, 0), false, true);
		createMaterial("gold", matGold, TinkerFluids.gold, Items.GOLD_INGOT,
				new HeadMaterialStats(0, 0, 0, HarvestLevels.COBALT), new HandleMaterialStats(0, 0),
				new ExtraMaterialStats(0), new BowMaterialStats(0, 0, 0), false, true);
	}

	//PlusTIC to the rescue
	public static void integrate(Map<String, Material> materials,
			Map<String, MaterialIntegration> materialIntegrations, Collection<String> excludedMaterials) {
		materials.forEach((k, v) -> {
			if (!materialIntegrations.containsKey(k) && !excludedMaterials.contains(k)) {
				MaterialIntegration mi;
				if (v.getFluid() != null && v.getFluid() != TinkerFluids.emerald) {
					mi = new MaterialIntegration(v, v.getFluid(), StringUtils.capitalize(k)).toolforge();
				} else {
					mi = new MaterialIntegration(v);
				}
				mi.integrate();
				mi.integrateRecipes();
				materialIntegrations.put(k, mi);
			}
		});

		// Utils.displace(TinkerMaterials.wood.getIdentifier()); // so that
		// natura
		// woods are
		// prioritized
	}
}
