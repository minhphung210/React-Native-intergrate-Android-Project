package com.example.admin.androidnormal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.shell.MainReactPackage;

import java.util.Arrays;

public class MyReactActivity extends AppCompatActivity implements DefaultHardwareBackBtnHandler,ViewInterface
{
    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
//               setContentView(R.layout.activity_my_react);

               mReactRootView = new ReactRootView(this);
               mReactInstanceManager = ReactInstanceManager.builder()
                       .setApplication(getApplication())
                       .setBundleAssetName("index.android.bundle")
                       .setJSMainModulePath("index")
//                       .addPackage(new MainReactPackage())
                       .addPackages(Arrays.<ReactPackage>asList(
                               new MainReactPackage(),
                               new NavigatePackage(this)
                       ))
                       .setUseDeveloperSupport(BuildConfig.DEBUG)
                       .setInitialLifecycleState(LifecycleState.RESUMED)
                       .build();
               /*
               The string here (e.g. "MyReactNativeApp") has to match
               the string in AppRegistry.registerComponent() in index.js
               */
        mReactRootView.startReactApplication(mReactInstanceManager, "MyReactNativeApp", null);
        setContentView(mReactRootView);
    }


    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostPause(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostResume(this, this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostDestroy(this);
        }
        if (mReactRootView != null) {
            mReactRootView.unmountReactApplication();
        }
    }

    @Override
    public void onBackPressed() {
        if (mReactInstanceManager != null) {
            mReactInstanceManager.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_MENU && mReactInstanceManager != null ){
          mReactInstanceManager.showDevOptionsDialog();
          return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public void clickBack() {
        finish();
    }
}
