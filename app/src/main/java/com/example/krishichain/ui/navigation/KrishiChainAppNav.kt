package com.example.krishichain

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.krishichain.navigation.NavRoutes
import com.example.krishichain.ui.screens.*

@Composable
fun KrishiChainAppNav() {
    val nav = rememberNavController()
    NavHost(nav, startDestination = NavRoutes.Launch) {
        listOf(
            NavRoutes.Launch to { LaunchScreen(nav) },
            NavRoutes.Login to { LoginScreen(nav) },
            NavRoutes.Register to { RegisterScreen(nav) },
            NavRoutes.RoleSelect to { RoleSelectScreen(nav) },
            NavRoutes.FarmerDashboard to { FarmerDashboardScreen(nav) },
            NavRoutes.CreateBatch to { CreateBatchScreen(nav) },
            NavRoutes.BatchHistory to { BatchHistoryScreen(nav) },
            NavRoutes.DistributorDashboard to { DistributorDashboardScreen(nav) },
            NavRoutes.QRScanner to { QRScannerScreen(nav) },
            NavRoutes.TransferOwnership to { TransferOwnershipScreen(nav) },
            NavRoutes.RetailerDashboard to { RetailerDashboardScreen(nav) },
            NavRoutes.UpdatePrice to { UpdatePriceScreen(nav) },
            NavRoutes.ConsumerDashboard to { ConsumerDashboardScreen(nav) },
            NavRoutes.Feedback to { FeedbackScreen(nav) }
        ).forEach { (route, screen) -> composable(route) { screen() } }

        composable("${NavRoutes.BatchDetail}/{batchId}",
            listOf(navArgument("batchId") { type = NavType.StringType })
        ) {
            BatchDetailScreen(nav, it.arguments?.getString("batchId") ?: "")
        }
    }
}
