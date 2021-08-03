package com.konopelko.sandboxandroid.data.api.entity.response

import android.os.Parcel
import android.os.Parcelable

data class NewsResponse(
    val articles: List<Article>
) {
    data class Article(
        val source: ArticleSource,
        val author: String,
        val title: String,
        val description: String,
        val url: String,
        val urlToImage: String,
        val publishedAt: String,
        val content: String
    ) : Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readParcelable<ArticleSource>(ArticleSource::class.java.classLoader)!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!
        ) {
        }

        data class ArticleSource(
            val id: String?,
            val name: String
        ) : Parcelable {
            constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString()!!
            ) {
            }

            override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(id)
                parcel.writeString(name)
            }

            override fun describeContents(): Int {
                return 0
            }

            companion object CREATOR : Parcelable.Creator<ArticleSource> {
                override fun createFromParcel(parcel: Parcel): ArticleSource {
                    return ArticleSource(parcel)
                }

                override fun newArray(size: Int): Array<ArticleSource?> {
                    return arrayOfNulls(size)
                }
            }
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(author)
            parcel.writeString(title)
            parcel.writeString(description)
            parcel.writeString(url)
            parcel.writeString(urlToImage)
            parcel.writeString(publishedAt)
            parcel.writeString(content)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Article> {
            override fun createFromParcel(parcel: Parcel): Article {
                return Article(parcel)
            }

            override fun newArray(size: Int): Array<Article?> {
                return arrayOfNulls(size)
            }
        }
    }
}
