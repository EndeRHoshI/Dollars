package com.hoshi.dollars

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.hoshi.dollars.databinding.ActivityMainBinding
import com.tencent.imsdk.v2.V2TIMCallback
import com.tencent.qcloud.tuicore.TUILogin

/**
 * Created by lv.qx on 2022/1/19
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.login.setOnClickListener {
            val userId = "496985305"
            val userSig = GenerateTestUserSig.genTestUserSig(userId)
            // 在用户 UI 点击登录的时候登录 UI 组件：
            TUILogin.login(
                userId,
                userSig,
                object : V2TIMCallback {
                    override fun onError(code: Int, desc: String) {
                        Log.d("hoshiTest", "code = $code, desc = $desc")
                    }
                    override fun onSuccess() {
                        Log.d("hoshiTest", "login success")
                        startActivity(Intent(this@MainActivity, ChatActivity::class.java))
                    }
                }
            )
        }
    }

}