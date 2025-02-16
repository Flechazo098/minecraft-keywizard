package xyz.xindi.keywizard.util;

public class DrawingUtil {
//    public static void fill(PoseStack matrices, float x1, float y1, float x2, float y2, int color) {
//        Matrix4f matrix = matrices.m_85850_().m_85861_();
//        if (x1 < x2) {
//            float j = x1;
//            x1 = x2;
//            x2 = j;
//        }
//        if (y1 < y2) {
//            float j = y1;
//            y1 = y2;
//            y2 = j;
//        }
//        float f = (color >> 24 & 0xFF) / 255.0F;
//        float g = (color >> 16 & 0xFF) / 255.0F;
//        float h = (color >> 8 & 0xFF) / 255.0F;
//        float k = (color & 0xFF) / 255.0F;
//        BufferBuilder bufferBuilder = Tesselator.m_85913_().m_85915_();
//        RenderSystem.m_69478_();
//        RenderSystem.m_69472_();
//        RenderSystem.m_69453_();
//        RenderSystem.m_157427_(GameRenderer::m_172811_);
//        bufferBuilder.m_166779_(VertexFormat.Mode.QUADS, DefaultVertexFormat.f_85815_);
//        bufferBuilder.m_85982_(matrix, x1, y2, 0.0F).m_85950_(g, h, k, f).m_5752_();
//        bufferBuilder.m_85982_(matrix, x2, y2, 0.0F).m_85950_(g, h, k, f).m_5752_();
//        bufferBuilder.m_85982_(matrix, x2, y1, 0.0F).m_85950_(g, h, k, f).m_5752_();
//        bufferBuilder.m_85982_(matrix, x1, y1, 0.0F).m_85950_(g, h, k, f).m_5752_();
//        BufferUploader.m_231202_(bufferBuilder.m_231175_());
//        RenderSystem.m_69493_();
//        RenderSystem.m_69461_();
//    }
//
//    public static void drawHorizontalLine(PoseStack matrices, float x1, float x2, float y, int color) {
//        if (x2 < x1) {
//            float i = x1;
//            x1 = x2;
//            x2 = i;
//        }
//        fill(matrices, x1, y, x2 + 1.0F, y + 1.0F, color);
//    }
//
//    public static void drawVerticalLine(PoseStack matrices, float x, float y1, float y2, int color) {
//        if (y2 < y1) {
//            float i = y1;
//            y1 = y2;
//            y2 = i;
//        }
//        fill(matrices, x, y1 + 1.0F, x + 1.0F, y2, color);
//    }
//
//    public static void drawNoFillRect(PoseStack matrices, float left, float top, float right, float bottom, int color) {
//        drawHorizontalLine(matrices, left, right, top, color);
//        drawHorizontalLine(matrices, left, right, bottom, color);
//        drawVerticalLine(matrices, left, top, bottom, color);
//        drawVerticalLine(matrices, right, top, bottom, color);
//    }
}
