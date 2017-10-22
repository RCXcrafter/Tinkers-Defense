package lance5057.tDefense.proxy;

import java.util.Map;

import javax.annotation.Nonnull;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TD_Commands;
import lance5057.tDefense.core.CoreClientProxy;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.renderers.BaubleRenderer;
import lance5057.tDefense.core.renderers.SheatheModel;
import lance5057.tDefense.core.tools.TDTools;
import lance5057.tDefense.holiday.HolidayClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import slimeknights.tconstruct.common.ModelRegisterUtil;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.TinkerRegistryClient;
import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;

//import lance5057.tDefense.core.renderer.TestSkinChanger;

public class ClientProxy extends CommonProxy {
	// static final ToolModelLoader toolmodel = new ToolModelLoader();
	// public static final ModelSheath sheath = new ModelSheath();
	// ModifierSoulHandler SoulHandler;

	// public static ModelTinkersTabard sheath;

	ToolBuildGuiInfo roundshieldGUI;
	ToolBuildGuiInfo heatershieldGUI;

	ToolBuildGuiInfo zweihanderGUI;
	ToolBuildGuiInfo shearsGUI;
	/*ToolBuildGuiInfo fishingRodGUI;

	ToolBuildGuiInfo hoodGUI;
	ToolBuildGuiInfo shawlGUI;
	ToolBuildGuiInfo robeGUI;
	ToolBuildGuiInfo shoesGUI;

	ToolBuildGuiInfo coifGUI;
	ToolBuildGuiInfo hauberkGUI;
	ToolBuildGuiInfo chaussesGUI;
	ToolBuildGuiInfo bootsGUI;

	ToolBuildGuiInfo helmGUI;
	ToolBuildGuiInfo breastplateGUI;
	ToolBuildGuiInfo grievesGUI;
	ToolBuildGuiInfo sabatonsGUI;

	ToolBuildGuiInfo sheatheGUI;
	ToolBuildGuiInfo ringGUI;
	ToolBuildGuiInfo amuletGUI;*/

	public static SheatheModel sheathe;

	public static CoreClientProxy coreProxy = new CoreClientProxy();
	public static HolidayClientProxy holiProxy = new HolidayClientProxy();
	// public static ArmorClientProxy armorProxy = new ArmorClientProxy();

	@Override
	public void preInit() {
		ClientCommandHandler.instance.registerCommand(new TD_Commands());
		registerToolRenderers();
		registerPartModels();

		coreProxy.preInit();
	}

	@Override
	public void init() {
		Map<String, RenderPlayer> skinMap = Minecraft.getMinecraft().getRenderManager().getSkinMap();
		RenderPlayer render;
		render = skinMap.get("default");
		render.addLayer(new BaubleRenderer());

		render = skinMap.get("slim");
		render.addLayer(new BaubleRenderer());

		createToolGuis();
		setToolGuis();
		registerToolGuis();
		createToolModels();

		coreProxy.init();
		// armorProxy.init();
		holiProxy.Init();
	}

	public void registerToolRenderers() {
		ModelRegisterUtil.registerToolModel(TDTools.roundshield);
		ModelRegisterUtil.registerToolModel(TDTools.heatershield);
		ModelRegisterUtil.registerToolModel(TDTools.zweihander);
		ModelRegisterUtil.registerToolModel(TDTools.shears);
		/*ModelRegisterUtil.registerToolModel(TDTools.fishingRod);

		ModelRegisterUtil.registerToolModel(TDTools.hood);
		ModelRegisterUtil.registerToolModel(TDTools.shawl);
		ModelRegisterUtil.registerToolModel(TDTools.robe);
		ModelRegisterUtil.registerToolModel(TDTools.shoes);

		ModelRegisterUtil.registerToolModel(TDTools.sheathe);
		ModelRegisterUtil.registerToolModel(TDTools.ring);
		ModelRegisterUtil.registerToolModel(TDTools.amulet);*/
	}

