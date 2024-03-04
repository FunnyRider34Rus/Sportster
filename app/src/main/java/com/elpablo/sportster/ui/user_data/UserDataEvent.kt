package com.elpablo.sportster.ui.user_data

sealed class UserDataEvent {
    class OnSelectGender(val value: GenderType) : UserDataEvent()
    class OnSelectHeight(val value: Int) : UserDataEvent()
    class OnSelectWeight(val value: Int) : UserDataEvent()
}