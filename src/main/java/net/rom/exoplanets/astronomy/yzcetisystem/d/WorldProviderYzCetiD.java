package net.rom.exoplanets.astronomy.yzcetisystem.d;

import java.util.LinkedList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeAdaptive;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.RoomTreasure;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.rom.api.stellar.world.WorldProviderExoPlanet;
import net.rom.exoplanets.astronomy.yzcetisystem.YzCetiBlocks;
import net.rom.exoplanets.astronomy.yzcetisystem.YzCetiDimensions;
import net.rom.exoplanets.astronomy.yzcetisystem.d.worldgen.BiomeProviderYzCetiD;
import net.rom.exoplanets.astronomy.yzcetisystem.d.worldgen.ChunkProviderYzCetiD;
import net.rom.exoplanets.conf.SConfigSystems;
import net.rom.exoplanets.init.InitPlanets;

public class WorldProviderYzCetiD extends WorldProviderExoPlanet {

    @Override
    public Vector3 getSkyColor() {
        return new Vector3(0, 0, 0);
    }

    @Override
    public float getSolarSize() {
        return 0.5F;
    }

    @Override
    public boolean hasSunset() {
        return false;
    }

    @Override
    public long getDayLength() {
        return 100320L;
    }

    @Override
    public Class<? extends IChunkGenerator> getChunkProviderClass() {
        return ChunkProviderYzCetiD.class;
    }

    @Override
    public Class<? extends BiomeProvider> getBiomeProviderClass() {
        BiomeAdaptive.setBodyMultiBiome(InitPlanets.yzcetid);
        return BiomeProviderYzCetiD.class;
    }

    @Override
    public double getHorizon() {
        return 44.0D;
    }

    @Override
    public int getAverageGroundLevel() {
        return 44;
    }

    @Override
    public boolean canCoordinateBeSpawn(int var1, int var2) {
        return true;
    }

    @Override
    public float getGravity() {
        return 0.015F;
    }

    @Override
    public int getHeight() {
        return 800;
    }

    @Override
    public double getMeteorFrequency() {
        return 10.0D;
    }

    @Override
    public double getFuelUsageMultiplier() {
        return 1.2D;
    }

    @Override
    public boolean canSpaceshipTierPass(int tier) {
        return tier >= SConfigSystems.yzceti_tier;
    }

    @Override
    public float getFallDamageModifier() {
        return 0.38F;

    }

    @Override
    public CelestialBody getCelestialBody() {
        return InitPlanets.yzcetid;
    }

    @Override
    public float getThermalLevelModifier() {
        return 5.0F;
    }

    @Override
    public double getSolarEnergyMultiplier() {
        return 3.5D;
    }

    @Override
    public DimensionType getDimensionType() {
        return YzCetiDimensions.YZCETID;
    }

    @Override
    public int getDungeonSpacing() {
        return 0;
    }

    @Override
    public ResourceLocation getDungeonChestType() {
        return null;
    }

    @Override
    public List<Block> getSurfaceBlocks() {
        List<Block> list = new LinkedList<>();
        list.add(YzCetiBlocks.CetiD.D_SEDIMENTARYROCK);
        list.add(YzCetiBlocks.CetiD.D_IGNEOUS);
        list.add(YzCetiBlocks.CetiD.D_GRAVEL);
        return list;
    }

    @Override
    public double getYCoordinateToTeleport() {
        return 800.0D;
    }
}