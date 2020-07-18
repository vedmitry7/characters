package com.vedmitryapps.characters.presentation.support

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.vedmitryapps.characters.R
import com.vedmitryapps.characters.network.response.Character
import com.vedmitryapps.characters.base.adapter.BaseRecyclerAdapter
import com.vedmitryapps.characters.base.adapter.BaseViewHolder

class CharacterAdapter : BaseRecyclerAdapter<Character, CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(items[position])
    }
}

class CharacterViewHolder(itemView: View) : BaseViewHolder<Character>(itemView) {

    private val name: TextView? = itemView.findViewById(R.id.text_view_name_CVH)
    private val image: SimpleDraweeView? = itemView.findViewById(R.id.text_view_image_CVH)

    override fun initUI() {
        name?.text = item.name
        image?.setImageURI(item.image)
    }

}