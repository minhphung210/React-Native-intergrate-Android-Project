package com.example.admin.androidnormal;

import android.app.Activity;
import android.widget.Toast;

import com.facebook.react.ReactApplication;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class NavigateModule extends ReactContextBaseJavaModule {
    private static final String LENGTH_SHORT = "LENGTH_SHORT";
    private  static final String LENGTH_LONG = "LENGTH_LONG";
    private ViewInterface viewInterface;
    // constructor
    public  NavigateModule(ReactApplicationContext context,ViewInterface viewInterface){
        super(context);
        this.viewInterface = viewInterface;
    }

    @Override
    public String getName() {
        return "NavigateModule";
    }

//    @Nullable
//    @Override
//    public Map<String, Object> getConstants() {
//        final  Map<String, Object> constants = new HashMap<>();
//        constants.put("PI", "3.14" );
//        constants.put(LENGTH_SHORT, Toast.LENGTH_SHORT);
//        constants.put(LENGTH_LONG, Toast.LENGTH_LONG);
//        return constants;
//    }

    @ReactMethod
    public void navigate (){
        Toast.makeText(getReactApplicationContext(), "Show Toast" , Toast.LENGTH_LONG).show();
        viewInterface.clickBack();
    }

}
