package net.gurken.pocket_end_update.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.apache.commons.lang3.mutable.MutableInt;

public class StructuralFeature extends Feature<StructuralFeatureConfiguration> {
    // CREDIT GOES TO: TeamTwilight | https://github.com/TeamTwilight/twilightforest, from whom this code is adapted.
    // The Twilight Forest uses a custom LGPL License
    // https://github.com/TeamTwilight/twilightforest/blob/1.20.x/LICENSE
    public StructuralFeature(Codec<StructuralFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    /**
     * Places the given feature at the given location.
     * During world generation, features are provided with a 3x3 region of chunks, centered on the chunk being generated,
     * that they can safely generate into.
     * @param pContext A context object with a reference to the level and the position the feature is being placed at
     */
    public boolean place(FeaturePlaceContext<StructuralFeatureConfiguration> pContext) {
        RandomSource randomsource = pContext.random();
        WorldGenLevel worldgenlevel = pContext.level();
        BlockPos blockpos = pContext.origin();
        Rotation rotation = Rotation.getRandom(randomsource);
        StructuralFeatureConfiguration structuralfeatureconfiguration = pContext.config();
        int i = randomsource.nextInt(structuralfeatureconfiguration.structuralStructures.size());
        StructureTemplateManager structuretemplatemanager = worldgenlevel.getLevel().getServer().getStructureManager();
        StructureTemplate structuretemplate = structuretemplatemanager.getOrCreate(structuralfeatureconfiguration.structuralStructures.get(i));
        StructureTemplate structuretemplate1 = structuretemplatemanager.getOrCreate(structuralfeatureconfiguration.overlayStructures.get(i));
        ChunkPos chunkpos = new ChunkPos(blockpos);
        BoundingBox boundingbox = new BoundingBox(chunkpos.getMinBlockX() - 16, worldgenlevel.getMinBuildHeight(), chunkpos.getMinBlockZ() - 16, chunkpos.getMaxBlockX() + 16, worldgenlevel.getMaxBuildHeight(), chunkpos.getMaxBlockZ() + 16);
        StructurePlaceSettings structureplacesettings = (new StructurePlaceSettings()).setRotation(rotation).setBoundingBox(boundingbox).setRandom(randomsource);
        Vec3i vec3i = structuretemplate.getSize(rotation);
        BlockPos blockpos1 = blockpos.offset(-vec3i.getX() / 2, 0, -vec3i.getZ() / 2);

        int j = blockpos.getY();

        for(int k = 0; k < vec3i.getX(); ++k) {
            for(int l = 0; l < vec3i.getZ(); ++l) {
                j = Math.min(j, worldgenlevel.getHeight(Heightmap.Types.WORLD_SURFACE_WG, blockpos1.getX() + k, blockpos1.getZ() + l));
            }
        }

        int i1 = Math.max(j, worldgenlevel.getMinBuildHeight() + 10);
        BlockPos blockpos2 = structuretemplate.getZeroPositionWithTransform(blockpos1.atY(i1), Mirror.NONE, rotation);
        if (countEmptyCorners(worldgenlevel, structuretemplate.getBoundingBox(structureplacesettings, blockpos2)) > structuralfeatureconfiguration.maxEmptyCornersAllowed) {
            return false;
        } else {
            structureplacesettings.clearProcessors();
            structuralfeatureconfiguration.structuralProcessors.value().list().forEach(structureplacesettings::addProcessor);
            structuretemplate.placeInWorld(worldgenlevel, blockpos2, blockpos2, structureplacesettings, randomsource, 4);
            structureplacesettings.clearProcessors();
            structuralfeatureconfiguration.overlayProcessors.value().list().forEach(structureplacesettings::addProcessor);
            structuretemplate1.placeInWorld(worldgenlevel, blockpos2, blockpos2, structureplacesettings, randomsource, 4);
            return true;
        }
    }

    private static int countEmptyCorners(WorldGenLevel pLevel, BoundingBox pBoundingBox) {
        MutableInt mutableint = new MutableInt(0);
        pBoundingBox.forAllCorners((p_284921_) -> {
            BlockState blockstate = pLevel.getBlockState(p_284921_);
            if (blockstate.isAir() || blockstate.is(Blocks.LAVA) || blockstate.is(Blocks.WATER)) {
                mutableint.add(1);
            }

        });
        return mutableint.getValue();
    }
}
