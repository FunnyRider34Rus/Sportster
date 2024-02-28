package com.elpablo.sportster.ui.permissions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elpablo.sportster.R
import com.elpablo.sportster.core.theme.SportsterTheme

@Composable
fun PermissionsScreen(
    modifier: Modifier = Modifier,
    navigateToPreviousScreen: () -> Unit,
    navigateToNextScreen: () -> Unit,
    grantPermissions: () -> Unit
) {
   Column(
       modifier = modifier
           .fillMaxSize()
           .padding(32.dp)
   ) {
       Row(
           modifier = Modifier.fillMaxWidth(),
           verticalAlignment = Alignment.CenterVertically
       ) {
           Icon(
               imageVector = Icons.AutoMirrored.Filled.ArrowBack,
               contentDescription = "Назад",
               modifier = Modifier
                   .size(32.dp)
                   .clickable { navigateToPreviousScreen.invoke() }
           )
           Text(
               text = stringResource(id = R.string.permissions_screen_title),
               modifier = Modifier.padding(horizontal = 16.dp),
               style = MaterialTheme.typography.titleLarge
               )
       }
       HorizontalDivider(modifier = Modifier
           .fillMaxWidth(0.8f)
           .padding(vertical = 16.dp)
           .align(Alignment.CenterHorizontally)
       )
       Spacer(modifier = Modifier.weight(1f))
       Text(
           text = stringResource(id = R.string.permissions_screen_body),
           style = MaterialTheme.typography.bodyLarge
       )
       Text(
           text = stringResource(id = R.string.permissions_screen_description),
           modifier = Modifier.padding(top = 16.dp),
           color = Color.Gray,
           style = MaterialTheme.typography.labelMedium
           )
       Spacer(modifier = Modifier.weight(1f))
       Button(
           onClick = navigateToNextScreen,
           modifier = Modifier
               .fillMaxWidth(0.6f)
               .align(Alignment.CenterHorizontally)
       ) {
           Text(text = stringResource(id = R.string.permissiom_screen_button))
       }
   }
}

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun PreviewPermissionsScreen() {
    SportsterTheme {
        PermissionsScreen(
            navigateToPreviousScreen = {  },
            navigateToNextScreen = {  },
            grantPermissions = {  })
    }
}