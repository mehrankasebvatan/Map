package app.mkv.map.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.carto.graphics.Color;
import com.carto.styles.AnimationStyle;
import com.carto.styles.LineStyle;
import com.carto.styles.LineStyleBuilder;
import com.google.android.material.textfield.TextInputEditText;

import org.neshan.common.model.LatLng;
import org.neshan.mapsdk.MapView;
import org.neshan.mapsdk.model.Polyline;

import java.util.ArrayList;

import app.mkv.map.R;

public class LineActivity extends AppCompatActivity {

    MapView map;
    AnimationStyle anim;
    TextInputEditText start1, end1, start2, end2;
    Button line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_line);

    }


    @Override
    protected void onStart() {
        super.onStart();

        initLayoutReferences();
    }

    private void initLayoutReferences() {
        initViews();

    }

    private void initViews() {
        map = findViewById(R.id.map);
        start1 = findViewById(R.id.input_start1);
        start2 = findViewById(R.id.input_start2);
        end1 = findViewById(R.id.input_end1);
        end2 = findViewById(R.id.input_end2);

    }

    // Drawing line on map
    public Polyline drawLine(View view){
        // Adding some LatLng points to a latLngs
        ArrayList<LatLng> latLngs = new ArrayList<>();

        Double dStart1 = Double.parseDouble(start1.getText().toString());
        Double dStart2 = Double.parseDouble(start2.getText().toString());
        Double dEnd1 = Double.parseDouble(end1.getText().toString());
        Double dEnd2 = Double.parseDouble(end2.getText().toString());

        latLngs.add(new LatLng(dStart1, dEnd1));
        latLngs.add(new LatLng(dStart2, dEnd2));

        // Creating a line from LineGeom. here we use getLineStyle() method to define line styles
        Polyline polyline = new Polyline(latLngs, getLineStyle());
        // adding the created line to lineLayer, showing it on map
        map.addPolyline(polyline);
        // focusing camera on first point of drawn line
        map.moveCamera(new LatLng(dStart1, dEnd1),0.3f );
        map.setZoom(12,0);
        return polyline;
    }
    private LineStyle getLineStyle(){
        LineStyleBuilder lineStCr = new LineStyleBuilder();
        lineStCr.setColor(new Color((short) 2, (short) 119, (short) 189, (short)190));
        lineStCr.setWidth(12f);
        lineStCr.setStretchFactor(0f);
        return lineStCr.buildStyle();
    }



}