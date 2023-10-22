package com.msd5.pushpeers.utils

import android.graphics.Color
import android.text.Selection
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.textfield.TextInputEditText

fun View.makeGone() {
    this.visibility = View.GONE
}

fun View.makeVisible() {
    this.visibility = View.VISIBLE
}

fun View.makeInvisible() {
    this.visibility = View.INVISIBLE
}

fun TextInputEditText.disableEditText() {
    this.isFocusableInTouchMode = false
    this.isEnabled = false
}

fun TextInputEditText.enableEditText() {
    this.isFocusableInTouchMode = true
    this.isEnabled = true
}

fun TextInputEditText.isLimitedValue(limit: Int): Boolean {
    return this.text.toString().toInt() <= limit
}

@BindingAdapter("is_selected")
fun setSelected(view: View, selected: Boolean) {
    view.isSelected = selected
}

fun EditText.hasEmptyValue(): Boolean {
    return this.text.toString().isEmpty()
}

fun EditText.getTx(): String {
    return this.text.toString()
}

fun Group.setAllOnClickListener(listener: View.OnClickListener?) {
    referencedIds.forEach { id ->
        rootView.findViewById<View>(id).setOnClickListener(listener)
    }
}

 fun EditText.enableEditText() {
    isFocusableInTouchMode = true
    isFocusable = true
    isEnabled = true
}

 fun EditText.disableEditText() {
    isFocusableInTouchMode = false
    isFocusable = false
    isEnabled = false
}

fun ImageView.circleImage(url:String){
    Glide.with(this).load(url).circleCrop().into(this)
}
fun ImageView.roundImage(url:String){
    Glide.with(this).load(url).circleCrop().centerCrop()
        .apply(RequestOptions.bitmapTransform(RoundedCorners(20))).into(this)
}
fun ImageView.roundImage(url:Int){
    Glide.with(this).load(url).centerCrop()
        .apply(RequestOptions.bitmapTransform(RoundedCorners(20))).into(this)
}

fun TextView.makeLinks(vararg links: Pair<String, View.OnClickListener>) {
    val spannableString = SpannableString(this.text)
    for (link in links) {
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                Selection.setSelection((view as TextView).text as Spannable, 0)
                view.invalidate()
                link.second.onClick(view)
            }
        }
        val startIndexOfLink = this.text.toString().indexOf(link.first)
        spannableString.setSpan(
            clickableSpan, startIndexOfLink, startIndexOfLink + link.first.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            ForegroundColorSpan(Color.parseColor("#46C2CC")),
            startIndexOfLink,
            startIndexOfLink + link.first.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }
    this.movementMethod =
        LinkMovementMethod.getInstance() // without LinkMovementMethod, link can not click
    this.setText(spannableString, TextView.BufferType.SPANNABLE)
}
fun CheckBox.makeLinks(vararg links: Pair<String, View.OnClickListener>) {
    val spannableString = SpannableString(this.text)
    for (link in links) {
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                Selection.setSelection((view as TextView).text as Spannable, 0)
                view.invalidate()
                link.second.onClick(view)
            }
        }
        val startIndexOfLink = this.text.toString().indexOf(link.first)
        spannableString.setSpan(
            clickableSpan, startIndexOfLink, startIndexOfLink + link.first.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            ForegroundColorSpan(Color.parseColor("#46C2CC")),
            startIndexOfLink,
            startIndexOfLink + link.first.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }
    this.movementMethod =
        LinkMovementMethod.getInstance() // without LinkMovementMethod, link can not click
    this.setText(spannableString, TextView.BufferType.SPANNABLE)
}
