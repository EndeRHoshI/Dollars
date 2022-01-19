package com.hoshi.dollars

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.hoshi.dollars.const.CommonConst
import com.tencent.qcloud.tuicore.TUILogin

/**
 * Created by lv.qx on 2022/1/19
 */
class HApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        TUILogin.init(this, CommonConst.SDK_APP_ID, null, null)
    }

}