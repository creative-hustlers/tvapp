package com.example.tvapp


import com.google.gson.annotations.SerializedName

data class Demo(
    @SerializedName("android_tablet_url")
    val androidTabletUrl: String?,
    @SerializedName("android_tv_url")
    val androidTvUrl: String?,
    @SerializedName("android_url")
    val androidUrl: String?,
    @SerializedName("apple_ipad_url")
    val appleIpadUrl: String?,
    @SerializedName("apple_tv_url")
    val appleTvUrl: String?,
    @SerializedName("iphone_url")
    val iphoneUrl: String?,
    @SerializedName("lg_tv_url")
    val lgTvUrl: String?,
    @SerializedName("roku_tv_url")
    val rokuTvUrl: String?
)