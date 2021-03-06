package draylar.glimmeringpotions.client.renderer;

import draylar.glimmeringpotions.entity.PotionStandBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;

public class PotionStandBlockEntityRenderer extends BlockEntityRenderer<PotionStandBlockEntity> {

    public PotionStandBlockEntityRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(PotionStandBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.translate(0.51f, 0.4f, .49f);
        matrices.scale(0.75f, 0.75f, 0.75f);
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(45));

        MinecraftClient.getInstance().getItemRenderer().renderItem(
                blockEntity.getPotion(),
                ModelTransformation.Mode.FIXED,
                light,
                overlay,
                matrices,
                vertexConsumers
        );

        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(90));
        matrices.translate(0.03f, 0.0f, -0.03f);
        MinecraftClient.getInstance().getItemRenderer().renderItem(
                blockEntity.getPotion(),
                ModelTransformation.Mode.FIXED,
                light,
                overlay,
                matrices,
                vertexConsumers
        );
    }
}
