package com.aplikasi.pantailampung

import android.os.Parcel
import android.os.Parcelable


data class Pantai(
    val nama: String,
    val deskripsi: String,
    val foto: Int,
    val detailNama : String,
    val detailFoto: Int,
    val detailDesk: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nama)
        parcel.writeString(deskripsi)
        parcel.writeInt(foto)
        parcel.writeString(detailNama)
        parcel.writeInt(detailFoto)
        parcel.writeString(detailDesk)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pantai> {
        override fun createFromParcel(parcel: Parcel): Pantai {
            return Pantai(parcel)
        }

        override fun newArray(size: Int): Array<Pantai?> {
            return arrayOfNulls(size)
        }
    }
}

