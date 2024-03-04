package com.elpablo.sportster.ui.user_data

data class UserDataViewState(
    val gender: GenderType = GenderType.MALE,
    val height: Int = 170,
    val weight: Int = 60
)

enum class GenderType(val type: String) {
    MALE("Муж"), FEMALE("Жен")
}