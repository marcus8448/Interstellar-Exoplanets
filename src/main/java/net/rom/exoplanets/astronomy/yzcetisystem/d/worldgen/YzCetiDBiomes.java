package net.rom.exoplanets.astronomy.yzcetisystem.d.worldgen;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.rom.exoplanets.astronomy.yzcetisystem.YzCetiBlocks;
import net.rom.exoplanets.astronomy.yzcetisystem.d.BiomeDecoratorOther;
import net.rom.exoplanets.astronomy.yzcetisystem.d.worldgen.biomes.BiomeGenYzCetiD;
import net.rom.exoplanets.astronomy.yzcetisystem.d.worldgen.biomes.BiomeGenYzCetiMoltenMantleSea;

public class YzCetiDBiomes extends BiomeGenBaseGC {

	public static final Biome yz_ceti_d = new BiomeGenYzCetiD(new BiomeProperties("YzCeti D").setBaseHeight(0.125F).setHeightVariation(0.5F).setRainfall(0.0F).setRainDisabled());
	public static final Biome yz_ceti_d_mantle = new BiomeGenYzCetiMoltenMantleSea(new BiomeProperties("YzCeti D Mantle Sea").setBaseHeight(-1.0F).setHeightVariation(0.2F).setRainfall(0.0F).setRainDisabled());

	protected YzCetiDBiomes(BiomeProperties properties) {
		super(properties, true);
	}

	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorOther();
	}

	@Override
	public void genTerrainBlocks(World world, Random rand, ChunkPrimer chunk, int x, int z, double stoneNoise) {
	    generateYzCetiBiomeTerrain(rand, chunk, x, z, stoneNoise);
	}

	public final void generateYzCetiBiomeTerrain(Random rand, ChunkPrimer chunk, int x, int z, double stoneNoise) {
		IBlockState iblockstate = this.topBlock;
		IBlockState iblockstate1 = this.fillerBlock;
		int j = -1;
		int k = (int) (stoneNoise / 3.0D + 3.0D + rand.nextDouble() * 5.25D);
		int l = x & 15;
		int i1 = z & 15;
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

		for (int j1 = 255; j1 >= 0; --j1) {
			if (j1 <= rand.nextInt(5)) {
				chunk.setBlockState(i1, j1, l, Blocks.BEDROCK.getDefaultState());
			} else {
				IBlockState iblockstate2 = chunk.getBlockState(i1, j1, l);
				if (iblockstate2.getMaterial() == Material.AIR) {
					j = -1;
				} else if (iblockstate2.getBlock() == YzCetiBlocks.CetiD.D_SEDIMENTARYROCK) {
					if (j == -1) {
						if (k <= 0) {
							iblockstate = null;
							iblockstate1 = YzCetiBlocks.CetiD.D_SEDIMENTARYROCK.getDefaultState();
						} else if (j1 >= 63 - 4 && j1 <= 63 + 1) {
							iblockstate = this.topBlock;
							iblockstate1 = this.fillerBlock;
						}

						if (j1 < 63 && (iblockstate == null || iblockstate.getMaterial() == Material.AIR)) {
							if (this.getTemperature(blockpos$mutableblockpos.setPos(x, j1, z)) < 0.15F) {
								iblockstate = Blocks.ICE.getDefaultState();
							} else {
								iblockstate = Blocks.WATER.getDefaultState();
							}
						}

						j = k;

						if (j1 >= 63 - 1) {
							chunk.setBlockState(i1, j1, l, iblockstate);
						} else if (j1 < 63 - 7 - k) {
							iblockstate = null;
							iblockstate1 = YzCetiBlocks.CetiD.D_SEDIMENTARYROCK.getDefaultState();
							chunk.setBlockState(i1, j1, l, YzCetiBlocks.CetiD.D_GRAVEL.getDefaultState());
						} else {
							chunk.setBlockState(i1, j1, l, iblockstate1);
						}
					} else if (j > 0) {
						--j;
						chunk.setBlockState(i1, j1, l, iblockstate1);
					}
				}
			}
		}
	}
}
