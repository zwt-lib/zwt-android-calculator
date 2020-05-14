package test.calc;

import android.graphics.Point;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Display;
import android.widget.ImageView;

import it.unipr.netsec.zwt.ZwtFrame;
import it.unipr.netsec.zwt.examples.calc.RPNCalculator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int statusBarHeight = 0;
        int resourceId = getResources().getIdentifier("statusBarHeight", "dimen", "android");
        if (resourceId > 0) statusBarHeight = getResources().getDimensionPixelSize(resourceId);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y - statusBarHeight;

        ImageView imageView = findViewById(R.id.myImageView);

        calculator(imageView, width, height);
    }

    private void calculator(ImageView imageView, int width, int height) {
        ZwtFrame frame = new ZwtFrame(imageView, width, height);
        RPNCalculator.RES_PATH="resources";
        new RPNCalculator(frame,true);
    }

}
