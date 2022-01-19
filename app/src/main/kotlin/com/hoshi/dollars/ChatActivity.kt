package com.hoshi.dollars

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hoshi.dollars.databinding.ActivityChatBinding
import com.tencent.qcloud.tuikit.tuicontact.ui.pages.TUIContactFragment
import com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIConversationFragment

/**
 * Created by lv.qx on 2022/1/19
 */
class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityChatBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val fragments = listOf(
            TUIConversationFragment(), // tuiconversation 组件提供的会话界面
            TUIContactFragment() // tuicontact 组件提供的联系人界面
        )
        binding.viewPager.offscreenPageLimit = 2
        binding.viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = fragments.size
            override fun createFragment(position: Int) = fragments.getOrNull(position) ?: Fragment()
        }
        binding.viewPager.setCurrentItem(0, false)

    }

}