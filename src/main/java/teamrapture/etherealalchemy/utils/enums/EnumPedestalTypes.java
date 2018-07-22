package teamrapture.etherealalchemy.utils.enums;

import net.minecraft.util.math.BlockPos;
import scala.actors.threadpool.Arrays;

import java.util.List;

public enum EnumPedestalTypes {
    PLUS(new BlockPos[]{new BlockPos(-2, 0, 0), new BlockPos(2, 0, 0), new BlockPos(0, 0, -2), new BlockPos(0, 0, 2)}),

    CIRCLE(new BlockPos[]{new BlockPos(0, 0, -3), new BlockPos(-3, 0, 0), new BlockPos(3, 0, 0), new BlockPos(0, 0, 3),
    new BlockPos(2, 0, -2), new BlockPos(-2, 0, -2), new BlockPos(2, 0, 2), new BlockPos(-2, 0, 2)}),

    DIAMOND(new BlockPos[]{new BlockPos(-1, 0, -1), new BlockPos(1, 0, -1), new BlockPos(-1, 0, 1), new BlockPos(1, 0, 1),
    new BlockPos(0, 0, -3), new BlockPos(0, 0, 3), new BlockPos(-3, 0, 0), new BlockPos(3, 0, 0)});

    public List<BlockPos> blocksList;

    private EnumPedestalTypes(BlockPos[] blockPos) {
        blocksList = Arrays.asList(blockPos);
    }
}
