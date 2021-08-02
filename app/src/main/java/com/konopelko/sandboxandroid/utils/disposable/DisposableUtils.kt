package com.konopelko.sandboxandroid.utils.disposable

import io.reactivex.rxjava3.disposables.Disposable

fun Disposable.addToSubscriptions(subscriptions: MutableList<Disposable>) {
    subscriptions.add(this)
}