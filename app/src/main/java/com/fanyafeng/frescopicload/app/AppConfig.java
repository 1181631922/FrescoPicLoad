package com.fanyafeng.frescopicload.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.fanyafeng.frescopicload.util.frscoutil.FrescoConfig;

/**
 * Author： fanyafeng
 * Data： 16/7/9 11:14
 * Email: fanyafeng@live.cn
 */
public class AppConfig extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this, FrescoConfig.getsImagePipelineConfig(this));
    }
}
