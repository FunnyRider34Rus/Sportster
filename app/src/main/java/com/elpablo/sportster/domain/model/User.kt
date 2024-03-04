package com.elpablo.sportster.domain.model

import com.elpablo.sportster.ui.user_data.GenderType

data class User(
    val uid: String? = null,
    val displayName: String? = null,
    val photoURL: String? = null,
    val gender: GenderType? = GenderType.MALE
)