	public void createToolGuis() {
		roundshieldGUI = new ToolBuildGuiInfo(TDTools.roundshield);
		heatershieldGUI = new ToolBuildGuiInfo(TDTools.heatershield);
		zweihanderGUI = new ToolBuildGuiInfo(TDTools.zweihander);
		shearsGUI = new ToolBuildGuiInfo(TDTools.shears);
		/*fishingRodGUI = new ToolBuildGuiInfo(TDTools.fishingRod);

		hoodGUI = new ToolBuildGuiInfo(TDTools.hood);
		shawlGUI = new ToolBuildGuiInfo(TDTools.shawl);
		robeGUI = new ToolBuildGuiInfo(TDTools.robe);
		shoesGUI = new ToolBuildGuiInfo(TDTools.shoes);

		sheatheGUI = new ToolBuildGuiInfo(TDTools.sheathe);
		ringGUI = new ToolBuildGuiInfo(TDTools.ring);
		amuletGUI = new ToolBuildGuiInfo(TDTools.amulet);*/

	}

	public void setupToolGuis() {
		roundshieldGUI.addSlotPosition(34, 15 + 8);
		roundshieldGUI.addSlotPosition(34, 33 + 8);
		roundshieldGUI.addSlotPosition(34, 51 + 8);

		heatershieldGUI.addSlotPosition(34, 15 + 8);
		heatershieldGUI.addSlotPosition(25, 33 + 8);
		heatershieldGUI.addSlotPosition(43, 33 + 8);
		heatershieldGUI.addSlotPosition(34, 51 + 8);

		zweihanderGUI.addSlotPosition(34, 15 + 8);
		zweihanderGUI.addSlotPosition(25, 33 + 8);
		zweihanderGUI.addSlotPosition(43, 33 + 8);
		zweihanderGUI.addSlotPosition(34, 51 + 8);

		/*hoodGUI.addSlotPosition(34, 15 + 8);
		hoodGUI.addSlotPosition(43, 33 + 8);
		hoodGUI.addSlotPosition(34, 51 + 8);

		shawlGUI.addSlotPosition(34, 15 + 8);
		shawlGUI.addSlotPosition(43, 33 + 8);
		shawlGUI.addSlotPosition(34, 51 + 8);

		robeGUI.addSlotPosition(34, 15 + 8);
		robeGUI.addSlotPosition(43, 33 + 8);
		robeGUI.addSlotPosition(34, 51 + 8);

		shoesGUI.addSlotPosition(34, 15 + 8);
		shoesGUI.addSlotPosition(43, 33 + 8);
		shoesGUI.addSlotPosition(34, 51 + 8);*/

		shearsGUI.addSlotPosition(34, 15 + 8);
		shearsGUI.addSlotPosition(43, 33 + 8);
		shearsGUI.addSlotPosition(34, 51 + 8);

		/*ringGUI.addSlotPosition(34, 15 + 8);
		ringGUI.addSlotPosition(43, 33 + 8);
		ringGUI.addSlotPosition(34, 51 + 8);*/
	}

	public void registerToolGuis() {
		TinkerRegistryClient.addToolBuilding(roundshieldGUI);
		TinkerRegistryClient.addToolBuilding(heatershieldGUI);
		TinkerRegistryClient.addToolBuilding(zweihanderGUI);
		TinkerRegistryClient.addToolBuilding(shearsGUI);
		/*TinkerRegistryClient.addToolBuilding(fishingRodGUI);

		TinkerRegistryClient.addToolBuilding(hoodGUI);
		TinkerRegistryClient.addToolBuilding(shawlGUI);
		TinkerRegistryClient.addToolBuilding(robeGUI);
		TinkerRegistryClient.addToolBuilding(shoesGUI);

		TinkerRegistryClient.addToolBuilding(sheatheGUI);
		TinkerRegistryClient.addToolBuilding(ringGUI);
		TinkerRegistryClient.addToolBuilding(amuletGUI);*/
	}

	public void registerPartModels() {
		ModelRegisterUtil.registerPartModel(TDParts.armorPlate);
		/*ModelRegisterUtil.registerPartModel(TDParts.chainmail);
		ModelRegisterUtil.registerPartModel(TDParts.clasp);
		ModelRegisterUtil.registerPartModel(TDParts.cloth);
		ModelRegisterUtil.registerPartModel(TDParts.filigree);
		ModelRegisterUtil.registerPartModel(TDParts.ringShank);*/
		ModelRegisterUtil.registerPartModel(TDParts.rivets);
		/*ModelRegisterUtil.registerPartModel(TDParts.setting);
		ModelRegisterUtil.registerPartModel(TDParts.wire);*/
	}

	@Override
	public void reloadRenderers() {
		setToolGuis();
	}

