package net.lax1dude.eaglercraft.v1_8.minecraft;

import net.minecraft.client.resources.metadata.animation.AnimationMetadataSection;
import net.minecraft.client.resources.metadata.animation.AnimationFrame;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class AnimationMetadataSectionWrapper {
    private final List<AnimationFrame> frames;
    private final int frameTime;
    private final boolean interpolate;

    public AnimationMetadataSectionWrapper(AnimationMetadataSection meta) {
        if (meta != null) {
            // In 1.21.4, frames() returns Optional<List<AnimationFrame>>
            Optional<List<AnimationFrame>> framesOpt = meta.frames();
            this.frames = framesOpt.orElse(List.of());
            
            // Get frame time from the first frame, default to 1
            int firstFrameTime = 1;
            if (!this.frames.isEmpty()) {
                firstFrameTime = this.frames.get(0).time().orElse(1);
            }
            this.frameTime = firstFrameTime;
            
            // Check if we should interpolate frames
            this.interpolate = !this.frames.isEmpty() && this.frames.size() > 1;
        } else {
            this.frames = List.of();
            this.frameTime = 1;
            this.interpolate = false;
        }
    }

    public int getFrameTimeSingle(int index) {
        if (frames.isEmpty()) return 1;
        // Get time for the frame at the given index, default to 1 if not specified
        return frames.get(index % frames.size()).time().orElse(1);
    }

    public int getFrameIndex(int index) {
        if (frames.isEmpty()) return index;
        // Return the index of the frame in the frames list
        return index % frames.size();
    }

    public int getFrameCount() {
        return frames.size();
    }

    public boolean isInterpolate() {
        return interpolate;
    }

    public int getFrameTime() {
        return frameTime;
    }

    public Iterable<Integer> getFrameIndexSet() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < frames.size(); i++) {
            result.add(i);
        }
        return result;
    }
}
