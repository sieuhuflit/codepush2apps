package com.example.codepush2apps.codepush2apps;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;
import com.microsoft.codepush.react.CodePush;

public class MyRNApp2 extends AppCompatActivity {
    private ReactRootView mReactRootView = null;
    private ReactInstanceManager mReactInstanceManager = null;
    private final int OVERLAY_PERMISSION_REQ_CODE = 1235;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );

        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ) {
            if ( !Settings.canDrawOverlays( this ) ) {
                Intent intent = new Intent( Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse( "package:" + getPackageName() ) );
                startActivityForResult( intent, OVERLAY_PERMISSION_REQ_CODE );
            }
        }

        mReactRootView = new ReactRootView( this );
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication( getApplication() )
                .addPackage( new MainReactPackage() )
                .addPackage(new CodePush("_Sq6jEGNltXf7nMo71djSh2fJHrFH1iYttmSz", getApplicationContext(), BuildConfig.DEBUG))
                .setUseDeveloperSupport( BuildConfig.DEBUG )
                .setInitialLifecycleState( LifecycleState.RESUMED )
                .setJSBundleFile(CodePush.getJSBundleFile("CodePush/MyRNApp2/index2.android.bundle"))
                .build();

        mReactRootView.startReactApplication( mReactInstanceManager, "codepush2apps", null );

        setContentView( mReactRootView );
    }
}
