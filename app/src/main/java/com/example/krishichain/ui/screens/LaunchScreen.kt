package com.example.krishichain.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.krishichain.R
import com.example.krishichain.navigation.NavRoutes

@Composable
fun LaunchScreen(navController: NavController) {
    var selectedRole by remember { mutableStateOf("") }
    val roles = listOf(
        stringResource(R.string.role_farmer),
        stringResource(R.string.role_distributor),
        stringResource(R.string.role_retailer),
        stringResource(R.string.role_consumer)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(32.dp))
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier.size(96.dp)
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.app_intro),
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(Modifier.height(16.dp))
        Column {
            Text(stringResource(R.string.benefits_title), style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(8.dp))
            Text("• " + stringResource(R.string.benefit_1))
            Text("• " + stringResource(R.string.benefit_2))
            Text("• " + stringResource(R.string.benefit_3))
            Text("• " + stringResource(R.string.benefit_4))
        }
        Spacer(Modifier.height(24.dp))
        Button(
            onClick = { navController.navigate(NavRoutes.Login) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.login_register))
        }
        Spacer(Modifier.height(24.dp))
        Text(stringResource(R.string.select_role), style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            roles.forEach { role ->
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .selectable(
                            selected = selectedRole == role,
                            onClick = { selectedRole = role }
                        ),
                    colors = CardDefaults.cardColors(
                        containerColor = if (selectedRole == role) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(role)
                    }
                }
            }
        }
    }
}