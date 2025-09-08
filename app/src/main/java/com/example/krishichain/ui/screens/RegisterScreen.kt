package com.example.krishichain.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.krishichain.navigation.NavRoutes
import com.example.krishichain.R

@Composable
fun RegisterScreen(navController: NavController) {
    var selectedRole by remember { mutableStateOf("") }
    val roles = listOf(
        stringResource(R.string.role_farmer),
        stringResource(R.string.role_distributor),
        stringResource(R.string.role_retailer),
        stringResource(R.string.role_consumer)
    )
    var fieldValue by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(stringResource(R.string.register_title), style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        roles.forEach { role ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                RadioButton(
                    selected = selectedRole == role,
                    onClick = { selectedRole = role }
                )
                Text(role)
            }
        }
        Spacer(Modifier.height(16.dp))
        if (selectedRole.isNotBlank()) {
            val label = when (selectedRole) {
                stringResource(R.string.role_farmer) -> stringResource(R.string.farmer_card_number)
                stringResource(R.string.role_distributor) -> stringResource(R.string.gstin)
                stringResource(R.string.role_retailer) -> stringResource(R.string.shop_license)
                else -> stringResource(R.string.phone_google_id)
            }
            OutlinedTextField(
                value = fieldValue,
                onValueChange = { fieldValue = it },
                label = { Text(label) },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                if (selectedRole.isBlank() || fieldValue.isBlank()) {
                    error = stringResource(R.string.error_empty_field)
                } else {
                    // Save user profile to DB (stub)
                    when (selectedRole) {
                        stringResource(R.string.role_farmer) -> navController.navigate(NavRoutes.FarmerDashboard)
                        stringResource(R.string.role_distributor) -> navController.navigate(NavRoutes.DistributorDashboard)
                        stringResource(R.string.role_retailer) -> navController.navigate(NavRoutes.RetailerDashboard)
                        else -> navController.navigate(NavRoutes.ConsumerDashboard)
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.register))
        }
        if (error.isNotBlank()) {
            Spacer(Modifier.height(8.dp))
            Text(error, color = MaterialTheme.colorScheme.error)
        }
    }
}