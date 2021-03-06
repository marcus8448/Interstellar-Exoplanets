package net.rom.exoplanets.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.ItemStack;

public class MapUtil extends StateMapperBase implements ItemMeshDefinition {
	
	public final ModelResourceLocation location;
	
	public MapUtil(String modName, String fileName, String modelName) {
		this.location = new ModelResourceLocation(modName + ":" + fileName, modelName);
	}
	
	@Override
	protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
		return location;
	}
	
	@Override
	public ModelResourceLocation getModelLocation(ItemStack stack) {
		return location;
	}
	
}