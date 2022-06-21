package teamdraco.unnamedanimalmod.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FlashlightFishModel<T extends Entity> extends EntityModel<T> {
    public ModelPart body;
    public ModelPart tail;
    public ModelPart dorsalfin;
    public ModelPart analfin;
    public ModelPart pelvicfinleft;
    public ModelPart pelvicfinright;

    public FlashlightFishModel() {
        this.texWidth = 20;
        this.texHeight = 20;
        this.dorsalfin = new ModelPart(this, 6, 9);
        this.dorsalfin.setPos(0.0F, -1.5F, 1.5F);
        this.dorsalfin.addBox(0.0F, -2.0F, -1.5F, 0.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.pelvicfinright = new ModelPart(this, 0, -1);
        this.pelvicfinright.setPos(-0.5F, 1.5F, -1.0F);
        this.pelvicfinright.addBox(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(pelvicfinright, 0.0F, 0.0F, 0.3490658503988659F);
        this.body = new ModelPart(this, 0, 0);
        this.body.setPos(0.0F, 22.5F, 0.0F);
        this.body.addBox(-1.0F, -1.5F, -3.0F, 2.0F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.analfin = new ModelPart(this, 0, 0);
        this.analfin.setPos(0.0F, 1.5F, 2.0F);
        this.analfin.addBox(0.0F, 0.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.pelvicfinleft = new ModelPart(this, 0, -1);
        this.pelvicfinleft.mirror = true;
        this.pelvicfinleft.setPos(0.5F, 1.5F, -1.0F);
        this.pelvicfinleft.addBox(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(pelvicfinleft, 0.0F, 0.0F, -0.3490658503988659F);
        this.tail = new ModelPart(this, 0, 6);
        this.tail.setPos(0.0F, 0.0F, 3.0F);
        this.tail.addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.body.addChild(this.dorsalfin);
        this.body.addChild(this.pelvicfinright);
        this.body.addChild(this.analfin);
        this.body.addChild(this.pelvicfinleft);
        this.body.addChild(this.tail);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = 1.0F;
        if (!entityIn.isInWater()) {
            f = 1.5F;
        }

        this.tail.yRot = -f * 0.45F * Mth.sin(0.6F * ageInTicks);
    }

    public void setRotateAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
