package com.example.krishichain

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.krishichain.navigation.NavRoutes
import com.example.krishichain.ui.screens.*

@Composable
fun KrishiChainAppNav() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = NavRoutes.Launch) {
        composable(NavRoutes.Launch) { LaunchScreen(navController) }
        composable(NavRoutes.Login) { LoginScreen(navController) }
        composable(NavRoutes.Register) { RegisterScreen(navController) }
        composable(NavRoutes.RoleSelect) { RoleSelectScreen(navController) }
        composable(NavRoutes.FarmerDashboard) { FarmerDashboardScreen(navController) }
        composable(NavRoutes.CreateBatch) { CreateBatchScreen(navController) }
        composable("${NavRoutes.BatchDetail}/{batchId}",
            arguments = listOf(navArgument("batchId") { type = NavType.StringType })
        ) { backStackEntry ->
            val batchId = backStackEntry.arguments?.getString("batchId") ?: ""
            BatchDetailScreen(navController, batchId)
        }
        composable(NavRoutes.BatchHistory) { BatchHistoryScreen(navController) }
        composable(NavRoutes.DistributorDashboard) { DistributorDashboardScreen(navController) }
        composable(NavRoutes.QRScanner) { QRScannerScreen(navController) }
        composable(NavRoutes.TransferOwnership) { TransferOwnershipScreen(navController) }
        composable(NavRoutes.RetailerDashboard) { RetailerDashboardScreen(navController) }
        composable(NavRoutes.UpdatePrice) { UpdatePriceScreen(navController) }
        composable(NavRoutes.ConsumerDashboard) { ConsumerDashboardScreen(navController) }
        composable(NavRoutes.Feedback) { FeedbackScreen(navController) }
    }
}