package teamdraco.unnamedanimalmod.common.worldgen.trees.mangrove;

import teamdraco.unnamedanimalmod.UAMHelper;
import teamdraco.unnamedanimalmod.common.block.MangroveSaplingBlock;
import teamdraco.unnamedanimalmod.init.UAMBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class MangroveTreeHelper
{
    //NOTE all random values below have 1 added to them when randomizing, the values determine the maximum possible output, not number of outputs
    //region land
    //trunk placement
    public static int minimumLandTrunkHeight = 7; //the bare minimum height a trunk can be
    public static int landTrunkHeightExtra = 2; //maximum possible randomized increase in height
    public static int minimumSideLandTrunkHeight = 1; //the bare minimum height a trunk can be
    public static int sideLandTrunkHeightExtra = 2; //maximum possible randomized increase in height
    //endregion

    //region water
    //trunk core placement - lowest point of the trunk
    public static int minimumWaterTrunkOffset = 2; //the absolute minimum height difference between the sapling the core, important when planted in small bodies of water
    public static int waterTrunkOffsetExtra = 1; //maximum possible randomized extra difference

    //full trunk placement, goes all the way up to the crown
    public static int minimumWaterTrunkHeight = 7; //the bare minimum height a trunk can be, should probably be higher than maximumUpwardsRootOffset
    public static int waterTrunkHeightExtra = 2; //maximum possible randomized increase in height

    //root placement
    public static int maximumUpwardsWaterRootOffset = 2; //maximum upwards offset of the start of the root
    public static int minimumWaterRootCoreOffset = 2; //minimum distance between the trunk core and the root core
    public static int waterRootCoreOffsetExtra = 1; //maximum possible randomized increase in distance
    //endregion

    //treetop placement
    public static int maximumDownwardsBranchOffset = 2; //maximum downwards offset of the start of the branch
    public static int minimumBranchCoreOffset = 3; //minimum distance between the trunk top and the branch core
    public static int branchCoreOffsetExtra = 1; //maximum possible randomized increase in distance
    public static int minimumBranchHeight = 2; //the bare minimum height a branch can be
    public static int branchHeightExtra = 2; //maximum possible randomized increase in height

    //leaves placement
    public static int leavesHeight = 4; //the total height of each individual leaves blob
    public static int leavesHeightExtra = 1; //yknow the drill, + random value
    public static int leavesStartDownwardsOffsetExtra = 2; //leaves don't always start atop the brannch, up to x blocks down
    public static int leavesSize = 2; //horizontal size of the blob
    public static int leavesSizeExtra = 1; //once again, randomized extra leaves size;
    public static int leavesShrinkStart = 2; //after how many blob layers do blob layers start to shrink. Until then they grow.
    public static int minimumVineHeight = 7; //the minimum possible height of vines
    public static int vineHeightExtra = 2; //I don't think I need to even write anything here

    public static void fill(WorldGenLevel reader, ArrayList<Entry> filler)
    {
        for (Entry entry : filler)
        {
            reader.setBlock(entry.pos, entry.state, 3);
        }
    }

    public static void fillLeaves(WorldGenLevel reader, Random rand, ArrayList<Entry> filler)
    {
        Collection<Entry> vineFiller = UAMHelper.takeAll(filler, p -> p.state.getBlock() instanceof VineBlock);
        for (Entry entry : filler)
        {
            if (canPlace(reader, entry.pos))
            {
                reader.setBlock(entry.pos, entry.state, 3);
            }
        }
        for (Entry entry : vineFiller)
        {
            if (canPlace(reader, entry.pos))
            {
                int vinesLength = minimumVineHeight + rand.nextInt(vineHeightExtra + 1);
                for (int i = 0; i < vinesLength; i++)
                {
                    BlockPos vinePos = entry.pos.below(i);
                    if (canPlace(reader, vinePos) && !reader.isWaterAt(vinePos))
                    {
                        reader.setBlock(vinePos, entry.state, 3);
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }
    }

    public static void makeLeafBlob(ArrayList<Entry> filler, Random rand, BlockPos pos, int branchHeight)
    {
        int randomOffset = rand.nextInt(leavesStartDownwardsOffsetExtra + 1);
        int startingLeavesOffset = branchHeight - randomOffset;
        int finalLeavesHeight = leavesHeight + rand.nextInt(leavesHeightExtra + 1);

        int size = leavesSize - 1 + rand.nextInt(leavesSizeExtra);
        for (int i = 0; i < finalLeavesHeight; i++)
        {
            int y = startingLeavesOffset + i;
            BlockPos blobSliceCenter = pos.above(y);
            if (i < leavesShrinkStart)
            {
                size++;
            }
            else
            {
                size--;
            }
            makeLeafSlice(filler, rand, blobSliceCenter, size, i < leavesShrinkStart);
        }
    }

    public static void makeLeafSlice(ArrayList<Entry> filler, Random rand, BlockPos pos, int leavesSize, boolean vines)
    {
        for (int x = -leavesSize; x <= leavesSize; x++)
        {
            for (int z = -leavesSize; z <= leavesSize; z++)
            {
                if (Math.abs(x) == leavesSize && Math.abs(z) == leavesSize)
                {
                    continue;
                }
                BlockPos leavesPos = new BlockPos(pos).offset(x, 0, z);
                if (rand.nextFloat() > 0.15f)
                {

                    filler.add(new Entry(leavesPos, UAMBlocks.MANGROVE_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1)));
                }
                else
                {
                    filler.add(new Entry(leavesPos, UAMBlocks.FLOWERING_MANGROVE_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1)));
                }

                if (vines)
                {
                    if (Math.abs(x) == leavesSize || Math.abs(z) == leavesSize)
                    {
                        if (rand.nextFloat() < 0.2f)
                        {
                            Direction[] directions = new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST};
                            for (Direction direction : directions)
                            {
                                filler.add(new Entry(leavesPos.relative(direction), Blocks.VINE.defaultBlockState().setValue(VineBlock.PROPERTY_BY_DIRECTION.get(direction.getOpposite()), true)));
                            }
                        }
                    }
                    if (rand.nextFloat() < 0.1F)
                    {
                        filler.add(new Entry(leavesPos.below(), UAMBlocks.MANGROVE_FRUIT.get().defaultBlockState()));
                    }
                }
            }
        }
    }

    public static boolean canPlace(WorldGenLevel reader, BlockPos pos)
    {
        if (!World.isInWorldBounds(pos))
        {
            return false;
        }
        return (reader.getBlockState(pos).getBlock() instanceof MangroveSaplingBlock || reader.isWaterAt(pos) || reader.isEmptyBlock(pos) || reader.getBlockState(pos).getMaterial().isReplaceable());
    }
}
