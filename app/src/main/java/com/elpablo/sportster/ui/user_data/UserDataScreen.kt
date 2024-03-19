package com.elpablo.sportster.ui.user_data

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elpablo.sportster.R
import com.elpablo.sportster.core.components.SportsterButton
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

        SportsterTitleOnlyText(modifier = modifier, title = stringResource(id = R.string.userdata_screen_title))

        SelectGenderMenu(
            modifier = Modifier.padding(horizontal = 80.dp),
            title = stringResource(id = R.string.userdata_screen_gender_field),
            value = state.gender,
            options = listOf(GenderType.MALE, GenderType.FEMALE),
            onClick = { selected -> onEvent(UserDataEvent.OnSelectGender(value = selected)) }
        )

        SelectHeightMenu(
            modifier = Modifier.padding(horizontal = 80.dp),
            title = stringResource(id = R.string.userdata_screen_height_field),
            suffix = { Text(text = stringResource(id = R.string.userdata_screen_height_value)) },
            value = state.height,
            options = (50..250).toList(),
            onClick = { selected -> onEvent(UserDataEvent.OnSelectHeight(value = selected)) }
        )

        SelectWeightMenu(
            modifier = Modifier.padding(horizontal = 80.dp),
            title = stringResource(id = R.string.userdata_screen_weight_field),
            suffix = { Text(text = stringResource(id = R.string.userdata_screen_weight_value)) },
            value = state.weight,
            options = (20..150).toList(),
            onClick = { selected -> onEvent(UserDataEvent.OnSelectWeight(value = selected)) }
        )
        Spacer(modifier = Modifier.weight(1f))
        SportsterButton(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.userdata_screen_button),
            onClick = navigateToMainScreen
        )
    }
}

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
private fun PreviewUserData() {
    SportsterTheme {
        UserDataScreen(modifier = Modifier, state = UserDataViewState(), onEvent = {  }, navigateToMainScreen = {  })
    }
}