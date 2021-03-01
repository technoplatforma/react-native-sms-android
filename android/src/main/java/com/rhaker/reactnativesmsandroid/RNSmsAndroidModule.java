package com.rhaker.reactnativesmsandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Telephony;
import android.util.Log;

import java.lang.String;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNSmsAndroidModule extends ReactContextBaseJavaModule {

    private static final String TAG = RNSmsAndroidModule.class.getSimpleName();

    private ReactApplicationContext reactContext;

    // set the activity - pulled in from Main
    public RNSmsAndroidModule(ReactApplicationContext reactContext) {
      super(reactContext);
      this.reactContext = reactContext;
    }

    @Override
    public String getName() {
      return "SmsAndroid";
    }

    @ReactMethod
    public void sms(String phoneNumberString, String body, final Promise promise) {

            // launch default sms package, user hits send
            Intent sendIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + phoneNumberString.trim()));
            sendIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            if (body != null) {
                sendIntent.putExtra("sms_body", body);
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                String defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(getCurrentActivity());
                if (defaultSmsPackageName != null) {
                    sendIntent.setPackage(defaultSmsPackageName);
                }
            }

            try {
                this.reactContext.startActivity(sendIntent);
                promise.resolve(true);
            }

            catch (Exception e) {
                promise.reject(false)
            }

    }
}