	public void setToolGuis() {
		roundshieldGUI.positions.clear();
		roundshieldGUI.addSlotPosition(34, 15);
		roundshieldGUI.addSlotPosition(34, 33);
		roundshieldGUI.addSlotPosition(34, 51);

		heatershieldGUI.positions.clear();
		heatershieldGUI.addSlotPosition(34, 15);
		heatershieldGUI.addSlotPosition(25, 33);
		heatershieldGUI.addSlotPosition(43, 33);
		heatershieldGUI.addSlotPosition(34, 51);

		zweihanderGUI.positions.clear();
		zweihanderGUI.addSlotPosition(34, 15);
		zweihanderGUI.addSlotPosition(25, 33);
		zweihanderGUI.addSlotPosition(43, 33);
		zweihanderGUI.addSlotPosition(34, 51);

		/*hoodGUI.positions.clear();
		hoodGUI.addSlotPosition(34, 15 + 8);
		hoodGUI.addSlotPosition(43, 33 + 8);
		hoodGUI.addSlotPosition(34, 51 + 8);

		shawlGUI.positions.clear();
		shawlGUI.addSlotPosition(34, 15 + 8);
		shawlGUI.addSlotPosition(43, 33 + 8);
		shawlGUI.addSlotPosition(34, 51 + 8);

		robeGUI.positions.clear();
		robeGUI.addSlotPosition(34, 15 + 8);
		robeGUI.addSlotPosition(43, 33 + 8);
		robeGUI.addSlotPosition(34, 51 + 8);

		shoesGUI.positions.clear();
		shoesGUI.addSlotPosition(34, 15 + 8);
		shoesGUI.addSlotPosition(43, 33 + 8);
		shoesGUI.addSlotPosition(34, 51 + 8);*/

		shearsGUI.positions.clear();
		shearsGUI.addSlotPosition(34, 15 + 8);
		shearsGUI.addSlotPosition(43, 33 + 8);
		shearsGUI.addSlotPosition(34, 51 + 8);

		/*fishingRodGUI.positions.clear();
		fishingRodGUI.addSlotPosition(34, 15 + 8);
		fishingRodGUI.addSlotPosition(43, 33 + 8);
		fishingRodGUI.addSlotPosition(34, 51 + 8);

		sheatheGUI.positions.clear();
		sheatheGUI.addSlotPosition(34, 15);
		sheatheGUI.addSlotPosition(34, 33);
		sheatheGUI.addSlotPosition(34, 51);

		ringGUI.positions.clear();
		ringGUI.addSlotPosition(34, 15);
		ringGUI.addSlotPosition(34, 33);
		ringGUI.addSlotPosition(34, 51);
		
		amuletGUI.positions.clear();
		amuletGUI.addSlotPosition(34, 15);
		amuletGUI.addSlotPosition(34, 33);
		amuletGUI.addSlotPosition(34, 51);*/
	}

	void createToolModels() {
		sheathe = new SheatheModel();
	}

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(Reference.MOD_ID + ":" + id, "inventory"));
	}

	@Override
	public void registerFluidModels(Fluid fluid) {
		if (fluid == null) {
			return;
		}

		Block block = fluid.getBlock();
		if (block != null) {
			Item item = Item.getItemFromBlock(block);
			FluidStateMapper mapper = new FluidStateMapper(fluid);

			// item-model
			if (item != null) {
				ModelLoader.registerItemVariants(item);
				ModelLoader.setCustomMeshDefinition(item, mapper);
			}
			// block-model
			ModelLoader.setCustomStateMapper(block, mapper);
		}
	}

	@Override
	public void registerItemBlockRenderer(Block block, int meta, String file) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta,
				new ModelResourceLocation(Reference.MOD_ID + ":" + file, "inventory"));
	}

	public static class FluidStateMapper extends StateMapperBase implements ItemMeshDefinition {

		public final Fluid fluid;
		public final ModelResourceLocation location;

		public FluidStateMapper(Fluid fluid) {
			this.fluid = fluid;

			// have each block hold its fluid per nbt? hm
			this.location = new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, "fluid_block"),
					fluid.getName());
		}

		@Nonnull
		@Override
		protected ModelResourceLocation getModelResourceLocation(@Nonnull IBlockState state) {
			return location;
		}

		@Nonnull
		@Override
		public ModelResourceLocation getModelLocation(@Nonnull ItemStack stack) {
			return location;
		}
	}
}
