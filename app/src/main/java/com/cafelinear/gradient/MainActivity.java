package com.cafelinear.gradient;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View gradientView = findViewById(R.id.gradient_view);
        final View gradientView2 = findViewById(R.id.gradient_view2);

        ShapeDrawable.ShaderFactory sf = new ShapeDrawable.ShaderFactory() {
            @Override
            public Shader resize(int width, int height) {
                return new LinearGradient(
                        0, 0,
                        gradientView.getWidth(), 0,
                        new int[] {
                                Color.GREEN,
                                Color.MAGENTA
                        },
                        new float[] {
                                0,
                                2f
                        },
                        Shader.TileMode.CLAMP);
            }
        };

        PaintDrawable p = new PaintDrawable();
        p.setShape(new RectShape());
        p.setShaderFactory(sf);

        gradientView.setBackground(p);

        ShapeDrawable.ShaderFactory sf2 = new ShapeDrawable.ShaderFactory() {
            @Override
            public Shader resize(int width, int height) {
                return new LinearGradient(
                        0, 0,
                        gradientView.getWidth(), 0,
                        new int[] {
                                Color.GREEN,
                                Color.MAGENTA
                        },
                        new float[] {
                                -1f,
                                1f
                        },
                        Shader.TileMode.CLAMP);
            }
        };

        PaintDrawable p2 = new PaintDrawable();
        p2.setShape(new RectShape());
        p2.setShaderFactory(sf2);

        gradientView2.setBackground(p2);
    }
}
