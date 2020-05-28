package com.example.arcgishelloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.esri.arcgisruntime.ArcGISRuntimeEnvironment;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.ArcGISScene;
import com.esri.arcgisruntime.mapping.Basemap;
//import com.esri.arcgisruntime.mapping.view.MapView;
import com.esri.arcgisruntime.mapping.view.Camera;
import com.esri.arcgisruntime.mapping.view.SceneView;

public class MainActivity extends AppCompatActivity {
    private SceneView mSceneView;

    private void setupMap() {
        if (mSceneView != null) {
            ArcGISRuntimeEnvironment.setLicense(getResources().getString(R.string.arcgis_license_key));

            double latitude = 33.8610;
            double longitude = -118.8080;
            double altitude = 25000.0;
            double heading = 0.1;
            double pitch = 45.0;
            double roll = 0.0;

            ArcGISScene scene = new ArcGISScene();
            scene.setBasemap(Basemap.createStreets());
            mSceneView.setScene(scene);
            Camera camera = new Camera(latitude, longitude, altitude, heading, pitch, roll);
            mSceneView.setViewpointCamera(camera);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSceneView = findViewById(R.id.sceneView);
        setupMap();
    }
    @Override
    protected void onPause() {
        if (mSceneView != null) {
            mSceneView.pause();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mSceneView != null) {
            mSceneView.resume();
        }
    }

    @Override
    protected void onDestroy() {
        if (mSceneView != null) {
            mSceneView.dispose();
        }
        super.onDestroy();
    }
}
