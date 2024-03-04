package com.elpablo.sportster.ui.user_data

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elpablo.sportster.core.components.SportsterDropdownMenu
import com.elpablo.sportster.core.components.SportsterTitleOnlyText
import com.elpablo.sportster.core.theme.SportsterTheme
import com.elpablo.sportster.ui.user_data.components.SelectGenderMenu
import com.elpablo.sportster.ui.user_data.components.SelectHeightMenu
import com.elpablo.sportster.ui.user_data.components.SelectWeightMenu

@Composable
fun UserDataScreen(
    modifier: Modifier,
    state: UserDataViewState,
    onEvent: (UserDataEvent) -> Unit,
    navigateToMainScreen: () -> Unit
) {

    Column(modifier = modifier
        .fillMaxSize()
        .padding(32.dp)
    ) {

        SportsterTitleOnlyText(modifier = modifier, title = "Ваши данные")

        SelectGenderMenu(
            modifier = Modifier.padding(horizontal = 64.dp),
            title = "Пол",
            value = state.gender,
            options = listOf(GenderType.MALE, GenderType.FEMALE),
            onClick = { selected -> onEvent(UserDataEvent.OnSelectGender(value = selected)) }
        )

        SelectHeightMenu(
            modifier = Modifier.padding(horizontal = 64.dp),
            title = "Рост",
            suffix = { Text(text = "см") },
            value = state.height,
            options = (50..250).toList(),
            onClick = { selected -> onEvent(UserDataEvent.OnSelectHeight(value = selected)) }
        )

        SelectWeightMenu(
            modifier = Modifier.padding(horizontal = 64.dp),
            title = "Вес",
            suffix = { Text(text = "кг") },
            value = state.weight,
            options = (20..150).toList(),
            onClick = { selected -> onEvent(UserDataEvent.OnSelectWeight(value = selected)) }
        )
    }
}

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun PreviewUserData() {
    SportsterTheme {
        UserDataScreen(modifier = Modifier, state = UserDataViewState(), onEvent = {  }, navigateToMainScreen = {  })
    }
}