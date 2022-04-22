package de.mimi.science.core.init.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

import static net.minecraft.world.level.block.WeepingVinesPlantBlock.SHAPE;

public class MicroscopeBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public MicroscopeBlock(Properties properties) {
        super(properties);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(11, 0, 4, 12, 1, 5),
            Block.box(4, 0, 4, 5, 1, 5),
            Block.box(4, 0, 11, 5, 1, 12),
            Block.box(11, 0, 11, 12, 1, 12),
            Block.box(3, 1, 3, 13, 2, 11),
            Block.box(7, 0, 12, 9, 3, 14),
            Block.box(9, 1, 11, 13, 2, 13),
            Block.box(3, 1, 11, 7, 2, 13),
            Block.box(7, 3, 13, 9, 4, 14),
            Block.box(9, 2, 10, 10, 3, 13),
            Block.box(9, 4, 10, 10, 5, 13),
            Block.box(6, 2, 10, 7, 3, 13),
            Block.box(6, 4, 10, 7, 5, 13),
            Block.box(5, 3, 12, 11, 4, 13),
            Block.box(11, 3, 4, 12, 4, 13),
            Block.box(4, 3, 4, 5, 4, 13),
            Block.box(5, 3, 4, 11, 4, 12),
            Block.box(7, 1, 11, 9, 2, 12),
            Block.box(7, 4, 12, 9, 6, 14),
            Block.box(7, 6, 11, 9, 8, 14),
            Block.box(7, 8, 11, 9, 9, 13),
            Block.box(7, 10, 10, 9, 11, 12),
            Block.box(6, 12, 9, 10, 13, 11),
            Block.box(7, 9, 10, 9, 10, 13),
            Block.box(7, 11, 9, 9, 12, 12),
            Block.box(7, 13, 9, 9, 14, 10),
            Block.box(7, 8, 8, 9, 16, 9),
            Block.box(7, 8, 5, 9, 16, 6),
            Block.box(6, 8, 6, 7, 16, 8),
            Block.box(9, 8, 6, 10, 16, 8),
            Block.box(7, 8, 6, 9, 15, 8),
            Block.box(7, 5, 6, 9, 8, 8),
            Block.box(9, 11, 8, 10, 14, 9),
            Block.box(9, 11, 5, 10, 14, 6),
            Block.box(6, 11, 5, 7, 14, 6),
            Block.box(7, 11, 4, 9, 14, 5),
            Block.box(6, 11, 8, 7, 14, 9),
            Block.box(5, 11, 6, 6, 14, 8),
            Block.box(10, 11, 6, 11, 14, 8),
            Block.box(10, 12, 9, 11, 13, 12),
            Block.box(5, 12, 9, 6, 13, 12),
            Block.box(10, 11, 10, 11, 12, 11),
            Block.box(10, 13, 10, 11, 14, 11),
            Block.box(5, 13, 10, 6, 14, 11),
            Block.box(5, 11, 10, 6, 12, 11)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(0, 0, 0, 16, 1, 16),
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(3, 1, 3, 6, 2, 6),
            Block.box(9, 1, 7, 12, 2, 10),
            Block.box(3, 2, 6, 6, 5, 7),
            Block.box(9, 2, 10, 12, 15, 11),
            Block.box(9, 2, 6, 12, 15, 7),
            Block.box(12, 2, 7, 13, 15, 10),
            Block.box(6, 2, 3, 7, 5, 6),
            Block.box(8, 2, 7, 9, 8, 10),
            Block.box(8, 9, 7, 9, 15, 10),
            Block.box(2, 2, 3, 3, 5, 6),
            Block.box(3, 2, 2, 6, 5, 3),
            Block.box(8, 1, 8, 9, 2, 9),
            Block.box(10, 1, 10, 11, 2, 11),
            Block.box(12, 1, 8, 13, 2, 9),
            Block.box(10, 1, 6, 11, 2, 7),
            Block.box(6, 1, 4, 7, 2, 5),
            Block.box(4, 1, 2, 5, 2, 3),
            Block.box(4, 1, 6, 5, 2, 7),
            Block.box(2, 1, 4, 3, 2, 5),
            Block.box(4, 1, 12, 5, 2, 13),
            Block.box(4, 14, 12, 5, 15, 13),
            Block.box(4, 1, 13, 5, 15, 14),
            Block.box(3, 1, 12, 4, 15, 13),
            Block.box(4, 1, 11, 5, 9, 12),
            Block.box(5, 1, 12, 6, 15, 13),
            Block.box(4, 6, 3, 5, 15, 4),
            Block.box(5, 6, 4, 6, 15, 5),
            Block.box(4, 6, 5, 5, 9, 6),
            Block.box(4, 12, 5, 5, 15, 6),
            Block.box(4, 12, 11, 5, 15, 12),
            Block.box(3, 6, 4, 4, 15, 5),
            Block.box(3, 5, 5, 6, 6, 6),
            Block.box(3, 5, 3, 6, 6, 4),
            Block.box(5, 5, 4, 6, 6, 5),
            Block.box(3, 5, 4, 4, 6, 5),
            Block.box(0, 1, 14, 2, 15, 16),
            Block.box(14, 1, 14, 16, 15, 16),
            Block.box(14, 1, 0, 16, 15, 2),
            Block.box(0, 1, 0, 2, 15, 2),
            Block.box(4, 9, 5, 5, 10, 8),
            Block.box(4, 9, 9, 5, 10, 12),
            Block.box(4, 11, 5, 5, 12, 12),
            Block.box(3, 10, 5, 4, 11, 12),
            Block.box(5, 10, 5, 6, 11, 12),
            Block.box(3, 7, 8, 4, 10, 9),
            Block.box(4, 8, 7, 9, 9, 8),
            Block.box(4, 8, 9, 9, 9, 10),
            Block.box(4, 7, 8, 8, 8, 9),
            Block.box(5, 9, 8, 8, 10, 9),
            Block.box(14, 1, 6, 15, 15, 10),
            Block.box(14, 1, 5, 16, 15, 6),
            Block.box(14, 1, 10, 16, 15, 11),
            Block.box(15, 1, 6, 16, 3, 7),
            Block.box(15, 1, 8, 16, 3, 9),
            Block.box(15, 4, 9, 16, 6, 10),
            Block.box(15, 4, 7, 16, 6, 8),
            Block.box(15, 7, 6, 16, 9, 7),
            Block.box(15, 7, 8, 16, 9, 9),
            Block.box(15, 10, 9, 16, 12, 10),
            Block.box(15, 10, 7, 16, 12, 8),
            Block.box(15, 13, 6, 16, 15, 7),
            Block.box(15, 13, 8, 16, 15, 9),
            Block.box(15, 3, 6, 16, 4, 10),
            Block.box(15, 6, 6, 16, 7, 10),
            Block.box(15, 9, 6, 16, 10, 10),
            Block.box(15, 12, 6, 16, 13, 10),
            Block.box(15, 1, 7, 16, 3, 8),
            Block.box(15, 1, 9, 16, 3, 10),
            Block.box(15, 4, 8, 16, 6, 9),
            Block.box(15, 4, 6, 16, 6, 7),
            Block.box(15, 7, 7, 16, 9, 8),
            Block.box(15, 7, 9, 16, 9, 10),
            Block.box(15, 10, 8, 16, 12, 9),
            Block.box(15, 10, 6, 16, 12, 7),
            Block.box(15, 13, 7, 16, 15, 8),
            Block.box(15, 13, 9, 16, 15, 10)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(0, 0, 0, 16, 1, 16),
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(10, 1, 3, 13, 2, 6),
            Block.box(6, 1, 9, 9, 2, 12),
            Block.box(9, 2, 3, 10, 5, 6),
            Block.box(5, 2, 9, 6, 15, 12),
            Block.box(9, 2, 9, 10, 15, 12),
            Block.box(6, 2, 12, 9, 15, 13),
            Block.box(10, 2, 6, 13, 5, 7),
            Block.box(6, 2, 8, 9, 8, 9),
            Block.box(6, 9, 8, 9, 15, 9),
            Block.box(10, 2, 2, 13, 5, 3),
            Block.box(13, 2, 3, 14, 5, 6),
            Block.box(7, 1, 8, 8, 2, 9),
            Block.box(5, 1, 10, 6, 2, 11),
            Block.box(7, 1, 12, 8, 2, 13),
            Block.box(9, 1, 10, 10, 2, 11),
            Block.box(11, 1, 6, 12, 2, 7),
            Block.box(13, 1, 4, 14, 2, 5),
            Block.box(9, 1, 4, 10, 2, 5),
            Block.box(11, 1, 2, 12, 2, 3),
            Block.box(3, 1, 4, 4, 2, 5),
            Block.box(3, 14, 4, 4, 15, 5),
            Block.box(2, 1, 4, 3, 15, 5),
            Block.box(3, 1, 3, 4, 15, 4),
            Block.box(4, 1, 4, 5, 9, 5),
            Block.box(3, 1, 5, 4, 15, 6),
            Block.box(12, 6, 4, 13, 15, 5),
            Block.box(11, 6, 5, 12, 15, 6),
            Block.box(10, 6, 4, 11, 9, 5),
            Block.box(10, 12, 4, 11, 15, 5),
            Block.box(4, 12, 4, 5, 15, 5),
            Block.box(11, 6, 3, 12, 15, 4),
            Block.box(10, 5, 3, 11, 6, 6),
            Block.box(12, 5, 3, 13, 6, 6),
            Block.box(11, 5, 5, 12, 6, 6),
            Block.box(11, 5, 3, 12, 6, 4),
            Block.box(0, 1, 0, 2, 15, 2),
            Block.box(0, 1, 14, 2, 15, 16),
            Block.box(14, 1, 14, 16, 15, 16),
            Block.box(14, 1, 0, 16, 15, 2),
            Block.box(8, 9, 4, 11, 10, 5),
            Block.box(4, 9, 4, 7, 10, 5),
            Block.box(4, 11, 4, 11, 12, 5),
            Block.box(4, 10, 3, 11, 11, 4),
            Block.box(4, 10, 5, 11, 11, 6),
            Block.box(7, 7, 3, 8, 10, 4),
            Block.box(8, 8, 4, 9, 9, 9),
            Block.box(6, 8, 4, 7, 9, 9),
            Block.box(7, 7, 4, 8, 8, 8),
            Block.box(7, 9, 5, 8, 10, 8),
            Block.box(6, 1, 14, 10, 15, 15),
            Block.box(10, 1, 14, 11, 15, 16),
            Block.box(5, 1, 14, 6, 15, 16),
            Block.box(9, 1, 15, 10, 3, 16),
            Block.box(7, 1, 15, 8, 3, 16),
            Block.box(6, 4, 15, 7, 6, 16),
            Block.box(8, 4, 15, 9, 6, 16),
            Block.box(9, 7, 15, 10, 9, 16),
            Block.box(7, 7, 15, 8, 9, 16),
            Block.box(6, 10, 15, 7, 12, 16),
            Block.box(8, 10, 15, 9, 12, 16),
            Block.box(9, 13, 15, 10, 15, 16),
            Block.box(7, 13, 15, 8, 15, 16),
            Block.box(6, 3, 15, 10, 4, 16),
            Block.box(6, 6, 15, 10, 7, 16),
            Block.box(6, 9, 15, 10, 10, 16),
            Block.box(6, 12, 15, 10, 13, 16),
            Block.box(8, 1, 15, 9, 3, 16),
            Block.box(6, 1, 15, 7, 3, 16),
            Block.box(7, 4, 15, 8, 6, 16),
            Block.box(9, 4, 15, 10, 6, 16),
            Block.box(8, 7, 15, 9, 9, 16),
            Block.box(6, 7, 15, 7, 9, 16),
            Block.box(7, 10, 15, 8, 12, 16),
            Block.box(9, 10, 15, 10, 12, 16),
            Block.box(8, 13, 15, 9, 15, 16),
            Block.box(6, 13, 15, 7, 15, 16)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(0, 0, 0, 16, 1, 16),
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(10, 1, 10, 13, 2, 13),
            Block.box(4, 1, 6, 7, 2, 9),
            Block.box(10, 2, 9, 13, 5, 10),
            Block.box(4, 2, 5, 7, 15, 6),
            Block.box(4, 2, 9, 7, 15, 10),
            Block.box(3, 2, 6, 4, 15, 9),
            Block.box(9, 2, 10, 10, 5, 13),
            Block.box(7, 2, 6, 8, 8, 9),
            Block.box(7, 9, 6, 8, 15, 9),
            Block.box(13, 2, 10, 14, 5, 13),
            Block.box(10, 2, 13, 13, 5, 14),
            Block.box(7, 1, 7, 8, 2, 8),
            Block.box(5, 1, 5, 6, 2, 6),
            Block.box(3, 1, 7, 4, 2, 8),
            Block.box(5, 1, 9, 6, 2, 10),
            Block.box(9, 1, 11, 10, 2, 12),
            Block.box(11, 1, 13, 12, 2, 14),
            Block.box(11, 1, 9, 12, 2, 10),
            Block.box(13, 1, 11, 14, 2, 12),
            Block.box(11, 1, 3, 12, 2, 4),
            Block.box(11, 14, 3, 12, 15, 4),
            Block.box(11, 1, 2, 12, 15, 3),
            Block.box(12, 1, 3, 13, 15, 4),
            Block.box(11, 1, 4, 12, 9, 5),
            Block.box(10, 1, 3, 11, 15, 4),
            Block.box(11, 6, 12, 12, 15, 13),
            Block.box(10, 6, 11, 11, 15, 12),
            Block.box(11, 6, 10, 12, 9, 11),
            Block.box(11, 12, 10, 12, 15, 11),
            Block.box(11, 12, 4, 12, 15, 5),
            Block.box(12, 6, 11, 13, 15, 12),
            Block.box(10, 5, 10, 13, 6, 11),
            Block.box(10, 5, 12, 13, 6, 13),
            Block.box(10, 5, 11, 11, 6, 12),
            Block.box(12, 5, 11, 13, 6, 12),
            Block.box(14, 1, 0, 16, 15, 2),
            Block.box(0, 1, 0, 2, 15, 2),
            Block.box(0, 1, 14, 2, 15, 16),
            Block.box(14, 1, 14, 16, 15, 16),
            Block.box(11, 9, 8, 12, 10, 11),
            Block.box(11, 9, 4, 12, 10, 7),
            Block.box(11, 11, 4, 12, 12, 11),
            Block.box(12, 10, 4, 13, 11, 11),
            Block.box(10, 10, 4, 11, 11, 11),
            Block.box(12, 7, 7, 13, 10, 8),
            Block.box(7, 8, 8, 12, 9, 9),
            Block.box(7, 8, 6, 12, 9, 7),
            Block.box(8, 7, 7, 12, 8, 8),
            Block.box(8, 9, 7, 11, 10, 8),
            Block.box(1, 1, 6, 2, 15, 10),
            Block.box(0, 1, 10, 2, 15, 11),
            Block.box(0, 1, 5, 2, 15, 6),
            Block.box(0, 1, 9, 1, 3, 10),
            Block.box(0, 1, 7, 1, 3, 8),
            Block.box(0, 4, 6, 1, 6, 7),
            Block.box(0, 4, 8, 1, 6, 9),
            Block.box(0, 7, 9, 1, 9, 10),
            Block.box(0, 7, 7, 1, 9, 8),
            Block.box(0, 10, 6, 1, 12, 7),
            Block.box(0, 10, 8, 1, 12, 9),
            Block.box(0, 13, 9, 1, 15, 10),
            Block.box(0, 13, 7, 1, 15, 8),
            Block.box(0, 3, 6, 1, 4, 10),
            Block.box(0, 6, 6, 1, 7, 10),
            Block.box(0, 9, 6, 1, 10, 10),
            Block.box(0, 12, 6, 1, 13, 10),
            Block.box(0, 1, 8, 1, 3, 9),
            Block.box(0, 1, 6, 1, 3, 7),
            Block.box(0, 4, 7, 1, 6, 8),
            Block.box(0, 4, 9, 1, 6, 10),
            Block.box(0, 7, 8, 1, 9, 9),
            Block.box(0, 7, 6, 1, 9, 7),
            Block.box(0, 10, 7, 1, 12, 8),
            Block.box(0, 10, 9, 1, 12, 10),
            Block.box(0, 13, 8, 1, 15, 9),
            Block.box(0, 13, 6, 1, 15, 7)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();



    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    /* FACING */

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }
}
