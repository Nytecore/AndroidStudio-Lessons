package com.example.landmarkbook

import android.os.Parcel
import android.os.Parcelable

data class Landmark(val name : String , val country : String , val image : Int) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun describeContents(): Int = 0

    override fun writeToParcel(p0: Parcel, p1: Int) {
        p0.writeString(name)
        p0.writeString(country)
        p0.writeInt(image)
    }

    companion object CREATOR : Parcelable.Creator<Landmark> {
        override fun createFromParcel(parcel: Parcel): Landmark {
            return Landmark(parcel)
        }

        override fun newArray(size: Int): Array<Landmark?> {
            return arrayOfNulls(size)
        }
    }
}