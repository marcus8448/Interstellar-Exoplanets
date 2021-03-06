package net.rom.exoplanets.world;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.rom.exoplanets.init.ExoBlocks;

public class OverworldOreGen implements IWorldGenerator {

	public WorldGenerator ORELIMONITE;
	public WorldGenerator ORERUTHENIUM;
	public WorldGenerator ORERUTILE;
	
	public OverworldOreGen() {
		ORELIMONITE = new WorldGenMinable(ExoBlocks.overworldore.getStateFromMeta(0), 5);
		ORERUTHENIUM = new WorldGenMinable(ExoBlocks.overworldore.getStateFromMeta(1), 5);
		ORERUTILE = new WorldGenMinable(ExoBlocks.overworldore.getStateFromMeta(2), 6);
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
	    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
	        throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

	    int heightDiff = maxHeight - minHeight + 1;
	    for (int i = 0; i < chancesToSpawn; i ++) {
	        int x = chunk_X * 16 + rand.nextInt(16);
	        int y = minHeight + rand.nextInt(heightDiff);
	        int z = chunk_Z * 16 + rand.nextInt(16);
	        generator.generate(world, rand, new BlockPos(x, y, z));
	    }
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		switch(world.provider.getDimensionType().getId()) {
		case 0: //Overworld Dimension
			runGenerator(ORELIMONITE, world, random, chunkX, chunkZ, 3, 45, 150);
			runGenerator(ORERUTHENIUM, world, random, chunkX, chunkZ, 8, 0, 64);
			runGenerator(ORERUTILE, world, random, chunkX, chunkZ, 5, 0, 64);
		}
		
	}

}
