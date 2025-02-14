package com.BrassAmber.ba_bt.worldGen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class BTJigsawConfiguration implements FeatureConfiguration {
    public static final Codec<BTJigsawConfiguration> CODEC = RecordCodecBuilder.create((p_67764_) -> {
        return p_67764_.group(StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(BTJigsawConfiguration::startPool), Codec.intRange(0, 25).fieldOf("size").forGetter(BTJigsawConfiguration::maxDepth)).apply(p_67764_, BTJigsawConfiguration::new);
    });
    private final Holder<StructureTemplatePool> startPool;
    private final int maxDepth;


    public BTJigsawConfiguration(Holder<StructureTemplatePool> poolHolder, int maxDepthIn) {
        this.startPool = poolHolder;
        this.maxDepth = maxDepthIn;
    }


    public int maxDepth() {
        return this.maxDepth;
    }

    public Holder<StructureTemplatePool> startPool() {
        return this.startPool;
    }
}

