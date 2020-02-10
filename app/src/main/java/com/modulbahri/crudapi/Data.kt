package com.modulbahri.crudapi

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Data (
    var nama: String ?="",
    var nohp: String ?="",
    var alamat: String ?="",
    var email: String ?="",
    var gambar: String ?="",
    var randomid: String ?=""

): Parcelable